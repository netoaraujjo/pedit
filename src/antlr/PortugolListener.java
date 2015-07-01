// Generated from C:\Users\Luis Guilherme\Desktop\pedit\src\antlr\Portugol.g4 by ANTLR 4.1

package antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PortugolParser}.
 */
public interface PortugolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PortugolParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(@NotNull PortugolParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(@NotNull PortugolParser.ComandosContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#fecharParenteses}.
	 * @param ctx the parse tree
	 */
	void enterFecharParenteses(@NotNull PortugolParser.FecharParentesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#fecharParenteses}.
	 * @param ctx the parse tree
	 */
	void exitFecharParenteses(@NotNull PortugolParser.FecharParentesesContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#funcPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterFuncPrincipal(@NotNull PortugolParser.FuncPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#funcPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitFuncPrincipal(@NotNull PortugolParser.FuncPrincipalContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(@NotNull PortugolParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(@NotNull PortugolParser.ParametroContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#ler}.
	 * @param ctx the parse tree
	 */
	void enterLer(@NotNull PortugolParser.LerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#ler}.
	 * @param ctx the parse tree
	 */
	void exitLer(@NotNull PortugolParser.LerContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#retorna}.
	 * @param ctx the parse tree
	 */
	void enterRetorna(@NotNull PortugolParser.RetornaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#retorna}.
	 * @param ctx the parse tree
	 */
	void exitRetorna(@NotNull PortugolParser.RetornaContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#senao}.
	 * @param ctx the parse tree
	 */
	void enterSenao(@NotNull PortugolParser.SenaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#senao}.
	 * @param ctx the parse tree
	 */
	void exitSenao(@NotNull PortugolParser.SenaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(@NotNull PortugolParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(@NotNull PortugolParser.ArgumentosContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#chamadaDeFunc}.
	 * @param ctx the parse tree
	 */
	void enterChamadaDeFunc(@NotNull PortugolParser.ChamadaDeFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#chamadaDeFunc}.
	 * @param ctx the parse tree
	 */
	void exitChamadaDeFunc(@NotNull PortugolParser.ChamadaDeFuncContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(@NotNull PortugolParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(@NotNull PortugolParser.ParaContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#declarFunc}.
	 * @param ctx the parse tree
	 */
	void enterDeclarFunc(@NotNull PortugolParser.DeclarFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declarFunc}.
	 * @param ctx the parse tree
	 */
	void exitDeclarFunc(@NotNull PortugolParser.DeclarFuncContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull PortugolParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull PortugolParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(@NotNull PortugolParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(@NotNull PortugolParser.AtribuicaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(@NotNull PortugolParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(@NotNull PortugolParser.EnquantoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull PortugolParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull PortugolParser.TipoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#decisao}.
	 * @param ctx the parse tree
	 */
	void enterDecisao(@NotNull PortugolParser.DecisaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#decisao}.
	 * @param ctx the parse tree
	 */
	void exitDecisao(@NotNull PortugolParser.DecisaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#escrever}.
	 * @param ctx the parse tree
	 */
	void enterEscrever(@NotNull PortugolParser.EscreverContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#escrever}.
	 * @param ctx the parse tree
	 */
	void exitEscrever(@NotNull PortugolParser.EscreverContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#declarVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarVar(@NotNull PortugolParser.DeclarVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declarVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarVar(@NotNull PortugolParser.DeclarVarContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#sair}.
	 * @param ctx the parse tree
	 */
	void enterSair(@NotNull PortugolParser.SairContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#sair}.
	 * @param ctx the parse tree
	 */
	void exitSair(@NotNull PortugolParser.SairContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#exprLogica}.
	 * @param ctx the parse tree
	 */
	void enterExprLogica(@NotNull PortugolParser.ExprLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#exprLogica}.
	 * @param ctx the parse tree
	 */
	void exitExprLogica(@NotNull PortugolParser.ExprLogicaContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(@NotNull PortugolParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(@NotNull PortugolParser.ExpressaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link PortugolParser#declarConst}.
	 * @param ctx the parse tree
	 */
	void enterDeclarConst(@NotNull PortugolParser.DeclarConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declarConst}.
	 * @param ctx the parse tree
	 */
	void exitDeclarConst(@NotNull PortugolParser.DeclarConstContext ctx);
}