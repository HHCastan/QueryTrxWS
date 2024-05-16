
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para personalReward complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="personalReward">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="campaignId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lingeringTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="message1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proximity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="redemptionLimit" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="rewardAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rewardDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rewardTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rewardsTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "personalReward", propOrder = {
    "campaignId",
    "categoryCode",
    "condition",
    "imageUrl",
    "lingeringTime",
    "message1",
    "message2",
    "productCode",
    "proximity",
    "redemptionLimit",
    "rewardAmount",
    "rewardDescription",
    "rewardId",
    "rewardTypeDescription",
    "rewardsTypeId",
    "timezone",
    "validFrom",
    "validUntil"
})
public class PersonalReward
    extends FalBaseDTO
{

    protected long campaignId;
    protected String categoryCode;
    protected String condition;
    protected String imageUrl;
    protected int lingeringTime;
    protected String message1;
    protected String message2;
    protected String productCode;
    protected double proximity;
    protected short redemptionLimit;
    protected double rewardAmount;
    protected String rewardDescription;
    protected long rewardId;
    protected String rewardTypeDescription;
    protected int rewardsTypeId;
    protected TimeZone timezone;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFrom;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validUntil;

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
     * Obtiene el valor de la propiedad imageUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Define el valor de la propiedad imageUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad lingeringTime.
     * 
     */
    public int getLingeringTime() {
        return lingeringTime;
    }

    /**
     * Define el valor de la propiedad lingeringTime.
     * 
     */
    public void setLingeringTime(int value) {
        this.lingeringTime = value;
    }

    /**
     * Obtiene el valor de la propiedad message1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage1() {
        return message1;
    }

    /**
     * Define el valor de la propiedad message1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage1(String value) {
        this.message1 = value;
    }

    /**
     * Obtiene el valor de la propiedad message2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage2() {
        return message2;
    }

    /**
     * Define el valor de la propiedad message2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage2(String value) {
        this.message2 = value;
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
     * Obtiene el valor de la propiedad proximity.
     * 
     */
    public double getProximity() {
        return proximity;
    }

    /**
     * Define el valor de la propiedad proximity.
     * 
     */
    public void setProximity(double value) {
        this.proximity = value;
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
