/**
 * BaseLoyaltyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class BaseLoyaltyResponse  extends com.fal.ws.impl.FalBaseResponse  implements java.io.Serializable {
    private java.lang.String cashierID;

    private java.lang.String currencyCode;

    private java.lang.String PAN;

    private java.lang.String processingCode;

    private java.lang.String responseCode;

    private java.lang.String terminalID;

    private java.lang.String transactionDate;

    private java.lang.String transactionNumber;

    private java.lang.String transactionTime;

    private java.lang.String transmissionTimestamp;

    public BaseLoyaltyResponse() {
    }

    public BaseLoyaltyResponse(
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
           java.lang.String transmissionTimestamp) {
        super(
            messages,
            success);
        this.cashierID = cashierID;
        this.currencyCode = currencyCode;
        this.PAN = PAN;
        this.processingCode = processingCode;
        this.responseCode = responseCode;
        this.terminalID = terminalID;
        this.transactionDate = transactionDate;
        this.transactionNumber = transactionNumber;
        this.transactionTime = transactionTime;
        this.transmissionTimestamp = transmissionTimestamp;
    }


    /**
     * Gets the cashierID value for this BaseLoyaltyResponse.
     * 
     * @return cashierID
     */
    public java.lang.String getCashierID() {
        return cashierID;
    }


    /**
     * Sets the cashierID value for this BaseLoyaltyResponse.
     * 
     * @param cashierID
     */
    public void setCashierID(java.lang.String cashierID) {
        this.cashierID = cashierID;
    }


    /**
     * Gets the currencyCode value for this BaseLoyaltyResponse.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this BaseLoyaltyResponse.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the PAN value for this BaseLoyaltyResponse.
     * 
     * @return PAN
     */
    public java.lang.String getPAN() {
        return PAN;
    }


    /**
     * Sets the PAN value for this BaseLoyaltyResponse.
     * 
     * @param PAN
     */
    public void setPAN(java.lang.String PAN) {
        this.PAN = PAN;
    }


    /**
     * Gets the processingCode value for this BaseLoyaltyResponse.
     * 
     * @return processingCode
     */
    public java.lang.String getProcessingCode() {
        return processingCode;
    }


    /**
     * Sets the processingCode value for this BaseLoyaltyResponse.
     * 
     * @param processingCode
     */
    public void setProcessingCode(java.lang.String processingCode) {
        this.processingCode = processingCode;
    }


    /**
     * Gets the responseCode value for this BaseLoyaltyResponse.
     * 
     * @return responseCode
     */
    public java.lang.String getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this BaseLoyaltyResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the terminalID value for this BaseLoyaltyResponse.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this BaseLoyaltyResponse.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the transactionDate value for this BaseLoyaltyResponse.
     * 
     * @return transactionDate
     */
    public java.lang.String getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this BaseLoyaltyResponse.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.lang.String transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the transactionNumber value for this BaseLoyaltyResponse.
     * 
     * @return transactionNumber
     */
    public java.lang.String getTransactionNumber() {
        return transactionNumber;
    }


    /**
     * Sets the transactionNumber value for this BaseLoyaltyResponse.
     * 
     * @param transactionNumber
     */
    public void setTransactionNumber(java.lang.String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }


    /**
     * Gets the transactionTime value for this BaseLoyaltyResponse.
     * 
     * @return transactionTime
     */
    public java.lang.String getTransactionTime() {
        return transactionTime;
    }


    /**
     * Sets the transactionTime value for this BaseLoyaltyResponse.
     * 
     * @param transactionTime
     */
    public void setTransactionTime(java.lang.String transactionTime) {
        this.transactionTime = transactionTime;
    }


    /**
     * Gets the transmissionTimestamp value for this BaseLoyaltyResponse.
     * 
     * @return transmissionTimestamp
     */
    public java.lang.String getTransmissionTimestamp() {
        return transmissionTimestamp;
    }


    /**
     * Sets the transmissionTimestamp value for this BaseLoyaltyResponse.
     * 
     * @param transmissionTimestamp
     */
    public void setTransmissionTimestamp(java.lang.String transmissionTimestamp) {
        this.transmissionTimestamp = transmissionTimestamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseLoyaltyResponse)) return false;
        BaseLoyaltyResponse other = (BaseLoyaltyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cashierID==null && other.getCashierID()==null) || 
             (this.cashierID!=null &&
              this.cashierID.equals(other.getCashierID()))) &&
            ((this.currencyCode==null && other.getCurrencyCode()==null) || 
             (this.currencyCode!=null &&
              this.currencyCode.equals(other.getCurrencyCode()))) &&
            ((this.PAN==null && other.getPAN()==null) || 
             (this.PAN!=null &&
              this.PAN.equals(other.getPAN()))) &&
            ((this.processingCode==null && other.getProcessingCode()==null) || 
             (this.processingCode!=null &&
              this.processingCode.equals(other.getProcessingCode()))) &&
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.transactionNumber==null && other.getTransactionNumber()==null) || 
             (this.transactionNumber!=null &&
              this.transactionNumber.equals(other.getTransactionNumber()))) &&
            ((this.transactionTime==null && other.getTransactionTime()==null) || 
             (this.transactionTime!=null &&
              this.transactionTime.equals(other.getTransactionTime()))) &&
            ((this.transmissionTimestamp==null && other.getTransmissionTimestamp()==null) || 
             (this.transmissionTimestamp!=null &&
              this.transmissionTimestamp.equals(other.getTransmissionTimestamp())));
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
        if (getCashierID() != null) {
            _hashCode += getCashierID().hashCode();
        }
        if (getCurrencyCode() != null) {
            _hashCode += getCurrencyCode().hashCode();
        }
        if (getPAN() != null) {
            _hashCode += getPAN().hashCode();
        }
        if (getProcessingCode() != null) {
            _hashCode += getProcessingCode().hashCode();
        }
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getTerminalID() != null) {
            _hashCode += getTerminalID().hashCode();
        }
        if (getTransactionDate() != null) {
            _hashCode += getTransactionDate().hashCode();
        }
        if (getTransactionNumber() != null) {
            _hashCode += getTransactionNumber().hashCode();
        }
        if (getTransactionTime() != null) {
            _hashCode += getTransactionTime().hashCode();
        }
        if (getTransmissionTimestamp() != null) {
            _hashCode += getTransmissionTimestamp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseLoyaltyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "baseLoyaltyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashierID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashierID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "currencyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAN");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("processingCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "processingCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "responseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminalID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminalID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transmissionTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transmissionTimestamp"));
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
