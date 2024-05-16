/**
 * VoidedRewards.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class VoidedRewards  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.VoidedReward[] voidedReward;

    public VoidedRewards() {
    }

    public VoidedRewards(
           com.fal.ws.impl.VoidedReward[] voidedReward) {
        this.voidedReward = voidedReward;
    }


    /**
     * Gets the voidedReward value for this VoidedRewards.
     * 
     * @return voidedReward
     */
    public com.fal.ws.impl.VoidedReward[] getVoidedReward() {
        return voidedReward;
    }


    /**
     * Sets the voidedReward value for this VoidedRewards.
     * 
     * @param voidedReward
     */
    public void setVoidedReward(com.fal.ws.impl.VoidedReward[] voidedReward) {
        this.voidedReward = voidedReward;
    }

    public com.fal.ws.impl.VoidedReward getVoidedReward(int i) {
        return this.voidedReward[i];
    }

    public void setVoidedReward(int i, com.fal.ws.impl.VoidedReward _value) {
        this.voidedReward[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VoidedRewards)) return false;
        VoidedRewards other = (VoidedRewards) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.voidedReward==null && other.getVoidedReward()==null) || 
             (this.voidedReward!=null &&
              java.util.Arrays.equals(this.voidedReward, other.getVoidedReward())));
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
        if (getVoidedReward() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVoidedReward());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVoidedReward(), i);
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
        new org.apache.axis.description.TypeDesc(VoidedRewards.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "voidedRewards"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("voidedReward");
        elemField.setXmlName(new javax.xml.namespace.QName("", "voidedReward"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "voidedReward"));
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
