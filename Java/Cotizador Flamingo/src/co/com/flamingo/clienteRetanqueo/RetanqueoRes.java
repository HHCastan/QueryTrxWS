
package co.com.flamingo.clienteRetanqueo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetanqueoRes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetanqueoRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RespuestaMetodo" type="{http://www.flamingo.com.co}RespuestaMetodo" minOccurs="0"/>
 *         &lt;element name="Retanqueo" type="{http://www.flamingo.com.co}infoRetanqueo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetanqueoRes", propOrder = {
    "respuestaMetodo",
    "retanqueo"
})
public class RetanqueoRes {

    @XmlElementRef(name = "RespuestaMetodo", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<RespuestaMetodo> respuestaMetodo;
    @XmlElementRef(name = "Retanqueo", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<InfoRetanqueo> retanqueo;

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

    /**
     * Obtiene el valor de la propiedad retanqueo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InfoRetanqueo }{@code >}
     *     
     */
    public JAXBElement<InfoRetanqueo> getRetanqueo() {
        return retanqueo;
    }

    /**
     * Define el valor de la propiedad retanqueo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InfoRetanqueo }{@code >}
     *     
     */
    public void setRetanqueo(JAXBElement<InfoRetanqueo> value) {
        this.retanqueo = value;
    }

}
