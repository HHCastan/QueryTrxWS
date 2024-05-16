
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para personalRewardsResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="personalRewardsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseResponse">
 *       &lt;sequence>
 *         &lt;element name="cardDetails" type="{http://impl.ws.fal.com/}cardDetails" minOccurs="0"/>
 *         &lt;element name="personalRewards" type="{http://impl.ws.fal.com/}personalReward" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personalRewardsResponse", propOrder = {
    "cardDetails",
    "personalRewards"
})
public class PersonalRewardsResponse
    extends FalBaseResponse
{

    protected CardDetails cardDetails;
    @XmlElement(nillable = true)
    protected List<PersonalReward> personalRewards;

    /**
     * Obtiene el valor de la propiedad cardDetails.
     * 
     * @return
     *     possible object is
     *     {@link CardDetails }
     *     
     */
    public CardDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Define el valor de la propiedad cardDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDetails }
     *     
     */
    public void setCardDetails(CardDetails value) {
        this.cardDetails = value;
    }

    /**
     * Gets the value of the personalRewards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personalRewards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonalRewards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonalReward }
     * 
     * 
     */
    public List<PersonalReward> getPersonalRewards() {
        if (personalRewards == null) {
            personalRewards = new ArrayList<PersonalReward>();
        }
        return this.personalRewards;
    }

}
