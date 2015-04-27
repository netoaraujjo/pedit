programa exemplo;

	inteiro: numero;

	inteiro fatorial (inteiro fat){
		se (fat > 1){
			retorno (fat * fatorial(fat - 1));
		} senao {
			retorno (1);
		}
		retorno (1);
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
		//escrever ("Fatorial de N. Digite o número:");
		ler (numero);
		enquanto (i < 100) {
			escrever(i);
			i = i +1;
		}
		x = resultado(fatorial(numero));
		retorno (1);
	}