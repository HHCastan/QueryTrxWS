
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para lineItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="lineItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="familyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nonDiscountable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rewardsExcluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineItem", propOrder = {
    "familyCode",
    "index",
    "nonDiscountable",
    "productCode",
    "productPrice",
    "productType",
    "quantity",
    "rewardsExcluded"
})
public class LineItem
    extends FalBaseDTO
{

    protected String familyCode;
    protected int index;
    protected boolean nonDiscountable;
    protected String productCode;
    protected double productPrice;
    protected int productType;
    protected double quantity;
    protected boolean rewardsExcluded;

    /**
     * Obtiene el valor de la propiedad familyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyCode() {
        return familyCode;
    }

    /**
     * Define el valor de la propiedad familyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyCode(String value) {
        this.familyCode = value;
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
     * Obtiene el valor de la propiedad nonDiscountable.
     * 
     */
    public boolean isNonDiscountable() {
        return nonDiscountable;
    }

    /**
     * Define el valor de la propiedad nonDiscountable.
     * 
     */
    public void setNonDiscountable(boolean value) {
        this.nonDiscountable = value;
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
     * Obtiene el valor de la propiedad productPrice.
     * 
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     * Define el valor de la propiedad productPrice.
     * 
     */
    public void setProductPrice(double value) {
        this.productPrice = value;
    }

    /**
     * Obtiene el valor de la propiedad productType.
     * 
     */
    public int getProductType() {
        return productType;
    }

    /**
     * Define el valor de la propiedad productType.
     * 
     */
    public void setProductType(int value) {
        this.productType = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     */
    public void setQuantity(double value) {
        this.quantity = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardsExcluded.
     * 
     */
    public boolean isRewardsExcluded() {
        return rewardsExcluded;
    }

    /**
     * Define el valor de la propiedad rewardsExcluded.
     * 
     */
    public void setRewardsExcluded(boolean value) {
        this.rewardsExcluded = value;
    }

}
