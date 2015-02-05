package ieci.tecdoc.sgm.tram.sign;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.ispaclib.sign.ISignConnector;

import java.util.List;

import com.lowagie.text.pdf.PdfContentByte;

public interface ISigemSignConnector extends ISignConnector {

	/**
	 * Genera la imagen para la banda gris lateral del documento PDF a firmar.
	 *
	 * @param dateFirma
	 *            Fecha de la firma.
	 * @param pdfContentByte
	 *            Contenido del documento PDF para el que se genera la banda
	 *            gris lateral.
	 * @param margen
	 *            Margen para la banda lateral.
	 * @param vh
	 *            Indicador de orientaci�n del documento (vertical/horizontal).
	 * @param x
	 *            Ancho de l�nea para cada l�nea de la banda.
	 * @param numberOfPages
	 *            N�mero de p�ginas del documento PDF.
	 * @param pageActual
	 *            N�mero de p�gina actual.
	 * @param codCotejo
	 *            C�digo de cotejo (c�digo seguro de verificaci�n) para el
	 *            documento.
	 * @param signerList
	 *            Lista de firmantes a mostrar en la banda lateral.
	 *
	 * @throws ISPACException
	 *             Si se produce alg�n error.
	 */
	public void generateGrayBandImagen(String dateFirma,
			PdfContentByte pdfContentByte, float margen, boolean vh, float x,
			int numberOfPages, int pageActual, String codCotejo, List signerList)
			throws ISPACException;

}
