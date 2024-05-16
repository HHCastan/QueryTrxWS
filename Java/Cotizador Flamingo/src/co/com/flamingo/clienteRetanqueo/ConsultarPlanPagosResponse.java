
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
 *         &lt;element name="ConsultarPlanPagosResult" type="{http://www.flamingo.com.co}ConsultarPlanPagosRes" minOccurs="0"/>
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
    "consultarPlanPagosResult"
})
@XmlRootElement(name = "ConsultarPlanPagosResponse")
public class ConsultarPlanPagosResponse {

    @XmlElementRef(name = "ConsultarPlanPagosResult", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<ConsultarPlanPagosRes> consultarPlanPagosResult;

    /**
     * Obtiene el valor de la propiedad consultarPlanPagosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConsultarPlanPagosRes }{@code >}
     *     
     */
    public JAXBElement<ConsultarPlanPagosRes> getConsultarPlanPagosResult() {
        return consultarPlanPagosResult;
    }

    /**
     * Define el valor de la propiedad consultarPlanPagosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConsultarPlanPagosRes }{@code >}
     *     
     */
    public void setConsultarPlanPagosResult(JAXBElement<ConsultarPlanPagosRes> value) {
        this.consultarPlanPagosResult = value;
    }

}
