
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para giftReward complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="giftReward">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="applyAsTender" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="availableQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="costs" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="counterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="counterDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lineItem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selectedQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenderAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "giftReward", propOrder = {
    "applyAsTender",
    "availableQuantity",
    "costs",
    "counterCode",
    "counterDesc",
    "description",
    "lineItem",
    "productCode",
    "rewardId",
    "selectedQuantity",
    "tenderAmount"
})
public class GiftReward
    extends FalBaseDTO
{

    protected boolean applyAsTender;
    protected int availableQuantity;
    protected double costs;
    protected String counterCode;
    protected String counterDesc;
    protected String description;
    protected int lineItem;
    protected String productCode;
    protected String rewardId;
    protected int selectedQuantity;
    protected double tenderAmount;

    /**
     * Obtiene el valor de la propiedad applyAsTender.
     * 
     */
    public boolean isApplyAsTender() {
        return applyAsTender;
    }

    /**
     * Define el valor de la propiedad applyAsTender.
     * 
     */
    public void setApplyAsTender(boolean value) {
        this.applyAsTender = value;
    }

    /**
     * Obtiene el valor de la propiedad availableQuantity.
     * 
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * Define el valor de la propiedad availableQuantity.
     * 
     */
    public void setAvailableQuantity(int value) {
        this.availableQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad costs.
     * 
     */
    public double getCosts() {
        return costs;
    }

    /**
     * Define el valor de la propiedad costs.
     * 
     */
    public void setCosts(double value) {
        this.costs = value;
    }

    /**
     * Obtiene el valor de la propiedad counterCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterCode() {
        return counterCode;
    }

    /**
     * Define el valor de la propiedad counterCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterCode(String value) {
        this.counterCode = value;
    }

    /**
     * Obtiene el valor de la propiedad counterDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterDesc() {
        return counterDesc;
    }

    /**
     * Define el valor de la propiedad counterDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterDesc(String value) {
        this.counterDesc = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad lineItem.
     * 
     */
    public int getLineItem() {
        return lineItem;
    }

    /**
     * Define el valor de la propiedad lineItem.
     * 
     */
    public void setLineItem(int value) {
        this.lineItem = value;
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
     * Obtiene el valor de la propiedad rewardId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRewardId() {
        return rewardId;
    }

    /**
     * Define el valor de la propiedad rewardId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRewardId(String value) {
        this.rewardId = value;
    }

    /**
     * Obtiene el valor de la propiedad selectedQuantity.
     * 
     */
    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    /**
     * Define el valor de la propiedad selectedQuantity.
     * 
     */
    public void setSelectedQuantity(int value) {
        this.selectedQuantity = value;
    }

    /**
     * Obtiene el valor de la propiedad tenderAmount.
     * 
     */
    public double getTenderAmount() {
        return tenderAmount;
    }

    /**
     * Define el valor de la propiedad tenderAmount.
     * 
     */
    public void setTenderAmount(double value) {
        this.tenderAmount = value;
    }

}
