/**
 * 
 */
package application;

import gui.MainWindow;

import javax.swing.JFrame;

/**
 * @author Francisco Neto, Luís Guilherme
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainWindow janelaPrincipal = new MainWindow();
		janelaPrincipal.setSize(800, 600);
		janelaPrincipal.setLocationRelativeTo(null);
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janelaPrincipal.setVisible(true);
	}

}
