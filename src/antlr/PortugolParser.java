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
			enterOuterAlt(_localctx, 1);
			{
			setState(78); match(ID);
			setState(79); match(IGUAL);
			setState(82);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(80); expressao(0);
				}
				break;

			case 2:
				{
				setState(81); exprLogica(0);
				}
				break;
			}
			setState(84); match(PONTO_E_VIRGULA);
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
			setState(86); match(CONSTANTE);
			setState(87); tipo();
			setState(88); atribuicao();
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
			setState(90); match(INTEIRO);
			setState(91); match(PRINCIPAL);
			setState(92); match(ABRE_PARENTESIS);
			setState(93); match(FECHA_PARENTESIS);
			setState(94); match(ABRE_CHAVES);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(97);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(95); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(96); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(102); comandos();
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(108); retorna();
			setState(109); match(FECHA_CHAVES);
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
			setState(111); tipo();
			setState(112); match(ID);
			setState(113); match(ABRE_PARENTESIS);
			setState(122);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(114); parametro();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(115); match(VIRGULA);
					setState(116); parametro();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(124); match(FECHA_PARENTESIS);
			setState(125); match(ABRE_CHAVES);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONSTANTE) | (1L << INTEIRO) | (1L << LOGICO) | (1L << PALAVRA) | (1L << REAL))) != 0)) {
				{
				setState(128);
				switch (_input.LA(1)) {
				case INTEIRO:
				case LOGICO:
				case PALAVRA:
				case REAL:
					{
					setState(126); declarVar();
					}
					break;
				case CONSTANTE:
					{
					setState(127); declarConst();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(133); comandos();
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(139); retorna();
			setState(140); match(FECHA_CHAVES);
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
			setState(142); tipo();
			setState(143); match(ID);
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
			setState(152);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(145); atribuicao();
				}
				break;
			case LER:
				enterOuterAlt(_localctx, 2);
				{
				setState(146); ler();
				}
				break;
			case ESCREVER:
				enterOuterAlt(_localctx, 3);
				{
				setState(147); escrever();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(148); decisao();
				}
				break;
			case PARA:
				enterOuterAlt(_localctx, 5);
				{
				setState(149); para();
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 6);
				{
				setState(150); enquanto();
				}
				break;
			case RETORNO:
				enterOuterAlt(_localctx, 7);
				{
				setState(151); retorna();
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
			setState(154); match(LER);
			setState(155); match(ABRE_PARENTESIS);
			setState(156); match(ID);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(157); match(VIRGULA);
				setState(158); match(ID);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164); match(FECHA_PARENTESIS);
			setState(165); match(PONTO_E_VIRGULA);
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
			setState(167); match(ESCREVER);
			setState(168); match(ABRE_PARENTESIS);
			setState(169); argumentos();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(170); match(VIRGULA);
				setState(171); argumentos();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177); match(FECHA_PARENTESIS);
			setState(178); match(PONTO_E_VIRGULA);
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
			setState(180); match(ID);
			setState(181); match(ABRE_PARENTESIS);
			setState(190);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABRE_PARENTESIS) | (1L << BOOLEANO) | (1L << CADEIA_DE_CARACTERES) | (1L << NEGACAO) | (1L << NUM_INTEIRO) | (1L << NUM_REAL) | (1L << SUBTRACAO) | (1L << ID))) != 0)) {
				{
				setState(182); argumentos();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(183); match(VIRGULA);
					setState(184); argumentos();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(192); match(FECHA_PARENTESIS);
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
		enterRule(_localctx, 24, RULE_argumentos);
		try {
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194); expressao(0);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); exprLogica(0);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196); chamadaDeFunc();
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
			setState(199); match(SE);
			setState(200); match(ABRE_PARENTESIS);
			setState(201); exprLogica(0);
			setState(202); match(FECHA_PARENTESIS);
			setState(203); match(ABRE_CHAVES);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
				{
				{
				setState(204); comandos();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210); match(FECHA_CHAVES);
			setState(220);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(211); match(SENAO);
				setState(212); match(ABRE_CHAVES);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << ID))) != 0)) {
					{
					{
					setState(213); comandos();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219); match(FECHA_CHAVES);
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
			setState(222); match(PARA);
			setState(223); match(ID);
			setState(224); match(DE);
			setState(225); expressao(0);
			setState(226); match(ATE);
			setState(227); expressao(0);
			setState(230);
			_la = _input.LA(1);
			if (_la==PASSO) {
				{
				setState(228); match(PASSO);
				setState(229); expressao(0);
				}
			}

			setState(232); match(ABRE_CHAVES);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				setState(236);
				switch (_input.LA(1)) {
				case ENQUANTO:
				case ESCREVER:
				case SE:
				case LER:
				case PARA:
				case RETORNO:
				case ID:
					{
					setState(233); comandos();
					}
					break;
				case SAIR:
					{
					setState(234); match(SAIR);
					setState(235); match(PONTO_E_VIRGULA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241); match(FECHA_CHAVES);
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
			setState(243); match(ENQUANTO);
			setState(244); match(ABRE_PARENTESIS);
			setState(245); exprLogica(0);
			setState(246); match(FECHA_PARENTESIS);
			setState(247); match(ABRE_CHAVES);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENQUANTO) | (1L << ESCREVER) | (1L << SE) | (1L << LER) | (1L << PARA) | (1L << RETORNO) | (1L << SAIR) | (1L << ID))) != 0)) {
				{
				setState(251);
				switch (_input.LA(1)) {
				case ENQUANTO:
				case ESCREVER:
				case SE:
				case LER:
				case PARA:
				case RETORNO:
				case ID:
					{
					setState(248); comandos();
					}
					break;
				case SAIR:
					{
					setState(249); match(SAIR);
					setState(250); match(PONTO_E_VIRGULA);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256); match(FECHA_CHAVES);
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
		public TerminalNode CADEIA_DE_CARACTERES() { return getToken(PortugolParser.CADEIA_DE_CARACTERES, 0); }
		public TerminalNode NUM_REAL() { return getToken(PortugolParser.NUM_REAL, 0); }
		public ChamadaDeFuncContext chamadaDeFunc() {
			return getRuleContext(ChamadaDeFuncContext.class,0);
		}
		public TerminalNode BOOLEANO() { return getToken(PortugolParser.BOOLEANO, 0); }
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
			setState(271);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(259); match(SUBTRACAO);
				setState(260); expressao(10);
				}
				break;

			case 2:
				{
				setState(261); match(ABRE_PARENTESIS);
				setState(262); expressao(0);
				setState(263); match(FECHA_PARENTESIS);
				}
				break;

			case 3:
				{
				setState(265); match(NUM_INTEIRO);
				}
				break;

			case 4:
				{
				setState(266); match(NUM_REAL);
				}
				break;

			case 5:
				{
				setState(267); chamadaDeFunc();
				}
				break;

			case 6:
				{
				setState(268); match(CADEIA_DE_CARACTERES);
				}
				break;

			case 7:
				{
				setState(269); match(BOOLEANO);
				}
				break;

			case 8:
				{
				setState(270); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(279);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(273);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(274);
						_la = _input.LA(1);
						if ( !(_la==DIVIDIR || _la==MULTIPLICACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(275); expressao(10);
						}
						break;

					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(276);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(277);
						_la = _input.LA(1);
						if ( !(_la==SOMA || _la==SUBTRACAO) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(278); expressao(9);
						}
						break;
					}
					} 
				}
				setState(283);
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
			setState(292);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(285); match(NEGACAO);
				setState(286); exprLogica(4);
				}
				break;

			case 2:
				{
				setState(287); expressao(0);
				setState(288);
				_la = _input.LA(1);
				if ( !(_la==OPERADORES_IGUALDADES || _la==OPERADORES_SUPERIORIDADE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(289); expressao(0);
				}
				break;

			case 3:
				{
				setState(291); match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprLogicaContext(_parentctx, _parentState, _p);
					pushNewRecursionContext(_localctx, _startState, RULE_exprLogica);
					setState(294);
					if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
					setState(295); match(OPERADORES_IGUALDADES);
					setState(296); exprLogica(4);
					}
					} 
				}
				setState(301);
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
		enterRule(_localctx, 36, RULE_retorna);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); match(RETORNO);
			setState(303); match(ABRE_PARENTESIS);
			setState(304); expressao(0);
			setState(305); match(FECHA_PARENTESIS);
			setState(306); match(PONTO_E_VIRGULA);
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
		case 0: return 9 >= _localctx._p;

		case 1: return 8 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\u0137\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3\2"+
		"\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3@\n\3\f\3"+
		"\16\3C\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\5\3\5\3"+
		"\5\3\5\5\5U\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7"+
		"\7d\n\7\f\7\16\7g\13\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\bx\n\b\f\b\16\b{\13\b\5\b}\n\b\3\b\3\b\3\b\3\b\7\b"+
		"\u0083\n\b\f\b\16\b\u0086\13\b\3\b\7\b\u0089\n\b\f\b\16\b\u008c\13\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00a2\n\13\f\13\16\13\u00a5\13\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u00af\n\f\f\f\16\f\u00b2\13\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\7\r\u00bc\n\r\f\r\16\r\u00bf\13\r\5\r\u00c1\n\r"+
		"\3\r\3\r\3\16\3\16\3\16\5\16\u00c8\n\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00d0\n\17\f\17\16\17\u00d3\13\17\3\17\3\17\3\17\3\17\7\17\u00d9"+
		"\n\17\f\17\16\17\u00dc\13\17\3\17\5\17\u00df\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00e9\n\20\3\20\3\20\3\20\3\20\7\20\u00ef\n"+
		"\20\f\20\16\20\u00f2\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00fe\n\21\f\21\16\21\u0101\13\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0112\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u011a\n\22\f\22\16\22\u011d\13\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0127\n\23\3\23\3\23\3\23\7\23"+
		"\u012c\n\23\f\23\16\23\u012f\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\4\2\13\13\30\30"+
		"\3\2()\3\2\34\35\u0153\2(\3\2\2\2\4:\3\2\2\2\6N\3\2\2\2\bP\3\2\2\2\nX"+
		"\3\2\2\2\f\\\3\2\2\2\16q\3\2\2\2\20\u0090\3\2\2\2\22\u009a\3\2\2\2\24"+
		"\u009c\3\2\2\2\26\u00a9\3\2\2\2\30\u00b6\3\2\2\2\32\u00c7\3\2\2\2\34\u00c9"+
		"\3\2\2\2\36\u00e0\3\2\2\2 \u00f5\3\2\2\2\"\u0111\3\2\2\2$\u0126\3\2\2"+
		"\2&\u0130\3\2\2\2()\7$\2\2)*\7-\2\2*/\7\"\2\2+.\5\4\3\2,.\5\n\6\2-+\3"+
		"\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\65\3\2\2\2\61/\3"+
		"\2\2\2\62\64\5\16\b\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5\f\7\29\3\3\2\2\2:;\5\6\4\2;<\7"+
		"\f\2\2<A\7-\2\2=>\7*\2\2>@\7-\2\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2BD\3\2\2\2CA\3\2\2\2DE\7\"\2\2E\5\3\2\2\2FG\7\25\2\2GO\b\4\1\2HI\7"+
		"%\2\2IO\b\4\1\2JK\7\27\2\2KO\b\4\1\2LM\7\36\2\2MO\b\4\1\2NF\3\2\2\2NH"+
		"\3\2\2\2NJ\3\2\2\2NL\3\2\2\2O\7\3\2\2\2PQ\7-\2\2QT\7\22\2\2RU\5\"\22\2"+
		"SU\5$\23\2TR\3\2\2\2TS\3\2\2\2UV\3\2\2\2VW\7\"\2\2W\t\3\2\2\2XY\7\t\2"+
		"\2YZ\5\6\4\2Z[\5\b\5\2[\13\3\2\2\2\\]\7\25\2\2]^\7#\2\2^_\7\5\2\2_`\7"+
		"\21\2\2`e\7\3\2\2ad\5\4\3\2bd\5\n\6\2ca\3\2\2\2cb\3\2\2\2dg\3\2\2\2ec"+
		"\3\2\2\2ef\3\2\2\2fk\3\2\2\2ge\3\2\2\2hj\5\22\n\2ih\3\2\2\2jm\3\2\2\2"+
		"ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\5&\24\2op\7\17\2\2p\r\3\2\2"+
		"\2qr\5\6\4\2rs\7-\2\2s|\7\5\2\2ty\5\20\t\2uv\7*\2\2vx\5\20\t\2wu\3\2\2"+
		"\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z}\3\2\2\2{y\3\2\2\2|t\3\2\2\2|}\3\2\2"+
		"\2}~\3\2\2\2~\177\7\21\2\2\177\u0084\7\3\2\2\u0080\u0083\5\4\3\2\u0081"+
		"\u0083\5\n\6\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u008a\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0089\5\22\n\2\u0088\u0087\3\2\2\2\u0089\u008c\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\u008e\5&\24\2\u008e\u008f\7\17\2\2\u008f\17\3\2\2"+
		"\2\u0090\u0091\5\6\4\2\u0091\u0092\7-\2\2\u0092\21\3\2\2\2\u0093\u009b"+
		"\5\b\5\2\u0094\u009b\5\24\13\2\u0095\u009b\5\26\f\2\u0096\u009b\5\34\17"+
		"\2\u0097\u009b\5\36\20\2\u0098\u009b\5 \21\2\u0099\u009b\5&\24\2\u009a"+
		"\u0093\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2"+
		"\2\2\u009a\u0097\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\23\3\2\2\2\u009c\u009d\7\26\2\2\u009d\u009e\7\5\2\2\u009e\u00a3\7-\2"+
		"\2\u009f\u00a0\7*\2\2\u00a0\u00a2\7-\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a5"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\7\21\2\2\u00a7\u00a8\7\"\2\2\u00a8\25\3\2\2"+
		"\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\7\5\2\2\u00ab\u00b0\5\32\16\2\u00ac"+
		"\u00ad\7*\2\2\u00ad\u00af\5\32\16\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3"+
		"\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7\21\2\2\u00b4\u00b5\7\"\2\2\u00b5\27\3\2\2"+
		"\2\u00b6\u00b7\7-\2\2\u00b7\u00c0\7\5\2\2\u00b8\u00bd\5\32\16\2\u00b9"+
		"\u00ba\7*\2\2\u00ba\u00bc\5\32\16\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\7\21\2\2\u00c3\31\3\2\2\2\u00c4\u00c8\5\"\22\2\u00c5"+
		"\u00c8\5$\23\2\u00c6\u00c8\5\30\r\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3"+
		"\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00ca\7\23\2\2\u00ca"+
		"\u00cb\7\5\2\2\u00cb\u00cc\5$\23\2\u00cc\u00cd\7\21\2\2\u00cd\u00d1\7"+
		"\3\2\2\u00ce\u00d0\5\22\n\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4\u00de\7\17\2\2\u00d5\u00d6\7\24\2\2\u00d6\u00da\7\3\2\2\u00d7"+
		"\u00d9\5\22\n\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3"+
		"\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00df\7\17\2\2\u00de\u00d5\3\2\2\2\u00de\u00df\3\2\2\2\u00df\35\3\2\2"+
		"\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\7-\2\2\u00e2\u00e3\7\n\2\2\u00e3\u00e4"+
		"\5\"\22\2\u00e4\u00e5\7\6\2\2\u00e5\u00e8\5\"\22\2\u00e6\u00e7\7 \2\2"+
		"\u00e7\u00e9\5\"\22\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00f0\7\3\2\2\u00eb\u00ef\5\22\n\2\u00ec\u00ed\7\'\2\2"+
		"\u00ed\u00ef\7\"\2\2\u00ee\u00eb\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f2"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f3\u00f4\7\17\2\2\u00f4\37\3\2\2\2\u00f5\u00f6\7\r\2"+
		"\2\u00f6\u00f7\7\5\2\2\u00f7\u00f8\5$\23\2\u00f8\u00f9\7\21\2\2\u00f9"+
		"\u00ff\7\3\2\2\u00fa\u00fe\5\22\n\2\u00fb\u00fc\7\'\2\2\u00fc\u00fe\7"+
		"\"\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0103\7\17\2\2\u0103!\3\2\2\2\u0104\u0105\b\22\1\2\u0105\u0106"+
		"\7)\2\2\u0106\u0112\5\"\22\2\u0107\u0108\7\5\2\2\u0108\u0109\5\"\22\2"+
		"\u0109\u010a\7\21\2\2\u010a\u0112\3\2\2\2\u010b\u0112\7\32\2\2\u010c\u0112"+
		"\7\33\2\2\u010d\u0112\5\30\r\2\u010e\u0112\7\b\2\2\u010f\u0112\7\7\2\2"+
		"\u0110\u0112\7-\2\2\u0111\u0104\3\2\2\2\u0111\u0107\3\2\2\2\u0111\u010b"+
		"\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010d\3\2\2\2\u0111\u010e\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u011b\3\2\2\2\u0113\u0114\6\22"+
		"\2\3\u0114\u0115\t\2\2\2\u0115\u011a\5\"\22\2\u0116\u0117\6\22\3\3\u0117"+
		"\u0118\t\3\2\2\u0118\u011a\5\"\22\2\u0119\u0113\3\2\2\2\u0119\u0116\3"+
		"\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"#\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\b\23\1\2\u011f\u0120\7\31\2"+
		"\2\u0120\u0127\5$\23\2\u0121\u0122\5\"\22\2\u0122\u0123\t\4\2\2\u0123"+
		"\u0124\5\"\22\2\u0124\u0127\3\2\2\2\u0125\u0127\7-\2\2\u0126\u011e\3\2"+
		"\2\2\u0126\u0121\3\2\2\2\u0126\u0125\3\2\2\2\u0127\u012d\3\2\2\2\u0128"+
		"\u0129\6\23\4\3\u0129\u012a\7\34\2\2\u012a\u012c\5$\23\2\u012b\u0128\3"+
		"\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"%\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7&\2\2\u0131\u0132\7\5\2\2\u0132"+
		"\u0133\5\"\22\2\u0133\u0134\7\21\2\2\u0134\u0135\7\"\2\2\u0135\'\3\2\2"+
		"\2#-/\65ANTceky|\u0082\u0084\u008a\u009a\u00a3\u00b0\u00bd\u00c0\u00c7"+
		"\u00d1\u00da\u00de\u00e8\u00ee\u00f0\u00fd\u00ff\u0111\u0119\u011b\u0126"+
		"\u012d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}