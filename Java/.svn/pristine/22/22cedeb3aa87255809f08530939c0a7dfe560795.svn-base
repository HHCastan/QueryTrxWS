/**
 * Ticket.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class Ticket  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.LineItems lineItems;

    private java.lang.String ticketDate;

    private java.lang.String ticketNumber;

    private com.fal.ws.impl.VouchersDto vouchers;

    public Ticket() {
    }

    public Ticket(
           com.fal.ws.impl.LineItems lineItems,
           java.lang.String ticketDate,
           java.lang.String ticketNumber,
           com.fal.ws.impl.VouchersDto vouchers) {
        this.lineItems = lineItems;
        this.ticketDate = ticketDate;
        this.ticketNumber = ticketNumber;
        this.vouchers = vouchers;
    }


    /**
     * Gets the lineItems value for this Ticket.
     * 
     * @return lineItems
     */
    public com.fal.ws.impl.LineItems getLineItems() {
        return lineItems;
    }


    /**
     * Sets the lineItems value for this Ticket.
     * 
     * @param lineItems
     */
    public void setLineItems(com.fal.ws.impl.LineItems lineItems) {
        this.lineItems = lineItems;
    }


    /**
     * Gets the ticketDate value for this Ticket.
     * 
     * @return ticketDate
     */
    public java.lang.String getTicketDate() {
        return ticketDate;
    }


    /**
     * Sets the ticketDate value for this Ticket.
     * 
     * @param ticketDate
     */
    public void setTicketDate(java.lang.String ticketDate) {
        this.ticketDate = ticketDate;
    }


    /**
     * Gets the ticketNumber value for this Ticket.
     * 
     * @return ticketNumber
     */
    public java.lang.String getTicketNumber() {
        return ticketNumber;
    }


    /**
     * Sets the ticketNumber value for this Ticket.
     * 
     * @param ticketNumber
     */
    public void setTicketNumber(java.lang.String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    /**
     * Gets the vouchers value for this Ticket.
     * 
     * @return vouchers
     */
    public com.fal.ws.impl.VouchersDto getVouchers() {
        return vouchers;
    }


    /**
     * Sets the vouchers value for this Ticket.
     * 
     * @param vouchers
     */
    public void setVouchers(com.fal.ws.impl.VouchersDto vouchers) {
        this.vouchers = vouchers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ticket)) return false;
        Ticket other = (Ticket) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.lineItems==null && other.getLineItems()==null) || 
             (this.lineItems!=null &&
              this.lineItems.equals(other.getLineItems()))) &&
            ((this.ticketDate==null && other.getTicketDate()==null) || 
             (this.ticketDate!=null &&
              this.ticketDate.equals(other.getTicketDate()))) &&
            ((this.ticketNumber==null && other.getTicketNumber()==null) || 
             (this.ticketNumber!=null &&
              this.ticketNumber.equals(other.getTicketNumber()))) &&
            ((this.vouchers==null && other.getVouchers()==null) || 
             (this.vouchers!=null &&
              this.vouchers.equals(other.getVouchers())));
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
        if (getLineItems() != null) {
            _hashCode += getLineItems().hashCode();
        }
        if (getTicketDate() != null) {
            _hashCode += getTicketDate().hashCode();
        }
        if (getTicketNumber() != null) {
            _hashCode += getTicketNumber().hashCode();
        }
        if (getVouchers() != null) {
            _hashCode += getVouchers().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ticket.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticket"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lineItems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lineItems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItems"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ticketNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ticketNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vouchers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vouchers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "vouchersDto"));
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
