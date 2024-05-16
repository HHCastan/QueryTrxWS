
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getPersonalRewardsResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getPersonalRewardsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonalRewardsResponse" type="{http://impl.ws.fal.com/}personalRewardsResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonalRewardsResponse", propOrder = {
    "personalRewardsResponse"
})
public class GetPersonalRewardsResponse {

    @XmlElement(name = "PersonalRewardsResponse")
    protected PersonalRewardsResponse personalRewardsResponse;

    /**
     * Obtiene el valor de la propiedad personalRewardsResponse.
     * 
     * @return
     *     possible object is
     *     {@link PersonalRewardsResponse }
     *     
     */
    public PersonalRewardsResponse getPersonalRewardsResponse() {
        return personalRewardsResponse;
    }

    /**
     * Define el valor de la propiedad personalRewardsResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonalRewardsResponse }
     *     
     */
    public void setPersonalRewardsResponse(PersonalRewardsResponse value) {
        this.personalRewardsResponse = value;
    }

}
