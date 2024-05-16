/**
 * ProductTriggers.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class ProductTriggers  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.ProductTrigger[] productTrigger;

    public ProductTriggers() {
    }

    public ProductTriggers(
           com.fal.ws.impl.ProductTrigger[] productTrigger) {
        this.productTrigger = productTrigger;
    }


    /**
     * Gets the productTrigger value for this ProductTriggers.
     * 
     * @return productTrigger
     */
    public com.fal.ws.impl.ProductTrigger[] getProductTrigger() {
        return productTrigger;
    }


    /**
     * Sets the productTrigger value for this ProductTriggers.
     * 
     * @param productTrigger
     */
    public void setProductTrigger(com.fal.ws.impl.ProductTrigger[] productTrigger) {
        this.productTrigger = productTrigger;
    }

    public com.fal.ws.impl.ProductTrigger getProductTrigger(int i) {
        return this.productTrigger[i];
    }

    public void setProductTrigger(int i, com.fal.ws.impl.ProductTrigger _value) {
        this.productTrigger[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProductTriggers)) return false;
        ProductTriggers other = (ProductTriggers) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.productTrigger==null && other.getProductTrigger()==null) || 
             (this.productTrigger!=null &&
              java.util.Arrays.equals(this.productTrigger, other.getProductTrigger())));
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
        if (getProductTrigger() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductTrigger());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductTrigger(), i);
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
        new org.apache.axis.description.TypeDesc(ProductTriggers.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productTriggers"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productTrigger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productTrigger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productTrigger"));
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
