
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para basketRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="basketRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}baseLoyaltyRequest">
 *       &lt;sequence>
 *         &lt;element name="giftRewards" type="{http://impl.ws.fal.com/}giftRewards" minOccurs="0"/>
 *         &lt;element name="paymentMethods" type="{http://impl.ws.fal.com/}paymentMethods" minOccurs="0"/>
 *         &lt;element name="rewardLimitations" type="{http://impl.ws.fal.com/}rewardLimitations" minOccurs="0"/>
 *         &lt;element name="ticket" type="{http://impl.ws.fal.com/}ticket" minOccurs="0"/>
 *         &lt;element name="tillInteractionAnswers" type="{http://impl.ws.fal.com/}tillInteractionAnswers" minOccurs="0"/>
 *         &lt;element name="transactionLimitations" type="{http://impl.ws.fal.com/}transactionLimitations" minOccurs="0"/>
 *         &lt;element name="voidedRewards" type="{http://impl.ws.fal.com/}voidedRewards" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "basketRequest", propOrder = {
    "giftRewards",
    "paymentMethods",
    "rewardLimitations",
    "ticket",
    "tillInteractionAnswers",
    "transactionLimitations",
    "voidedRewards"
})
public class BasketRequest
    extends BaseLoyaltyRequest
{

    protected GiftRewards giftRewards;
    protected PaymentMethods paymentMethods;
    protected RewardLimitations rewardLimitations;
    protected Ticket ticket;
    protected TillInteractionAnswers tillInteractionAnswers;
    protected TransactionLimitations transactionLimitations;
    protected VoidedRewards voidedRewards;

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
     * Obtiene el valor de la propiedad paymentMethods.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethods }
     *     
     */
    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Define el valor de la propiedad paymentMethods.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethods }
     *     
     */
    public void setPaymentMethods(PaymentMethods value) {
        this.paymentMethods = value;
    }

    /**
     * Obtiene el valor de la propiedad rewardLimitations.
     * 
     * @return
     *     possible object is
     *     {@link RewardLimitations }
     *     
     */
    public RewardLimitations getRewardLimitations() {
        return rewardLimitations;
    }

    /**
     * Define el valor de la propiedad rewardLimitations.
     * 
     * @param value
     *     allowed object is
     *     {@link RewardLimitations }
     *     
     */
    public void setRewardLimitations(RewardLimitations value) {
        this.rewardLimitations = value;
    }

    /**
     * Obtiene el valor de la propiedad ticket.
     * 
     * @return
     *     possible object is
     *     {@link Ticket }
     *     
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Define el valor de la propiedad ticket.
     * 
     * @param value
     *     allowed object is
     *     {@link Ticket }
     *     
     */
    public void setTicket(Ticket value) {
        this.ticket = value;
    }

    /**
     * Obtiene el valor de la propiedad tillInteractionAnswers.
     * 
     * @return
     *     possible object is
     *     {@link TillInteractionAnswers }
     *     
     */
    public TillInteractionAnswers getTillInteractionAnswers() {
        return tillInteractionAnswers;
    }

    /**
     * Define el valor de la propiedad tillInteractionAnswers.
     * 
     * @param value
     *     allowed object is
     *     {@link TillInteractionAnswers }
     *     
     */
    public void setTillInteractionAnswers(TillInteractionAnswers value) {
        this.tillInteractionAnswers = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionLimitations.
     * 
     * @return
     *     possible object is
     *     {@link TransactionLimitations }
     *     
     */
    public TransactionLimitations getTransactionLimitations() {
        return transactionLimitations;
    }

    /**
     * Define el valor de la propiedad transactionLimitations.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionLimitations }
     *     
     */
    public void setTransactionLimitations(TransactionLimitations value) {
        this.transactionLimitations = value;
    }

    /**
     * Obtiene el valor de la propiedad voidedRewards.
     * 
     * @return
     *     possible object is
     *     {@link VoidedRewards }
     *     
     */
    public VoidedRewards getVoidedRewards() {
        return voidedRewards;
    }

    /**
     * Define el valor de la propiedad voidedRewards.
     * 
     * @param value
     *     allowed object is
     *     {@link VoidedRewards }
     *     
     */
    public void setVoidedRewards(VoidedRewards value) {
        this.voidedRewards = value;
    }

}
