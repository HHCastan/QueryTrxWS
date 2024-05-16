/*
 * An XML document type.
 * Localname: ProcessaHuella
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ProcessaHuellaDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * A document containing one ProcessaHuella(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public class ProcessaHuellaDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ProcessaHuellaDocument
{
    private static final long serialVersionUID = 1L;
    
    public ProcessaHuellaDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PROCESSAHUELLA$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ProcessaHuella");
    
    
    /**
     * Gets the "ProcessaHuella" element
     */
    public co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella getProcessaHuella()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella target = null;
            target = (co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella)get_store().find_element_user(PROCESSAHUELLA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ProcessaHuella" element
     */
    public void setProcessaHuella(co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella processaHuella)
    {
        generatedSetterHelperImpl(processaHuella, PROCESSAHUELLA$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ProcessaHuella" element
     */
    public co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella addNewProcessaHuella()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella target = null;
            target = (co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella)get_store().add_element_user(PROCESSAHUELLA$0);
            return target;
        }
    }
    /**
     * An XML ProcessaHuella(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public static class ProcessaHuellaImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ProcessaHuellaDocument.ProcessaHuella
    {
        private static final long serialVersionUID = 1L;
        
        public ProcessaHuellaImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName OBJDATA$0 = 
            new javax.xml.namespace.QName("http://bytte.com.co/casb/", "objData");
        
        
        /**
         * Gets the "objData" element
         */
        public co.com.bytte.casb.HuellaProceso getObjData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.HuellaProceso target = null;
                target = (co.com.bytte.casb.HuellaProceso)get_store().find_element_user(OBJDATA$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "objData" element
         */
        public boolean isSetObjData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(OBJDATA$0) != 0;
            }
        }
        
        /**
         * Sets the "objData" element
         */
        public void setObjData(co.com.bytte.casb.HuellaProceso objData)
        {
            generatedSetterHelperImpl(objData, OBJDATA$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
        }
        
        /**
         * Appends and returns a new empty "objData" element
         */
        public co.com.bytte.casb.HuellaProceso addNewObjData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                co.com.bytte.casb.HuellaProceso target = null;
                target = (co.com.bytte.casb.HuellaProceso)get_store().add_element_user(OBJDATA$0);
                return target;
            }
        }
        
        /**
         * Unsets the "objData" element
         */
        public void unsetObjData()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(OBJDATA$0, 0);
            }
        }
    }
}
