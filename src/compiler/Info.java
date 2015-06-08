package compiler;

public class Info {
	private int tipo;
	private int categoria;

	public Info(int tipo, int categoria) {
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
