/**
 * Rewards.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class Rewards  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private com.fal.ws.impl.Reward[] reward;

    public Rewards() {
    }

    public Rewards(
           com.fal.ws.impl.Reward[] reward) {
        this.reward = reward;
    }


    /**
     * Gets the reward value for this Rewards.
     * 
     * @return reward
     */
    public com.fal.ws.impl.Reward[] getReward() {
        return reward;
    }


    /**
     * Sets the reward value for this Rewards.
     * 
     * @param reward
     */
    public void setReward(com.fal.ws.impl.Reward[] reward) {
        this.reward = reward;
    }

    public com.fal.ws.impl.Reward getReward(int i) {
        return this.reward[i];
    }

    public void setReward(int i, com.fal.ws.impl.Reward _value) {
        this.reward[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Rewards)) return false;
        Rewards other = (Rewards) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.reward==null && other.getReward()==null) || 
             (this.reward!=null &&
              java.util.Arrays.equals(this.reward, other.getReward())));
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
        if (getReward() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getReward());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getReward(), i);
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
        new org.apache.axis.description.TypeDesc(Rewards.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewards"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reward");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reward"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "reward"));
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
