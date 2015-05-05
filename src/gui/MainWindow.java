/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import application.Semantica;
import controller.FileController;

/**
 * @author Francisco Neto, Luis Guilherme
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
	// Menu Configuracoes
	private JMenu menuConfiguracoes;
	private JMenu menuTemas;
	private JRadioButtonMenuItem[] temas;
	private ButtonGroup temasButtonGroup;
	private UIManager.LookAndFeelInfo[] looksIntalados;
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
	private JPanel container; // engloba sidebar, area de edicao, console e barra de status
	private JPanel painelPrincipal; // engloba sidebar, área de edicao e console
	private JPanel painelBarraStatus;
	
	/**********************************************
	 * Painel principal
	 *********************************************/
	private JSplitPane splitPaneVertical; // separa o painel principal nos paineis central e lateral
	private JPanel painelLateral; // painel que contem a sidebar
	private JPanel painelCentral; // painel que contem o painel de edicao e codigo e o console/debbuger
	private static JTabbedPane tabbebPaneCodigo; // painel que contem toda a area de codigo
	private JPanel painelInfo; // contem a area de informacoes de build e console
	private JSplitPane splitPaneHorizontal; // separa o painel central nos paineis codigo e info
	
	/**********************************************
	 * Painel lateral
	 *********************************************/
	private JTabbedPane painelSidebar; // o container de abas da sidebar
	private JPanel painelNavegar;
	
	/**********************************************
	 * Painel edicao
	 *********************************************/
	private JPopupMenu popupMenuAba;
	private JMenuItem fecharAba;
	private JMenuItem fecharTodasAbas;
	private JMenuItem fecharOutrasAbas;
	
	/**********************************************
	 * Painel info
	 *********************************************/
	private JTabbedPane painelLog; // container de abas da painel info
	private JPanel painelConsole;
	private JPanel painelLogInfo;
	private JTextPane textConsole;
	private JTextPane textLog;
	private JPopupMenu popupMenuInfo;
	private JMenuItem limparInfo;
	
	
	/* Fim dos elementos de interface
	 ************************************************************************************************/
	private List<PainelCodigo> abas;
	private FileController fileControler;
	private Map<String, String> config;
	
	
	/**
	 * CONSTRUTOR
	 */
	public MainWindow() {
		super("pEdit");
		fileControler = new FileController();
		abas = new ArrayList<PainelCodigo>();
		config = new HashMap<String, String>();

		configuraMenuBar();
		setJMenuBar(menuBar);
		configuraToolbar();
		
		configuraContainer();

		add(painelToolbar, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
		
		configuraAparencia();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				executaFechamento();
			}
		});
	}
	
	private void executaFechamento() {
 		// verificar se as alteracoes foram salvas
		salvaConfiguracoes();
		System.exit(0);
	}
	
	private void salvaConfiguracoes() {
		try {
			Formatter formatter = new Formatter(new File("config.ini"));
			String tema = "";
			for (int i = 0; i < temas.length; i++) {
				if (temas[i].isSelected()) {
					tema = temas[i].getText();
				}
			}
			formatter.format("tema=%s\n", tema);
			formatter.format("sidebar=%s\n", verPainelLateral.isSelected() ? "on" : "off");
			formatter.format("log=%s\n", verConsole.isSelected() ? "on" : "off");
			formatter.format("line=%s", verNumeroLinhas.isSelected() ? "on" : "off");
			formatter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void configuraAparencia(){
		try {
			Scanner scanner = new Scanner(new File("config.ini"));
			while (scanner.hasNext()) {
				String[] str = scanner.nextLine().split("=");
				config.put(str[0], str[1]);
			}
			
			verPainelLateral.setSelected(config.get("sidebar").matches("on"));
			verConsole.setSelected(config.get("log").matches("on"));
			
			if (config.get("line").matches("on")) {
				PainelCodigo.exibirLinhas = true;
				verNumeroLinhas.setSelected(true);
			} else {
				PainelCodigo.exibirLinhas = false;
				verNumeroLinhas.setSelected(false);
			}
			
			UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
			List<String> lookNames = new ArrayList<String>();
			for (int i = 0; i < looks.length; i++) {
				lookNames.add(looks[i].getName());
			}
			if (lookNames.contains(config.get("tema"))) {
				try {
					UIManager.setLookAndFeel(looks[lookNames.indexOf(config.get("tema"))].getClassName());
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
					for (int i = 0; i < temas.length; i++) {
						if (temas[i].getText().compareTo(config.get("tema")) == 0) {
							temas[i].setSelected(true);
							break;
						}
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			} else {
				try {
					UIManager.setLookAndFeel(looks[lookNames.indexOf("Metal")].getClassName());
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
					for (int i = 0; i < temas.length; i++) {
						if (temas[i].getText().matches("Metal")) {
							temas[i].setSelected(true);
							break;
						}
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/***********************************************************************************************
	 * Configuracoes da barra de menu
	 **********************************************************************************************/
	
	private void configuraMenuBar() {
		menuBar = new JMenuBar();
		
		menuArquivo = new JMenu("Arquivo");
		menuEditar = new JMenu("Editar");
		menuVer = new JMenu("Ver");
		menuConfiguracoes = new JMenu("Configuracoes");
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
		novo.addActionListener(new NovoArquivoHandler());
		
		abrir = new JMenuItem("Abrir");
		abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		abrir.addActionListener(new AbrirArquivoHandler());
		
		salvar = new JMenuItem("Salvar");
		salvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		salvar.addActionListener(new SalvarArquivoHandler());
		
		salvarComo = new JMenuItem("Salvar como...");
		salvarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		salvarComo.addActionListener(new SalvarComoHandler());
		
		imprimir = new JMenuItem("Imprimir");
		imprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		
		sair = new JMenuItem("Sair");
		sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				executaFechamento();
			}
		});
		
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
		recortar.addActionListener(new RecortarHandler());
		
		copiar = new JMenuItem("Copiar");
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		
		colar = new JMenuItem("Colar");
		colar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		selecionarTudo = new JMenuItem("Selecionar tudo");
		selecionarTudo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		selecionarTudo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JTextPane txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				RSyntaxTextArea txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				txt.setSelectionStart(0);
				txt.setSelectionEnd(txt.getText().length()-1);
			}
		});
		
		comentarioLinha = new JMenuItem("Inserir comentario de linha");
		comentarioLinha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		comentarioLinha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//JTextPane txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				RSyntaxTextArea txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				String txtSelecionado = txt.getSelectedText();
				if (txtSelecionado != null) {
					txt.replaceSelection("// " + txtSelecionado);
				} else {
					txt.replaceSelection("// ");
				}
			}
		});
		
		comentarioBloco = new JMenuItem("Inserir comentario de bloco");
		comentarioBloco.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		comentarioBloco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//JTextPane txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				RSyntaxTextArea txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
				String txtSelecionado = txt.getSelectedText();
				if (txtSelecionado != null) {
					txt.replaceSelection("/* " + txtSelecionado + " */");
				} else {
					txt.replaceSelection("/* */");
				}
			}
		});
		
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
		verPainelLateral.setSelected(true);
		verPainelLateral.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (verPainelLateral.isSelected()) {
					painelLateral.setVisible(true);
				} else {
					painelLateral.setVisible(false);
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
				}
			}
		});
		
		verConsole = new JCheckBoxMenuItem("Console");
		verConsole.setSelected(true);
		verConsole.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (verConsole.isSelected()) {
					painelInfo.setVisible(true);
				} else {
					painelInfo.setVisible(false);
					SwingUtilities.updateComponentTreeUI(MainWindow.this);
				}
			}
		});
		
		verNumeroLinhas = new JCheckBoxMenuItem("Numero das linhas");
		verNumeroLinhas.setSelected(true);
		verNumeroLinhas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				PainelCodigo.exibirLinhas = verNumeroLinhas.isSelected();
				for (PainelCodigo painelCodigo : abas) {
					painelCodigo.habilitaNumeroLinhas();
				}
			}
		});
		
		menuVer.add(verPainelLateral);
		menuVer.add(verConsole);
		menuVer.add(verNumeroLinhas);
	}
	
	private void configuraMenuConfiguracoes() {
		menuTemas = new JMenu("Temas");
		
		looksIntalados = UIManager.getInstalledLookAndFeels();
		temas = new JRadioButtonMenuItem[looksIntalados.length];
		temasButtonGroup = new ButtonGroup();
		TemaHandler temaHandler = new TemaHandler();
		
		for (int i = 0; i < looksIntalados.length; i++) {
			temas[i] = new JRadioButtonMenuItem(looksIntalados[i].getName());
			temasButtonGroup.add(temas[i]);
			menuTemas.add(temas[i]);
			temas[i].addActionListener(temaHandler);
		}
		
		menuConfiguracoes.add(menuTemas);
	}
	
	private void configuraMenuAjuda() {
		sumario = new JMenuItem("Sumario");
		sumario.setAccelerator(KeyStroke.getKeyStroke("F1"));
		
		sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DialogSobre();
			}
		});
		
		menuAjuda.add(sumario);
		menuAjuda.add(sobre);
	}
	
	
	/***********************************************************************************************
	 * Configuracoes da barra de ferramentas
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
		botaoNovo.addActionListener(new NovoArquivoHandler());
		//botaoNovo.setBorderPainted(false);
		
		Icon iconeAbrir = new ImageIcon(getClass().getResource(iconDir + "folder.png"));
		botaoAbrir = new JButton(iconeAbrir);
		botaoAbrir.setToolTipText("Abrir arquivo (Ctrl+O)");
		botaoAbrir.addActionListener(new AbrirArquivoHandler());
		
		Icon iconeSalvar = new ImageIcon(getClass().getResource(iconDir + "save.png"));
		botaoSalvar = new JButton(iconeSalvar);
		botaoSalvar.setToolTipText("Salvar (Ctrl+S)");
		botaoSalvar.addActionListener(new SalvarArquivoHandler());
		
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
		botaoRecortar.addActionListener(new RecortarHandler());
		
		Icon iconeCopiar = new ImageIcon(getClass().getResource(iconDir + "copy_page.png"));
		botaoCopiar = new JButton(iconeCopiar);
		botaoCopiar.setToolTipText("Copiar conte�do selecionado (Ctrl+C)");
		
		Icon iconeColar = new ImageIcon(getClass().getResource(iconDir + "copy_page.png"));
		botaoColar = new JButton(iconeColar);
		botaoColar.setToolTipText("Colar da �rea de transfer�ncia (Ctrl+V)");
		
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
		botaoExecutar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Semantica sem = new Semantica();
				Map<String, String> hash = null;
				
				String txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTexto();
				File arq = abas.get(tabbebPaneCodigo.getSelectedIndex()).getArquivo();
				fileControler.salvarArquivo(txt, arq);
				
				try {
					hash = sem.executa(abas.get(tabbebPaneCodigo.getSelectedIndex()).getArquivo());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				textConsole.setText("");
				
				StyledDocument doc = textConsole.getStyledDocument();

		        Style style = textConsole.addStyle("I'm a Style", null);
		        
		        StyleConstants.setForeground(style, Color.blue);

		        try { doc.insertString(doc.getLength(), hash.get("output") + "\n",style); }
		        catch (BadLocationException e1){}
		        
		        StyleConstants.setForeground(style, Color.red);

		        try { doc.insertString(doc.getLength(), hash.get("error") + "\n",style); }
		        catch (BadLocationException e1){}

				painelLog.setSelectedIndex(1);
			}
		});
		
		Icon iconeParar = new ImageIcon(getClass().getResource(iconDir + "stop.png"));
		botaoParar = new JButton(iconeParar);
		botaoParar.setToolTipText("Parar");
		
		toolbarExecutar.add(botaoExecutar);
		toolbarExecutar.add(botaoParar);
		
	}

	
	/***********************************************************************************************
	 * Habilita ferramentas de edicao
	 **********************************************************************************************/
	private void habilitaFerramentasEdicao(boolean status) {
		salvar.setEnabled(status);
		salvarComo.setEnabled(status);
		imprimir.setEnabled(status);
		
		desfazer.setEnabled(status);
		refazer.setEnabled(status);
		recortar.setEnabled(status);
		copiar.setEnabled(status);
		colar.setEnabled(status);
		selecionarTudo.setEnabled(status);
		comentarioLinha.setEnabled(status);
		comentarioBloco.setEnabled(status);
		
		botaoSalvar.setEnabled(status);
		botaoImprimir.setEnabled(status);
		botaoDesfazer.setEnabled(status);
		botaoRefazer.setEnabled(status);
		botaoRecortar.setEnabled(status);
		botaoCopiar.setEnabled(status);
		botaoColar.setEnabled(status);
		botaoExecutar.setEnabled(status);
		botaoParar.setEnabled(status);
	}
	
	
	/***********************************************************************************************
	 * Configuracoes do container - engloba sidebar, area de edicao, console e barra de status
	 **********************************************************************************************/
	// as bordas laterais devem ser inseridas no container
	private void configuraContainer() {
		BorderLayout layout = new BorderLayout(0, 5);
		container = new JPanel(layout);
		
		configuraPainelPrincipal();
		container.add(painelPrincipal, BorderLayout.CENTER);
		
		configuraBarraStatus();
		container.add(painelBarraStatus, BorderLayout.SOUTH);
	}
	
	// Engloba sidebar, area de edicao e console
	private void configuraPainelPrincipal() {
		painelPrincipal = new JPanel(new BorderLayout());
		
		configuraPainelLateral();
		configuraPainelCentral();
		
		splitPaneVertical = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelLateral, painelCentral);
		splitPaneVertical.setResizeWeight(0.13);
		splitPaneVertical.setOneTouchExpandable(true);
		
		painelPrincipal.add(splitPaneVertical);
	}
	
	// contem todo o painel lateral
	private void configuraPainelLateral() {
		painelLateral = new JPanel(new BorderLayout());
		painelSidebar = new JTabbedPane();
		configuraPainelNavegar();
		
		painelSidebar.addTab("Navegar", painelNavegar);
		
		painelLateral.add(painelSidebar);
	}
	
	private void configuraPainelNavegar() {
		painelNavegar = new JPanel(new BorderLayout());
	}
	
	private void configuraPainelCentral() {
		painelCentral = new JPanel(new BorderLayout());
		
		configuraTabbedPaneCodigo();
		configuraPainelInfo();
		
		splitPaneHorizontal = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbebPaneCodigo, painelInfo);
		splitPaneHorizontal.setResizeWeight(0.8);
		splitPaneHorizontal.setOneTouchExpandable(true);
		
		painelCentral.add(splitPaneHorizontal);
	}
	
	private void configuraTabbedPaneCodigo() {
		tabbebPaneCodigo = new JTabbedPane();
		popupMenuAba = new JPopupMenu();
		fecharAba = new JMenuItem("Fechar");
		fecharAba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// verifica se o arquivo correspondente foi salvo
				abas.remove(tabbebPaneCodigo.getSelectedIndex());
				tabbebPaneCodigo.removeTabAt(tabbebPaneCodigo.getSelectedIndex());
				if (tabbebPaneCodigo.getTabCount() == 0) {
					habilitaFerramentasEdicao(false);
				}
			}
		});
		
		
		fecharTodasAbas = new JMenuItem("Fechar todas");
		fecharTodasAbas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// provavelmente vai ser necessario um for para ver quem nao foi salvo
				abas.clear();
				tabbebPaneCodigo.removeAll();
				habilitaFerramentasEdicao(false);
			}
		});
		
		fecharOutrasAbas = new JMenuItem("Fechar outras");
		fecharOutrasAbas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelCodigo pc = abas.get(tabbebPaneCodigo.getSelectedIndex());
				abas.clear();
				tabbebPaneCodigo.removeAll();
				abas.add(pc);
				tabbebPaneCodigo.addTab(pc.getArquivo().getName(), pc);
			}
		});
		
		popupMenuAba.add(fecharAba);
		popupMenuAba.add(fecharOutrasAbas);
		popupMenuAba.add(fecharTodasAbas);
		
		tabbebPaneCodigo.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (abas.size() > 0) {
					setTitle("pEdit - " + abas.get(tabbebPaneCodigo.getSelectedIndex()).getArquivo().getAbsolutePath());
				} else {
					setTitle("pEdit");
				}
				
			}
		});
		
		tabbebPaneCodigo.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			public void mouseReleased(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			private void checkForTriggerEvent(MouseEvent event) {
				if (event.isPopupTrigger() && tabbebPaneCodigo.getTabCount() > 0) {
					popupMenuAba.show(event.getComponent(), event.getX(), event.getY());
				}
			}
		});
		
		habilitaFerramentasEdicao(tabbebPaneCodigo.getTabCount() > 0);
		
	}
	
	public static void alteraTituloAba() {
		int index = tabbebPaneCodigo.getSelectedIndex();
		tabbebPaneCodigo.setTitleAt(index, "* " + tabbebPaneCodigo.getTitleAt(index));
	}
	
	
	
	
	
	
	
	
	
	private void configuraPainelInfo() {
		painelInfo = new JPanel(new BorderLayout());
		painelLog = new JTabbedPane();
		
		popupMenuInfo = new JPopupMenu();
		limparInfo = new JMenuItem("Limpar");
		limparInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textConsole.setText("");
			}
		});
		
		popupMenuInfo.add(limparInfo);
		
		painelLog.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			public void mouseReleased(MouseEvent event) {
				checkForTriggerEvent(event);
			}
			
			private void checkForTriggerEvent(MouseEvent event) {
				if (event.isPopupTrigger()) {
					popupMenuInfo.show(event.getComponent(), event.getX(), event.getY());
				}
			}
		});
		
		configuraPainelLogInfo();
		configuraPainelConsole();
		
		painelLog.addTab("Log", painelLogInfo);
		painelLog.addTab("Console", painelConsole);
		
		painelInfo.add(painelLog);
	}
	
	private void configuraPainelLogInfo() {
		painelLogInfo = new JPanel(new BorderLayout());
		textLog = new JTextPane();
		painelLogInfo.add(new JScrollPane(textLog));
	}
	
	private void configuraPainelConsole() {
		painelConsole = new JPanel(new BorderLayout());
		textConsole = new JTextPane();
		painelConsole.add(new JScrollPane(textConsole));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***********************************************************************************************
	 * Configuracoes da barra de status
	 **********************************************************************************************/
	
	private void configuraBarraStatus() {
		FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
		painelBarraStatus = new JPanel(layout);
		painelBarraStatus.add(new JLabel("Barra de status"));
	}
	
	
	/***********************************************************************************************
	 * Manipula alteracao do tema
	 **********************************************************************************************/
	
	private class TemaHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < temas.length; i++) {
				if (temas[i].isSelected()) {
					try {
						UIManager.setLookAndFeel(looksIntalados[i].getClassName());
						SwingUtilities.updateComponentTreeUI(MainWindow.this);
					} catch (ClassNotFoundException | InstantiationException
							| IllegalAccessException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
													  "Nao foi possivel alterar o tema.",
													  "Erro",
													  JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	
	/***********************************************************************************************
	 * Manipula criacao de arquivos
	 **********************************************************************************************/
	
	private class NovoArquivoHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			File arq = fileControler.criaNovoArquivo();
			if (arq != null) {
				PainelCodigo painelCodigo = new PainelCodigo(arq, true);
				abas.add(painelCodigo);
				autoCompleta(abas.get(abas.size() - 1));
				tabbebPaneCodigo.addTab(arq.getName(), painelCodigo);
				tabbebPaneCodigo.setSelectedIndex(abas.size() - 1);
				
				habilitaFerramentasEdicao(true);
			}
		}
	}
	
	
	/***********************************************************************************************
	 * Manipula abertura de arquivos
	 **********************************************************************************************/
	
	private class AbrirArquivoHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			File arq = fileControler.abrirArquivo();
			if (arq != null) {
				int openedFileIndex = getOpenedFileIndex(arq);
				if (openedFileIndex == -1) {
					PainelCodigo painelCodigo = new PainelCodigo(arq, false);
					abas.add(painelCodigo);
					autoCompleta(abas.get(abas.size() - 1));
					tabbebPaneCodigo.addTab(arq.getName(), painelCodigo);
					tabbebPaneCodigo.setSelectedIndex(abas.size() - 1);
					habilitaFerramentasEdicao(true);
				} else {
					tabbebPaneCodigo.setSelectedIndex(openedFileIndex);
				}
			}
		}
		
		private int getOpenedFileIndex(File arq) {
			for (int i = 0; i < abas.size(); i++) {
				if (abas.get(i).getArquivo().getAbsolutePath().compareTo(arq.getAbsolutePath()) == 0) {
					return i;
				}
			}
			return -1;
		}
	}
	
	
	/***********************************************************************************************
	 * Manipula salvar arquivos
	 **********************************************************************************************/
	
	private class SalvarArquivoHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int indice = tabbebPaneCodigo.getSelectedIndex();
			String txt = abas.get(indice).getTexto();
			File arq = abas.get(indice).getArquivo();
			fileControler.salvarArquivo(txt, arq);
			abas.get(indice).setArquivoAlterado(false);
			tabbebPaneCodigo.setTitleAt(indice, abas.get(indice).getArquivo().getName());
		}
	}
	
	/***********************************************************************************************
	 * Manipula salvar como... arquivos
	 **********************************************************************************************/
	
	private class SalvarComoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			File arqNovo = fileControler.criaNovoArquivo();
			if (arqNovo != null) {
				String txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTexto();
				fileControler.salvarArquivo(txt, arqNovo);
			}
		}
	}
	
	/***********************************************************************************************
	 * Manipula recortar
	 **********************************************************************************************/
	
	private class RecortarHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//JTextPane txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
			RSyntaxTextArea txt = abas.get(tabbebPaneCodigo.getSelectedIndex()).getTextArea();
			txt.replaceSelection("");
			// add na area de transferencia
		}
	}
	
	private void autoCompleta(PainelCodigo aba) {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();

		provider.addCompletion(new BasicCompletion(provider, "programa"));
		provider.addCompletion(new BasicCompletion(provider, "final"));
		provider.addCompletion(new BasicCompletion(provider, "inteiro"));
		provider.addCompletion(new BasicCompletion(provider, "real"));
		provider.addCompletion(new BasicCompletion(provider, "logico"));
		provider.addCompletion(new BasicCompletion(provider, "palavra"));
		provider.addCompletion(new BasicCompletion(provider, "constante"));
		provider.addCompletion(new BasicCompletion(provider, "se"));
		provider.addCompletion(new BasicCompletion(provider, "entao"));
		provider.addCompletion(new BasicCompletion(provider, "senao"));
		provider.addCompletion(new BasicCompletion(provider, "faca"));
		provider.addCompletion(new BasicCompletion(provider, "ate"));
		provider.addCompletion(new BasicCompletion(provider, "enquanto"));
		provider.addCompletion(new BasicCompletion(provider, "para"));
		provider.addCompletion(new BasicCompletion(provider, "de"));
		provider.addCompletion(new BasicCompletion(provider, "ate"));
		provider.addCompletion(new BasicCompletion(provider, "passo"));
		provider.addCompletion(new BasicCompletion(provider, "retorno"));
		provider.addCompletion(new BasicCompletion(provider, "verdadeiro"));
		provider.addCompletion(new BasicCompletion(provider, "falso"));
		provider.addCompletion(new BasicCompletion(provider, "sair"));
		provider.addCompletion(new BasicCompletion(provider, "principal"));
		
		
		provider.addCompletion(new ShorthandCompletion(provider, "ler",
	            "ler(", "ler("));
	    provider.addCompletion(new ShorthandCompletion(provider, "escrever",
	            "escrever(", "escrever("));
		
		CompletionProvider prov = provider;
		AutoCompletion ac = new AutoCompletion(prov);
		
		ac.install(aba.getTextArea());
	}

}
