
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para lookupCardsResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lookupCardsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardLookupResponse" type="{http://impl.ws.fal.com/}cardLookupResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookupCardsResponse", propOrder = {
    "cardLookupResponse"
})
public class LookupCardsResponse {

    @XmlElement(name = "CardLookupResponse")
    protected CardLookupResponse cardLookupResponse;

    /**
     * Obtiene el valor de la propiedad cardLookupResponse.
     * 
     * @return
     *     possible object is
     *     {@link CardLookupResponse }
     *     
     */
    public CardLookupResponse getCardLookupResponse() {
        return cardLookupResponse;
    }

    /**
     * Define el valor de la propiedad cardLookupResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link CardLookupResponse }
     *     
     */
    public void setCardLookupResponse(CardLookupResponse value) {
        this.cardLookupResponse = value;
    }

}
