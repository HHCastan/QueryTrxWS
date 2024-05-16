/**
 * Reward.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class Reward  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private int carrier;

    private int category;

    private java.lang.String financingRef;

    private int index;

    private java.lang.String productCode;

    private java.lang.String productFamily;

    private com.fal.ws.impl.ProductTriggers productTriggers;

    private double rewardAmount;

    private java.lang.String rewardDescription;

    private java.lang.String rewardID;

    private com.fal.ws.impl.RewardMessage rewardMessage;

    private int rewardQuantity;

    public Reward() {
    }

    public Reward(
           int carrier,
           int category,
           java.lang.String financingRef,
           int index,
           java.lang.String productCode,
           java.lang.String productFamily,
           com.fal.ws.impl.ProductTriggers productTriggers,
           double rewardAmount,
           java.lang.String rewardDescription,
           java.lang.String rewardID,
           com.fal.ws.impl.RewardMessage rewardMessage,
           int rewardQuantity) {
        this.carrier = carrier;
        this.category = category;
        this.financingRef = financingRef;
        this.index = index;
        this.productCode = productCode;
        this.productFamily = productFamily;
        this.productTriggers = productTriggers;
        this.rewardAmount = rewardAmount;
        this.rewardDescription = rewardDescription;
        this.rewardID = rewardID;
        this.rewardMessage = rewardMessage;
        this.rewardQuantity = rewardQuantity;
    }


    /**
     * Gets the carrier value for this Reward.
     * 
     * @return carrier
     */
    public int getCarrier() {
        return carrier;
    }


    /**
     * Sets the carrier value for this Reward.
     * 
     * @param carrier
     */
    public void setCarrier(int carrier) {
        this.carrier = carrier;
    }


    /**
     * Gets the category value for this Reward.
     * 
     * @return category
     */
    public int getCategory() {
        return category;
    }


    /**
     * Sets the category value for this Reward.
     * 
     * @param category
     */
    public void setCategory(int category) {
        this.category = category;
    }


    /**
     * Gets the financingRef value for this Reward.
     * 
     * @return financingRef
     */
    public java.lang.String getFinancingRef() {
        return financingRef;
    }


    /**
     * Sets the financingRef value for this Reward.
     * 
     * @param financingRef
     */
    public void setFinancingRef(java.lang.String financingRef) {
        this.financingRef = financingRef;
    }


    /**
     * Gets the index value for this Reward.
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }


    /**
     * Sets the index value for this Reward.
     * 
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }


    /**
     * Gets the productCode value for this Reward.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this Reward.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productFamily value for this Reward.
     * 
     * @return productFamily
     */
    public java.lang.String getProductFamily() {
        return productFamily;
    }


    /**
     * Sets the productFamily value for this Reward.
     * 
     * @param productFamily
     */
    public void setProductFamily(java.lang.String productFamily) {
        this.productFamily = productFamily;
    }


    /**
     * Gets the productTriggers value for this Reward.
     * 
     * @return productTriggers
     */
    public com.fal.ws.impl.ProductTriggers getProductTriggers() {
        return productTriggers;
    }


    /**
     * Sets the productTriggers value for this Reward.
     * 
     * @param productTriggers
     */
    public void setProductTriggers(com.fal.ws.impl.ProductTriggers productTriggers) {
        this.productTriggers = productTriggers;
    }


    /**
     * Gets the rewardAmount value for this Reward.
     * 
     * @return rewardAmount
     */
    public double getRewardAmount() {
        return rewardAmount;
    }


    /**
     * Sets the rewardAmount value for this Reward.
     * 
     * @param rewardAmount
     */
    public void setRewardAmount(double rewardAmount) {
        this.rewardAmount = rewardAmount;
    }


    /**
     * Gets the rewardDescription value for this Reward.
     * 
     * @return rewardDescription
     */
    public java.lang.String getRewardDescription() {
        return rewardDescription;
    }


    /**
     * Sets the rewardDescription value for this Reward.
     * 
     * @param rewardDescription
     */
    public void setRewardDescription(java.lang.String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }


    /**
     * Gets the rewardID value for this Reward.
     * 
     * @return rewardID
     */
    public java.lang.String getRewardID() {
        return rewardID;
    }


    /**
     * Sets the rewardID value for this Reward.
     * 
     * @param rewardID
     */
    public void setRewardID(java.lang.String rewardID) {
        this.rewardID = rewardID;
    }


    /**
     * Gets the rewardMessage value for this Reward.
     * 
     * @return rewardMessage
     */
    public com.fal.ws.impl.RewardMessage getRewardMessage() {
        return rewardMessage;
    }


    /**
     * Sets the rewardMessage value for this Reward.
     * 
     * @param rewardMessage
     */
    public void setRewardMessage(com.fal.ws.impl.RewardMessage rewardMessage) {
        this.rewardMessage = rewardMessage;
    }


    /**
     * Gets the rewardQuantity value for this Reward.
     * 
     * @return rewardQuantity
     */
    public int getRewardQuantity() {
        return rewardQuantity;
    }


    /**
     * Sets the rewardQuantity value for this Reward.
     * 
     * @param rewardQuantity
     */
    public void setRewardQuantity(int rewardQuantity) {
        this.rewardQuantity = rewardQuantity;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Reward)) return false;
        Reward other = (Reward) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.carrier == other.getCarrier() &&
            this.category == other.getCategory() &&
            ((this.financingRef==null && other.getFinancingRef()==null) || 
             (this.financingRef!=null &&
              this.financingRef.equals(other.getFinancingRef()))) &&
            this.index == other.getIndex() &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productFamily==null && other.getProductFamily()==null) || 
             (this.productFamily!=null &&
              this.productFamily.equals(other.getProductFamily()))) &&
            ((this.productTriggers==null && other.getProductTriggers()==null) || 
             (this.productTriggers!=null &&
              this.productTriggers.equals(other.getProductTriggers()))) &&
            this.rewardAmount == other.getRewardAmount() &&
            ((this.rewardDescription==null && other.getRewardDescription()==null) || 
             (this.rewardDescription!=null &&
              this.rewardDescription.equals(other.getRewardDescription()))) &&
            ((this.rewardID==null && other.getRewardID()==null) || 
             (this.rewardID!=null &&
              this.rewardID.equals(other.getRewardID()))) &&
            ((this.rewardMessage==null && other.getRewardMessage()==null) || 
             (this.rewardMessage!=null &&
              this.rewardMessage.equals(other.getRewardMessage()))) &&
            this.rewardQuantity == other.getRewardQuantity();
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
        _hashCode += getCarrier();
        _hashCode += getCategory();
        if (getFinancingRef() != null) {
            _hashCode += getFinancingRef().hashCode();
        }
        _hashCode += getIndex();
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductFamily() != null) {
            _hashCode += getProductFamily().hashCode();
        }
        if (getProductTriggers() != null) {
            _hashCode += getProductTriggers().hashCode();
        }
        _hashCode += new Double(getRewardAmount()).hashCode();
        if (getRewardDescription() != null) {
            _hashCode += getRewardDescription().hashCode();
        }
        if (getRewardID() != null) {
            _hashCode += getRewardID().hashCode();
        }
        if (getRewardMessage() != null) {
            _hashCode += getRewardMessage().hashCode();
        }
        _hashCode += getRewardQuantity();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Reward.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "reward"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("carrier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "carrier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("financingRef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "financingRef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("", "index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productFamily");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productFamily"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productTriggers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productTriggers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productTriggers"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardMessage"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
