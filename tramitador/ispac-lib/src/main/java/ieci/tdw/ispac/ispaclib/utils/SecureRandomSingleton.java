package ieci.tdw.ispac.ispaclib.utils;

import java.security.SecureRandom;

/**
 * Se ha creado esta clase ante la necesidad de generar n�meros aleatorios
 * para la generaci�n de UIDs. Todos los Session Beans de tipo IspacSesion
 * que corran dentro de una misma m�quina virtual utilizar�n el mismo
 * generaror de n�meros aleatorios si utilizan esta clase para obtener el
 * SecureRandom
 */

public class SecureRandomSingleton 
{
  // Generador de n�meros aleatorios. Existir� duranta la vida de la JVM
  private static SecureRandom seeder;

  /**
   * Constructor privado que crea el generador de numeros aleatorios. Es privado
   * para que no sea llamado desde fuera y pueda as� generar un nuevo generador
   * de n�meros aleatorios.
   */
  private SecureRandomSingleton()
  {    
    seeder = new SecureRandom ();
  }

  /**
   * Devuelve el generador de n�meros aleatorios. Siempre devuelve el mismo. Si
   * no existe, lo crea, cosa que ocurrir� s�lo la primera vez que se llame a este
   * m�todo. 
   * @return generador de n�meros aletarios
   */
  public static synchronized SecureRandom getSecureRandomInstance ()
  {
    if (seeder == null)
      new SecureRandomSingleton ();      
    return seeder;
  }
  
}