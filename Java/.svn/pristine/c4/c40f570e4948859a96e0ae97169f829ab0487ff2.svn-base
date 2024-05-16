/**
 * CustomerInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package omnia.mefia.com;

public class CustomerInfoResponse  implements java.io.Serializable {
    private omnia.mefia.com.AccountBasicInfo[] informacionCuentas;

    private java.lang.String respuesta;

    public CustomerInfoResponse() {
    }

    public CustomerInfoResponse(
           omnia.mefia.com.AccountBasicInfo[] informacionCuentas,
           java.lang.String respuesta) {
           this.informacionCuentas = informacionCuentas;
           this.respuesta = respuesta;
    }


    /**
     * Gets the informacionCuentas value for this CustomerInfoResponse.
     * 
     * @return informacionCuentas
     */
    public omnia.mefia.com.AccountBasicInfo[] getInformacionCuentas() {
        return informacionCuentas;
    }


    /**
     * Sets the informacionCuentas value for this CustomerInfoResponse.
     * 
     * @param informacionCuentas
     */
    public void setInformacionCuentas(omnia.mefia.com.AccountBasicInfo[] informacionCuentas) {
        this.informacionCuentas = informacionCuentas;
    }


    /**
     * Gets the respuesta value for this CustomerInfoResponse.
     * 
     * @return respuesta
     */
    public java.lang.String getRespuesta() {
        return respuesta;
    }


    /**
     * Sets the respuesta value for this CustomerInfoResponse.
     * 
     * @param respuesta
     */
    public void setRespuesta(java.lang.String respuesta) {
        this.respuesta = respuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerInfoResponse)) return false;
        CustomerInfoResponse other = (CustomerInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.informacionCuentas==null && other.getInformacionCuentas()==null) || 
             (this.informacionCuentas!=null &&
              java.util.Arrays.equals(this.informacionCuentas, other.getInformacionCuentas()))) &&
            ((this.respuesta==null && other.getRespuesta()==null) || 
             (this.respuesta!=null &&
              this.respuesta.equals(other.getRespuesta())));
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
        if (getInformacionCuentas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInformacionCuentas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInformacionCuentas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRespuesta() != null) {
            _hashCode += getRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://com.mefia.omnia", "customerInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionCuentas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "informacionCuentas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://com.mefia.omnia", "accountBasicInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "cuenta"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuesta"));
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
