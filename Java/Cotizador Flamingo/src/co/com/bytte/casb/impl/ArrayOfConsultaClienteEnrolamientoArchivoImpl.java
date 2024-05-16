/*
 * XML Type:  ArrayOfConsultaClienteEnrolamientoArchivo
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML ArrayOfConsultaClienteEnrolamientoArchivo(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class ArrayOfConsultaClienteEnrolamientoArchivoImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo
{
    private static final long serialVersionUID = 1L;
    
    public ArrayOfConsultaClienteEnrolamientoArchivoImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CONSULTACLIENTEENROLAMIENTOARCHIVO$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ConsultaClienteEnrolamientoArchivo");
    
    
    /**
     * Gets array of all "ConsultaClienteEnrolamientoArchivo" elements
     */
    public co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo[] getConsultaClienteEnrolamientoArchivoArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, targetList);
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo[] result = new co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo getConsultaClienteEnrolamientoArchivoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().find_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public boolean isNilConsultaClienteEnrolamientoArchivoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().find_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "ConsultaClienteEnrolamientoArchivo" element
     */
    public int sizeOfConsultaClienteEnrolamientoArchivoArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CONSULTACLIENTEENROLAMIENTOARCHIVO$0);
        }
    }
    
    /**
     * Sets array of all "ConsultaClienteEnrolamientoArchivo" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setConsultaClienteEnrolamientoArchivoArray(co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo[] consultaClienteEnrolamientoArchivoArray)
    {
        check_orphaned();
        arraySetterHelper(consultaClienteEnrolamientoArchivoArray, CONSULTACLIENTEENROLAMIENTOARCHIVO$0);
    }
    
    /**
     * Sets ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public void setConsultaClienteEnrolamientoArchivoArray(int i, co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo consultaClienteEnrolamientoArchivo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().find_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(consultaClienteEnrolamientoArchivo);
        }
    }
    
    /**
     * Nils the ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public void setNilConsultaClienteEnrolamientoArchivoArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().find_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo insertNewConsultaClienteEnrolamientoArchivo(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().insert_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "ConsultaClienteEnrolamientoArchivo" element
     */
    public co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo addNewConsultaClienteEnrolamientoArchivo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ConsultaClienteEnrolamientoArchivo)get_store().add_element_user(CONSULTACLIENTEENROLAMIENTOARCHIVO$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "ConsultaClienteEnrolamientoArchivo" element
     */
    public void removeConsultaClienteEnrolamientoArchivo(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CONSULTACLIENTEENROLAMIENTOARCHIVO$0, i);
        }
    }
}
