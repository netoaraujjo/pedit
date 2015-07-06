package compiler;

public class Chave {
	private String id;
	private int escopo;

	public Chave(String id, int escopo) {
		this.id = id;
		this.escopo = escopo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEscopo() {
		return escopo;
	}

	public void setEscopo(int escopo) {
		this.escopo = escopo;
	}

}
