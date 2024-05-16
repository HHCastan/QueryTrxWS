/*
 * XML Type:  ClienteEnrolamientoDetalle
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ClienteEnrolamientoDetalle
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML ClienteEnrolamientoDetalle(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class ClienteEnrolamientoDetalleImpl extends co.com.bytte.casb.impl.ResponseImpl implements co.com.bytte.casb.ClienteEnrolamientoDetalle
{
    private static final long serialVersionUID = 1L;
    
    public ClienteEnrolamientoDetalleImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CLIENTEENROLAMIENTO$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ClienteEnrolamiento");
    
    
    /**
     * Gets the "ClienteEnrolamiento" element
     */
    public co.com.bytte.casb.Cliente getClienteEnrolamiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.Cliente target = null;
            target = (co.com.bytte.casb.Cliente)get_store().find_element_user(CLIENTEENROLAMIENTO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "ClienteEnrolamiento" element
     */
    public boolean isSetClienteEnrolamiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CLIENTEENROLAMIENTO$0) != 0;
        }
    }
    
    /**
     * Sets the "ClienteEnrolamiento" element
     */
    public void setClienteEnrolamiento(co.com.bytte.casb.Cliente clienteEnrolamiento)
    {
        generatedSetterHelperImpl(clienteEnrolamiento, CLIENTEENROLAMIENTO$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ClienteEnrolamiento" element
     */
    public co.com.bytte.casb.Cliente addNewClienteEnrolamiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.Cliente target = null;
            target = (co.com.bytte.casb.Cliente)get_store().add_element_user(CLIENTEENROLAMIENTO$0);
            return target;
        }
    }
    
    /**
     * Unsets the "ClienteEnrolamiento" element
     */
    public void unsetClienteEnrolamiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CLIENTEENROLAMIENTO$0, 0);
        }
    }
}
