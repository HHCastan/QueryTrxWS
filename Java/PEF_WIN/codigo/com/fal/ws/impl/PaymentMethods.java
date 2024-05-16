/**
 * PaymentMethods.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class PaymentMethods  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String auditNumber;

    private int newNumberIssuedCoupons;

    private int newPointsBalance;

    private int numberPrintedCoupons;

    private com.fal.ws.impl.PaymentMethod[] paymentMethod;

    public PaymentMethods() {
    }

    public PaymentMethods(
           java.lang.String auditNumber,
           int newNumberIssuedCoupons,
           int newPointsBalance,
           int numberPrintedCoupons,
           com.fal.ws.impl.PaymentMethod[] paymentMethod) {
        this.auditNumber = auditNumber;
        this.newNumberIssuedCoupons = newNumberIssuedCoupons;
        this.newPointsBalance = newPointsBalance;
        this.numberPrintedCoupons = numberPrintedCoupons;
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the auditNumber value for this PaymentMethods.
     * 
     * @return auditNumber
     */
    public java.lang.String getAuditNumber() {
        return auditNumber;
    }


    /**
     * Sets the auditNumber value for this PaymentMethods.
     * 
     * @param auditNumber
     */
    public void setAuditNumber(java.lang.String auditNumber) {
        this.auditNumber = auditNumber;
    }


    /**
     * Gets the newNumberIssuedCoupons value for this PaymentMethods.
     * 
     * @return newNumberIssuedCoupons
     */
    public int getNewNumberIssuedCoupons() {
        return newNumberIssuedCoupons;
    }


    /**
     * Sets the newNumberIssuedCoupons value for this PaymentMethods.
     * 
     * @param newNumberIssuedCoupons
     */
    public void setNewNumberIssuedCoupons(int newNumberIssuedCoupons) {
        this.newNumberIssuedCoupons = newNumberIssuedCoupons;
    }


    /**
     * Gets the newPointsBalance value for this PaymentMethods.
     * 
     * @return newPointsBalance
     */
    public int getNewPointsBalance() {
        return newPointsBalance;
    }


    /**
     * Sets the newPointsBalance value for this PaymentMethods.
     * 
     * @param newPointsBalance
     */
    public void setNewPointsBalance(int newPointsBalance) {
        this.newPointsBalance = newPointsBalance;
    }


    /**
     * Gets the numberPrintedCoupons value for this PaymentMethods.
     * 
     * @return numberPrintedCoupons
     */
    public int getNumberPrintedCoupons() {
        return numberPrintedCoupons;
    }


    /**
     * Sets the numberPrintedCoupons value for this PaymentMethods.
     * 
     * @param numberPrintedCoupons
     */
    public void setNumberPrintedCoupons(int numberPrintedCoupons) {
        this.numberPrintedCoupons = numberPrintedCoupons;
    }


    /**
     * Gets the paymentMethod value for this PaymentMethods.
     * 
     * @return paymentMethod
     */
    public com.fal.ws.impl.PaymentMethod[] getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this PaymentMethods.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(com.fal.ws.impl.PaymentMethod[] paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public com.fal.ws.impl.PaymentMethod getPaymentMethod(int i) {
        return this.paymentMethod[i];
    }

    public void setPaymentMethod(int i, com.fal.ws.impl.PaymentMethod _value) {
        this.paymentMethod[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentMethods)) return false;
        PaymentMethods other = (PaymentMethods) obj;
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
            this.newNumberIssuedCoupons == other.getNewNumberIssuedCoupons() &&
            this.newPointsBalance == other.getNewPointsBalance() &&
            this.numberPrintedCoupons == other.getNumberPrintedCoupons() &&
            ((this.paymentMethod==null && other.getPaymentMethod()==null) || 
             (this.paymentMethod!=null &&
              java.util.Arrays.equals(this.paymentMethod, other.getPaymentMethod())));
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
        _hashCode += getNewNumberIssuedCoupons();
        _hashCode += getNewPointsBalance();
        _hashCode += getNumberPrintedCoupons();
        if (getPaymentMethod() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPaymentMethod());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPaymentMethod(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentMethods.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "paymentMethods"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auditNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auditNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newNumberIssuedCoupons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newNumberIssuedCoupons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPointsBalance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "newPointsBalance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberPrintedCoupons");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberPrintedCoupons"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "paymentMethod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
