/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Francisco Neto, Luís Guilherme
 *
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private String sep = File.separator;
	private String iconDir = ".." + sep + "icons" + sep;

	/**********************************************
	 * Barra de menu
	 *********************************************/
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

	/**********************************************
	 * Barra de ferramentas
	 *********************************************/
	private JPanel painelToolbar;
	// Toolbar Arquivos
	private JToolBar toolbarArquivo;
	private JButton botaoNovo;
	private JButton botaoAbrir;
	private JButton botaoSalvar;
	private JButton botaoImprimir;
	// Toolbar Editar
	private JToolBar toolbarEditar;
	private JButton botaoDesfazer;
	private JButton botaoRefazer;
	private JButton botaoRecortar;
	private JButton botaoCopiar;
	private JButton botaoColar;
	// Toolbar Executar
	private JToolBar toolbarExecutar;
	private JButton botaoExecutar;
	private JButton botaoParar;
	
	/**********************************************
	 * Container
	 *********************************************/
	private JPanel container; // engloba sidebar, área de edição, console e barra de status
	private JPanel painelPrincipal; // engloba sidebar, área de edição e console
	private JPanel painelBarraStatus;
	
	/**********************************************
	 * Painel principal
	 *********************************************/
	private JSplitPane splitPane1; // divide o painel principal horizontalmente
	// sidebar
	private JTabbedPane painelSidebar;
	private JPanel containerSidebar;
	// painel edição
	private JPanel painelEdicao; // engloba área de edição e console
	private JSplitPane splitPane2; // divide a area de edição verticalmente
	private JTabbedPane painelCodigo;
	private JPanel containerCodigo;
	private JTabbedPane painelConsole;
	private JPanel containerConsole;
	private JPanel containerErros;
	private JTextArea textAreaConsole;
	
	
	
	/**
	 * CONSTRUTOR
	 */
	public MainWindow() {
		super("pEdit");

		configuraAparencia();

		configuraMenuBar();
		setJMenuBar(menuBar);
		configuraToolbar();
		
		configuraContainer();
		
		add(painelToolbar, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}

	
	/***********************************************************************************************
	 * Configurações da barra de menu
	 **********************************************************************************************/
	
	private void configuraMenuBar() {
		menuBar = new JMenuBar();
		
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
	
	
	/***********************************************************************************************
	 * Configurações da barra de ferramentas
	 **********************************************************************************************/
	
	private void configuraToolbar() {
		painelToolbar = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		painelToolbar.setLayout(layout);
		
		configuraToolbarArquivo();
		configuraToolbarEditar();
		configuraToolbarExecutar();
		
		painelToolbar.add(toolbarArquivo);
		painelToolbar.add(toolbarEditar);
		painelToolbar.add(toolbarExecutar);
	}
	
	private void configuraToolbarArquivo() {
		toolbarArquivo = new JToolBar();
		toolbarArquivo.setName("Arquivo");

		Icon iconeNovo = new ImageIcon(getClass().getResource(iconDir + "new_page.png"));
		botaoNovo = new JButton(iconeNovo);
		botaoNovo.setToolTipText("Criar novo arquivo (Ctrl+N)");
		//botaoNovo.setBorderPainted(false);
		
		Icon iconeAbrir = new ImageIcon(getClass().getResource(iconDir + "folder.png"));
		botaoAbrir = new JButton(iconeAbrir);
		botaoAbrir.setToolTipText("Abrir arquivo (Ctrl+O)");
		
		Icon iconeSalvar = new ImageIcon(getClass().getResource(iconDir + "save.png"));
		botaoSalvar = new JButton(iconeSalvar);
		botaoSalvar.setToolTipText("Salvar (Ctrl+S)");
		
		Icon iconeImprimir = new ImageIcon(getClass().getResource(iconDir + "print.png"));
		botaoImprimir = new JButton(iconeImprimir);
		botaoImprimir.setToolTipText("Imprimir (Ctrl+P)");
		
		toolbarArquivo.add(botaoNovo);
		toolbarArquivo.add(botaoAbrir);
		toolbarArquivo.add(botaoSalvar);
		toolbarArquivo.add(botaoImprimir);
	}
	
	private void configuraToolbarEditar() {
		toolbarEditar = new JToolBar();
		toolbarEditar.setName("Editar");
		
		Icon iconeDesfazer = new ImageIcon(getClass().getResource(iconDir + "arrow_left.png"));
		botaoDesfazer = new JButton(iconeDesfazer);
		botaoDesfazer.setToolTipText("Desfazer (Ctrl+Z)");
		
		Icon iconeRefazer = new ImageIcon(getClass().getResource(iconDir + "arrow_right.png"));
		botaoRefazer = new JButton(iconeRefazer);
		botaoRefazer.setToolTipText("Refazer (Ctrl+Shift+Z)");
		
		Icon iconeRecortar = new ImageIcon(getClass().getResource(iconDir + "cut.png"));
		botaoRecortar = new JButton(iconeRecortar);
		botaoRecortar.setToolTipText("Recortar (Ctrl+X)");
		
		Icon iconeCopiar = new ImageIcon(getClass().getResource(iconDir + "copy_page.png"));
		botaoCopiar = new JButton(iconeCopiar);
		botaoCopiar.setToolTipText("Copiar conteúdo selecionado (Ctrl+C)");
		
		Icon iconeColar = new ImageIcon(getClass().getResource(iconDir + "copy_page.png"));
		botaoColar = new JButton(iconeColar);
		botaoColar.setToolTipText("Colar da área de transferência (Ctrl+V)");
		
		toolbarEditar.add(botaoDesfazer);
		toolbarEditar.add(botaoRefazer);
		toolbarEditar.add(botaoRecortar);
		toolbarEditar.add(botaoCopiar);
		toolbarEditar.add(botaoColar);
	}
	
	private void configuraToolbarExecutar() {
		toolbarExecutar = new JToolBar();
		toolbarExecutar.setName("Executar");
		
		Icon iconeExecutar = new ImageIcon(getClass().getResource(iconDir + "play.png"));
		botaoExecutar = new JButton(iconeExecutar);
		botaoExecutar.setToolTipText("Executar");
		
		Icon iconeParar = new ImageIcon(getClass().getResource(iconDir + "stop.png"));
		botaoParar = new JButton(iconeParar);
		botaoParar.setToolTipText("Parar");
		
		toolbarExecutar.add(botaoExecutar);
		toolbarExecutar.add(botaoParar);
		
	}

	
	/***********************************************************************************************
	 * Configurações do container - engloba sidebar, área de edição, console e barra de status
	 **********************************************************************************************/
	// as bordas laterais devem ser inseridas no container
	private void configuraContainer() {
		BorderLayout layout = new BorderLayout(5, 5);
		container = new JPanel(layout);
		
		configuraPainelPrincipal();
		container.add(painelPrincipal, BorderLayout.CENTER);
		
		configuraBarraStatus();
		container.add(painelBarraStatus, BorderLayout.SOUTH);
	}
	
	
	/***********************************************************************************************
	 * Configurações do painel principal - engloba sidebar, área de edição, console
	 **********************************************************************************************/
	
	private void configuraPainelPrincipal() {
		painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBackground(Color.BLACK);
		
		
		configuraPainelSidebar();
		configuraPainelEdicao();
		
		
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelSidebar, painelEdicao);
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(200);
		painelPrincipal.add(splitPane1);
	}
	
	
	/***********************************************************************************************
	 * Configurações da sidebar
	 **********************************************************************************************/
	
	private void configuraPainelSidebar() {
		painelSidebar = new JTabbedPane();
		containerSidebar = new JPanel(new BorderLayout());
		
		// inserir o conteudo da sidebar aki
		
		painelSidebar.addTab("Explorer", containerSidebar);
	}
	
	
	/***********************************************************************************************
	 * Configurações do painel edição - engloba área de edição e console
	 **********************************************************************************************/
	private void configuraPainelEdicao() {
		painelEdicao = new JPanel(new BorderLayout());
		
		configuraPainelCodigo();
		configuraPainelConsole();
		
		splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, painelCodigo, painelConsole);
		splitPane2.setOneTouchExpandable(true);
		splitPane2.setDividerLocation(0.8);
		painelEdicao.add(splitPane2);
	}
	
	private void configuraPainelCodigo() {
		painelCodigo = new JTabbedPane();
		//containerCodigo = new JPanel(new BorderLayout());
	}
	
	private void configuraPainelConsole() {
		painelConsole = new JTabbedPane();
		containerConsole = new JPanel(new BorderLayout());
		textAreaConsole = new JTextArea();
		textAreaConsole.setEditable(false);
		containerConsole.add(new JScrollPane(textAreaConsole));
		
		containerErros = new JPanel(new BorderLayout());
		
		painelConsole.addTab("Erros", containerErros);
		painelConsole.addTab("Console", containerConsole);
	}
	
	
	
	
	/***********************************************************************************************
	 * Configurações da barra de status
	 **********************************************************************************************/
	
	private void configuraBarraStatus() {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		painelBarraStatus = new JPanel(layout);
		painelBarraStatus.add(new JLabel("Barra de status"));
	}
	
	
	/***********************************************************************************************
	 * Configurações da aparência plugável
	 **********************************************************************************************/
	
	private void configuraAparencia() {
		String sistema = System.getProperty("os.name");
		UIManager.LookAndFeelInfo[] looks = UIManager
				.getInstalledLookAndFeels();
		List<String> lookNames = new ArrayList<String>();
		for (UIManager.LookAndFeelInfo look : looks) {
			lookNames.add(look.getName());
		}
		for (String name : lookNames) {
			System.out.println(name);
		}

		/*try {
			UIManager.setLookAndFeel(looks[lookNames.indexOf("Nimbus")].getClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		 * int lkPos = 0; if (sistema.equals("Linux")) { lkPos =
		 * lookNames.indexOf("GTK+"); } else if (sistema.contains("Windows")) {
		 * lkPos = } else if (sistema.equals("MacOS")) {
		 * 
		 * } else { lkPos = lookNames.indexOf("Nimbus"); }
		 * 
		 * // temporariamente seta nimbus como padrao try {
		 * //UIManager.setLookAndFeel(looks[lkPos].getClassName());
		 * UIManager.setLookAndFeel
		 * (looks[lookNames.indexOf("Nimbus")].getClassName()); } catch
		 * (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

}
