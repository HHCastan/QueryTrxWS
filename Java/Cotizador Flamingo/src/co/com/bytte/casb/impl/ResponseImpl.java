/*
 * XML Type:  Response
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.Response
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML Response(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class ResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.Response
{
    private static final long serialVersionUID = 1L;
    
    public ResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPERACIONEXITOSA$0 = 
        new javax.xml.namespace.QName("", "OperacionExitosa");
    private static final javax.xml.namespace.QName MENSAJE$2 = 
        new javax.xml.namespace.QName("", "Mensaje");
    
    
    /**
     * Gets the "OperacionExitosa" attribute
     */
    public boolean getOperacionExitosa()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OPERACIONEXITOSA$0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "OperacionExitosa" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetOperacionExitosa()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(OPERACIONEXITOSA$0);
            return target;
        }
    }
    
    /**
     * Sets the "OperacionExitosa" attribute
     */
    public void setOperacionExitosa(boolean operacionExitosa)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(OPERACIONEXITOSA$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(OPERACIONEXITOSA$0);
            }
            target.setBooleanValue(operacionExitosa);
        }
    }
    
    /**
     * Sets (as xml) the "OperacionExitosa" attribute
     */
    public void xsetOperacionExitosa(org.apache.xmlbeans.XmlBoolean operacionExitosa)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(OPERACIONEXITOSA$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(OPERACIONEXITOSA$0);
            }
            target.set(operacionExitosa);
        }
    }
    
    /**
     * Gets the "Mensaje" attribute
     */
    public java.lang.String getMensaje()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MENSAJE$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Mensaje" attribute
     */
    public org.apache.xmlbeans.XmlString xgetMensaje()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MENSAJE$2);
            return target;
        }
    }
    
    /**
     * True if has "Mensaje" attribute
     */
    public boolean isSetMensaje()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(MENSAJE$2) != null;
        }
    }
    
    /**
     * Sets the "Mensaje" attribute
     */
    public void setMensaje(java.lang.String mensaje)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MENSAJE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MENSAJE$2);
            }
            target.setStringValue(mensaje);
        }
    }
    
    /**
     * Sets (as xml) the "Mensaje" attribute
     */
    public void xsetMensaje(org.apache.xmlbeans.XmlString mensaje)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(MENSAJE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(MENSAJE$2);
            }
            target.set(mensaje);
        }
    }
    
    /**
     * Unsets the "Mensaje" attribute
     */
    public void unsetMensaje()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(MENSAJE$2);
        }
    }
}
