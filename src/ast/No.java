package ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class No {

	private HashMap<String, String> atributos;

	private ArrayList<No> filhos;
	private No parent;

	public No(String id) {
		filhos = new ArrayList<>();
		this.atributos = new HashMap<>();
		this.atributos.put("id", id);

	}

	public void setParent(No n) {
		this.parent = n;
	}

	public void addFilho(No n) {
		n.setParent(this);
		this.filhos.add(n);
	}

	public No getParent() {
		return this.parent;
	}

	public ArrayList<No> getFilhos() {
		return this.filhos;
	}

	public void setAtributo(String att, String valor) {
		this.atributos.put(att, valor);
	}

	@Override
	public String toString() {
		return this.atributos.get("id");
	}

	public String getAtributo(String key) {
		return this.atributos.get(key);
	}

	public String stringfy() {
		StringBuilder sb = new StringBuilder();
		stringfy("", true, sb, 0);
		return sb.toString();
	}

	protected void stringfy(String prefix, boolean isTail, StringBuilder sb,
			int index) {
		String valor = this.getAtributo("id");
		String tipo = this.getAtributo("tipo");

		System.out.println(prefix + (isTail ? " └── " : " ├── ") + valor + "("
				+ tipo + ")");
		index = 0;
		for (Iterator<No> iterator = filhos.iterator(); iterator.hasNext();) {
			iterator.next().stringfy(prefix + (isTail ? "     " : " │   "),
					!iterator.hasNext(), sb, index++);
		}
	}

}