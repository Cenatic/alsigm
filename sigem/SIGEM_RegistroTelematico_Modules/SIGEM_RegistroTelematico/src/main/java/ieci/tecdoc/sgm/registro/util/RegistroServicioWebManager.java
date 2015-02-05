/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/*
 * Created on 21-jul-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ieci.tecdoc.sgm.registro.util;


/**
 * @author IECI S.A.
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RegistroServicioWebManager {

	public RegistroServicioWebManager()
	{

	}
	
	/**
	 * Funci�n que comienza el proceso de registro y genera
	 * y devuelve el identificador global �nico de registro
	 * 
	 * @return Identificador �nico global.
	 * @throws Exception Si se produce alg�n error.
	 */
	public static String newRegistry() throws Exception
	{
		String registryNumber = null;
		return registryNumber;
	}
	
	/**
	 * Funci�n que recoge y persiste los datos del asiento
	 * de registro
	 * 
	 * @param guid Identificador �nico que relaciona el nuevo registro que se est� creando
	 * @param procedureId Identificador de tr�mite
	 * @param addressee Destinatario
	 * @param folderId N�mero de expediente
	 * @param specificData Datos de la solicitud
	 * @throws Exception Cuando se produce alg�n error.
	 */
	public static void setRegistryData(String guid, String procedureId, 
	 							String addressee, String folderId,
								String specificData) throws Exception
								
	{
	}
	
	/**
	 * Crea un nuevo documento asociado al registro abierto
	 * 
	 * @param guid Identificador �nico que relaciona el nuevo registro que se est� creando
	 * @param code Codigo de documento
	 * @param chunk Trozo de documento
	 * @throws Exception Si se produce alg�n error
	 */
	public static void addRegistryDocumentChunk(String guid, String code, String chunk) throws Exception
	{
	}
	
	/**
	 * Crea la solicitud de registro
	 * 
	 * @param guid Identificador �nico que relaciona el nuevo registro que se est� creando
	 * @return Documento xml con la solicitud de registro
	 * @throws Exception Si se produce alg�n error
	 */
	public static String createRegistryRequest(String guid) throws Exception
	{
	  String registryRequest = null;
	  return registryRequest;
	}
	
	
	/**
��� * Recupera un justificante de registro.
��� * 
��� * @param registryNumber N�mero de registro.
��� * @return El justificante de registro.
��� * @throws java.lang.Exception Si se produce alg�n error.
��� */
	public static String getRegistryReceipt(String registryNumber) throws Exception
	{
		String receipt = null;
	    return receipt;
	}
	
	/**
	 * Devuelve el n�mero de trozos en los que se 
	 * divide el documento que se pasa como par�metro
	 * 
	 * @param registryNumber N�mero de registro.
	 * @param code C�digo del documento
	 * @return Indice del trozo del documento pedido.
	 * @throws Exception
	 */
	public static int getDocumentChunks(String registryNumber, String code) throws Exception
	{
		int number = 0;
		return number;
	}
	
	/**
	 * Recupera el trozo del contenido i-�simo del documento 
	 * del asiento de registro que se pasa como par�metro.
	 * 
	 * @param registryNumber N�mero de registro
	 * @param code C�digo del documento
	 * @param index �ndice del trozo del documento pedido.
	 * @return El trozo del documento codificado en base64.
	 * @throws Exception
	 */
	public static String getDocumentContentChunk(String registryNumber, String code, int index) throws Exception
	{
		String chunk = null;
		return chunk;
	}
	
}
