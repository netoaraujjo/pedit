package antlr;

import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.PortugolParser.ArgumentosContext;

public class PortugolSemantica extends PortugolBaseListener {
	@Override
	public void enterDeclarVar(PortugolParser.DeclarVarContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			PortugolParser.tabelaSimbolos.put(no.getText(), ctx.tipo().t);
		}
	}

	@Override
	public void enterEscrever(PortugolParser.EscreverContext ctx) {
		String str = "\n";
		for (ArgumentosContext arg : ctx.argumentos()) {
			str += arg.getText().toString() + "\n";
		}
		System.out.println("O que foi digitado no ESCREVER:" + str);
	}

}
