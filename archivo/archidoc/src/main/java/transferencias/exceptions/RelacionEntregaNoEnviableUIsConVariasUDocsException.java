/**
 *
 */
package transferencias.exceptions;

import common.exceptions.CheckedArchivoException;

/**
 * Una relaci�n de entrega entre archivos con reencajado, y formato nuevo no
 * multidoc solo permite una unidad documental por cada unidad de instalaci�n.
 * 
 * @author Iecisa
 * @version $Revision$
 * 
 */
public class RelacionEntregaNoEnviableUIsConVariasUDocsException extends
		CheckedArchivoException {

	private static final long serialVersionUID = -4782853517649190712L;

}
