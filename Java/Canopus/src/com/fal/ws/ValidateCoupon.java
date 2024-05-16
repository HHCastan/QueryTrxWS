
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para validateCoupon complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="validateCoupon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Basket" type="{http://impl.ws.fal.com/}basketRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCoupon", propOrder = {
    "basket"
})
public class ValidateCoupon {

    @XmlElement(name = "Basket")
    protected BasketRequest basket;

    /**
     * Obtiene el valor de la propiedad basket.
     * 
     * @return
     *     possible object is
     *     {@link BasketRequest }
     *     
     */
    public BasketRequest getBasket() {
        return basket;
    }

    /**
     * Define el valor de la propiedad basket.
     * 
     * @param value
     *     allowed object is
     *     {@link BasketRequest }
     *     
     */
    public void setBasket(BasketRequest value) {
        this.basket = value;
    }

}
