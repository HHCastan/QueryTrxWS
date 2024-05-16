/**
 * BaseLoyaltyRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class BaseLoyaltyRequest  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String cashierID;

    private java.lang.String currencyCode;

    private java.lang.String functionID;

    private java.lang.String PAN;

    private boolean persist;

    private java.lang.String processingCode;

    private java.lang.String siteCode;

    private java.lang.String terminalID;

    private java.lang.String terminalType;

    private java.lang.String transactionDate;

    private java.lang.String transactionNumber;

    private java.lang.String transactionTime;

    public BaseLoyaltyRequest() {
    }

    public BaseLoyaltyRequest(
           java.lang.String cashierID,
           java.lang.String currencyCode,
           java.lang.String functionID,
           java.lang.String PAN,
           boolean persist,
           java.lang.String processingCode,
           java.lang.String siteCode,
           java.lang.String terminalID,
           java.lang.String terminalType,
           java.lang.String transactionDate,
           java.lang.String transactionNumber,
           java.lang.String transactionTime) {
        this.cashierID = cashierID;
        this.currencyCode = currencyCode;
        this.functionID = functionID;
        this.PAN = PAN;
        this.persist = persist;
        this.processingCode = processingCode;
        this.siteCode = siteCode;
        this.terminalID = terminalID;
        this.terminalType = terminalType;
        this.transactionDate = transactionDate;
        this.transactionNumber = transactionNumber;
        this.transactionTime = transactionTime;
    }


    /**
     * Gets the cashierID value for this BaseLoyaltyRequest.
     * 
     * @return cashierID
     */
    public java.lang.String getCashierID() {
        return cashierID;
    }


    /**
     * Sets the cashierID value for this BaseLoyaltyRequest.
     * 
     * @param cashierID
     */
    public void setCashierID(java.lang.String cashierID) {
        this.cashierID = cashierID;
    }


    /**
     * Gets the currencyCode value for this BaseLoyaltyRequest.
     * 
     * @return currencyCode
     */
    public java.lang.String getCurrencyCode() {
        return currencyCode;
    }


    /**
     * Sets the currencyCode value for this BaseLoyaltyRequest.
     * 
     * @param currencyCode
     */
    public void setCurrencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     * Gets the functionID value for this BaseLoyaltyRequest.
     * 
     * @return functionID
     */
    public java.lang.String getFunctionID() {
        return functionID;
    }


    /**
     * Sets the functionID value for this BaseLoyaltyRequest.
     * 
     * @param functionID
     */
    public void setFunctionID(java.lang.String functionID) {
        this.functionID = functionID;
    }


    /**
     * Gets the PAN value for this BaseLoyaltyRequest.
     * 
     * @return PAN
     */
    public java.lang.String getPAN() {
        return PAN;
    }


    /**
     * Sets the PAN value for this BaseLoyaltyRequest.
     * 
     * @param PAN
     */
    public void setPAN(java.lang.String PAN) {
        this.PAN = PAN;
    }


    /**
     * Gets the persist value for this BaseLoyaltyRequest.
     * 
     * @return persist
     */
    public boolean isPersist() {
        return persist;
    }


    /**
     * Sets the persist value for this BaseLoyaltyRequest.
     * 
     * @param persist
     */
    public void setPersist(boolean persist) {
        this.persist = persist;
    }


    /**
     * Gets the processingCode value for this BaseLoyaltyRequest.
     * 
     * @return processingCode
     */
    public java.lang.String getProcessingCode() {
        return processingCode;
    }


    /**
     * Sets the processingCode value for this BaseLoyaltyRequest.
     * 
     * @param processingCode
     */
    public void setProcessingCode(java.lang.String processingCode) {
        this.processingCode = processingCode;
    }


    /**
     * Gets the siteCode value for this BaseLoyaltyRequest.
     * 
     * @return siteCode
     */
    public java.lang.String getSiteCode() {
        return siteCode;
    }


    /**
     * Sets the siteCode value for this BaseLoyaltyRequest.
     * 
     * @param siteCode
     */
    public void setSiteCode(java.lang.String siteCode) {
        this.siteCode = siteCode;
    }


    /**
     * Gets the terminalID value for this BaseLoyaltyRequest.
     * 
     * @return terminalID
     */
    public java.lang.String getTerminalID() {
        return terminalID;
    }


    /**
     * Sets the terminalID value for this BaseLoyaltyRequest.
     * 
     * @param terminalID
     */
    public void setTerminalID(java.lang.String terminalID) {
        this.terminalID = terminalID;
    }


    /**
     * Gets the terminalType value for this BaseLoyaltyRequest.
     * 
     * @return terminalType
     */
    public java.lang.String getTerminalType() {
        return terminalType;
    }


    /**
     * Sets the terminalType value for this BaseLoyaltyRequest.
     * 
     * @param terminalType
     */
    public void setTerminalType(java.lang.String terminalType) {
        this.terminalType = terminalType;
    }


    /**
     * Gets the transactionDate value for this BaseLoyaltyRequest.
     * 
     * @return transactionDate
     */
    public java.lang.String getTransactionDate() {
        return transactionDate;
    }


    /**
     * Sets the transactionDate value for this BaseLoyaltyRequest.
     * 
     * @param transactionDate
     */
    public void setTransactionDate(java.lang.String transactionDate) {
        this.transactionDate = transactionDate;
    }


    /**
     * Gets the transactionNumber value for this BaseLoyaltyRequest.
     * 
     * @return transactionNumber
     */
    public java.lang.String getTransactionNumber() {
        return transactionNumber;
    }


    /**
     * Sets the transactionNumber value for this BaseLoyaltyRequest.
     * 
     * @param transactionNumber
     */
    public void setTransactionNumber(java.lang.String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }


    /**
     * Gets the transactionTime value for this BaseLoyaltyRequest.
     * 
     * @return transactionTime
     */
    public java.lang.String getTransactionTime() {
        return transactionTime;
    }


    /**
     * Sets the transactionTime value for this BaseLoyaltyRequest.
     * 
     * @param transactionTime
     */
    public void setTransactionTime(java.lang.String transactionTime) {
        this.transactionTime = transactionTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BaseLoyaltyRequest)) return false;
        BaseLoyaltyRequest other = (BaseLoyaltyRequest) obj;
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
            ((this.functionID==null && other.getFunctionID()==null) || 
             (this.functionID!=null &&
              this.functionID.equals(other.getFunctionID()))) &&
            ((this.PAN==null && other.getPAN()==null) || 
             (this.PAN!=null &&
              this.PAN.equals(other.getPAN()))) &&
            this.persist == other.isPersist() &&
            ((this.processingCode==null && other.getProcessingCode()==null) || 
             (this.processingCode!=null &&
              this.processingCode.equals(other.getProcessingCode()))) &&
            ((this.siteCode==null && other.getSiteCode()==null) || 
             (this.siteCode!=null &&
              this.siteCode.equals(other.getSiteCode()))) &&
            ((this.terminalID==null && other.getTerminalID()==null) || 
             (this.terminalID!=null &&
              this.terminalID.equals(other.getTerminalID()))) &&
            ((this.terminalType==null && other.getTerminalType()==null) || 
             (this.terminalType!=null &&
              this.terminalType.equals(other.getTerminalType()))) &&
            ((this.transactionDate==null && other.getTransactionDate()==null) || 
             (this.transactionDate!=null &&
              this.transactionDate.equals(other.getTransactionDate()))) &&
            ((this.transactionNumber==null && other.getTransactionNumber()==null) || 
             (this.transactionNumber!=null &&
              this.transactionNumber.equals(other.getTransactionNumber()))) &&
            ((this.transactionTime==null && other.getTransactionTime()==null) || 
             (this.transactionTime!=null &&
              this.transactionTime.equals(other.getTransactionTime())));
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
        if (getFunctionID() != null) {
            _hashCode += getFunctionID().hashCode();
        }
        if (getPAN() != null) {
            _hashCode += getPAN().hashCode();
        }
        _hashCode += (isPersist() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getProcessingCode() != null) {
            _hashCode += getProcessingCode().hashCode();
        }
        if (getSiteCode() != null) {
            _hashCode += getSiteCode().hashCode();
        }
        if (getTerminalID() != null) {
            _hashCode += getTerminalID().hashCode();
        }
        if (getTerminalType() != null) {
            _hashCode += getTerminalType().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseLoyaltyRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "baseLoyaltyRequest"));
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
        elemField.setFieldName("functionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "functionID"));
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
        elemField.setFieldName("persist");
        elemField.setXmlName(new javax.xml.namespace.QName("", "persist"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("siteCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siteCode"));
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
        elemField.setFieldName("terminalType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "terminalType"));
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
