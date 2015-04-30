/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Francisco Neto, Luis Guilherme
 *
 */
public class DialogSobre extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private Container container;
	private JPanel painelSup;
	private JPanel painelInf;
	private JLabel componentes;
	private JPanel painelNomes;
	private JLabel neto;
	private JLabel luis;
	private JButton buttonFechar;
	private JPanel painelBotao;
	
	private List<JLabel> sobre;
	
	public DialogSobre() {
		setTitle("Sobre o pEdit");
		setSize(400, 255);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		container = getContentPane();
		container.setLayout(new GridLayout(2, 1, 0, 10));
		
		componentes = new JLabel("Componentes:", JLabel.CENTER);
		componentes.setForeground(Color.BLUE);
		painelNomes = new JPanel(new FlowLayout());
		neto = new JLabel("Francisco Neto Carvalho de Araujo", JLabel.CENTER);
		neto.setForeground(Color.BLUE);
		luis = new JLabel("Luis Guilherme Teixeira dos Santos", JLabel.CENTER);
		luis.setForeground(Color.BLUE);
		
		Random random = new Random();
		int i = random.nextInt(2);
		if (i == 0) {
			painelNomes.add(neto);
			painelNomes.add(luis);
		} else {
			painelNomes.add(luis);
			painelNomes.add(neto);
		}
		
		buttonFechar = new JButton("Fechar");
		buttonFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		painelBotao = new JPanel(new FlowLayout());
		painelBotao.add(buttonFechar);
		
		painelSup = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		sobre = new ArrayList<JLabel>();
		sobre.add(new JLabel("pEdit é uma IDE integrada a um compilador para"));
		sobre.add(new JLabel("Portugol Simplificado, solicitados pelo professor"));
		sobre.add(new JLabel("Raimundo Santos Moura Junior, como trabalho final"));
		sobre.add(new JLabel("da disciplina Construcao de Compiladores, ministrada"));
		sobre.add(new JLabel("no período 2015.1"));
		
		for (JLabel jLabel : sobre) {
			painelSup.add(jLabel);
		}

		
		painelInf = new JPanel(new BorderLayout(0, 5));
		painelInf.add(componentes, BorderLayout.NORTH);
		painelInf.add(painelNomes, BorderLayout.CENTER);
		painelInf.add(painelBotao, BorderLayout.SOUTH);
		
		container.add(painelSup);
		container.add(painelInf);
		
		setVisible(true);
	}

}
