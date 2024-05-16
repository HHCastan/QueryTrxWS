
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para validateCouponResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="validateCouponResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseMessage" type="{http://impl.ws.fal.com/}baseLoyaltyResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCouponResponse", propOrder = {
    "responseMessage"
})
public class ValidateCouponResponse {

    @XmlElement(name = "ResponseMessage")
    protected BaseLoyaltyResponse responseMessage;

    /**
     * Obtiene el valor de la propiedad responseMessage.
     * 
     * @return
     *     possible object is
     *     {@link BaseLoyaltyResponse }
     *     
     */
    public BaseLoyaltyResponse getResponseMessage() {
        return responseMessage;
    }

    /**
     * Define el valor de la propiedad responseMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseLoyaltyResponse }
     *     
     */
    public void setResponseMessage(BaseLoyaltyResponse value) {
        this.responseMessage = value;
    }

}
