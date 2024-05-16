/**
 * TrxErrors.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class TrxErrors  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.TrxError[] transactionError;

    public TrxErrors() {
    }

    public TrxErrors(
           com.fal.ws.impl.TrxError[] transactionError) {
        this.transactionError = transactionError;
    }


    /**
     * Gets the transactionError value for this TrxErrors.
     * 
     * @return transactionError
     */
    public com.fal.ws.impl.TrxError[] getTransactionError() {
        return transactionError;
    }


    /**
     * Sets the transactionError value for this TrxErrors.
     * 
     * @param transactionError
     */
    public void setTransactionError(com.fal.ws.impl.TrxError[] transactionError) {
        this.transactionError = transactionError;
    }

    public com.fal.ws.impl.TrxError getTransactionError(int i) {
        return this.transactionError[i];
    }

    public void setTransactionError(int i, com.fal.ws.impl.TrxError _value) {
        this.transactionError[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrxErrors)) return false;
        TrxErrors other = (TrxErrors) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.transactionError==null && other.getTransactionError()==null) || 
             (this.transactionError!=null &&
              java.util.Arrays.equals(this.transactionError, other.getTransactionError())));
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
        if (getTransactionError() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTransactionError());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTransactionError(), i);
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
        new org.apache.axis.description.TypeDesc(TrxErrors.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "trxErrors"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transactionError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "trxError"));
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
