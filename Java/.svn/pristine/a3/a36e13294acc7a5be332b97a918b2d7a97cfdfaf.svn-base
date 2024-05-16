
package co.com.flamingo.clienteRetanqueo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CrearAprobacionRes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CrearAprobacionRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosAprobacion" type="{http://www.flamingo.com.co}infoAprobacion" minOccurs="0"/>
 *         &lt;element name="RespuestaMetodo" type="{http://www.flamingo.com.co}RespuestaMetodo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CrearAprobacionRes", propOrder = {
    "datosAprobacion",
    "respuestaMetodo"
})
public class CrearAprobacionRes {

    @XmlElementRef(name = "DatosAprobacion", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<InfoAprobacion> datosAprobacion;
    @XmlElementRef(name = "RespuestaMetodo", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<RespuestaMetodo> respuestaMetodo;

    /**
     * Obtiene el valor de la propiedad datosAprobacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InfoAprobacion }{@code >}
     *     
     */
    public JAXBElement<InfoAprobacion> getDatosAprobacion() {
        return datosAprobacion;
    }

    /**
     * Define el valor de la propiedad datosAprobacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InfoAprobacion }{@code >}
     *     
     */
    public void setDatosAprobacion(JAXBElement<InfoAprobacion> value) {
        this.datosAprobacion = value;
    }

    /**
     * Obtiene el valor de la propiedad respuestaMetodo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}
     *     
     */
    public JAXBElement<RespuestaMetodo> getRespuestaMetodo() {
        return respuestaMetodo;
    }

    /**
     * Define el valor de la propiedad respuestaMetodo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}
     *     
     */
    public void setRespuestaMetodo(JAXBElement<RespuestaMetodo> value) {
        this.respuestaMetodo = value;
    }

}
