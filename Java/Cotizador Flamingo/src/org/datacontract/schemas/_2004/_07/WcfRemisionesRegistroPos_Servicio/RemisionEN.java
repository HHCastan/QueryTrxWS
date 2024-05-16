/**
 * RemisionEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio;

public class RemisionEN  implements java.io.Serializable {
    private java.lang.String cedula;

    private java.lang.String documentoMp;

    private org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos;

    private java.lang.String medioPago;

    private java.lang.Integer mpAutomatico;

    private java.lang.String nombre;

    private java.lang.Integer nroCuotas;

    private java.math.BigDecimal valorMax;

    public RemisionEN() {
    }

    public RemisionEN(
           java.lang.String cedula,
           java.lang.String documentoMp,
           org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos,
           java.lang.String medioPago,
           java.lang.Integer mpAutomatico,
           java.lang.String nombre,
           java.lang.Integer nroCuotas,
           java.math.BigDecimal valorMax) {
           this.cedula = cedula;
           this.documentoMp = documentoMp;
           this.listaArticulos = listaArticulos;
           this.medioPago = medioPago;
           this.mpAutomatico = mpAutomatico;
           this.nombre = nombre;
           this.nroCuotas = nroCuotas;
           this.valorMax = valorMax;
    }


    /**
     * Gets the cedula value for this RemisionEN.
     * 
     * @return cedula
     */
    public java.lang.String getCedula() {
        return cedula;
    }


    /**
     * Sets the cedula value for this RemisionEN.
     * 
     * @param cedula
     */
    public void setCedula(java.lang.String cedula) {
        this.cedula = cedula;
    }


    /**
     * Gets the documentoMp value for this RemisionEN.
     * 
     * @return documentoMp
     */
    public java.lang.String getDocumentoMp() {
        return documentoMp;
    }


    /**
     * Sets the documentoMp value for this RemisionEN.
     * 
     * @param documentoMp
     */
    public void setDocumentoMp(java.lang.String documentoMp) {
        this.documentoMp = documentoMp;
    }


    /**
     * Gets the listaArticulos value for this RemisionEN.
     * 
     * @return listaArticulos
     */
    public org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] getListaArticulos() {
        return listaArticulos;
    }


    /**
     * Sets the listaArticulos value for this RemisionEN.
     * 
     * @param listaArticulos
     */
    public void setListaArticulos(org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos) {
        this.listaArticulos = listaArticulos;
    }


    /**
     * Gets the medioPago value for this RemisionEN.
     * 
     * @return medioPago
     */
    public java.lang.String getMedioPago() {
        return medioPago;
    }


    /**
     * Sets the medioPago value for this RemisionEN.
     * 
     * @param medioPago
     */
    public void setMedioPago(java.lang.String medioPago) {
        this.medioPago = medioPago;
    }


    /**
     * Gets the mpAutomatico value for this RemisionEN.
     * 
     * @return mpAutomatico
     */
    public java.lang.Integer getMpAutomatico() {
        return mpAutomatico;
    }


    /**
     * Sets the mpAutomatico value for this RemisionEN.
     * 
     * @param mpAutomatico
     */
    public void setMpAutomatico(java.lang.Integer mpAutomatico) {
        this.mpAutomatico = mpAutomatico;
    }


    /**
     * Gets the nombre value for this RemisionEN.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this RemisionEN.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nroCuotas value for this RemisionEN.
     * 
     * @return nroCuotas
     */
    public java.lang.Integer getNroCuotas() {
        return nroCuotas;
    }


    /**
     * Sets the nroCuotas value for this RemisionEN.
     * 
     * @param nroCuotas
     */
    public void setNroCuotas(java.lang.Integer nroCuotas) {
        this.nroCuotas = nroCuotas;
    }


    /**
     * Gets the valorMax value for this RemisionEN.
     * 
     * @return valorMax
     */
    public java.math.BigDecimal getValorMax() {
        return valorMax;
    }


    /**
     * Sets the valorMax value for this RemisionEN.
     * 
     * @param valorMax
     */
    public void setValorMax(java.math.BigDecimal valorMax) {
        this.valorMax = valorMax;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemisionEN)) return false;
        RemisionEN other = (RemisionEN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cedula==null && other.getCedula()==null) || 
             (this.cedula!=null &&
              this.cedula.equals(other.getCedula()))) &&
            ((this.documentoMp==null && other.getDocumentoMp()==null) || 
             (this.documentoMp!=null &&
              this.documentoMp.equals(other.getDocumentoMp()))) &&
            ((this.listaArticulos==null && other.getListaArticulos()==null) || 
             (this.listaArticulos!=null &&
              java.util.Arrays.equals(this.listaArticulos, other.getListaArticulos()))) &&
            ((this.medioPago==null && other.getMedioPago()==null) || 
             (this.medioPago!=null &&
              this.medioPago.equals(other.getMedioPago()))) &&
            ((this.mpAutomatico==null && other.getMpAutomatico()==null) || 
             (this.mpAutomatico!=null &&
              this.mpAutomatico.equals(other.getMpAutomatico()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nroCuotas==null && other.getNroCuotas()==null) || 
             (this.nroCuotas!=null &&
              this.nroCuotas.equals(other.getNroCuotas()))) &&
            ((this.valorMax==null && other.getValorMax()==null) || 
             (this.valorMax!=null &&
              this.valorMax.equals(other.getValorMax())));
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
        if (getCedula() != null) {
            _hashCode += getCedula().hashCode();
        }
        if (getDocumentoMp() != null) {
            _hashCode += getDocumentoMp().hashCode();
        }
        if (getListaArticulos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaArticulos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaArticulos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMedioPago() != null) {
            _hashCode += getMedioPago().hashCode();
        }
        if (getMpAutomatico() != null) {
            _hashCode += getMpAutomatico().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNroCuotas() != null) {
            _hashCode += getNroCuotas().hashCode();
        }
        if (getValorMax() != null) {
            _hashCode += getValorMax().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RemisionEN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "RemisionEN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cedula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Cedula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentoMp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "DocumentoMp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaArticulos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "ListaArticulos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "ArticuloRem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "ArticuloRem"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medioPago");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "MedioPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mpAutomatico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "MpAutomatico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nroCuotas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "NroCuotas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorMax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "ValorMax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
