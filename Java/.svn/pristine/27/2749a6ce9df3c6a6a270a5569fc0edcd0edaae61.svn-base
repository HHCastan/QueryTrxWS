
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rewardMessage complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rewardMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="customerMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cashierMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketMessage" type="{http://impl.ws.fal.com/}ticketMessage" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rewardMessage", propOrder = {
    "customerMessage",
    "cashierMessage",
    "ticketMessage"
})
public class RewardMessage
    extends FalBaseDTO
{

    protected String customerMessage;
    protected String cashierMessage;
    @XmlElement(nillable = true)
    protected List<TicketMessage> ticketMessage;

    /**
     * Obtiene el valor de la propiedad customerMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerMessage() {
        return customerMessage;
    }

    /**
     * Define el valor de la propiedad customerMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerMessage(String value) {
        this.customerMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad cashierMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashierMessage() {
        return cashierMessage;
    }

    /**
     * Define el valor de la propiedad cashierMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashierMessage(String value) {
        this.cashierMessage = value;
    }

    /**
     * Gets the value of the ticketMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketMessage }
     * 
     * 
     */
    public List<TicketMessage> getTicketMessage() {
        if (ticketMessage == null) {
            ticketMessage = new ArrayList<TicketMessage>();
        }
        return this.ticketMessage;
    }

}
