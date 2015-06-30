package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.swing.JOptionPane;

import ast.No;
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
		codigo = ".class public " + nomeProg + "\n";
		codigo += ".super java/lang/Object\n\n";
		codigo += ".field public static scanner_field Ljava/util/Scanner;\n\n";
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
		// inserir metodos padroes
		geraConstrutor();
		codigo += leInteiro();
		codigo += leFloat();
		codigo += leString();

		codigo += pause();

		codigo += ".method public static main([Ljava/lang/String;)V\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n\n";

		codigo += "new java/util/Scanner\n";
		codigo += "dup\n";
		codigo += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codigo += "invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V\n\n";
	} // fim abreMain

	public void fechaMain() {
		codigo += "\n";
		codigo += "invokestatic " + nomeProg + ".pause()V\n";

		codigo += "return\n";
		codigo += ".end method";

		if (gerar) {
			salvarArquivoJasmin();
			try {
				gerarArquivoClass();
			} catch (GerarClassException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	} // fim fechaMain

	public void gerarLer(int tipo, int enderecoLocal) {
		codigo += "\n";
		codigo += "invokestatic " + nomeProg + "." + getTipoLeitura(tipo)
				+ "\n";
		codigo += getTipoDaExpressao(tipo) + "store " + enderecoLocal + "\n";
	} // fim geraLer

	public void gerarEscrever(int tipo, int enderecoLocal) {
		codigo += "\n";
		codigo += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codigo += getTipoDaExpressao(tipo) + "load " + enderecoLocal + "\n";
		codigo += "invokevirtual java/io/PrintStream/println("
				+ getTipoDeDado(tipo) + ")V\n\n";
	} // fim geraEscrever

	public void geraEscreverMensagem(String mensagem) {
		codigo += "\n";
		codigo += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codigo += "ldc " + mensagem + "\n";
		codigo += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n\n";
	} // fim geraEscreverMensagem

	private String leInteiro() {
		String codLeInteiro = "";
		codLeInteiro += ".method public static leInteiro()I\n";
		codLeInteiro += ".limit stack 5\n";
		codLeInteiro += "new java/io/BufferedReader\n";
		codLeInteiro += "dup\n";
		codLeInteiro += "new java/io/InputStreamReader\n";
		codLeInteiro += "dup\n";
		codLeInteiro += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codLeInteiro += "invokespecial java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V\n";
		codLeInteiro += "invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V\n";
		codLeInteiro += "invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;\n";
		codLeInteiro += "invokestatic java/lang/Integer/parseInt(Ljava/lang/String;)I\n";
		codLeInteiro += "ireturn\n";
		codLeInteiro += ".end method\n\n";

		return codLeInteiro;
	} // fim leInteiro

	private String leFloat() {
		String codLeFloat = "";
		codLeFloat += ".method public static leFloat()F\n";
		codLeFloat += ".limit stack 5\n";
		codLeFloat += "new java/io/BufferedReader\n";
		codLeFloat += "dup\n";
		codLeFloat += "new java/io/InputStreamReader\n";
		codLeFloat += "dup\n";
		codLeFloat += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codLeFloat += "invokespecial java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V\n";
		codLeFloat += "invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V\n";
		codLeFloat += "invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;\n";
		codLeFloat += "invokestatic java/lang/Float/parseFloat(Ljava/lang/String;)F\n";
		codLeFloat += "freturn\n";
		codLeFloat += ".end method\n\n";

		return codLeFloat;
	} // fim leFloat

	private String leString() {
		String codLeString = "";
		codLeString += ".method public static leString()Ljava/lang/String;\n";
		codLeString += ".limit stack 5\n";
		codLeString += "new java/io/BufferedReader\n";
		codLeString += "dup\n";
		codLeString += "new java/io/InputStreamReader\n";
		codLeString += "dup\n";
		codLeString += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codLeString += "invokespecial java/io/InputStreamReader/<init>(Ljava/io/InputStream;)V\n";
		codLeString += "invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V\n";
		codLeString += "invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;\n";
		codLeString += "areturn\n";
		codLeString += ".end method\n\n";

		return codLeString;
	} // fim leString

	private String pause() {
		String codPause = "";
		codPause += ".method public static pause()V\n";
		codPause += ".limit stack 5\n";
		codPause += ".limit locals 5\n";
		codPause += "getstatic java/lang/System/out Ljava/io/PrintStream;\n";
		codPause += "ldc \"Pressione ENTER para continuar...\"\n";
		codPause += "invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V\n";
		codPause += "getstatic java/lang/System/in Ljava/io/InputStream;\n";
		codPause += "invokevirtual java/io/InputStream/read()I\n";
		codPause += "return\n";
		codPause += ".end method\n\n";

		return codPause;
	} // fim pause

	public void abreDeclrVar(int tipo, int enderecoGlobal, int enderecoLocal,
			int escopo, String id) {
		if (escopo == 0) {
			codigo += ".field public " + id + " " + getTipoDeDado(tipo) + " = "
					+ getInicializacaoPorTipo(tipo) + "\n";
		} else {
			codigo += "ldc " + getInicializacaoPorTipo(tipo) + "\n";
			codigo += getTipoDaExpressao(tipo) + "store " + enderecoLocal
					+ "\n";
		}
	} // fim abreDeclrVar

	public void abreFuncao(int tipo, String idFuncao, int qtdVar,
			List<InfoVariavel> parametros) {
		codigo += "\n.method public static " + idFuncao + "(";

		// insere os tipos dos parametros
		for (InfoVariavel param : parametros) {
			codigo += getTipoDeDado(param.getTipo());
		}

		codigo += ")" + getTipoDeDado(tipo) + "\n";
		codigo += ".limit stack " + (10 * qtdVar + 10) + "\n";
		codigo += ".limit locals " + (qtdVar + 10) + "\n\n";

	} // fim abreFuncao

	public void fechaFuncao(int tipo, int endLocalRetorno) {

		codigo += getTipoDaExpressao(tipo);
		codigo += "load " + endLocalRetorno + "\n";
		codigo += getTipoDaExpressao(tipo) + "return\n";
		codigo += ".end method\n";

	} // fim fechaFuncao

	public void gerarAtribuicao(ArrayList<No> nos, Integer tipoExpressao,
			Integer keyVarRetorno) {
		String tipoDeExpressao = getTipoDaExpressao(tipoExpressao);
		codigo += "\n;INICIO ATRIBUICAO\n";

		for (int i = nos.size() - 1; i >= 0; i--) {
			if (nos.get(i).getAtributo("tipo").compareTo("op") == 0) {
				if (getTipoDaOperacao(nos.get(i).toString()) != null) {
					codigo += tipoDeExpressao
							+ getTipoDaOperacao(nos.get(i).toString()) + "\n";
				} else {
					// PRECISA IMPLEMENTAR A UTILIZACAO DE OPERADORES LOGICO
					// AQUI!
				}
			} else if (nos.get(i).getAtributo("tipo").compareTo("id") == 0) {
				codigo += tipoDeExpressao + "load "
						+ nos.get(i).getAtributo("posicao") + "\n";
			} else {
				codigo += "ldc " + nos.get(i).toString() + "\n";
			}
		}
		codigo += tipoDeExpressao + "store " + keyVarRetorno + "\n"
				+ ";FIM ATRIBUICAO" + "\n";
	}

	public void chamadaMetodo(String nomeDoMetodo, String argumentos,
			List<Integer> tiposArgsVars, int endLocalRetorno, int tipoDeRetorno) {
		String tipos = "";

		if (tiposArgsVars != null) {
			for (int i = 0; i < tiposArgsVars.size(); i++) {
				tipos += getTipoDeDado(tiposArgsVars.get(i));
			}
		}

		codigo += argumentos + "\ninvokestatic " + this.nomeProg + "."
				+ nomeDoMetodo + "(" + tipos + ")"
				+ getTipoDeDado(tipoDeRetorno) + "\n"
				+ getTipoDaExpressao(tipoDeRetorno) + "store "
				+ endLocalRetorno + "\n";
	}

	private String getTipoDeDado(int tipoDeDado) {
		switch (tipoDeDado) {
		case Constantes.INTEIRO:
		case Constantes.LOGICO:
			return "I";
		case Constantes.REAL:
			return "F";
		default:
			return "Ljava/lang/String;";
		}
	} // fim getTipoDeDado

	public String getTipoDaExpressao(int tipoExpressao) {
		switch (tipoExpressao) {
		case Constantes.INTEIRO:
		case Constantes.LOGICO:
			return "i";
		case Constantes.REAL:
			return "f";
		default:
			return "a";
		}
	} // fim getTipoDaExpressao

	private String getTipoDaOperacao(String tipoOperacao) {
		switch (tipoOperacao) {
		case "*":
			return "mul";
		case "/":
			return "div";
		case "+":
			return "add";
		case "-":
			return "sub";
		}
		return null;
	} // fim getTipoDaOperacao

	private String getTipoLeitura(int tipo) {
		switch (tipo) {
		case Constantes.INTEIRO:
			return "leInteiro()I";
		case Constantes.REAL:
			return "leFloat()F";
		default:
			return "leString()Ljava/lang/String;";
		}
	}

	private String getInicializacaoPorTipo(int tipo) {
		switch (tipo) {
		case Constantes.INTEIRO:
		case Constantes.LOGICO:
			return "0";
		case Constantes.REAL:
			return "0.0";
		default:
			return "\"\"";
		}
	} // fim getInicializacaoPorTipo

	private void gerarArquivoClass() throws GerarClassException {

		String pathJasmin = GeraCodigo.class.getClassLoader().getResource("")
				.getPath()
				+ "lib" + SEP + "jasmin.jar";

		ProcessBuilder pb = new ProcessBuilder("java", "-jar", pathJasmin,
				pathArq);

		pb.directory(new File(diretorio));

		Process process;
		try {
			process = pb.start();
			process.waitFor();

			BufferedReader readerSucesso = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			BufferedReader readerErro = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));

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

	private void salvarArquivoJasmin() {
		File arquivo = new File(pathArq);
		try {
			Formatter saida = new Formatter(arquivo);
			saida.format("%s", codigo);
			saida.close();
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Ocorreu um erro na producao do codigo e o mesmo nao foi gerado",
							"Erro", JOptionPane.ERROR_MESSAGE);
		}
	} // salvarArquivoJasmin

	public void executar() throws ExecutarCodigoException {
		String comando = "java " + nomeProg;

		ProcessBuilder pb = new ProcessBuilder("gnome-terminal", "-e", comando);

		pb.directory(new File(diretorio));

		Process process;
		try {
			process = pb.start();
			process.waitFor();

			BufferedReader readerSucesso = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			BufferedReader readerErro = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));

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

} // fim classe GeraCodigo
