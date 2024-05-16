/**
 * GiftRewards.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class GiftRewards  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.GiftReward[] giftReward;

    public GiftRewards() {
    }

    public GiftRewards(
           com.fal.ws.impl.GiftReward[] giftReward) {
        this.giftReward = giftReward;
    }


    /**
     * Gets the giftReward value for this GiftRewards.
     * 
     * @return giftReward
     */
    public com.fal.ws.impl.GiftReward[] getGiftReward() {
        return giftReward;
    }


    /**
     * Sets the giftReward value for this GiftRewards.
     * 
     * @param giftReward
     */
    public void setGiftReward(com.fal.ws.impl.GiftReward[] giftReward) {
        this.giftReward = giftReward;
    }

    public com.fal.ws.impl.GiftReward getGiftReward(int i) {
        return this.giftReward[i];
    }

    public void setGiftReward(int i, com.fal.ws.impl.GiftReward _value) {
        this.giftReward[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GiftRewards)) return false;
        GiftRewards other = (GiftRewards) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.giftReward==null && other.getGiftReward()==null) || 
             (this.giftReward!=null &&
              java.util.Arrays.equals(this.giftReward, other.getGiftReward())));
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
        if (getGiftReward() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGiftReward());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGiftReward(), i);
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
        new org.apache.axis.description.TypeDesc(GiftRewards.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "giftRewards"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("giftReward");
        elemField.setXmlName(new javax.xml.namespace.QName("", "giftReward"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "giftReward"));
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
