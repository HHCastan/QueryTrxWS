
package co.com.flamingo.clienteRetanqueo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CrearAprobacionResult" type="{http://www.flamingo.com.co}CrearAprobacionRes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "crearAprobacionResult"
})
@XmlRootElement(name = "CrearAprobacionResponse")
public class CrearAprobacionResponse {

    @XmlElementRef(name = "CrearAprobacionResult", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<CrearAprobacionRes> crearAprobacionResult;

    /**
     * Obtiene el valor de la propiedad crearAprobacionResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CrearAprobacionRes }{@code >}
     *     
     */
    public JAXBElement<CrearAprobacionRes> getCrearAprobacionResult() {
        return crearAprobacionResult;
    }

    /**
     * Define el valor de la propiedad crearAprobacionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CrearAprobacionRes }{@code >}
     *     
     */
    public void setCrearAprobacionResult(JAXBElement<CrearAprobacionRes> value) {
        this.crearAprobacionResult = value;
    }

}
