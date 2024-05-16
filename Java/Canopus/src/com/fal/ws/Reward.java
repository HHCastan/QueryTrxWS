
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para reward complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reward">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="carrier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="financingRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productFamily" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productTriggers" type="{http://impl.ws.fal.com/}productTriggers" minOccurs="0"/>
 *         &lt;element name="rewardAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rewardDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardMessage" type="{http://impl.ws.fal.com/}rewardMessage" minOccurs="0"/>
 *         &lt;element name="rewardQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reward", propOrder = {
    "carrier",
    "category",
    "financingRef",
    "index",
    "productCode",
    "productFamily",
    "productTriggers",
    "rewardAmount",
    "rewardDescription",
    "rewardID",
    "rewardMessage",
    "rewardQuantity"
})
public class Reward
    extends FalBaseDTO
{

    protected int carrier;
    protected int category;
    protected String financingRef;
    protected int index;
    protected String productCode;
    protected String productFamily;
    protected ProductTriggers productTriggers;
    protected double rewardAmount;
    protected String rewardDescription;
    protected String rewardID;
    protected RewardMessage rewardMessage;
    protected int rewardQuantity;

    /**
     * Obtiene el valor de la propiedad carrier.
     * 
     */
    public int getCarrier() {
        return carrier;
    }

    /**
     * Define el valor de la propiedad carrier.
     * 
     */
    public void setCarrier(int value) {
        this.carrier = value;
    }

    /**
     * Obtiene el valor de la propiedad category.
     * 
     */
    public int getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     */
    public void setCategory(int value) {
        this.category = value;
    }

    /**
     * Obtiene el valor de la propiedad financingRef.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancingRef() {
        return financingRef;
    }

    /**
     * Define el valor de la propiedad financingRef.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancingRef(String value) {
        this.financingRef = value;
    }

    /**
     * Obtiene el valor de la propiedad index.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Define el valor de la propiedad index.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Obtiene el valor de la propiedad productCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Define el valor de la propiedad productCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Obtiene el valor de la propiedad productFamily.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductFamily() {
        return productFamily;
    }

    /**
     * Define el valor de la propiedad productFamily.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductFamily(String value) {
        this.productFamily = value;
    }

    /**
     * Obtiene el valor de la propiedad productTriggers.
     * 
     * @return
     *     possible object is
     *     {@link ProductTriggers }
     *     
     */
    public ProductTriggers getProductTriggers() {
        return productTriggers;
    }

    /**
     * Define el valor de la propiedad productTriggers.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTriggers }
     *     
     */
    public void setProductTriggers(ProductTriggers value) {
        this.productTriggers = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardAmount.
     * 
     */
    public double getRewardAmount() {
        return rewardAmount;
    }

    /**
     * Define el valor de la propiedad rewardAmount.
     * 
     */
    public void setRewardAmount(double value) {
        this.rewardAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRewardDescription() {
        return rewardDescription;
    }

    /**
     * Define el valor de la propiedad rewardDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRewardDescription(String value) {
        this.rewardDescription = value;
    }

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

    /**
     * Obtiene el valor de la propiedad rewardMessage.
     * 
     * @return
     *     possible object is
     *     {@link RewardMessage }
     *     
     */
    public RewardMessage getRewardMessage() {
        return rewardMessage;
    }

    /**
     * Define el valor de la propiedad rewardMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardMessage }
     *     
     */
    public void setRewardMessage(RewardMessage value) {
        this.rewardMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardQuantity.
     * 
     */
    public int getRewardQuantity() {
        return rewardQuantity;
    }

    /**
     * Define el valor de la propiedad rewardQuantity.
     * 
     */
    public void setRewardQuantity(int value) {
        this.rewardQuantity = value;
    }

}
