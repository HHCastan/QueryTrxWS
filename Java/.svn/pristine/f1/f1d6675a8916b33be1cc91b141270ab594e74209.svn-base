
package co.com.flamingo.clienteRetanqueo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ConsultarSaldoNugRes complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ConsultarSaldoNugRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosNug" type="{http://www.flamingo.com.co}infoClienteNug" minOccurs="0"/>
 *         &lt;element name="RespuestaMetodo" type="{http://www.flamingo.com.co}RespuestaMetodo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarSaldoNugRes", propOrder = {
    "datosNug",
    "respuestaMetodo"
})
public class ConsultarSaldoNugRes {

    @XmlElementRef(name = "DatosNug", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<InfoClienteNug> datosNug;
    @XmlElementRef(name = "RespuestaMetodo", namespace = "http://www.flamingo.com.co", type = JAXBElement.class, required = false)
    protected JAXBElement<RespuestaMetodo> respuestaMetodo;

    /**
     * Obtiene el valor de la propiedad datosNug.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InfoClienteNug }{@code >}
     *     
     */
    public JAXBElement<InfoClienteNug> getDatosNug() {
        return datosNug;
    }

    /**
     * Define el valor de la propiedad datosNug.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InfoClienteNug }{@code >}
     *     
     */
    public void setDatosNug(JAXBElement<InfoClienteNug> value) {
        this.datosNug = value;
    }

    /**
     * Obtiene el valor de la propiedad respuestaMetodo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}
     *     
     */
    public JAXBElement<RespuestaMetodo> getRespuestaMetodo() {
        return respuestaMetodo;
    }

    /**
     * Define el valor de la propiedad respuestaMetodo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}
     *     
     */
    public void setRespuestaMetodo(JAXBElement<RespuestaMetodo> value) {
        this.respuestaMetodo = value;
    }

}
