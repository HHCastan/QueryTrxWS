/**
 * WSCASBServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package co.com.bytte.casb;


/**
 *  WSCASBServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class WSCASBServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public WSCASBServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public WSCASBServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for consultaClienteImagen method
     * override this method for handling normal response from consultaClienteImagen operation
     */
    public void receiveResultconsultaClienteImagen(
        co.com.bytte.casb.ConsultaClienteImagenResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultaClienteImagen operation
     */
    public void receiveErrorconsultaClienteImagen(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for processaLogCliente method
     * override this method for handling normal response from processaLogCliente operation
     */
    public void receiveResultprocessaLogCliente(
        co.com.bytte.casb.ProcessaLogClienteResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from processaLogCliente operation
     */
    public void receiveErrorprocessaLogCliente(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for processaHuella method
     * override this method for handling normal response from processaHuella operation
     */
    public void receiveResultprocessaHuella(
        co.com.bytte.casb.ProcessaHuellaResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from processaHuella operation
     */
    public void receiveErrorprocessaHuella(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for initWs method
     * override this method for handling normal response from initWs operation
     */
    public void receiveResultinitWs(
        co.com.bytte.casb.InitWsResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from initWs operation
     */
    public void receiveErrorinitWs(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultaCliente method
     * override this method for handling normal response from consultaCliente operation
     */
    public void receiveResultconsultaCliente(
        co.com.bytte.casb.ConsultaClienteResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultaCliente operation
     */
    public void receiveErrorconsultaCliente(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultaLogCliente method
     * override this method for handling normal response from consultaLogCliente operation
     */
    public void receiveResultconsultaLogCliente(
        co.com.bytte.casb.ConsultaLogClienteResponseDocument result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultaLogCliente operation
     */
    public void receiveErrorconsultaLogCliente(java.lang.Exception e) {
    }
}
