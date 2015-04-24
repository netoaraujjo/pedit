/**
 * 
 */
package application;

import java.io.FileInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr.PortugolLexer;
import antlr.PortugolParser;
import antlr.PortugolSemantica;

/**
 * @author Francisco Neto, Luis Guilherme
 *
 */
public class MainTest {

	public static void main(String[] args) throws Exception {
		String inputFile = "C:/Users/Luis Guilherme/Desktop/pEdit/src/input.por"; 
        InputStream is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        //Lexico
        PortugolLexer lexer = new PortugolLexer(input); 
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        //Sintatico
        PortugolParser parser = new PortugolParser(tokens);
        
        ParseTree tree = parser.prog();
        
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new PortugolSemantica(), tree);

        System.out.println(PortugolParser.tabelaSimbolos); 

	}

}
