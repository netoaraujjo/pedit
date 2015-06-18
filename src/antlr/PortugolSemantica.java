package antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import util.Constantes;
import antlr.PortugolParser.ParametroContext;

import compiler.Chave;
import compiler.InfoFuncao;
import compiler.InfoVariavel;

public class PortugolSemantica extends PortugolBaseListener {

	private Map<Chave, InfoVariavel> tsVar = new HashMap<Chave, InfoVariavel>();
	private Map<Chave, InfoFuncao> tsFunc = new HashMap<Chave, InfoFuncao>();
	private String output = "";
	private String erro = "";
	private int escopo = 0;
	private int endereceVar = 0;

	private ArrayList<Integer> tiposVariaveisAtr = new ArrayList<Integer>();

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

		ArrayList<ParserRuleContext> paisExpr = getPaisExpr(ctx);

		for (ParserRuleContext exprCtx : paisExpr) {
			if (exprCtx instanceof PortugolParser.AtribuicaoContext) {
				if (ctx.NUM_INTEIRO() != null) {
					tiposVariaveisAtr.add(Constantes.INTEIRO);
				} else if (ctx.NUM_REAL() != null) {
					tiposVariaveisAtr.add(Constantes.REAL);
				} else if (ctx.CADEIA_DE_CARACTERES() != null) {
					tiposVariaveisAtr.add(Constantes.PALAVRA);
				} else if (ctx.ID() != null) {
					if (existeID(ctx.ID().getText())) {
						tiposVariaveisAtr.add(getTipoID(ctx.ID().getText()));
					}
				} else if (ctx.chamadaDeFunc() != null) {
					
					int tipo = 0;
					
					if (existeChaveFunc(ctx.chamadaDeFunc().ID().getText())) { // Função não existe
						
						Set<Chave> chaves = tsFunc.keySet();
						for (Chave key : chaves) {
							if (key != null) {
								if (key.getId().compareTo(ctx.chamadaDeFunc().ID().getText()) == 0) {
									InfoFuncao infoFuncao = tsFunc.get(key);
									tipo = infoFuncao.getTipo();
									break;
								}
							}
						}
					}
					
					tiposVariaveisAtr.add(tipo);
					
				}
			}
		}

		if (ctx.ID() != null) {
			if (!existeID(ctx.ID().getText())) {
				erro += "Linha " + ctx.getStart().getLine() + " - Identificador \"" + ctx.ID().getText() + "\" não foi criado.\n";
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
	public void enterComandos(PortugolParser.ComandosContext ctx) {
		if (ctx.atribuicao() != null) {
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

	@Override
	public void exitAtribuicao(PortugolParser.AtribuicaoContext ctx) {

		if (ctx.expressao() != null) {
			int tipoIdAtr = getTipoID(ctx.ID().getText());

			for (Integer tipo : tiposVariaveisAtr) {
				if (tipo != tipoIdAtr) {
					erro += "Linha " + ctx.getStart().getLine()
							+ " - Atribuição entre tipos incompatíveis.\n";
				}
			}

			tiposVariaveisAtr.clear();

		}
	}

	public boolean existeChaveVar(String id, int escopo) {

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

	public boolean existeID(String id) {
		boolean existe = true;

		if (!existeChaveVar(id, escopo) && !existeChaveVar(id, 0)) {
			existe = false;
		}

		return existe;
	}

	public boolean existeChaveFunc(String id) {

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

	public boolean argumentoLogico(String id, int escopo) {

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

	public String retornaValor(int tipo) {
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

	public ArrayList<ParserRuleContext> getPaisExpr(
			PortugolParser.ExpressaoContext ctx) {

		ParserRuleContext ruleCtx = ctx.getParent();

		ArrayList<ParserRuleContext> paisExpr = new ArrayList<ParserRuleContext>();

		while (ruleCtx != null) {
			paisExpr.add(ruleCtx);
			ruleCtx = ruleCtx.getParent();
		}

		return paisExpr;
	}

	public int getTipoID(String id) {
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
