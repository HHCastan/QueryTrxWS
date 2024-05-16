
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
 *         &lt;element name="GenerarTokenResult" type="{http://www.flamingo.com.co}TokenRes" minOccurs="0"/>
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
    "generarTokenResult"
})
@XmlRootElement(name = "GenerarTokenResponse")
public class GenerarTokenResponse {

    @XmlElementRef(name = "GenerarTokenResult", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<TokenRes> generarTokenResult;

    /**
     * Obtiene el valor de la propiedad generarTokenResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TokenRes }{@code >}
     *     
     */
    public JAXBElement<TokenRes> getGenerarTokenResult() {
        return generarTokenResult;
    }

    /**
     * Define el valor de la propiedad generarTokenResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TokenRes }{@code >}
     *     
     */
    public void setGenerarTokenResult(JAXBElement<TokenRes> value) {
        this.generarTokenResult = value;
    }

}
