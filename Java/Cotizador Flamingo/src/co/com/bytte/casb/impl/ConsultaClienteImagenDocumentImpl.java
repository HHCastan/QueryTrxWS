/*
 * An XML document type.
 * Localname: ConsultaClienteImagen
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ConsultaClienteImagenDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * A document containing one ConsultaClienteImagen(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public class ConsultaClienteImagenDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaClienteImagenDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConsultaClienteImagenDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONSULTACLIENTEIMAGEN$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ConsultaClienteImagen");
    
    
    /**
     * Gets the "ConsultaClienteImagen" element
     */
    public co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen getConsultaClienteImagen()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen target = null;
            target = (co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen)get_store().find_element_user(CONSULTACLIENTEIMAGEN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ConsultaClienteImagen" element
     */
    public void setConsultaClienteImagen(co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen consultaClienteImagen)
    {
        generatedSetterHelperImpl(consultaClienteImagen, CONSULTACLIENTEIMAGEN$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConsultaClienteImagen" element
     */
    public co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen addNewConsultaClienteImagen()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen target = null;
            target = (co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen)get_store().add_element_user(CONSULTACLIENTEIMAGEN$0);
            return target;
        }
    }
    /**
     * An XML ConsultaClienteImagen(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public static class ConsultaClienteImagenImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaClienteImagenDocument.ConsultaClienteImagen
    {
        private static final long serialVersionUID = 1L;
        
        public ConsultaClienteImagenImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REQUEST$0 = 
            new javax.xml.namespace.QName("http://bytte.com.co/casb/", "request");
        
        
        /**
         * Gets the "request" element
         */
        public co.com.bytte.casb.ConsultaClienteImagenRequest getRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.ConsultaClienteImagenRequest target = null;
                target = (co.com.bytte.casb.ConsultaClienteImagenRequest)get_store().find_element_user(REQUEST$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "request" element
         */
        public boolean isSetRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(REQUEST$0) != 0;
            }
        }
        
        /**
         * Sets the "request" element
         */
        public void setRequest(co.com.bytte.casb.ConsultaClienteImagenRequest request)
        {
            generatedSetterHelperImpl(request, REQUEST$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "request" element
         */
        public co.com.bytte.casb.ConsultaClienteImagenRequest addNewRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.ConsultaClienteImagenRequest target = null;
                target = (co.com.bytte.casb.ConsultaClienteImagenRequest)get_store().add_element_user(REQUEST$0);
                return target;
            }
        }
        
        /**
         * Unsets the "request" element
         */
        public void unsetRequest()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(REQUEST$0, 0);
            }
        }
    }
}
