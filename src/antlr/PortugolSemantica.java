package antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.PortugolParser.ParametroContext;
import application.Chave;
import application.Constantes;
import application.Info;

public class PortugolSemantica extends PortugolBaseListener {

	private String output = "";
	private int escopo = 0;

	@Override
	public void enterDeclarVar(PortugolParser.DeclarVarContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			PortugolParser.tabelaSimbolos.put(new Chave(no.getText(), escopo),
					new Info(ctx.tipo().t, Constantes.VARIAVEL));
		}
	}

	@Override
	public void enterDeclarConst(PortugolParser.DeclarConstContext ctx) {
		PortugolParser.tabelaSimbolos.put(new Chave(ctx.atribuicao().ID()
				.getText(), escopo), new Info(ctx.tipo().t,
				Constantes.CONSTANTE));
	}

	@Override
	public void enterFuncPrincipal(PortugolParser.FuncPrincipalContext ctx) {
		escopo += 1;
		PortugolParser.tabelaSimbolos.put(new Chave("principal", escopo),
				new Info(Constantes.INTEIRO, Constantes.FUNCAO_PRINCIPAL));
	}

	@Override
	public void enterDeclarFunc(PortugolParser.DeclarFuncContext ctx) {
		escopo += 1;
		PortugolParser.tabelaSimbolos.put(
				new Chave(ctx.ID().getText(), escopo), new Info(ctx.tipo().t,
						Constantes.FUNCAO));

		for (ParametroContext parametro : ctx.parametro()) {
			PortugolParser.tabelaSimbolos.put(new Chave(parametro.ID()
					.getText(), escopo), new Info(parametro.tipo().t,
					Constantes.PARAMETRO));
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

}
