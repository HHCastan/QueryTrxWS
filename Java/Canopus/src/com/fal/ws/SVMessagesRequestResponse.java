
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SVMessagesRequestResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SVMessagesRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SVResponse" type="{http://impl.ws.fal.com/}svBaseLoyaltyResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SVMessagesRequestResponse", propOrder = {
    "svResponse"
})
public class SVMessagesRequestResponse {

    @XmlElement(name = "SVResponse")
    protected SvBaseLoyaltyResponse svResponse;

    /**
     * Obtiene el valor de la propiedad svResponse.
     * 
     * @return
     *     possible object is
     *     {@link SvBaseLoyaltyResponse }
     *     
     */
    public SvBaseLoyaltyResponse getSVResponse() {
        return svResponse;
    }

    /**
     * Define el valor de la propiedad svResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link SvBaseLoyaltyResponse }
     *     
     */
    public void setSVResponse(SvBaseLoyaltyResponse value) {
        this.svResponse = value;
    }

}
