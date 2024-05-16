
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
 *         &lt;element name="SimularPlanPagosResult" type="{http://www.flamingo.com.co}SimularPlanPagosRes" minOccurs="0"/>
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
    "simularPlanPagosResult"
})
@XmlRootElement(name = "SimularPlanPagosResponse")
public class SimularPlanPagosResponse {

    @XmlElementRef(name = "SimularPlanPagosResult", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<SimularPlanPagosRes> simularPlanPagosResult;

    /**
     * Obtiene el valor de la propiedad simularPlanPagosResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SimularPlanPagosRes }{@code >}
     *     
     */
    public JAXBElement<SimularPlanPagosRes> getSimularPlanPagosResult() {
        return simularPlanPagosResult;
    }

    /**
     * Define el valor de la propiedad simularPlanPagosResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SimularPlanPagosRes }{@code >}
     *     
     */
    public void setSimularPlanPagosResult(JAXBElement<SimularPlanPagosRes> value) {
        this.simularPlanPagosResult = value;
    }

}
