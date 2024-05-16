
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para svBaseLoyaltyRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="svBaseLoyaltyRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}baseLoyaltyRequest">
 *       &lt;sequence>
 *         &lt;element name="additionalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amountSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCodeSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateExpiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalDataElements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSEntryMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="settlementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="track1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="track2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transmissionDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "svBaseLoyaltyRequest", propOrder = {
    "additionalAmount",
    "amountSettlement",
    "currencyCodeSettlement",
    "dateExpiration",
    "originalDataElements",
    "posEntryMode",
    "settlementDate",
    "track1",
    "track2",
    "transactionAmount",
    "transmissionDateTime"
})
public class SvBaseLoyaltyRequest
    extends BaseLoyaltyRequest
{

    protected String additionalAmount;
    protected String amountSettlement;
    protected String currencyCodeSettlement;
    protected String dateExpiration;
    protected String originalDataElements;
    @XmlElement(name = "POSEntryMode")
    protected String posEntryMode;
    protected String settlementDate;
    protected String track1;
    protected String track2;
    protected String transactionAmount;
    protected String transmissionDateTime;

    /**
     * Obtiene el valor de la propiedad additionalAmount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalAmount() {
        return additionalAmount;
    }

    /**
     * Define el valor de la propiedad additionalAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalAmount(String value) {
        this.additionalAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad amountSettlement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountSettlement() {
        return amountSettlement;
    }

    /**
     * Define el valor de la propiedad amountSettlement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountSettlement(String value) {
        this.amountSettlement = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCodeSettlement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCodeSettlement() {
        return currencyCodeSettlement;
    }

    /**
     * Define el valor de la propiedad currencyCodeSettlement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCodeSettlement(String value) {
        this.currencyCodeSettlement = value;
    }

    /**
     * Obtiene el valor de la propiedad dateExpiration.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Define el valor de la propiedad dateExpiration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateExpiration(String value) {
        this.dateExpiration = value;
    }

    /**
     * Obtiene el valor de la propiedad originalDataElements.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalDataElements() {
        return originalDataElements;
    }

    /**
     * Define el valor de la propiedad originalDataElements.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalDataElements(String value) {
        this.originalDataElements = value;
    }

    /**
     * Obtiene el valor de la propiedad posEntryMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSEntryMode() {
        return posEntryMode;
    }

    /**
     * Define el valor de la propiedad posEntryMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSEntryMode(String value) {
        this.posEntryMode = value;
    }

    /**
     * Obtiene el valor de la propiedad settlementDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementDate() {
        return settlementDate;
    }

    /**
     * Define el valor de la propiedad settlementDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementDate(String value) {
        this.settlementDate = value;
    }

    /**
     * Obtiene el valor de la propiedad track1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack1() {
        return track1;
    }

    /**
     * Define el valor de la propiedad track1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack1(String value) {
        this.track1 = value;
    }

    /**
     * Obtiene el valor de la propiedad track2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2() {
        return track2;
    }

    /**
     * Define el valor de la propiedad track2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2(String value) {
        this.track2 = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionAmount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Define el valor de la propiedad transactionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAmount(String value) {
        this.transactionAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad transmissionDateTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmissionDateTime() {
        return transmissionDateTime;
    }

    /**
     * Define el valor de la propiedad transmissionDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmissionDateTime(String value) {
        this.transmissionDateTime = value;
    }

}
