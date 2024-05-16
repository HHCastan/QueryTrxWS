/**
 * AccountBasicInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package omnia.mefia.com;

public class AccountBasicInfo  implements java.io.Serializable {
    private java.math.BigDecimal cupoDisponible;

    private java.lang.String numeroCuenta;

    private java.math.BigDecimal pagoMinimo;

    private java.math.BigDecimal pagoTotal;

    private java.lang.String productoCliente;

    public AccountBasicInfo() {
    }

    public AccountBasicInfo(
           java.math.BigDecimal cupoDisponible,
           java.lang.String numeroCuenta,
           java.math.BigDecimal pagoMinimo,
           java.math.BigDecimal pagoTotal,
           java.lang.String productoCliente) {
           this.cupoDisponible = cupoDisponible;
           this.numeroCuenta = numeroCuenta;
           this.pagoMinimo = pagoMinimo;
           this.pagoTotal = pagoTotal;
           this.productoCliente = productoCliente;
    }


    /**
     * Gets the cupoDisponible value for this AccountBasicInfo.
     * 
     * @return cupoDisponible
     */
    public java.math.BigDecimal getCupoDisponible() {
        return cupoDisponible;
    }


    /**
     * Sets the cupoDisponible value for this AccountBasicInfo.
     * 
     * @param cupoDisponible
     */
    public void setCupoDisponible(java.math.BigDecimal cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }


    /**
     * Gets the numeroCuenta value for this AccountBasicInfo.
     * 
     * @return numeroCuenta
     */
    public java.lang.String getNumeroCuenta() {
        return numeroCuenta;
    }


    /**
     * Sets the numeroCuenta value for this AccountBasicInfo.
     * 
     * @param numeroCuenta
     */
    public void setNumeroCuenta(java.lang.String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    /**
     * Gets the pagoMinimo value for this AccountBasicInfo.
     * 
     * @return pagoMinimo
     */
    public java.math.BigDecimal getPagoMinimo() {
        return pagoMinimo;
    }


    /**
     * Sets the pagoMinimo value for this AccountBasicInfo.
     * 
     * @param pagoMinimo
     */
    public void setPagoMinimo(java.math.BigDecimal pagoMinimo) {
        this.pagoMinimo = pagoMinimo;
    }


    /**
     * Gets the pagoTotal value for this AccountBasicInfo.
     * 
     * @return pagoTotal
     */
    public java.math.BigDecimal getPagoTotal() {
        return pagoTotal;
    }


    /**
     * Sets the pagoTotal value for this AccountBasicInfo.
     * 
     * @param pagoTotal
     */
    public void setPagoTotal(java.math.BigDecimal pagoTotal) {
        this.pagoTotal = pagoTotal;
    }


    /**
     * Gets the productoCliente value for this AccountBasicInfo.
     * 
     * @return productoCliente
     */
    public java.lang.String getProductoCliente() {
        return productoCliente;
    }


    /**
     * Sets the productoCliente value for this AccountBasicInfo.
     * 
     * @param productoCliente
     */
    public void setProductoCliente(java.lang.String productoCliente) {
        this.productoCliente = productoCliente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AccountBasicInfo)) return false;
        AccountBasicInfo other = (AccountBasicInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cupoDisponible==null && other.getCupoDisponible()==null) || 
             (this.cupoDisponible!=null &&
              this.cupoDisponible.equals(other.getCupoDisponible()))) &&
            ((this.numeroCuenta==null && other.getNumeroCuenta()==null) || 
             (this.numeroCuenta!=null &&
              this.numeroCuenta.equals(other.getNumeroCuenta()))) &&
            ((this.pagoMinimo==null && other.getPagoMinimo()==null) || 
             (this.pagoMinimo!=null &&
              this.pagoMinimo.equals(other.getPagoMinimo()))) &&
            ((this.pagoTotal==null && other.getPagoTotal()==null) || 
             (this.pagoTotal!=null &&
              this.pagoTotal.equals(other.getPagoTotal()))) &&
            ((this.productoCliente==null && other.getProductoCliente()==null) || 
             (this.productoCliente!=null &&
              this.productoCliente.equals(other.getProductoCliente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCupoDisponible() != null) {
            _hashCode += getCupoDisponible().hashCode();
        }
        if (getNumeroCuenta() != null) {
            _hashCode += getNumeroCuenta().hashCode();
        }
        if (getPagoMinimo() != null) {
            _hashCode += getPagoMinimo().hashCode();
        }
        if (getPagoTotal() != null) {
            _hashCode += getPagoTotal().hashCode();
        }
        if (getProductoCliente() != null) {
            _hashCode += getProductoCliente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountBasicInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://com.mefia.omnia", "accountBasicInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cupoDisponible");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cupoDisponible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroCuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagoMinimo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pagoMinimo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pagoTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pagoTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productoCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productoCliente"));
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
