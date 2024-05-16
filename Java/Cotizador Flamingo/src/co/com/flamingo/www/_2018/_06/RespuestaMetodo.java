/**
 * RespuestaMetodo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.flamingo.www._2018._06;

public class RespuestaMetodo  implements java.io.Serializable {
    private java.math.BigDecimal idRetorno;

    private java.lang.String mensajeRetorno;

    public RespuestaMetodo() {
    }

    public RespuestaMetodo(
           java.math.BigDecimal idRetorno,
           java.lang.String mensajeRetorno) {
           this.idRetorno = idRetorno;
           this.mensajeRetorno = mensajeRetorno;
    }


    /**
     * Gets the idRetorno value for this RespuestaMetodo.
     * 
     * @return idRetorno
     */
    public java.math.BigDecimal getIdRetorno() {
        return idRetorno;
    }


    /**
     * Sets the idRetorno value for this RespuestaMetodo.
     * 
     * @param idRetorno
     */
    public void setIdRetorno(java.math.BigDecimal idRetorno) {
        this.idRetorno = idRetorno;
    }


    /**
     * Gets the mensajeRetorno value for this RespuestaMetodo.
     * 
     * @return mensajeRetorno
     */
    public java.lang.String getMensajeRetorno() {
        return mensajeRetorno;
    }


    /**
     * Sets the mensajeRetorno value for this RespuestaMetodo.
     * 
     * @param mensajeRetorno
     */
    public void setMensajeRetorno(java.lang.String mensajeRetorno) {
        this.mensajeRetorno = mensajeRetorno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaMetodo)) return false;
        RespuestaMetodo other = (RespuestaMetodo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idRetorno==null && other.getIdRetorno()==null) || 
             (this.idRetorno!=null &&
              this.idRetorno.equals(other.getIdRetorno()))) &&
            ((this.mensajeRetorno==null && other.getMensajeRetorno()==null) || 
             (this.mensajeRetorno!=null &&
              this.mensajeRetorno.equals(other.getMensajeRetorno())));
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
        if (getIdRetorno() != null) {
            _hashCode += getIdRetorno().hashCode();
        }
        if (getMensajeRetorno() != null) {
            _hashCode += getMensajeRetorno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaMetodo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "RespuestaMetodo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "IdRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensajeRetorno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "MensajeRetorno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
