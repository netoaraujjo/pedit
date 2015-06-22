/**
 * 
 */
package compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.PortugolLexer;
import antlr.PortugolParser;
import antlr.PortugolSemantica;

/**
 * @author Francisco Neto, Luis Guilherme
 *
 */
public class Semantica {
	public Map<Chave, InfoVariavel> tsVar;
	public Map<Chave, InfoFuncao> tsFunc;
	private Map<String, String> saida = new HashMap<>();
	private String output;
	private String erroSint = "";
	private String erroSem;

	public Map<String, String> executa(File arquivo) throws Exception {

		String inputFile = arquivo.getAbsolutePath();
		InputStream is = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(is);

		// Lexico
		PortugolLexer lexer = new PortugolLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Sintatico
		PortugolParser parser = new PortugolParser(tokens);
		parser.removeErrorListeners();

		ANTLRErrorListener listener = new ANTLRErrorListener() {

			@Override
			public void syntaxError(Recognizer<?, ?> recognizer,
					Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				List<String> stack = ((Parser) recognizer)
						.getRuleInvocationStack();
				Collections.reverse(stack);
				StringBuilder buf = new StringBuilder();
				buf.append("Linha " + line + ":" + charPositionInLine + " "
						+ msg + "\n");

				erroSint += buf.toString();
			}

			@Override
			public void reportAmbiguity(Parser arg0, DFA arg1, int arg2,
					int arg3, boolean arg4, BitSet arg5, ATNConfigSet arg6) {
				// TODO Auto-generated method stub

			}

			@Override
			public void reportAttemptingFullContext(Parser arg0, DFA arg1,
					int arg2, int arg3, BitSet arg4, ATNConfigSet arg5) {
				// TODO Auto-generated method stub

			}

			@Override
			public void reportContextSensitivity(Parser arg0, DFA arg1,
					int arg2, int arg3, int arg4, ATNConfigSet arg5) {
				// TODO Auto-generated method stub

			}
		};

		parser.addErrorListener(listener);

		ParseTree tree = parser.prog();

		ParseTreeWalker walker = new ParseTreeWalker();
		//PortugolSemantica ps = new PortugolSemantica();
		PortugolSemantica ps = new PortugolSemantica(arquivo);

		walker.walk(ps, tree);

		output = ps.getOutput();
		erroSem = ps.getErro();

		tsVar = ps.getTsVar();
		tsFunc = ps.getTsFunc();

		output += "--: VARIAVEIS :--\n";

		Set<Chave> chaves = tsVar.keySet();
		for (Chave key : chaves) {
			if (key != null)
				output += key.getId() + " -> TIPO: " + tsVar.get(key).getTipo()
						+ " | CATEGORIA: " + tsVar.get(key).getCategoria()
						+ " | ESCOPO: " + key.getEscopo()
						+ " | ENDEREÇO: " + tsVar.get(key).getEndereco()
						+ " | VALOR: " + tsVar.get(key).getValor() + "\n";
		}

		output += "\n--: FUNCOES :--\n";

		chaves = tsFunc.keySet();
		for (Chave key : chaves) {
			if (key != null)
				output += key.getId() + " -> TIPO: "
						+ tsFunc.get(key).getTipo() + " | CATEGORIA: "
						+ tsFunc.get(key).getCategoria() + " | QNTD. PARAM.: "
						+ tsFunc.get(key).getQntdParametro()
						+ " | SEQ. PARAM.: "
						+ tsFunc.get(key).getSeqParametro() + " | ESCOPO: "
						+ key.getEscopo() + "\n";
		}

		// System.out.println(PortugolParser.tabelaSimbolos);

		saida.put("erroSint", erroSint);
		saida.put("erroSem", erroSem);
		saida.put("output", output);

		return saida;

	}

}
