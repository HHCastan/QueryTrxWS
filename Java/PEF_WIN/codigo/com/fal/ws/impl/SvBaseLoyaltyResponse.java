/**
 * SvBaseLoyaltyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class SvBaseLoyaltyResponse  extends com.fal.ws.impl.BaseLoyaltyResponse  implements java.io.Serializable {
    private java.lang.String additionalAmounts;

    private java.lang.String additionalResponseData;

    private java.lang.String authIdResponse;

    private java.lang.String currencyCodeSettlement;

    private java.lang.String functionID;

    private java.lang.String retrievalReferenceNum;

    private java.lang.String transactionAmount;

    public SvBaseLoyaltyResponse() {
    }

    public SvBaseLoyaltyResponse(
           com.fal.ws.impl.ResponseMessage[] messages,
           boolean success,
           java.lang.String cashierID,
           java.lang.String currencyCode,
           java.lang.String PAN,
           java.lang.String processingCode,
           java.lang.String responseCode,
           java.lang.String terminalID,
           java.lang.String transactionDate,
           java.lang.String transactionNumber,
           java.lang.String transactionTime,
           java.lang.String transmissionTimestamp,
           java.lang.String additionalAmounts,
           java.lang.String additionalResponseData,
           java.lang.String authIdResponse,
           java.lang.String currencyCodeSettlement,
           java.lang.String functionID,
           java.lang.String retrievalReferenceNum,
           java.lang.String transactionAmount) {
        super(
            messages,
            success,
            cashierID,
            currencyCode,
            PAN,
            processingCode,
            responseCode,
            terminalID,
            transactionDate,
            transactionNumber,
            transactionTime,
            transmissionTimestamp);
        this.additionalAmounts = additionalAmounts;
        this.additionalResponseData = additionalResponseData;
        this.authIdResponse = authIdResponse;
        this.currencyCodeSettlement = currencyCodeSettlement;
        this.functionID = functionID;
        this.retrievalReferenceNum = retrievalReferenceNum;
        this.transactionAmount = transactionAmount;
    }


    /**
     * Gets the additionalAmounts value for this SvBaseLoyaltyResponse.
     * 
     * @return additionalAmounts
     */
    public java.lang.String getAdditionalAmounts() {
        return additionalAmounts;
    }


    /**
     * Sets the additionalAmounts value for this SvBaseLoyaltyResponse.
     * 
     * @param additionalAmounts
     */
    public void setAdditionalAmounts(java.lang.String additionalAmounts) {
        this.additionalAmounts = additionalAmounts;
    }


    /**
     * Gets the additionalResponseData value for this SvBaseLoyaltyResponse.
     * 
     * @return additionalResponseData
     */
    public java.lang.String getAdditionalResponseData() {
        return additionalResponseData;
    }


    /**
     * Sets the additionalResponseData value for this SvBaseLoyaltyResponse.
     * 
     * @param additionalResponseData
     */
    public void setAdditionalResponseData(java.lang.String additionalResponseData) {
        this.additionalResponseData = additionalResponseData;
    }


    /**
     * Gets the authIdResponse value for this SvBaseLoyaltyResponse.
     * 
     * @return authIdResponse
     */
    public java.lang.String getAuthIdResponse() {
        return authIdResponse;
    }


    /**
     * Sets the authIdResponse value for this SvBaseLoyaltyResponse.
     * 
     * @param authIdResponse
     */
    public void setAuthIdResponse(java.lang.String authIdResponse) {
        this.authIdResponse = authIdResponse;
    }


    /**
     * Gets the currencyCodeSettlement value for this SvBaseLoyaltyResponse.
     * 
     * @return currencyCodeSettlement
     */
    public java.lang.String getCurrencyCodeSettlement() {
        return currencyCodeSettlement;
    }


    /**
     * Sets the currencyCodeSettlement value for this SvBaseLoyaltyResponse.
     * 
     * @param currencyCodeSettlement
     */
    public void setCurrencyCodeSettlement(java.lang.String currencyCodeSettlement) {
        this.currencyCodeSettlement = currencyCodeSettlement;
    }


    /**
     * Gets the functionID value for this SvBaseLoyaltyResponse.
     * 
     * @return functionID
     */
    public java.lang.String getFunctionID() {
        return functionID;
    }


    /**
     * Sets the functionID value for this SvBaseLoyaltyResponse.
     * 
     * @param functionID
     */
    public void setFunctionID(java.lang.String functionID) {
        this.functionID = functionID;
    }


    /**
     * Gets the retrievalReferenceNum value for this SvBaseLoyaltyResponse.
     * 
     * @return retrievalReferenceNum
     */
    public java.lang.String getRetrievalReferenceNum() {
        return retrievalReferenceNum;
    }


    /**
     * Sets the retrievalReferenceNum value for this SvBaseLoyaltyResponse.
     * 
     * @param retrievalReferenceNum
     */
    public void setRetrievalReferenceNum(java.lang.String retrievalReferenceNum) {
        this.retrievalReferenceNum = retrievalReferenceNum;
    }


    /**
     * Gets the transactionAmount value for this SvBaseLoyaltyResponse.
     * 
     * @return transactionAmount
     */
    public java.lang.String getTransactionAmount() {
        return transactionAmount;
    }


    /**
     * Sets the transactionAmount value for this SvBaseLoyaltyResponse.
     * 
     * @param transactionAmount
     */
    public void setTransactionAmount(java.lang.String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SvBaseLoyaltyResponse)) return false;
        SvBaseLoyaltyResponse other = (SvBaseLoyaltyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.additionalAmounts==null && other.getAdditionalAmounts()==null) || 
             (this.additionalAmounts!=null &&
              this.additionalAmounts.equals(other.getAdditionalAmounts()))) &&
            ((this.additionalResponseData==null && other.getAdditionalResponseData()==null) || 
             (this.additionalResponseData!=null &&
              this.additionalResponseData.equals(other.getAdditionalResponseData()))) &&
            ((this.authIdResponse==null && other.getAuthIdResponse()==null) || 
             (this.authIdResponse!=null &&
              this.authIdResponse.equals(other.getAuthIdResponse()))) &&
            ((this.currencyCodeSettlement==null && other.getCurrencyCodeSettlement()==null) || 
             (this.currencyCodeSettlement!=null &&
              this.currencyCodeSettlement.equals(other.getCurrencyCodeSettlement()))) &&
            ((this.functionID==null && other.getFunctionID()==null) || 
             (this.functionID!=null &&
              this.functionID.equals(other.getFunctionID()))) &&
            ((this.retrievalReferenceNum==null && other.getRetrievalReferenceNum()==null) || 
             (this.retrievalReferenceNum!=null &&
              this.retrievalReferenceNum.equals(other.getRetrievalReferenceNum()))) &&
            ((this.transactionAmount==null && other.getTransactionAmount()==null) || 
             (this.transactionAmount!=null &&
              this.transactionAmount.equals(other.getTransactionAmount())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAdditionalAmounts() != null) {
            _hashCode += getAdditionalAmounts().hashCode();
        }
        if (getAdditionalResponseData() != null) {
            _hashCode += getAdditionalResponseData().hashCode();
        }
        if (getAuthIdResponse() != null) {
            _hashCode += getAuthIdResponse().hashCode();
        }
        if (getCurrencyCodeSettlement() != null) {
            _hashCode += getCurrencyCodeSettlement().hashCode();
        }
        if (getFunctionID() != null) {
            _hashCode += getFunctionID().hashCode();
        }
        if (getRetrievalReferenceNum() != null) {
            _hashCode += getRetrievalReferenceNum().hashCode();
        }
        if (getTransactionAmount() != null) {
            _hashCode += getTransactionAmount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SvBaseLoyaltyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "svBaseLoyaltyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalAmounts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "additionalAmounts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalResponseData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "additionalResponseData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authIdResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "authIdResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCodeSettlement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currencyCodeSettlement"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("functionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "functionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retrievalReferenceNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "retrievalReferenceNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
