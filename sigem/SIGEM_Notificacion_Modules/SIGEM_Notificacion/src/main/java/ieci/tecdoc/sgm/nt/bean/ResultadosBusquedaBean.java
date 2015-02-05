/*
 * ResultadosBusquedaBean.java
 *
 * Created on 24 de mayo de 2007, 15:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ieci.tecdoc.sgm.nt.bean;

/**
 *
 * @author Usuario
 */
public final class ResultadosBusquedaBean  extends GenericoBean{
    
    private String error;
    private String descripcion;
    private String detalle;
    
    private java.util.ArrayList resultados;

    public ResultadosBusquedaBean() {
        resultados = new java.util.ArrayList();
    }

    /**
    * Devuelve el n�mero de resultados de la colecci�n.
    * @return int N�mero de resultados de la colecci�n.
    */
    public int count() {
        return resultados.size();
    }

    /**
     * Devuelve el resultado de la posici�n indicada dentro de la colecci�n
     * @param index Posici�n del resultado a recuperar.
     * @return Expediente asociado a registro.
     */
    public ResultadoBusquedaBean get(int index) {
        return (ResultadoBusquedaBean) resultados.get(index);
    }

    /**
     * A�ade un nuevo resultado a la colecci�n.
     * @param expediente Nueo resultado a a�adir.
     */
    public void add(ResultadoBusquedaBean nuevoValor_) {
    	resultados.add(nuevoValor_);
    }

    /**
     * Devuelve el valor del codigo de error
     * @return String codigo de error
     */
    public String getError() {
        return error;
    }

    /**
     * Establece el valor del codigo de error
     * @param error String nuevo valor del codigo de error
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Devuelve el valor de la descripcion del error
     * @return String descripcion del error
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el valor de la descripcion del error
     * @param descripcion String nuevo valor de la descripcion del error
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devielve el detalle del error
     * @return String detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Establece el valor del detalle del error
     * @param detalle String nuevo valor del detalle del error
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}
