package common.bi;

import common.exceptions.CheckedArchivoException;

/**
 * Se produce cuando se trata de realizar operaciones de selecci�n sobre una
 * serie y la serie no dispone de una valoraci�n dictaminada.
 */
public class SerieNoValoradaException extends CheckedArchivoException {

	private static final long serialVersionUID = 1L;

}