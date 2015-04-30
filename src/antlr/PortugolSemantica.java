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
	public void enterAtribuicao(PortugolParser.AtribuicaoContext ctx) {
		System.out.println("ID: " + ctx.ID().getText());
		if (ctx.expressao().isEmpty()) {
			System.out.println("ATRIBUICAO: " + ctx.exprLogica().getText()
					+ "\n");
		} else {
			System.out.println("ATRIBUICAO: " + ctx.expressao().getText()
					+ "\n");
		}
	}

	@Override
	public void enterEscrever(PortugolParser.EscreverContext ctx) {
		String str = "";
		for (ArgumentosContext arg : ctx.argumentos()) {
			if (arg.getText().contains("\""))
				str += arg.getText().substring(1, arg.getText().length() - 1)
						+ "\n";
			else
				str += arg.getText().toString() + "\n";
		}
		System.out.println("ESCREVER: " + str);
	}

	@Override
	public void enterChamadaDeFunc(PortugolParser.ChamadaDeFuncContext ctx) {
		String str = "";

		System.out.println("ID: " + ctx.ID().toString());

		for (ArgumentosContext arg : ctx.argumentos()) {
			if (arg.chamadaDeFunc() != null)
				str += arg.chamadaDeFunc().getText() + "\n";
			else if (arg.expressao() != null)
				str += arg.expressao().getText() + "\n";
			else if (arg.exprLogica() != null)
				str += arg.exprLogica().getText() + "\n";
		}

		System.out.println("ARGUMENTOS: " + str);
	}

	@Override
	public void enterLer(PortugolParser.LerContext ctx) {
		String str = "";

		for (TerminalNode t : ctx.ID()) {
			str += t.getText() + "\n";
		}

		System.out.println("LER: " + str);
	}

	@Override
	public void enterRetorna(PortugolParser.RetornaContext ctx) {
		System.out.println("RETORNA: " + ctx.expressao().getText() + "\n");
	}

	@Override
	public void enterDeclarConst(PortugolParser.DeclarConstContext ctx) {
		System.out.println(ctx.getStart().getText() + " "
				+ ctx.tipo().getText() + " " + ctx.atribuicao().getText()
				+ "\n");

	}

	@Override
	public void enterComandos(PortugolParser.ComandosContext ctx) {
		String str = "";
		
		if (ctx.atribuicao() != null)
			str += ctx.atribuicao().getText() + "\n";
		else if (ctx.ler() != null)
			str += ctx.ler().getText() + "\n";
		else if (ctx.escrever() != null)
			str += ctx.escrever().getText() + "\n";
		else if (ctx.decisao() != null)
			str += ctx.decisao().getText() + "\n";
		else if (ctx.para() != null)
			str += ctx.para().getText() + "\n";
		else if (ctx.enquanto() != null)
			str += ctx.enquanto().getText() + "\n";
		else if (ctx.retorna() != null)
			str += ctx.retorna().getText() + "\n";
		
		System.out.println("COMANDOS: " + str);
	}

}
