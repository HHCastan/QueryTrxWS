
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para productPromotion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="productPromotion">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="beaconTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productSuggestions" type="{http://impl.ws.fal.com/}productInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="redemptionLimit" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="rewardAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rewardDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rewardTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardsTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="surveyCoupon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="surveyLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetCoupon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetItem" type="{http://impl.ws.fal.com/}productInfo" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://impl.ws.fal.com/}timeZone" minOccurs="0"/>
 *         &lt;element name="validFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="validUntil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productPromotion", propOrder = {
    "beaconTag",
    "campaignId",
    "categoryCode",
    "condition",
    "productSuggestions",
    "redemptionLimit",
    "rewardAmount",
    "rewardDescription",
    "rewardId",
    "rewardTypeDescription",
    "rewardsTypeId",
    "surveyCoupon",
    "surveyLink",
    "targetCoupon",
    "targetItem",
    "timezone",
    "validFrom",
    "validUntil"
})
public class ProductPromotion
    extends FalBaseDTO
{

    protected String beaconTag;
    protected long campaignId;
    protected String categoryCode;
    protected String condition;
    @XmlElement(nillable = true)
    protected List<ProductInfo> productSuggestions;
    protected short redemptionLimit;
    protected double rewardAmount;
    protected String rewardDescription;
    protected long rewardId;
    protected String rewardTypeDescription;
    protected int rewardsTypeId;
    protected String surveyCoupon;
    protected String surveyLink;
    protected String targetCoupon;
    protected ProductInfo targetItem;
    protected TimeZone timezone;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validUntil;

    /**
     * Obtiene el valor de la propiedad beaconTag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeaconTag() {
        return beaconTag;
    }

    /**
     * Define el valor de la propiedad beaconTag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeaconTag(String value) {
        this.beaconTag = value;
    }

    /**
     * Obtiene el valor de la propiedad campaignId.
     * 
     */
    public long getCampaignId() {
        return campaignId;
    }

    /**
     * Define el valor de la propiedad campaignId.
     * 
     */
    public void setCampaignId(long value) {
        this.campaignId = value;
    }

    /**
     * Obtiene el valor de la propiedad categoryCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Define el valor de la propiedad categoryCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

    /**
     * Obtiene el valor de la propiedad condition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Define el valor de la propiedad condition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondition(String value) {
        this.condition = value;
    }

    /**
     * Gets the value of the productSuggestions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productSuggestions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductSuggestions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductInfo }
     * 
     * 
     */
    public List<ProductInfo> getProductSuggestions() {
        if (productSuggestions == null) {
            productSuggestions = new ArrayList<ProductInfo>();
        }
        return this.productSuggestions;
    }

    /**
     * Obtiene el valor de la propiedad redemptionLimit.
     * 
     */
    public short getRedemptionLimit() {
        return redemptionLimit;
    }

    /**
     * Define el valor de la propiedad redemptionLimit.
     * 
     */
    public void setRedemptionLimit(short value) {
        this.redemptionLimit = value;
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
     * Obtiene el valor de la propiedad rewardId.
     * 
     */
    public long getRewardId() {
        return rewardId;
    }

    /**
     * Define el valor de la propiedad rewardId.
     * 
     */
    public void setRewardId(long value) {
        this.rewardId = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardTypeDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRewardTypeDescription() {
        return rewardTypeDescription;
    }

    /**
     * Define el valor de la propiedad rewardTypeDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRewardTypeDescription(String value) {
        this.rewardTypeDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardsTypeId.
     * 
     */
    public int getRewardsTypeId() {
        return rewardsTypeId;
    }

    /**
     * Define el valor de la propiedad rewardsTypeId.
     * 
     */
    public void setRewardsTypeId(int value) {
        this.rewardsTypeId = value;
    }

    /**
     * Obtiene el valor de la propiedad surveyCoupon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurveyCoupon() {
        return surveyCoupon;
    }

    /**
     * Define el valor de la propiedad surveyCoupon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurveyCoupon(String value) {
        this.surveyCoupon = value;
    }

    /**
     * Obtiene el valor de la propiedad surveyLink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurveyLink() {
        return surveyLink;
    }

    /**
     * Define el valor de la propiedad surveyLink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurveyLink(String value) {
        this.surveyLink = value;
    }

    /**
     * Obtiene el valor de la propiedad targetCoupon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCoupon() {
        return targetCoupon;
    }

    /**
     * Define el valor de la propiedad targetCoupon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCoupon(String value) {
        this.targetCoupon = value;
    }

    /**
     * Obtiene el valor de la propiedad targetItem.
     * 
     * @return
     *     possible object is
     *     {@link ProductInfo }
     *     
     */
    public ProductInfo getTargetItem() {
        return targetItem;
    }

    /**
     * Define el valor de la propiedad targetItem.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductInfo }
     *     
     */
    public void setTargetItem(ProductInfo value) {
        this.targetItem = value;
    }

    /**
     * Obtiene el valor de la propiedad timezone.
     * 
     * @return
     *     possible object is
     *     {@link TimeZone }
     *     
     */
    public TimeZone getTimezone() {
        return timezone;
    }

    /**
     * Define el valor de la propiedad timezone.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *     
     */
    public void setTimezone(TimeZone value) {
        this.timezone = value;
    }

    /**
     * Obtiene el valor de la propiedad validFrom.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Define el valor de la propiedad validFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad validUntil.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidUntil() {
        return validUntil;
    }

    /**
     * Define el valor de la propiedad validUntil.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidUntil(XMLGregorianCalendar value) {
        this.validUntil = value;
    }

}
