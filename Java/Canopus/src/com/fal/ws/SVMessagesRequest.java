
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SVMessagesRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SVMessagesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SVRequest" type="{http://impl.ws.fal.com/}svBaseLoyaltyRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SVMessagesRequest", propOrder = {
    "svRequest"
})
public class SVMessagesRequest {

    @XmlElement(name = "SVRequest")
    protected SvBaseLoyaltyRequest svRequest;

    /**
     * Obtiene el valor de la propiedad svRequest.
     * 
     * @return
     *     possible object is
     *     {@link SvBaseLoyaltyRequest }
     *     
     */
    public SvBaseLoyaltyRequest getSVRequest() {
        return svRequest;
    }

    /**
     * Define el valor de la propiedad svRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link SvBaseLoyaltyRequest }
     *     
     */
    public void setSVRequest(SvBaseLoyaltyRequest value) {
        this.svRequest = value;
    }

}
