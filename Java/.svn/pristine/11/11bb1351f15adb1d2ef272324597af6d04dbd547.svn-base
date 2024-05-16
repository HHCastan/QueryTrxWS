
package com.fal.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para productPromotionResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="productPromotionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseResponse">
 *       &lt;sequence>
 *         &lt;element name="cardDetails" type="{http://impl.ws.fal.com/}cardDetails" minOccurs="0"/>
 *         &lt;element name="processingTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="productPromotion" type="{http://impl.ws.fal.com/}productPromotion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transmissionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productPromotionResponse", propOrder = {
    "cardDetails",
    "processingTime",
    "productPromotion",
    "transmissionTimestamp"
})
public class ProductPromotionResponse
    extends FalBaseResponse
{

    protected CardDetails cardDetails;
    protected long processingTime;
    @XmlElement(nillable = true)
    protected List<ProductPromotion> productPromotion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transmissionTimestamp;

    /**
     * Obtiene el valor de la propiedad cardDetails.
     * 
     * @return
     *     possible object is
     *     {@link CardDetails }
     *     
     */
    public CardDetails getCardDetails() {
        return cardDetails;
    }

    /**
     * Define el valor de la propiedad cardDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link CardDetails }
     *     
     */
    public void setCardDetails(CardDetails value) {
        this.cardDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad processingTime.
     * 
     */
    public long getProcessingTime() {
        return processingTime;
    }

    /**
     * Define el valor de la propiedad processingTime.
     * 
     */
    public void setProcessingTime(long value) {
        this.processingTime = value;
    }

    /**
     * Gets the value of the productPromotion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productPromotion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductPromotion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductPromotion }
     * 
     * 
     */
    public List<ProductPromotion> getProductPromotion() {
        if (productPromotion == null) {
            productPromotion = new ArrayList<ProductPromotion>();
        }
        return this.productPromotion;
    }

    /**
     * Obtiene el valor de la propiedad transmissionTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransmissionTimestamp() {
        return transmissionTimestamp;
    }

    /**
     * Define el valor de la propiedad transmissionTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransmissionTimestamp(XMLGregorianCalendar value) {
        this.transmissionTimestamp = value;
    }

}
