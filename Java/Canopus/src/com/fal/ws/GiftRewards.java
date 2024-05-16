
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para giftRewards complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="giftRewards">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="giftReward" type="{http://impl.ws.fal.com/}giftReward" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "giftRewards", propOrder = {
    "giftReward"
})
public class GiftRewards
    extends FalBaseDTO
{

    @XmlElement(nillable = true)
    protected List<GiftReward> giftReward;

    /**
     * Gets the value of the giftReward property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the giftReward property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGiftReward().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GiftReward }
     * 
     * 
     */
    public List<GiftReward> getGiftReward() {
        if (giftReward == null) {
            giftReward = new ArrayList<GiftReward>();
        }
        return this.giftReward;
    }

}
