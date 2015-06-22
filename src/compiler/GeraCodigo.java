package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

import javax.swing.JOptionPane;

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
	}
	
	public void abreMain(int qtdVar) {
		codigo += ".method public static main([Ljava/lang/String;)V\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n";
		
		codigo += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codigo += "ldc \"Digite dois valores:\"\n";
		codigo += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";
	}
	
	public void fechaMain() {
		codigo += "return\n";
		codigo += ".end method";
		imprimeCodigo();
		if (gerar) {
			salvarArquivoJasmin();
			try {
				gerarArquivoClass();
				gerarArquivoSh();
				executar();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void gerarArquivoClass() throws IOException, InterruptedException {
		
		String pathJasmin = GeraCodigo.class.getClassLoader().getResource("").getPath() + "lib"+ SEP +"jasmin.jar";
		
		ProcessBuilder pb = new ProcessBuilder(
				"java", 
				"-jar", 
				pathJasmin, 
				pathArq);
		
		pb.directory(new File(diretorio));
		
		Process process = pb.start();
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
	}
	
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
	
	private void gerarArquivoSh() throws InterruptedException, IOException {
		File arquivo = new File(diretorio + SEP + nomeProg + ".sh");
		String conteudo = "java " + nomeProg;
		try {
			Formatter saida = new Formatter(arquivo);
			saida.format("%s", conteudo);
			saida.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(
					null,
					"Ocorreu um erro na producao do executavel e o mesmo nao foi gerado",
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		
		ProcessBuilder pb = new ProcessBuilder(
				"chmod", 
				"+x", 
				nomeProg + ".sh");
		
		pb.directory(new File(diretorio));
		
		Process process = pb.start();
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
	}
	
	private void executar() throws IOException, InterruptedException {
		
		ProcessBuilder pb = new ProcessBuilder("." + SEP + nomeProg + ".sh");
		
		pb.directory(new File(diretorio));
		
		Process process = pb.start();
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
		
	}
}
