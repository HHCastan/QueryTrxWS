/**
 * ValidacionDatosClienteRes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.flamingo.www.contratos;

public class ValidacionDatosClienteRes  implements java.io.Serializable {
    private co.com.flamingo.www._2018._06.ValidacionDatosCliente cliente;

    private co.com.flamingo.www._2018._06.RespuestaMetodo respuestaMetodo;

    public ValidacionDatosClienteRes() {
    }

    public ValidacionDatosClienteRes(
           co.com.flamingo.www._2018._06.ValidacionDatosCliente cliente,
           co.com.flamingo.www._2018._06.RespuestaMetodo respuestaMetodo) {
           this.cliente = cliente;
           this.respuestaMetodo = respuestaMetodo;
    }


    /**
     * Gets the cliente value for this ValidacionDatosClienteRes.
     * 
     * @return cliente
     */
    public co.com.flamingo.www._2018._06.ValidacionDatosCliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this ValidacionDatosClienteRes.
     * 
     * @param cliente
     */
    public void setCliente(co.com.flamingo.www._2018._06.ValidacionDatosCliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the respuestaMetodo value for this ValidacionDatosClienteRes.
     * 
     * @return respuestaMetodo
     */
    public co.com.flamingo.www._2018._06.RespuestaMetodo getRespuestaMetodo() {
        return respuestaMetodo;
    }


    /**
     * Sets the respuestaMetodo value for this ValidacionDatosClienteRes.
     * 
     * @param respuestaMetodo
     */
    public void setRespuestaMetodo(co.com.flamingo.www._2018._06.RespuestaMetodo respuestaMetodo) {
        this.respuestaMetodo = respuestaMetodo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ValidacionDatosClienteRes)) return false;
        ValidacionDatosClienteRes other = (ValidacionDatosClienteRes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.respuestaMetodo==null && other.getRespuestaMetodo()==null) || 
             (this.respuestaMetodo!=null &&
              this.respuestaMetodo.equals(other.getRespuestaMetodo())));
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
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getRespuestaMetodo() != null) {
            _hashCode += getRespuestaMetodo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ValidacionDatosClienteRes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.flamingo.com.co/contratos", "ValidacionDatosClienteRes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.flamingo.com.co/contratos", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "ValidacionDatosCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaMetodo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.flamingo.com.co/contratos", "RespuestaMetodo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "RespuestaMetodo"));
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
