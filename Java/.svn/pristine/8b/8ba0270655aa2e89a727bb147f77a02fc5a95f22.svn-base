
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ticketMessages complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ticketMessages">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
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
@XmlType(name = "ticketMessages", propOrder = {
    "ticketMessage"
})
public class TicketMessages
    extends FalBaseDTO
{

    @XmlElement(nillable = true)
    protected List<TicketMessage> ticketMessage;

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
