// Generated from C:\Users\Luis Guilherme\Google Drive\UFPI\DISCIPLINAS\7º PERÍODO\CONSTRUÇÃO DE COMPILADORES - Raimundo Moura\Trabalho Final\Portugol.g4 by ANTLR 4.1

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
		RULE_comandos = 8, RULE_sair = 9, RULE_ler = 10, RULE_escrever = 11, RULE_chamadaDeFunc = 12, 
		RULE_argumentos = 13, RULE_decisao = 14, RULE_para = 15, RULE_enquanto = 16, 
		RULE_expressao = 17, RULE_exprLogica = 18, RULE_retorna = 19;
	public static final String[] ruleNames = {
		"prog", "declarVar", "tipo", "atribuicao", "declarConst", "funcPrincipal", 
		"declarFunc", "parametro", "comandos", "sair", "ler", "escrever", "chamadaDeFunc", 
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
			setState(40); match(PROGRAMA);
			setState(41); match(ID);
			setState(42); match(PONTO_E_VIRGULA);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					setState(45);
					switch (_input.LA(1)) {
					case INTEIRO:
					case LOGICO:
					case PALAVRA:
					case REAL:
						{
						setState(43); declarVar();
						}
						break;
					case CONSTANTE:
						{
						setState(44); declarConst();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(50); declarFunc();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(56); funcPrincipal();
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
			setState(58); tipo();
			setState(59); match(DOIS_PONTOS);
			setState(60); match(ID);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(61); match(VIRGULA);
				setState(62); match(ID);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); match(PONTO_E_VIRGULA);
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
			setState(78);
			switch (_input.LA(1)) {
			case INTEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); match(INTEIRO);
				((TipoContext)_localctx).t =  1;
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(72); match(REAL);
				((TipoContext)_localctx).t =  2;
				}
				break;
			case LOGICO:
				enterOuterAlt(_localctx, 3);
				{
				setState(74); match(LOGICO);
				((TipoContext)_localctx).t =  3;
				}
				break;
			case PALAVRA:
				enterOuterAlt(_localctx, 4);
				{
				setState(76); match(PALAVRA);
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
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80); match(ID);
				setState(81); match(IGUAL);
				setState(82); expressao(0);
				setState(83); match(PONTO_E_VIRGULA);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); match(ID);
				setState(86); match(IGUAL);
				setState(87); exprLogica(0);
				setState(88); match(PONTO_E_VIRGULA);
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
			setState(92); match(CONSTANTE);
			setState(93); tipo();
			setState(94); atribuicao();
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
			setState(96); match(INTEIRO);
			setState(97); match(PRINCIPAL);
			setState(98); match(ABRE_PARENTESIS);
			setState(99); match(FECHA_PARENTESIS);
			setState(100); match(ABRE_CHAVES);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(103);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(101); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(102); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(108); comandos();
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(114); retorna();
			setState(115); match(FECHA_CHAVES);
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
			setState(117); tipo();
			setState(118); match(ID);
			setState(119); match(ABRE_PARENTESIS);
			setState(128);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(120); parametro();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(121); match(VIRGULA);
					setState(122); parametro();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(130); match(FECHA_PARENTESIS);
			setState(131); match(ABRE_CHAVES);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(134);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(132); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(133); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(139); comandos();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(145); retorna();
			setState(146); match(FECHA_CHAVES);
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
			setState(148); tipo();
			setState(149); match(ID);
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
			setState(159);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(151); atribuicao();
				}
				break;
			case LER:
				enterOuterAlt(_localctx, 2);
				{
				setState(152); ler();
				}
				break;
			case ESCREVER:
				enterOuterAlt(_localctx, 3);
				{
				setState(153); escrever();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(154); decisao();
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 5);
				{
				setState(155); para();
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 6);
				{
				setState(156); enquanto();
				}
				break;
			case RETORNO:
				enterOuterAlt(_localctx, 7);
				{
				setState(157); retorna();
				}
				break;
			case SAIR:
				enterOuterAlt(_localctx, 8);
				{
				setState(158); sair();
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
			setState(161); match(SAIR);
			setState(162); match(PONTO_E_VIRGULA);
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
			setState(164); match(LER);
			setState(165); match(ABRE_PARENTESIS);
			setState(166); match(ID);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(167); match(VIRGULA);
				setState(168); match(ID);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174); match(FECHA_PARENTESIS);
			setState(175); match(PONTO_E_VIRGULA);
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
			setState(177); match(ESCREVER);
			setState(178); match(ABRE_PARENTESIS);
			setState(179); argumentos();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(180); match(VIRGULA);
				setState(181); argumentos();
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
			setState(190); match(ID);
			setState(191); match(ABRE_PARENTESIS);
			setState(200);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABRE_PARENTESIS) | (1L << BOOLEANO) | (1L << CADEIA_DE_CARACTERES) | (1L << NEGACAO) | (1L << NUM_INTEIRO) | (1L << NUM_REAL) | (1L << SUBTRACAO) | (1L << ID))) != 0)) {
				{
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
				}
			}

			setState(202); match(FECHA_PARENTESIS);
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
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); expressao(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); exprLogica(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); chamadaDeFunc();
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
		enterRule(_localctx, 28, RULE_decisao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(SE);
			setState(210); match(ABRE_PARENTESIS);
			setState(211); exprLogica(0);
			setState(212); match(FECHA_PARENTESIS);
			setState(213); match(ABRE_CHAVES);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(214); comandos();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220); match(FECHA_CHAVES);
			setState(230);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(221); match(SENAO);
				setState(222); match(ABRE_CHAVES);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
					{
					{
					setState(223); comandos();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229); match(FECHA_CHAVES);
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
		enterRule(_localctx, 30, RULE_para);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(PARA);
			setState(233); match(ID);
			setState(234); match(DE);
			setState(235); expressao(0);
			setState(236); match(ATE);
			setState(237); expressao(0);
			setState(240);
			_la = _input.LA(1);
			if (_la==PASSO) {
				{
				setState(238); match(PASSO);
				setState(239); expressao(0);
				}
			}

			setState(242); match(ABRE_CHAVES);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(243); comandos();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249); match(FECHA_CHAVES);
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
		enterRule(_localctx, 32, RULE_enquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(ENQUANTO);
			setState(252); match(ABRE_PARENTESIS);
			setState(253); exprLogica(0);
			setState(254); match(FECHA_PARENTESIS);
			setState(255); match(ABRE_CHAVES);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				{
				setState(256); comandos();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262); match(FECHA_CHAVES);
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
		public int t;
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
		int _startState = 34;
		enterRecursionRule(_localctx, RULE_expressao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(265); match(SUBTRACAO);
				setState(266); expressao(9);
				}
				break;

			case 2:
				{
				setState(267); match(ABRE_PARENTESIS);
				setState(268); expressao(0);
				setState(269); match(FECHA_PARENTESIS);
				}
				break;

			case 3:
				{
				setState(271); match(NUM_INTEIRO);
				((ExpressaoContext)_localctx).t =  1;
				}
				break;

			case 4:
				{
				setState(273); match(NUM_REAL);
				((ExpressaoContext)_localctx).t =  2;
				}
				break;

			case 5:
				{
				setState(275); chamadaDeFunc();
				}
				break;

			case 6:
				{
				setState(276); match(CADEIA_DE_CARACTERES);
				((ExpressaoContext)_localctx).t =  4;
				}
				break;

			case 7:
				{
				setState(278); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(281);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(282);
						_la = _input.LA(1);
						if ( !(_la==DIVIDIR || _la==MULTIPLICACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(283); expressao(9);
						}
						break;

					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(284);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(285);
						_la = _input.LA(1);
						if ( !(_la==SOMA || _la==SUBTRACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(286); expressao(8);
						}
						break;
					}
					} 
				}
				setState(291);
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
		int _startState = 36;
		enterRecursionRule(_localctx, RULE_exprLogica);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(293); match(NEGACAO);
				setState(294); exprLogica(6);
				}
				break;

			case 2:
				{
				setState(295); match(ABRE_PARENTESIS);
				setState(296); exprLogica(0);
				setState(297); match(FECHA_PARENTESIS);
				}
				break;

			case 3:
				{
				setState(299); expressao(0);
				setState(300);
				_la = _input.LA(1);
				if ( !(_la==OPERADORES_IGUALDADES || _la==OPERADORES_SUPERIORIDADE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(301); expressao(0);
				}
				break;

			case 4:
				{
				setState(303); match(BOOLEANO);
				}
				break;

			case 5:
				{
				setState(304); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(312);
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
					setState(307);
					if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
					setState(308); match(OPERADORES_IGUALDADES);
					setState(309); exprLogica(5);
					}
					} 
				}
				setState(314);
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
		enterRule(_localctx, 38, RULE_retorna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(RETORNO);
			setState(316); match(ABRE_PARENTESIS);
			setState(317); expressao(0);
			setState(318); match(FECHA_PARENTESIS);
			setState(319); match(PONTO_E_VIRGULA);
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
		case 17: return expressao_sempred((ExpressaoContext)_localctx, predIndex);

		case 18: return exprLogica_sempred((ExprLogicaContext)_localctx, predIndex);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\u0144\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\7\2\60\n\2\f\2\16\2"+
		"\63\13\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3"+
		"B\n\3\f\3\16\3E\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4Q\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\7\7p\n\7\f\7\16\7"+
		"s\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13"+
		"\b\5\b\u0083\n\b\3\b\3\b\3\b\3\b\7\b\u0089\n\b\f\b\16\b\u008c\13\b\3\b"+
		"\7\b\u008f\n\b\f\b\16\b\u0092\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00a2\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\7\f\u00ac\n\f\f\f\16\f\u00af\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00b9\n\r\f\r\16\r\u00bc\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7"+
		"\16\u00c6\n\16\f\16\16\16\u00c9\13\16\5\16\u00cb\n\16\3\16\3\16\3\17\3"+
		"\17\3\17\5\17\u00d2\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00da\n\20"+
		"\f\20\16\20\u00dd\13\20\3\20\3\20\3\20\3\20\7\20\u00e3\n\20\f\20\16\20"+
		"\u00e6\13\20\3\20\5\20\u00e9\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\5\21\u00f3\n\21\3\21\3\21\7\21\u00f7\n\21\f\21\16\21\u00fa\13\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0104\n\22\f\22\16\22\u0107"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u011a\n\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0122\n\23\f\23\16\23\u0125\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0134\n\24\3\24\3\24\3\24\7\24\u0139"+
		"\n\24\f\24\16\24\u013c\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\2\26\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\4\2\13\13\30\30\3\2()"+
		"\3\2\34\35\u015f\2*\3\2\2\2\4<\3\2\2\2\6P\3\2\2\2\b\\\3\2\2\2\n^\3\2\2"+
		"\2\fb\3\2\2\2\16w\3\2\2\2\20\u0096\3\2\2\2\22\u00a1\3\2\2\2\24\u00a3\3"+
		"\2\2\2\26\u00a6\3\2\2\2\30\u00b3\3\2\2\2\32\u00c0\3\2\2\2\34\u00d1\3\2"+
		"\2\2\36\u00d3\3\2\2\2 \u00ea\3\2\2\2\"\u00fd\3\2\2\2$\u0119\3\2\2\2&\u0133"+
		"\3\2\2\2(\u013d\3\2\2\2*+\7$\2\2+,\7-\2\2,\61\7\"\2\2-\60\5\4\3\2.\60"+
		"\5\n\6\2/-\3\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\67\3\2\2\2\63\61\3\2\2\2\64\66\5\16\b\2\65\64\3\2\2\2\669\3\2\2\2\67"+
		"\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\5\f\7\2;\3\3\2\2\2<=\5"+
		"\6\4\2=>\7\f\2\2>C\7-\2\2?@\7*\2\2@B\7-\2\2A?\3\2\2\2BE\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\"\2\2G\5\3\2\2\2HI\7\25\2\2IQ\b"+
		"\4\1\2JK\7%\2\2KQ\b\4\1\2LM\7\27\2\2MQ\b\4\1\2NO\7\36\2\2OQ\b\4\1\2PH"+
		"\3\2\2\2PJ\3\2\2\2PL\3\2\2\2PN\3\2\2\2Q\7\3\2\2\2RS\7-\2\2ST\7\22\2\2"+
		"TU\5$\23\2UV\7\"\2\2V]\3\2\2\2WX\7-\2\2XY\7\22\2\2YZ\5&\24\2Z[\7\"\2\2"+
		"[]\3\2\2\2\\R\3\2\2\2\\W\3\2\2\2]\t\3\2\2\2^_\7\t\2\2_`\5\6\4\2`a\5\b"+
		"\5\2a\13\3\2\2\2bc\7\25\2\2cd\7#\2\2de\7\5\2\2ef\7\21\2\2fk\7\3\2\2gj"+
		"\5\4\3\2hj\5\n\6\2ig\3\2\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l"+
		"q\3\2\2\2mk\3\2\2\2np\5\22\n\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"rt\3\2\2\2sq\3\2\2\2tu\5(\25\2uv\7\17\2\2v\r\3\2\2\2wx\5\6\4\2xy\7-\2"+
		"\2y\u0082\7\5\2\2z\177\5\20\t\2{|\7*\2\2|~\5\20\t\2}{\3\2\2\2~\u0081\3"+
		"\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0082z\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\7\21\2\2\u0085\u008a\7\3\2\2\u0086\u0089\5\4\3\2\u0087\u0089\5\n\6\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0090\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008f\5\22\n\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\5(\25\2\u0094\u0095\7\17\2\2\u0095\17\3\2\2\2\u0096\u0097\5\6\4"+
		"\2\u0097\u0098\7-\2\2\u0098\21\3\2\2\2\u0099\u00a2\5\b\5\2\u009a\u00a2"+
		"\5\26\f\2\u009b\u00a2\5\30\r\2\u009c\u00a2\5\36\20\2\u009d\u00a2\5 \21"+
		"\2\u009e\u00a2\5\"\22\2\u009f\u00a2\5(\25\2\u00a0\u00a2\5\24\13\2\u00a1"+
		"\u0099\3\2\2\2\u00a1\u009a\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1\u009c\3\2"+
		"\2\2\u00a1\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\23\3\2\2\2\u00a3\u00a4\7\'\2\2\u00a4\u00a5\7\"\2"+
		"\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\26\2\2\u00a7\u00a8\7\5\2\2\u00a8\u00ad"+
		"\7-\2\2\u00a9\u00aa\7*\2\2\u00aa\u00ac\7-\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\21\2\2\u00b1\u00b2\7\"\2\2\u00b2"+
		"\27\3\2\2\2\u00b3\u00b4\7\16\2\2\u00b4\u00b5\7\5\2\2\u00b5\u00ba\5\34"+
		"\17\2\u00b6\u00b7\7*\2\2\u00b7\u00b9\5\34\17\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7\21\2\2\u00be\u00bf\7\"\2\2\u00bf"+
		"\31\3\2\2\2\u00c0\u00c1\7-\2\2\u00c1\u00ca\7\5\2\2\u00c2\u00c7\5\34\17"+
		"\2\u00c3\u00c4\7*\2\2\u00c4\u00c6\5\34\17\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00c2\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\7\21\2\2\u00cd\33\3\2\2\2\u00ce\u00d2\5$\23"+
		"\2\u00cf\u00d2\5&\24\2\u00d0\u00d2\5\32\16\2\u00d1\u00ce\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d4\7\23\2"+
		"\2\u00d4\u00d5\7\5\2\2\u00d5\u00d6\5&\24\2\u00d6\u00d7\7\21\2\2\u00d7"+
		"\u00db\7\3\2\2\u00d8\u00da\5\22\n\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3"+
		"\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e8\7\17\2\2\u00df\u00e0\7\24\2\2\u00e0\u00e4\7"+
		"\3\2\2\u00e1\u00e3\5\22\n\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00e9\7\17\2\2\u00e8\u00df\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\37\3\2\2\2\u00ea\u00eb\7\37\2\2\u00eb\u00ec\7-\2\2\u00ec\u00ed\7\n\2"+
		"\2\u00ed\u00ee\5$\23\2\u00ee\u00ef\7\6\2\2\u00ef\u00f2\5$\23\2\u00f0\u00f1"+
		"\7 \2\2\u00f1\u00f3\5$\23\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f8\7\3\2\2\u00f5\u00f7\5\22\n\2\u00f6\u00f5\3"+
		"\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\17\2\2\u00fc!\3\2\2\2"+
		"\u00fd\u00fe\7\r\2\2\u00fe\u00ff\7\5\2\2\u00ff\u0100\5&\24\2\u0100\u0101"+
		"\7\21\2\2\u0101\u0105\7\3\2\2\u0102\u0104\5\22\n\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\17\2\2\u0109#\3\2\2\2\u010a"+
		"\u010b\b\23\1\2\u010b\u010c\7)\2\2\u010c\u011a\5$\23\2\u010d\u010e\7\5"+
		"\2\2\u010e\u010f\5$\23\2\u010f\u0110\7\21\2\2\u0110\u011a\3\2\2\2\u0111"+
		"\u0112\7\32\2\2\u0112\u011a\b\23\1\2\u0113\u0114\7\33\2\2\u0114\u011a"+
		"\b\23\1\2\u0115\u011a\5\32\16\2\u0116\u0117\7\b\2\2\u0117\u011a\b\23\1"+
		"\2\u0118\u011a\7-\2\2\u0119\u010a\3\2\2\2\u0119\u010d\3\2\2\2\u0119\u0111"+
		"\3\2\2\2\u0119\u0113\3\2\2\2\u0119\u0115\3\2\2\2\u0119\u0116\3\2\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u0123\3\2\2\2\u011b\u011c\6\23\2\3\u011c\u011d\t"+
		"\2\2\2\u011d\u0122\5$\23\2\u011e\u011f\6\23\3\3\u011f\u0120\t\3\2\2\u0120"+
		"\u0122\5$\23\2\u0121\u011b\3\2\2\2\u0121\u011e\3\2\2\2\u0122\u0125\3\2"+
		"\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124%\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0126\u0127\b\24\1\2\u0127\u0128\7\31\2\2\u0128\u0134\5&\24\2"+
		"\u0129\u012a\7\5\2\2\u012a\u012b\5&\24\2\u012b\u012c\7\21\2\2\u012c\u0134"+
		"\3\2\2\2\u012d\u012e\5$\23\2\u012e\u012f\t\4\2\2\u012f\u0130\5$\23\2\u0130"+
		"\u0134\3\2\2\2\u0131\u0134\7\7\2\2\u0132\u0134\7-\2\2\u0133\u0126\3\2"+
		"\2\2\u0133\u0129\3\2\2\2\u0133\u012d\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0132\3\2\2\2\u0134\u013a\3\2\2\2\u0135\u0136\6\24\4\3\u0136\u0137\7"+
		"\34\2\2\u0137\u0139\5&\24\2\u0138\u0135\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\'\3\2\2\2\u013c\u013a\3\2\2\2"+
		"\u013d\u013e\7&\2\2\u013e\u013f\7\5\2\2\u013f\u0140\5$\23\2\u0140\u0141"+
		"\7\21\2\2\u0141\u0142\7\"\2\2\u0142)\3\2\2\2!/\61\67CP\\ikq\177\u0082"+
		"\u0088\u008a\u0090\u00a1\u00ad\u00ba\u00c7\u00ca\u00d1\u00db\u00e4\u00e8"+
		"\u00f2\u00f8\u0105\u0119\u0121\u0123\u0133\u013a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}