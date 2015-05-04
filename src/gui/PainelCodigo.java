/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * @author Francisco Neto, Luis Guilherme
 *
 */
public class PainelCodigo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static boolean exibirLinhas;
	
	private File arquivo;
//	private JTextPane txtCodigo;
	private RSyntaxTextArea txtCodigo;
	RTextScrollPane sp;
	private boolean arquivoAlterado;
	
	public PainelCodigo(File arq, boolean novo) {
		arquivo = arq;
		setLayout(new BorderLayout());
		//txtCodigo = new JTextPane();
		txtCodigo = new RSyntaxTextArea();
		txtCodigo.setSelectionColor(Color.LIGHT_GRAY);
		
		sp = new RTextScrollPane(txtCodigo);
		sp.setLineNumbersEnabled(exibirLinhas);
		
		arquivoAlterado = false;
		
		if (!novo) {
			leArquivo();
		}
		
		//add(new JScrollPane(txtCodigo));
		add(sp);
	}
	
	public boolean isArquivoAlterado() {
		return arquivoAlterado;
	}
	
	public void setArquivoAlterado(boolean arqAlt) {
		arquivoAlterado = arqAlt;
	}
	
	public void habilitaNumeroLinhas() {
		sp.setLineNumbersEnabled(exibirLinhas);
	}
	
	private void leArquivo() {
		String conteudo = "";
		try {
			Scanner scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
				//conteudo += scanner.nextLine() + "\n";// if(scanner.hasNextLine()) {}
				conteudo += scanner.nextLine();
				if (scanner.hasNextLine()) {
					conteudo += "\n";
				}
			}
			scanner.close();
			txtCodigo.setText(conteudo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File getArquivo() {
		return arquivo;
	}
	
	public String getTexto() {
		return txtCodigo.getText();
	}
	
//	public JTextPane getTextArea() {
//		return txtCodigo;
//	}
	
	public RSyntaxTextArea getTextArea() {
		return txtCodigo;
	}
}
