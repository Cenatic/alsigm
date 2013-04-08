/*
 * Created on 02-jun-2004
 *
 */
package ieci.tdw.ispac.api.rule;

import ieci.tdw.ispac.api.errors.ISPACRuleException;


public interface IRule
{
	  /**
	   *Funci�n de inicializaci�n del evento.
	   *@param docTXContext Documento XML con la descripci�n del contexto de ejecuci�n del evento.
	   *@param itx Interface para solicitar transacciones de ISPAC
	   *@return true si la inicializaci�n se ha ejecutado correctamente
	   */

	  public boolean init(IRuleContext rulectx)
	  	throws ISPACRuleException;

	  /**
	   *Funci�n de validaci�n del evento.
	   *@return La funci�n debe devolver false si, por alguna regla de negocio, el evento no
	   *est� autorizado (por ejemplo, falta por cumplimentar alg�n campo obligatorio)
	   */
	  public boolean validate(IRuleContext rulectx)
	  	throws ISPACRuleException;

	  /**
	   *Funci�n de personalizaci�n del evento.
	   *Aqu� se definen las acciones asociadas al evento
	   *@return Se debe devolver un objeto si el tipo de evento lo necesita
	   *(calculo de responsables, etc)
	   */
	  public Object execute(IRuleContext rulectx)
	  	throws ISPACRuleException;

	  /**
	   *El sistema invoca esta funci�n si se encuentra con alg�n problema
	   *durante la ejecuci�n del evento. Permitir�a deshacer operaciones
	   *realizadas en el m�todo execute()
	   */
	  public void cancel(IRuleContext rulectx)
	  	throws ISPACRuleException;
}
