package exceptions;

public class GerarClassException extends Exception {

	private static final long serialVersionUID = 1L;

	public GerarClassException() {
		super("Erro ao gerar o arquivo .class! Bytecode não gerado.");
	}

}
