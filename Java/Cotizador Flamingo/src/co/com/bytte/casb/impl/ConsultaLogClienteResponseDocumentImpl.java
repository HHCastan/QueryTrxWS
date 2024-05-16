/*
 * An XML document type.
 * Localname: ConsultaLogClienteResponse
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ConsultaLogClienteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * A document containing one ConsultaLogClienteResponse(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public class ConsultaLogClienteResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaLogClienteResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public ConsultaLogClienteResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONSULTALOGCLIENTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ConsultaLogClienteResponse");
    
    
    /**
     * Gets the "ConsultaLogClienteResponse" element
     */
    public co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse getConsultaLogClienteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse target = null;
            target = (co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse)get_store().find_element_user(CONSULTALOGCLIENTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ConsultaLogClienteResponse" element
     */
    public void setConsultaLogClienteResponse(co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse consultaLogClienteResponse)
    {
        generatedSetterHelperImpl(consultaLogClienteResponse, CONSULTALOGCLIENTERESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ConsultaLogClienteResponse" element
     */
    public co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse addNewConsultaLogClienteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse target = null;
            target = (co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse)get_store().add_element_user(CONSULTALOGCLIENTERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML ConsultaLogClienteResponse(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public static class ConsultaLogClienteResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ConsultaLogClienteResponseDocument.ConsultaLogClienteResponse
    {
        private static final long serialVersionUID = 1L;
        
        public ConsultaLogClienteResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CONSULTALOGCLIENTERESULT$0 = 
            new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ConsultaLogClienteResult");
        
        
        /**
         * Gets the "ConsultaLogClienteResult" element
         */
        public co.com.bytte.casb.LogResponseImageTransactions getConsultaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.LogResponseImageTransactions target = null;
                target = (co.com.bytte.casb.LogResponseImageTransactions)get_store().find_element_user(CONSULTALOGCLIENTERESULT$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ConsultaLogClienteResult" element
         */
        public boolean isSetConsultaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CONSULTALOGCLIENTERESULT$0) != 0;
            }
        }
        
        /**
         * Sets the "ConsultaLogClienteResult" element
         */
        public void setConsultaLogClienteResult(co.com.bytte.casb.LogResponseImageTransactions consultaLogClienteResult)
        {
            generatedSetterHelperImpl(consultaLogClienteResult, CONSULTALOGCLIENTERESULT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "ConsultaLogClienteResult" element
         */
        public co.com.bytte.casb.LogResponseImageTransactions addNewConsultaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.LogResponseImageTransactions target = null;
                target = (co.com.bytte.casb.LogResponseImageTransactions)get_store().add_element_user(CONSULTALOGCLIENTERESULT$0);
                return target;
            }
        }
        
        /**
         * Unsets the "ConsultaLogClienteResult" element
         */
        public void unsetConsultaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CONSULTALOGCLIENTERESULT$0, 0);
            }
        }
    }
}
