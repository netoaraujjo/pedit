// Generated from C:\Users\Luis Guilherme\Google Drive\UFPI\DISCIPLINAS\7º PERÍODO\CONSTRUÇÃO DE COMPILADORES - Raimundo Moura\Trabalho Final\Portugol.g4 by ANTLR 4.1

package antlr;
import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PortugolLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "'['", "'('", "'ate'", "BOOLEANO", "CADEIA_DE_CARACTERES", "'constante'", 
		"'de'", "'/'", "':'", "'enquanto'", "'escrever'", "'}'", "']'", "')'", 
		"'='", "'se'", "'senao'", "'inteiro'", "'ler'", "'logico'", "'*'", "'!'", 
		"NUM_INTEIRO", "NUM_REAL", "OPERADORES_IGUALDADES", "OPERADORES_SUPERIORIDADE", 
		"'palavra'", "'para'", "'passo'", "'.'", "';'", "'principal'", "'programa'", 
		"'real'", "'retorno'", "'sair'", "'+'", "'-'", "','", "COMENTARIO_DE_LINHA", 
		"COMENTARIO", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"ABRE_CHAVES", "ABRE_COLCHETE", "ABRE_PARENTESIS", "ATE", "BOOLEANO", 
		"CADEIA_DE_CARACTERES", "CONSTANTE", "DE", "DIVIDIR", "DOIS_PONTOS", "ENQUANTO", 
		"ESCREVER", "FECHA_CHAVES", "FECHA_COLCHETE", "FECHA_PARENTESIS", "IGUAL", 
		"SE", "SENAO", "INTEIRO", "LER", "LOGICO", "MULTIPLICACAO", "NEGACAO", 
		"NUM_INTEIRO", "NUM_REAL", "OPERADORES_IGUALDADES", "OPERADORES_SUPERIORIDADE", 
		"PALAVRA", "PARA", "PASSO", "PONTO", "PONTO_E_VIRGULA", "PRINCIPAL", "PROGRAMA", 
		"REAL", "RETORNO", "SAIR", "SOMA", "SUBTRACAO", "VIRGULA", "COMENTARIO_DE_LINHA", 
		"COMENTARIO", "ID", "WS"
	};


	public static Map<String, Integer> tabelaSimbolos = new HashMap<String, Integer>();


	public PortugolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Portugol.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 40: COMENTARIO_DE_LINHA_action((RuleContext)_localctx, actionIndex); break;

		case 41: COMENTARIO_action((RuleContext)_localctx, actionIndex); break;

		case 43: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void COMENTARIO_DE_LINHA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2.\u014a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6u\n\6\3\7\3\7\7\7y\n\7\f\7"+
		"\16\7|\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\6\31\u00cc\n\31\r\31\16\31\u00cd\3\32\6\32\u00d1\n"+
		"\32\r\32\16\32\u00d2\3\32\3\32\6\32\u00d7\n\32\r\32\16\32\u00d8\3\33\3"+
		"\33\3\33\3\33\5\33\u00df\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3("+
		"\3(\3)\3)\3*\3*\3*\3*\7*\u0129\n*\f*\16*\u012c\13*\3*\3*\3*\3*\3+\3+\3"+
		"+\3+\7+\u0136\n+\f+\16+\u0139\13+\3+\3+\3+\3+\3+\3,\3,\7,\u0142\n,\f,"+
		"\16,\u0145\13,\3-\3-\3-\3-\5z\u012a\u0137.\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O"+
		")\1Q*\1S+\2U,\3W-\1Y.\4\3\2\7\3\2\62;\4\2>>@@\3\2C|\4\2\62;C|\5\2\13\f"+
		"\17\17\"\"\u0152\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2"+
		"\7_\3\2\2\2\ta\3\2\2\2\13t\3\2\2\2\rv\3\2\2\2\17\177\3\2\2\2\21\u0089"+
		"\3\2\2\2\23\u008c\3\2\2\2\25\u008e\3\2\2\2\27\u0090\3\2\2\2\31\u0099\3"+
		"\2\2\2\33\u00a2\3\2\2\2\35\u00a4\3\2\2\2\37\u00a6\3\2\2\2!\u00a8\3\2\2"+
		"\2#\u00aa\3\2\2\2%\u00ad\3\2\2\2\'\u00b3\3\2\2\2)\u00bb\3\2\2\2+\u00bf"+
		"\3\2\2\2-\u00c6\3\2\2\2/\u00c8\3\2\2\2\61\u00cb\3\2\2\2\63\u00d0\3\2\2"+
		"\2\65\u00de\3\2\2\2\67\u00e0\3\2\2\29\u00e2\3\2\2\2;\u00ea\3\2\2\2=\u00ef"+
		"\3\2\2\2?\u00f5\3\2\2\2A\u00f7\3\2\2\2C\u00f9\3\2\2\2E\u0103\3\2\2\2G"+
		"\u010c\3\2\2\2I\u0111\3\2\2\2K\u0119\3\2\2\2M\u011e\3\2\2\2O\u0120\3\2"+
		"\2\2Q\u0122\3\2\2\2S\u0124\3\2\2\2U\u0131\3\2\2\2W\u013f\3\2\2\2Y\u0146"+
		"\3\2\2\2[\\\7}\2\2\\\4\3\2\2\2]^\7]\2\2^\6\3\2\2\2_`\7*\2\2`\b\3\2\2\2"+
		"ab\7c\2\2bc\7v\2\2cd\7g\2\2d\n\3\2\2\2ef\7x\2\2fg\7g\2\2gh\7t\2\2hi\7"+
		"f\2\2ij\7c\2\2jk\7f\2\2kl\7g\2\2lm\7k\2\2mn\7t\2\2nu\7q\2\2op\7h\2\2p"+
		"q\7c\2\2qr\7n\2\2rs\7u\2\2su\7q\2\2te\3\2\2\2to\3\2\2\2u\f\3\2\2\2vz\7"+
		"$\2\2wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{}\3\2\2\2|z\3"+
		"\2\2\2}~\7$\2\2~\16\3\2\2\2\177\u0080\7e\2\2\u0080\u0081\7q\2\2\u0081"+
		"\u0082\7p\2\2\u0082\u0083\7u\2\2\u0083\u0084\7v\2\2\u0084\u0085\7c\2\2"+
		"\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087\u0088\7g\2\2\u0088\20\3\2"+
		"\2\2\u0089\u008a\7f\2\2\u008a\u008b\7g\2\2\u008b\22\3\2\2\2\u008c\u008d"+
		"\7\61\2\2\u008d\24\3\2\2\2\u008e\u008f\7<\2\2\u008f\26\3\2\2\2\u0090\u0091"+
		"\7g\2\2\u0091\u0092\7p\2\2\u0092\u0093\7s\2\2\u0093\u0094\7w\2\2\u0094"+
		"\u0095\7c\2\2\u0095\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\u0098\7q\2\2"+
		"\u0098\30\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7u\2\2\u009b\u009c\7"+
		"e\2\2\u009c\u009d\7t\2\2\u009d\u009e\7g\2\2\u009e\u009f\7x\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7t\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7\177\2\2\u00a3"+
		"\34\3\2\2\2\u00a4\u00a5\7_\2\2\u00a5\36\3\2\2\2\u00a6\u00a7\7+\2\2\u00a7"+
		" \3\2\2\2\u00a8\u00a9\7?\2\2\u00a9\"\3\2\2\2\u00aa\u00ab\7u\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7p\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2\7q\2\2\u00b2&\3\2\2\2\u00b3"+
		"\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7g\2\2"+
		"\u00b7\u00b8\7k\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7q\2\2\u00ba(\3\2\2"+
		"\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7t\2\2\u00be*\3\2"+
		"\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7i\2\2\u00c2\u00c3"+
		"\7k\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5\7q\2\2\u00c5,\3\2\2\2\u00c6\u00c7"+
		"\7,\2\2\u00c7.\3\2\2\2\u00c8\u00c9\7#\2\2\u00c9\60\3\2\2\2\u00ca\u00cc"+
		"\t\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\62\3\2\2\2\u00cf\u00d1\t\2\2\2\u00d0\u00cf\3\2\2"+
		"\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d6\7\60\2\2\u00d5\u00d7\t\2\2\2\u00d6\u00d5\3\2\2\2"+
		"\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\64"+
		"\3\2\2\2\u00da\u00db\7?\2\2\u00db\u00df\7?\2\2\u00dc\u00dd\7#\2\2\u00dd"+
		"\u00df\7?\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\66\3\2\2\2"+
		"\u00e0\u00e1\t\3\2\2\u00e18\3\2\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7c"+
		"\2\2\u00e4\u00e5\7n\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7x\2\2\u00e7\u00e8"+
		"\7t\2\2\u00e8\u00e9\7c\2\2\u00e9:\3\2\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec"+
		"\7c\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee\7c\2\2\u00ee<\3\2\2\2\u00ef\u00f0"+
		"\7r\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00f4\7q\2\2\u00f4>\3\2\2\2\u00f5\u00f6\7\60\2\2\u00f6@\3\2\2\2\u00f7"+
		"\u00f8\7=\2\2\u00f8B\3\2\2\2\u00f9\u00fa\7r\2\2\u00fa\u00fb\7t\2\2\u00fb"+
		"\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7k\2\2"+
		"\u00ff\u0100\7r\2\2\u0100\u0101\7c\2\2\u0101\u0102\7n\2\2\u0102D\3\2\2"+
		"\2\u0103\u0104\7r\2\2\u0104\u0105\7t\2\2\u0105\u0106\7q\2\2\u0106\u0107"+
		"\7i\2\2\u0107\u0108\7t\2\2\u0108\u0109\7c\2\2\u0109\u010a\7o\2\2\u010a"+
		"\u010b\7c\2\2\u010bF\3\2\2\2\u010c\u010d\7t\2\2\u010d\u010e\7g\2\2\u010e"+
		"\u010f\7c\2\2\u010f\u0110\7n\2\2\u0110H\3\2\2\2\u0111\u0112\7t\2\2\u0112"+
		"\u0113\7g\2\2\u0113\u0114\7v\2\2\u0114\u0115\7q\2\2\u0115\u0116\7t\2\2"+
		"\u0116\u0117\7p\2\2\u0117\u0118\7q\2\2\u0118J\3\2\2\2\u0119\u011a\7u\2"+
		"\2\u011a\u011b\7c\2\2\u011b\u011c\7k\2\2\u011c\u011d\7t\2\2\u011dL\3\2"+
		"\2\2\u011e\u011f\7-\2\2\u011fN\3\2\2\2\u0120\u0121\7/\2\2\u0121P\3\2\2"+
		"\2\u0122\u0123\7.\2\2\u0123R\3\2\2\2\u0124\u0125\7\61\2\2\u0125\u0126"+
		"\7\61\2\2\u0126\u012a\3\2\2\2\u0127\u0129\13\2\2\2\u0128\u0127\3\2\2\2"+
		"\u0129\u012c\3\2\2\2\u012a\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012e\7\f\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0130\b*\2\2\u0130T\3\2\2\2\u0131\u0132\7\61\2\2\u0132\u0133\7,\2\2\u0133"+
		"\u0137\3\2\2\2\u0134\u0136\13\2\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3"+
		"\2\2\2\u0137\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013b\7,\2\2\u013b\u013c\7\61\2\2\u013c\u013d\3\2"+
		"\2\2\u013d\u013e\b+\3\2\u013eV\3\2\2\2\u013f\u0143\t\4\2\2\u0140\u0142"+
		"\t\5\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144X\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\t\6\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u0149\b-\4\2\u0149Z\3\2\2\2\f\2tz\u00cd\u00d2"+
		"\u00d8\u00de\u012a\u0137\u0143";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}