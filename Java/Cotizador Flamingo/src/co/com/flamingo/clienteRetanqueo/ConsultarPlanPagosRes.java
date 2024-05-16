
package co.com.flamingo.clienteRetanqueo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarPlanPagosRes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarPlanPagosRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosCredito" type="{http://www.flamingo.com.co}infoCredito" minOccurs="0"/>
 *         &lt;element name="PlanPagos" type="{http://www.flamingo.com.co}ArrayOfPlanPagos" minOccurs="0"/>
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
@XmlType(name = "ConsultarPlanPagosRes", propOrder = {
    "datosCredito",
    "planPagos",
    "respuestaMetodo"
})
public class ConsultarPlanPagosRes {

    @XmlElementRef(name = "DatosCredito", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<InfoCredito> datosCredito;
    @XmlElementRef(name = "PlanPagos", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPlanPagos> planPagos;
    @XmlElementRef(name = "RespuestaMetodo", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<RespuestaMetodo> respuestaMetodo;

    /**
     * Obtiene el valor de la propiedad datosCredito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InfoCredito }{@code >}
     *     
     */
    public JAXBElement<InfoCredito> getDatosCredito() {
        return datosCredito;
    }

    /**
     * Define el valor de la propiedad datosCredito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InfoCredito }{@code >}
     *     
     */
    public void setDatosCredito(JAXBElement<InfoCredito> value) {
        this.datosCredito = value;
    }

    /**
     * Obtiene el valor de la propiedad planPagos.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPlanPagos }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPlanPagos> getPlanPagos() {
        return planPagos;
    }

    /**
     * Define el valor de la propiedad planPagos.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPlanPagos }{@code >}
     *     
     */
    public void setPlanPagos(JAXBElement<ArrayOfPlanPagos> value) {
        this.planPagos = value;
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
