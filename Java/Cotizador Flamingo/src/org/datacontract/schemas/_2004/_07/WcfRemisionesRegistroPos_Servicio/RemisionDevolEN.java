/**
 * RemisionDevolEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio;

public class RemisionDevolEN  implements java.io.Serializable {
    private java.lang.String calmacen;

    private java.lang.String cedula;

    private java.lang.String fechaReg;

    private java.lang.String hora;

    private org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos;

    private java.lang.String nombre;

    private java.lang.String terminal;

    private java.lang.String transaccion;

    public RemisionDevolEN() {
    }

    public RemisionDevolEN(
           java.lang.String calmacen,
           java.lang.String cedula,
           java.lang.String fechaReg,
           java.lang.String hora,
           org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos,
           java.lang.String nombre,
           java.lang.String terminal,
           java.lang.String transaccion) {
           this.calmacen = calmacen;
           this.cedula = cedula;
           this.fechaReg = fechaReg;
           this.hora = hora;
           this.listaArticulos = listaArticulos;
           this.nombre = nombre;
           this.terminal = terminal;
           this.transaccion = transaccion;
    }


    /**
     * Gets the calmacen value for this RemisionDevolEN.
     * 
     * @return calmacen
     */
    public java.lang.String getCalmacen() {
        return calmacen;
    }


    /**
     * Sets the calmacen value for this RemisionDevolEN.
     * 
     * @param calmacen
     */
    public void setCalmacen(java.lang.String calmacen) {
        this.calmacen = calmacen;
    }


    /**
     * Gets the cedula value for this RemisionDevolEN.
     * 
     * @return cedula
     */
    public java.lang.String getCedula() {
        return cedula;
    }


    /**
     * Sets the cedula value for this RemisionDevolEN.
     * 
     * @param cedula
     */
    public void setCedula(java.lang.String cedula) {
        this.cedula = cedula;
    }


    /**
     * Gets the fechaReg value for this RemisionDevolEN.
     * 
     * @return fechaReg
     */
    public java.lang.String getFechaReg() {
        return fechaReg;
    }


    /**
     * Sets the fechaReg value for this RemisionDevolEN.
     * 
     * @param fechaReg
     */
    public void setFechaReg(java.lang.String fechaReg) {
        this.fechaReg = fechaReg;
    }


    /**
     * Gets the hora value for this RemisionDevolEN.
     * 
     * @return hora
     */
    public java.lang.String getHora() {
        return hora;
    }


    /**
     * Sets the hora value for this RemisionDevolEN.
     * 
     * @param hora
     */
    public void setHora(java.lang.String hora) {
        this.hora = hora;
    }


    /**
     * Gets the listaArticulos value for this RemisionDevolEN.
     * 
     * @return listaArticulos
     */
    public org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] getListaArticulos() {
        return listaArticulos;
    }


    /**
     * Sets the listaArticulos value for this RemisionDevolEN.
     * 
     * @param listaArticulos
     */
    public void setListaArticulos(org.datacontract.schemas._2004._07.WcfRemisionesRegistroPos_Servicio.ArticuloRem[] listaArticulos) {
        this.listaArticulos = listaArticulos;
    }


    /**
     * Gets the nombre value for this RemisionDevolEN.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this RemisionDevolEN.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the terminal value for this RemisionDevolEN.
     * 
     * @return terminal
     */
    public java.lang.String getTerminal() {
        return terminal;
    }


    /**
     * Sets the terminal value for this RemisionDevolEN.
     * 
     * @param terminal
     */
    public void setTerminal(java.lang.String terminal) {
        this.terminal = terminal;
    }


    /**
     * Gets the transaccion value for this RemisionDevolEN.
     * 
     * @return transaccion
     */
    public java.lang.String getTransaccion() {
        return transaccion;
    }


    /**
     * Sets the transaccion value for this RemisionDevolEN.
     * 
     * @param transaccion
     */
    public void setTransaccion(java.lang.String transaccion) {
        this.transaccion = transaccion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemisionDevolEN)) return false;
        RemisionDevolEN other = (RemisionDevolEN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calmacen==null && other.getCalmacen()==null) || 
             (this.calmacen!=null &&
              this.calmacen.equals(other.getCalmacen()))) &&
            ((this.cedula==null && other.getCedula()==null) || 
             (this.cedula!=null &&
              this.cedula.equals(other.getCedula()))) &&
            ((this.fechaReg==null && other.getFechaReg()==null) || 
             (this.fechaReg!=null &&
              this.fechaReg.equals(other.getFechaReg()))) &&
            ((this.hora==null && other.getHora()==null) || 
             (this.hora!=null &&
              this.hora.equals(other.getHora()))) &&
            ((this.listaArticulos==null && other.getListaArticulos()==null) || 
             (this.listaArticulos!=null &&
              java.util.Arrays.equals(this.listaArticulos, other.getListaArticulos()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.terminal==null && other.getTerminal()==null) || 
             (this.terminal!=null &&
              this.terminal.equals(other.getTerminal()))) &&
            ((this.transaccion==null && other.getTransaccion()==null) || 
             (this.transaccion!=null &&
              this.transaccion.equals(other.getTransaccion())));
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
        if (getCalmacen() != null) {
            _hashCode += getCalmacen().hashCode();
        }
        if (getCedula() != null) {
            _hashCode += getCedula().hashCode();
        }
        if (getFechaReg() != null) {
            _hashCode += getFechaReg().hashCode();
        }
        if (getHora() != null) {
            _hashCode += getHora().hashCode();
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getTerminal() != null) {
            _hashCode += getTerminal().hashCode();
        }
        if (getTransaccion() != null) {
            _hashCode += getTransaccion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RemisionDevolEN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "RemisionDevolEN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calmacen");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Calmacen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cedula");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Cedula"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaReg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "FechaReg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Hora"));
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
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("terminal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Terminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WcfRemisionesRegistroPos.Servicio", "Transaccion"));
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
