
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para deleteFamilyByParent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="deleteFamilyByParent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FamilyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ParentFamilyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteFamilyByParent", propOrder = {
    "familyCode",
    "parentFamilyCode"
})
public class DeleteFamilyByParent {

    @XmlElement(name = "FamilyCode")
    protected String familyCode;
    @XmlElement(name = "ParentFamilyCode")
    protected String parentFamilyCode;

    /**
     * Obtiene el valor de la propiedad familyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyCode() {
        return familyCode;
    }

    /**
     * Define el valor de la propiedad familyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyCode(String value) {
        this.familyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad parentFamilyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentFamilyCode() {
        return parentFamilyCode;
    }

    /**
     * Define el valor de la propiedad parentFamilyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentFamilyCode(String value) {
        this.parentFamilyCode = value;
    }

}
