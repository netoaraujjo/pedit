/**
 * 
 */
package exceptions;

/**
 * @author neto
 *
 */
public class ArquivoJaExistenteException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ArquivoJaExistenteException() {
		super("Arquivo já existente!");
	}
	
}
