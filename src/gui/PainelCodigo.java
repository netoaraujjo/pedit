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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * @author Francisco Neto, LuisGuilherme
 *
 */
public class PainelCodigo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private File arquivo;
	private JTextPane txtCodigo;
	
	public PainelCodigo(File arq, boolean novo) {
		arquivo = arq;
		setLayout(new BorderLayout());
		txtCodigo = new JTextPane();
		txtCodigo.setSelectionColor(Color.LIGHT_GRAY);
		if (!novo) {
			leArquivo();
		}
		add(new JScrollPane(txtCodigo));
	}
	
	private void leArquivo() {
		String conteudo = "";
		try {
			Scanner scanner = new Scanner(arquivo);
			while (scanner.hasNextLine()) {
				conteudo += scanner.nextLine() + "\n";
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
	
	public JTextPane getTextArea() {
		return txtCodigo;
	}

}
