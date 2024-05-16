package com.linea.posappEnginePromotions.contenedores;

/**
 * @author edgar.cuesta
 * Clase que generaliza cada uno de los contenedores de propiedades
 *
 */
public interface ContenedorAbstract
{
    
    /**
     * Se encarga de realizar la carga de propiedades a petición, es el que
     * lee los archivos, xml, bd, etc, de donde quiero que se extraigan las
     * propiedades
     */
    public void cargaPropiedades();
    /**
     * Se encarga de realizar la carga de propiedades a petición, es el que
     * lee los archivos, xml, bd, etc, de donde quiero que se extraigan las
     * propiedades (solo para ambientes Windows
     */
    public void cargaPropiedadesWIN();
    /**
     * Método que recibe una clave, y devuelve un valor asociado a la misma.
     * @param clave Clave mediante la que extraeré el Valor
     * @return Valor correspondiente a la clave enviada
     */
    public String extraerPropiedad(String clave);
}
