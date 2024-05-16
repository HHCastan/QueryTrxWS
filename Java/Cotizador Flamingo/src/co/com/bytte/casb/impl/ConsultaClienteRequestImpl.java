/*
 * XML Type:  ConsultaClienteRequest
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ConsultaClienteRequest
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML ConsultaClienteRequest(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class ConsultaClienteRequestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaClienteRequest
{
    private static final long serialVersionUID = 1L;
    
    public ConsultaClienteRequestImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName NODOCUMENTO$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "NoDocumento");
    
    
    /**
     * Gets the "NoDocumento" element
     */
    public java.lang.String getNoDocumento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NODOCUMENTO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NoDocumento" element
     */
    public org.apache.xmlbeans.XmlString xgetNoDocumento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NODOCUMENTO$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "NoDocumento" element
     */
    public boolean isSetNoDocumento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NODOCUMENTO$0) != 0;
        }
    }
    
    /**
     * Sets the "NoDocumento" element
     */
    public void setNoDocumento(java.lang.String noDocumento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NODOCUMENTO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NODOCUMENTO$0);
            }
            target.setStringValue(noDocumento);
        }
    }
    
    /**
     * Sets (as xml) the "NoDocumento" element
     */
    public void xsetNoDocumento(org.apache.xmlbeans.XmlString noDocumento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NODOCUMENTO$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NODOCUMENTO$0);
            }
            target.set(noDocumento);
        }
    }
    
    /**
     * Unsets the "NoDocumento" element
     */
    public void unsetNoDocumento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NODOCUMENTO$0, 0);
        }
    }
}
