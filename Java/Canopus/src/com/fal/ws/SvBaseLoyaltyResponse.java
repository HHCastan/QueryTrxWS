
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para svBaseLoyaltyResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="svBaseLoyaltyResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}baseLoyaltyResponse">
 *       &lt;sequence>
 *         &lt;element name="additionalAmounts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalResponseData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authIdResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currencyCodeSettlement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="functionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retrievalReferenceNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "svBaseLoyaltyResponse", propOrder = {
    "additionalAmounts",
    "additionalResponseData",
    "authIdResponse",
    "currencyCodeSettlement",
    "functionID",
    "retrievalReferenceNum",
    "transactionAmount"
})
public class SvBaseLoyaltyResponse
    extends BaseLoyaltyResponse
{

    protected String additionalAmounts;
    protected String additionalResponseData;
    protected String authIdResponse;
    protected String currencyCodeSettlement;
    protected String functionID;
    protected String retrievalReferenceNum;
    protected String transactionAmount;

    /**
     * Obtiene el valor de la propiedad additionalAmounts.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalAmounts() {
        return additionalAmounts;
    }

    /**
     * Define el valor de la propiedad additionalAmounts.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalAmounts(String value) {
        this.additionalAmounts = value;
    }

    /**
     * Obtiene el valor de la propiedad additionalResponseData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalResponseData() {
        return additionalResponseData;
    }

    /**
     * Define el valor de la propiedad additionalResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalResponseData(String value) {
        this.additionalResponseData = value;
    }

    /**
     * Obtiene el valor de la propiedad authIdResponse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthIdResponse() {
        return authIdResponse;
    }

    /**
     * Define el valor de la propiedad authIdResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthIdResponse(String value) {
        this.authIdResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCodeSettlement.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCodeSettlement() {
        return currencyCodeSettlement;
    }

    /**
     * Define el valor de la propiedad currencyCodeSettlement.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCodeSettlement(String value) {
        this.currencyCodeSettlement = value;
    }

    /**
     * Obtiene el valor de la propiedad functionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionID() {
        return functionID;
    }

    /**
     * Define el valor de la propiedad functionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionID(String value) {
        this.functionID = value;
    }

    /**
     * Obtiene el valor de la propiedad retrievalReferenceNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetrievalReferenceNum() {
        return retrievalReferenceNum;
    }

    /**
     * Define el valor de la propiedad retrievalReferenceNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetrievalReferenceNum(String value) {
        this.retrievalReferenceNum = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionAmount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Define el valor de la propiedad transactionAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAmount(String value) {
        this.transactionAmount = value;
    }

}
