package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuBarBuilder {
	
	/**************************************
	 * Itens da barra de menu
	**************************************/
	private JMenuBar menuBar;
	// Menu Arquivo
	private JMenu menuArquivo;
	private JMenuItem novo;
	private JMenuItem abrir;
	private JMenuItem salvar;
	private JMenuItem salvarComo;
	private JMenuItem imprimir;
	private JMenuItem sair;
	// Menu Editar
	private JMenu menuEditar;
	private JMenuItem desfazer;
	private JMenuItem refazer;
	private JMenuItem recortar;
	private JMenuItem copiar;
	private JMenuItem colar;
	private JMenuItem selecionarTudo;
	private JMenuItem comentarioLinha;
	private JMenuItem comentarioBloco;
	// Menu Ver
	private JMenu menuVer;
	private JCheckBoxMenuItem verPainelLateral;
	private JCheckBoxMenuItem verConsole;
	private JCheckBoxMenuItem verNumeroLinhas;
	// Menu Configurações
	private JMenu menuConfiguracoes;
	// Menu Ajuda
	private JMenu menuAjuda;
	private JMenuItem sumario;
	private JMenuItem sobre;
	
	public JMenuBar getMenuBar() {
		menuBar = new JMenuBar();
		configuraMenuBar();
		return menuBar;
	}
	
	private void configuraMenuBar() {
		menuArquivo = new JMenu("Arquivo");
		menuEditar = new JMenu("Editar");
		menuVer = new JMenu("Ver");
		menuConfiguracoes = new JMenu("Configurações");
		menuAjuda = new JMenu("Ajuda");
		
		configuraMenuArquivo();
		configuraMenuEditar();
		configuraMenuVer();
		configuraMenuConfiguracoes();
		configuraMenuAjuda();
		
		menuBar.add(menuArquivo);
		menuBar.add(menuEditar);
		menuBar.add(menuVer);
		menuBar.add(menuConfiguracoes);
		menuBar.add(menuAjuda);
	}
	
	private void configuraMenuArquivo() {
		novo = new JMenuItem("Novo");
		novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		abrir = new JMenuItem("Abrir");
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		
		salvar = new JMenuItem("Salvar");
		salvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		salvarComo = new JMenuItem("Salvar como...");
		salvarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		imprimir = new JMenuItem("Imprimir");
		imprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		
		sair = new JMenuItem("Sair");
		sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		
		menuArquivo.add(novo);
		menuArquivo.add(abrir);
		menuArquivo.addSeparator();
		menuArquivo.add(salvar);
		menuArquivo.add(salvarComo);
		menuArquivo.addSeparator();
		menuArquivo.add(imprimir);
		menuArquivo.addSeparator();
		menuArquivo.add(sair);
	}
	
	private void configuraMenuEditar() {
		desfazer = new JMenuItem("Desfazer");
		desfazer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		
		refazer = new JMenuItem("Refazer");
		refazer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		recortar = new JMenuItem("Recortar");
		recortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		
		copiar = new JMenuItem("Copiar");
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		colar = new JMenuItem("Colar");
		colar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		selecionarTudo = new JMenuItem("Selecionar tudo");
		selecionarTudo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		
		comentarioLinha = new JMenuItem("Inserir comentário de linha");
		comentarioLinha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		comentarioBloco = new JMenuItem("Inserir comentário de bloco");
		comentarioBloco.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		
		menuEditar.add(desfazer);
		menuEditar.add(refazer);
		menuEditar.addSeparator();
		menuEditar.add(recortar);
		menuEditar.add(copiar);
		menuEditar.add(colar);
		menuEditar.addSeparator();
		menuEditar.add(selecionarTudo);
		menuEditar.addSeparator();
		menuEditar.add(comentarioLinha);
		menuEditar.add(comentarioBloco);
	}
	
	private void configuraMenuVer() {
		verPainelLateral = new JCheckBoxMenuItem("Painel lateral");
		
		verConsole = new JCheckBoxMenuItem("Console");
		
		verNumeroLinhas = new JCheckBoxMenuItem("Número das linhas");
		
		menuVer.add(verPainelLateral);
		menuVer.add(verConsole);
		menuVer.add(verNumeroLinhas);
	}
	
	private void configuraMenuConfiguracoes() {
		
	}
	
	private void configuraMenuAjuda() {
		sumario = new JMenuItem("Sumário");
		sumario.setAccelerator(KeyStroke.getKeyStroke("F1"));
		
		sobre = new JMenuItem("Sobre");
		
		menuAjuda.add(sumario);
		menuAjuda.add(sobre);
	}
}
