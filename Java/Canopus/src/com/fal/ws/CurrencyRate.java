
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para currencyRate complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="currencyRate">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="rateEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="buyRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="sellRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="currencyCodeFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCodeTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rateStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "currencyRate", propOrder = {
    "rateEndDate",
    "rate",
    "buyRate",
    "sellRate",
    "currencyCodeFrom",
    "currencyCodeTo",
    "rateStartDate"
})
public class CurrencyRate
    extends FalBaseDTO
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rateEndDate;
    protected Double rate;
    protected Double buyRate;
    protected Double sellRate;
    protected String currencyCodeFrom;
    protected String currencyCodeTo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rateStartDate;

    /**
     * Obtiene el valor de la propiedad rateEndDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRateEndDate() {
        return rateEndDate;
    }

    /**
     * Define el valor de la propiedad rateEndDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRateEndDate(XMLGregorianCalendar value) {
        this.rateEndDate = value;
    }

    /**
     * Obtiene el valor de la propiedad rate.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRate() {
        return rate;
    }

    /**
     * Define el valor de la propiedad rate.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRate(Double value) {
        this.rate = value;
    }

    /**
     * Obtiene el valor de la propiedad buyRate.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBuyRate() {
        return buyRate;
    }

    /**
     * Define el valor de la propiedad buyRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBuyRate(Double value) {
        this.buyRate = value;
    }

    /**
     * Obtiene el valor de la propiedad sellRate.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSellRate() {
        return sellRate;
    }

    /**
     * Define el valor de la propiedad sellRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSellRate(Double value) {
        this.sellRate = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCodeFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCodeFrom() {
        return currencyCodeFrom;
    }

    /**
     * Define el valor de la propiedad currencyCodeFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCodeFrom(String value) {
        this.currencyCodeFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCodeTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCodeTo() {
        return currencyCodeTo;
    }

    /**
     * Define el valor de la propiedad currencyCodeTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCodeTo(String value) {
        this.currencyCodeTo = value;
    }

    /**
     * Obtiene el valor de la propiedad rateStartDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRateStartDate() {
        return rateStartDate;
    }

    /**
     * Define el valor de la propiedad rateStartDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRateStartDate(XMLGregorianCalendar value) {
        this.rateStartDate = value;
    }

}
