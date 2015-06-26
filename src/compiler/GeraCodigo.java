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
	} // fim construtor
	
	
	public void setGerar(boolean gerar) {
		this.gerar = gerar;
	} // fim setGerar
	
	
	private void inicializa() {
		codigo  = ".class public " + nomeProg + "\n";
		codigo += ".super java/lang/Object\n\n";
	} // fim inicializa
	
	
	public void geraConstrutor() {
		codigo += "\n";
		codigo += ".method public <init>()V\n";
		codigo += "aload_0\n";
		codigo += "invokespecial java/lang/Object/<init>()V\n";
		codigo += "return\n";
		codigo += ".end method\n\n";
	} // fim geraConstrutor
	
	public void abreMain(int qtdVar) {
		geraConstrutor();
		
		codigo += ".method public static main([Ljava/lang/String;)V\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n\n";
	} // fim abreMain
	
	
	public void fechaMain() {
		
		
		
		codigo += "\n";
		codigo += "invokestatic " + nomeProg + ".pause()V\n";
		
		codigo += "return\n";
		codigo += ".end method";
		
		codigo += pause();
		
		//imprimeCodigo();
		
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
	
	
	
	
	
	private String pause() {
		String codPause = "";
		codPause += "\n\n";
		codPause += ".method public static pause()V\n";
		codPause += ".limit stack 10\n";
		codPause += ".limit locals 10\n\n";
		
		codPause += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codPause += "ldc \"Pressione ENTER para continuar...\"\n";
		codPause += "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n\n";
		
		codPause += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codPause += "invokevirtual java/io/InputStream/read()I\n";
		
		codPause += "return\n";
		
		codPause += ".end method";
		
		return codPause;
	} // fim pause
	
	
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
	} // fim imprimeCodigo
	
	
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
	} // salvarArquivoJasmin
	
	
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
	
	
	public void abreDeclrVar(int tipo, int enderecoGlobal, int enderecoLocal, int escopo, String id) {
		switch (tipo) {
			case Constantes.INTEIRO:
			case Constantes.LOGICO:
				if (escopo == 0) {
					codigo += ".field public " + id + " I = 0\n";
				} else {
					codigo += "ldc 0\n";
					codigo += "istore " + enderecoLocal + "\n";
				}
				break;
			case Constantes.REAL:
				if (escopo == 0) {
					codigo += ".field public " + id + " F = 0.0\n";
				} else {
					codigo += "ldc 0.0\n";
					codigo += "fstore " + enderecoLocal + "\n";
				}
				break;
			case Constantes.PALAVRA:
				if (escopo == 0) {
					codigo += ".field public " + id + " Ljava/lang/String; = \"\"\n";
				} else {
					codigo += "ldc \"\"\n";
					codigo += "astore " + enderecoLocal + "\n";
				}
				break;
		}
	} // fim abreDeclrVar
	
	
	public void abreFuncao(int tipo, String idFuncao, int qtdVar) {
		String tipoFunc = "";
		
		switch (tipo) {
			case Constantes.INTEIRO:
			case Constantes.LOGICO:
				tipoFunc = "I";
				break;
			case Constantes.REAL:
				tipoFunc = "F";
				break;
			case Constantes.PALAVRA:
				tipoFunc = "Ljava/lang/String;";
				break;
		}
		
		codigo += "\n.method public " + idFuncao + "()" + tipoFunc + "\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n\n";
	} // fim abreFuncao
	
	
	public void abreDeclaracaoParametro(int tipo, int enderecoGlobal, int enderecoLocal) {
		switch (tipo) {
			case Constantes.INTEIRO:
			case Constantes.LOGICO:
				codigo += "ldc 0\n";
				codigo += "istore " + enderecoLocal + "\n";
				break;
			case Constantes.REAL:
				codigo += "ldc 0.0\n";
				codigo += "fstore " + enderecoLocal + "\n";
				break;
			case Constantes.PALAVRA:
				codigo += "ldc \"\"\n";
				codigo += "astore " + enderecoLocal + "\n";
				break;
		}
	} // fim abreDeclaracaoParametro
	
	
	public void fechaFuncao(int tipo) {
		codigo += "\n";
		codigo += "ldc 0\n";
		switch (tipo) {
			case Constantes.INTEIRO:
			case Constantes.LOGICO:
				codigo += "ireturn";
				break;
			case Constantes.REAL:
				codigo += "freturn";
				break;
			case Constantes.PALAVRA:
				codigo += "areturn";
				break;
		}
		codigo += "\n";
		codigo += ".end method\n";
	} // fim fechaFuncao
}
