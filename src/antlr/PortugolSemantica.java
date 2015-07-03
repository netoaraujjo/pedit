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
import antlr.PortugolParser.ArgumentosContext;
import antlr.PortugolParser.ComandosContext;
import antlr.PortugolParser.ExprLogicaContext;
import antlr.PortugolParser.ExpressaoContext;
import antlr.PortugolParser.ParaContext;
import antlr.PortugolParser.ParametroContext;
import ast.Ast;
import ast.No;
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
	private int enderecoVarGlobal = 0;
	private int enderecoVarLocal = 0;

	private ArrayList<Integer> tiposVariaveisAtribuicao = new ArrayList<Integer>();
	private ArrayList<Integer> tiposVariaveisArgumentos = new ArrayList<Integer>();

	private ArrayList<Integer> tiposVariaveisRetornos = new ArrayList<Integer>();
	private ArrayList<Integer> tiposRetornoFuncao = new ArrayList<Integer>();

	private ArrayList<Integer> tiposSe = new ArrayList<Integer>();
	private ArrayList<Integer> tiposPara = new ArrayList<Integer>();
	private ArrayList<Integer> tiposEnquanto = new ArrayList<Integer>();

	private GeraCodigo geraCodigo;

	// Construtor padrão vazio
	public PortugolSemantica() {
	}

	// Construtor recebe o nome do arquivo, que também será o nome do arquivo .j
	public PortugolSemantica(File arq) {
		geraCodigo = new GeraCodigo(arq);
		geraCodigo.setGerar(true);
	}

	@Override
	public void enterDeclarVar(PortugolParser.DeclarVarContext ctx) {
		for (TerminalNode no : ctx.ID()) {
			if (!existeChaveVar(no.getText(), this.escopo)) {

				tsVar.put(new Chave(no.getText(), escopo),
						new InfoVariavel(ctx.tipo().t, Constantes.VARIAVEL,
								enderecoVarGlobal, enderecoVarLocal,
								retornaValor(ctx.tipo().t)));

				geraCodigo.abreDeclrVar(ctx.tipo().t, enderecoVarGlobal,
						enderecoVarLocal, this.escopo, no.getText());

				enderecoVarGlobal++;
				enderecoVarLocal++;
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
								enderecoVarGlobal, enderecoVarLocal, "")); // Falta
																			// descobrir
																			// o
																			// valor
																			// da
				// constante
				enderecoVarGlobal++;
				enderecoVarLocal++;
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
		enderecoVarLocal = 0;
		escopo = -1;

		tsFunc.put(new Chave("principal", escopo), new InfoFuncao(
				Constantes.INTEIRO, Constantes.FUNCAO_PRINCIPAL,
				new ArrayList<Integer>(), new ArrayList<Integer>()));

		geraCodigo.abreMain(tsVar.size());
	}

	@Override
	public void exitFuncPrincipal(PortugolParser.FuncPrincipalContext ctx) {
		List<ComandosContext> comandos = ctx.comandos();

		if (!comandos.isEmpty()) {
			for (ComandosContext cmd : comandos) {
				if (cmd.retorna() != null) {
					verificaTipoRetorno(Constantes.INTEIRO,
							cmd.retorna().stop.getLine(), "principal");
				}
			}
		}

		if (ctx.retorna() != null) {
			verificaTipoRetorno(Constantes.INTEIRO, ctx.start.getLine(),
					"principal");
		}

		geraCodigo.fechaMain();
	}

	@Override
	public void enterDeclarFunc(PortugolParser.DeclarFuncContext ctx) {
		enderecoVarLocal = 0;
		escopo += 1;

		ArrayList<Integer> seqParam = new ArrayList<Integer>();
		ArrayList<Integer> seqEndLocal = new ArrayList<Integer>();

		List<InfoVariavel> ivTemp = new ArrayList<>();

		for (ParametroContext param : ctx.parametro()) {
			if (!existeChaveVar(param.ID().getText(), this.escopo)) {

				tsVar.put(new Chave(param.ID().getText(), escopo),
						new InfoVariavel(param.tipo().t, Constantes.PARAMETRO,
								enderecoVarGlobal, enderecoVarLocal,
								retornaValor(param.tipo().t)));

				ivTemp.add(new InfoVariavel(param.tipo().t,
						Constantes.PARAMETRO, enderecoVarGlobal,
						enderecoVarLocal, retornaValor(param.tipo().t)));

				seqEndLocal.add(enderecoVarLocal);
				seqParam.add(param.tipo().t);

				enderecoVarGlobal++;
				enderecoVarLocal++;
			} else {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + param.ID().getText()
						+ "\" já foi criado no escopo atual.\n";
			}
		}

		if (!existeChaveFunc(ctx.ID().getText())) {
			tsFunc.put(new Chave(ctx.ID().getText(), this.escopo),
					new InfoFuncao(ctx.tipo().t, Constantes.FUNCAO, seqParam,
							seqEndLocal));
		} else {
			erro += "Linha " + ctx.getStart().getLine()
					+ " - Já existe uma funcao com o identificador \""
					+ ctx.ID().getText() + "\".\n";
		}

		geraCodigo.abreFuncao(ctx.tipo().t, ctx.ID().getText(), tsVar.size(),
				ivTemp);
	}

	@Override
	public void exitDeclarFunc(PortugolParser.DeclarFuncContext ctx) {
		List<ComandosContext> comandos = ctx.comandos();

		if (!comandos.isEmpty()) {
			for (ComandosContext cmd : comandos) {
				if (cmd.retorna() != null) {
					verificaTipoRetorno(ctx.tipo().t,
							cmd.retorna().stop.getLine(), ctx.ID().getText());
				}
			}
		}

		if (ctx.retorna() != null) {
			verificaTipoRetorno(ctx.tipo().t, ctx.retorna().stop.getLine(), ctx
					.ID().getText());
		}

		ExpressaoContext exp = ctx.retorna().expressao();
		if (exp.ID() != null || exp.valor != null) {
			geraCodigo.fechaFuncao();
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
				} else {
					InfoVariavel iv = getInfoVariavel(no.getText(), this.escopo);
					geraCodigo.gerarLer(iv.getTipo(), iv.getEnderecoLocal());
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
	public void enterEscrever(PortugolParser.EscreverContext ctx) {
		for (ArgumentosContext argumento : ctx.argumentos()) {
			if (argumento.expressao() != null) {
				if (argumento.expressao().CADEIA_DE_CARACTERES() != null) {
					geraCodigo.geraEscreverMensagem(argumento.expressao()
							.CADEIA_DE_CARACTERES().getText());
				} else if (argumento.expressao().NUM_INTEIRO() != null) {
					geraCodigo.geraEscreverMensagem("\""
							+ argumento.expressao().NUM_INTEIRO().getText()
							+ "\"");
				} else if (argumento.expressao().NUM_REAL() != null) {
					geraCodigo
							.geraEscreverMensagem("\""
									+ argumento.expressao().NUM_REAL()
											.getText() + "\"");
				} else if (argumento.expressao().ID() != null) {
					InfoVariavel iv = getInfoVariavel(argumento.expressao()
							.ID().getText(), this.escopo);
					if (iv != null) {
						geraCodigo.gerarEscrever(iv.getTipo(),
								iv.getEnderecoLocal());
					}
				}
			}
		}
	}

	@Override
	public void enterPara(PortugolParser.ParaContext ctx) {
		analisaPara(ctx);
	}

	@Override
	public void exitPara(PortugolParser.ParaContext ctx) {
		int tipo = tiposPara.get(0);

		for (int i = 1; i < tiposPara.size(); i++) {
			if (tiposPara.get(i) != tipo) {
				erro += "Linha "
						+ ctx.getStart().getLine()
						+ " - Expressão com tipo diferente de INTEIRO na posição "
						+ (i + 1) + "\n";
			}
		}

		tiposPara.clear();

		int passo = 1;
		if (ctx.expressao(2) != null) {
			passo = Integer.parseInt(ctx.expressao(2).NUM_INTEIRO().getText());
		}

		InfoVariavel var = getInfoVariavel(ctx.ID().getText(), this.escopo);
		geraCodigo.fecharPara(var.getEnderecoLocal(), passo);

		Ast.reinit();

	}

	@Override
	public void exitAbrirChaves(PortugolParser.AbrirChavesContext ctx) {
		Ast.gerarPosFixa(Ast.root);
		System.out.println(Ast.posFixa);

		ParaContext paraCtx = (ParaContext) ctx.getParent();
		InfoVariavel var = getInfoVariavel(paraCtx.ID().getText(), this.escopo);

		geraCodigo.abrirPara(var.getEnderecoLocal(),
				Integer.parseInt(paraCtx.expressao(0).NUM_INTEIRO().getText()),
				Integer.parseInt(paraCtx.expressao(1).NUM_INTEIRO().getText()));

		Ast.reinit();
	}

	@Override
	public void enterExpressao(PortugolParser.ExpressaoContext ctx) {
		boolean ehArgumento = false, ehComando = false;

		ArrayList<ParserRuleContext> paisExpr = getPaisExpr(ctx);

		for (ParserRuleContext exprCtx : paisExpr) {

			if (exprCtx instanceof PortugolParser.AtribuicaoContext
					&& !ehArgumento) {
				setTipoVariaveisAtribuicao(ctx);
			} else if (exprCtx instanceof PortugolParser.ArgumentosContext
					&& !ehArgumento) {
				setTipoVariaveisArgumentos(ctx);
				ehArgumento = true;
			} else if (exprCtx instanceof PortugolParser.RetornaContext
					&& !ehArgumento) {
				setTipoVariaveisRetornos(ctx);
			} else if (exprCtx instanceof PortugolParser.EnquantoContext
					&& !ehComando) {
				setTipoEnquanto(ctx);
			} else if (exprCtx instanceof PortugolParser.DecisaoContext
					&& !ehComando) {
				setTipoSe(ctx);
			} else if (exprCtx instanceof PortugolParser.ParaContext
					&& !ehComando) {
				setTipoPara(ctx);
			} else if (exprCtx instanceof PortugolParser.ComandosContext) {
				ehComando = true;
			}

		}

		if (!ehArgumento) {

			boolean ehAtribuicao = false;

			for (ParserRuleContext exprCtx : paisExpr) {
				if (exprCtx instanceof PortugolParser.AtribuicaoContext) {
					setAstExpressao(ctx);
					ehAtribuicao = true;
				} else if (exprCtx instanceof PortugolParser.DecisaoContext
						&& !ehAtribuicao) {
					setAstExpressao(ctx);
				} else if (exprCtx instanceof PortugolParser.EnquantoContext
						&& !ehAtribuicao) {
					setAstExpressao(ctx);
				}
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
	public void exitExpressao(PortugolParser.ExpressaoContext ctx) {
		ArrayList<ParserRuleContext> paisExpr = getPaisExpr(ctx);

		boolean ehAtribuicao = false;

		for (ParserRuleContext pai : paisExpr) {
			if (pai instanceof PortugolParser.AtribuicaoContext) {
				if (ctx.op != null) {
					Ast.up();
				} else if (ctx.ID() != null) {
					Ast.up();
				} else if (ctx.valor != null) {
					Ast.up();
				}

				ehAtribuicao = true;
			} else if ((pai instanceof PortugolParser.DecisaoContext || pai instanceof PortugolParser.EnquantoContext)
					&& !ehAtribuicao) {
				if (ctx.op != null) {
					Ast.up();
				} else if (ctx.ID() != null) {
					Ast.up();
				} else if (ctx.valor != null) {
					Ast.up();
				}
			}
		}

	}

	@Override
	public void exitFecharParenteses(PortugolParser.FecharParentesesContext ctx) {

		if (ctx.parent instanceof PortugolParser.DecisaoContext) {
			Ast.gerarPosFixa(Ast.root);
			System.out.println(Ast.posFixa);
			geraCodigo.abrirSe(Ast.posFixa);
			Ast.reinit();
		} else if (ctx.parent instanceof PortugolParser.EnquantoContext) {
			Ast.gerarPosFixa(Ast.root);
			System.out.println(Ast.posFixa);
			geraCodigo.abrirEnquanto(Ast.posFixa);
			Ast.reinit();
		}

	}

	@Override
	public void exitDecisao(PortugolParser.DecisaoContext ctx) {

		if (!tiposSe.isEmpty()) {

			int tipo = tiposSe.get(0);

			for (int i = 1; i < tiposSe.size(); i++) {
				if (tiposSe.get(i) != tipo) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Expressões são de tipos diferentes\n";
				}
			}

			tiposSe.clear();
		}

		geraCodigo.fecharSe();

		if (Ast.root != null)
			Ast.print();
		Ast.reinit();

	}

	@Override
	public void enterExprLogica(PortugolParser.ExprLogicaContext ctx) {
		boolean ehArgumento = false;
		ArrayList<ParserRuleContext> paisExpr = getPaisExprLogica(ctx);

		for (ParserRuleContext exprCtx : paisExpr) {

			if (exprCtx instanceof PortugolParser.ArgumentosContext) {
				ehArgumento = true;
				break;
			}

		}

		if (!ehArgumento) {
			boolean ehAtribuicao = false;
			for (ParserRuleContext exprCtx : paisExpr) {
				if (exprCtx instanceof PortugolParser.AtribuicaoContext) {
					ehAtribuicao = true;
				} else if ((exprCtx instanceof PortugolParser.DecisaoContext || exprCtx instanceof PortugolParser.EnquantoContext)
						&& !ehAtribuicao) {
					setAstExprLogica(ctx);
				}
			}
		}

		if (ctx.ID() != null) {
			if (!existeChaveVar(ctx.ID().getText(), escopo)
					&& !existeChaveVar(ctx.ID().getText(), 0)) {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + ctx.ID().getText()
						+ "\" não foi criado.\n";
			} else {
				if (getTipoID(ctx.ID().getText()) != Constantes.LOGICO) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Identificador \"" + ctx.ID().getText()
							+ "\" não é do tipo lógico.\n";
				}
			}
		}
	}

	@Override
	public void exitExprLogica(PortugolParser.ExprLogicaContext ctx) {
		boolean ehAtribuicao = false;
		ArrayList<ParserRuleContext> paisExpr = getPaisExprLogica(ctx);

		for (ParserRuleContext pai : paisExpr) {
			if (pai instanceof PortugolParser.AtribuicaoContext) {

			} else if ((pai instanceof PortugolParser.DecisaoContext || pai instanceof PortugolParser.EnquantoContext)
					&& !ehAtribuicao) {
				if (ctx.op != null) {
					Ast.up();
				} else if (ctx.OPERADORES_IGUALDADES() != null) {
					Ast.up();
				} else if (ctx.ID() != null) {
					Ast.up();
				} else if (ctx.BOOLEANO() != null) {
					Ast.up();
				}
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
				if (infoFuncao.getQntdParametro() != ctx.argumentos().size()) {
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

					if (seqParam.get(i) == tiposVariaveisArgumentos
							.get(tam - 1)) {

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
	public void exitEnquanto(PortugolParser.EnquantoContext ctx) {
		if (!tiposEnquanto.isEmpty()) {

			int tipo = tiposEnquanto.get(0);

			for (int i = 1; i < tiposEnquanto.size(); i++) {
				if (tiposEnquanto.get(i) != tipo) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Expressões são de tipos diferentes\n";
				}
			}

			tiposEnquanto.clear();
		}

		geraCodigo.fecharEnquanto();

		if (Ast.root != null)
			Ast.print();
		Ast.reinit();
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

		if (tipo != 0) {

			geraCodigoRetorno(ctx);

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
			} else {
				if (ctx.expressao() != null) {
					if (ctx.expressao().chamadaDeFunc() != null) {
						geraCodigoChamadaFuncao(ctx);
					}
				}
			}

		}
	}

	@Override
	// Só gera para variaveis locais
	public void exitAtribuicao(PortugolParser.AtribuicaoContext ctx) {

		if (ctx.expressao() != null) {
			boolean tipoErrado = false;

			int tipoIdAtr = getTipoID(ctx.ID().getText());

			for (Integer tipo : tiposVariaveisAtribuicao) {
				if (tipo != tipoIdAtr) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Atribuição entre tipos incompatíveis.\n";

					tipoErrado = true;
				}
			}

			InfoVariavel var = getInfoVariavel(ctx.ID().getText(), this.escopo);
			if (!tipoErrado && var != null && Ast.root != null) {
				Ast.gerarPosFixa(Ast.root);

				if (ctx.expressao().chamadaDeFunc() == null) {
					geraCodigo.gerarAtribuicao(Ast.posFixa, tipoIdAtr,
							var.getEnderecoLocal());
				}

			}

			tiposVariaveisAtribuicao.clear();

		}

		if (Ast.root != null)
			Ast.print();
		Ast.reinit();
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

	private ArrayList<ParserRuleContext> getPaisExprLogica(
			PortugolParser.ExprLogicaContext ctx) {

		ParserRuleContext ruleCtx = ctx.getParent();

		ArrayList<ParserRuleContext> paisExpr = new ArrayList<ParserRuleContext>();

		while (ruleCtx != null) {
			paisExpr.add(ruleCtx);
			ruleCtx = ruleCtx.getParent();
		}

		return paisExpr;
	}

	private ArrayList<ParserRuleContext> getPaisRetorno(
			PortugolParser.RetornaContext ctx) {
		ParserRuleContext ruleCtx = ctx.getParent();

		ArrayList<ParserRuleContext> paisRetorno = new ArrayList<ParserRuleContext>();

		while (ruleCtx != null) {
			paisRetorno.add(ruleCtx);
			ruleCtx = ruleCtx.getParent();
		}

		return paisRetorno;
	}

	private void geraCodigoChamadaFuncao(PortugolParser.AtribuicaoContext ctx) {
		InfoFuncao infoFuncao = null;
		Chave chave = null;
		Set<Chave> chaves = tsFunc.keySet();

		for (Chave key : chaves) {
			if (key != null) {
				if (key.getId().compareTo(
						ctx.expressao().chamadaDeFunc().ID().getText()) == 0) {
					infoFuncao = tsFunc.get(key);
					chave = key;
					break;
				}
			}
		}

		List<ArgumentosContext> args = ctx.expressao().chamadaDeFunc()
				.argumentos();
		String argumentosStr = "\n";

		for (ArgumentosContext argumento : args) {
			if (argumento.expressao().ID() != null) {

				int tipo = getTipoID(argumento.expressao().ID().getText());
				InfoVariavel var = getInfoVariavel(argumento.expressao().ID()
						.getText(), this.escopo);

				argumentosStr += geraCodigo.getTipoDaExpressao(tipo) + "load "
						+ var.getEnderecoLocal() + "\n";

			} else if (argumento.expressao().NUM_INTEIRO() != null) {
				argumentosStr += "ldc "
						+ argumento.expressao().NUM_INTEIRO().getText() + "\n";
			} else if (argumento.expressao().NUM_REAL() != null) {
				argumentosStr += "ldc "
						+ argumento.expressao().NUM_REAL().getText() + "\n";
			} else if (argumento.expressao().CADEIA_DE_CARACTERES() != null) {
				argumentosStr += "ldc "
						+ argumento.expressao().CADEIA_DE_CARACTERES()
								.getText() + "\n";
			}

		}

		InfoVariavel var = getInfoVariavel(ctx.ID().getText(), this.escopo);

		geraCodigo.chamadaMetodo(chave.getId(), argumentosStr,
				infoFuncao.getSeqParametro(), var.getEnderecoLocal(),
				infoFuncao.getTipo());
	}

	private void geraCodigoRetorno(PortugolParser.RetornaContext ctx) {
		boolean ehFilhoPrincipal = false;
		ArrayList<ParserRuleContext> paisRetorno = getPaisRetorno(ctx);

		for (ParserRuleContext retornoCtx : paisRetorno) {

			if (retornoCtx instanceof PortugolParser.FuncPrincipalContext) {
				ehFilhoPrincipal = true;
				break;
			}

		}

		if (!ehFilhoPrincipal) {
			String retornoStr = "\n";

			ExpressaoContext exp = ctx.expressao();

			if (exp.ID() != null) {

				int tipo = getTipoID(exp.ID().getText());
				InfoVariavel var = getInfoVariavel(exp.ID().getText(),
						this.escopo);

				retornoStr += geraCodigo.getTipoDaExpressao(tipo) + "load "
						+ var.getEnderecoLocal() + "\n";
				retornoStr += geraCodigo.getTipoDaExpressao(tipo) + "return\n";

			} else if (exp.NUM_INTEIRO() != null) {
				retornoStr += "ldc " + exp.NUM_INTEIRO().getText() + "\n";
				retornoStr += "ireturn\n";
			} else if (exp.NUM_REAL() != null) {
				retornoStr += "ldc " + exp.NUM_REAL().getText() + "\n";
				retornoStr += "freturn\n";
			} else if (exp.CADEIA_DE_CARACTERES() != null) {
				retornoStr += "ldc " + exp.CADEIA_DE_CARACTERES().getText()
						+ "\n";
				retornoStr += "areturn\n";

			}

			geraCodigo.geraRetorno(retornoStr);

		}

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
				}
			}
		}

		if (tipo == 0) {
			for (Chave key : chaves) {
				if (key != null) {
					if (key.getEscopo() == 0 && key.getId().compareTo(id) == 0) {
						InfoVariavel info = tsVar.get(key);
						tipo = info.getTipo();
						break;
					}
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

	private void setTipoVariaveisRetornos(PortugolParser.ExpressaoContext ctx) {
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

	private void setTipoVariaveisArgumentos(PortugolParser.ExpressaoContext ctx) {
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

	private void setTipoPara(ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposPara.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposPara.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposPara.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposPara.add(getTipoID(ctx.ID().getText()));
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

			tiposPara.add(tipo);
		}
	}

	private void setTipoEnquanto(ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposEnquanto.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposEnquanto.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposEnquanto.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposEnquanto.add(getTipoID(ctx.ID().getText()));
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

			tiposEnquanto.add(tipo);
		}
	}

	private void setTipoSe(ExpressaoContext ctx) {
		if (ctx.NUM_INTEIRO() != null) {
			tiposSe.add(Constantes.INTEIRO);
		} else if (ctx.NUM_REAL() != null) {
			tiposSe.add(Constantes.REAL);
		} else if (ctx.CADEIA_DE_CARACTERES() != null) {
			tiposSe.add(Constantes.PALAVRA);
		} else if (ctx.ID() != null) {
			if (existeID(ctx.ID().getText())) {
				tiposSe.add(getTipoID(ctx.ID().getText()));
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

			tiposSe.add(tipo);
		}
	}

	private void analisaAtribuicao(ComandosContext ctx) {
		if (ctx.atribuicao().ID() == null) {
			erro += "Linha "
					+ ctx.start.getLine()
					+ " - Retorno da função não é atribuído a nenhum identificador.\n";
		} else {
			InfoVariavel infoVariavel = getInfoVariavel(ctx.atribuicao().ID()
					.getText(), this.escopo);
			if (infoVariavel != null) {
				if (infoVariavel.getCategoria() == Constantes.CONSTANTE) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - A constante \""
							+ ctx.atribuicao().ID().getText()
							+ "\" não pode ser modificada.\n";
				}
			} else {
				infoVariavel = getInfoVariavel(ctx.atribuicao().ID().getText(),
						this.escopo);
				if (infoVariavel != null
						&& infoVariavel.getCategoria() == Constantes.CONSTANTE) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - A constante \""
							+ ctx.atribuicao().ID().getText()
							+ "\" não pode ser modificada.\n";
				}
			}
		}
	}

	private void analisaPara(PortugolParser.ParaContext ctx) {
		if (!existeChaveVar(ctx.ID().getText(), escopo)
				&& !existeChaveVar(ctx.ID().getText(), 0)) {
			erro += "Linha " + ctx.getStart().getLine() + " - Identificador \""
					+ ctx.ID().getText() + "\" não foi criado.\n";
		} else {
			if (getTipoID(ctx.ID().getText()) != Constantes.INTEIRO) {
				erro += "Linha " + ctx.getStart().getLine()
						+ " - Identificador \"" + ctx.ID().getText()
						+ "\" não é do tipo INTEIRO.\n";
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

	private InfoVariavel getInfoVariavel(String id, int escopo) {
		InfoVariavel infoVariavel = null;

		Set<Chave> chaves = tsVar.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getEscopo() == escopo && key.getId().compareTo(id) == 0) {
					infoVariavel = tsVar.get(key);
					break;
				}
			}
		}

		return infoVariavel;
	}

	private void setAstExpressao(PortugolParser.ExpressaoContext ctx) {
		boolean escopoEhZero = false;

		if (ctx.op != null) {
			No n = new No(ctx.op.getText());
			n.setAtributo("tipo", "op");
			Ast.init(n);

		} else if (ctx.ID() != null) {
			No n = new No(ctx.ID().getText());
			n.setAtributo("tipo", "id");
			Chave key = getChaveTsVar(ctx.ID().getText(), this.escopo);

			if (key == null) {
				key = getChaveTsVar(ctx.ID().getText(), 0);
				escopoEhZero = true;
			}

			if (key != null) {
				InfoVariavel var = this.tsVar.get(key);
				if (escopoEhZero) {
					n.setAtributo("posicao",
							String.valueOf(var.getEnderecoGlobal()));
				} else {
					n.setAtributo("posicao",
							String.valueOf(var.getEnderecoLocal()));
				}
				n.setAtributo("type", String.valueOf(var.getTipo()));

			}
			Ast.init(n);

		} else if (ctx.valor != null) {
			No n = new No(ctx.valor.getText());
			n.setAtributo("tipo", "valor");

			if (ctx.NUM_INTEIRO() != null) {
				n.setAtributo("type", String.valueOf(Constantes.INTEIRO));
			} else if (ctx.NUM_REAL() != null) {
				n.setAtributo("type", String.valueOf(Constantes.REAL));
			} else if (ctx.CADEIA_DE_CARACTERES() != null) {
				n.setAtributo("type", String.valueOf(Constantes.PALAVRA));
			}

			Ast.init(n);

		}
	}

	private void setAstExprLogica(ExprLogicaContext ctx) {
		boolean escopoEhZero = false;

		if (ctx.op != null) {
			No n = new No(ctx.op.getText());
			n.setAtributo("tipo", "op");
			Ast.init(n);
		} else if (ctx.OPERADORES_IGUALDADES() != null && ctx.op == null) {
			No n = new No(ctx.OPERADORES_IGUALDADES().getText());
			n.setAtributo("tipo", "op");
			Ast.init(n);
		} else if (ctx.ID() != null) {
			No n = new No(ctx.ID().getText());
			n.setAtributo("tipo", "id");
			Chave key = getChaveTsVar(ctx.ID().getText(), this.escopo);

			if (key == null) {
				key = getChaveTsVar(ctx.ID().getText(), 0);
				escopoEhZero = true;
			}

			if (key != null) {
				InfoVariavel var = this.tsVar.get(key);
				if (escopoEhZero) {
					n.setAtributo("posicao",
							String.valueOf(var.getEnderecoGlobal()));
				} else {
					n.setAtributo("posicao",
							String.valueOf(var.getEnderecoLocal()));
				}
				n.setAtributo("type", String.valueOf(var.getTipo()));

			}
			Ast.init(n);

		} else if (ctx.BOOLEANO() != null) {

			No n = new No(ctx.BOOLEANO().getText());
			n.setAtributo("tipo", "valor");
			n.setAtributo("type", String.valueOf(Constantes.LOGICO));
			Ast.init(n);

		}
	}

	private Chave getChaveTsVar(String id, int escopo) {
		Chave chave = null;

		Set<Chave> chaves = tsVar.keySet();
		for (Chave key : chaves) {
			if (key != null) {
				if (key.getEscopo() == escopo && key.getId().compareTo(id) == 0) {
					chave = key;
					break;
				}
			}
		}

		return chave;
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

	public GeraCodigo getGeraCogigo() {
		return geraCodigo;
	}

}
