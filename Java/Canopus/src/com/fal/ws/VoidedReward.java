
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para voidedReward complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="voidedReward">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="rewardID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voidedReward", propOrder = {
    "rewardID"
})
public class VoidedReward
    extends FalBaseDTO
{

    protected String rewardID;

    /**
     * Obtiene el valor de la propiedad rewardID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRewardID() {
        return rewardID;
    }

    /**
     * Define el valor de la propiedad rewardID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRewardID(String value) {
        this.rewardID = value;
    }

}
