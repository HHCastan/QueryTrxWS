/**
 * BrandDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class BrandDTO  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String code;

    private java.lang.String description;

    private java.lang.Boolean isHomeBrand;

    private java.lang.Integer brandCategory;

    public BrandDTO() {
    }

    public BrandDTO(
           java.lang.String code,
           java.lang.String description,
           java.lang.Boolean isHomeBrand,
           java.lang.Integer brandCategory) {
        this.code = code;
        this.description = description;
        this.isHomeBrand = isHomeBrand;
        this.brandCategory = brandCategory;
    }


    /**
     * Gets the code value for this BrandDTO.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this BrandDTO.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the description value for this BrandDTO.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this BrandDTO.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the isHomeBrand value for this BrandDTO.
     * 
     * @return isHomeBrand
     */
    public java.lang.Boolean getIsHomeBrand() {
        return isHomeBrand;
    }


    /**
     * Sets the isHomeBrand value for this BrandDTO.
     * 
     * @param isHomeBrand
     */
    public void setIsHomeBrand(java.lang.Boolean isHomeBrand) {
        this.isHomeBrand = isHomeBrand;
    }


    /**
     * Gets the brandCategory value for this BrandDTO.
     * 
     * @return brandCategory
     */
    public java.lang.Integer getBrandCategory() {
        return brandCategory;
    }


    /**
     * Sets the brandCategory value for this BrandDTO.
     * 
     * @param brandCategory
     */
    public void setBrandCategory(java.lang.Integer brandCategory) {
        this.brandCategory = brandCategory;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BrandDTO)) return false;
        BrandDTO other = (BrandDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.isHomeBrand==null && other.getIsHomeBrand()==null) || 
             (this.isHomeBrand!=null &&
              this.isHomeBrand.equals(other.getIsHomeBrand()))) &&
            ((this.brandCategory==null && other.getBrandCategory()==null) || 
             (this.brandCategory!=null &&
              this.brandCategory.equals(other.getBrandCategory())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getIsHomeBrand() != null) {
            _hashCode += getIsHomeBrand().hashCode();
        }
        if (getBrandCategory() != null) {
            _hashCode += getBrandCategory().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BrandDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "brandDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isHomeBrand");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isHomeBrand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("brandCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "brandCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
