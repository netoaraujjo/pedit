/**
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		
		configuraAparencia();
		
		menuBar = new MenuBarBuilder().getMenuBar();
		setJMenuBar(menuBar);
	}
	
	private void configuraAparencia() {
		String sistema = System.getProperty("os.name");
		UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
		List<String> lookNames = new ArrayList<String>();
		for (UIManager.LookAndFeelInfo look : looks) {
			lookNames.add(look.getName());
		}
		for (String name : lookNames) {
			System.out.println(name);
		}
		
		/*
		int lkPos = 0;
		if (sistema.equals("Linux")) {
			lkPos = lookNames.indexOf("GTK+");
		} else if (sistema.contains("Windows")) {
			lkPos = 
		} else if (sistema.equals("MacOS")) {
			
		} else {
			lkPos = lookNames.indexOf("Nimbus");
		}
		
		// temporariamente seta nimbus como padrao
		try {
			//UIManager.setLookAndFeel(looks[lkPos].getClassName());
			UIManager.setLookAndFeel(looks[lookNames.indexOf("Nimbus")].getClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
}
