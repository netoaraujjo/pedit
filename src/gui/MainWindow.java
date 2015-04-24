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
	private JMenuItem sobre;
	
	
	public MainWindow() {
		super("pEdit");
		
		menuBar = new JMenuBar();
		configuraMenuBar();
		setJMenuBar(menuBar);
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
		abrir = new JMenuItem("Abrir");
		salvar = new JMenuItem("Salvar");
		salvarComo = new JMenuItem("Salvar como...");
		imprimir = new JMenuItem("Imprimir");
		sair = new JMenuItem("Sair");
		
		menuArquivo.add(novo);
		menuArquivo.add(abrir);
		menuArquivo.add(salvar);
		menuArquivo.add(salvarComo);
		menuArquivo.add(imprimir);
		menuArquivo.add(sair);
	}
	
	private void configuraMenuEditar() {
		desfazer = new JMenuItem("Desfazer");
		refazer = new JMenuItem("Refazer");
		recortar = new JMenuItem("Recortar");
		copiar = new JMenuItem("Copiar");
		colar = new JMenuItem("Colar");
		selecionarTudo = new JMenuItem("Selecionar tudo");
		comentarioLinha = new JMenuItem("Inserir comentário de linha");
		comentarioBloco = new JMenuItem("Inserir comentário de bloco");
		
		menuEditar.add(desfazer);
		menuEditar.add(refazer);
		menuEditar.add(recortar);
		menuEditar.add(copiar);
		menuEditar.add(colar);
		menuEditar.add(selecionarTudo);
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
		sobre = new JMenuItem("Sobre");
		
		menuAjuda.add(sobre);
	}
	
}
