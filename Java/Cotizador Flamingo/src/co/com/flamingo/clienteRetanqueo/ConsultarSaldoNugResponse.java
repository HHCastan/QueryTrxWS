
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
 *         &lt;element name="ConsultarSaldoNugResult" type="{http://www.flamingo.com.co}ConsultarSaldoNugRes" minOccurs="0"/>
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
    "consultarSaldoNugResult"
})
@XmlRootElement(name = "ConsultarSaldoNugResponse")
public class ConsultarSaldoNugResponse {

    @XmlElementRef(name = "ConsultarSaldoNugResult", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<ConsultarSaldoNugRes> consultarSaldoNugResult;

    /**
     * Obtiene el valor de la propiedad consultarSaldoNugResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConsultarSaldoNugRes }{@code >}
     *     
     */
    public JAXBElement<ConsultarSaldoNugRes> getConsultarSaldoNugResult() {
        return consultarSaldoNugResult;
    }

    /**
     * Define el valor de la propiedad consultarSaldoNugResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConsultarSaldoNugRes }{@code >}
     *     
     */
    public void setConsultarSaldoNugResult(JAXBElement<ConsultarSaldoNugRes> value) {
        this.consultarSaldoNugResult = value;
    }

}
