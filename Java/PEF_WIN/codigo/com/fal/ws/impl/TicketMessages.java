/**
 * TicketMessages.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class TicketMessages  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.TicketMessage[] ticketMessage;

    public TicketMessages() {
    }

    public TicketMessages(
           com.fal.ws.impl.TicketMessage[] ticketMessage) {
        this.ticketMessage = ticketMessage;
    }


    /**
     * Gets the ticketMessage value for this TicketMessages.
     * 
     * @return ticketMessage
     */
    public com.fal.ws.impl.TicketMessage[] getTicketMessage() {
        return ticketMessage;
    }


    /**
     * Sets the ticketMessage value for this TicketMessages.
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
        if (!(obj instanceof TicketMessages)) return false;
        TicketMessages other = (TicketMessages) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
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
        new org.apache.axis.description.TypeDesc(TicketMessages.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticketMessages"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
