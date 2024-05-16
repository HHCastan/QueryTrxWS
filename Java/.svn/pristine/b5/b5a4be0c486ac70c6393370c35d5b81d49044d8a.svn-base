/**
 * LineItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class LineItem  extends com.fal.ws.impl.FalBaseDTO  implements java.io.Serializable {
    private java.lang.String familyCode;

    private int index;

    private boolean nonDiscountable;

    private java.lang.String productCode;

    private double productPrice;

    private int productType;

    private double quantity;

    private boolean rewardsExcluded;

    public LineItem() {
    }

    public LineItem(
           java.lang.String familyCode,
           int index,
           boolean nonDiscountable,
           java.lang.String productCode,
           double productPrice,
           int productType,
           double quantity,
           boolean rewardsExcluded) {
        this.familyCode = familyCode;
        this.index = index;
        this.nonDiscountable = nonDiscountable;
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productType = productType;
        this.quantity = quantity;
        this.rewardsExcluded = rewardsExcluded;
    }


    /**
     * Gets the familyCode value for this LineItem.
     * 
     * @return familyCode
     */
    public java.lang.String getFamilyCode() {
        return familyCode;
    }


    /**
     * Sets the familyCode value for this LineItem.
     * 
     * @param familyCode
     */
    public void setFamilyCode(java.lang.String familyCode) {
        this.familyCode = familyCode;
    }


    /**
     * Gets the index value for this LineItem.
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }


    /**
     * Sets the index value for this LineItem.
     * 
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }


    /**
     * Gets the nonDiscountable value for this LineItem.
     * 
     * @return nonDiscountable
     */
    public boolean isNonDiscountable() {
        return nonDiscountable;
    }


    /**
     * Sets the nonDiscountable value for this LineItem.
     * 
     * @param nonDiscountable
     */
    public void setNonDiscountable(boolean nonDiscountable) {
        this.nonDiscountable = nonDiscountable;
    }


    /**
     * Gets the productCode value for this LineItem.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this LineItem.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productPrice value for this LineItem.
     * 
     * @return productPrice
     */
    public double getProductPrice() {
        return productPrice;
    }


    /**
     * Sets the productPrice value for this LineItem.
     * 
     * @param productPrice
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    /**
     * Gets the productType value for this LineItem.
     * 
     * @return productType
     */
    public int getProductType() {
        return productType;
    }


    /**
     * Sets the productType value for this LineItem.
     * 
     * @param productType
     */
    public void setProductType(int productType) {
        this.productType = productType;
    }


    /**
     * Gets the quantity value for this LineItem.
     * 
     * @return quantity
     */
    public double getQuantity() {
        return quantity;
    }


    /**
     * Sets the quantity value for this LineItem.
     * 
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    /**
     * Gets the rewardsExcluded value for this LineItem.
     * 
     * @return rewardsExcluded
     */
    public boolean isRewardsExcluded() {
        return rewardsExcluded;
    }


    /**
     * Sets the rewardsExcluded value for this LineItem.
     * 
     * @param rewardsExcluded
     */
    public void setRewardsExcluded(boolean rewardsExcluded) {
        this.rewardsExcluded = rewardsExcluded;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LineItem)) return false;
        LineItem other = (LineItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.familyCode==null && other.getFamilyCode()==null) || 
             (this.familyCode!=null &&
              this.familyCode.equals(other.getFamilyCode()))) &&
            this.index == other.getIndex() &&
            this.nonDiscountable == other.isNonDiscountable() &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            this.productPrice == other.getProductPrice() &&
            this.productType == other.getProductType() &&
            this.quantity == other.getQuantity() &&
            this.rewardsExcluded == other.isRewardsExcluded();
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
        if (getFamilyCode() != null) {
            _hashCode += getFamilyCode().hashCode();
        }
        _hashCode += getIndex();
        _hashCode += (isNonDiscountable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        _hashCode += new Double(getProductPrice()).hashCode();
        _hashCode += getProductType();
        _hashCode += new Double(getQuantity()).hashCode();
        _hashCode += (isRewardsExcluded() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LineItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "familyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("index");
        elemField.setXmlName(new javax.xml.namespace.QName("", "index"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nonDiscountable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nonDiscountable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rewardsExcluded");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rewardsExcluded"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
