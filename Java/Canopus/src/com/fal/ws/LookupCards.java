
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para lookupCards complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lookupCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LookupRequest" type="{http://impl.ws.fal.com/}cardLookupRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lookupCards", propOrder = {
    "lookupRequest"
})
public class LookupCards {

    @XmlElement(name = "LookupRequest")
    protected CardLookupRequest lookupRequest;

    /**
     * Obtiene el valor de la propiedad lookupRequest.
     * 
     * @return
     *     possible object is
     *     {@link CardLookupRequest }
     *     
     */
    public CardLookupRequest getLookupRequest() {
        return lookupRequest;
    }

    /**
     * Define el valor de la propiedad lookupRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link CardLookupRequest }
     *     
     */
    public void setLookupRequest(CardLookupRequest value) {
        this.lookupRequest = value;
    }

}
