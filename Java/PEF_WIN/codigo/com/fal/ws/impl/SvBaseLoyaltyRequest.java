/**
 * SvBaseLoyaltyRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class SvBaseLoyaltyRequest  extends com.fal.ws.impl.BaseLoyaltyRequest  implements java.io.Serializable {
    private java.lang.String additionalAmount;

    private java.lang.String amountSettlement;

    private java.lang.String currencyCodeSettlement;

    private java.lang.String dateExpiration;

    private java.lang.String originalDataElements;

    private java.lang.String POSEntryMode;

    private java.lang.String settlementDate;

    private java.lang.String track1;

    private java.lang.String track2;

    private java.lang.String transactionAmount;

    private java.lang.String transmissionDateTime;

    public SvBaseLoyaltyRequest() {
    }

    public SvBaseLoyaltyRequest(
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
           java.lang.String transactionTime,
           java.lang.String additionalAmount,
           java.lang.String amountSettlement,
           java.lang.String currencyCodeSettlement,
           java.lang.String dateExpiration,
           java.lang.String originalDataElements,
           java.lang.String POSEntryMode,
           java.lang.String settlementDate,
           java.lang.String track1,
           java.lang.String track2,
           java.lang.String transactionAmount,
           java.lang.String transmissionDateTime) {
        super(
            cashierID,
            currencyCode,
            functionID,
            PAN,
            persist,
            processingCode,
            siteCode,
            terminalID,
            terminalType,
            transactionDate,
            transactionNumber,
            transactionTime);
        this.additionalAmount = additionalAmount;
        this.amountSettlement = amountSettlement;
        this.currencyCodeSettlement = currencyCodeSettlement;
        this.dateExpiration = dateExpiration;
        this.originalDataElements = originalDataElements;
        this.POSEntryMode = POSEntryMode;
        this.settlementDate = settlementDate;
        this.track1 = track1;
        this.track2 = track2;
        this.transactionAmount = transactionAmount;
        this.transmissionDateTime = transmissionDateTime;
    }


    /**
     * Gets the additionalAmount value for this SvBaseLoyaltyRequest.
     * 
     * @return additionalAmount
     */
    public java.lang.String getAdditionalAmount() {
        return additionalAmount;
    }


    /**
     * Sets the additionalAmount value for this SvBaseLoyaltyRequest.
     * 
     * @param additionalAmount
     */
    public void setAdditionalAmount(java.lang.String additionalAmount) {
        this.additionalAmount = additionalAmount;
    }


    /**
     * Gets the amountSettlement value for this SvBaseLoyaltyRequest.
     * 
     * @return amountSettlement
     */
    public java.lang.String getAmountSettlement() {
        return amountSettlement;
    }


    /**
     * Sets the amountSettlement value for this SvBaseLoyaltyRequest.
     * 
     * @param amountSettlement
     */
    public void setAmountSettlement(java.lang.String amountSettlement) {
        this.amountSettlement = amountSettlement;
    }


    /**
     * Gets the currencyCodeSettlement value for this SvBaseLoyaltyRequest.
     * 
     * @return currencyCodeSettlement
     */
    public java.lang.String getCurrencyCodeSettlement() {
        return currencyCodeSettlement;
    }


    /**
     * Sets the currencyCodeSettlement value for this SvBaseLoyaltyRequest.
     * 
     * @param currencyCodeSettlement
     */
    public void setCurrencyCodeSettlement(java.lang.String currencyCodeSettlement) {
        this.currencyCodeSettlement = currencyCodeSettlement;
    }


    /**
     * Gets the dateExpiration value for this SvBaseLoyaltyRequest.
     * 
     * @return dateExpiration
     */
    public java.lang.String getDateExpiration() {
        return dateExpiration;
    }


    /**
     * Sets the dateExpiration value for this SvBaseLoyaltyRequest.
     * 
     * @param dateExpiration
     */
    public void setDateExpiration(java.lang.String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }


    /**
     * Gets the originalDataElements value for this SvBaseLoyaltyRequest.
     * 
     * @return originalDataElements
     */
    public java.lang.String getOriginalDataElements() {
        return originalDataElements;
    }


    /**
     * Sets the originalDataElements value for this SvBaseLoyaltyRequest.
     * 
     * @param originalDataElements
     */
    public void setOriginalDataElements(java.lang.String originalDataElements) {
        this.originalDataElements = originalDataElements;
    }


    /**
     * Gets the POSEntryMode value for this SvBaseLoyaltyRequest.
     * 
     * @return POSEntryMode
     */
    public java.lang.String getPOSEntryMode() {
        return POSEntryMode;
    }


    /**
     * Sets the POSEntryMode value for this SvBaseLoyaltyRequest.
     * 
     * @param POSEntryMode
     */
    public void setPOSEntryMode(java.lang.String POSEntryMode) {
        this.POSEntryMode = POSEntryMode;
    }


    /**
     * Gets the settlementDate value for this SvBaseLoyaltyRequest.
     * 
     * @return settlementDate
     */
    public java.lang.String getSettlementDate() {
        return settlementDate;
    }


    /**
     * Sets the settlementDate value for this SvBaseLoyaltyRequest.
     * 
     * @param settlementDate
     */
    public void setSettlementDate(java.lang.String settlementDate) {
        this.settlementDate = settlementDate;
    }


    /**
     * Gets the track1 value for this SvBaseLoyaltyRequest.
     * 
     * @return track1
     */
    public java.lang.String getTrack1() {
        return track1;
    }


    /**
     * Sets the track1 value for this SvBaseLoyaltyRequest.
     * 
     * @param track1
     */
    public void setTrack1(java.lang.String track1) {
        this.track1 = track1;
    }


    /**
     * Gets the track2 value for this SvBaseLoyaltyRequest.
     * 
     * @return track2
     */
    public java.lang.String getTrack2() {
        return track2;
    }


    /**
     * Sets the track2 value for this SvBaseLoyaltyRequest.
     * 
     * @param track2
     */
    public void setTrack2(java.lang.String track2) {
        this.track2 = track2;
    }


    /**
     * Gets the transactionAmount value for this SvBaseLoyaltyRequest.
     * 
     * @return transactionAmount
     */
    public java.lang.String getTransactionAmount() {
        return transactionAmount;
    }


    /**
     * Sets the transactionAmount value for this SvBaseLoyaltyRequest.
     * 
     * @param transactionAmount
     */
    public void setTransactionAmount(java.lang.String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }


    /**
     * Gets the transmissionDateTime value for this SvBaseLoyaltyRequest.
     * 
     * @return transmissionDateTime
     */
    public java.lang.String getTransmissionDateTime() {
        return transmissionDateTime;
    }


    /**
     * Sets the transmissionDateTime value for this SvBaseLoyaltyRequest.
     * 
     * @param transmissionDateTime
     */
    public void setTransmissionDateTime(java.lang.String transmissionDateTime) {
        this.transmissionDateTime = transmissionDateTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SvBaseLoyaltyRequest)) return false;
        SvBaseLoyaltyRequest other = (SvBaseLoyaltyRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.additionalAmount==null && other.getAdditionalAmount()==null) || 
             (this.additionalAmount!=null &&
              this.additionalAmount.equals(other.getAdditionalAmount()))) &&
            ((this.amountSettlement==null && other.getAmountSettlement()==null) || 
             (this.amountSettlement!=null &&
              this.amountSettlement.equals(other.getAmountSettlement()))) &&
            ((this.currencyCodeSettlement==null && other.getCurrencyCodeSettlement()==null) || 
             (this.currencyCodeSettlement!=null &&
              this.currencyCodeSettlement.equals(other.getCurrencyCodeSettlement()))) &&
            ((this.dateExpiration==null && other.getDateExpiration()==null) || 
             (this.dateExpiration!=null &&
              this.dateExpiration.equals(other.getDateExpiration()))) &&
            ((this.originalDataElements==null && other.getOriginalDataElements()==null) || 
             (this.originalDataElements!=null &&
              this.originalDataElements.equals(other.getOriginalDataElements()))) &&
            ((this.POSEntryMode==null && other.getPOSEntryMode()==null) || 
             (this.POSEntryMode!=null &&
              this.POSEntryMode.equals(other.getPOSEntryMode()))) &&
            ((this.settlementDate==null && other.getSettlementDate()==null) || 
             (this.settlementDate!=null &&
              this.settlementDate.equals(other.getSettlementDate()))) &&
            ((this.track1==null && other.getTrack1()==null) || 
             (this.track1!=null &&
              this.track1.equals(other.getTrack1()))) &&
            ((this.track2==null && other.getTrack2()==null) || 
             (this.track2!=null &&
              this.track2.equals(other.getTrack2()))) &&
            ((this.transactionAmount==null && other.getTransactionAmount()==null) || 
             (this.transactionAmount!=null &&
              this.transactionAmount.equals(other.getTransactionAmount()))) &&
            ((this.transmissionDateTime==null && other.getTransmissionDateTime()==null) || 
             (this.transmissionDateTime!=null &&
              this.transmissionDateTime.equals(other.getTransmissionDateTime())));
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
        if (getAdditionalAmount() != null) {
            _hashCode += getAdditionalAmount().hashCode();
        }
        if (getAmountSettlement() != null) {
            _hashCode += getAmountSettlement().hashCode();
        }
        if (getCurrencyCodeSettlement() != null) {
            _hashCode += getCurrencyCodeSettlement().hashCode();
        }
        if (getDateExpiration() != null) {
            _hashCode += getDateExpiration().hashCode();
        }
        if (getOriginalDataElements() != null) {
            _hashCode += getOriginalDataElements().hashCode();
        }
        if (getPOSEntryMode() != null) {
            _hashCode += getPOSEntryMode().hashCode();
        }
        if (getSettlementDate() != null) {
            _hashCode += getSettlementDate().hashCode();
        }
        if (getTrack1() != null) {
            _hashCode += getTrack1().hashCode();
        }
        if (getTrack2() != null) {
            _hashCode += getTrack2().hashCode();
        }
        if (getTransactionAmount() != null) {
            _hashCode += getTransactionAmount().hashCode();
        }
        if (getTransmissionDateTime() != null) {
            _hashCode += getTransmissionDateTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SvBaseLoyaltyRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "svBaseLoyaltyRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("additionalAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "additionalAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountSettlement");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amountSettlement"));
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
        elemField.setFieldName("dateExpiration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateExpiration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalDataElements");
        elemField.setXmlName(new javax.xml.namespace.QName("", "originalDataElements"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("POSEntryMode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "POSEntryMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settlementDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "settlementDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("track1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "track1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("track2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "track2"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transmissionDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transmissionDateTime"));
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
