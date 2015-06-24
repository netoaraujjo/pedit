package exceptions;

public class ExecutarCodigoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExecutarCodigoException() {
		super("Erro ao executar o código!");
	}

}
