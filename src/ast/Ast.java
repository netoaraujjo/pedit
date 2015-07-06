package ast;

import java.util.ArrayList;

public class Ast {

	public static No root;
	public static No currentNode;
	public static boolean bloqueado = false;

	public static ArrayList<No> posFixa = new ArrayList<>();

	public static void init(No s) {
		if (bloqueado) {
			setCurrentNode(s);
		} else {
			root = s;
			currentNode = s;
			bloqueado = true;
		}
	}

	public static void gerarPosFixa(No n) {
		if (n != null) {
			
			posFixa.add(n);
			
			if (!n.getFilhos().isEmpty()) {
				gerarPosFixa(n.getFilhos().get(1));
				gerarPosFixa(n.getFilhos().get(0));
			}
		}
	}

	public static void reinit() {
		posFixa.clear();
		bloqueado = false;
	}

	public static void addFilho(No nodeToAdd) {
		currentNode.addFilho(nodeToAdd);
	}

	public static void setCurrentNode(No n) {

		currentNode.addFilho(n);
		currentNode = n;

	}

	public static void up() {
		if (currentNode != null) {
			currentNode = currentNode.getParent();
		}
	}

	public static void print() {
		root.stringfy();
	}

}