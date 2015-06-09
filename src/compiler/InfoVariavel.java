package compiler;

public class InfoVariavel extends Info {
	private int endereco;
	private String valor;

	public InfoVariavel(int tipo, int categoria, int endereco, String valor) {
		super(tipo, categoria);
		this.endereco = endereco;
		this.setValor(valor);
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
