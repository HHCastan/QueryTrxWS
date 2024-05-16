/**
 * RewardLimitations.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class RewardLimitations  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.RewardLimitation[] rewardLimitation;

    public RewardLimitations() {
    }

    public RewardLimitations(
           com.fal.ws.impl.RewardLimitation[] rewardLimitation) {
        this.rewardLimitation = rewardLimitation;
    }


    /**
     * Gets the rewardLimitation value for this RewardLimitations.
     * 
     * @return rewardLimitation
     */
    public com.fal.ws.impl.RewardLimitation[] getRewardLimitation() {
        return rewardLimitation;
    }


    /**
     * Sets the rewardLimitation value for this RewardLimitations.
     * 
     * @param rewardLimitation
     */
    public void setRewardLimitation(com.fal.ws.impl.RewardLimitation[] rewardLimitation) {
        this.rewardLimitation = rewardLimitation;
    }

    public com.fal.ws.impl.RewardLimitation getRewardLimitation(int i) {
        return this.rewardLimitation[i];
    }

    public void setRewardLimitation(int i, com.fal.ws.impl.RewardLimitation _value) {
        this.rewardLimitation[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RewardLimitations)) return false;
        RewardLimitations other = (RewardLimitations) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.rewardLimitation==null && other.getRewardLimitation()==null) || 
             (this.rewardLimitation!=null &&
              java.util.Arrays.equals(this.rewardLimitation, other.getRewardLimitation())));
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
        if (getRewardLimitation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRewardLimitation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRewardLimitation(), i);
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
        new org.apache.axis.description.TypeDesc(RewardLimitations.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardLimitations"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardLimitation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardLimitation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardLimitation"));
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
