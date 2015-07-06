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
				// verifica se o arquivo ja existe
				if (file.exists()) {
					String msg = "O arquivo já existe. Deseja substitui-lo?";
					String titulo = "Arquivo ja existente";
					int op = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
					// pergunta se quer substituir o arquivo
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
	
	
	public File abrirArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.CANCEL_OPTION) {
			return null;
		} else {
			File arq = fileChooser.getSelectedFile();
			if (!arq.getName().endsWith(".por")) {
				JOptionPane.showMessageDialog(null,
											  "Tipo de arquivo incompativel. "
											  + "O arquivo deve possuir extensao .por",
											  "Erro",
											  JOptionPane.ERROR_MESSAGE);
				return null;
			}
			return arq;
		}
	}
	
	public void salvarArquivo(String texto, File arquivo) {
		try {
			Formatter saida = new Formatter(arquivo);
			saida.format("%s", texto);
			saida.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
										  "Ocorreu um erro e as alteracoes no arquivo nao foram salvas",
										  "Erro",
										  JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
