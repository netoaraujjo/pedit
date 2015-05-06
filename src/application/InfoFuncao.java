package application;

import java.util.ArrayList;

public class InfoFuncao {
	private int tipo;
	private int categoria;
	private int qntdParametro;
	private ArrayList<Integer> seqParametro;

	public InfoFuncao(int tipo, int categoria,
			ArrayList<Integer> seqParametro) {
		this.tipo = tipo;
		this.categoria = categoria;
		this.seqParametro = seqParametro;
		this.qntdParametro = seqParametro.size();
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getQntdParametro() {
		return qntdParametro;
	}

	public void setQntdParametro(int qntdParametro) {
		this.qntdParametro = qntdParametro;
	}

	public ArrayList<Integer> getSeqParametro() {
		return seqParametro;
	}

	public void setSeqParametro(ArrayList<Integer> seqParametro) {
		this.seqParametro = seqParametro;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

}
