/*
 * XML Type:  LogResponseImage
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.LogResponseImage
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML LogResponseImage(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class LogResponseImageImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.LogResponseImage
{
    private static final long serialVersionUID = 1L;
    
    public LogResponseImageImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LAUID$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "LAU_ID");
    private static final javax.xml.namespace.QName FECHAPROCESO$2 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "FECHA_PROCESO");
    private static final javax.xml.namespace.QName STPROCESO$4 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ST_PROCESO");
    private static final javax.xml.namespace.QName STCAPTURADOCUMENTO$6 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ST_CAPTURA_DOCUMENTO");
    private static final javax.xml.namespace.QName STVERIFICAHUELLA$8 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "ST_VERIFICA_HUELLA");
    private static final javax.xml.namespace.QName SCOREPROCESO$10 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "SCORE_PROCESO");
    private static final javax.xml.namespace.QName MACHINGTHRESHOLD$12 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "MACHING_THRESHOLD");
    private static final javax.xml.namespace.QName DNSHOST$14 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "DNS_HOST");
    private static final javax.xml.namespace.QName NOMBREFUNCIONARIO$16 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "NOMBRE_FUNCIONARIO");
    private static final javax.xml.namespace.QName FUNID$18 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "FUN_ID");
    private static final javax.xml.namespace.QName LISTAARCHIVOS$20 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "LISTA_ARCHIVOS");
    
    
    /**
     * Gets the "LAU_ID" element
     */
    public java.lang.String getLAUID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LAUID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "LAU_ID" element
     */
    public org.apache.xmlbeans.XmlString xgetLAUID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAUID$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "LAU_ID" element
     */
    public boolean isSetLAUID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LAUID$0) != 0;
        }
    }
    
    /**
     * Sets the "LAU_ID" element
     */
    public void setLAUID(java.lang.String lauid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LAUID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LAUID$0);
            }
            target.setStringValue(lauid);
        }
    }
    
    /**
     * Sets (as xml) the "LAU_ID" element
     */
    public void xsetLAUID(org.apache.xmlbeans.XmlString lauid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAUID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LAUID$0);
            }
            target.set(lauid);
        }
    }
    
    /**
     * Unsets the "LAU_ID" element
     */
    public void unsetLAUID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LAUID$0, 0);
        }
    }
    
    /**
     * Gets the "FECHA_PROCESO" element
     */
    public java.util.Calendar getFECHAPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHAPROCESO$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "FECHA_PROCESO" element
     */
    public org.apache.xmlbeans.XmlDateTime xgetFECHAPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(FECHAPROCESO$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "FECHA_PROCESO" element
     */
    public void setFECHAPROCESO(java.util.Calendar fechaproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHAPROCESO$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FECHAPROCESO$2);
            }
            target.setCalendarValue(fechaproceso);
        }
    }
    
    /**
     * Sets (as xml) the "FECHA_PROCESO" element
     */
    public void xsetFECHAPROCESO(org.apache.xmlbeans.XmlDateTime fechaproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDateTime target = null;
            target = (org.apache.xmlbeans.XmlDateTime)get_store().find_element_user(FECHAPROCESO$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDateTime)get_store().add_element_user(FECHAPROCESO$2);
            }
            target.set(fechaproceso);
        }
    }
    
    /**
     * Gets the "ST_PROCESO" element
     */
    public boolean getSTPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STPROCESO$4, 0);
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "ST_PROCESO" element
     */
    public org.apache.xmlbeans.XmlBoolean xgetSTPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(STPROCESO$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ST_PROCESO" element
     */
    public void setSTPROCESO(boolean stproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STPROCESO$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STPROCESO$4);
            }
            target.setBooleanValue(stproceso);
        }
    }
    
    /**
     * Sets (as xml) the "ST_PROCESO" element
     */
    public void xsetSTPROCESO(org.apache.xmlbeans.XmlBoolean stproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(STPROCESO$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(STPROCESO$4);
            }
            target.set(stproceso);
        }
    }
    
    /**
     * Gets the "ST_CAPTURA_DOCUMENTO" element
     */
    public short getSTCAPTURADOCUMENTO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STCAPTURADOCUMENTO$6, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "ST_CAPTURA_DOCUMENTO" element
     */
    public org.apache.xmlbeans.XmlShort xgetSTCAPTURADOCUMENTO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(STCAPTURADOCUMENTO$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ST_CAPTURA_DOCUMENTO" element
     */
    public void setSTCAPTURADOCUMENTO(short stcapturadocumento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STCAPTURADOCUMENTO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STCAPTURADOCUMENTO$6);
            }
            target.setShortValue(stcapturadocumento);
        }
    }
    
    /**
     * Sets (as xml) the "ST_CAPTURA_DOCUMENTO" element
     */
    public void xsetSTCAPTURADOCUMENTO(org.apache.xmlbeans.XmlShort stcapturadocumento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(STCAPTURADOCUMENTO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(STCAPTURADOCUMENTO$6);
            }
            target.set(stcapturadocumento);
        }
    }
    
    /**
     * Gets the "ST_VERIFICA_HUELLA" element
     */
    public short getSTVERIFICAHUELLA()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STVERIFICAHUELLA$8, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getShortValue();
        }
    }
    
    /**
     * Gets (as xml) the "ST_VERIFICA_HUELLA" element
     */
    public org.apache.xmlbeans.XmlShort xgetSTVERIFICAHUELLA()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(STVERIFICAHUELLA$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ST_VERIFICA_HUELLA" element
     */
    public void setSTVERIFICAHUELLA(short stverificahuella)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STVERIFICAHUELLA$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STVERIFICAHUELLA$8);
            }
            target.setShortValue(stverificahuella);
        }
    }
    
    /**
     * Sets (as xml) the "ST_VERIFICA_HUELLA" element
     */
    public void xsetSTVERIFICAHUELLA(org.apache.xmlbeans.XmlShort stverificahuella)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlShort target = null;
            target = (org.apache.xmlbeans.XmlShort)get_store().find_element_user(STVERIFICAHUELLA$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlShort)get_store().add_element_user(STVERIFICAHUELLA$8);
            }
            target.set(stverificahuella);
        }
    }
    
    /**
     * Gets the "SCORE_PROCESO" element
     */
    public java.lang.String getSCOREPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SCOREPROCESO$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SCORE_PROCESO" element
     */
    public org.apache.xmlbeans.XmlString xgetSCOREPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SCOREPROCESO$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "SCORE_PROCESO" element
     */
    public boolean isSetSCOREPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SCOREPROCESO$10) != 0;
        }
    }
    
    /**
     * Sets the "SCORE_PROCESO" element
     */
    public void setSCOREPROCESO(java.lang.String scoreproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SCOREPROCESO$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SCOREPROCESO$10);
            }
            target.setStringValue(scoreproceso);
        }
    }
    
    /**
     * Sets (as xml) the "SCORE_PROCESO" element
     */
    public void xsetSCOREPROCESO(org.apache.xmlbeans.XmlString scoreproceso)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SCOREPROCESO$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SCOREPROCESO$10);
            }
            target.set(scoreproceso);
        }
    }
    
    /**
     * Unsets the "SCORE_PROCESO" element
     */
    public void unsetSCOREPROCESO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SCOREPROCESO$10, 0);
        }
    }
    
    /**
     * Gets the "MACHING_THRESHOLD" element
     */
    public java.lang.String getMACHINGTHRESHOLD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MACHINGTHRESHOLD$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "MACHING_THRESHOLD" element
     */
    public org.apache.xmlbeans.XmlString xgetMACHINGTHRESHOLD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MACHINGTHRESHOLD$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "MACHING_THRESHOLD" element
     */
    public boolean isSetMACHINGTHRESHOLD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MACHINGTHRESHOLD$12) != 0;
        }
    }
    
    /**
     * Sets the "MACHING_THRESHOLD" element
     */
    public void setMACHINGTHRESHOLD(java.lang.String machingthreshold)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MACHINGTHRESHOLD$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MACHINGTHRESHOLD$12);
            }
            target.setStringValue(machingthreshold);
        }
    }
    
    /**
     * Sets (as xml) the "MACHING_THRESHOLD" element
     */
    public void xsetMACHINGTHRESHOLD(org.apache.xmlbeans.XmlString machingthreshold)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(MACHINGTHRESHOLD$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(MACHINGTHRESHOLD$12);
            }
            target.set(machingthreshold);
        }
    }
    
    /**
     * Unsets the "MACHING_THRESHOLD" element
     */
    public void unsetMACHINGTHRESHOLD()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MACHINGTHRESHOLD$12, 0);
        }
    }
    
    /**
     * Gets the "DNS_HOST" element
     */
    public java.lang.String getDNSHOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DNSHOST$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "DNS_HOST" element
     */
    public org.apache.xmlbeans.XmlString xgetDNSHOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DNSHOST$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "DNS_HOST" element
     */
    public boolean isSetDNSHOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DNSHOST$14) != 0;
        }
    }
    
    /**
     * Sets the "DNS_HOST" element
     */
    public void setDNSHOST(java.lang.String dnshost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DNSHOST$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DNSHOST$14);
            }
            target.setStringValue(dnshost);
        }
    }
    
    /**
     * Sets (as xml) the "DNS_HOST" element
     */
    public void xsetDNSHOST(org.apache.xmlbeans.XmlString dnshost)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DNSHOST$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DNSHOST$14);
            }
            target.set(dnshost);
        }
    }
    
    /**
     * Unsets the "DNS_HOST" element
     */
    public void unsetDNSHOST()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DNSHOST$14, 0);
        }
    }
    
    /**
     * Gets the "NOMBRE_FUNCIONARIO" element
     */
    public java.lang.String getNOMBREFUNCIONARIO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMBREFUNCIONARIO$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NOMBRE_FUNCIONARIO" element
     */
    public org.apache.xmlbeans.XmlString xgetNOMBREFUNCIONARIO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMBREFUNCIONARIO$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "NOMBRE_FUNCIONARIO" element
     */
    public boolean isSetNOMBREFUNCIONARIO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NOMBREFUNCIONARIO$16) != 0;
        }
    }
    
    /**
     * Sets the "NOMBRE_FUNCIONARIO" element
     */
    public void setNOMBREFUNCIONARIO(java.lang.String nombrefuncionario)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMBREFUNCIONARIO$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMBREFUNCIONARIO$16);
            }
            target.setStringValue(nombrefuncionario);
        }
    }
    
    /**
     * Sets (as xml) the "NOMBRE_FUNCIONARIO" element
     */
    public void xsetNOMBREFUNCIONARIO(org.apache.xmlbeans.XmlString nombrefuncionario)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMBREFUNCIONARIO$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMBREFUNCIONARIO$16);
            }
            target.set(nombrefuncionario);
        }
    }
    
    /**
     * Unsets the "NOMBRE_FUNCIONARIO" element
     */
    public void unsetNOMBREFUNCIONARIO()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NOMBREFUNCIONARIO$16, 0);
        }
    }
    
    /**
     * Gets the "FUN_ID" element
     */
    public java.lang.String getFUNID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FUNID$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FUN_ID" element
     */
    public org.apache.xmlbeans.XmlString xgetFUNID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FUNID$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "FUN_ID" element
     */
    public boolean isSetFUNID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FUNID$18) != 0;
        }
    }
    
    /**
     * Sets the "FUN_ID" element
     */
    public void setFUNID(java.lang.String funid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FUNID$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FUNID$18);
            }
            target.setStringValue(funid);
        }
    }
    
    /**
     * Sets (as xml) the "FUN_ID" element
     */
    public void xsetFUNID(org.apache.xmlbeans.XmlString funid)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FUNID$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FUNID$18);
            }
            target.set(funid);
        }
    }
    
    /**
     * Unsets the "FUN_ID" element
     */
    public void unsetFUNID()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FUNID$18, 0);
        }
    }
    
    /**
     * Gets the "LISTA_ARCHIVOS" element
     */
    public co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo getLISTAARCHIVOS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo)get_store().find_element_user(LISTAARCHIVOS$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "LISTA_ARCHIVOS" element
     */
    public boolean isSetLISTAARCHIVOS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(LISTAARCHIVOS$20) != 0;
        }
    }
    
    /**
     * Sets the "LISTA_ARCHIVOS" element
     */
    public void setLISTAARCHIVOS(co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo listaarchivos)
    {
        generatedSetterHelperImpl(listaarchivos, LISTAARCHIVOS$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "LISTA_ARCHIVOS" element
     */
    public co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo addNewLISTAARCHIVOS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo target = null;
            target = (co.com.bytte.casb.ArrayOfConsultaClienteEnrolamientoArchivo)get_store().add_element_user(LISTAARCHIVOS$20);
            return target;
        }
    }
    
    /**
     * Unsets the "LISTA_ARCHIVOS" element
     */
    public void unsetLISTAARCHIVOS()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(LISTAARCHIVOS$20, 0);
        }
    }
}
