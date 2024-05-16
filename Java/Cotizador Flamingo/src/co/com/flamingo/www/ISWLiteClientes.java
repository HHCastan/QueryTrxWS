/**
 * ISWLiteClientes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.flamingo.www;

public interface ISWLiteClientes extends java.rmi.Remote {
    public co.com.flamingo.www.contratos.ValidacionDatosClienteRes validarClienteSafix(java.lang.String pTipoIdentificacion, java.lang.String pIdentificacion, java.util.Calendar pFechaNacimiento, java.util.Calendar pFechaExpedicion) throws java.rmi.RemoteException;
    public co.com.flamingo.www._2018._06.RespuestaMetodo actualizarClienteSafix(java.lang.String pTipoIdentificacion, java.lang.String pIdentificacion, java.lang.Integer pPais, java.lang.Integer pDepartamento, java.lang.Integer pCiudad, java.lang.Integer pBarrio, java.lang.String pDireccion, java.lang.String pTipoTelefono1, java.lang.String pTelefono1, java.lang.String pTipoTelefono2, java.lang.String pTelefono2, java.lang.String pCorreoElectronico, java.lang.String pOcupacion, java.lang.String pCargo, java.lang.String pTipoContrato, java.lang.String pActividad, java.lang.String pPEPS, java.lang.String pUsuarioModifica, java.util.Calendar pFechaModifica) throws java.rmi.RemoteException;
}
