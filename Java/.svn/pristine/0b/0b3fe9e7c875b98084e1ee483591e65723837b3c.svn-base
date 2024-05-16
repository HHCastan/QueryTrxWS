
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para voidedRewards complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="voidedRewards">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="voidedReward" type="{http://impl.ws.fal.com/}voidedReward" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voidedRewards", propOrder = {
    "voidedReward"
})
public class VoidedRewards
    extends FalBaseDTO
{

    @XmlElement(nillable = true)
    protected List<VoidedReward> voidedReward;

    /**
     * Gets the value of the voidedReward property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voidedReward property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoidedReward().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoidedReward }
     * 
     * 
     */
    public List<VoidedReward> getVoidedReward() {
        if (voidedReward == null) {
            voidedReward = new ArrayList<VoidedReward>();
        }
        return this.voidedReward;
    }

}
