package compiler;

public class InfoVariavel extends Info {
	private int endereco;

	public InfoVariavel(int tipo, int categoria, int endereco) {
		super(tipo, categoria);
		this.endereco = endereco;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

}
