
package co.com.flamingo.clienteRetanqueo;

import java.math.BigDecimal;
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
 *         &lt;element name="pNumeroAprobacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pValorAprobacion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="pCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pNumeroAprobacion",
    "pValorAprobacion",
    "pCliente"
})
@XmlRootElement(name = "SimularPlanPagos")
public class SimularPlanPagos {

    @XmlElementRef(name = "pIngreso", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<Autenticacion> pIngreso;
    @XmlElementRef(name = "pNumeroAprobacion", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pNumeroAprobacion;
    protected BigDecimal pValorAprobacion;
    @XmlElementRef(name = "pCliente", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pCliente;

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
     * Obtiene el valor de la propiedad pNumeroAprobacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPNumeroAprobacion() {
        return pNumeroAprobacion;
    }

    /**
     * Define el valor de la propiedad pNumeroAprobacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPNumeroAprobacion(JAXBElement<String> value) {
        this.pNumeroAprobacion = value;
    }

    /**
     * Obtiene el valor de la propiedad pValorAprobacion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPValorAprobacion() {
        return pValorAprobacion;
    }

    /**
     * Define el valor de la propiedad pValorAprobacion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPValorAprobacion(BigDecimal value) {
        this.pValorAprobacion = value;
    }

    /**
     * Obtiene el valor de la propiedad pCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPCliente() {
        return pCliente;
    }

    /**
     * Define el valor de la propiedad pCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPCliente(JAXBElement<String> value) {
        this.pCliente = value;
    }

}
