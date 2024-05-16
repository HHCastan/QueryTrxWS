/**
 * LineItems.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class LineItems  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.LineItem[] lineItem;

    public LineItems() {
    }

    public LineItems(
           com.fal.ws.impl.LineItem[] lineItem) {
        this.lineItem = lineItem;
    }


    /**
     * Gets the lineItem value for this LineItems.
     * 
     * @return lineItem
     */
    public com.fal.ws.impl.LineItem[] getLineItem() {
        return lineItem;
    }


    /**
     * Sets the lineItem value for this LineItems.
     * 
     * @param lineItem
     */
    public void setLineItem(com.fal.ws.impl.LineItem[] lineItem) {
        this.lineItem = lineItem;
    }

    public com.fal.ws.impl.LineItem getLineItem(int i) {
        return this.lineItem[i];
    }

    public void setLineItem(int i, com.fal.ws.impl.LineItem _value) {
        this.lineItem[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LineItems)) return false;
        LineItems other = (LineItems) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.lineItem==null && other.getLineItem()==null) || 
             (this.lineItem!=null &&
              java.util.Arrays.equals(this.lineItem, other.getLineItem())));
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
        if (getLineItem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLineItem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLineItem(), i);
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
        new org.apache.axis.description.TypeDesc(LineItems.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItems"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lineItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lineItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItem"));
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
