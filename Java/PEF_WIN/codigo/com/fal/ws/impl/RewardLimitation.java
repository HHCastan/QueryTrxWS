/**
 * RewardLimitation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class RewardLimitation  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private double limit;

    private java.lang.String rewardID;

    public RewardLimitation() {
    }

    public RewardLimitation(
           double limit,
           java.lang.String rewardID) {
        this.limit = limit;
        this.rewardID = rewardID;
    }


    /**
     * Gets the limit value for this RewardLimitation.
     * 
     * @return limit
     */
    public double getLimit() {
        return limit;
    }


    /**
     * Sets the limit value for this RewardLimitation.
     * 
     * @param limit
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }


    /**
     * Gets the rewardID value for this RewardLimitation.
     * 
     * @return rewardID
     */
    public java.lang.String getRewardID() {
        return rewardID;
    }


    /**
     * Sets the rewardID value for this RewardLimitation.
     * 
     * @param rewardID
     */
    public void setRewardID(java.lang.String rewardID) {
        this.rewardID = rewardID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RewardLimitation)) return false;
        RewardLimitation other = (RewardLimitation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.limit == other.getLimit() &&
            ((this.rewardID==null && other.getRewardID()==null) || 
             (this.rewardID!=null &&
              this.rewardID.equals(other.getRewardID())));
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
        _hashCode += new Double(getLimit()).hashCode();
        if (getRewardID() != null) {
            _hashCode += getRewardID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RewardLimitation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardLimitation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
