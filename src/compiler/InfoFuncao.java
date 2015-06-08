package compiler;

import java.util.ArrayList;

public class InfoFuncao extends InfoVariavel {
	private int qntdParametro;
	private ArrayList<Integer> seqParametro;

	public InfoFuncao(int tipo, int categoria, ArrayList<Integer> seqParametro) {
		super(tipo, categoria);
		this.seqParametro = seqParametro;
		this.qntdParametro = seqParametro.size();
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

}
