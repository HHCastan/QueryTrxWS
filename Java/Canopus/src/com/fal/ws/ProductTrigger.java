
package com.fal.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para productTrigger complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="productTrigger">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.ws.fal.com/}falBaseDTO">
 *       &lt;sequence>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productTrigger", propOrder = {
    "index",
    "quantity"
})
public class ProductTrigger
    extends FalBaseDTO
{

    protected int index;
    protected double quantity;

    /**
     * Obtiene el valor de la propiedad index.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Define el valor de la propiedad index.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Obtiene el valor de la propiedad quantity.
     * 
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     */
    public void setQuantity(double value) {
        this.quantity = value;
    }

}
