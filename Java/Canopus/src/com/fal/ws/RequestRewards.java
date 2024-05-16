
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para requestRewards complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="requestRewards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RewardsRequest" type="{http://impl.ws.fal.com/}basketRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestRewards", propOrder = {
    "rewardsRequest"
})
public class RequestRewards {

    @XmlElement(name = "RewardsRequest")
    protected BasketRequest rewardsRequest;

    /**
     * Obtiene el valor de la propiedad rewardsRequest.
     * 
     * @return
     *     possible object is
     *     {@link BasketRequest }
     *     
     */
    public BasketRequest getRewardsRequest() {
        return rewardsRequest;
    }

    /**
     * Define el valor de la propiedad rewardsRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketRequest }
     *     
     */
    public void setRewardsRequest(BasketRequest value) {
        this.rewardsRequest = value;
    }

}
