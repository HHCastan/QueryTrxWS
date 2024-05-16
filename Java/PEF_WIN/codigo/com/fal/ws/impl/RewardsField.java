/**
 * RewardsField.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class RewardsField  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String auditNumber;

    private int numberGrantedCoupons;

    private int numberPointsConvertedIntoCoupons;

    private int pointsBalance;

    private java.lang.String pointsBalanceTimestamp;

    private double pointsEarned;

    private int previouslyIssuedCoupons;

    private com.fal.ws.impl.Rewards rewards;

    private int tempPointsBalance;

    private int totalDiscountAmount;

    public RewardsField() {
    }

    public RewardsField(
           java.lang.String auditNumber,
           int numberGrantedCoupons,
           int numberPointsConvertedIntoCoupons,
           int pointsBalance,
           java.lang.String pointsBalanceTimestamp,
           double pointsEarned,
           int previouslyIssuedCoupons,
           com.fal.ws.impl.Rewards rewards,
           int tempPointsBalance,
           int totalDiscountAmount) {
        this.auditNumber = auditNumber;
        this.numberGrantedCoupons = numberGrantedCoupons;
        this.numberPointsConvertedIntoCoupons = numberPointsConvertedIntoCoupons;
        this.pointsBalance = pointsBalance;
        this.pointsBalanceTimestamp = pointsBalanceTimestamp;
        this.pointsEarned = pointsEarned;
        this.previouslyIssuedCoupons = previouslyIssuedCoupons;
        this.rewards = rewards;
        this.tempPointsBalance = tempPointsBalance;
        this.totalDiscountAmount = totalDiscountAmount;
    }


    /**
     * Gets the auditNumber value for this RewardsField.
     * 
     * @return auditNumber
     */
    public java.lang.String getAuditNumber() {
        return auditNumber;
    }


    /**
     * Sets the auditNumber value for this RewardsField.
     * 
     * @param auditNumber
     */
    public void setAuditNumber(java.lang.String auditNumber) {
        this.auditNumber = auditNumber;
    }


    /**
     * Gets the numberGrantedCoupons value for this RewardsField.
     * 
     * @return numberGrantedCoupons
     */
    public int getNumberGrantedCoupons() {
        return numberGrantedCoupons;
    }


    /**
     * Sets the numberGrantedCoupons value for this RewardsField.
     * 
     * @param numberGrantedCoupons
     */
    public void setNumberGrantedCoupons(int numberGrantedCoupons) {
        this.numberGrantedCoupons = numberGrantedCoupons;
    }


    /**
     * Gets the numberPointsConvertedIntoCoupons value for this RewardsField.
     * 
     * @return numberPointsConvertedIntoCoupons
     */
    public int getNumberPointsConvertedIntoCoupons() {
        return numberPointsConvertedIntoCoupons;
    }


    /**
     * Sets the numberPointsConvertedIntoCoupons value for this RewardsField.
     * 
     * @param numberPointsConvertedIntoCoupons
     */
    public void setNumberPointsConvertedIntoCoupons(int numberPointsConvertedIntoCoupons) {
        this.numberPointsConvertedIntoCoupons = numberPointsConvertedIntoCoupons;
    }


    /**
     * Gets the pointsBalance value for this RewardsField.
     * 
     * @return pointsBalance
     */
    public int getPointsBalance() {
        return pointsBalance;
    }


    /**
     * Sets the pointsBalance value for this RewardsField.
     * 
     * @param pointsBalance
     */
    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }


    /**
     * Gets the pointsBalanceTimestamp value for this RewardsField.
     * 
     * @return pointsBalanceTimestamp
     */
    public java.lang.String getPointsBalanceTimestamp() {
        return pointsBalanceTimestamp;
    }


    /**
     * Sets the pointsBalanceTimestamp value for this RewardsField.
     * 
     * @param pointsBalanceTimestamp
     */
    public void setPointsBalanceTimestamp(java.lang.String pointsBalanceTimestamp) {
        this.pointsBalanceTimestamp = pointsBalanceTimestamp;
    }


    /**
     * Gets the pointsEarned value for this RewardsField.
     * 
     * @return pointsEarned
     */
    public double getPointsEarned() {
        return pointsEarned;
    }


    /**
     * Sets the pointsEarned value for this RewardsField.
     * 
     * @param pointsEarned
     */
    public void setPointsEarned(double pointsEarned) {
        this.pointsEarned = pointsEarned;
    }


    /**
     * Gets the previouslyIssuedCoupons value for this RewardsField.
     * 
     * @return previouslyIssuedCoupons
     */
    public int getPreviouslyIssuedCoupons() {
        return previouslyIssuedCoupons;
    }


    /**
     * Sets the previouslyIssuedCoupons value for this RewardsField.
     * 
     * @param previouslyIssuedCoupons
     */
    public void setPreviouslyIssuedCoupons(int previouslyIssuedCoupons) {
        this.previouslyIssuedCoupons = previouslyIssuedCoupons;
    }


    /**
     * Gets the rewards value for this RewardsField.
     * 
     * @return rewards
     */
    public com.fal.ws.impl.Rewards getRewards() {
        return rewards;
    }


    /**
     * Sets the rewards value for this RewardsField.
     * 
     * @param rewards
     */
    public void setRewards(com.fal.ws.impl.Rewards rewards) {
        this.rewards = rewards;
    }


    /**
     * Gets the tempPointsBalance value for this RewardsField.
     * 
     * @return tempPointsBalance
     */
    public int getTempPointsBalance() {
        return tempPointsBalance;
    }


    /**
     * Sets the tempPointsBalance value for this RewardsField.
     * 
     * @param tempPointsBalance
     */
    public void setTempPointsBalance(int tempPointsBalance) {
        this.tempPointsBalance = tempPointsBalance;
    }


    /**
     * Gets the totalDiscountAmount value for this RewardsField.
     * 
     * @return totalDiscountAmount
     */
    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }


    /**
     * Sets the totalDiscountAmount value for this RewardsField.
     * 
     * @param totalDiscountAmount
     */
    public void setTotalDiscountAmount(int totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RewardsField)) return false;
        RewardsField other = (RewardsField) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.auditNumber==null && other.getAuditNumber()==null) || 
             (this.auditNumber!=null &&
              this.auditNumber.equals(other.getAuditNumber()))) &&
            this.numberGrantedCoupons == other.getNumberGrantedCoupons() &&
            this.numberPointsConvertedIntoCoupons == other.getNumberPointsConvertedIntoCoupons() &&
            this.pointsBalance == other.getPointsBalance() &&
            ((this.pointsBalanceTimestamp==null && other.getPointsBalanceTimestamp()==null) || 
             (this.pointsBalanceTimestamp!=null &&
              this.pointsBalanceTimestamp.equals(other.getPointsBalanceTimestamp()))) &&
            this.pointsEarned == other.getPointsEarned() &&
            this.previouslyIssuedCoupons == other.getPreviouslyIssuedCoupons() &&
            ((this.rewards==null && other.getRewards()==null) || 
             (this.rewards!=null &&
              this.rewards.equals(other.getRewards()))) &&
            this.tempPointsBalance == other.getTempPointsBalance() &&
            this.totalDiscountAmount == other.getTotalDiscountAmount();
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
        if (getAuditNumber() != null) {
            _hashCode += getAuditNumber().hashCode();
        }
        _hashCode += getNumberGrantedCoupons();
        _hashCode += getNumberPointsConvertedIntoCoupons();
        _hashCode += getPointsBalance();
        if (getPointsBalanceTimestamp() != null) {
            _hashCode += getPointsBalanceTimestamp().hashCode();
        }
        _hashCode += new Double(getPointsEarned()).hashCode();
        _hashCode += getPreviouslyIssuedCoupons();
        if (getRewards() != null) {
            _hashCode += getRewards().hashCode();
        }
        _hashCode += getTempPointsBalance();
        _hashCode += getTotalDiscountAmount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RewardsField.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardsField"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberGrantedCoupons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberGrantedCoupons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberPointsConvertedIntoCoupons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberPointsConvertedIntoCoupons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pointsBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pointsBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pointsBalanceTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pointsBalanceTimestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pointsEarned");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pointsEarned"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previouslyIssuedCoupons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previouslyIssuedCoupons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewards");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewards"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewards"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempPointsBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempPointsBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalDiscountAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalDiscountAmount"));
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
