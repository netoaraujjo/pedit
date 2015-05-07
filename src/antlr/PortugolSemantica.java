package antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.PortugolParser.ParametroContext;
import application.Chave;
import application.Constantes;
import application.InfoFuncao;
import application.InfoVariavel;

public class PortugolSemantica extends PortugolBaseListener {
	private Map<Chave, InfoVariavel> tsVar = new HashMap<Chave, InfoVariavel>();
	private Map<Chave, InfoFuncao> tsFunc = new HashMap<Chave, InfoFuncao>();
	private String output = "";
	private String erro = "";
	private int escopo = 0;

	@Override
	public void enterDeclarVar(PortugolParser.DeclarVarContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			if (!existeChaveVar(no.getText(), this.escopo, tsVar)) {
				tsVar.put(new Chave(no.getText(), escopo),
						new InfoVariavel(ctx.tipo().t, Constantes.VARIAVEL));
			} else {
				erro += "Identificador " + no.getText()
						+ " ja foi criado no escopo atual.\n";
			}
		}
	}

	@Override
	public void enterDeclarConst(PortugolParser.DeclarConstContext ctx) {
		if (ctx.atribuicao().ID() != null) {
			if (!existeChaveVar(ctx.atribuicao().ID().getText(), this.escopo,
					tsVar)) {
				tsVar.put(new Chave(ctx.atribuicao().ID().getText(), escopo),
						new InfoVariavel(ctx.tipo().t, Constantes.CONSTANTE));
			} else {
				erro += "Identificador " + ctx.atribuicao().ID().getText()
						+ " ja foi criado no escopo atual.\n";
			}
		} else {
			erro += "Constante nao foi inicializada corretamente.\n";
		}
	}

	@Override
	public void enterFuncPrincipal(PortugolParser.FuncPrincipalContext ctx) {
		escopo += 1;
		tsFunc.put(new Chave("principal", escopo), new InfoFuncao(
				Constantes.INTEIRO, Constantes.FUNCAO_PRINCIPAL,
				new ArrayList<Integer>()));
	}

	@Override
	public void enterDeclarFunc(PortugolParser.DeclarFuncContext ctx) {
		escopo += 1;

		ArrayList<Integer> seqParam = new ArrayList<Integer>();

		for (ParametroContext param : ctx.parametro()) {
			tsVar.put(new Chave(param.ID().getText(), escopo),
					new InfoVariavel(param.tipo().t, Constantes.PARAMETRO));
			seqParam.add(param.tipo().t);
		}

		if (!existeChaveFunc(ctx.ID().getText(), tsFunc)) {
			tsFunc.put(new Chave(ctx.ID().getText(), this.escopo),
					new InfoFuncao(ctx.tipo().t, Constantes.FUNCAO, seqParam));
		} else {
			erro += "Ja existe uma funcao com o identificador "
					+ ctx.ID().getText();
		}
	}

	/*
	 * @Override public void enterAtribuicao(PortugolParser.AtribuicaoContext
	 * ctx) { output += "ID: " + ctx.ID().getText() + "\n";
	 * 
	 * if (ctx.expressao().isEmpty()) { output += "ATRIBUICAO: " +
	 * ctx.exprLogica().getText() + "\n"; } else { output += "ATRIBUICAO: " +
	 * ctx.expressao().getText() + "\n"; } }
	 * 
	 * @Override public void enterEscrever(PortugolParser.EscreverContext ctx) {
	 * String str = "";
	 * 
	 * for (ArgumentosContext arg : ctx.argumentos()) { if
	 * (arg.getText().contains("\"")) str += arg.getText().substring(1,
	 * arg.getText().length() - 1) + "\n"; else str += arg.getText().toString()
	 * + "\n"; }
	 * 
	 * output += "ESCREVER: " + str + "\n"; }
	 * 
	 * @Override public void
	 * enterChamadaDeFunc(PortugolParser.ChamadaDeFuncContext ctx) { String str
	 * = "";
	 * 
	 * output += "ID: " + ctx.ID().toString() + "\n";
	 * 
	 * for (ArgumentosContext arg : ctx.argumentos()) { if (arg.chamadaDeFunc()
	 * != null) str += arg.chamadaDeFunc().getText() + "\n"; else if
	 * (arg.expressao() != null) str += arg.expressao().getText() + "\n"; else
	 * if (arg.exprLogica() != null) str += arg.exprLogica().getText() + "\n"; }
	 * 
	 * output += "ARGUMENTOS: " + str + "\n"; }
	 * 
	 * @Override public void enterLer(PortugolParser.LerContext ctx) { String
	 * str = "";
	 * 
	 * for (TerminalNode t : ctx.ID()) { str += t.getText() + "\n"; }
	 * 
	 * output += "LER: " + str + "\n"; }
	 * 
	 * @Override public void enterRetorna(PortugolParser.RetornaContext ctx) {
	 * output += "RETORNA: " + ctx.expressao().getText() + "\n"; }
	 * 
	 * @Override public void enterComandos(PortugolParser.ComandosContext ctx) {
	 * String str = "";
	 * 
	 * if (ctx.atribuicao() != null) str += ctx.atribuicao().getText() + "\n";
	 * else if (ctx.ler() != null) str += ctx.ler().getText() + "\n"; else if
	 * (ctx.escrever() != null) str += ctx.escrever().getText() + "\n"; else if
	 * (ctx.decisao() != null) str += ctx.decisao().getText() + "\n"; else if
	 * (ctx.para() != null) str += ctx.para().getText() + "\n"; else if
	 * (ctx.enquanto() != null) str += ctx.enquanto().getText() + "\n"; else if
	 * (ctx.retorna() != null) str += ctx.retorna().getText() + "\n";
	 * 
	 * output += "COMANDOS: " + str + "\n"; }
	 */

	public String getOutput() {
		return output;
	}

	public String getErro() {
		return erro;
	}

	public Map<Chave, InfoVariavel> getTsVar() {
		return tsVar;
	}

	public Map<Chave, InfoFuncao> getTsFunc() {
		return tsFunc;
	}

	public boolean existeChaveVar(String id, int escopo,
			Map<Chave, InfoVariavel> hash) {
		boolean existe = false;

		Set<Chave> chaves = hash.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getEscopo() == escopo && key.getId().compareTo(id) == 0) {
					existe = true;
					break;
				}
			}
		}

		return existe;
	}

	public boolean existeChaveFunc(String id, Map<Chave, InfoFuncao> hash) {
		boolean existe = false;

		Set<Chave> chaves = hash.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getId().compareTo(id) == 0) {
					existe = true;
					break;
				}
			}
		}

		return existe;
	}

}
