
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para deleteCurrencyRate complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="deleteCurrencyRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrencyCodeFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyCodeTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyRateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCurrencyRate", propOrder = {
    "currencyCodeFrom",
    "currencyCodeTo",
    "currencyRateDate"
})
public class DeleteCurrencyRate {

    @XmlElement(name = "CurrencyCodeFrom")
    protected String currencyCodeFrom;
    @XmlElement(name = "CurrencyCodeTo")
    protected String currencyCodeTo;
    @XmlElement(name = "CurrencyRateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar currencyRateDate;

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
     * Obtiene el valor de la propiedad currencyRateDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrencyRateDate() {
        return currencyRateDate;
    }

    /**
     * Define el valor de la propiedad currencyRateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrencyRateDate(XMLGregorianCalendar value) {
        this.currencyRateDate = value;
    }

}
