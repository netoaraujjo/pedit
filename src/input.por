programa exemplo;

	inteiro: numero;
	constante inteiro luis = 10;

	inteiro fatorial (inteiro fat){
		se (fat > 1){
			retorno (fat * fatorial(fat - 1));
		} senao {
			retorno (1);
		}
		retorno (2);
	}

	/* lsjkdfhgsdjklfg */
	logico resultado (inteiro valor){
		escrever ("Resultado: ", valor);
		para i de 1 ate 100 passo 2 {
			escrever(i);
		}
		retorno (verdade);
	}

	inteiro principal(){
		x = -1;
		//escrever ("Fatorial de N. Digite o n�mero:");
		ler (numero);
		enquanto (i < 100) {
			escrever(i);
			i = i +1;
		}
		x = resultado(fatorial(numero));
		retorno (3);
	}