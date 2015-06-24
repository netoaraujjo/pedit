package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

import javax.swing.JOptionPane;

import util.Constantes;
import exceptions.ExecutarCodigoException;
import exceptions.GerarClassException;

public class GeraCodigo {
	private final String SEP = File.separator;
	private String pathArq;
	private String nomeProg;
	private String codigo;
	private boolean gerar;
	private String diretorio;
	
	
	public GeraCodigo(File arq) {
		this.nomeProg = arq.getName().substring(0, arq.getName().length() - 4);
		diretorio = arq.getParent();
		this.pathArq = diretorio + SEP + nomeProg + ".j";
		this.gerar = true;
		inicializa();
	}
	
	
	public void setGerar(boolean gerar) {
		this.gerar = gerar;
	}
	
	
	private void inicializa() {
		codigo  = ".class public " + nomeProg + "\n";
		codigo += ".super java/lang/Object\n\n";		
	} // fim inicializa
	
	
	public void abreMain(int qtdVar) {
		codigo += "\n";
		codigo += ".method public static main([Ljava/lang/String;)V\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n\n";
	} // fim abreMain
	
	
	public void fechaMain() {
		
		codigo += "invokestatic " + nomeProg + ".pause()V\n\n";
		
		codigo += "return\n";
		codigo += ".end method\n\n";
		
		codigo += ".method public static pause()V\n";
		codigo += ".limit stack 10\n";
		codigo += ".limit locals 10\n\n";
		
		codigo += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codigo += "ldc \"Pressione ENTER para continuar...\"\n";
		codigo += "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n\n";
		
		codigo += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codigo += "invokevirtual java/io/InputStream/read()I\n\n";
		
		codigo += "return\n\n";
		
		codigo += ".end method";
		
		imprimeCodigo();
		
		if (gerar) {
			salvarArquivoJasmin();
			try {
				gerarArquivoClass();
				executar();
			} catch (GerarClassException e) {
				JOptionPane.showMessageDialog(
						null, 
						e.getMessage(), 
						"Erro", 
						JOptionPane.ERROR_MESSAGE);
			} catch (ExecutarCodigoException e) {
				JOptionPane.showMessageDialog(
						null, 
						e.getMessage(), 
						"Erro", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	} // fim fechaMain
	
	
	private void gerarArquivoClass() throws GerarClassException {
		
		String pathJasmin = GeraCodigo.class.getClassLoader().getResource("").getPath() + "lib"+ SEP +"jasmin.jar";
		
		ProcessBuilder pb = new ProcessBuilder(
				"java", 
				"-jar", 
				pathJasmin, 
				pathArq);
		
		pb.directory(new File(diretorio));
		
		Process process;
		try {
			process = pb.start();
			process.waitFor();
			
			BufferedReader readerSucesso =  new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader readerErro =  new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			String txt;
			
			while ((txt = readerErro.readLine()) != null) {
				System.out.println(txt + "\n");
			}
			
			while ((txt = readerSucesso.readLine()) != null) {
				System.out.println(txt + "\n");
			}
		} catch (IOException | InterruptedException e) {
			throw new GerarClassException();
		}
	} // fim gerarArquivoClass
	
	
	private void imprimeCodigo() {
		System.out.println(codigo);
	}
	
	
	private void salvarArquivoJasmin() {
		File arquivo = new File(pathArq);
		try {
			Formatter saida = new Formatter(arquivo);
			saida.format("%s", codigo);
			saida.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(
					null,
					"Ocorreu um erro na producao do codigo e o mesmo nao foi gerado",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	private void executar() throws ExecutarCodigoException {
		String comando = "java " + nomeProg;
		
		ProcessBuilder pb = new ProcessBuilder("gnome-terminal", "-e", comando);
		
		pb.directory(new File(diretorio));
		
		Process process;
		try {
			process = pb.start();
			process.waitFor();
			
			BufferedReader readerSucesso =  new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader readerErro =  new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			String txt;
			
			while ((txt = readerErro.readLine()) != null) {
				System.out.println(txt + "\n");
			}
			
			while ((txt = readerSucesso.readLine()) != null) {
				System.out.println(txt + "\n");
			}
		} catch (IOException | InterruptedException e) {
			throw new ExecutarCodigoException();
		}
	} // fim executar
	
	public void abreDeclrVar(int tipo, int endereco, int escopo, String id) {
		
		switch (tipo) {
			case Constantes.INTEIRO:
			case Constantes.LOGICO:
				if (escopo == 0) {
					codigo += ".field public " + id + " I\n";
				} else {
					codigo += "ldc 0\n";
					codigo += "istore " + endereco + "\n";
				}
				break;
			case Constantes.REAL:
				if (escopo == 0) {
					codigo += ".field public " + id + " F\n";
				} else {
					codigo += "ldc 0.0\n";
					codigo += "fstore " + endereco + "\n";
				}
				break;
			case Constantes.PALAVRA:
				if (escopo == 0) {
					codigo += ".field public " + id + " I\n";
				} else {
					codigo += "ldc \"\"\n";
					codigo += "astore " + endereco + "\n";
				}
				break;
			default:
				break;
		}
		
	}
}
