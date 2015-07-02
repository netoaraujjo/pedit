// Generated from C:\Users\Luis Guilherme\Desktop\pedit\src\antlr\Portugol.g4 by ANTLR 4.1

package antlr;

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
		ABRE_CHAVES=1, ABRE_COLCHETE=2, ABRE_PARENTESES=3, ATE=4, BOOLEANO=5, 
		CADEIA_DE_CARACTERES=6, CONSTANTE=7, DE=8, DIVIDIR=9, DOIS_PONTOS=10, 
		ENQUANTO=11, ESCREVER=12, FECHA_CHAVES=13, FECHA_COLCHETE=14, FECHA_PARENTESES=15, 
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
		RULE_comandos = 8, RULE_sair = 9, RULE_ler = 10, RULE_escrever = 11, RULE_chamadaDeFunc = 12, 
		RULE_argumentos = 13, RULE_decisao = 14, RULE_fecharParenteses = 15, RULE_senao = 16, 
		RULE_para = 17, RULE_enquanto = 18, RULE_expressao = 19, RULE_exprLogica = 20, 
		RULE_retorna = 21;
	public static final String[] ruleNames = {
		"prog", "declarVar", "tipo", "atribuicao", "declarConst", "funcPrincipal", 
		"declarFunc", "parametro", "comandos", "sair", "ler", "escrever", "chamadaDeFunc", 
		"argumentos", "decisao", "fecharParenteses", "senao", "para", "enquanto", 
		"expressao", "exprLogica", "retorna"
	};

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

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
			setState(44); match(PROGRAMA);
			setState(45); match(ID);
			setState(46); match(PONTO_E_VIRGULA);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(49);
					switch (_input.LA(1)) {
					case INTEIRO:
					case LOGICO:
					case PALAVRA:
					case REAL:
						{
						setState(47); declarVar();
						}
						break;
					case CONSTANTE:
						{
						setState(48); declarConst();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(54); declarFunc();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(60); funcPrincipal();
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
			setState(62); tipo();
			setState(63); match(DOIS_PONTOS);
			setState(64); match(ID);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(65); match(VIRGULA);
				setState(66); match(ID);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72); match(PONTO_E_VIRGULA);
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
			setState(82);
			switch (_input.LA(1)) {
			case INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(74); match(INTEIRO);
				((TipoContext)_localctx).t =  1;
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); match(REAL);
				((TipoContext)_localctx).t =  2;
				}
				break;
			case LOGICO:
				enterOuterAlt(_localctx, 3);
				{
				setState(78); match(LOGICO);
				((TipoContext)_localctx).t =  3;
				}
				break;
			case PALAVRA:
				enterOuterAlt(_localctx, 4);
				{
				setState(80); match(PALAVRA);
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
		public ExprLogicaContext exprLogica() {
			return getRuleContext(ExprLogicaContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
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
				setState(84); match(ID);
				setState(85); match(IGUAL);
				setState(86); expressao(0);
				setState(87); match(PONTO_E_VIRGULA);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89); match(ID);
				setState(90); match(IGUAL);
				setState(91); exprLogica(0);
				setState(92); match(PONTO_E_VIRGULA);
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
		public RetornaContext retorna() {
			return getRuleContext(RetornaContext.class,0);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(INTEIRO);
			setState(101); match(PRINCIPAL);
			setState(102); match(ABRE_PARENTESES);
			setState(103); match(FECHA_PARENTESES);
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
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(112); comandos();
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(118); retorna();
			setState(119); match(FECHA_CHAVES);
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
		public RetornaContext retorna() {
			return getRuleContext(RetornaContext.class,0);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121); tipo();
			setState(122); match(ID);
			setState(123); match(ABRE_PARENTESES);
			setState(132);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(124); parametro();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(125); match(VIRGULA);
					setState(126); parametro();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(134); match(FECHA_PARENTESES);
			setState(135); match(ABRE_CHAVES);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(138);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(136); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(137); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(143); comandos();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(149); retorna();
			setState(150); match(FECHA_CHAVES);
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
			setState(152); tipo();
			setState(153); match(ID);
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
		public SairContext sair() {
			return getRuleContext(SairContext.class,0);
		}
		public LerContext ler() {
			return getRuleContext(LerContext.class,0);
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
			setState(163);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); atribuicao();
				}
				break;
			case LER:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); ler();
				}
				break;
			case ESCREVER:
				enterOuterAlt(_localctx, 3);
				{
				setState(157); escrever();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(158); decisao();
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 5);
				{
				setState(159); para();
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 6);
				{
				setState(160); enquanto();
				}
				break;
			case RETORNO:
				enterOuterAlt(_localctx, 7);
				{
				setState(161); retorna();
				}
				break;
			case SAIR:
				enterOuterAlt(_localctx, 8);
				{
				setState(162); sair();
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

	public static class SairContext extends ParserRuleContext {
		public SairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterSair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitSair(this);
		}
	}

	public final SairContext sair() throws RecognitionException {
		SairContext _localctx = new SairContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(SAIR);
			setState(166); match(PONTO_E_VIRGULA);
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
		enterRule(_localctx, 20, RULE_ler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(LER);
			setState(169); match(ABRE_PARENTESES);
			setState(170); match(ID);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(171); match(VIRGULA);
				setState(172); match(ID);
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178); match(FECHA_PARENTESES);
			setState(179); match(PONTO_E_VIRGULA);
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
		enterRule(_localctx, 22, RULE_escrever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(ESCREVER);
			setState(182); match(ABRE_PARENTESES);
			setState(183); argumentos();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(184); match(VIRGULA);
				setState(185); argumentos();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191); match(FECHA_PARENTESES);
			setState(192); match(PONTO_E_VIRGULA);
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
		enterRule(_localctx, 24, RULE_chamadaDeFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(ID);
			setState(195); match(ABRE_PARENTESES);
			setState(204);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABRE_PARENTESES) | (1L << BOOLEANO) | (1L << CADEIA_DE_CARACTERES) | (1L << NEGACAO) | (1L << NUM_INTEIRO) | (1L << NUM_REAL) | (1L << SUBTRACAO) | (1L << ID))) != 0)) {
				{
				setState(196); argumentos();
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(197); match(VIRGULA);
					setState(198); argumentos();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(206); match(FECHA_PARENTESES);
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
		enterRule(_localctx, 26, RULE_argumentos);
		try {
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208); expressao(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); exprLogica(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210); chamadaDeFunc();
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
		public SenaoContext senao() {
			return getRuleContext(SenaoContext.class,0);
		}
		public FecharParentesesContext fecharParenteses() {
			return getRuleContext(FecharParentesesContext.class,0);
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
		enterRule(_localctx, 28, RULE_decisao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(SE);
			setState(214); match(ABRE_PARENTESES);
			setState(215); exprLogica(0);
			setState(216); fecharParenteses();
			setState(217); match(ABRE_CHAVES);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(218); comandos();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224); match(FECHA_CHAVES);
			setState(226);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(225); senao();
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

	public static class FecharParentesesContext extends ParserRuleContext {
		public TerminalNode FECHA_PARENTESES() { return getToken(PortugolParser.FECHA_PARENTESES, 0); }
		public FecharParentesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fecharParenteses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterFecharParenteses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitFecharParenteses(this);
		}
	}

	public final FecharParentesesContext fecharParenteses() throws RecognitionException {
		FecharParentesesContext _localctx = new FecharParentesesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fecharParenteses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(FECHA_PARENTESES);
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

	public static class SenaoContext extends ParserRuleContext {
		public ComandosContext comandos(int i) {
			return getRuleContext(ComandosContext.class,i);
		}
		public List<ComandosContext> comandos() {
			return getRuleContexts(ComandosContext.class);
		}
		public SenaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).enterSenao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PortugolListener ) ((PortugolListener)listener).exitSenao(this);
		}
	}

	public final SenaoContext senao() throws RecognitionException {
		SenaoContext _localctx = new SenaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_senao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(SENAO);
			setState(231); match(ABRE_CHAVES);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(232); comandos();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238); match(FECHA_CHAVES);
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
		enterRule(_localctx, 34, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(PARA);
			setState(241); match(ID);
			setState(242); match(DE);
			setState(243); expressao(0);
			setState(244); match(ATE);
			setState(245); expressao(0);
			setState(248);
			_la = _input.LA(1);
			if (_la==PASSO) {
				{
				setState(246); match(PASSO);
				setState(247); expressao(0);
				}
			}

			setState(250); match(ABRE_CHAVES);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(251); comandos();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257); match(FECHA_CHAVES);
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
		public FecharParentesesContext fecharParenteses() {
			return getRuleContext(FecharParentesesContext.class,0);
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
		enterRule(_localctx, 36, RULE_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(ENQUANTO);
			setState(260); match(ABRE_PARENTESES);
			setState(261); exprLogica(0);
			setState(262); fecharParenteses();
			setState(263); match(ABRE_CHAVES);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(264); comandos();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270); match(FECHA_CHAVES);
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
		public Token valor;
		public Token op;
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public TerminalNode ID() { return getToken(PortugolParser.ID, 0); }
		public TerminalNode CADEIA_DE_CARACTERES() { return getToken(PortugolParser.CADEIA_DE_CARACTERES, 0); }
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
		int _startState = 38;
		enterRecursionRule(_localctx, RULE_expressao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(273); match(SUBTRACAO);
				setState(274); expressao(9);
				}
				break;

			case 2:
				{
				setState(275); match(ABRE_PARENTESES);
				setState(276); expressao(0);
				setState(277); match(FECHA_PARENTESES);
				}
				break;

			case 3:
				{
				setState(279); ((ExpressaoContext)_localctx).valor = match(NUM_INTEIRO);
				}
				break;

			case 4:
				{
				setState(280); ((ExpressaoContext)_localctx).valor = match(NUM_REAL);
				}
				break;

			case 5:
				{
				setState(281); chamadaDeFunc();
				}
				break;

			case 6:
				{
				setState(282); ((ExpressaoContext)_localctx).valor = match(CADEIA_DE_CARACTERES);
				}
				break;

			case 7:
				{
				setState(283); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(292);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(286);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(287);
						((ExpressaoContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==DIVIDIR || _la==MULTIPLICACAO) ) {
							((ExpressaoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(288); expressao(9);
						}
						break;

					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(289);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(290);
						((ExpressaoContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SOMA || _la==SUBTRACAO) ) {
							((ExpressaoContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(291); expressao(8);
						}
						break;
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public Token op;
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
		public TerminalNode BOOLEANO() { return getToken(PortugolParser.BOOLEANO, 0); }
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
		int _startState = 40;
		enterRecursionRule(_localctx, RULE_exprLogica);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(298); match(NEGACAO);
				setState(299); exprLogica(6);
				}
				break;

			case 2:
				{
				setState(300); match(ABRE_PARENTESES);
				setState(301); exprLogica(0);
				setState(302); match(FECHA_PARENTESES);
				}
				break;

			case 3:
				{
				setState(304); expressao(0);
				setState(305);
				((ExprLogicaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OPERADORES_IGUALDADES || _la==OPERADORES_SUPERIORIDADE) ) {
					((ExprLogicaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(306); expressao(0);
				}
				break;

			case 4:
				{
				setState(308); match(BOOLEANO);
				}
				break;

			case 5:
				{
				setState(309); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprLogicaContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
					setState(312);
					if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
					setState(313); match(OPERADORES_IGUALDADES);
					setState(314); exprLogica(5);
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
		enterRule(_localctx, 42, RULE_retorna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320); match(RETORNO);
			setState(321); match(ABRE_PARENTESES);
			setState(322); expressao(0);
			setState(323); match(FECHA_PARENTESES);
			setState(324); match(PONTO_E_VIRGULA);
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
		case 19: return expressao_sempred((ExpressaoContext)_localctx, predIndex);

		case 20: return exprLogica_sempred((ExprLogicaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprLogica_sempred(ExprLogicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return 4 >= _localctx._p;
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\u0149\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\7\2\64\n\2\f\2\16\2\67\13\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4U\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7\7"+
		"\7t\n\7\f\7\16\7w\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0082\n"+
		"\b\f\b\16\b\u0085\13\b\5\b\u0087\n\b\3\b\3\b\3\b\3\b\7\b\u008d\n\b\f\b"+
		"\16\b\u0090\13\b\3\b\7\b\u0093\n\b\f\b\16\b\u0096\13\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a6\n\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u00b0\n\f\f\f\16\f\u00b3\13\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u00bd\n\r\f\r\16\r\u00c0\13\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\7\16\u00ca\n\16\f\16\16\16\u00cd\13\16\5\16\u00cf\n"+
		"\16\3\16\3\16\3\17\3\17\3\17\5\17\u00d6\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00de\n\20\f\20\16\20\u00e1\13\20\3\20\3\20\5\20\u00e5\n\20"+
		"\3\21\3\21\3\22\3\22\3\22\7\22\u00ec\n\22\f\22\16\22\u00ef\13\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fb\n\23\3\23\3\23"+
		"\7\23\u00ff\n\23\f\23\16\23\u0102\13\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u010c\n\24\f\24\16\24\u010f\13\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u011f\n\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0127\n\25\f\25\16\25\u012a\13\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0139"+
		"\n\26\3\26\3\26\3\26\7\26\u013e\n\26\f\26\16\26\u0141\13\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,\2\5\4\2\13\13\30\30\3\2()\3\2\34\35\u0162\2.\3\2\2\2\4@\3\2\2"+
		"\2\6T\3\2\2\2\b`\3\2\2\2\nb\3\2\2\2\ff\3\2\2\2\16{\3\2\2\2\20\u009a\3"+
		"\2\2\2\22\u00a5\3\2\2\2\24\u00a7\3\2\2\2\26\u00aa\3\2\2\2\30\u00b7\3\2"+
		"\2\2\32\u00c4\3\2\2\2\34\u00d5\3\2\2\2\36\u00d7\3\2\2\2 \u00e6\3\2\2\2"+
		"\"\u00e8\3\2\2\2$\u00f2\3\2\2\2&\u0105\3\2\2\2(\u011e\3\2\2\2*\u0138\3"+
		"\2\2\2,\u0142\3\2\2\2./\7$\2\2/\60\7-\2\2\60\65\7\"\2\2\61\64\5\4\3\2"+
		"\62\64\5\n\6\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5\16\b\298\3\2\2\2:=\3\2\2"+
		"\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\5\f\7\2?\3\3\2\2\2@A\5\6"+
		"\4\2AB\7\f\2\2BG\7-\2\2CD\7*\2\2DF\7-\2\2EC\3\2\2\2FI\3\2\2\2GE\3\2\2"+
		"\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\"\2\2K\5\3\2\2\2LM\7\25\2\2MU\b\4"+
		"\1\2NO\7%\2\2OU\b\4\1\2PQ\7\27\2\2QU\b\4\1\2RS\7\36\2\2SU\b\4\1\2TL\3"+
		"\2\2\2TN\3\2\2\2TP\3\2\2\2TR\3\2\2\2U\7\3\2\2\2VW\7-\2\2WX\7\22\2\2XY"+
		"\5(\25\2YZ\7\"\2\2Za\3\2\2\2[\\\7-\2\2\\]\7\22\2\2]^\5*\26\2^_\7\"\2\2"+
		"_a\3\2\2\2`V\3\2\2\2`[\3\2\2\2a\t\3\2\2\2bc\7\t\2\2cd\5\6\4\2de\5\b\5"+
		"\2e\13\3\2\2\2fg\7\25\2\2gh\7#\2\2hi\7\5\2\2ij\7\21\2\2jo\7\3\2\2kn\5"+
		"\4\3\2ln\5\n\6\2mk\3\2\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pu\3"+
		"\2\2\2qo\3\2\2\2rt\5\22\n\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx"+
		"\3\2\2\2wu\3\2\2\2xy\5,\27\2yz\7\17\2\2z\r\3\2\2\2{|\5\6\4\2|}\7-\2\2"+
		"}\u0086\7\5\2\2~\u0083\5\20\t\2\177\u0080\7*\2\2\u0080\u0082\5\20\t\2"+
		"\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0086~\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\21\2\2\u0089\u008e\7"+
		"\3\2\2\u008a\u008d\5\4\3\2\u008b\u008d\5\n\6\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0094\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093\5\22\n\2\u0092"+
		"\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\5,\27\2\u0098"+
		"\u0099\7\17\2\2\u0099\17\3\2\2\2\u009a\u009b\5\6\4\2\u009b\u009c\7-\2"+
		"\2\u009c\21\3\2\2\2\u009d\u00a6\5\b\5\2\u009e\u00a6\5\26\f\2\u009f\u00a6"+
		"\5\30\r\2\u00a0\u00a6\5\36\20\2\u00a1\u00a6\5$\23\2\u00a2\u00a6\5&\24"+
		"\2\u00a3\u00a6\5,\27\2\u00a4\u00a6\5\24\13\2\u00a5\u009d\3\2\2\2\u00a5"+
		"\u009e\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2"+
		"\2\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\23\3\2\2\2\u00a7\u00a8\7\'\2\2\u00a8\u00a9\7\"\2\2\u00a9\25\3\2\2\2\u00aa"+
		"\u00ab\7\26\2\2\u00ab\u00ac\7\5\2\2\u00ac\u00b1\7-\2\2\u00ad\u00ae\7*"+
		"\2\2\u00ae\u00b0\7-\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b5\7\21\2\2\u00b5\u00b6\7\"\2\2\u00b6\27\3\2\2\2\u00b7\u00b8"+
		"\7\16\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00be\5\34\17\2\u00ba\u00bb\7*\2\2"+
		"\u00bb\u00bd\5\34\17\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c2\7\21\2\2\u00c2\u00c3\7\"\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\7-\2"+
		"\2\u00c5\u00ce\7\5\2\2\u00c6\u00cb\5\34\17\2\u00c7\u00c8\7*\2\2\u00c8"+
		"\u00ca\5\34\17\2\u00c9\u00c7\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00c6\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\7\21"+
		"\2\2\u00d1\33\3\2\2\2\u00d2\u00d6\5(\25\2\u00d3\u00d6\5*\26\2\u00d4\u00d6"+
		"\5\32\16\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d6\35\3\2\2\2\u00d7\u00d8\7\23\2\2\u00d8\u00d9\7\5\2\2\u00d9\u00da"+
		"\5*\26\2\u00da\u00db\5 \21\2\u00db\u00df\7\3\2\2\u00dc\u00de\5\22\n\2"+
		"\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\7\17\2\2"+
		"\u00e3\u00e5\5\"\22\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\37"+
		"\3\2\2\2\u00e6\u00e7\7\21\2\2\u00e7!\3\2\2\2\u00e8\u00e9\7\24\2\2\u00e9"+
		"\u00ed\7\3\2\2\u00ea\u00ec\5\22\n\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3"+
		"\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f1\7\17\2\2\u00f1#\3\2\2\2\u00f2\u00f3\7\37\2"+
		"\2\u00f3\u00f4\7-\2\2\u00f4\u00f5\7\n\2\2\u00f5\u00f6\5(\25\2\u00f6\u00f7"+
		"\7\6\2\2\u00f7\u00fa\5(\25\2\u00f8\u00f9\7 \2\2\u00f9\u00fb\5(\25\2\u00fa"+
		"\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0100\7\3"+
		"\2\2\u00fd\u00ff\5\22\n\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0103\u0104\7\17\2\2\u0104%\3\2\2\2\u0105\u0106\7\r\2\2\u0106\u0107"+
		"\7\5\2\2\u0107\u0108\5*\26\2\u0108\u0109\5 \21\2\u0109\u010d\7\3\2\2\u010a"+
		"\u010c\5\22\n\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3"+
		"\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7\17\2\2\u0111\'\3\2\2\2\u0112\u0113\b\25\1\2\u0113\u0114\7)\2"+
		"\2\u0114\u011f\5(\25\2\u0115\u0116\7\5\2\2\u0116\u0117\5(\25\2\u0117\u0118"+
		"\7\21\2\2\u0118\u011f\3\2\2\2\u0119\u011f\7\32\2\2\u011a\u011f\7\33\2"+
		"\2\u011b\u011f\5\32\16\2\u011c\u011f\7\b\2\2\u011d\u011f\7-\2\2\u011e"+
		"\u0112\3\2\2\2\u011e\u0115\3\2\2\2\u011e\u0119\3\2\2\2\u011e\u011a\3\2"+
		"\2\2\u011e\u011b\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f"+
		"\u0128\3\2\2\2\u0120\u0121\6\25\2\3\u0121\u0122\t\2\2\2\u0122\u0127\5"+
		"(\25\2\u0123\u0124\6\25\3\3\u0124\u0125\t\3\2\2\u0125\u0127\5(\25\2\u0126"+
		"\u0120\3\2\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129)\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c"+
		"\b\26\1\2\u012c\u012d\7\31\2\2\u012d\u0139\5*\26\2\u012e\u012f\7\5\2\2"+
		"\u012f\u0130\5*\26\2\u0130\u0131\7\21\2\2\u0131\u0139\3\2\2\2\u0132\u0133"+
		"\5(\25\2\u0133\u0134\t\4\2\2\u0134\u0135\5(\25\2\u0135\u0139\3\2\2\2\u0136"+
		"\u0139\7\7\2\2\u0137\u0139\7-\2\2\u0138\u012b\3\2\2\2\u0138\u012e\3\2"+
		"\2\2\u0138\u0132\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013f\3\2\2\2\u013a\u013b\6\26\4\3\u013b\u013c\7\34\2\2\u013c\u013e\5"+
		"*\26\2\u013d\u013a\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140+\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7&\2\2\u0143"+
		"\u0144\7\5\2\2\u0144\u0145\5(\25\2\u0145\u0146\7\21\2\2\u0146\u0147\7"+
		"\"\2\2\u0147-\3\2\2\2!\63\65;GT`mou\u0083\u0086\u008c\u008e\u0094\u00a5"+
		"\u00b1\u00be\u00cb\u00ce\u00d5\u00df\u00e4\u00ed\u00fa\u0100\u010d\u011e"+
		"\u0126\u0128\u0138\u013f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}