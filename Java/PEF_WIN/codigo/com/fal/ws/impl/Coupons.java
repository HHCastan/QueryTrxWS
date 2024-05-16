/**
 * Coupons.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class Coupons  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.Coupon[] coupon;

    public Coupons() {
    }

    public Coupons(
           com.fal.ws.impl.Coupon[] coupon) {
        this.coupon = coupon;
    }


    /**
     * Gets the coupon value for this Coupons.
     * 
     * @return coupon
     */
    public com.fal.ws.impl.Coupon[] getCoupon() {
        return coupon;
    }


    /**
     * Sets the coupon value for this Coupons.
     * 
     * @param coupon
     */
    public void setCoupon(com.fal.ws.impl.Coupon[] coupon) {
        this.coupon = coupon;
    }

    public com.fal.ws.impl.Coupon getCoupon(int i) {
        return this.coupon[i];
    }

    public void setCoupon(int i, com.fal.ws.impl.Coupon _value) {
        this.coupon[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Coupons)) return false;
        Coupons other = (Coupons) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.coupon==null && other.getCoupon()==null) || 
             (this.coupon!=null &&
              java.util.Arrays.equals(this.coupon, other.getCoupon())));
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
        if (getCoupon() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCoupon());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCoupon(), i);
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
        new org.apache.axis.description.TypeDesc(Coupons.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "coupons"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("coupon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "coupon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "coupon"));
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
