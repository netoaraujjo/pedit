/**
 * 
 */
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<String, String> saida = new HashMap<>();
	private String output;
	private String error = "";

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
				buf.append("Linha " + line + ":" + charPositionInLine +  " " + msg + "\n");
				
				error += buf.toString();
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
		PortugolSemantica ps = new PortugolSemantica();

		walker.walk(ps, tree);

		output = ps.getOutput();
		output += "\n" + PortugolParser.tabelaSimbolos;

		// System.out.println(PortugolParser.tabelaSimbolos);
		
		saida.put("error", error);
		saida.put("output", output);
		
		return saida;

	}

}
