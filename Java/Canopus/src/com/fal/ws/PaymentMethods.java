
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paymentMethods complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="paymentMethods">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="auditNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newNumberIssuedCoupons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="newPointsBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberPrintedCoupons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paymentMethod" type="{http://impl.ws.fal.com/}paymentMethod" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentMethods", propOrder = {
    "auditNumber",
    "newNumberIssuedCoupons",
    "newPointsBalance",
    "numberPrintedCoupons",
    "paymentMethod"
})
public class PaymentMethods
    extends FalBaseDTO
{

    protected String auditNumber;
    protected int newNumberIssuedCoupons;
    protected int newPointsBalance;
    protected int numberPrintedCoupons;
    @XmlElement(nillable = true)
    protected List<PaymentMethod> paymentMethod;

    /**
     * Obtiene el valor de la propiedad auditNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuditNumber() {
        return auditNumber;
    }

    /**
     * Define el valor de la propiedad auditNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuditNumber(String value) {
        this.auditNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad newNumberIssuedCoupons.
     * 
     */
    public int getNewNumberIssuedCoupons() {
        return newNumberIssuedCoupons;
    }

    /**
     * Define el valor de la propiedad newNumberIssuedCoupons.
     * 
     */
    public void setNewNumberIssuedCoupons(int value) {
        this.newNumberIssuedCoupons = value;
    }

    /**
     * Obtiene el valor de la propiedad newPointsBalance.
     * 
     */
    public int getNewPointsBalance() {
        return newPointsBalance;
    }

    /**
     * Define el valor de la propiedad newPointsBalance.
     * 
     */
    public void setNewPointsBalance(int value) {
        this.newPointsBalance = value;
    }

    /**
     * Obtiene el valor de la propiedad numberPrintedCoupons.
     * 
     */
    public int getNumberPrintedCoupons() {
        return numberPrintedCoupons;
    }

    /**
     * Define el valor de la propiedad numberPrintedCoupons.
     * 
     */
    public void setNumberPrintedCoupons(int value) {
        this.numberPrintedCoupons = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMethod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMethod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMethod }
     * 
     * 
     */
    public List<PaymentMethod> getPaymentMethod() {
        if (paymentMethod == null) {
            paymentMethod = new ArrayList<PaymentMethod>();
        }
        return this.paymentMethod;
    }

}
