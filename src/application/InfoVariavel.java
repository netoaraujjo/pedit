package application;

public class InfoVariavel {
	private int tipo;
	private int categoria;

	public InfoVariavel(int tipo, int categoria) {
		this.tipo = tipo;
		this.categoria = categoria;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
