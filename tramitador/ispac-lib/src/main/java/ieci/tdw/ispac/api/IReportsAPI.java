package ieci.tdw.ispac.api;

import ieci.tdw.ispac.api.errors.ISPACException;
import ieci.tdw.ispac.api.item.IItem;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Interfaz del API de gesti�n de informes.
 * 
 */
public interface IReportsAPI {

	
	/**
	 * Comprueba que el XML de la plantilla del informe sea v�lido. 
	 * @param xml XML de la plantilla del informe.
	 * @return true si el XML es v�lido, false en caso contrario.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public boolean checkReport(String xml) throws ISPACException;
	
	/**
	 * Genera el informe en formato PDF.
	 * @param ctReport Informaci�n del informe.
	 * @param position Posici�n que se imprime.
	 * @param numExp N�mero de expediente.
	 * @param locale Locale del cliente.
	 * @param out Salida del informe.
	 * @param stageId Fase actual sobre la que se esta trabajando
	 * @param taskId Tra�mite actual sobre el que se esta trabajando
	 * @param numExpsSearch Array con los n�meros de expedientes resultados de la b�squeda
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void generatePDFReport(IItem ctReport, String position, String numExp, Locale locale, OutputStream out, int stageId, int taskId, String [] numExpsSearch) throws ISPACException;

	/**
	 * Genera un informe en formato PDF a partir de una plantilla.
	 * @param template Plantilla en formato jrxml.
	 * @param params Par�metros del informe.
	 * @param con Conexi�n con la base de datos.
	 * @param out Informe en PDF.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void generatePDFReport(InputStream template, Map params, Connection con, OutputStream out) throws ISPACException;

	/**
	 * Genera un informe en formato RTF a partir de una plantilla compilada.
	 * @param template Plantilla compilada.
	 * @param params Par�metros del informe.
	 * @param con Conexi�n con la base de datos.
	 * @param out Informe en PDF.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void generateRTFReport(InputStream template, Map params, Connection con, OutputStream out) throws ISPACException;
	
	/**
	 * Compila la plantilla de un informe.
	 * @param ctReport Informaci�n del informe.
	 * @return Fichero de la plantilla compilada.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public File compileReport(IItem ctReport) throws ISPACException ;
	
    /**
     * Obtiene la lista de responsables a los que se ha asignado el informe.
     * @param reportId Identificador del informe.
     * @return Lista de responsables asignados al informe.
     * @throws ISPACException si ocurre alg�n error.
     */
    public List getReportOrganization(int reportId) throws ISPACException;

    /**
     * Elimina los responsables recibidos en responsiblesIds del informe cuyo id sea el recibido en idReport
     * @param idReport Identificador del informe
     * @param responsibleIds Array con la lista de responsable a desasociar del informe
     * @throws ISPACException
     */
    public void deleteResponsiblesReport(String idReport, String[] responsibleIds)throws ISPACException;
    
    /**
	 * Genera el informe en formato PDF.
	 * 
	 * @param ctReport Informaci�n del informe.
	 * @param position Posici�n que se imprime.
	 * @param numExp N�mero de expediente.
	 * @param locale Locale del cliente.
	 * @param out Salida del informe.
	 * @param stageId Fase actual sobre la que se esta trabajando.
	 * @param taskId Tra�mite actual sobre el que se esta trabajando.
	 * @param numExpsSearch Array con los n�meros de expedientes resultado de la b�squeda.
	 * @param extraParams Par�metros extra para el informe.
	 * @throws ISPACException si ocurre alg�n error.
	 */
	public void generatePDFReport(IItem ctReport, String position, String numExp, Locale locale, OutputStream out, int stageId, int taskId, String[] numExpedientes, Map extraParams)
	throws ISPACException;
	
	/**
	 * Valida el valor que ha indicado el usuario para los par�metros del informe
	 * @param values
	 * @param types
	 * @throws ISPACException
	 */
	public void validatePDFReportParams(Map values,	Map types)
	throws ISPACException;

}
