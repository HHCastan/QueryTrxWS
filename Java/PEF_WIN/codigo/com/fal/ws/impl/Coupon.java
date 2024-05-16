/**
 * Coupon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class Coupon  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String advantageId;

    private java.lang.Float amount;

    private java.lang.Integer amountType;

    private java.lang.String campaignId;

    private java.lang.String counter;

    private java.lang.String couponLPF;

    private java.lang.Integer couponType;

    private java.lang.Float couponValue;

    private java.util.Calendar endDate;

    private java.lang.Integer format;

    private java.lang.String id;

    private com.fal.ws.impl.CouponMessages messages;

    private java.util.Calendar startDate;

    public Coupon() {
    }

    public Coupon(
           java.lang.String advantageId,
           java.lang.Float amount,
           java.lang.Integer amountType,
           java.lang.String campaignId,
           java.lang.String counter,
           java.lang.String couponLPF,
           java.lang.Integer couponType,
           java.lang.Float couponValue,
           java.util.Calendar endDate,
           java.lang.Integer format,
           java.lang.String id,
           com.fal.ws.impl.CouponMessages messages,
           java.util.Calendar startDate) {
        this.advantageId = advantageId;
        this.amount = amount;
        this.amountType = amountType;
        this.campaignId = campaignId;
        this.counter = counter;
        this.couponLPF = couponLPF;
        this.couponType = couponType;
        this.couponValue = couponValue;
        this.endDate = endDate;
        this.format = format;
        this.id = id;
        this.messages = messages;
        this.startDate = startDate;
    }


    /**
     * Gets the advantageId value for this Coupon.
     * 
     * @return advantageId
     */
    public java.lang.String getAdvantageId() {
        return advantageId;
    }


    /**
     * Sets the advantageId value for this Coupon.
     * 
     * @param advantageId
     */
    public void setAdvantageId(java.lang.String advantageId) {
        this.advantageId = advantageId;
    }


    /**
     * Gets the amount value for this Coupon.
     * 
     * @return amount
     */
    public java.lang.Float getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this Coupon.
     * 
     * @param amount
     */
    public void setAmount(java.lang.Float amount) {
        this.amount = amount;
    }


    /**
     * Gets the amountType value for this Coupon.
     * 
     * @return amountType
     */
    public java.lang.Integer getAmountType() {
        return amountType;
    }


    /**
     * Sets the amountType value for this Coupon.
     * 
     * @param amountType
     */
    public void setAmountType(java.lang.Integer amountType) {
        this.amountType = amountType;
    }


    /**
     * Gets the campaignId value for this Coupon.
     * 
     * @return campaignId
     */
    public java.lang.String getCampaignId() {
        return campaignId;
    }


    /**
     * Sets the campaignId value for this Coupon.
     * 
     * @param campaignId
     */
    public void setCampaignId(java.lang.String campaignId) {
        this.campaignId = campaignId;
    }


    /**
     * Gets the counter value for this Coupon.
     * 
     * @return counter
     */
    public java.lang.String getCounter() {
        return counter;
    }


    /**
     * Sets the counter value for this Coupon.
     * 
     * @param counter
     */
    public void setCounter(java.lang.String counter) {
        this.counter = counter;
    }


    /**
     * Gets the couponLPF value for this Coupon.
     * 
     * @return couponLPF
     */
    public java.lang.String getCouponLPF() {
        return couponLPF;
    }


    /**
     * Sets the couponLPF value for this Coupon.
     * 
     * @param couponLPF
     */
    public void setCouponLPF(java.lang.String couponLPF) {
        this.couponLPF = couponLPF;
    }


    /**
     * Gets the couponType value for this Coupon.
     * 
     * @return couponType
     */
    public java.lang.Integer getCouponType() {
        return couponType;
    }


    /**
     * Sets the couponType value for this Coupon.
     * 
     * @param couponType
     */
    public void setCouponType(java.lang.Integer couponType) {
        this.couponType = couponType;
    }


    /**
     * Gets the couponValue value for this Coupon.
     * 
     * @return couponValue
     */
    public java.lang.Float getCouponValue() {
        return couponValue;
    }


    /**
     * Sets the couponValue value for this Coupon.
     * 
     * @param couponValue
     */
    public void setCouponValue(java.lang.Float couponValue) {
        this.couponValue = couponValue;
    }


    /**
     * Gets the endDate value for this Coupon.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this Coupon.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the format value for this Coupon.
     * 
     * @return format
     */
    public java.lang.Integer getFormat() {
        return format;
    }


    /**
     * Sets the format value for this Coupon.
     * 
     * @param format
     */
    public void setFormat(java.lang.Integer format) {
        this.format = format;
    }


    /**
     * Gets the id value for this Coupon.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Coupon.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the messages value for this Coupon.
     * 
     * @return messages
     */
    public com.fal.ws.impl.CouponMessages getMessages() {
        return messages;
    }


    /**
     * Sets the messages value for this Coupon.
     * 
     * @param messages
     */
    public void setMessages(com.fal.ws.impl.CouponMessages messages) {
        this.messages = messages;
    }


    /**
     * Gets the startDate value for this Coupon.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this Coupon.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Coupon)) return false;
        Coupon other = (Coupon) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.advantageId==null && other.getAdvantageId()==null) || 
             (this.advantageId!=null &&
              this.advantageId.equals(other.getAdvantageId()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.amountType==null && other.getAmountType()==null) || 
             (this.amountType!=null &&
              this.amountType.equals(other.getAmountType()))) &&
            ((this.campaignId==null && other.getCampaignId()==null) || 
             (this.campaignId!=null &&
              this.campaignId.equals(other.getCampaignId()))) &&
            ((this.counter==null && other.getCounter()==null) || 
             (this.counter!=null &&
              this.counter.equals(other.getCounter()))) &&
            ((this.couponLPF==null && other.getCouponLPF()==null) || 
             (this.couponLPF!=null &&
              this.couponLPF.equals(other.getCouponLPF()))) &&
            ((this.couponType==null && other.getCouponType()==null) || 
             (this.couponType!=null &&
              this.couponType.equals(other.getCouponType()))) &&
            ((this.couponValue==null && other.getCouponValue()==null) || 
             (this.couponValue!=null &&
              this.couponValue.equals(other.getCouponValue()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.messages==null && other.getMessages()==null) || 
             (this.messages!=null &&
              this.messages.equals(other.getMessages()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate())));
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
        if (getAdvantageId() != null) {
            _hashCode += getAdvantageId().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getAmountType() != null) {
            _hashCode += getAmountType().hashCode();
        }
        if (getCampaignId() != null) {
            _hashCode += getCampaignId().hashCode();
        }
        if (getCounter() != null) {
            _hashCode += getCounter().hashCode();
        }
        if (getCouponLPF() != null) {
            _hashCode += getCouponLPF().hashCode();
        }
        if (getCouponType() != null) {
            _hashCode += getCouponType().hashCode();
        }
        if (getCouponValue() != null) {
            _hashCode += getCouponValue().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMessages() != null) {
            _hashCode += getMessages().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Coupon.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "coupon"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("advantageId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "advantageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaignId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "campaignId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("counter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "counter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponLPF");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponLPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("couponValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "couponValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("format");
        elemField.setXmlName(new javax.xml.namespace.QName("", "format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "messages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "couponMessages"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
