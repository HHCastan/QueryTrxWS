/*
 * XML Type:  DocumentoData
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.DocumentoData
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb.impl;
/**
 * An XML DocumentoData(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public class DocumentoDataImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements co.com.bytte.casb.DocumentoData
{
    private static final long serialVersionUID = 1L;
    
    public DocumentoDataImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERSIONCEDULA$0 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "VersionCedula");
    private static final javax.xml.namespace.QName NUMEROTARJETA$2 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "NumeroTarjeta");
    private static final javax.xml.namespace.QName NUMEROCEDULA$4 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "NumeroCedula");
    private static final javax.xml.namespace.QName PRIMERAPELLIDO$6 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "PrimerApellido");
    private static final javax.xml.namespace.QName SEGUNDOAPELLIDO$8 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "SegundoApellido");
    private static final javax.xml.namespace.QName PRIMERNOMBRE$10 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "PrimerNombre");
    private static final javax.xml.namespace.QName SEGUNDONOMBRE$12 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "SegundoNombre");
    private static final javax.xml.namespace.QName NOMBRESCOMPLETOS$14 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "NombresCompletos");
    private static final javax.xml.namespace.QName SEXO$16 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "Sexo");
    private static final javax.xml.namespace.QName FECHANACIMIENTO$18 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "FechaNacimiento");
    private static final javax.xml.namespace.QName RH$20 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "RH");
    private static final javax.xml.namespace.QName TEMPLATE$22 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "Template");
    private static final javax.xml.namespace.QName TIPODEDO1$24 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "TipoDedo1");
    private static final javax.xml.namespace.QName TIPODEDO2$26 = 
        new javax.xml.namespace.QName("http://bytte.com.co/casb/", "TipoDedo2");
    
    
    /**
     * Gets the "VersionCedula" element
     */
    public java.lang.String getVersionCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSIONCEDULA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "VersionCedula" element
     */
    public org.apache.xmlbeans.XmlString xgetVersionCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSIONCEDULA$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "VersionCedula" element
     */
    public boolean isSetVersionCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VERSIONCEDULA$0) != 0;
        }
    }
    
    /**
     * Sets the "VersionCedula" element
     */
    public void setVersionCedula(java.lang.String versionCedula)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(VERSIONCEDULA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(VERSIONCEDULA$0);
            }
            target.setStringValue(versionCedula);
        }
    }
    
    /**
     * Sets (as xml) the "VersionCedula" element
     */
    public void xsetVersionCedula(org.apache.xmlbeans.XmlString versionCedula)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(VERSIONCEDULA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(VERSIONCEDULA$0);
            }
            target.set(versionCedula);
        }
    }
    
    /**
     * Unsets the "VersionCedula" element
     */
    public void unsetVersionCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VERSIONCEDULA$0, 0);
        }
    }
    
    /**
     * Gets the "NumeroTarjeta" element
     */
    public java.lang.String getNumeroTarjeta()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMEROTARJETA$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NumeroTarjeta" element
     */
    public org.apache.xmlbeans.XmlString xgetNumeroTarjeta()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NUMEROTARJETA$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "NumeroTarjeta" element
     */
    public boolean isSetNumeroTarjeta()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NUMEROTARJETA$2) != 0;
        }
    }
    
    /**
     * Sets the "NumeroTarjeta" element
     */
    public void setNumeroTarjeta(java.lang.String numeroTarjeta)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMEROTARJETA$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NUMEROTARJETA$2);
            }
            target.setStringValue(numeroTarjeta);
        }
    }
    
    /**
     * Sets (as xml) the "NumeroTarjeta" element
     */
    public void xsetNumeroTarjeta(org.apache.xmlbeans.XmlString numeroTarjeta)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NUMEROTARJETA$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NUMEROTARJETA$2);
            }
            target.set(numeroTarjeta);
        }
    }
    
    /**
     * Unsets the "NumeroTarjeta" element
     */
    public void unsetNumeroTarjeta()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NUMEROTARJETA$2, 0);
        }
    }
    
    /**
     * Gets the "NumeroCedula" element
     */
    public java.lang.String getNumeroCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMEROCEDULA$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NumeroCedula" element
     */
    public org.apache.xmlbeans.XmlString xgetNumeroCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NUMEROCEDULA$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "NumeroCedula" element
     */
    public boolean isSetNumeroCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NUMEROCEDULA$4) != 0;
        }
    }
    
    /**
     * Sets the "NumeroCedula" element
     */
    public void setNumeroCedula(java.lang.String numeroCedula)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NUMEROCEDULA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NUMEROCEDULA$4);
            }
            target.setStringValue(numeroCedula);
        }
    }
    
    /**
     * Sets (as xml) the "NumeroCedula" element
     */
    public void xsetNumeroCedula(org.apache.xmlbeans.XmlString numeroCedula)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NUMEROCEDULA$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NUMEROCEDULA$4);
            }
            target.set(numeroCedula);
        }
    }
    
    /**
     * Unsets the "NumeroCedula" element
     */
    public void unsetNumeroCedula()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NUMEROCEDULA$4, 0);
        }
    }
    
    /**
     * Gets the "PrimerApellido" element
     */
    public java.lang.String getPrimerApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMERAPELLIDO$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PrimerApellido" element
     */
    public org.apache.xmlbeans.XmlString xgetPrimerApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMERAPELLIDO$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "PrimerApellido" element
     */
    public boolean isSetPrimerApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PRIMERAPELLIDO$6) != 0;
        }
    }
    
    /**
     * Sets the "PrimerApellido" element
     */
    public void setPrimerApellido(java.lang.String primerApellido)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMERAPELLIDO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PRIMERAPELLIDO$6);
            }
            target.setStringValue(primerApellido);
        }
    }
    
    /**
     * Sets (as xml) the "PrimerApellido" element
     */
    public void xsetPrimerApellido(org.apache.xmlbeans.XmlString primerApellido)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMERAPELLIDO$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PRIMERAPELLIDO$6);
            }
            target.set(primerApellido);
        }
    }
    
    /**
     * Unsets the "PrimerApellido" element
     */
    public void unsetPrimerApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PRIMERAPELLIDO$6, 0);
        }
    }
    
    /**
     * Gets the "SegundoApellido" element
     */
    public java.lang.String getSegundoApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEGUNDOAPELLIDO$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SegundoApellido" element
     */
    public org.apache.xmlbeans.XmlString xgetSegundoApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEGUNDOAPELLIDO$8, 0);
            return target;
        }
    }
    
    /**
     * True if has "SegundoApellido" element
     */
    public boolean isSetSegundoApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SEGUNDOAPELLIDO$8) != 0;
        }
    }
    
    /**
     * Sets the "SegundoApellido" element
     */
    public void setSegundoApellido(java.lang.String segundoApellido)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEGUNDOAPELLIDO$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SEGUNDOAPELLIDO$8);
            }
            target.setStringValue(segundoApellido);
        }
    }
    
    /**
     * Sets (as xml) the "SegundoApellido" element
     */
    public void xsetSegundoApellido(org.apache.xmlbeans.XmlString segundoApellido)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEGUNDOAPELLIDO$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SEGUNDOAPELLIDO$8);
            }
            target.set(segundoApellido);
        }
    }
    
    /**
     * Unsets the "SegundoApellido" element
     */
    public void unsetSegundoApellido()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SEGUNDOAPELLIDO$8, 0);
        }
    }
    
    /**
     * Gets the "PrimerNombre" element
     */
    public java.lang.String getPrimerNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMERNOMBRE$10, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "PrimerNombre" element
     */
    public org.apache.xmlbeans.XmlString xgetPrimerNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMERNOMBRE$10, 0);
            return target;
        }
    }
    
    /**
     * True if has "PrimerNombre" element
     */
    public boolean isSetPrimerNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PRIMERNOMBRE$10) != 0;
        }
    }
    
    /**
     * Sets the "PrimerNombre" element
     */
    public void setPrimerNombre(java.lang.String primerNombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PRIMERNOMBRE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PRIMERNOMBRE$10);
            }
            target.setStringValue(primerNombre);
        }
    }
    
    /**
     * Sets (as xml) the "PrimerNombre" element
     */
    public void xsetPrimerNombre(org.apache.xmlbeans.XmlString primerNombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PRIMERNOMBRE$10, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PRIMERNOMBRE$10);
            }
            target.set(primerNombre);
        }
    }
    
    /**
     * Unsets the "PrimerNombre" element
     */
    public void unsetPrimerNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PRIMERNOMBRE$10, 0);
        }
    }
    
    /**
     * Gets the "SegundoNombre" element
     */
    public java.lang.String getSegundoNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEGUNDONOMBRE$12, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "SegundoNombre" element
     */
    public org.apache.xmlbeans.XmlString xgetSegundoNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEGUNDONOMBRE$12, 0);
            return target;
        }
    }
    
    /**
     * True if has "SegundoNombre" element
     */
    public boolean isSetSegundoNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SEGUNDONOMBRE$12) != 0;
        }
    }
    
    /**
     * Sets the "SegundoNombre" element
     */
    public void setSegundoNombre(java.lang.String segundoNombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEGUNDONOMBRE$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SEGUNDONOMBRE$12);
            }
            target.setStringValue(segundoNombre);
        }
    }
    
    /**
     * Sets (as xml) the "SegundoNombre" element
     */
    public void xsetSegundoNombre(org.apache.xmlbeans.XmlString segundoNombre)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEGUNDONOMBRE$12, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SEGUNDONOMBRE$12);
            }
            target.set(segundoNombre);
        }
    }
    
    /**
     * Unsets the "SegundoNombre" element
     */
    public void unsetSegundoNombre()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SEGUNDONOMBRE$12, 0);
        }
    }
    
    /**
     * Gets the "NombresCompletos" element
     */
    public java.lang.String getNombresCompletos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMBRESCOMPLETOS$14, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "NombresCompletos" element
     */
    public org.apache.xmlbeans.XmlString xgetNombresCompletos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMBRESCOMPLETOS$14, 0);
            return target;
        }
    }
    
    /**
     * True if has "NombresCompletos" element
     */
    public boolean isSetNombresCompletos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(NOMBRESCOMPLETOS$14) != 0;
        }
    }
    
    /**
     * Sets the "NombresCompletos" element
     */
    public void setNombresCompletos(java.lang.String nombresCompletos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NOMBRESCOMPLETOS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NOMBRESCOMPLETOS$14);
            }
            target.setStringValue(nombresCompletos);
        }
    }
    
    /**
     * Sets (as xml) the "NombresCompletos" element
     */
    public void xsetNombresCompletos(org.apache.xmlbeans.XmlString nombresCompletos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(NOMBRESCOMPLETOS$14, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(NOMBRESCOMPLETOS$14);
            }
            target.set(nombresCompletos);
        }
    }
    
    /**
     * Unsets the "NombresCompletos" element
     */
    public void unsetNombresCompletos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(NOMBRESCOMPLETOS$14, 0);
        }
    }
    
    /**
     * Gets the "Sexo" element
     */
    public java.lang.String getSexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEXO$16, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Sexo" element
     */
    public org.apache.xmlbeans.XmlString xgetSexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEXO$16, 0);
            return target;
        }
    }
    
    /**
     * True if has "Sexo" element
     */
    public boolean isSetSexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SEXO$16) != 0;
        }
    }
    
    /**
     * Sets the "Sexo" element
     */
    public void setSexo(java.lang.String sexo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SEXO$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SEXO$16);
            }
            target.setStringValue(sexo);
        }
    }
    
    /**
     * Sets (as xml) the "Sexo" element
     */
    public void xsetSexo(org.apache.xmlbeans.XmlString sexo)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(SEXO$16, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(SEXO$16);
            }
            target.set(sexo);
        }
    }
    
    /**
     * Unsets the "Sexo" element
     */
    public void unsetSexo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SEXO$16, 0);
        }
    }
    
    /**
     * Gets the "FechaNacimiento" element
     */
    public java.lang.String getFechaNacimiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHANACIMIENTO$18, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "FechaNacimiento" element
     */
    public org.apache.xmlbeans.XmlString xgetFechaNacimiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FECHANACIMIENTO$18, 0);
            return target;
        }
    }
    
    /**
     * True if has "FechaNacimiento" element
     */
    public boolean isSetFechaNacimiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(FECHANACIMIENTO$18) != 0;
        }
    }
    
    /**
     * Sets the "FechaNacimiento" element
     */
    public void setFechaNacimiento(java.lang.String fechaNacimiento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FECHANACIMIENTO$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FECHANACIMIENTO$18);
            }
            target.setStringValue(fechaNacimiento);
        }
    }
    
    /**
     * Sets (as xml) the "FechaNacimiento" element
     */
    public void xsetFechaNacimiento(org.apache.xmlbeans.XmlString fechaNacimiento)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FECHANACIMIENTO$18, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FECHANACIMIENTO$18);
            }
            target.set(fechaNacimiento);
        }
    }
    
    /**
     * Unsets the "FechaNacimiento" element
     */
    public void unsetFechaNacimiento()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(FECHANACIMIENTO$18, 0);
        }
    }
    
    /**
     * Gets the "RH" element
     */
    public java.lang.String getRH()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RH$20, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "RH" element
     */
    public org.apache.xmlbeans.XmlString xgetRH()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RH$20, 0);
            return target;
        }
    }
    
    /**
     * True if has "RH" element
     */
    public boolean isSetRH()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RH$20) != 0;
        }
    }
    
    /**
     * Sets the "RH" element
     */
    public void setRH(java.lang.String rh)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RH$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RH$20);
            }
            target.setStringValue(rh);
        }
    }
    
    /**
     * Sets (as xml) the "RH" element
     */
    public void xsetRH(org.apache.xmlbeans.XmlString rh)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RH$20, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RH$20);
            }
            target.set(rh);
        }
    }
    
    /**
     * Unsets the "RH" element
     */
    public void unsetRH()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RH$20, 0);
        }
    }
    
    /**
     * Gets the "Template" element
     */
    public java.lang.String getTemplate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TEMPLATE$22, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "Template" element
     */
    public org.apache.xmlbeans.XmlString xgetTemplate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TEMPLATE$22, 0);
            return target;
        }
    }
    
    /**
     * True if has "Template" element
     */
    public boolean isSetTemplate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TEMPLATE$22) != 0;
        }
    }
    
    /**
     * Sets the "Template" element
     */
    public void setTemplate(java.lang.String template)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TEMPLATE$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TEMPLATE$22);
            }
            target.setStringValue(template);
        }
    }
    
    /**
     * Sets (as xml) the "Template" element
     */
    public void xsetTemplate(org.apache.xmlbeans.XmlString template)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TEMPLATE$22, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TEMPLATE$22);
            }
            target.set(template);
        }
    }
    
    /**
     * Unsets the "Template" element
     */
    public void unsetTemplate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TEMPLATE$22, 0);
        }
    }
    
    /**
     * Gets the "TipoDedo1" element
     */
    public java.lang.String getTipoDedo1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPODEDO1$24, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TipoDedo1" element
     */
    public org.apache.xmlbeans.XmlString xgetTipoDedo1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPODEDO1$24, 0);
            return target;
        }
    }
    
    /**
     * True if has "TipoDedo1" element
     */
    public boolean isSetTipoDedo1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIPODEDO1$24) != 0;
        }
    }
    
    /**
     * Sets the "TipoDedo1" element
     */
    public void setTipoDedo1(java.lang.String tipoDedo1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPODEDO1$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIPODEDO1$24);
            }
            target.setStringValue(tipoDedo1);
        }
    }
    
    /**
     * Sets (as xml) the "TipoDedo1" element
     */
    public void xsetTipoDedo1(org.apache.xmlbeans.XmlString tipoDedo1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPODEDO1$24, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TIPODEDO1$24);
            }
            target.set(tipoDedo1);
        }
    }
    
    /**
     * Unsets the "TipoDedo1" element
     */
    public void unsetTipoDedo1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIPODEDO1$24, 0);
        }
    }
    
    /**
     * Gets the "TipoDedo2" element
     */
    public java.lang.String getTipoDedo2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPODEDO2$26, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "TipoDedo2" element
     */
    public org.apache.xmlbeans.XmlString xgetTipoDedo2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPODEDO2$26, 0);
            return target;
        }
    }
    
    /**
     * True if has "TipoDedo2" element
     */
    public boolean isSetTipoDedo2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TIPODEDO2$26) != 0;
        }
    }
    
    /**
     * Sets the "TipoDedo2" element
     */
    public void setTipoDedo2(java.lang.String tipoDedo2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TIPODEDO2$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TIPODEDO2$26);
            }
            target.setStringValue(tipoDedo2);
        }
    }
    
    /**
     * Sets (as xml) the "TipoDedo2" element
     */
    public void xsetTipoDedo2(org.apache.xmlbeans.XmlString tipoDedo2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TIPODEDO2$26, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TIPODEDO2$26);
            }
            target.set(tipoDedo2);
        }
    }
    
    /**
     * Unsets the "TipoDedo2" element
     */
    public void unsetTipoDedo2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TIPODEDO2$26, 0);
        }
    }
}
