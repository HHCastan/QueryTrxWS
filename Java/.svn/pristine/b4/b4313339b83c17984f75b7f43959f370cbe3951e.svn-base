/**
 * CustomerDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class CustomerDetails  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.Balances balances;

    private com.fal.ws.impl.CustomerName customerName;

    public CustomerDetails() {
    }

    public CustomerDetails(
           com.fal.ws.impl.Balances balances,
           com.fal.ws.impl.CustomerName customerName) {
        this.balances = balances;
        this.customerName = customerName;
    }


    /**
     * Gets the balances value for this CustomerDetails.
     * 
     * @return balances
     */
    public com.fal.ws.impl.Balances getBalances() {
        return balances;
    }


    /**
     * Sets the balances value for this CustomerDetails.
     * 
     * @param balances
     */
    public void setBalances(com.fal.ws.impl.Balances balances) {
        this.balances = balances;
    }


    /**
     * Gets the customerName value for this CustomerDetails.
     * 
     * @return customerName
     */
    public com.fal.ws.impl.CustomerName getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this CustomerDetails.
     * 
     * @param customerName
     */
    public void setCustomerName(com.fal.ws.impl.CustomerName customerName) {
        this.customerName = customerName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerDetails)) return false;
        CustomerDetails other = (CustomerDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.balances==null && other.getBalances()==null) || 
             (this.balances!=null &&
              this.balances.equals(other.getBalances()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName())));
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
        if (getBalances() != null) {
            _hashCode += getBalances().hashCode();
        }
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "customerDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("balances");
        elemField.setXmlName(new javax.xml.namespace.QName("", "balances"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "balances"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "customerName"));
        elemField.setMinOccurs(0);
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
