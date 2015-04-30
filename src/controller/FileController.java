/**
 * 
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Francisco Neto, Luis Guilherme
 *
 */
public class FileController {
	
	public File criaNovoArquivo() {
		while (true) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showSaveDialog(null);
			
			if (result == JFileChooser.CANCEL_OPTION) {
				return null;
			} else {
				File file = fileChooser.getSelectedFile();
				// se o usuario nao inserir a extensao a ide insere
				String arquivo = file.toString();
				if (!arquivo.endsWith(".por")) {
					arquivo += ".por";
					file = new File(arquivo);
				}
				if (file.exists()) {
					String msg = "O arquivo já existe. Deseja substitui-lo?";
					String titulo = "Arquivo ja existente";
					int op = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
					if (op == JOptionPane.YES_OPTION) {
						criaArquivo(file);
						return file;
					}
				} else {
					criaArquivo(file);
					return file;
				}
			}
		}
	}
	
	private void criaArquivo(File file) {
		Formatter saida;
		try {
			saida = new Formatter(file);
			saida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
