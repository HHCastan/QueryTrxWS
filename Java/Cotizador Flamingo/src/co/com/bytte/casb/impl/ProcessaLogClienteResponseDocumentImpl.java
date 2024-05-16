/*
 * An XML document type.
 * Localname: ProcessaLogClienteResponse
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ProcessaLogClienteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * A document containing one ProcessaLogClienteResponse(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public class ProcessaLogClienteResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ProcessaLogClienteResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProcessaLogClienteResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSALOGCLIENTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ProcessaLogClienteResponse");
    
    
    /**
     * Gets the "ProcessaLogClienteResponse" element
     */
    public co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse getProcessaLogClienteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse target = null;
            target = (co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse)get_store().find_element_user(PROCESSALOGCLIENTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessaLogClienteResponse" element
     */
    public void setProcessaLogClienteResponse(co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse processaLogClienteResponse)
    {
        generatedSetterHelperImpl(processaLogClienteResponse, PROCESSALOGCLIENTERESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ProcessaLogClienteResponse" element
     */
    public co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse addNewProcessaLogClienteResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse target = null;
            target = (co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse)get_store().add_element_user(PROCESSALOGCLIENTERESPONSE$0);
            return target;
        }
    }
    /**
     * An XML ProcessaLogClienteResponse(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public static class ProcessaLogClienteResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse
    {
        private static final long serialVersionUID = 1L;
        
        public ProcessaLogClienteResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName PROCESSALOGCLIENTERESULT$0 = 
            new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ProcessaLogClienteResult");
        
        
        /**
         * Gets the "ProcessaLogClienteResult" element
         */
        public co.com.bytte.casb.LogResponse getProcessaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.LogResponse target = null;
                target = (co.com.bytte.casb.LogResponse)get_store().find_element_user(PROCESSALOGCLIENTERESULT$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "ProcessaLogClienteResult" element
         */
        public boolean isSetProcessaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PROCESSALOGCLIENTERESULT$0) != 0;
            }
        }
        
        /**
         * Sets the "ProcessaLogClienteResult" element
         */
        public void setProcessaLogClienteResult(co.com.bytte.casb.LogResponse processaLogClienteResult)
        {
            generatedSetterHelperImpl(processaLogClienteResult, PROCESSALOGCLIENTERESULT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "ProcessaLogClienteResult" element
         */
        public co.com.bytte.casb.LogResponse addNewProcessaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.LogResponse target = null;
                target = (co.com.bytte.casb.LogResponse)get_store().add_element_user(PROCESSALOGCLIENTERESULT$0);
                return target;
            }
        }
        
        /**
         * Unsets the "ProcessaLogClienteResult" element
         */
        public void unsetProcessaLogClienteResult()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PROCESSALOGCLIENTERESULT$0, 0);
            }
        }
    }
}
