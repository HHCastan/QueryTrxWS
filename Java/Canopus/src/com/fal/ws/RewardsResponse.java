
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rewardsResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="rewardsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}baseLoyaltyResponse">
 *       &lt;sequence>
 *         &lt;element name="rewardsGranted" type="{http://impl.ws.fal.com/}rewardsField" minOccurs="0"/>
 *         &lt;element name="giftRewards" type="{http://impl.ws.fal.com/}giftRewards" minOccurs="0"/>
 *         &lt;element name="coupons" type="{http://impl.ws.fal.com/}coupons" minOccurs="0"/>
 *         &lt;element name="ticketMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cashierMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="optionalTicketMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticketMessages" type="{http://impl.ws.fal.com/}ticketMessages" minOccurs="0"/>
 *         &lt;element name="customerDetails" type="{http://impl.ws.fal.com/}customerDetails" minOccurs="0"/>
 *         &lt;element name="nearMissMessages" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nearMissMessage" type="{http://impl.ws.fal.com/}nearMissMessage" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="trxErrors" type="{http://impl.ws.fal.com/}trxErrors" minOccurs="0"/>
 *         &lt;element name="tillInteractions" type="{http://impl.ws.fal.com/}tillInteractions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rewardsResponse", propOrder = {
    "rewardsGranted",
    "giftRewards",
    "coupons",
    "ticketMessage",
    "customerMessage",
    "cashierMessage",
    "optionalTicketMessage",
    "ticketMessages",
    "customerDetails",
    "nearMissMessages",
    "trxErrors",
    "tillInteractions"
})
public class RewardsResponse
    extends BaseLoyaltyResponse
{

    protected RewardsField rewardsGranted;
    protected GiftRewards giftRewards;
    protected Coupons coupons;
    protected String ticketMessage;
    protected String customerMessage;
    protected String cashierMessage;
    protected String optionalTicketMessage;
    protected TicketMessages ticketMessages;
    protected CustomerDetails customerDetails;
    protected RewardsResponse.NearMissMessages nearMissMessages;
    protected TrxErrors trxErrors;
    protected TillInteractions tillInteractions;

    /**
     * Obtiene el valor de la propiedad rewardsGranted.
     * 
     * @return
     *     possible object is
     *     {@link RewardsField }
     *     
     */
    public RewardsField getRewardsGranted() {
        return rewardsGranted;
    }

    /**
     * Define el valor de la propiedad rewardsGranted.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardsField }
     *     
     */
    public void setRewardsGranted(RewardsField value) {
        this.rewardsGranted = value;
    }

    /**
     * Obtiene el valor de la propiedad giftRewards.
     * 
     * @return
     *     possible object is
     *     {@link GiftRewards }
     *     
     */
    public GiftRewards getGiftRewards() {
        return giftRewards;
    }

    /**
     * Define el valor de la propiedad giftRewards.
     * 
     * @param value
     *     allowed object is
     *     {@link GiftRewards }
     *     
     */
    public void setGiftRewards(GiftRewards value) {
        this.giftRewards = value;
    }

    /**
     * Obtiene el valor de la propiedad coupons.
     * 
     * @return
     *     possible object is
     *     {@link Coupons }
     *     
     */
    public Coupons getCoupons() {
        return coupons;
    }

    /**
     * Define el valor de la propiedad coupons.
     * 
     * @param value
     *     allowed object is
     *     {@link Coupons }
     *     
     */
    public void setCoupons(Coupons value) {
        this.coupons = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketMessage() {
        return ticketMessage;
    }

    /**
     * Define el valor de la propiedad ticketMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketMessage(String value) {
        this.ticketMessage = value;
    }

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
     * Obtiene el valor de la propiedad optionalTicketMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionalTicketMessage() {
        return optionalTicketMessage;
    }

    /**
     * Define el valor de la propiedad optionalTicketMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionalTicketMessage(String value) {
        this.optionalTicketMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketMessages.
     * 
     * @return
     *     possible object is
     *     {@link TicketMessages }
     *     
     */
    public TicketMessages getTicketMessages() {
        return ticketMessages;
    }

    /**
     * Define el valor de la propiedad ticketMessages.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketMessages }
     *     
     */
    public void setTicketMessages(TicketMessages value) {
        this.ticketMessages = value;
    }

    /**
     * Obtiene el valor de la propiedad customerDetails.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDetails }
     *     
     */
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Define el valor de la propiedad customerDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDetails }
     *     
     */
    public void setCustomerDetails(CustomerDetails value) {
        this.customerDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad nearMissMessages.
     * 
     * @return
     *     possible object is
     *     {@link RewardsResponse.NearMissMessages }
     *     
     */
    public RewardsResponse.NearMissMessages getNearMissMessages() {
        return nearMissMessages;
    }

    /**
     * Define el valor de la propiedad nearMissMessages.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardsResponse.NearMissMessages }
     *     
     */
    public void setNearMissMessages(RewardsResponse.NearMissMessages value) {
        this.nearMissMessages = value;
    }

    /**
     * Obtiene el valor de la propiedad trxErrors.
     * 
     * @return
     *     possible object is
     *     {@link TrxErrors }
     *     
     */
    public TrxErrors getTrxErrors() {
        return trxErrors;
    }

    /**
     * Define el valor de la propiedad trxErrors.
     * 
     * @param value
     *     allowed object is
     *     {@link TrxErrors }
     *     
     */
    public void setTrxErrors(TrxErrors value) {
        this.trxErrors = value;
    }

    /**
     * Obtiene el valor de la propiedad tillInteractions.
     * 
     * @return
     *     possible object is
     *     {@link TillInteractions }
     *     
     */
    public TillInteractions getTillInteractions() {
        return tillInteractions;
    }

    /**
     * Define el valor de la propiedad tillInteractions.
     * 
     * @param value
     *     allowed object is
     *     {@link TillInteractions }
     *     
     */
    public void setTillInteractions(TillInteractions value) {
        this.tillInteractions = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nearMissMessage" type="{http://impl.ws.fal.com/}nearMissMessage" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nearMissMessage"
    })
    public static class NearMissMessages {

        protected List<NearMissMessage> nearMissMessage;

        /**
         * Gets the value of the nearMissMessage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nearMissMessage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNearMissMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NearMissMessage }
         * 
         * 
         */
        public List<NearMissMessage> getNearMissMessage() {
            if (nearMissMessage == null) {
                nearMissMessage = new ArrayList<NearMissMessage>();
            }
            return this.nearMissMessage;
        }

    }

}
