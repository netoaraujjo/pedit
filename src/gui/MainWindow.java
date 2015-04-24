/**
 * 
 */
package gui;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Francisco Neto, Luís Guilherme
 *
 */
public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	/**************************************
	 * Itens da barra de menu
	**************************************/
	private JMenuBar menuBar;
	
	
	public MainWindow() {
		super("pEdit");
		
		menuBar = new MenuBarBuilder().getMenuBar();
		setJMenuBar(menuBar);
	}
	
}
