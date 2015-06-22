package antlr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import util.Constantes;
import antlr.PortugolParser.ComandosContext;
import antlr.PortugolParser.ExpressaoContext;
import antlr.PortugolParser.ParametroContext;

import compiler.Chave;
import compiler.GeraCodigo;
import compiler.InfoFuncao;
import compiler.InfoVariavel;

public class PortugolSemantica extends PortugolBaseListener {

	private Map<Chave, InfoVariavel> tsVar = new HashMap<Chave, InfoVariavel>();
	private Map<Chave, InfoFuncao> tsFunc = new HashMap<Chave, InfoFuncao>();
	private String output = "";
	private String erro = "";
	private int escopo = 0;
	private int endereceVar = 0;

	private ArrayList<Integer> tiposVariaveisAtribuicao = new ArrayList<Integer>();
	private ArrayList<Integer> tiposVariaveisArgumentos = new ArrayList<Integer>();

	private ArrayList<Integer> tiposVariaveisRetornos = new ArrayList<Integer>();
	private ArrayList<Integer> tiposRetornoFuncao = new ArrayList<Integer>();
	
	private GeraCodigo geraCodigo;
	
	// Construtor padrão vazio
	public PortugolSemantica() {}
	
	// Construtor recebe o nome do arquivo, que também será o nome do arquivo .j
	public PortugolSemantica(File arq) {
		geraCodigo = new GeraCodigo(arq);
	}
	
	@Override
	public void enterDeclarVar(PortugolParser.DeclarVarContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			if (!existeChaveVar(no.getText(), this.escopo)) {

				tsVar.put(new Chave(no.getText(), escopo),
						new InfoVariavel(ctx.tipo().t, Constantes.VARIAVEL,
								endereceVar, retornaValor(ctx.tipo().t)));
				endereceVar++;
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + no.getText()
						+ "\" já foi criado no escopo atual.\n";
			}
		}
	}

	@Override
	public void enterDeclarConst(PortugolParser.DeclarConstContext ctx) {
		if (ctx.atribuicao().ID() != null) {
			if (!existeChaveVar(ctx.atribuicao().ID().getText(), this.escopo)) {

				tsVar.put(new Chave(ctx.atribuicao().ID().getText(), escopo),
						new InfoVariavel(ctx.tipo().t, Constantes.CONSTANTE,
								endereceVar, "")); // Falta descobrir o valor da
													// constante
				endereceVar++;
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \""
						+ ctx.atribuicao().ID().getText()
						+ "\" já foi criado no escopo atual.\n";
			}
		} else {
			erro += "Linha " + ctx.getStart().getLine()
					+ " - Constante nao foi inicializada corretamente.\n";
		}
	}

	@Override
	public void enterFuncPrincipal(PortugolParser.FuncPrincipalContext ctx) {

		escopo = -1;

		tsFunc.put(new Chave("principal", escopo), new InfoFuncao(
				Constantes.INTEIRO, Constantes.FUNCAO_PRINCIPAL,
				new ArrayList<Integer>()));
	}

	@Override
	public void exitFuncPrincipal(PortugolParser.FuncPrincipalContext ctx) {
		List<ComandosContext> comandos = ctx.comandos();
		
		geraCodigo.abreMain(tsVar.size());
		
		if (!comandos.isEmpty()) {
			for (ComandosContext cmd : comandos) {
				if (cmd.retorna() != null) {
					verificaTipoRetorno(Constantes.INTEIRO, cmd.retorna().stop.getLine(), "principal");
				}
			}
		}
		
		if (ctx.retorna() != null) {
			verificaTipoRetorno(Constantes.INTEIRO, ctx.start.getLine(), "principal");
		}
		

		
		geraCodigo.fechaMain();
		
	}

	@Override
	public void enterDeclarFunc(PortugolParser.DeclarFuncContext ctx) {

		escopo += 1;

		ArrayList<Integer> seqParam = new ArrayList<Integer>();

		for (ParametroContext param : ctx.parametro()) {
			if (!existeChaveVar(param.ID().getText(), this.escopo)) {

				tsVar.put(new Chave(param.ID().getText(), escopo),
						new InfoVariavel(param.tipo().t, Constantes.PARAMETRO,
								endereceVar, retornaValor(param.tipo().t)));
				endereceVar++;
				seqParam.add(param.tipo().t);
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + param.ID().getText()
						+ "\" já foi criado no escopo atual.\n";
			}
		}

		if (!existeChaveFunc(ctx.ID().getText())) {
			tsFunc.put(new Chave(ctx.ID().getText(), this.escopo),
					new InfoFuncao(ctx.tipo().t, Constantes.FUNCAO, seqParam));
		} else {
			erro += "Linha " + ctx.getStart().getLine()
					+ " - Já existe uma funcao com o identificador \""
					+ ctx.ID().getText() + "\".\n";
		}
	}

	@Override
	public void exitDeclarFunc(PortugolParser.DeclarFuncContext ctx) {
		List<ComandosContext> comandos = ctx.comandos();
		
		if (!comandos.isEmpty()) {
			for (ComandosContext cmd : comandos) {
				if (cmd.retorna() != null) {
					verificaTipoRetorno(ctx.tipo().t, cmd.retorna().stop.getLine(), ctx.ID().getText());
				}
			}
		}
		
		if (ctx.retorna() != null) {
			verificaTipoRetorno(ctx.tipo().t, ctx.retorna().stop.getLine(), ctx.ID().getText());
		}
		
	}
	
	@Override
	public void enterAtribuicao(PortugolParser.AtribuicaoContext ctx) {
		if (ctx.ID() != null) {
			if (!existeChaveVar(ctx.ID().getText(), escopo)
					&& !existeChaveVar(ctx.ID().getText(), 0)) {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + ctx.ID().getText()
						+ "\" não foi criado.\n";
			}
		}
	}

	@Override
	public void enterLer(PortugolParser.LerContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			if (existeChaveVar(no.getText(), this.escopo)) {
				if (argumentoLogico(no.getText(), this.escopo)) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Identificador \"" + no.getText()
							+ "\" é do tipo logico.\n";
				}
			} else if (existeChaveVar(no.getText(), 0)) {
				if (argumentoLogico(no.getText(), 0)) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Identificador \"" + no.getText()
							+ "\" é do tipo logico.\n";
				}
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + no.getText()
						+ "\" não foi criado.\n";
			}
		}
	}

	@Override
	public void enterPara(PortugolParser.ParaContext ctx) {
		if (!existeChaveVar(ctx.ID().getText(), escopo)
				&& !existeChaveVar(ctx.ID().getText(), 0)) {
			erro += "Linha " + ctx.getStart().getLine() + " - Identificador \""
					+ ctx.ID().getText() + "\" não foi criado.\n";
		}
	}

	@Override
	public void enterExpressao(PortugolParser.ExpressaoContext ctx) {
		boolean ehArgumento = false;
		
		ArrayList<ParserRuleContext> paisExpr = getPaisExpr(ctx);
		
		for (ParserRuleContext exprCtx : paisExpr) {
			if (exprCtx instanceof PortugolParser.AtribuicaoContext && !ehArgumento) {
				setTipoVariaveisAtribuicao(ctx);
			} else if (exprCtx instanceof PortugolParser.ArgumentosContext && !ehArgumento) {
				setTipoVariaveisArgumentos(ctx);
				ehArgumento = true;
			} else if (exprCtx instanceof PortugolParser.RetornaContext && !ehArgumento) {
				setTipoVariaveisRetornos(ctx);
			}
		}

		if (ctx.ID() != null) {
			if (!existeID(ctx.ID().getText())) {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + ctx.ID().getText()
						+ "\" não foi criado.\n";
			}
		}
		
	}

	@Override
	public void enterExprLogica(PortugolParser.ExprLogicaContext ctx) {
		if (ctx.ID() != null) {
			if (!existeChaveVar(ctx.ID().getText(), escopo)
					&& !existeChaveVar(ctx.ID().getText(), 0)) {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + ctx.ID().getText()
						+ "\" não foi criado.\n";
			}
		}
	}

	@Override
	public void enterChamadaDeFunc(PortugolParser.ChamadaDeFuncContext ctx) {
		Chave chave = null;
		InfoFuncao infoFuncao = null;
		if (existeChaveFunc(ctx.ID().getText())) { // Função não existe
			Set<Chave> chaves = tsFunc.keySet();
			for (Chave key : chaves) {
				if (key != null) {
					if (key.getId().compareTo(ctx.ID().getText()) == 0) {
						chave = key;
						infoFuncao = tsFunc.get(key);
						break;
					}
				}
			}

			/* Função não está no escopo correto */
			if (chave.getEscopo() == this.escopo || this.escopo == -1) {
				if (infoFuncao.getQntdParametro() == ctx.argumentos().size()) {
					// Testar se os tipos são iguais
				} else {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Chamada da função \"" + ctx.ID().getText()
							+ "\" tem quantidade de argumentos incompatível.\n";
				}
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Impossível chamar função \"" + ctx.ID().getText()
						+ "\" no escopo atual.\n";
			}
		} else {
			erro += "Linha " + ctx.getStart().getLine() + " - A função \""
					+ ctx.ID().getText() + "\" não foi declarada.\n";
		}
	}

	@Override
	public void exitChamadaDeFunc(PortugolParser.ChamadaDeFuncContext ctx) {
		
		InfoFuncao infoFuncao = null;
		Set<Chave> chaves = tsFunc.keySet();

		for (Chave key : chaves) {
			if (key != null) {
				if (key.getId().compareTo(ctx.ID().getText()) == 0) {
					infoFuncao = tsFunc.get(key);
					break;
				}
			}
		}

		if (infoFuncao != null) {
			ArrayList<Integer> seqParam = infoFuncao.getSeqParametro();
			
			int tam = tiposVariaveisArgumentos.size();
			
			if (seqParam.size() <= tam) {
				for (int i = 0; i < seqParam.size(); i++) {
					
					tam = tiposVariaveisArgumentos.size();
					
					if (seqParam.get(i) == tiposVariaveisArgumentos.get(tam - 1)) {
						
						tiposVariaveisArgumentos.remove(tam - 1);
						
					} else {
						
						tiposVariaveisArgumentos.remove(tam - 1);
						erro += "Linha " + ctx.getStart().getLine()
								+ " - Chamada de função \""
								+ ctx.ID().getText()
								+ "\" com tipo incompatível no argumento "
								+ (i + 1) + "\n";
						
					}
				}
			}
		}
		
	}

	@Override
	public void enterComandos(PortugolParser.ComandosContext ctx) {
		if (ctx.atribuicao() != null) {
			analisaAtribuicao(ctx);
		} else if (ctx.sair() != null) {
			analisaSair(ctx);
		}
	}

	@Override
	public void exitRetorna(PortugolParser.RetornaContext ctx) {
		int tipo = tiposVariaveisRetornos.get(0);

		for (int i = 1; i < tiposVariaveisRetornos.size(); i++) {
			if (tiposVariaveisRetornos.get(i) != tipo) {
				tipo = 0;
				break;
			}
		}

		tiposRetornoFuncao.add(tipo);
		tiposVariaveisRetornos.clear();
	}

	@Override
	public void exitAtribuicao(PortugolParser.AtribuicaoContext ctx) {

		if (ctx.expressao() != null) {
			int tipoIdAtr = getTipoID(ctx.ID().getText());

			for (Integer tipo : tiposVariaveisAtribuicao) {
				if (tipo != tipoIdAtr) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Atribuição entre tipos incompatíveis.\n";
				}
			}

			tiposVariaveisAtribuicao.clear();

		}
	}

	private boolean existeChaveVar(String id, int escopo) {

		boolean existe = false;

		Set<Chave> chaves = tsVar.keySet();
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

	private boolean existeID(String id) {
		boolean existe = true;

		if (!existeChaveVar(id, escopo) && !existeChaveVar(id, 0)) {
			existe = false;
		}

		return existe;
	}

	private boolean existeChaveFunc(String id) {

		boolean existe = false;

		Set<Chave> chaves = tsFunc.keySet();
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

	private boolean argumentoLogico(String id, int escopo) {

		boolean logico = false;

		Set<Chave> chaves = tsVar.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getEscopo() == escopo && key.getId().compareTo(id) == 0
						&& tsVar.get(key).getTipo() == Constantes.LOGICO) {
					logico = true;
					break;
				}
			}
		}
		return logico;
	}

	private String retornaValor(int tipo) {
		String value = "";

		if (tipo == Constantes.INTEIRO) {
			value = "0";
		} else if (tipo == Constantes.REAL) {
			value = "0.0";
		} else if (tipo == Constantes.PALAVRA) {
			value = "";
		} else if (tipo == Constantes.LOGICO) {
			value = Constantes.FALSO;
		}

		return value;
	}

	private ArrayList<ParserRuleContext> getPaisExpr(
			PortugolParser.ExpressaoContext ctx) {

		ParserRuleContext ruleCtx = ctx.getParent();

		ArrayList<ParserRuleContext> paisExpr = new ArrayList<ParserRuleContext>();

		while (ruleCtx != null) {
			paisExpr.add(ruleCtx);
			ruleCtx = ruleCtx.getParent();
		}

		return paisExpr;
	}

	private int getTipoID(String id) {
		int tipo = 0;

		Set<Chave> chaves = tsVar.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getEscopo() == this.escopo
						&& key.getId().compareTo(id) == 0) {
					InfoVariavel info = tsVar.get(key);
					tipo = info.getTipo();
					break;
				} else if (key.getEscopo() == 0
						&& key.getId().compareTo(id) == 0) {
					InfoVariavel info = tsVar.get(key);
					tipo = info.getTipo();
					break;
				}
			}
		}

		return tipo;
	}

	private void setTipoVariaveisAtribuicao(PortugolParser.ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposVariaveisAtribuicao.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposVariaveisAtribuicao.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposVariaveisAtribuicao.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposVariaveisAtribuicao.add(getTipoID(ctx.ID().getText()));
			}
		} else if (ctx.chamadaDeFunc() != null) {

			int tipo = 0;

			if (existeChaveFunc(ctx.chamadaDeFunc().ID().getText())) { // Função
																		// não
																		// existe

				Set<Chave> chaves = tsFunc.keySet();
				for (Chave key : chaves) {
					if (key != null) {
						if (key.getId().compareTo(
								ctx.chamadaDeFunc().ID().getText()) == 0) {
							InfoFuncao infoFuncao = tsFunc.get(key);
							tipo = infoFuncao.getTipo();
							break;
						}
					}
				}
			}

			tiposVariaveisAtribuicao.add(tipo);

		}
	}

	private void setTipoVariaveisRetornos(ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposVariaveisRetornos.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposVariaveisRetornos.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposVariaveisRetornos.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposVariaveisRetornos.add(getTipoID(ctx.ID().getText()));
			}
		} else if (ctx.chamadaDeFunc() != null) {

			int tipo = 0;

			if (existeChaveFunc(ctx.chamadaDeFunc().ID().getText())) { // Função
																		// não
																		// existe

				Set<Chave> chaves = tsFunc.keySet();
				for (Chave key : chaves) {
					if (key != null) {
						if (key.getId().compareTo(
								ctx.chamadaDeFunc().ID().getText()) == 0) {
							InfoFuncao infoFuncao = tsFunc.get(key);
							tipo = infoFuncao.getTipo();
							break;
						}
					}
				}
			}

			tiposVariaveisRetornos.add(tipo);

		}
	}

	private void setTipoVariaveisArgumentos(ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposVariaveisArgumentos.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposVariaveisArgumentos.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposVariaveisArgumentos.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposVariaveisArgumentos.add(getTipoID(ctx.ID().getText()));
			}
		} else if (ctx.chamadaDeFunc() != null) {

			int tipo = 0;

			if (existeChaveFunc(ctx.chamadaDeFunc().ID().getText())) { // Função
																		// não
																		// existe

				Set<Chave> chaves = tsFunc.keySet();
				for (Chave key : chaves) {
					if (key != null) {
						if (key.getId().compareTo(
								ctx.chamadaDeFunc().ID().getText()) == 0) {
							InfoFuncao infoFuncao = tsFunc.get(key);
							tipo = infoFuncao.getTipo();
							break;
						}
					}
				}
			}

			tiposVariaveisArgumentos.add(tipo);

		}
	}

	private void analisaAtribuicao(ComandosContext ctx) {
		if (ctx.atribuicao().ID() == null) {
			erro += "Linha "
					+ ctx.start.getLine()
					+ " - Retorno da função não é atribuído a nenhum identificador.\n";
		} else {
			InfoVariavel infoVariavel = null;
			if (existeChaveVar(ctx.atribuicao().ID().getText(), this.escopo)) {
				Set<Chave> chaves = tsVar.keySet();
				for (Chave key : chaves) {
					if (key != null) {
						if (key.getId().compareTo(
								ctx.atribuicao().ID().getText()) == 0
								&& key.getEscopo() == this.escopo) {
							infoVariavel = tsVar.get(key);
							break;
						}
					}
				}
				if (infoVariavel.getCategoria() == Constantes.CONSTANTE) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - A constante \""
							+ ctx.atribuicao().ID().getText()
							+ "\" não pode ser modificada.\n";
				}
			} else if (existeChaveVar(ctx.atribuicao().ID().getText(), 0)) { // Variavel
																				// existe
				Set<Chave> chaves = tsVar.keySet();
				for (Chave key : chaves) {
					if (key != null) {
						if (key.getId().compareTo(
								ctx.atribuicao().ID().getText()) == 0
								&& key.getEscopo() == 0) {
							infoVariavel = tsVar.get(key);
							break;
						}
					}
				}
				if (infoVariavel.getCategoria() == Constantes.CONSTANTE) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - A constante \""
							+ ctx.atribuicao().ID().getText()
							+ "\" não pode ser modificada.\n";
				}
			}
		}
	}

	private void analisaSair(ComandosContext ctx) {
		boolean flag = false;
		ParserRuleContext ruleCtx = ctx.sair().getParent();

		ArrayList<ParserRuleContext> paisSair = new ArrayList<ParserRuleContext>();

		while (ruleCtx != null) {
			paisSair.add(ruleCtx);
			ruleCtx = ruleCtx.getParent();
		}

		if (!paisSair.isEmpty()) {
			for (ParserRuleContext sairCtx : paisSair) {
				if (sairCtx instanceof PortugolParser.EnquantoContext
						|| sairCtx instanceof PortugolParser.ParaContext) {
					flag = true;
					break;
				}
			}

			if (flag == false) {
				erro += "Linha "
						+ ctx.start.getLine()
						+ " - Comando \"sair\" não está dentro de um laço de repetição.\n";
			}
		}
	}

	private void verificaTipoRetorno(int tipoFunc, int linha, String idFunc) {
		if (tipoFunc != tiposRetornoFuncao.get(0)) {
			erro += "Linha " + linha
					+ " - Tipo de retorno incompatível com o tipo da função \""
					+ idFunc + "\".\n";
		}
		
		tiposRetornoFuncao.remove(0);
	}

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

}
