
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para saveCurrencyRate complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="saveCurrencyRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrencyRate" type="{http://impl.ws.fal.com/}currencyRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "saveCurrencyRate", propOrder = {
    "currencyRate"
})
public class SaveCurrencyRate {

    @XmlElement(name = "CurrencyRate")
    protected CurrencyRate currencyRate;

    /**
     * Obtiene el valor de la propiedad currencyRate.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyRate }
     *     
     */
    public CurrencyRate getCurrencyRate() {
        return currencyRate;
    }

    /**
     * Define el valor de la propiedad currencyRate.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyRate }
     *     
     */
    public void setCurrencyRate(CurrencyRate value) {
        this.currencyRate = value;
    }

}
