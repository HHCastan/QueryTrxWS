
package co.com.flamingo.clienteRetanqueo;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para infoRetanqueo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="infoRetanqueo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CentralRiesgos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CupoDisponible" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FechaFinal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FechaInicial" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IDCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoIdCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infoRetanqueo", propOrder = {
    "centralRiesgos",
    "cupoDisponible",
    "fechaFinal",
    "fechaInicial",
    "idCliente",
    "tipoIdCliente"
})
public class InfoRetanqueo {

    @XmlElementRef(name = "CentralRiesgos", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<String> centralRiesgos;
    @XmlElement(name = "CupoDisponible")
    protected BigDecimal cupoDisponible;
    @XmlElement(name = "FechaFinal")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaFinal;
    @XmlElement(name = "FechaInicial")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaInicial;
    @XmlElementRef(name = "IDCliente", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idCliente;
    @XmlElementRef(name = "TipoIdCliente", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoIdCliente;

    /**
     * Obtiene el valor de la propiedad centralRiesgos.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCentralRiesgos() {
        return centralRiesgos;
    }

    /**
     * Define el valor de la propiedad centralRiesgos.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCentralRiesgos(JAXBElement<String> value) {
        this.centralRiesgos = value;
    }

    /**
     * Obtiene el valor de la propiedad cupoDisponible.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCupoDisponible() {
        return cupoDisponible;
    }

    /**
     * Define el valor de la propiedad cupoDisponible.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCupoDisponible(BigDecimal value) {
        this.cupoDisponible = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFinal.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Define el valor de la propiedad fechaFinal.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaFinal(XMLGregorianCalendar value) {
        this.fechaFinal = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInicial.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Define el valor de la propiedad fechaInicial.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicial(XMLGregorianCalendar value) {
        this.fechaInicial = value;
    }

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIDCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDCliente(JAXBElement<String> value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoIdCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoIdCliente() {
        return tipoIdCliente;
    }

    /**
     * Define el valor de la propiedad tipoIdCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoIdCliente(JAXBElement<String> value) {
        this.tipoIdCliente = value;
    }

}
