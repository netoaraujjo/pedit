grammar Portugol;

@header{
package antlr;
}

prog: 'programa' ID ';' (declarVar | declarConst)* declarFunc* funcPrincipal;

declarVar: tipo ':' ID (',' ID)* ';' ;

tipo returns [int t]: INTEIRO {$t = 1;}
    | REAL {$t = 2;}
    | LOGICO {$t = 3;}
    | PALAVRA {$t = 4;}
    ;

atribuicao: ID '=' expressao ';'
          | ID '=' exprLogica ';'
          ;

declarConst: 'constante' tipo atribuicao ;

funcPrincipal: 'inteiro' 'principal' '(' ')' '{'
                   (declarVar | declarConst)*
                   comandos*
                   retorna
                '}'
                ;

declarFunc: tipo ID '(' (parametro (',' parametro)*)? ')' '{'
                   (declarVar | declarConst)*
                   comandos*
                   retorna
                '}'
                ;

parametro: tipo ID ;

comandos: atribuicao
        | ler
        | escrever
        | decisao
        | para
        | enquanto
        | retorna
        | sair
        ;

sair: 'sair' ';';

ler: 'ler' '(' ID (',' ID)* ')' ';';

escrever: 'escrever' '(' argumentos (',' argumentos)* ')' ';';

chamadaDeFunc: ID '(' (argumentos (',' argumentos)*)? ')' ;

argumentos: expressao
          | exprLogica
          | chamadaDeFunc
          ;

decisao: 'se' '(' exprLogica ')' '{'
             comandos*
         '}'
         (senao)?
       ;

senao: 'senao' '{'
             comandos*
         '}'
     ;

para: 'para' ID 'de' expressao 'ate' expressao ('passo' expressao)? '{'
            comandos*
      '}'
    ;

enquanto: 'enquanto' '(' exprLogica ')' '{'
            comandos*
          '}'
        ;

expressao: '-' expressao
         | expressao op = ('*' | '/') expressao
         | expressao op = ('+' | '-') expressao
         | '(' expressao ')'
         | valor = NUM_INTEIRO
         | valor = NUM_REAL
         | chamadaDeFunc
         | valor = CADEIA_DE_CARACTERES
         | ID
         ;

exprLogica: '!' exprLogica
          | '(' exprLogica ')'
          | exprLogica OPERADORES_IGUALDADES exprLogica
          | expressao a=(OPERADORES_IGUALDADES | OPERADORES_SUPERIORIDADE) expressao
          | BOOLEANO
          | ID
          ;

retorna: 'retorno' '(' expressao ')' ';';

ABRE_CHAVES: '{';
ABRE_COLCHETE: '[';
ABRE_PARENTESIS: '(';
ATE: 'ate';
BOOLEANO: 'verdade' | 'falso';
CADEIA_DE_CARACTERES: '"' .*? '"';
CONSTANTE: 'constante';
DE: 'de';
DIVIDIR: '/';
DOIS_PONTOS: ':';
ENQUANTO: 'enquanto';
ESCREVER: 'escrever';
FECHA_CHAVES: '}';
FECHA_COLCHETE: ']';
FECHA_PARENTESIS: ')';
IGUAL: '=';
SE: 'se';
SENAO: 'senao';
INTEIRO: 'inteiro';
LER: 'ler';
LOGICO: 'logico';
MULTIPLICACAO : '*';
NEGACAO: '!';
NUM_INTEIRO: [0-9]+;
NUM_REAL: [0-9]+ '.' [0-9]+;
OPERADORES_IGUALDADES: '==' | '!=';
OPERADORES_SUPERIORIDADE: '>' | '<';
PALAVRA: 'palavra';
PARA: 'para';
PASSO: 'passo';
PONTO: '.';
PONTO_E_VIRGULA: ';';
PRINCIPAL: 'principal';
PROGRAMA: 'programa';
REAL: 'real';
RETORNO: 'retorno';
SAIR: 'sair';
SOMA: '+';
SUBTRACAO: '-';
VIRGULA: ',';

COMENTARIO_DE_LINHA: '//' .*? '\n' -> skip;
COMENTARIO: '/*' .*? '*/' -> skip;
ID: [a-zA-z][a-zA-z0-9]*;
WS: [ \t\n\r] -> skip;