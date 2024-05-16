/**
 * RewardMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class RewardMessage  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String customerMessage;

    private java.lang.String cashierMessage;

    private com.fal.ws.impl.TicketMessage[] ticketMessage;

    public RewardMessage() {
    }

    public RewardMessage(
           java.lang.String customerMessage,
           java.lang.String cashierMessage,
           com.fal.ws.impl.TicketMessage[] ticketMessage) {
        this.customerMessage = customerMessage;
        this.cashierMessage = cashierMessage;
        this.ticketMessage = ticketMessage;
    }


    /**
     * Gets the customerMessage value for this RewardMessage.
     * 
     * @return customerMessage
     */
    public java.lang.String getCustomerMessage() {
        return customerMessage;
    }


    /**
     * Sets the customerMessage value for this RewardMessage.
     * 
     * @param customerMessage
     */
    public void setCustomerMessage(java.lang.String customerMessage) {
        this.customerMessage = customerMessage;
    }


    /**
     * Gets the cashierMessage value for this RewardMessage.
     * 
     * @return cashierMessage
     */
    public java.lang.String getCashierMessage() {
        return cashierMessage;
    }


    /**
     * Sets the cashierMessage value for this RewardMessage.
     * 
     * @param cashierMessage
     */
    public void setCashierMessage(java.lang.String cashierMessage) {
        this.cashierMessage = cashierMessage;
    }


    /**
     * Gets the ticketMessage value for this RewardMessage.
     * 
     * @return ticketMessage
     */
    public com.fal.ws.impl.TicketMessage[] getTicketMessage() {
        return ticketMessage;
    }


    /**
     * Sets the ticketMessage value for this RewardMessage.
     * 
     * @param ticketMessage
     */
    public void setTicketMessage(com.fal.ws.impl.TicketMessage[] ticketMessage) {
        this.ticketMessage = ticketMessage;
    }

    public com.fal.ws.impl.TicketMessage getTicketMessage(int i) {
        return this.ticketMessage[i];
    }

    public void setTicketMessage(int i, com.fal.ws.impl.TicketMessage _value) {
        this.ticketMessage[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RewardMessage)) return false;
        RewardMessage other = (RewardMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.customerMessage==null && other.getCustomerMessage()==null) || 
             (this.customerMessage!=null &&
              this.customerMessage.equals(other.getCustomerMessage()))) &&
            ((this.cashierMessage==null && other.getCashierMessage()==null) || 
             (this.cashierMessage!=null &&
              this.cashierMessage.equals(other.getCashierMessage()))) &&
            ((this.ticketMessage==null && other.getTicketMessage()==null) || 
             (this.ticketMessage!=null &&
              java.util.Arrays.equals(this.ticketMessage, other.getTicketMessage())));
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
        if (getCustomerMessage() != null) {
            _hashCode += getCustomerMessage().hashCode();
        }
        if (getCashierMessage() != null) {
            _hashCode += getCashierMessage().hashCode();
        }
        if (getTicketMessage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTicketMessage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTicketMessage(), i);
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
        new org.apache.axis.description.TypeDesc(RewardMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardMessage"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customerMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cashierMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cashierMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticketMessage"));
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
