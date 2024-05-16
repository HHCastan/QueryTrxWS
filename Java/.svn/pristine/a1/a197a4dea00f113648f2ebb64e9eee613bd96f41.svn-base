
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
 *         &lt;element name="pIngreso" type="{http://www.flamingo.com.co}Autenticacion" minOccurs="0"/>
 *         &lt;element name="pAprobacion" type="{http://www.flamingo.com.co}Aprobacion" minOccurs="0"/>
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
    "pIngreso",
    "pAprobacion"
})
@XmlRootElement(name = "CrearAprobacion")
public class CrearAprobacion {

    @XmlElementRef(name = "pIngreso", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<Autenticacion> pIngreso;
    @XmlElementRef(name = "pAprobacion", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<Aprobacion> pAprobacion;

    /**
     * Obtiene el valor de la propiedad pIngreso.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}
     *     
     */
    public JAXBElement<Autenticacion> getPIngreso() {
        return pIngreso;
    }

    /**
     * Define el valor de la propiedad pIngreso.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}
     *     
     */
    public void setPIngreso(JAXBElement<Autenticacion> value) {
        this.pIngreso = value;
    }

    /**
     * Obtiene el valor de la propiedad pAprobacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Aprobacion }{@code >}
     *     
     */
    public JAXBElement<Aprobacion> getPAprobacion() {
        return pAprobacion;
    }

    /**
     * Define el valor de la propiedad pAprobacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Aprobacion }{@code >}
     *     
     */
    public void setPAprobacion(JAXBElement<Aprobacion> value) {
        this.pAprobacion = value;
    }

}
