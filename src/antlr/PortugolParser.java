// Generated from C:\Users\Luis Guilherme\Google Drive\UFPI\DISCIPLINAS\7º PERÍODO\CONSTRUÇÃO DE COMPILADORES - Raimundo Moura\Trabalho Final\Portugol.g4 by ANTLR 4.1

package antlr;
import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PortugolParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABRE_CHAVES=1, ABRE_COLCHETE=2, ABRE_PARENTESIS=3, ATE=4, BOOLEANO=5, 
		CADEIA_DE_CARACTERES=6, CONSTANTE=7, DE=8, DIVIDIR=9, DOIS_PONTOS=10, 
		ENQUANTO=11, ESCREVER=12, FECHA_CHAVES=13, FECHA_COLCHETE=14, FECHA_PARENTESIS=15, 
		IGUAL=16, SE=17, SENAO=18, INTEIRO=19, LER=20, LOGICO=21, MULTIPLICACAO=22, 
		NEGACAO=23, NUM_INTEIRO=24, NUM_REAL=25, OPERADORES_IGUALDADES=26, OPERADORES_SUPERIORIDADE=27, 
		PALAVRA=28, PARA=29, PASSO=30, PONTO=31, PONTO_E_VIRGULA=32, PRINCIPAL=33, 
		PROGRAMA=34, REAL=35, RETORNO=36, SAIR=37, SOMA=38, SUBTRACAO=39, VIRGULA=40, 
		COMENTARIO_DE_LINHA=41, COMENTARIO=42, ID=43, WS=44;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "'['", "'('", "'ate'", "BOOLEANO", "CADEIA_DE_CARACTERES", 
		"'constante'", "'de'", "'/'", "':'", "'enquanto'", "'escrever'", "'}'", 
		"']'", "')'", "'='", "'se'", "'senao'", "'inteiro'", "'ler'", "'logico'", 
		"'*'", "'!'", "NUM_INTEIRO", "NUM_REAL", "OPERADORES_IGUALDADES", "OPERADORES_SUPERIORIDADE", 
		"'palavra'", "'para'", "'passo'", "'.'", "';'", "'principal'", "'programa'", 
		"'real'", "'retorno'", "'sair'", "'+'", "'-'", "','", "COMENTARIO_DE_LINHA", 
		"COMENTARIO", "ID", "WS"
	};
	public static final int
		RULE_prog = 0, RULE_declarVar = 1, RULE_tipo = 2, RULE_atribuicao = 3, 
		RULE_declarConst = 4, RULE_funcPrincipal = 5, RULE_declarFunc = 6, RULE_parametro = 7, 
		RULE_comandos = 8, RULE_ler = 9, RULE_escrever = 10, RULE_chamadaDeFunc = 11, 
		RULE_argumentos = 12, RULE_decisao = 13, RULE_para = 14, RULE_enquanto = 15, 
		RULE_expressao = 16, RULE_exprLogica = 17, RULE_retorna = 18;
	public static final String[] ruleNames = {
		"prog", "declarVar", "tipo", "atribuicao", "declarConst", "funcPrincipal", 
		"declarFunc", "parametro", "comandos", "ler", "escrever", "chamadaDeFunc", 
		"argumentos", "decisao", "para", "enquanto", "expressao", "exprLogica", 
		"retorna"
	};

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	public static Map<String, Integer> tabelaSimbolos = new HashMap<String, Integer>();

	public PortugolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<DeclarConstContext> declarConst() {
			return getRuleContexts(DeclarConstContext.class);
		}
		public DeclarFuncContext declarFunc(int i) {
			return getRuleContext(DeclarFuncContext.class,i);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public FuncPrincipalContext funcPrincipal() {
			return getRuleContext(FuncPrincipalContext.class,0);
		}
		public DeclarConstContext declarConst(int i) {
			return getRuleContext(DeclarConstContext.class,i);
		}
		public DeclarVarContext declarVar(int i) {
			return getRuleContext(DeclarVarContext.class,i);
		}
		public List<DeclarFuncContext> declarFunc() {
			return getRuleContexts(DeclarFuncContext.class);
		}
		public List<DeclarVarContext> declarVar() {
			return getRuleContexts(DeclarVarContext.class);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(PROGRAMA);
			setState(39); match(ID);
			setState(40); match(PONTO_E_VIRGULA);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(43);
					switch (_input.LA(1)) {
					case INTEIRO:
					case LOGICO:
					case PALAVRA:
					case REAL:
						{
						setState(41); declarVar();
						}
						break;
					case CONSTANTE:
						{
						setState(42); declarConst();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(48); declarFunc();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(54); funcPrincipal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarVarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PortugolParser.ID); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(PortugolParser.ID, i);
		}
		public DeclarVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclarVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclarVar(this);
		}
	}

	public final DeclarVarContext declarVar() throws RecognitionException {
		DeclarVarContext _localctx = new DeclarVarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); tipo();
			setState(57); match(DOIS_PONTOS);
			setState(58); match(ID);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(59); match(VIRGULA);
				setState(60); match(ID);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66); match(PONTO_E_VIRGULA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public int t;
		public TerminalNode INTEIRO() { return getToken(PortugolParser.INTEIRO, 0); }
		public TerminalNode PALAVRA() { return getToken(PortugolParser.PALAVRA, 0); }
		public TerminalNode LOGICO() { return getToken(PortugolParser.LOGICO, 0); }
		public TerminalNode REAL() { return getToken(PortugolParser.REAL, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		try {
			setState(76);
			switch (_input.LA(1)) {
			case INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(INTEIRO);
				((TipoContext)_localctx).t =  1;
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); match(REAL);
				((TipoContext)_localctx).t =  2;
				}
				break;
			case LOGICO:
				enterOuterAlt(_localctx, 3);
				{
				setState(72); match(LOGICO);
				((TipoContext)_localctx).t =  3;
				}
				break;
			case PALAVRA:
				enterOuterAlt(_localctx, 4);
				{
				setState(74); match(PALAVRA);
				((TipoContext)_localctx).t =  4;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode CADEIA_DE_CARACTERES() { return getToken(PortugolParser.CADEIA_DE_CARACTERES, 0); }
		public TerminalNode NUM_REAL() { return getToken(PortugolParser.NUM_REAL, 0); }
		public TerminalNode BOOLEANO() { return getToken(PortugolParser.BOOLEANO, 0); }
		public TerminalNode NUM_INTEIRO() { return getToken(PortugolParser.NUM_INTEIRO, 0); }
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitAtribuicao(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atribuicao);
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); match(ID);
				setState(79); match(IGUAL);
				setState(80); match(NUM_INTEIRO);
				setState(81); match(PONTO_E_VIRGULA);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82); match(ID);
				setState(83); match(IGUAL);
				setState(84); match(NUM_REAL);
				setState(85); match(PONTO_E_VIRGULA);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86); match(ID);
				setState(87); match(IGUAL);
				setState(88); match(CADEIA_DE_CARACTERES);
				setState(89); match(PONTO_E_VIRGULA);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90); match(ID);
				setState(91); match(IGUAL);
				setState(92); match(BOOLEANO);
				setState(93); match(PONTO_E_VIRGULA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarConstContext extends ParserRuleContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DeclarConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclarConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclarConst(this);
		}
	}

	public final DeclarConstContext declarConst() throws RecognitionException {
		DeclarConstContext _localctx = new DeclarConstContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(CONSTANTE);
			setState(97); tipo();
			setState(98); atribuicao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncPrincipalContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<DeclarConstContext> declarConst() {
			return getRuleContexts(DeclarConstContext.class);
		}
		public DeclarConstContext declarConst(int i) {
			return getRuleContext(DeclarConstContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public DeclarVarContext declarVar(int i) {
			return getRuleContext(DeclarVarContext.class,i);
		}
		public List<DeclarVarContext> declarVar() {
			return getRuleContexts(DeclarVarContext.class);
		}
		public FuncPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterFuncPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitFuncPrincipal(this);
		}
	}

	public final FuncPrincipalContext funcPrincipal() throws RecognitionException {
		FuncPrincipalContext _localctx = new FuncPrincipalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(INTEIRO);
			setState(101); match(PRINCIPAL);
			setState(102); match(ABRE_PARENTESIS);
			setState(103); match(FECHA_PARENTESIS);
			setState(104); match(ABRE_CHAVES);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(107);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(105); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(106); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
				{
				{
				setState(112); comandos();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118); match(FECHA_CHAVES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarFuncContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<DeclarConstContext> declarConst() {
			return getRuleContexts(DeclarConstContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DeclarConstContext declarConst(int i) {
			return getRuleContext(DeclarConstContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public DeclarVarContext declarVar(int i) {
			return getRuleContext(DeclarVarContext.class,i);
		}
		public List<DeclarVarContext> declarVar() {
			return getRuleContexts(DeclarVarContext.class);
		}
		public DeclarFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDeclarFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDeclarFunc(this);
		}
	}

	public final DeclarFuncContext declarFunc() throws RecognitionException {
		DeclarFuncContext _localctx = new DeclarFuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); tipo();
			setState(121); match(ID);
			setState(122); match(ABRE_PARENTESIS);
			setState(131);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(123); parametro();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(124); match(VIRGULA);
					setState(125); parametro();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(133); match(FECHA_PARENTESIS);
			setState(134); match(ABRE_CHAVES);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(137);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(135); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(136); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
				{
				{
				setState(142); comandos();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148); match(FECHA_CHAVES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitParametro(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); tipo();
			setState(151); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public DecisaoContext decisao() {
			return getRuleContext(DecisaoContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public LerContext ler() {
			return getRuleContext(LerContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ChamadaDeFuncContext chamadaDeFunc() {
			return getRuleContext(ChamadaDeFuncContext.class,0);
		}
		public EscreverContext escrever() {
			return getRuleContext(EscreverContext.class,0);
		}
		public ParaContext para() {
			return getRuleContext(ParaContext.class,0);
		}
		public RetornaContext retorna() {
			return getRuleContext(RetornaContext.class,0);
		}
		public EnquantoContext enquanto() {
			return getRuleContext(EnquantoContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitComandos(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comandos);
		try {
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153); atribuicao();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); match(ID);
				setState(155); match(IGUAL);
				setState(158);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(156); expressao(0);
					}
					break;

				case 2:
					{
					setState(157); exprLogica(0);
					}
					break;
				}
				setState(160); match(PONTO_E_VIRGULA);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162); ler();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163); escrever();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(164); match(ID);
					setState(165); match(IGUAL);
					}
					break;
				}
				setState(168); chamadaDeFunc();
				setState(169); match(PONTO_E_VIRGULA);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(171); decisao();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(172); para();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(173); enquanto();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(174); retorna();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LerContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PortugolParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PortugolParser.ID, i);
		}
		public LerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterLer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitLer(this);
		}
	}

	public final LerContext ler() throws RecognitionException {
		LerContext _localctx = new LerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(LER);
			setState(178); match(ABRE_PARENTESIS);
			setState(179); match(ID);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(180); match(VIRGULA);
				setState(181); match(ID);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187); match(FECHA_PARENTESIS);
			setState(188); match(PONTO_E_VIRGULA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EscreverContext extends ParserRuleContext {
		public ArgumentosContext argumentos(int i) {
			return getRuleContext(ArgumentosContext.class,i);
		}
		public List<ArgumentosContext> argumentos() {
			return getRuleContexts(ArgumentosContext.class);
		}
		public EscreverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escrever; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterEscrever(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitEscrever(this);
		}
	}

	public final EscreverContext escrever() throws RecognitionException {
		EscreverContext _localctx = new EscreverContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_escrever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); match(ESCREVER);
			setState(191); match(ABRE_PARENTESIS);
			setState(192); argumentos();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(193); match(VIRGULA);
				setState(194); argumentos();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200); match(FECHA_PARENTESIS);
			setState(201); match(PONTO_E_VIRGULA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChamadaDeFuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ArgumentosContext argumentos(int i) {
			return getRuleContext(ArgumentosContext.class,i);
		}
		public List<ArgumentosContext> argumentos() {
			return getRuleContexts(ArgumentosContext.class);
		}
		public ChamadaDeFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamadaDeFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterChamadaDeFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitChamadaDeFunc(this);
		}
	}

	public final ChamadaDeFuncContext chamadaDeFunc() throws RecognitionException {
		ChamadaDeFuncContext _localctx = new ChamadaDeFuncContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_chamadaDeFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(ID);
			setState(204); match(ABRE_PARENTESIS);
			setState(213);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABRE_PARENTESIS) | (1L << CADEIA_DE_CARACTERES) | (1L << NEGACAO) | (1L << NUM_INTEIRO) | (1L << NUM_REAL) | (1L << SUBTRACAO) | (1L << ID))) != 0)) {
				{
				setState(205); argumentos();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(206); match(VIRGULA);
					setState(207); argumentos();
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(215); match(FECHA_PARENTESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentosContext extends ParserRuleContext {
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode CADEIA_DE_CARACTERES() { return getToken(PortugolParser.CADEIA_DE_CARACTERES, 0); }
		public ChamadaDeFuncContext chamadaDeFunc() {
			return getRuleContext(ChamadaDeFuncContext.class,0);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitArgumentos(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argumentos);
		try {
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217); expressao(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218); exprLogica(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219); match(CADEIA_DE_CARACTERES);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(220); chamadaDeFunc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecisaoContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public DecisaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterDecisao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitDecisao(this);
		}
	}

	public final DecisaoContext decisao() throws RecognitionException {
		DecisaoContext _localctx = new DecisaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decisao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(SE);
			setState(224); match(ABRE_PARENTESIS);
			setState(225); exprLogica(0);
			setState(226); match(FECHA_PARENTESIS);
			setState(227); match(ABRE_CHAVES);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
				{
				{
				setState(228); comandos();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234); match(FECHA_CHAVES);
			setState(244);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(235); match(SENAO);
				setState(236); match(ABRE_CHAVES);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
					{
					{
					setState(237); comandos();
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243); match(FECHA_CHAVES);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParaContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitPara(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); match(PARA);
			setState(247); match(ID);
			setState(248); match(DE);
			setState(249); expressao(0);
			setState(250); match(ATE);
			setState(251); expressao(0);
			setState(254);
			_la = _input.LA(1);
			if (_la==PASSO) {
				{
				setState(252); match(PASSO);
				setState(253); expressao(0);
				}
			}

			setState(256); match(ABRE_CHAVES);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				setState(260);
				switch (_input.LA(1)) {
				case ENQUANTO:
				case ESCREVER:
				case SE:
				case LER:
				case PARA:
				case RETORNO:
				case ID:
					{
					setState(257); comandos();
					}
					break;
				case SAIR:
					{
					setState(258); match(SAIR);
					setState(259); match(PONTO_E_VIRGULA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265); match(FECHA_CHAVES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnquantoContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public EnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitEnquanto(this);
		}
	}

	public final EnquantoContext enquanto() throws RecognitionException {
		EnquantoContext _localctx = new EnquantoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); match(ENQUANTO);
			setState(268); match(ABRE_PARENTESIS);
			setState(269); exprLogica(0);
			setState(270); match(FECHA_PARENTESIS);
			setState(271); match(ABRE_CHAVES);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				setState(275);
				switch (_input.LA(1)) {
				case ENQUANTO:
				case ESCREVER:
				case SE:
				case LER:
				case PARA:
				case RETORNO:
				case ID:
					{
					setState(272); comandos();
					}
					break;
				case SAIR:
					{
					setState(273); match(SAIR);
					setState(274); match(PONTO_E_VIRGULA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280); match(FECHA_CHAVES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public int _p;
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode NUM_REAL() { return getToken(PortugolParser.NUM_REAL, 0); }
		public ChamadaDeFuncContext chamadaDeFunc() {
			return getRuleContext(ChamadaDeFuncContext.class,0);
		}
		public TerminalNode NUM_INTEIRO() { return getToken(PortugolParser.NUM_INTEIRO, 0); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState, _p);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, RULE_expressao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(283); match(SUBTRACAO);
				setState(284); expressao(8);
				}
				break;

			case 2:
				{
				setState(285); match(ABRE_PARENTESIS);
				setState(286); expressao(0);
				setState(287); match(FECHA_PARENTESIS);
				}
				break;

			case 3:
				{
				setState(289); match(NUM_INTEIRO);
				}
				break;

			case 4:
				{
				setState(290); match(NUM_REAL);
				}
				break;

			case 5:
				{
				setState(291); chamadaDeFunc();
				}
				break;

			case 6:
				{
				setState(292); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(301);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(295);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(296);
						_la = _input.LA(1);
						if ( !(_la==DIVIDIR || _la==MULTIPLICACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(297); expressao(8);
						}
						break;

					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(298);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(299);
						_la = _input.LA(1);
						if ( !(_la==SOMA || _la==SUBTRACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(300); expressao(7);
						}
						break;
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprLogicaContext extends ParserRuleContext {
		public int _p;
		public List<ExprLogicaContext> exprLogica() {
			return getRuleContexts(ExprLogicaContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode OPERADORES_SUPERIORIDADE() { return getToken(PortugolParser.OPERADORES_SUPERIORIDADE, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public ExprLogicaContext exprLogica(int i) {
			return getRuleContext(ExprLogicaContext.class,i);
		}
		public TerminalNode OPERADORES_IGUALDADES() { return getToken(PortugolParser.OPERADORES_IGUALDADES, 0); }
		public ExprLogicaContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprLogicaContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_exprLogica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterExprLogica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitExprLogica(this);
		}
	}

	public final ExprLogicaContext exprLogica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprLogicaContext _localctx = new ExprLogicaContext(_ctx, _parentState, _p);
		ExprLogicaContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, RULE_exprLogica);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(307); match(NEGACAO);
				setState(308); exprLogica(4);
				}
				break;

			case 2:
				{
				setState(309); expressao(0);
				setState(310);
				_la = _input.LA(1);
				if ( !(_la==OPERADORES_IGUALDADES || _la==OPERADORES_SUPERIORIDADE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(311); expressao(0);
				}
				break;

			case 3:
				{
				setState(313); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprLogicaContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
					setState(316);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(317); match(OPERADORES_IGUALDADES);
					setState(318); exprLogica(4);
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RetornaContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode CADEIA_DE_CARACTERES() { return getToken(PortugolParser.CADEIA_DE_CARACTERES, 0); }
		public TerminalNode BOOLEANO() { return getToken(PortugolParser.BOOLEANO, 0); }
		public RetornaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorna; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterRetorna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitRetorna(this);
		}
	}

	public final RetornaContext retorna() throws RecognitionException {
		RetornaContext _localctx = new RetornaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_retorna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(RETORNO);
			setState(325); match(ABRE_PARENTESIS);
			setState(329);
			switch (_input.LA(1)) {
			case ABRE_PARENTESIS:
			case NUM_INTEIRO:
			case NUM_REAL:
			case SUBTRACAO:
			case ID:
				{
				setState(326); expressao(0);
				}
				break;
			case CADEIA_DE_CARACTERES:
				{
				setState(327); match(CADEIA_DE_CARACTERES);
				}
				break;
			case BOOLEANO:
				{
				setState(328); match(BOOLEANO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(331); match(FECHA_PARENTESIS);
			setState(332); match(PONTO_E_VIRGULA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return expressao_sempred((ExpressaoContext)_localctx, predIndex);

		case 17: return exprLogica_sempred((ExprLogicaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprLogica_sempred(ExprLogicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 3 >= _localctx._p;
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\u0151\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3\2"+
		"\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3"+
		"\16\3C\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7\7\7"+
		"t\n\7\f\7\16\7w\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0081\n\b\f\b"+
		"\16\b\u0084\13\b\5\b\u0086\n\b\3\b\3\b\3\b\3\b\7\b\u008c\n\b\f\b\16\b"+
		"\u008f\13\b\3\b\7\b\u0092\n\b\f\b\16\b\u0095\13\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00a1\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a9\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b2\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u00b9\n\13\f\13\16\13\u00bc\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\7\f\u00c6\n\f\f\f\16\f\u00c9\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\7\r\u00d3\n\r\f\r\16\r\u00d6\13\r\5\r\u00d8\n\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\5\16\u00e0\n\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00e8\n\17\f"+
		"\17\16\17\u00eb\13\17\3\17\3\17\3\17\3\17\7\17\u00f1\n\17\f\17\16\17\u00f4"+
		"\13\17\3\17\5\17\u00f7\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u0101\n\20\3\20\3\20\3\20\3\20\7\20\u0107\n\20\f\20\16\20\u010a\13"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0116\n\21"+
		"\f\21\16\21\u0119\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u0128\n\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u0130\n\22\f\22\16\22\u0133\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u013d\n\23\3\23\3\23\3\23\7\23\u0142\n\23\f\23\16\23\u0145"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\5\24\u014c\n\24\3\24\3\24\3\24\3\24\2"+
		"\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\4\2\13\13\30\30\3"+
		"\2()\3\2\34\35\u0174\2(\3\2\2\2\4:\3\2\2\2\6N\3\2\2\2\b`\3\2\2\2\nb\3"+
		"\2\2\2\ff\3\2\2\2\16z\3\2\2\2\20\u0098\3\2\2\2\22\u00b1\3\2\2\2\24\u00b3"+
		"\3\2\2\2\26\u00c0\3\2\2\2\30\u00cd\3\2\2\2\32\u00df\3\2\2\2\34\u00e1\3"+
		"\2\2\2\36\u00f8\3\2\2\2 \u010d\3\2\2\2\"\u0127\3\2\2\2$\u013c\3\2\2\2"+
		"&\u0146\3\2\2\2()\7$\2\2)*\7-\2\2*/\7\"\2\2+.\5\4\3\2,.\5\n\6\2-+\3\2"+
		"\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\65\3\2\2\2\61/\3\2"+
		"\2\2\62\64\5\16\b\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3"+
		"\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5\f\7\29\3\3\2\2\2:;\5\6\4\2;<\7\f"+
		"\2\2<A\7-\2\2=>\7*\2\2>@\7-\2\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2"+
		"\2BD\3\2\2\2CA\3\2\2\2DE\7\"\2\2E\5\3\2\2\2FG\7\25\2\2GO\b\4\1\2HI\7%"+
		"\2\2IO\b\4\1\2JK\7\27\2\2KO\b\4\1\2LM\7\36\2\2MO\b\4\1\2NF\3\2\2\2NH\3"+
		"\2\2\2NJ\3\2\2\2NL\3\2\2\2O\7\3\2\2\2PQ\7-\2\2QR\7\22\2\2RS\7\32\2\2S"+
		"a\7\"\2\2TU\7-\2\2UV\7\22\2\2VW\7\33\2\2Wa\7\"\2\2XY\7-\2\2YZ\7\22\2\2"+
		"Z[\7\b\2\2[a\7\"\2\2\\]\7-\2\2]^\7\22\2\2^_\7\7\2\2_a\7\"\2\2`P\3\2\2"+
		"\2`T\3\2\2\2`X\3\2\2\2`\\\3\2\2\2a\t\3\2\2\2bc\7\t\2\2cd\5\6\4\2de\5\b"+
		"\5\2e\13\3\2\2\2fg\7\25\2\2gh\7#\2\2hi\7\5\2\2ij\7\21\2\2jo\7\3\2\2kn"+
		"\5\4\3\2ln\5\n\6\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p"+
		"u\3\2\2\2qo\3\2\2\2rt\5\22\n\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2"+
		"vx\3\2\2\2wu\3\2\2\2xy\7\17\2\2y\r\3\2\2\2z{\5\6\4\2{|\7-\2\2|\u0085\7"+
		"\5\2\2}\u0082\5\20\t\2~\177\7*\2\2\177\u0081\5\20\t\2\u0080~\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085}\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\7\21\2\2\u0088\u008d\7\3\2\2\u0089\u008c\5\4\3\2"+
		"\u008a\u008c\5\n\6\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0093\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0092\5\22\n\2\u0091\u0090\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\7\17\2\2\u0097\17\3\2\2\2\u0098\u0099\5\6\4"+
		"\2\u0099\u009a\7-\2\2\u009a\21\3\2\2\2\u009b\u00b2\5\b\5\2\u009c\u009d"+
		"\7-\2\2\u009d\u00a0\7\22\2\2\u009e\u00a1\5\"\22\2\u009f\u00a1\5$\23\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\7\"\2\2\u00a3\u00b2\3\2\2\2\u00a4\u00b2\5\24\13\2\u00a5\u00b2\5\26\f"+
		"\2\u00a6\u00a7\7-\2\2\u00a7\u00a9\7\22\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\5\30\r\2\u00ab\u00ac\7\"\2\2"+
		"\u00ac\u00b2\3\2\2\2\u00ad\u00b2\5\34\17\2\u00ae\u00b2\5\36\20\2\u00af"+
		"\u00b2\5 \21\2\u00b0\u00b2\5&\24\2\u00b1\u009b\3\2\2\2\u00b1\u009c\3\2"+
		"\2\2\u00b1\u00a4\3\2\2\2\u00b1\u00a5\3\2\2\2\u00b1\u00a8\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\7\26\2\2\u00b4\u00b5\7\5\2\2\u00b5\u00ba"+
		"\7-\2\2\u00b6\u00b7\7*\2\2\u00b7\u00b9\7-\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\21\2\2\u00be\u00bf\7\"\2\2\u00bf"+
		"\25\3\2\2\2\u00c0\u00c1\7\16\2\2\u00c1\u00c2\7\5\2\2\u00c2\u00c7\5\32"+
		"\16\2\u00c3\u00c4\7*\2\2\u00c4\u00c6\5\32\16\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\21\2\2\u00cb\u00cc\7\"\2\2\u00cc"+
		"\27\3\2\2\2\u00cd\u00ce\7-\2\2\u00ce\u00d7\7\5\2\2\u00cf\u00d4\5\32\16"+
		"\2\u00d0\u00d1\7*\2\2\u00d1\u00d3\5\32\16\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\7\21\2\2\u00da\31\3\2\2\2\u00db\u00e0\5\"\22"+
		"\2\u00dc\u00e0\5$\23\2\u00dd\u00e0\7\b\2\2\u00de\u00e0\5\30\r\2\u00df"+
		"\u00db\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2"+
		"\2\2\u00e0\33\3\2\2\2\u00e1\u00e2\7\23\2\2\u00e2\u00e3\7\5\2\2\u00e3\u00e4"+
		"\5$\23\2\u00e4\u00e5\7\21\2\2\u00e5\u00e9\7\3\2\2\u00e6\u00e8\5\22\n\2"+
		"\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f6\7\17\2\2"+
		"\u00ed\u00ee\7\24\2\2\u00ee\u00f2\7\3\2\2\u00ef\u00f1\5\22\n\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\7\17\2\2\u00f6\u00ed\3"+
		"\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\35\3\2\2\2\u00f8\u00f9\7\37\2\2\u00f9"+
		"\u00fa\7-\2\2\u00fa\u00fb\7\n\2\2\u00fb\u00fc\5\"\22\2\u00fc\u00fd\7\6"+
		"\2\2\u00fd\u0100\5\"\22\2\u00fe\u00ff\7 \2\2\u00ff\u0101\5\"\22\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0108\7\3"+
		"\2\2\u0103\u0107\5\22\n\2\u0104\u0105\7\'\2\2\u0105\u0107\7\"\2\2\u0106"+
		"\u0103\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\7\17\2\2\u010c\37\3\2\2\2\u010d\u010e\7\r\2\2\u010e\u010f\7\5\2"+
		"\2\u010f\u0110\5$\23\2\u0110\u0111\7\21\2\2\u0111\u0117\7\3\2\2\u0112"+
		"\u0116\5\22\n\2\u0113\u0114\7\'\2\2\u0114\u0116\7\"\2\2\u0115\u0112\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\7\17"+
		"\2\2\u011b!\3\2\2\2\u011c\u011d\b\22\1\2\u011d\u011e\7)\2\2\u011e\u0128"+
		"\5\"\22\2\u011f\u0120\7\5\2\2\u0120\u0121\5\"\22\2\u0121\u0122\7\21\2"+
		"\2\u0122\u0128\3\2\2\2\u0123\u0128\7\32\2\2\u0124\u0128\7\33\2\2\u0125"+
		"\u0128\5\30\r\2\u0126\u0128\7-\2\2\u0127\u011c\3\2\2\2\u0127\u011f\3\2"+
		"\2\2\u0127\u0123\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0126\3\2\2\2\u0128\u0131\3\2\2\2\u0129\u012a\6\22\2\3\u012a\u012b\t"+
		"\2\2\2\u012b\u0130\5\"\22\2\u012c\u012d\6\22\3\3\u012d\u012e\t\3\2\2\u012e"+
		"\u0130\5\"\22\2\u012f\u0129\3\2\2\2\u012f\u012c\3\2\2\2\u0130\u0133\3"+
		"\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132#\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0134\u0135\b\23\1\2\u0135\u0136\7\31\2\2\u0136\u013d\5$\23\2"+
		"\u0137\u0138\5\"\22\2\u0138\u0139\t\4\2\2\u0139\u013a\5\"\22\2\u013a\u013d"+
		"\3\2\2\2\u013b\u013d\7-\2\2\u013c\u0134\3\2\2\2\u013c\u0137\3\2\2\2\u013c"+
		"\u013b\3\2\2\2\u013d\u0143\3\2\2\2\u013e\u013f\6\23\4\3\u013f\u0140\7"+
		"\34\2\2\u0140\u0142\5$\23\2\u0141\u013e\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144%\3\2\2\2\u0145\u0143\3\2\2\2"+
		"\u0146\u0147\7&\2\2\u0147\u014b\7\5\2\2\u0148\u014c\5\"\22\2\u0149\u014c"+
		"\7\b\2\2\u014a\u014c\7\7\2\2\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\7\21\2\2\u014e\u014f\7"+
		"\"\2\2\u014f\'\3\2\2\2&-/\65AN`mou\u0082\u0085\u008b\u008d\u0093\u00a0"+
		"\u00a8\u00b1\u00ba\u00c7\u00d4\u00d7\u00df\u00e9\u00f2\u00f6\u0100\u0106"+
		"\u0108\u0115\u0117\u0127\u012f\u0131\u013c\u0143\u014b";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}