package compiler;

public class InfoVariavel extends Info {
	private int enderecoGlobal;
	private int enderecoLocal;
	private String valor;

	public InfoVariavel(int tipo, int categoria, int enderecoGlobal, int enderecoLocal, String valor) {
		super(tipo, categoria);
		this.enderecoGlobal = enderecoGlobal;
		this.enderecoLocal = enderecoLocal;
		this.valor = valor;
	}

	public int getEnderecoGlobal() {
		return enderecoGlobal;
	}

	public void setEnderecoGlobal(int enderecoGlobal) {
		this.enderecoGlobal = enderecoGlobal;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getEnderecoLocal() {
		return enderecoLocal;
	}

	public void setEnderecoLocal(int enderecoLocal) {
		this.enderecoLocal = enderecoLocal;
	}

}
