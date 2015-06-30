package compiler;

import java.util.ArrayList;

public class InfoFuncao extends Info {
	private int qntdParametro;
	private ArrayList<Integer> seqParametro;
	private ArrayList<Integer> seqEnderecosLocais;

	public InfoFuncao(int tipo, int categoria, ArrayList<Integer> seqParametro, ArrayList<Integer> seqEnderecosLocais) {
		super(tipo, categoria);
		this.seqParametro = seqParametro;
		this.seqEnderecosLocais = seqEnderecosLocais;
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

	public ArrayList<Integer> getSeqEnderecosLocais() {
		return seqEnderecosLocais;
	}

	public void setSeqEnderecosLocais(ArrayList<Integer> seqEnderecosLocais) {
		this.seqEnderecosLocais = seqEnderecosLocais;
	}

}
