/**
 * SupInfos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class SupInfos  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.KeyValue[] supInfo;

    public SupInfos() {
    }

    public SupInfos(
           com.fal.ws.impl.KeyValue[] supInfo) {
        this.supInfo = supInfo;
    }


    /**
     * Gets the supInfo value for this SupInfos.
     * 
     * @return supInfo
     */
    public com.fal.ws.impl.KeyValue[] getSupInfo() {
        return supInfo;
    }


    /**
     * Sets the supInfo value for this SupInfos.
     * 
     * @param supInfo
     */
    public void setSupInfo(com.fal.ws.impl.KeyValue[] supInfo) {
        this.supInfo = supInfo;
    }

    public com.fal.ws.impl.KeyValue getSupInfo(int i) {
        return this.supInfo[i];
    }

    public void setSupInfo(int i, com.fal.ws.impl.KeyValue _value) {
        this.supInfo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SupInfos)) return false;
        SupInfos other = (SupInfos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.supInfo==null && other.getSupInfo()==null) || 
             (this.supInfo!=null &&
              java.util.Arrays.equals(this.supInfo, other.getSupInfo())));
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
        if (getSupInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSupInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSupInfo(), i);
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
        new org.apache.axis.description.TypeDesc(SupInfos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "supInfos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("supInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "supInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "keyValue"));
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
