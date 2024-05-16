/**
 * TransactionLimitations.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class TransactionLimitations  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.TransactionLimitation[] transactionLimitation;

    public TransactionLimitations() {
    }

    public TransactionLimitations(
           com.fal.ws.impl.TransactionLimitation[] transactionLimitation) {
        this.transactionLimitation = transactionLimitation;
    }


    /**
     * Gets the transactionLimitation value for this TransactionLimitations.
     * 
     * @return transactionLimitation
     */
    public com.fal.ws.impl.TransactionLimitation[] getTransactionLimitation() {
        return transactionLimitation;
    }


    /**
     * Sets the transactionLimitation value for this TransactionLimitations.
     * 
     * @param transactionLimitation
     */
    public void setTransactionLimitation(com.fal.ws.impl.TransactionLimitation[] transactionLimitation) {
        this.transactionLimitation = transactionLimitation;
    }

    public com.fal.ws.impl.TransactionLimitation getTransactionLimitation(int i) {
        return this.transactionLimitation[i];
    }

    public void setTransactionLimitation(int i, com.fal.ws.impl.TransactionLimitation _value) {
        this.transactionLimitation[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionLimitations)) return false;
        TransactionLimitations other = (TransactionLimitations) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.transactionLimitation==null && other.getTransactionLimitation()==null) || 
             (this.transactionLimitation!=null &&
              java.util.Arrays.equals(this.transactionLimitation, other.getTransactionLimitation())));
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
        if (getTransactionLimitation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransactionLimitation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransactionLimitation(), i);
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
        new org.apache.axis.description.TypeDesc(TransactionLimitations.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "transactionLimitations"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionLimitation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionLimitation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "transactionLimitation"));
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
