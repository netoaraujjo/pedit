/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Francisco Neto, LuisGuilherme
 *
 */
public class PainelCodigo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private File arquivo;
	private JTextArea txtCodigo;
	
	public PainelCodigo(File arq) {
		arquivo = arq;
		setLayout(new BorderLayout());
		txtCodigo = new JTextArea();
		add(new JScrollPane(txtCodigo));
	}
	
	public File getArquivo() {
		return arquivo;
	}

}
