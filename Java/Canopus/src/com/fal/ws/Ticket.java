
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ticket complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ticket">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="lineItems" type="{http://impl.ws.fal.com/}lineItems" minOccurs="0"/>
 *         &lt;element name="ticketDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vouchers" type="{http://impl.ws.fal.com/}vouchersDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticket", propOrder = {
    "lineItems",
    "ticketDate",
    "ticketNumber",
    "vouchers"
})
public class Ticket
    extends FalBaseDTO
{

    protected LineItems lineItems;
    protected String ticketDate;
    protected String ticketNumber;
    protected VouchersDto vouchers;

    /**
     * Obtiene el valor de la propiedad lineItems.
     * 
     * @return
     *     possible object is
     *     {@link LineItems }
     *     
     */
    public LineItems getLineItems() {
        return lineItems;
    }

    /**
     * Define el valor de la propiedad lineItems.
     * 
     * @param value
     *     allowed object is
     *     {@link LineItems }
     *     
     */
    public void setLineItems(LineItems value) {
        this.lineItems = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketDate() {
        return ticketDate;
    }

    /**
     * Define el valor de la propiedad ticketDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketDate(String value) {
        this.ticketDate = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Define el valor de la propiedad ticketNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad vouchers.
     * 
     * @return
     *     possible object is
     *     {@link VouchersDto }
     *     
     */
    public VouchersDto getVouchers() {
        return vouchers;
    }

    /**
     * Define el valor de la propiedad vouchers.
     * 
     * @param value
     *     allowed object is
     *     {@link VouchersDto }
     *     
     */
    public void setVouchers(VouchersDto value) {
        this.vouchers = value;
    }

}
