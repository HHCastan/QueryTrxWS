/*
 * XML Type:  ConsultaClienteEnrolamientoArchivo
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML ConsultaClienteEnrolamientoArchivo(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class ConsultaClienteEnrolamientoArchivoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo
{
    private static final long serialVersionUID = 1L;
    
    public ConsultaClienteEnrolamientoArchivoImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TIPOARCHIVOID$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "TIPO_ARCHIVO_ID");
    private static final javax.xml.namespace.QName TIPOARCHIVONOMBRE$2 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "TIPO_ARCHIVO_NOMBRE");
    private static final javax.xml.namespace.QName URL$4 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "URL");
    private static final javax.xml.namespace.QName ARCHIVO$6 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ARCHIVO");
    
    
    /**
     * Gets the "TIPO_ARCHIVO_ID" element
     */
    public int getTIPOARCHIVOID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOARCHIVOID$0, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "TIPO_ARCHIVO_ID" element
     */
    public org.apache.xmlbeans.XmlInt xgetTIPOARCHIVOID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIPOARCHIVOID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "TIPO_ARCHIVO_ID" element
     */
    public void setTIPOARCHIVOID(int tipoarchivoid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOARCHIVOID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIPOARCHIVOID$0);
            }
            target.setIntValue(tipoarchivoid);
        }
    }
    
    /**
     * Sets (as xml) the "TIPO_ARCHIVO_ID" element
     */
    public void xsetTIPOARCHIVOID(org.apache.xmlbeans.XmlInt tipoarchivoid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(TIPOARCHIVOID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(TIPOARCHIVOID$0);
            }
            target.set(tipoarchivoid);
        }
    }
    
    /**
     * Gets the "TIPO_ARCHIVO_NOMBRE" element
     */
    public java.lang.String getTIPOARCHIVONOMBRE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOARCHIVONOMBRE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TIPO_ARCHIVO_NOMBRE" element
     */
    public org.apache.xmlbeans.XmlString xgetTIPOARCHIVONOMBRE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPOARCHIVONOMBRE$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "TIPO_ARCHIVO_NOMBRE" element
     */
    public boolean isSetTIPOARCHIVONOMBRE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIPOARCHIVONOMBRE$2) != 0;
        }
    }
    
    /**
     * Sets the "TIPO_ARCHIVO_NOMBRE" element
     */
    public void setTIPOARCHIVONOMBRE(java.lang.String tipoarchivonombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPOARCHIVONOMBRE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIPOARCHIVONOMBRE$2);
            }
            target.setStringValue(tipoarchivonombre);
        }
    }
    
    /**
     * Sets (as xml) the "TIPO_ARCHIVO_NOMBRE" element
     */
    public void xsetTIPOARCHIVONOMBRE(org.apache.xmlbeans.XmlString tipoarchivonombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPOARCHIVONOMBRE$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TIPOARCHIVONOMBRE$2);
            }
            target.set(tipoarchivonombre);
        }
    }
    
    /**
     * Unsets the "TIPO_ARCHIVO_NOMBRE" element
     */
    public void unsetTIPOARCHIVONOMBRE()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIPOARCHIVONOMBRE$2, 0);
        }
    }
    
    /**
     * Gets the "URL" element
     */
    public java.lang.String getURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URL$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "URL" element
     */
    public org.apache.xmlbeans.XmlString xgetURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(URL$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "URL" element
     */
    public boolean isSetURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(URL$4) != 0;
        }
    }
    
    /**
     * Sets the "URL" element
     */
    public void setURL(java.lang.String url)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URL$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(URL$4);
            }
            target.setStringValue(url);
        }
    }
    
    /**
     * Sets (as xml) the "URL" element
     */
    public void xsetURL(org.apache.xmlbeans.XmlString url)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(URL$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(URL$4);
            }
            target.set(url);
        }
    }
    
    /**
     * Unsets the "URL" element
     */
    public void unsetURL()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(URL$4, 0);
        }
    }
    
    /**
     * Gets the "ARCHIVO" element
     */
    public byte[] getARCHIVO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARCHIVO$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getByteArrayValue();
        }
    }
    
    /**
     * Gets (as xml) the "ARCHIVO" element
     */
    public org.apache.xmlbeans.XmlBase64Binary xgetARCHIVO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARCHIVO$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "ARCHIVO" element
     */
    public boolean isSetARCHIVO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARCHIVO$6) != 0;
        }
    }
    
    /**
     * Sets the "ARCHIVO" element
     */
    public void setARCHIVO(byte[] archivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARCHIVO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARCHIVO$6);
            }
            target.setByteArrayValue(archivo);
        }
    }
    
    /**
     * Sets (as xml) the "ARCHIVO" element
     */
    public void xsetARCHIVO(org.apache.xmlbeans.XmlBase64Binary archivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBase64Binary target = null;
            target = (org.apache.xmlbeans.XmlBase64Binary)get_store().find_element_user(ARCHIVO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBase64Binary)get_store().add_element_user(ARCHIVO$6);
            }
            target.set(archivo);
        }
    }
    
    /**
     * Unsets the "ARCHIVO" element
     */
    public void unsetARCHIVO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARCHIVO$6, 0);
        }
    }
}
