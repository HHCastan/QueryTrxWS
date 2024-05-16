
package co.com.flamingo.clienteRetanqueo;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.flamingo.clienteRetanqueo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InfoClienteBasica_QNAME = new QName("http://www.flamingo.com.co", "infoClienteBasica");
    private final static QName _ClienteCer_QNAME = new QName("http://www.flamingo.com.co", "ClienteCer");
    private final static QName _ArrayOfPlanPagosDigital_QNAME = new QName("http://www.flamingo.com.co", "ArrayOfPlanPagosDigital");
    private final static QName _PlanPagosDigital_QNAME = new QName("http://www.flamingo.com.co", "PlanPagosDigital");
    private final static QName _ArrayOfInfoSimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "ArrayOfInfoSimulacionCuota");
    private final static QName _ArrayOfPlanPagos_QNAME = new QName("http://www.flamingo.com.co", "ArrayOfPlanPagos");
    private final static QName _ConsultarSaldoNugRes_QNAME = new QName("http://www.flamingo.com.co", "ConsultarSaldoNugRes");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _RetanqueoActualizarRes_QNAME = new QName("http://www.flamingo.com.co", "RetanqueoActualizarRes");
    private final static QName _RespuestaMetodo_QNAME = new QName("http://www.flamingo.com.co", "RespuestaMetodo");
    private final static QName _SeguroConsultar_QNAME = new QName("http://www.flamingo.com.co", "SeguroConsultar");
    private final static QName _ConsumoTarjeta_QNAME = new QName("http://www.flamingo.com.co", "ConsumoTarjeta");
    private final static QName _TokenRes_QNAME = new QName("http://www.flamingo.com.co", "TokenRes");
    private final static QName _ConsumoTarjetaRes_QNAME = new QName("http://www.flamingo.com.co", "ConsumoTarjetaRes");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _InfoActualizarRetanqueo_QNAME = new QName("http://www.flamingo.com.co", "InfoActualizarRetanqueo");
    private final static QName _SimularPlanPagosRes_QNAME = new QName("http://www.flamingo.com.co", "SimularPlanPagosRes");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _SimulacionCuotaModalidad_QNAME = new QName("http://www.flamingo.com.co", "SimulacionCuotaModalidad");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _GrabarSolicitudRes_QNAME = new QName("http://www.flamingo.com.co", "GrabarSolicitudRes");
    private final static QName _InfoSimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "InfoSimulacionCuota");
    private final static QName _SimularCuotaModalidadRes_QNAME = new QName("http://www.flamingo.com.co", "SimularCuotaModalidadRes");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _InfoClienteNug_QNAME = new QName("http://www.flamingo.com.co", "infoClienteNug");
    private final static QName _ConsultarSegurosRes_QNAME = new QName("http://www.flamingo.com.co", "ConsultarSegurosRes");
    private final static QName _DesbloquearDocumentoDigitalRes_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearDocumentoDigitalRes");
    private final static QName _AprobacionConsultar_QNAME = new QName("http://www.flamingo.com.co", "AprobacionConsultar");
    private final static QName _InfoCreditoDigital_QNAME = new QName("http://www.flamingo.com.co", "infoCreditoDigital");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Aprobacion_QNAME = new QName("http://www.flamingo.com.co", "Aprobacion");
    private final static QName _ClienteActualizar_QNAME = new QName("http://www.flamingo.com.co", "ClienteActualizar");
    private final static QName _ConsultarAprobacionRes_QNAME = new QName("http://www.flamingo.com.co", "ConsultarAprobacionRes");
    private final static QName _InfoRetanqueo_QNAME = new QName("http://www.flamingo.com.co", "infoRetanqueo");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _MensajeSimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "MensajeSimulacionCuota");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _InfoAprobacion_QNAME = new QName("http://www.flamingo.com.co", "infoAprobacion");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _PlanPagos_QNAME = new QName("http://www.flamingo.com.co", "PlanPagos");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _InfoAprobacionDigital_QNAME = new QName("http://www.flamingo.com.co", "InfoAprobacionDigital");
    private final static QName _ClienteConsultar_QNAME = new QName("http://www.flamingo.com.co", "ClienteConsultar");
    private final static QName _SimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "SimulacionCuota");
    private final static QName _CrearAprobacionRes_QNAME = new QName("http://www.flamingo.com.co", "CrearAprobacionRes");
    private final static QName _ArrayOfSeguroConsultar_QNAME = new QName("http://www.flamingo.com.co", "ArrayOfSeguroConsultar");
    private final static QName _SimularCuotaRes_QNAME = new QName("http://www.flamingo.com.co", "SimularCuotaRes");
    private final static QName _TarjetaEcommerce_QNAME = new QName("http://www.flamingo.com.co", "TarjetaEcommerce");
    private final static QName _DesbloquearDigitalRes_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearDigitalRes");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Autenticacion_QNAME = new QName("http://www.flamingo.com.co", "Autenticacion");
    private final static QName _InfoCredito_QNAME = new QName("http://www.flamingo.com.co", "infoCredito");
    private final static QName _AprobacionDigitalRes_QNAME = new QName("http://www.flamingo.com.co", "AprobacionDigitalRes");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _DesbloquearAprobacionRes_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearAprobacionRes");
    private final static QName _ConsultarPlanPagosRes_QNAME = new QName("http://www.flamingo.com.co", "ConsultarPlanPagosRes");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _ConsultarClienteRes_QNAME = new QName("http://www.flamingo.com.co", "ConsultarClienteRes");
    private final static QName _CustodiaDocumentosRes_QNAME = new QName("http://www.flamingo.com.co", "CustodiaDocumentosRes");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _CrearTarjetaEcommerceRes_QNAME = new QName("http://www.flamingo.com.co", "CrearTarjetaEcommerceRes");
    private final static QName _Aliado_QNAME = new QName("http://www.flamingo.com.co", "Aliado");
    private final static QName _RetanqueoRes_QNAME = new QName("http://www.flamingo.com.co", "RetanqueoRes");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _SimularPlanPagosDigitalesRes_QNAME = new QName("http://www.flamingo.com.co", "SimularPlanPagosDigitalesRes");
    private final static QName _ClienteActualizarIDCliente_QNAME = new QName("http://www.flamingo.com.co", "IDCliente");
    private final static QName _ClienteActualizarUsuario_QNAME = new QName("http://www.flamingo.com.co", "Usuario");
    private final static QName _ClienteActualizarNombreProducto_QNAME = new QName("http://www.flamingo.com.co", "NombreProducto");
    private final static QName _ClienteActualizarTipoIdCliente_QNAME = new QName("http://www.flamingo.com.co", "TipoIdCliente");
    private final static QName _CrearAprobacionResponseCrearAprobacionResult_QNAME = new QName("http://www.flamingo.com.co", "CrearAprobacionResult");
    private final static QName _AliadoIdAliado_QNAME = new QName("http://www.flamingo.com.co", "IdAliado");
    private final static QName _AliadoTipoIdAliado_QNAME = new QName("http://www.flamingo.com.co", "TipoIdAliado");
    private final static QName _TarjetaEcommerceNumeroTarjeta_QNAME = new QName("http://www.flamingo.com.co", "NumeroTarjeta");
    private final static QName _TarjetaEcommerceCodigoZona_QNAME = new QName("http://www.flamingo.com.co", "CodigoZona");
    private final static QName _TarjetaEcommerceIdTransaccion_QNAME = new QName("http://www.flamingo.com.co", "IdTransaccion");
    private final static QName _TarjetaEcommerceCodigoCliente_QNAME = new QName("http://www.flamingo.com.co", "CodigoCliente");
    private final static QName _ConsultarSegurosResDatosConsultarSeguros_QNAME = new QName("http://www.flamingo.com.co", "DatosConsultarSeguros");
    private final static QName _CrearTarjetaEcommerceResponseCrearTarjetaEcommerceResult_QNAME = new QName("http://www.flamingo.com.co", "CrearTarjetaEcommerceResult");
    private final static QName _SeguroConsultarCodSeguro_QNAME = new QName("http://www.flamingo.com.co", "CodSeguro");
    private final static QName _SeguroConsultarNomSeguro_QNAME = new QName("http://www.flamingo.com.co", "NomSeguro");
    private final static QName _InfoCreditoDigitalModalidad_QNAME = new QName("http://www.flamingo.com.co", "Modalidad");
    private final static QName _InfoCreditoDigitalEvento_QNAME = new QName("http://www.flamingo.com.co", "Evento");
    private final static QName _InfoCreditoDigitalDireccionZona_QNAME = new QName("http://www.flamingo.com.co", "DireccionZona");
    private final static QName _InfoCreditoDigitalOtorgadoPor_QNAME = new QName("http://www.flamingo.com.co", "OtorgadoPor");
    private final static QName _InfoCreditoDigitalFechaPago_QNAME = new QName("http://www.flamingo.com.co", "FechaPago");
    private final static QName _InfoCreditoDigitalIdCliente_QNAME = new QName("http://www.flamingo.com.co", "IdCliente");
    private final static QName _InfoCreditoDigitalNombreZona_QNAME = new QName("http://www.flamingo.com.co", "NombreZona");
    private final static QName _InfoCreditoDigitalNumeroCredito_QNAME = new QName("http://www.flamingo.com.co", "NumeroCredito");
    private final static QName _InfoCreditoDigitalFechaGeneracion_QNAME = new QName("http://www.flamingo.com.co", "FechaGeneracion");
    private final static QName _InfoCreditoDigitalTipoCredito_QNAME = new QName("http://www.flamingo.com.co", "TipoCredito");
    private final static QName _InfoCreditoDigitalNombreCliente_QNAME = new QName("http://www.flamingo.com.co", "NombreCliente");
    private final static QName _GenerarTokenResponseGenerarTokenResult_QNAME = new QName("http://www.flamingo.com.co", "GenerarTokenResult");
    private final static QName _ConsumoTarjetaEcommerceResponseConsumoTarjetaEcommerceResult_QNAME = new QName("http://www.flamingo.com.co", "ConsumoTarjetaEcommerceResult");
    private final static QName _ConsumoTarjetaAlmacenPOS_QNAME = new QName("http://www.flamingo.com.co", "AlmacenPOS");
    private final static QName _AprobacionDigitalPFormaPago_QNAME = new QName("http://www.flamingo.com.co", "pFormaPago");
    private final static QName _AprobacionDigitalPNumeroCelular_QNAME = new QName("http://www.flamingo.com.co", "pNumeroCelular");
    private final static QName _AprobacionDigitalPTipoIdCliente_QNAME = new QName("http://www.flamingo.com.co", "pTipoIdCliente");
    private final static QName _AprobacionDigitalPSolicitud_QNAME = new QName("http://www.flamingo.com.co", "pSolicitud");
    private final static QName _AprobacionDigitalPEmail_QNAME = new QName("http://www.flamingo.com.co", "pEmail");
    private final static QName _AprobacionDigitalPEstadoAprobacion_QNAME = new QName("http://www.flamingo.com.co", "pEstadoAprobacion");
    private final static QName _AprobacionDigitalPIdCliente_QNAME = new QName("http://www.flamingo.com.co", "pIdCliente");
    private final static QName _AprobacionDigitalPSucursal_QNAME = new QName("http://www.flamingo.com.co", "pSucursal");
    private final static QName _AprobacionDigitalPCodigoZona_QNAME = new QName("http://www.flamingo.com.co", "pCodigoZona");
    private final static QName _AprobacionDigitalPSeguro_QNAME = new QName("http://www.flamingo.com.co", "pSeguro");
    private final static QName _AprobacionDigitalPAfianzadora_QNAME = new QName("http://www.flamingo.com.co", "pAfianzadora");
    private final static QName _AprobacionDigitalPTerminal_QNAME = new QName("http://www.flamingo.com.co", "pTerminal");
    private final static QName _AprobacionDigitalPCedulaVendedor_QNAME = new QName("http://www.flamingo.com.co", "pCedulaVendedor");
    private final static QName _AprobacionDigitalPCodigoSeguro_QNAME = new QName("http://www.flamingo.com.co", "pCodigoSeguro");
    private final static QName _AprobacionDigitalPDireccionEmail_QNAME = new QName("http://www.flamingo.com.co", "pDireccionEmail");
    private final static QName _AprobacionDigitalPNug_QNAME = new QName("http://www.flamingo.com.co", "pNug");
    private final static QName _AprobacionDigitalPCelular_QNAME = new QName("http://www.flamingo.com.co", "pCelular");
    private final static QName _AutenticacionToken_QNAME = new QName("http://www.flamingo.com.co", "Token");
    private final static QName _AutenticacionContrasena_QNAME = new QName("http://www.flamingo.com.co", "Contrasena");
    private final static QName _TraerDatosServidorResponseTraerDatosServidorResult_QNAME = new QName("http://www.flamingo.com.co", "TraerDatosServidorResult");
    private final static QName _ConsultarRetanqueoResponseConsultarRetanqueoResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarRetanqueoResult");
    private final static QName _MensajeSimulacionCuotaTextoRetorno_QNAME = new QName("http://www.flamingo.com.co", "TextoRetorno");
    private final static QName _CustodiaDocumentosResponseCustodiaDocumentosResult_QNAME = new QName("http://www.flamingo.com.co", "CustodiaDocumentosResult");
    private final static QName _ActualizarRetanqueoResponseActualizarRetanqueoResult_QNAME = new QName("http://www.flamingo.com.co", "ActualizarRetanqueoResult");
    private final static QName _GrabarSolicitudPOrigen_QNAME = new QName("http://www.flamingo.com.co", "pOrigen");
    private final static QName _GrabarSolicitudPCodigoCanal_QNAME = new QName("http://www.flamingo.com.co", "pCodigoCanal");
    private final static QName _GrabarSolicitudPCliente_QNAME = new QName("http://www.flamingo.com.co", "pCliente");
    private final static QName _GrabarSolicitudPAliado_QNAME = new QName("http://www.flamingo.com.co", "pAliado");
    private final static QName _GrabarSolicitudPVendedor_QNAME = new QName("http://www.flamingo.com.co", "pVendedor");
    private final static QName _ConsumoTarjetaResDatosTarjeta_QNAME = new QName("http://www.flamingo.com.co", "DatosTarjeta");
    private final static QName _SimularCuotaModalidadResDatosSimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "DatosSimulacionCuota");
    private final static QName _SimularCuotaModalidadResMensajeSimulacion_QNAME = new QName("http://www.flamingo.com.co", "MensajeSimulacion");
    private final static QName _GrabarSolicitudResponseGrabarSolicitudResult_QNAME = new QName("http://www.flamingo.com.co", "GrabarSolicitudResult");
    private final static QName _SimulacionCuotaFormaPago_QNAME = new QName("http://www.flamingo.com.co", "FormaPago");
    private final static QName _SimulacionCuotaZona_QNAME = new QName("http://www.flamingo.com.co", "Zona");
    private final static QName _SimulacionCuotaCodigoAliado_QNAME = new QName("http://www.flamingo.com.co", "CodigoAliado");
    private final static QName _AprobacionDigitalResponseAprobacionDigitalResult_QNAME = new QName("http://www.flamingo.com.co", "AprobacionDigitalResult");
    private final static QName _CrearTarjetaEcommercePIngreso_QNAME = new QName("http://www.flamingo.com.co", "pIngreso");
    private final static QName _SimularCuotaModalidadPSimulacionCuota_QNAME = new QName("http://www.flamingo.com.co", "pSimulacionCuota");
    private final static QName _ConsultarAprobacionResDatosConsultarAprobacion_QNAME = new QName("http://www.flamingo.com.co", "DatosConsultarAprobacion");
    private final static QName _ActualizarNugResponseActualizarNugResult_QNAME = new QName("http://www.flamingo.com.co", "ActualizarNugResult");
    private final static QName _DesbloquearAprobacionPNumeroAprobacion_QNAME = new QName("http://www.flamingo.com.co", "pNumeroAprobacion");
    private final static QName _InfoAprobacionNombreAliado_QNAME = new QName("http://www.flamingo.com.co", "NombreAliado");
    private final static QName _InfoAprobacionAlmacen_QNAME = new QName("http://www.flamingo.com.co", "Almacen");
    private final static QName _InfoAprobacionNumeroAprobacion_QNAME = new QName("http://www.flamingo.com.co", "NumeroAprobacion");
    private final static QName _SimularCuotaModalidadResponseSimularCuotaModalidadResult_QNAME = new QName("http://www.flamingo.com.co", "SimularCuotaModalidadResult");
    private final static QName _InfoClienteNugCupoBloqueado_QNAME = new QName("http://www.flamingo.com.co", "CupoBloqueado");
    private final static QName _InfoClienteNugMotivoBloqueo_QNAME = new QName("http://www.flamingo.com.co", "MotivoBloqueo");
    private final static QName _AprobacionConsultarFechaVencimiento_QNAME = new QName("http://www.flamingo.com.co", "FechaVencimiento");
    private final static QName _AprobacionConsultarEventoMercadeo_QNAME = new QName("http://www.flamingo.com.co", "EventoMercadeo");
    private final static QName _AprobacionConsultarNomEventoCredito_QNAME = new QName("http://www.flamingo.com.co", "NomEventoCredito");
    private final static QName _AprobacionConsultarEstadoAprobacion_QNAME = new QName("http://www.flamingo.com.co", "EstadoAprobacion");
    private final static QName _AprobacionConsultarEstadoDigital_QNAME = new QName("http://www.flamingo.com.co", "EstadoDigital");
    private final static QName _AprobacionConsultarNomAliado_QNAME = new QName("http://www.flamingo.com.co", "NomAliado");
    private final static QName _AprobacionConsultarAfianzadora_QNAME = new QName("http://www.flamingo.com.co", "Afianzadora");
    private final static QName _AprobacionConsultarEventoCredito_QNAME = new QName("http://www.flamingo.com.co", "EventoCredito");
    private final static QName _AprobacionConsultarDigital_QNAME = new QName("http://www.flamingo.com.co", "Digital");
    private final static QName _AprobacionConsultarCanal_QNAME = new QName("http://www.flamingo.com.co", "Canal");
    private final static QName _AprobacionConsultarNombreSeguro_QNAME = new QName("http://www.flamingo.com.co", "NombreSeguro");
    private final static QName _AprobacionConsultarImpreso_QNAME = new QName("http://www.flamingo.com.co", "Impreso");
    private final static QName _AprobacionConsultarNombreModalidad_QNAME = new QName("http://www.flamingo.com.co", "NombreModalidad");
    private final static QName _AprobacionConsultarNomEventoMercadeo_QNAME = new QName("http://www.flamingo.com.co", "NomEventoMercadeo");
    private final static QName _AprobacionConsultarEcommerce_QNAME = new QName("http://www.flamingo.com.co", "Ecommerce");
    private final static QName _AprobacionConsultarCodigoSeguro_QNAME = new QName("http://www.flamingo.com.co", "CodigoSeguro");
    private final static QName _AprobacionConsultarFechaRegistro_QNAME = new QName("http://www.flamingo.com.co", "FechaRegistro");
    private final static QName _AprobacionDigitalResDatosAprobacionDigital_QNAME = new QName("http://www.flamingo.com.co", "DatosAprobacionDigital");
    private final static QName _ConsumoTarjetaEcommercePNumTarjeta_QNAME = new QName("http://www.flamingo.com.co", "pNumTarjeta");
    private final static QName _ConsumoTarjetaEcommercePIdAlmacenPOS_QNAME = new QName("http://www.flamingo.com.co", "pIdAlmacenPOS");
    private final static QName _ConsumoTarjetaEcommercePIDCliente_QNAME = new QName("http://www.flamingo.com.co", "pIDCliente");
    private final static QName _ConsumoTarjetaEcommercePIdTransaccion_QNAME = new QName("http://www.flamingo.com.co", "p_IdTransaccion");
    private final static QName _ConsultarSaldoNugResponseConsultarSaldoNugResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarSaldoNugResult");
    private final static QName _ConsultarPlanPagosResponseConsultarPlanPagosResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarPlanPagosResult");
    private final static QName _CrearAprobacionResDatosAprobacion_QNAME = new QName("http://www.flamingo.com.co", "DatosAprobacion");
    private final static QName _ConsultarAprobacionResponseConsultarAprobacionResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarAprobacionResult");
    private final static QName _InfoAprobacionDigitalCliente_QNAME = new QName("http://www.flamingo.com.co", "Cliente");
    private final static QName _InfoAprobacionDigitalZonaAlmacen_QNAME = new QName("http://www.flamingo.com.co", "ZonaAlmacen");
    private final static QName _InfoAprobacionDigitalNug_QNAME = new QName("http://www.flamingo.com.co", "Nug");
    private final static QName _GenerarTokenUser_QNAME = new QName("http://www.flamingo.com.co", "user");
    private final static QName _GenerarTokenPassword_QNAME = new QName("http://www.flamingo.com.co", "password");
    private final static QName _SimularPlanPagosDigitalesResponseSimularPlanPagosDigitalesResult_QNAME = new QName("http://www.flamingo.com.co", "SimularPlanPagosDigitalesResult");
    private final static QName _DesbloquearDocumentoDigitalResponseDesbloquearDocumentoDigitalResult_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearDocumentoDigitalResult");
    private final static QName _InfoRetanqueoCentralRiesgos_QNAME = new QName("http://www.flamingo.com.co", "CentralRiesgos");
    private final static QName _InfoClienteBasicaFirmaFGA_QNAME = new QName("http://www.flamingo.com.co", "FirmaFGA");
    private final static QName _InfoClienteBasicaFirmaNovAfianza_QNAME = new QName("http://www.flamingo.com.co", "FirmaNovAfianza");
    private final static QName _InfoClienteBasicaEmail_QNAME = new QName("http://www.flamingo.com.co", "Email");
    private final static QName _InfoClienteBasicaDocumentosCustodia_QNAME = new QName("http://www.flamingo.com.co", "DocumentosCustodia");
    private final static QName _InfoClienteBasicaActualizado_QNAME = new QName("http://www.flamingo.com.co", "Actualizado");
    private final static QName _InfoClienteBasicaCelular_QNAME = new QName("http://www.flamingo.com.co", "Celular");
    private final static QName _InfoClienteBasicaNomAfianzadora_QNAME = new QName("http://www.flamingo.com.co", "NomAfianzadora");
    private final static QName _InfoClienteBasicaDocumentacionImpresa_QNAME = new QName("http://www.flamingo.com.co", "DocumentacionImpresa");
    private final static QName _SimularCuotaPSimulacion_QNAME = new QName("http://www.flamingo.com.co", "pSimulacion");
    private final static QName _DesbloquearDigitalResponseDesbloquearDigitalResult_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearDigitalResult");
    private final static QName _AprobacionSucursalCliente_QNAME = new QName("http://www.flamingo.com.co", "SucursalCliente");
    private final static QName _AprobacionPeriodicidad_QNAME = new QName("http://www.flamingo.com.co", "Periodicidad");
    private final static QName _AprobacionCodigoOtp_QNAME = new QName("http://www.flamingo.com.co", "CodigoOtp");
    private final static QName _DesbloquearDigitalPEstado_QNAME = new QName("http://www.flamingo.com.co", "pEstado");
    private final static QName _ConsultarClienteResDatosCliente_QNAME = new QName("http://www.flamingo.com.co", "DatosCliente");
    private final static QName _ConsultarSaldoNugResDatosNug_QNAME = new QName("http://www.flamingo.com.co", "DatosNug");
    private final static QName _SimularPlanPagosResponseSimularPlanPagosResult_QNAME = new QName("http://www.flamingo.com.co", "SimularPlanPagosResult");
    private final static QName _ConsultarSegurosResponseConsultarSegurosResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarSegurosResult");
    private final static QName _RetanqueoResRetanqueo_QNAME = new QName("http://www.flamingo.com.co", "Retanqueo");
    private final static QName _SimularPlanPagosDigitalesResDatosCreditoDigital_QNAME = new QName("http://www.flamingo.com.co", "DatosCreditoDigital");
    private final static QName _CrearAprobacionPAprobacion_QNAME = new QName("http://www.flamingo.com.co", "pAprobacion");
    private final static QName _RespuestaMetodoMensajeRetorno_QNAME = new QName("http://www.flamingo.com.co", "MensajeRetorno");
    private final static QName _CustodiaDocumentosPUsuario_QNAME = new QName("http://www.flamingo.com.co", "pUsuario");
    private final static QName _ConsultarClienteResponseConsultarClienteResult_QNAME = new QName("http://www.flamingo.com.co", "ConsultarClienteResult");
    private final static QName _SimularPlanPagosResDatosCredito_QNAME = new QName("http://www.flamingo.com.co", "DatosCredito");
    private final static QName _SimularCuotaResponseSimularCuotaResult_QNAME = new QName("http://www.flamingo.com.co", "SimularCuotaResult");
    private final static QName _DesbloquearAprobacionResponseDesbloquearAprobacionResult_QNAME = new QName("http://www.flamingo.com.co", "DesbloquearAprobacionResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.flamingo.clienteRetanqueo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfoActualizarRetanqueo }
     * 
     */
    public InfoActualizarRetanqueo createInfoActualizarRetanqueo() {
        return new InfoActualizarRetanqueo();
    }

    /**
     * Create an instance of {@link SimularPlanPagosRes }
     * 
     */
    public SimularPlanPagosRes createSimularPlanPagosRes() {
        return new SimularPlanPagosRes();
    }

    /**
     * Create an instance of {@link SimularPlanPagos }
     * 
     */
    public SimularPlanPagos createSimularPlanPagos() {
        return new SimularPlanPagos();
    }

    /**
     * Create an instance of {@link Autenticacion }
     * 
     */
    public Autenticacion createAutenticacion() {
        return new Autenticacion();
    }

    /**
     * Create an instance of {@link DesbloquearDigitalResponse }
     * 
     */
    public DesbloquearDigitalResponse createDesbloquearDigitalResponse() {
        return new DesbloquearDigitalResponse();
    }

    /**
     * Create an instance of {@link DesbloquearDigitalRes }
     * 
     */
    public DesbloquearDigitalRes createDesbloquearDigitalRes() {
        return new DesbloquearDigitalRes();
    }

    /**
     * Create an instance of {@link SimulacionCuotaModalidad }
     * 
     */
    public SimulacionCuotaModalidad createSimulacionCuotaModalidad() {
        return new SimulacionCuotaModalidad();
    }

    /**
     * Create an instance of {@link TokenRes }
     * 
     */
    public TokenRes createTokenRes() {
        return new TokenRes();
    }

    /**
     * Create an instance of {@link ConsumoTarjeta }
     * 
     */
    public ConsumoTarjeta createConsumoTarjeta() {
        return new ConsumoTarjeta();
    }

    /**
     * Create an instance of {@link CrearAprobacion }
     * 
     */
    public CrearAprobacion createCrearAprobacion() {
        return new CrearAprobacion();
    }

    /**
     * Create an instance of {@link Aprobacion }
     * 
     */
    public Aprobacion createAprobacion() {
        return new Aprobacion();
    }

    /**
     * Create an instance of {@link ConsumoTarjetaRes }
     * 
     */
    public ConsumoTarjetaRes createConsumoTarjetaRes() {
        return new ConsumoTarjetaRes();
    }

    /**
     * Create an instance of {@link SimularCuotaModalidad }
     * 
     */
    public SimularCuotaModalidad createSimularCuotaModalidad() {
        return new SimularCuotaModalidad();
    }

    /**
     * Create an instance of {@link ActualizarNugResponse }
     * 
     */
    public ActualizarNugResponse createActualizarNugResponse() {
        return new ActualizarNugResponse();
    }

    /**
     * Create an instance of {@link ConsultarSaldoNugRes }
     * 
     */
    public ConsultarSaldoNugRes createConsultarSaldoNugRes() {
        return new ConsultarSaldoNugRes();
    }

    /**
     * Create an instance of {@link GenerarTokenResponse }
     * 
     */
    public GenerarTokenResponse createGenerarTokenResponse() {
        return new GenerarTokenResponse();
    }

    /**
     * Create an instance of {@link SimularPlanPagosDigitalesResponse }
     * 
     */
    public SimularPlanPagosDigitalesResponse createSimularPlanPagosDigitalesResponse() {
        return new SimularPlanPagosDigitalesResponse();
    }

    /**
     * Create an instance of {@link SimularPlanPagosDigitalesRes }
     * 
     */
    public SimularPlanPagosDigitalesRes createSimularPlanPagosDigitalesRes() {
        return new SimularPlanPagosDigitalesRes();
    }

    /**
     * Create an instance of {@link SeguroConsultar }
     * 
     */
    public SeguroConsultar createSeguroConsultar() {
        return new SeguroConsultar();
    }

    /**
     * Create an instance of {@link RetanqueoActualizarRes }
     * 
     */
    public RetanqueoActualizarRes createRetanqueoActualizarRes() {
        return new RetanqueoActualizarRes();
    }

    /**
     * Create an instance of {@link RespuestaMetodo }
     * 
     */
    public RespuestaMetodo createRespuestaMetodo() {
        return new RespuestaMetodo();
    }

    /**
     * Create an instance of {@link ClienteCer }
     * 
     */
    public ClienteCer createClienteCer() {
        return new ClienteCer();
    }

    /**
     * Create an instance of {@link SimularPlanPagosDigitales }
     * 
     */
    public SimularPlanPagosDigitales createSimularPlanPagosDigitales() {
        return new SimularPlanPagosDigitales();
    }

    /**
     * Create an instance of {@link ConsultarCliente }
     * 
     */
    public ConsultarCliente createConsultarCliente() {
        return new ConsultarCliente();
    }

    /**
     * Create an instance of {@link ClienteConsultar }
     * 
     */
    public ClienteConsultar createClienteConsultar() {
        return new ClienteConsultar();
    }

    /**
     * Create an instance of {@link ConsumoTarjetaEcommerce }
     * 
     */
    public ConsumoTarjetaEcommerce createConsumoTarjetaEcommerce() {
        return new ConsumoTarjetaEcommerce();
    }

    /**
     * Create an instance of {@link InfoClienteBasica }
     * 
     */
    public InfoClienteBasica createInfoClienteBasica() {
        return new InfoClienteBasica();
    }

    /**
     * Create an instance of {@link ArrayOfPlanPagos }
     * 
     */
    public ArrayOfPlanPagos createArrayOfPlanPagos() {
        return new ArrayOfPlanPagos();
    }

    /**
     * Create an instance of {@link ConsumoTarjetaEcommerceResponse }
     * 
     */
    public ConsumoTarjetaEcommerceResponse createConsumoTarjetaEcommerceResponse() {
        return new ConsumoTarjetaEcommerceResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPlanPagosDigital }
     * 
     */
    public ArrayOfPlanPagosDigital createArrayOfPlanPagosDigital() {
        return new ArrayOfPlanPagosDigital();
    }

    /**
     * Create an instance of {@link PlanPagosDigital }
     * 
     */
    public PlanPagosDigital createPlanPagosDigital() {
        return new PlanPagosDigital();
    }

    /**
     * Create an instance of {@link TraerDatosServidor }
     * 
     */
    public TraerDatosServidor createTraerDatosServidor() {
        return new TraerDatosServidor();
    }

    /**
     * Create an instance of {@link ArrayOfInfoSimulacionCuota }
     * 
     */
    public ArrayOfInfoSimulacionCuota createArrayOfInfoSimulacionCuota() {
        return new ArrayOfInfoSimulacionCuota();
    }

    /**
     * Create an instance of {@link CustodiaDocumentos }
     * 
     */
    public CustodiaDocumentos createCustodiaDocumentos() {
        return new CustodiaDocumentos();
    }

    /**
     * Create an instance of {@link ClienteActualizar }
     * 
     */
    public ClienteActualizar createClienteActualizar() {
        return new ClienteActualizar();
    }

    /**
     * Create an instance of {@link ConsultarAprobacionResponse }
     * 
     */
    public ConsultarAprobacionResponse createConsultarAprobacionResponse() {
        return new ConsultarAprobacionResponse();
    }

    /**
     * Create an instance of {@link ConsultarAprobacionRes }
     * 
     */
    public ConsultarAprobacionRes createConsultarAprobacionRes() {
        return new ConsultarAprobacionRes();
    }

    /**
     * Create an instance of {@link AprobacionDigitalResponse }
     * 
     */
    public AprobacionDigitalResponse createAprobacionDigitalResponse() {
        return new AprobacionDigitalResponse();
    }

    /**
     * Create an instance of {@link AprobacionDigitalRes }
     * 
     */
    public AprobacionDigitalRes createAprobacionDigitalRes() {
        return new AprobacionDigitalRes();
    }

    /**
     * Create an instance of {@link MensajeSimulacionCuota }
     * 
     */
    public MensajeSimulacionCuota createMensajeSimulacionCuota() {
        return new MensajeSimulacionCuota();
    }

    /**
     * Create an instance of {@link InfoRetanqueo }
     * 
     */
    public InfoRetanqueo createInfoRetanqueo() {
        return new InfoRetanqueo();
    }

    /**
     * Create an instance of {@link DesbloquearDocumentoDigital }
     * 
     */
    public DesbloquearDocumentoDigital createDesbloquearDocumentoDigital() {
        return new DesbloquearDocumentoDigital();
    }

    /**
     * Create an instance of {@link ConsultarAprobacion }
     * 
     */
    public ConsultarAprobacion createConsultarAprobacion() {
        return new ConsultarAprobacion();
    }

    /**
     * Create an instance of {@link SimularCuotaModalidadResponse }
     * 
     */
    public SimularCuotaModalidadResponse createSimularCuotaModalidadResponse() {
        return new SimularCuotaModalidadResponse();
    }

    /**
     * Create an instance of {@link SimularCuotaModalidadRes }
     * 
     */
    public SimularCuotaModalidadRes createSimularCuotaModalidadRes() {
        return new SimularCuotaModalidadRes();
    }

    /**
     * Create an instance of {@link GenerarToken }
     * 
     */
    public GenerarToken createGenerarToken() {
        return new GenerarToken();
    }

    /**
     * Create an instance of {@link Aliado }
     * 
     */
    public Aliado createAliado() {
        return new Aliado();
    }

    /**
     * Create an instance of {@link DesbloquearAprobacion }
     * 
     */
    public DesbloquearAprobacion createDesbloquearAprobacion() {
        return new DesbloquearAprobacion();
    }

    /**
     * Create an instance of {@link InfoCreditoDigital }
     * 
     */
    public InfoCreditoDigital createInfoCreditoDigital() {
        return new InfoCreditoDigital();
    }

    /**
     * Create an instance of {@link ConsultarPlanPagos }
     * 
     */
    public ConsultarPlanPagos createConsultarPlanPagos() {
        return new ConsultarPlanPagos();
    }

    /**
     * Create an instance of {@link ConsultarRetanqueo }
     * 
     */
    public ConsultarRetanqueo createConsultarRetanqueo() {
        return new ConsultarRetanqueo();
    }

    /**
     * Create an instance of {@link ActualizarNug }
     * 
     */
    public ActualizarNug createActualizarNug() {
        return new ActualizarNug();
    }

    /**
     * Create an instance of {@link InfoClienteNug }
     * 
     */
    public InfoClienteNug createInfoClienteNug() {
        return new InfoClienteNug();
    }

    /**
     * Create an instance of {@link ConsultarSegurosRes }
     * 
     */
    public ConsultarSegurosRes createConsultarSegurosRes() {
        return new ConsultarSegurosRes();
    }

    /**
     * Create an instance of {@link DesbloquearDocumentoDigitalRes }
     * 
     */
    public DesbloquearDocumentoDigitalRes createDesbloquearDocumentoDigitalRes() {
        return new DesbloquearDocumentoDigitalRes();
    }

    /**
     * Create an instance of {@link AprobacionConsultar }
     * 
     */
    public AprobacionConsultar createAprobacionConsultar() {
        return new AprobacionConsultar();
    }

    /**
     * Create an instance of {@link SimularCuotaResponse }
     * 
     */
    public SimularCuotaResponse createSimularCuotaResponse() {
        return new SimularCuotaResponse();
    }

    /**
     * Create an instance of {@link SimularCuotaRes }
     * 
     */
    public SimularCuotaRes createSimularCuotaRes() {
        return new SimularCuotaRes();
    }

    /**
     * Create an instance of {@link CrearAprobacionResponse }
     * 
     */
    public CrearAprobacionResponse createCrearAprobacionResponse() {
        return new CrearAprobacionResponse();
    }

    /**
     * Create an instance of {@link CrearAprobacionRes }
     * 
     */
    public CrearAprobacionRes createCrearAprobacionRes() {
        return new CrearAprobacionRes();
    }

    /**
     * Create an instance of {@link GrabarSolicitudRes }
     * 
     */
    public GrabarSolicitudRes createGrabarSolicitudRes() {
        return new GrabarSolicitudRes();
    }

    /**
     * Create an instance of {@link InfoSimulacionCuota }
     * 
     */
    public InfoSimulacionCuota createInfoSimulacionCuota() {
        return new InfoSimulacionCuota();
    }

    /**
     * Create an instance of {@link DesbloquearDigital }
     * 
     */
    public DesbloquearDigital createDesbloquearDigital() {
        return new DesbloquearDigital();
    }

    /**
     * Create an instance of {@link CustodiaDocumentosResponse }
     * 
     */
    public CustodiaDocumentosResponse createCustodiaDocumentosResponse() {
        return new CustodiaDocumentosResponse();
    }

    /**
     * Create an instance of {@link CustodiaDocumentosRes }
     * 
     */
    public CustodiaDocumentosRes createCustodiaDocumentosRes() {
        return new CustodiaDocumentosRes();
    }

    /**
     * Create an instance of {@link InfoCredito }
     * 
     */
    public InfoCredito createInfoCredito() {
        return new InfoCredito();
    }

    /**
     * Create an instance of {@link ConsultarSaldoNugResponse }
     * 
     */
    public ConsultarSaldoNugResponse createConsultarSaldoNugResponse() {
        return new ConsultarSaldoNugResponse();
    }

    /**
     * Create an instance of {@link DesbloquearAprobacionRes }
     * 
     */
    public DesbloquearAprobacionRes createDesbloquearAprobacionRes() {
        return new DesbloquearAprobacionRes();
    }

    /**
     * Create an instance of {@link ActualizarRetanqueo }
     * 
     */
    public ActualizarRetanqueo createActualizarRetanqueo() {
        return new ActualizarRetanqueo();
    }

    /**
     * Create an instance of {@link SimularPlanPagosResponse }
     * 
     */
    public SimularPlanPagosResponse createSimularPlanPagosResponse() {
        return new SimularPlanPagosResponse();
    }

    /**
     * Create an instance of {@link TarjetaEcommerce }
     * 
     */
    public TarjetaEcommerce createTarjetaEcommerce() {
        return new TarjetaEcommerce();
    }

    /**
     * Create an instance of {@link AprobacionDigital }
     * 
     */
    public AprobacionDigital createAprobacionDigital() {
        return new AprobacionDigital();
    }

    /**
     * Create an instance of {@link ConsultarClienteResponse }
     * 
     */
    public ConsultarClienteResponse createConsultarClienteResponse() {
        return new ConsultarClienteResponse();
    }

    /**
     * Create an instance of {@link ConsultarClienteRes }
     * 
     */
    public ConsultarClienteRes createConsultarClienteRes() {
        return new ConsultarClienteRes();
    }

    /**
     * Create an instance of {@link SimulacionCuota }
     * 
     */
    public SimulacionCuota createSimulacionCuota() {
        return new SimulacionCuota();
    }

    /**
     * Create an instance of {@link ArrayOfSeguroConsultar }
     * 
     */
    public ArrayOfSeguroConsultar createArrayOfSeguroConsultar() {
        return new ArrayOfSeguroConsultar();
    }

    /**
     * Create an instance of {@link CrearTarjetaEcommerceResponse }
     * 
     */
    public CrearTarjetaEcommerceResponse createCrearTarjetaEcommerceResponse() {
        return new CrearTarjetaEcommerceResponse();
    }

    /**
     * Create an instance of {@link CrearTarjetaEcommerceRes }
     * 
     */
    public CrearTarjetaEcommerceRes createCrearTarjetaEcommerceRes() {
        return new CrearTarjetaEcommerceRes();
    }

    /**
     * Create an instance of {@link InfoAprobacion }
     * 
     */
    public InfoAprobacion createInfoAprobacion() {
        return new InfoAprobacion();
    }

    /**
     * Create an instance of {@link ConsultarSeguros }
     * 
     */
    public ConsultarSeguros createConsultarSeguros() {
        return new ConsultarSeguros();
    }

    /**
     * Create an instance of {@link TraerDatosServidorResponse }
     * 
     */
    public TraerDatosServidorResponse createTraerDatosServidorResponse() {
        return new TraerDatosServidorResponse();
    }

    /**
     * Create an instance of {@link PlanPagos }
     * 
     */
    public PlanPagos createPlanPagos() {
        return new PlanPagos();
    }

    /**
     * Create an instance of {@link DesbloquearDocumentoDigitalResponse }
     * 
     */
    public DesbloquearDocumentoDigitalResponse createDesbloquearDocumentoDigitalResponse() {
        return new DesbloquearDocumentoDigitalResponse();
    }

    /**
     * Create an instance of {@link ConsultarSegurosResponse }
     * 
     */
    public ConsultarSegurosResponse createConsultarSegurosResponse() {
        return new ConsultarSegurosResponse();
    }

    /**
     * Create an instance of {@link InfoAprobacionDigital }
     * 
     */
    public InfoAprobacionDigital createInfoAprobacionDigital() {
        return new InfoAprobacionDigital();
    }

    /**
     * Create an instance of {@link GrabarSolicitud }
     * 
     */
    public GrabarSolicitud createGrabarSolicitud() {
        return new GrabarSolicitud();
    }

    /**
     * Create an instance of {@link ConsultarRetanqueoResponse }
     * 
     */
    public ConsultarRetanqueoResponse createConsultarRetanqueoResponse() {
        return new ConsultarRetanqueoResponse();
    }

    /**
     * Create an instance of {@link RetanqueoRes }
     * 
     */
    public RetanqueoRes createRetanqueoRes() {
        return new RetanqueoRes();
    }

    /**
     * Create an instance of {@link ConsultarSaldoNug }
     * 
     */
    public ConsultarSaldoNug createConsultarSaldoNug() {
        return new ConsultarSaldoNug();
    }

    /**
     * Create an instance of {@link DesbloquearAprobacionResponse }
     * 
     */
    public DesbloquearAprobacionResponse createDesbloquearAprobacionResponse() {
        return new DesbloquearAprobacionResponse();
    }

    /**
     * Create an instance of {@link CrearTarjetaEcommerce }
     * 
     */
    public CrearTarjetaEcommerce createCrearTarjetaEcommerce() {
        return new CrearTarjetaEcommerce();
    }

    /**
     * Create an instance of {@link ConsultarPlanPagosResponse }
     * 
     */
    public ConsultarPlanPagosResponse createConsultarPlanPagosResponse() {
        return new ConsultarPlanPagosResponse();
    }

    /**
     * Create an instance of {@link ConsultarPlanPagosRes }
     * 
     */
    public ConsultarPlanPagosRes createConsultarPlanPagosRes() {
        return new ConsultarPlanPagosRes();
    }

    /**
     * Create an instance of {@link SimularCuota }
     * 
     */
    public SimularCuota createSimularCuota() {
        return new SimularCuota();
    }

    /**
     * Create an instance of {@link GrabarSolicitudResponse }
     * 
     */
    public GrabarSolicitudResponse createGrabarSolicitudResponse() {
        return new GrabarSolicitudResponse();
    }

    /**
     * Create an instance of {@link ActualizarRetanqueoResponse }
     * 
     */
    public ActualizarRetanqueoResponse createActualizarRetanqueoResponse() {
        return new ActualizarRetanqueoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoClienteBasica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoClienteBasica")
    public JAXBElement<InfoClienteBasica> createInfoClienteBasica(InfoClienteBasica value) {
        return new JAXBElement<InfoClienteBasica>(_InfoClienteBasica_QNAME, InfoClienteBasica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteCer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ClienteCer")
    public JAXBElement<ClienteCer> createClienteCer(ClienteCer value) {
        return new JAXBElement<ClienteCer>(_ClienteCer_QNAME, ClienteCer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPlanPagosDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ArrayOfPlanPagosDigital")
    public JAXBElement<ArrayOfPlanPagosDigital> createArrayOfPlanPagosDigital(ArrayOfPlanPagosDigital value) {
        return new JAXBElement<ArrayOfPlanPagosDigital>(_ArrayOfPlanPagosDigital_QNAME, ArrayOfPlanPagosDigital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlanPagosDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "PlanPagosDigital")
    public JAXBElement<PlanPagosDigital> createPlanPagosDigital(PlanPagosDigital value) {
        return new JAXBElement<PlanPagosDigital>(_PlanPagosDigital_QNAME, PlanPagosDigital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfInfoSimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ArrayOfInfoSimulacionCuota")
    public JAXBElement<ArrayOfInfoSimulacionCuota> createArrayOfInfoSimulacionCuota(ArrayOfInfoSimulacionCuota value) {
        return new JAXBElement<ArrayOfInfoSimulacionCuota>(_ArrayOfInfoSimulacionCuota_QNAME, ArrayOfInfoSimulacionCuota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPlanPagos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ArrayOfPlanPagos")
    public JAXBElement<ArrayOfPlanPagos> createArrayOfPlanPagos(ArrayOfPlanPagos value) {
        return new JAXBElement<ArrayOfPlanPagos>(_ArrayOfPlanPagos_QNAME, ArrayOfPlanPagos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoNugRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarSaldoNugRes")
    public JAXBElement<ConsultarSaldoNugRes> createConsultarSaldoNugRes(ConsultarSaldoNugRes value) {
        return new JAXBElement<ConsultarSaldoNugRes>(_ConsultarSaldoNugRes_QNAME, ConsultarSaldoNugRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetanqueoActualizarRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RetanqueoActualizarRes")
    public JAXBElement<RetanqueoActualizarRes> createRetanqueoActualizarRes(RetanqueoActualizarRes value) {
        return new JAXBElement<RetanqueoActualizarRes>(_RetanqueoActualizarRes_QNAME, RetanqueoActualizarRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo")
    public JAXBElement<RespuestaMetodo> createRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeguroConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SeguroConsultar")
    public JAXBElement<SeguroConsultar> createSeguroConsultar(SeguroConsultar value) {
        return new JAXBElement<SeguroConsultar>(_SeguroConsultar_QNAME, SeguroConsultar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsumoTarjeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsumoTarjeta")
    public JAXBElement<ConsumoTarjeta> createConsumoTarjeta(ConsumoTarjeta value) {
        return new JAXBElement<ConsumoTarjeta>(_ConsumoTarjeta_QNAME, ConsumoTarjeta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TokenRes")
    public JAXBElement<TokenRes> createTokenRes(TokenRes value) {
        return new JAXBElement<TokenRes>(_TokenRes_QNAME, TokenRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsumoTarjetaRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsumoTarjetaRes")
    public JAXBElement<ConsumoTarjetaRes> createConsumoTarjetaRes(ConsumoTarjetaRes value) {
        return new JAXBElement<ConsumoTarjetaRes>(_ConsumoTarjetaRes_QNAME, ConsumoTarjetaRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoActualizarRetanqueo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "InfoActualizarRetanqueo")
    public JAXBElement<InfoActualizarRetanqueo> createInfoActualizarRetanqueo(InfoActualizarRetanqueo value) {
        return new JAXBElement<InfoActualizarRetanqueo>(_InfoActualizarRetanqueo_QNAME, InfoActualizarRetanqueo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularPlanPagosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularPlanPagosRes")
    public JAXBElement<SimularPlanPagosRes> createSimularPlanPagosRes(SimularPlanPagosRes value) {
        return new JAXBElement<SimularPlanPagosRes>(_SimularPlanPagosRes_QNAME, SimularPlanPagosRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulacionCuotaModalidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimulacionCuotaModalidad")
    public JAXBElement<SimulacionCuotaModalidad> createSimulacionCuotaModalidad(SimulacionCuotaModalidad value) {
        return new JAXBElement<SimulacionCuotaModalidad>(_SimulacionCuotaModalidad_QNAME, SimulacionCuotaModalidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrabarSolicitudRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "GrabarSolicitudRes")
    public JAXBElement<GrabarSolicitudRes> createGrabarSolicitudRes(GrabarSolicitudRes value) {
        return new JAXBElement<GrabarSolicitudRes>(_GrabarSolicitudRes_QNAME, GrabarSolicitudRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoSimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "InfoSimulacionCuota")
    public JAXBElement<InfoSimulacionCuota> createInfoSimulacionCuota(InfoSimulacionCuota value) {
        return new JAXBElement<InfoSimulacionCuota>(_InfoSimulacionCuota_QNAME, InfoSimulacionCuota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularCuotaModalidadRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularCuotaModalidadRes")
    public JAXBElement<SimularCuotaModalidadRes> createSimularCuotaModalidadRes(SimularCuotaModalidadRes value) {
        return new JAXBElement<SimularCuotaModalidadRes>(_SimularCuotaModalidadRes_QNAME, SimularCuotaModalidadRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoClienteNug }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoClienteNug")
    public JAXBElement<InfoClienteNug> createInfoClienteNug(InfoClienteNug value) {
        return new JAXBElement<InfoClienteNug>(_InfoClienteNug_QNAME, InfoClienteNug.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSegurosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarSegurosRes")
    public JAXBElement<ConsultarSegurosRes> createConsultarSegurosRes(ConsultarSegurosRes value) {
        return new JAXBElement<ConsultarSegurosRes>(_ConsultarSegurosRes_QNAME, ConsultarSegurosRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearDocumentoDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearDocumentoDigitalRes")
    public JAXBElement<DesbloquearDocumentoDigitalRes> createDesbloquearDocumentoDigitalRes(DesbloquearDocumentoDigitalRes value) {
        return new JAXBElement<DesbloquearDocumentoDigitalRes>(_DesbloquearDocumentoDigitalRes_QNAME, DesbloquearDocumentoDigitalRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprobacionConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "AprobacionConsultar")
    public JAXBElement<AprobacionConsultar> createAprobacionConsultar(AprobacionConsultar value) {
        return new JAXBElement<AprobacionConsultar>(_AprobacionConsultar_QNAME, AprobacionConsultar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoCreditoDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoCreditoDigital")
    public JAXBElement<InfoCreditoDigital> createInfoCreditoDigital(InfoCreditoDigital value) {
        return new JAXBElement<InfoCreditoDigital>(_InfoCreditoDigital_QNAME, InfoCreditoDigital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aprobacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Aprobacion")
    public JAXBElement<Aprobacion> createAprobacion(Aprobacion value) {
        return new JAXBElement<Aprobacion>(_Aprobacion_QNAME, Aprobacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteActualizar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ClienteActualizar")
    public JAXBElement<ClienteActualizar> createClienteActualizar(ClienteActualizar value) {
        return new JAXBElement<ClienteActualizar>(_ClienteActualizar_QNAME, ClienteActualizar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarAprobacionRes")
    public JAXBElement<ConsultarAprobacionRes> createConsultarAprobacionRes(ConsultarAprobacionRes value) {
        return new JAXBElement<ConsultarAprobacionRes>(_ConsultarAprobacionRes_QNAME, ConsultarAprobacionRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoRetanqueo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoRetanqueo")
    public JAXBElement<InfoRetanqueo> createInfoRetanqueo(InfoRetanqueo value) {
        return new JAXBElement<InfoRetanqueo>(_InfoRetanqueo_QNAME, InfoRetanqueo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MensajeSimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "MensajeSimulacionCuota")
    public JAXBElement<MensajeSimulacionCuota> createMensajeSimulacionCuota(MensajeSimulacionCuota value) {
        return new JAXBElement<MensajeSimulacionCuota>(_MensajeSimulacionCuota_QNAME, MensajeSimulacionCuota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoAprobacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoAprobacion")
    public JAXBElement<InfoAprobacion> createInfoAprobacion(InfoAprobacion value) {
        return new JAXBElement<InfoAprobacion>(_InfoAprobacion_QNAME, InfoAprobacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlanPagos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "PlanPagos")
    public JAXBElement<PlanPagos> createPlanPagos(PlanPagos value) {
        return new JAXBElement<PlanPagos>(_PlanPagos_QNAME, PlanPagos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoAprobacionDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "InfoAprobacionDigital")
    public JAXBElement<InfoAprobacionDigital> createInfoAprobacionDigital(InfoAprobacionDigital value) {
        return new JAXBElement<InfoAprobacionDigital>(_InfoAprobacionDigital_QNAME, InfoAprobacionDigital.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ClienteConsultar")
    public JAXBElement<ClienteConsultar> createClienteConsultar(ClienteConsultar value) {
        return new JAXBElement<ClienteConsultar>(_ClienteConsultar_QNAME, ClienteConsultar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimulacionCuota")
    public JAXBElement<SimulacionCuota> createSimulacionCuota(SimulacionCuota value) {
        return new JAXBElement<SimulacionCuota>(_SimulacionCuota_QNAME, SimulacionCuota.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CrearAprobacionRes")
    public JAXBElement<CrearAprobacionRes> createCrearAprobacionRes(CrearAprobacionRes value) {
        return new JAXBElement<CrearAprobacionRes>(_CrearAprobacionRes_QNAME, CrearAprobacionRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeguroConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ArrayOfSeguroConsultar")
    public JAXBElement<ArrayOfSeguroConsultar> createArrayOfSeguroConsultar(ArrayOfSeguroConsultar value) {
        return new JAXBElement<ArrayOfSeguroConsultar>(_ArrayOfSeguroConsultar_QNAME, ArrayOfSeguroConsultar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularCuotaRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularCuotaRes")
    public JAXBElement<SimularCuotaRes> createSimularCuotaRes(SimularCuotaRes value) {
        return new JAXBElement<SimularCuotaRes>(_SimularCuotaRes_QNAME, SimularCuotaRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TarjetaEcommerce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TarjetaEcommerce")
    public JAXBElement<TarjetaEcommerce> createTarjetaEcommerce(TarjetaEcommerce value) {
        return new JAXBElement<TarjetaEcommerce>(_TarjetaEcommerce_QNAME, TarjetaEcommerce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearDigitalRes")
    public JAXBElement<DesbloquearDigitalRes> createDesbloquearDigitalRes(DesbloquearDigitalRes value) {
        return new JAXBElement<DesbloquearDigitalRes>(_DesbloquearDigitalRes_QNAME, DesbloquearDigitalRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Autenticacion")
    public JAXBElement<Autenticacion> createAutenticacion(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_Autenticacion_QNAME, Autenticacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "infoCredito")
    public JAXBElement<InfoCredito> createInfoCredito(InfoCredito value) {
        return new JAXBElement<InfoCredito>(_InfoCredito_QNAME, InfoCredito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprobacionDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "AprobacionDigitalRes")
    public JAXBElement<AprobacionDigitalRes> createAprobacionDigitalRes(AprobacionDigitalRes value) {
        return new JAXBElement<AprobacionDigitalRes>(_AprobacionDigitalRes_QNAME, AprobacionDigitalRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearAprobacionRes")
    public JAXBElement<DesbloquearAprobacionRes> createDesbloquearAprobacionRes(DesbloquearAprobacionRes value) {
        return new JAXBElement<DesbloquearAprobacionRes>(_DesbloquearAprobacionRes_QNAME, DesbloquearAprobacionRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPlanPagosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarPlanPagosRes")
    public JAXBElement<ConsultarPlanPagosRes> createConsultarPlanPagosRes(ConsultarPlanPagosRes value) {
        return new JAXBElement<ConsultarPlanPagosRes>(_ConsultarPlanPagosRes_QNAME, ConsultarPlanPagosRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarClienteRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarClienteRes")
    public JAXBElement<ConsultarClienteRes> createConsultarClienteRes(ConsultarClienteRes value) {
        return new JAXBElement<ConsultarClienteRes>(_ConsultarClienteRes_QNAME, ConsultarClienteRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustodiaDocumentosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CustodiaDocumentosRes")
    public JAXBElement<CustodiaDocumentosRes> createCustodiaDocumentosRes(CustodiaDocumentosRes value) {
        return new JAXBElement<CustodiaDocumentosRes>(_CustodiaDocumentosRes_QNAME, CustodiaDocumentosRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearTarjetaEcommerceRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CrearTarjetaEcommerceRes")
    public JAXBElement<CrearTarjetaEcommerceRes> createCrearTarjetaEcommerceRes(CrearTarjetaEcommerceRes value) {
        return new JAXBElement<CrearTarjetaEcommerceRes>(_CrearTarjetaEcommerceRes_QNAME, CrearTarjetaEcommerceRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aliado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Aliado")
    public JAXBElement<Aliado> createAliado(Aliado value) {
        return new JAXBElement<Aliado>(_Aliado_QNAME, Aliado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetanqueoRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RetanqueoRes")
    public JAXBElement<RetanqueoRes> createRetanqueoRes(RetanqueoRes value) {
        return new JAXBElement<RetanqueoRes>(_RetanqueoRes_QNAME, RetanqueoRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularPlanPagosDigitalesRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularPlanPagosDigitalesRes")
    public JAXBElement<SimularPlanPagosDigitalesRes> createSimularPlanPagosDigitalesRes(SimularPlanPagosDigitalesRes value) {
        return new JAXBElement<SimularPlanPagosDigitalesRes>(_SimularPlanPagosDigitalesRes_QNAME, SimularPlanPagosDigitalesRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = ClienteActualizar.class)
    public JAXBElement<String> createClienteActualizarIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, ClienteActualizar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Usuario", scope = ClienteActualizar.class)
    public JAXBElement<String> createClienteActualizarUsuario(String value) {
        return new JAXBElement<String>(_ClienteActualizarUsuario_QNAME, String.class, ClienteActualizar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreProducto", scope = ClienteActualizar.class)
    public JAXBElement<String> createClienteActualizarNombreProducto(String value) {
        return new JAXBElement<String>(_ClienteActualizarNombreProducto_QNAME, String.class, ClienteActualizar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = ClienteActualizar.class)
    public JAXBElement<String> createClienteActualizarTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, ClienteActualizar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CrearAprobacionResult", scope = CrearAprobacionResponse.class)
    public JAXBElement<CrearAprobacionRes> createCrearAprobacionResponseCrearAprobacionResult(CrearAprobacionRes value) {
        return new JAXBElement<CrearAprobacionRes>(_CrearAprobacionResponseCrearAprobacionResult_QNAME, CrearAprobacionRes.class, CrearAprobacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdAliado", scope = Aliado.class)
    public JAXBElement<String> createAliadoIdAliado(String value) {
        return new JAXBElement<String>(_AliadoIdAliado_QNAME, String.class, Aliado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdAliado", scope = Aliado.class)
    public JAXBElement<String> createAliadoTipoIdAliado(String value) {
        return new JAXBElement<String>(_AliadoTipoIdAliado_QNAME, String.class, Aliado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroTarjeta", scope = TarjetaEcommerce.class)
    public JAXBElement<String> createTarjetaEcommerceNumeroTarjeta(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceNumeroTarjeta_QNAME, String.class, TarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoZona", scope = TarjetaEcommerce.class)
    public JAXBElement<String> createTarjetaEcommerceCodigoZona(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceCodigoZona_QNAME, String.class, TarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdTransaccion", scope = TarjetaEcommerce.class)
    public JAXBElement<String> createTarjetaEcommerceIdTransaccion(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceIdTransaccion_QNAME, String.class, TarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoCliente", scope = TarjetaEcommerce.class)
    public JAXBElement<String> createTarjetaEcommerceCodigoCliente(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceCodigoCliente_QNAME, String.class, TarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSeguroConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosConsultarSeguros", scope = ConsultarSegurosRes.class)
    public JAXBElement<ArrayOfSeguroConsultar> createConsultarSegurosResDatosConsultarSeguros(ArrayOfSeguroConsultar value) {
        return new JAXBElement<ArrayOfSeguroConsultar>(_ConsultarSegurosResDatosConsultarSeguros_QNAME, ArrayOfSeguroConsultar.class, ConsultarSegurosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsultarSegurosRes.class)
    public JAXBElement<RespuestaMetodo> createConsultarSegurosResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsultarSegurosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearTarjetaEcommerceRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CrearTarjetaEcommerceResult", scope = CrearTarjetaEcommerceResponse.class)
    public JAXBElement<CrearTarjetaEcommerceRes> createCrearTarjetaEcommerceResponseCrearTarjetaEcommerceResult(CrearTarjetaEcommerceRes value) {
        return new JAXBElement<CrearTarjetaEcommerceRes>(_CrearTarjetaEcommerceResponseCrearTarjetaEcommerceResult_QNAME, CrearTarjetaEcommerceRes.class, CrearTarjetaEcommerceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodSeguro", scope = SeguroConsultar.class)
    public JAXBElement<String> createSeguroConsultarCodSeguro(String value) {
        return new JAXBElement<String>(_SeguroConsultarCodSeguro_QNAME, String.class, SeguroConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NomSeguro", scope = SeguroConsultar.class)
    public JAXBElement<String> createSeguroConsultarNomSeguro(String value) {
        return new JAXBElement<String>(_SeguroConsultarNomSeguro_QNAME, String.class, SeguroConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Modalidad", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalModalidad(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalModalidad_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Evento", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalEvento(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalEvento_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DireccionZona", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalDireccionZona(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalDireccionZona_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "OtorgadoPor", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalOtorgadoPor(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalOtorgadoPor_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaPago", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalFechaPago(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalFechaPago_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdCliente", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalIdCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalIdCliente_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreZona", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalNombreZona(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreZona_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroCredito", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalNumeroCredito(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNumeroCredito_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaGeneracion", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalFechaGeneracion(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalFechaGeneracion_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoCredito", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalTipoCredito(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalTipoCredito_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreCliente", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalNombreCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreCliente_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoCreditoDigital.class)
    public JAXBElement<String> createInfoCreditoDigitalTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoCreditoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TokenRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "GenerarTokenResult", scope = GenerarTokenResponse.class)
    public JAXBElement<TokenRes> createGenerarTokenResponseGenerarTokenResult(TokenRes value) {
        return new JAXBElement<TokenRes>(_GenerarTokenResponseGenerarTokenResult_QNAME, TokenRes.class, GenerarTokenResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsumoTarjetaRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsumoTarjetaEcommerceResult", scope = ConsumoTarjetaEcommerceResponse.class)
    public JAXBElement<ConsumoTarjetaRes> createConsumoTarjetaEcommerceResponseConsumoTarjetaEcommerceResult(ConsumoTarjetaRes value) {
        return new JAXBElement<ConsumoTarjetaRes>(_ConsumoTarjetaEcommerceResponseConsumoTarjetaEcommerceResult_QNAME, ConsumoTarjetaRes.class, ConsumoTarjetaEcommerceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroTarjeta", scope = ConsumoTarjeta.class)
    public JAXBElement<String> createConsumoTarjetaNumeroTarjeta(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceNumeroTarjeta_QNAME, String.class, ConsumoTarjeta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "AlmacenPOS", scope = ConsumoTarjeta.class)
    public JAXBElement<String> createConsumoTarjetaAlmacenPOS(String value) {
        return new JAXBElement<String>(_ConsumoTarjetaAlmacenPOS_QNAME, String.class, ConsumoTarjeta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoCliente", scope = ConsumoTarjeta.class)
    public JAXBElement<String> createConsumoTarjetaCodigoCliente(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceCodigoCliente_QNAME, String.class, ConsumoTarjeta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pFormaPago", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPFormaPago(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPFormaPago_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroCelular", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPNumeroCelular(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPNumeroCelular_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSolicitud", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPSolicitud(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPSolicitud_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pEmail", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPEmail(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPEmail_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pEstadoAprobacion", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPEstadoAprobacion(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPEstadoAprobacion_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdCliente", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPIdCliente_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSucursal", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPSucursal(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPSucursal_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoZona", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPCodigoZona(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCodigoZona_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSeguro", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPSeguro(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPSeguro_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pAfianzadora", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPAfianzadora(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPAfianzadora_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTerminal", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPTerminal(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTerminal_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCedulaVendedor", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPCedulaVendedor(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCedulaVendedor_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoSeguro", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPCodigoSeguro(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCodigoSeguro_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pDireccionEmail", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPDireccionEmail(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPDireccionEmail_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNug", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPNug(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPNug_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCelular", scope = AprobacionDigital.class)
    public JAXBElement<String> createAprobacionDigitalPCelular(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCelular_QNAME, String.class, AprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdAliado", scope = Autenticacion.class)
    public JAXBElement<String> createAutenticacionIdAliado(String value) {
        return new JAXBElement<String>(_AliadoIdAliado_QNAME, String.class, Autenticacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Token", scope = Autenticacion.class)
    public JAXBElement<String> createAutenticacionToken(String value) {
        return new JAXBElement<String>(_AutenticacionToken_QNAME, String.class, Autenticacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Contrasena", scope = Autenticacion.class)
    public JAXBElement<String> createAutenticacionContrasena(String value) {
        return new JAXBElement<String>(_AutenticacionContrasena_QNAME, String.class, Autenticacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Usuario", scope = Autenticacion.class)
    public JAXBElement<String> createAutenticacionUsuario(String value) {
        return new JAXBElement<String>(_ClienteActualizarUsuario_QNAME, String.class, Autenticacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdAliado", scope = Autenticacion.class)
    public JAXBElement<String> createAutenticacionTipoIdAliado(String value) {
        return new JAXBElement<String>(_AliadoTipoIdAliado_QNAME, String.class, Autenticacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TraerDatosServidorResult", scope = TraerDatosServidorResponse.class)
    public JAXBElement<RespuestaMetodo> createTraerDatosServidorResponseTraerDatosServidorResult(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_TraerDatosServidorResponseTraerDatosServidorResult_QNAME, RespuestaMetodo.class, TraerDatosServidorResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetanqueoRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarRetanqueoResult", scope = ConsultarRetanqueoResponse.class)
    public JAXBElement<RetanqueoRes> createConsultarRetanqueoResponseConsultarRetanqueoResult(RetanqueoRes value) {
        return new JAXBElement<RetanqueoRes>(_ConsultarRetanqueoResponseConsultarRetanqueoResult_QNAME, RetanqueoRes.class, ConsultarRetanqueoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Modalidad", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoModalidad(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalModalidad_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Evento", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoEvento(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalEvento_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DireccionZona", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoDireccionZona(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalDireccionZona_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "OtorgadoPor", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoOtorgadoPor(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalOtorgadoPor_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaPago", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoFechaPago(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalFechaPago_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdCliente", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoIdCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalIdCliente_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreZona", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoNombreZona(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreZona_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroCredito", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoNumeroCredito(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNumeroCredito_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaGeneracion", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoFechaGeneracion(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalFechaGeneracion_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoCredito", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoTipoCredito(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalTipoCredito_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreCliente", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoNombreCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreCliente_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoCredito.class)
    public JAXBElement<String> createInfoCreditoTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoCredito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TextoRetorno", scope = MensajeSimulacionCuota.class)
    public JAXBElement<String> createMensajeSimulacionCuotaTextoRetorno(String value) {
        return new JAXBElement<String>(_MensajeSimulacionCuotaTextoRetorno_QNAME, String.class, MensajeSimulacionCuota.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustodiaDocumentosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CustodiaDocumentosResult", scope = CustodiaDocumentosResponse.class)
    public JAXBElement<CustodiaDocumentosRes> createCustodiaDocumentosResponseCustodiaDocumentosResult(CustodiaDocumentosRes value) {
        return new JAXBElement<CustodiaDocumentosRes>(_CustodiaDocumentosResponseCustodiaDocumentosResult_QNAME, CustodiaDocumentosRes.class, CustodiaDocumentosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetanqueoActualizarRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ActualizarRetanqueoResult", scope = ActualizarRetanqueoResponse.class)
    public JAXBElement<RetanqueoActualizarRes> createActualizarRetanqueoResponseActualizarRetanqueoResult(RetanqueoActualizarRes value) {
        return new JAXBElement<RetanqueoActualizarRes>(_ActualizarRetanqueoResponseActualizarRetanqueoResult_QNAME, RetanqueoActualizarRes.class, ActualizarRetanqueoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = CustodiaDocumentosRes.class)
    public JAXBElement<RespuestaMetodo> createCustodiaDocumentosResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, CustodiaDocumentosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pOrigen", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPOrigen(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPOrigen_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoCanal", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPCodigoCanal(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPCodigoCanal_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPCliente(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPCliente_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoZona", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPCodigoZona(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCodigoZona_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSucursal", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPSucursal(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPSucursal_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pAliado", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPAliado(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPAliado_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pVendedor", scope = GrabarSolicitud.class)
    public JAXBElement<String> createGrabarSolicitudPVendedor(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPVendedor_QNAME, String.class, GrabarSolicitud.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsumoTarjeta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosTarjeta", scope = ConsumoTarjetaRes.class)
    public JAXBElement<ConsumoTarjeta> createConsumoTarjetaResDatosTarjeta(ConsumoTarjeta value) {
        return new JAXBElement<ConsumoTarjeta>(_ConsumoTarjetaResDatosTarjeta_QNAME, ConsumoTarjeta.class, ConsumoTarjetaRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsumoTarjetaRes.class)
    public JAXBElement<RespuestaMetodo> createConsumoTarjetaResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsumoTarjetaRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfInfoSimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosSimulacionCuota", scope = SimularCuotaModalidadRes.class)
    public JAXBElement<ArrayOfInfoSimulacionCuota> createSimularCuotaModalidadResDatosSimulacionCuota(ArrayOfInfoSimulacionCuota value) {
        return new JAXBElement<ArrayOfInfoSimulacionCuota>(_SimularCuotaModalidadResDatosSimulacionCuota_QNAME, ArrayOfInfoSimulacionCuota.class, SimularCuotaModalidadRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MensajeSimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "MensajeSimulacion", scope = SimularCuotaModalidadRes.class)
    public JAXBElement<MensajeSimulacionCuota> createSimularCuotaModalidadResMensajeSimulacion(MensajeSimulacionCuota value) {
        return new JAXBElement<MensajeSimulacionCuota>(_SimularCuotaModalidadResMensajeSimulacion_QNAME, MensajeSimulacionCuota.class, SimularCuotaModalidadRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = SimularCuotaModalidadRes.class)
    public JAXBElement<RespuestaMetodo> createSimularCuotaModalidadResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, SimularCuotaModalidadRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrabarSolicitudRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "GrabarSolicitudResult", scope = GrabarSolicitudResponse.class)
    public JAXBElement<GrabarSolicitudRes> createGrabarSolicitudResponseGrabarSolicitudResult(GrabarSolicitudRes value) {
        return new JAXBElement<GrabarSolicitudRes>(_GrabarSolicitudResponseGrabarSolicitudResult_QNAME, GrabarSolicitudRes.class, GrabarSolicitudResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = GrabarSolicitudRes.class)
    public JAXBElement<RespuestaMetodo> createGrabarSolicitudResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, GrabarSolicitudRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteActualizar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = ActualizarRetanqueo.class)
    public JAXBElement<ClienteActualizar> createActualizarRetanqueoPCliente(ClienteActualizar value) {
        return new JAXBElement<ClienteActualizar>(_GrabarSolicitudPCliente_QNAME, ClienteActualizar.class, ActualizarRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = DesbloquearAprobacionRes.class)
    public JAXBElement<RespuestaMetodo> createDesbloquearAprobacionResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, DesbloquearAprobacionRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FormaPago", scope = SimulacionCuota.class)
    public JAXBElement<String> createSimulacionCuotaFormaPago(String value) {
        return new JAXBElement<String>(_SimulacionCuotaFormaPago_QNAME, String.class, SimulacionCuota.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Zona", scope = SimulacionCuota.class)
    public JAXBElement<String> createSimulacionCuotaZona(String value) {
        return new JAXBElement<String>(_SimulacionCuotaZona_QNAME, String.class, SimulacionCuota.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoAliado", scope = SimulacionCuota.class)
    public JAXBElement<String> createSimulacionCuotaCodigoAliado(String value) {
        return new JAXBElement<String>(_SimulacionCuotaCodigoAliado_QNAME, String.class, SimulacionCuota.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprobacionDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "AprobacionDigitalResult", scope = AprobacionDigitalResponse.class)
    public JAXBElement<AprobacionDigitalRes> createAprobacionDigitalResponseAprobacionDigitalResult(AprobacionDigitalRes value) {
        return new JAXBElement<AprobacionDigitalRes>(_AprobacionDigitalResponseAprobacionDigitalResult_QNAME, AprobacionDigitalRes.class, AprobacionDigitalResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = CrearTarjetaEcommerce.class)
    public JAXBElement<Autenticacion> createCrearTarjetaEcommercePIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, CrearTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdCliente", scope = CrearTarjetaEcommerce.class)
    public JAXBElement<String> createCrearTarjetaEcommercePIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPIdCliente_QNAME, String.class, CrearTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulacionCuotaModalidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSimulacionCuota", scope = SimularCuotaModalidad.class)
    public JAXBElement<SimulacionCuotaModalidad> createSimularCuotaModalidadPSimulacionCuota(SimulacionCuotaModalidad value) {
        return new JAXBElement<SimulacionCuotaModalidad>(_SimularCuotaModalidadPSimulacionCuota_QNAME, SimulacionCuotaModalidad.class, SimularCuotaModalidad.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AprobacionConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosConsultarAprobacion", scope = ConsultarAprobacionRes.class)
    public JAXBElement<AprobacionConsultar> createConsultarAprobacionResDatosConsultarAprobacion(AprobacionConsultar value) {
        return new JAXBElement<AprobacionConsultar>(_ConsultarAprobacionResDatosConsultarAprobacion_QNAME, AprobacionConsultar.class, ConsultarAprobacionRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsultarAprobacionRes.class)
    public JAXBElement<RespuestaMetodo> createConsultarAprobacionResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsultarAprobacionRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoNugRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ActualizarNugResult", scope = ActualizarNugResponse.class)
    public JAXBElement<ConsultarSaldoNugRes> createActualizarNugResponseActualizarNugResult(ConsultarSaldoNugRes value) {
        return new JAXBElement<ConsultarSaldoNugRes>(_ActualizarNugResponseActualizarNugResult_QNAME, ConsultarSaldoNugRes.class, ActualizarNugResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroAprobacion", scope = DesbloquearAprobacion.class)
    public JAXBElement<String> createDesbloquearAprobacionPNumeroAprobacion(String value) {
        return new JAXBElement<String>(_DesbloquearAprobacionPNumeroAprobacion_QNAME, String.class, DesbloquearAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = DesbloquearAprobacion.class)
    public JAXBElement<Autenticacion> createDesbloquearAprobacionPIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, DesbloquearAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdAliado", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionIdAliado(String value) {
        return new JAXBElement<String>(_AliadoIdAliado_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreAliado", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionNombreAliado(String value) {
        return new JAXBElement<String>(_InfoAprobacionNombreAliado_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdCliente", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionIdCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalIdCliente_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Almacen", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionAlmacen(String value) {
        return new JAXBElement<String>(_InfoAprobacionAlmacen_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroAprobacion", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionNumeroAprobacion(String value) {
        return new JAXBElement<String>(_InfoAprobacionNumeroAprobacion_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreCliente", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionNombreCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreCliente_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdAliado", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionTipoIdAliado(String value) {
        return new JAXBElement<String>(_AliadoTipoIdAliado_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoAprobacion.class)
    public JAXBElement<String> createInfoAprobacionTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularCuotaModalidadRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularCuotaModalidadResult", scope = SimularCuotaModalidadResponse.class)
    public JAXBElement<SimularCuotaModalidadRes> createSimularCuotaModalidadResponseSimularCuotaModalidadResult(SimularCuotaModalidadRes value) {
        return new JAXBElement<SimularCuotaModalidadRes>(_SimularCuotaModalidadResponseSimularCuotaModalidadResult_QNAME, SimularCuotaModalidadRes.class, SimularCuotaModalidadResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = InfoClienteNug.class)
    public JAXBElement<String> createInfoClienteNugIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, InfoClienteNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CupoBloqueado", scope = InfoClienteNug.class)
    public JAXBElement<String> createInfoClienteNugCupoBloqueado(String value) {
        return new JAXBElement<String>(_InfoClienteNugCupoBloqueado_QNAME, String.class, InfoClienteNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "MotivoBloqueo", scope = InfoClienteNug.class)
    public JAXBElement<String> createInfoClienteNugMotivoBloqueo(String value) {
        return new JAXBElement<String>(_InfoClienteNugMotivoBloqueo_QNAME, String.class, InfoClienteNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoClienteNug.class)
    public JAXBElement<String> createInfoClienteNugTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoClienteNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = ClienteConsultar.class)
    public JAXBElement<String> createClienteConsultarIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, ClienteConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = ClienteConsultar.class)
    public JAXBElement<String> createClienteConsultarTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, ClienteConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaVencimiento", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarFechaVencimiento(String value) {
        return new JAXBElement<String>(_AprobacionConsultarFechaVencimiento_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdAliado", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarIdAliado(String value) {
        return new JAXBElement<String>(_AliadoIdAliado_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "EventoMercadeo", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarEventoMercadeo(String value) {
        return new JAXBElement<String>(_AprobacionConsultarEventoMercadeo_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NomEventoCredito", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNomEventoCredito(String value) {
        return new JAXBElement<String>(_AprobacionConsultarNomEventoCredito_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "EstadoAprobacion", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarEstadoAprobacion(String value) {
        return new JAXBElement<String>(_AprobacionConsultarEstadoAprobacion_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoZona", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarCodigoZona(String value) {
        return new JAXBElement<String>(_TarjetaEcommerceCodigoZona_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "EstadoDigital", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarEstadoDigital(String value) {
        return new JAXBElement<String>(_AprobacionConsultarEstadoDigital_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreCliente", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNombreCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreCliente_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NomAliado", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNomAliado(String value) {
        return new JAXBElement<String>(_AprobacionConsultarNomAliado_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Afianzadora", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarAfianzadora(String value) {
        return new JAXBElement<String>(_AprobacionConsultarAfianzadora_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "EventoCredito", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarEventoCredito(String value) {
        return new JAXBElement<String>(_AprobacionConsultarEventoCredito_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Digital", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarDigital(String value) {
        return new JAXBElement<String>(_AprobacionConsultarDigital_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdCliente", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarIdCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalIdCliente_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Canal", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarCanal(String value) {
        return new JAXBElement<String>(_AprobacionConsultarCanal_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaGeneracion", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarFechaGeneracion(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalFechaGeneracion_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreSeguro", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNombreSeguro(String value) {
        return new JAXBElement<String>(_AprobacionConsultarNombreSeguro_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Impreso", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarImpreso(String value) {
        return new JAXBElement<String>(_AprobacionConsultarImpreso_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreModalidad", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNombreModalidad(String value) {
        return new JAXBElement<String>(_AprobacionConsultarNombreModalidad_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NomEventoMercadeo", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNomEventoMercadeo(String value) {
        return new JAXBElement<String>(_AprobacionConsultarNomEventoMercadeo_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Ecommerce", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarEcommerce(String value) {
        return new JAXBElement<String>(_AprobacionConsultarEcommerce_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoSeguro", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarCodigoSeguro(String value) {
        return new JAXBElement<String>(_AprobacionConsultarCodigoSeguro_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Aliado", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarAliado(String value) {
        return new JAXBElement<String>(_Aliado_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreZona", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarNombreZona(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreZona_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FechaRegistro", scope = AprobacionConsultar.class)
    public JAXBElement<String> createAprobacionConsultarFechaRegistro(String value) {
        return new JAXBElement<String>(_AprobacionConsultarFechaRegistro_QNAME, String.class, AprobacionConsultar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteCer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = ConsultarRetanqueo.class)
    public JAXBElement<ClienteCer> createConsultarRetanqueoPCliente(ClienteCer value) {
        return new JAXBElement<ClienteCer>(_GrabarSolicitudPCliente_QNAME, ClienteCer.class, ConsultarRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteCer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = ConsultarSaldoNug.class)
    public JAXBElement<ClienteCer> createConsultarSaldoNugPCliente(ClienteCer value) {
        return new JAXBElement<ClienteCer>(_GrabarSolicitudPCliente_QNAME, ClienteCer.class, ConsultarSaldoNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoAprobacionDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosAprobacionDigital", scope = AprobacionDigitalRes.class)
    public JAXBElement<InfoAprobacionDigital> createAprobacionDigitalResDatosAprobacionDigital(InfoAprobacionDigital value) {
        return new JAXBElement<InfoAprobacionDigital>(_AprobacionDigitalResDatosAprobacionDigital_QNAME, InfoAprobacionDigital.class, AprobacionDigitalRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = AprobacionDigitalRes.class)
    public JAXBElement<RespuestaMetodo> createAprobacionDigitalResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, AprobacionDigitalRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumTarjeta", scope = ConsumoTarjetaEcommerce.class)
    public JAXBElement<String> createConsumoTarjetaEcommercePNumTarjeta(String value) {
        return new JAXBElement<String>(_ConsumoTarjetaEcommercePNumTarjeta_QNAME, String.class, ConsumoTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = ConsumoTarjetaEcommerce.class)
    public JAXBElement<Autenticacion> createConsumoTarjetaEcommercePIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, ConsumoTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdAlmacenPOS", scope = ConsumoTarjetaEcommerce.class)
    public JAXBElement<String> createConsumoTarjetaEcommercePIdAlmacenPOS(String value) {
        return new JAXBElement<String>(_ConsumoTarjetaEcommercePIdAlmacenPOS_QNAME, String.class, ConsumoTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIDCliente", scope = ConsumoTarjetaEcommerce.class)
    public JAXBElement<String> createConsumoTarjetaEcommercePIDCliente(String value) {
        return new JAXBElement<String>(_ConsumoTarjetaEcommercePIDCliente_QNAME, String.class, ConsumoTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "p_IdTransaccion", scope = ConsumoTarjetaEcommerce.class)
    public JAXBElement<String> createConsumoTarjetaEcommercePIdTransaccion(String value) {
        return new JAXBElement<String>(_ConsumoTarjetaEcommercePIdTransaccion_QNAME, String.class, ConsumoTarjetaEcommerce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSaldoNugRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarSaldoNugResult", scope = ConsultarSaldoNugResponse.class)
    public JAXBElement<ConsultarSaldoNugRes> createConsultarSaldoNugResponseConsultarSaldoNugResult(ConsultarSaldoNugRes value) {
        return new JAXBElement<ConsultarSaldoNugRes>(_ConsultarSaldoNugResponseConsultarSaldoNugResult_QNAME, ConsultarSaldoNugRes.class, ConsultarSaldoNugResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPlanPagosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarPlanPagosResult", scope = ConsultarPlanPagosResponse.class)
    public JAXBElement<ConsultarPlanPagosRes> createConsultarPlanPagosResponseConsultarPlanPagosResult(ConsultarPlanPagosRes value) {
        return new JAXBElement<ConsultarPlanPagosRes>(_ConsultarPlanPagosResponseConsultarPlanPagosResult_QNAME, ConsultarPlanPagosRes.class, ConsultarPlanPagosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoAprobacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosAprobacion", scope = CrearAprobacionRes.class)
    public JAXBElement<InfoAprobacion> createCrearAprobacionResDatosAprobacion(InfoAprobacion value) {
        return new JAXBElement<InfoAprobacion>(_CrearAprobacionResDatosAprobacion_QNAME, InfoAprobacion.class, CrearAprobacionRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = CrearAprobacionRes.class)
    public JAXBElement<RespuestaMetodo> createCrearAprobacionResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, CrearAprobacionRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarAprobacionResult", scope = ConsultarAprobacionResponse.class)
    public JAXBElement<ConsultarAprobacionRes> createConsultarAprobacionResponseConsultarAprobacionResult(ConsultarAprobacionRes value) {
        return new JAXBElement<ConsultarAprobacionRes>(_ConsultarAprobacionResponseConsultarAprobacionResult_QNAME, ConsultarAprobacionRes.class, ConsultarAprobacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = SimularCuotaRes.class)
    public JAXBElement<RespuestaMetodo> createSimularCuotaResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, SimularCuotaRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FormaPago", scope = SimulacionCuotaModalidad.class)
    public JAXBElement<String> createSimulacionCuotaModalidadFormaPago(String value) {
        return new JAXBElement<String>(_SimulacionCuotaFormaPago_QNAME, String.class, SimulacionCuotaModalidad.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Zona", scope = SimulacionCuotaModalidad.class)
    public JAXBElement<String> createSimulacionCuotaModalidadZona(String value) {
        return new JAXBElement<String>(_SimulacionCuotaZona_QNAME, String.class, SimulacionCuotaModalidad.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoAliado", scope = SimulacionCuotaModalidad.class)
    public JAXBElement<String> createSimulacionCuotaModalidadCodigoAliado(String value) {
        return new JAXBElement<String>(_SimulacionCuotaCodigoAliado_QNAME, String.class, SimulacionCuotaModalidad.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroAprobacion", scope = ConsultarPlanPagos.class)
    public JAXBElement<String> createConsultarPlanPagosPNumeroAprobacion(String value) {
        return new JAXBElement<String>(_DesbloquearAprobacionPNumeroAprobacion_QNAME, String.class, ConsultarPlanPagos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = ConsultarPlanPagos.class)
    public JAXBElement<Autenticacion> createConsultarPlanPagosPIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, ConsultarPlanPagos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Cliente", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalCliente(String value) {
        return new JAXBElement<String>(_InfoAprobacionDigitalCliente_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroAprobacion", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalNumeroAprobacion(String value) {
        return new JAXBElement<String>(_InfoAprobacionNumeroAprobacion_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ZonaAlmacen", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalZonaAlmacen(String value) {
        return new JAXBElement<String>(_InfoAprobacionDigitalZonaAlmacen_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NumeroCredito", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalNumeroCredito(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNumeroCredito_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Nug", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalNug(String value) {
        return new JAXBElement<String>(_InfoAprobacionDigitalNug_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NombreCliente", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalNombreCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalNombreCliente_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoAprobacionDigital.class)
    public JAXBElement<String> createInfoAprobacionDigitalTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoAprobacionDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "user", scope = GenerarToken.class)
    public JAXBElement<String> createGenerarTokenUser(String value) {
        return new JAXBElement<String>(_GenerarTokenUser_QNAME, String.class, GenerarToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "password", scope = GenerarToken.class)
    public JAXBElement<String> createGenerarTokenPassword(String value) {
        return new JAXBElement<String>(_GenerarTokenPassword_QNAME, String.class, GenerarToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aliado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pAliado", scope = GenerarToken.class)
    public JAXBElement<Aliado> createGenerarTokenPAliado(Aliado value) {
        return new JAXBElement<Aliado>(_GrabarSolicitudPAliado_QNAME, Aliado.class, GenerarToken.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TarjetaEcommerce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosTarjeta", scope = CrearTarjetaEcommerceRes.class)
    public JAXBElement<TarjetaEcommerce> createCrearTarjetaEcommerceResDatosTarjeta(TarjetaEcommerce value) {
        return new JAXBElement<TarjetaEcommerce>(_ConsumoTarjetaResDatosTarjeta_QNAME, TarjetaEcommerce.class, CrearTarjetaEcommerceRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = CrearTarjetaEcommerceRes.class)
    public JAXBElement<RespuestaMetodo> createCrearTarjetaEcommerceResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, CrearTarjetaEcommerceRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pFormaPago", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<String> createSimularPlanPagosDigitalesPFormaPago(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPFormaPago_QNAME, String.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroAprobacion", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<String> createSimularPlanPagosDigitalesPNumeroAprobacion(String value) {
        return new JAXBElement<String>(_DesbloquearAprobacionPNumeroAprobacion_QNAME, String.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<String> createSimularPlanPagosDigitalesPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<String> createSimularPlanPagosDigitalesPCliente(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPCliente_QNAME, String.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<Autenticacion> createSimularPlanPagosDigitalesPIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoZona", scope = SimularPlanPagosDigitales.class)
    public JAXBElement<String> createSimularPlanPagosDigitalesPCodigoZona(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCodigoZona_QNAME, String.class, SimularPlanPagosDigitales.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularPlanPagosDigitalesRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularPlanPagosDigitalesResult", scope = SimularPlanPagosDigitalesResponse.class)
    public JAXBElement<SimularPlanPagosDigitalesRes> createSimularPlanPagosDigitalesResponseSimularPlanPagosDigitalesResult(SimularPlanPagosDigitalesRes value) {
        return new JAXBElement<SimularPlanPagosDigitalesRes>(_SimularPlanPagosDigitalesResponseSimularPlanPagosDigitalesResult_QNAME, SimularPlanPagosDigitalesRes.class, SimularPlanPagosDigitalesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearDocumentoDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearDocumentoDigitalResult", scope = DesbloquearDocumentoDigitalResponse.class)
    public JAXBElement<DesbloquearDocumentoDigitalRes> createDesbloquearDocumentoDigitalResponseDesbloquearDocumentoDigitalResult(DesbloquearDocumentoDigitalRes value) {
        return new JAXBElement<DesbloquearDocumentoDigitalRes>(_DesbloquearDocumentoDigitalResponseDesbloquearDocumentoDigitalResult_QNAME, DesbloquearDocumentoDigitalRes.class, DesbloquearDocumentoDigitalResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = InfoRetanqueo.class)
    public JAXBElement<String> createInfoRetanqueoIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, InfoRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CentralRiesgos", scope = InfoRetanqueo.class)
    public JAXBElement<String> createInfoRetanqueoCentralRiesgos(String value) {
        return new JAXBElement<String>(_InfoRetanqueoCentralRiesgos_QNAME, String.class, InfoRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoRetanqueo.class)
    public JAXBElement<String> createInfoRetanqueoTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FirmaFGA", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaFirmaFGA(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaFirmaFGA_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Afianzadora", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaAfianzadora(String value) {
        return new JAXBElement<String>(_AprobacionConsultarAfianzadora_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FirmaNovAfianza", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaFirmaNovAfianza(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaFirmaNovAfianza_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Email", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaEmail(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaEmail_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DocumentosCustodia", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaDocumentosCustodia(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaDocumentosCustodia_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Actualizado", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaActualizado(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaActualizado_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Celular", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaCelular(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaCelular_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "NomAfianzadora", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaNomAfianzadora(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaNomAfianzadora_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DocumentacionImpresa", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaDocumentacionImpresa(String value) {
        return new JAXBElement<String>(_InfoClienteBasicaDocumentacionImpresa_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoClienteBasica.class)
    public JAXBElement<String> createInfoClienteBasicaTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoClienteBasica.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = InfoActualizarRetanqueo.class)
    public JAXBElement<String> createInfoActualizarRetanqueoIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, InfoActualizarRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = InfoActualizarRetanqueo.class)
    public JAXBElement<String> createInfoActualizarRetanqueoTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, InfoActualizarRetanqueo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulacionCuota }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pSimulacion", scope = SimularCuota.class)
    public JAXBElement<SimulacionCuota> createSimularCuotaPSimulacion(SimulacionCuota value) {
        return new JAXBElement<SimulacionCuota>(_SimularCuotaPSimulacion_QNAME, SimulacionCuota.class, SimularCuota.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearDigitalRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearDigitalResult", scope = DesbloquearDigitalResponse.class)
    public JAXBElement<DesbloquearDigitalRes> createDesbloquearDigitalResponseDesbloquearDigitalResult(DesbloquearDigitalRes value) {
        return new JAXBElement<DesbloquearDigitalRes>(_DesbloquearDigitalResponseDesbloquearDigitalResult_QNAME, DesbloquearDigitalRes.class, DesbloquearDigitalResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "FormaPago", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionFormaPago(String value) {
        return new JAXBElement<String>(_SimulacionCuotaFormaPago_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Afianzadora", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionAfianzadora(String value) {
        return new JAXBElement<String>(_AprobacionConsultarAfianzadora_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Evento", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionEvento(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalEvento_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SucursalCliente", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionSucursalCliente(String value) {
        return new JAXBElement<String>(_AprobacionSucursalCliente_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Periodicidad", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionPeriodicidad(String value) {
        return new JAXBElement<String>(_AprobacionPeriodicidad_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IdCliente", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionIdCliente(String value) {
        return new JAXBElement<String>(_InfoCreditoDigitalIdCliente_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Almacen", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionAlmacen(String value) {
        return new JAXBElement<String>(_InfoAprobacionAlmacen_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Usuario", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionUsuario(String value) {
        return new JAXBElement<String>(_ClienteActualizarUsuario_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Nug", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionNug(String value) {
        return new JAXBElement<String>(_InfoAprobacionDigitalNug_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "CodigoOtp", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionCodigoOtp(String value) {
        return new JAXBElement<String>(_AprobacionCodigoOtp_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = Aprobacion.class)
    public JAXBElement<String> createAprobacionTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, Aprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroAprobacion", scope = DesbloquearDigital.class)
    public JAXBElement<String> createDesbloquearDigitalPNumeroAprobacion(String value) {
        return new JAXBElement<String>(_DesbloquearAprobacionPNumeroAprobacion_QNAME, String.class, DesbloquearDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = DesbloquearDigital.class)
    public JAXBElement<String> createDesbloquearDigitalPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, DesbloquearDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdCliente", scope = DesbloquearDigital.class)
    public JAXBElement<String> createDesbloquearDigitalPIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPIdCliente_QNAME, String.class, DesbloquearDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pEstado", scope = DesbloquearDigital.class)
    public JAXBElement<String> createDesbloquearDigitalPEstado(String value) {
        return new JAXBElement<String>(_DesbloquearDigitalPEstado_QNAME, String.class, DesbloquearDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoClienteBasica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosCliente", scope = ConsultarClienteRes.class)
    public JAXBElement<InfoClienteBasica> createConsultarClienteResDatosCliente(InfoClienteBasica value) {
        return new JAXBElement<InfoClienteBasica>(_ConsultarClienteResDatosCliente_QNAME, InfoClienteBasica.class, ConsultarClienteRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsultarClienteRes.class)
    public JAXBElement<RespuestaMetodo> createConsultarClienteResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsultarClienteRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsultarSaldoNugRes.class)
    public JAXBElement<RespuestaMetodo> createConsultarSaldoNugResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsultarSaldoNugRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoClienteNug }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosNug", scope = ConsultarSaldoNugRes.class)
    public JAXBElement<InfoClienteNug> createConsultarSaldoNugResDatosNug(InfoClienteNug value) {
        return new JAXBElement<InfoClienteNug>(_ConsultarSaldoNugResDatosNug_QNAME, InfoClienteNug.class, ConsultarSaldoNugRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularPlanPagosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularPlanPagosResult", scope = SimularPlanPagosResponse.class)
    public JAXBElement<SimularPlanPagosRes> createSimularPlanPagosResponseSimularPlanPagosResult(SimularPlanPagosRes value) {
        return new JAXBElement<SimularPlanPagosRes>(_SimularPlanPagosResponseSimularPlanPagosResult_QNAME, SimularPlanPagosRes.class, SimularPlanPagosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = DesbloquearDocumentoDigital.class)
    public JAXBElement<String> createDesbloquearDocumentoDigitalPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, DesbloquearDocumentoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdCliente", scope = DesbloquearDocumentoDigital.class)
    public JAXBElement<String> createDesbloquearDocumentoDigitalPIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPIdCliente_QNAME, String.class, DesbloquearDocumentoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pEstado", scope = DesbloquearDocumentoDigital.class)
    public JAXBElement<String> createDesbloquearDocumentoDigitalPEstado(String value) {
        return new JAXBElement<String>(_DesbloquearDigitalPEstado_QNAME, String.class, DesbloquearDocumentoDigital.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteActualizar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = ActualizarNug.class)
    public JAXBElement<ClienteActualizar> createActualizarNugPCliente(ClienteActualizar value) {
        return new JAXBElement<ClienteActualizar>(_GrabarSolicitudPCliente_QNAME, ClienteActualizar.class, ActualizarNug.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarSegurosRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarSegurosResult", scope = ConsultarSegurosResponse.class)
    public JAXBElement<ConsultarSegurosRes> createConsultarSegurosResponseConsultarSegurosResult(ConsultarSegurosRes value) {
        return new JAXBElement<ConsultarSegurosRes>(_ConsultarSegurosResponseConsultarSegurosResult_QNAME, ConsultarSegurosRes.class, ConsultarSegurosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoRetanqueo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Retanqueo", scope = RetanqueoRes.class)
    public JAXBElement<InfoRetanqueo> createRetanqueoResRetanqueo(InfoRetanqueo value) {
        return new JAXBElement<InfoRetanqueo>(_RetanqueoResRetanqueo_QNAME, InfoRetanqueo.class, RetanqueoRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = RetanqueoRes.class)
    public JAXBElement<RespuestaMetodo> createRetanqueoResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, RetanqueoRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "IDCliente", scope = ClienteCer.class)
    public JAXBElement<String> createClienteCerIDCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarIDCliente_QNAME, String.class, ClienteCer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "TipoIdCliente", scope = ClienteCer.class)
    public JAXBElement<String> createClienteCerTipoIdCliente(String value) {
        return new JAXBElement<String>(_ClienteActualizarTipoIdCliente_QNAME, String.class, ClienteCer.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoCreditoDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosCreditoDigital", scope = SimularPlanPagosDigitalesRes.class)
    public JAXBElement<InfoCreditoDigital> createSimularPlanPagosDigitalesResDatosCreditoDigital(InfoCreditoDigital value) {
        return new JAXBElement<InfoCreditoDigital>(_SimularPlanPagosDigitalesResDatosCreditoDigital_QNAME, InfoCreditoDigital.class, SimularPlanPagosDigitalesRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPlanPagosDigital }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "PlanPagosDigital", scope = SimularPlanPagosDigitalesRes.class)
    public JAXBElement<ArrayOfPlanPagosDigital> createSimularPlanPagosDigitalesResPlanPagosDigital(ArrayOfPlanPagosDigital value) {
        return new JAXBElement<ArrayOfPlanPagosDigital>(_PlanPagosDigital_QNAME, ArrayOfPlanPagosDigital.class, SimularPlanPagosDigitalesRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = SimularPlanPagosDigitalesRes.class)
    public JAXBElement<RespuestaMetodo> createSimularPlanPagosDigitalesResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, SimularPlanPagosDigitalesRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aprobacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pAprobacion", scope = CrearAprobacion.class)
    public JAXBElement<Aprobacion> createCrearAprobacionPAprobacion(Aprobacion value) {
        return new JAXBElement<Aprobacion>(_CrearAprobacionPAprobacion_QNAME, Aprobacion.class, CrearAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = CrearAprobacion.class)
    public JAXBElement<Autenticacion> createCrearAprobacionPIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, CrearAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = DesbloquearDigitalRes.class)
    public JAXBElement<RespuestaMetodo> createDesbloquearDigitalResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, DesbloquearDigitalRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "MensajeRetorno", scope = RespuestaMetodo.class)
    public JAXBElement<String> createRespuestaMetodoMensajeRetorno(String value) {
        return new JAXBElement<String>(_RespuestaMetodoMensajeRetorno_QNAME, String.class, RespuestaMetodo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pUsuario", scope = CustodiaDocumentos.class)
    public JAXBElement<String> createCustodiaDocumentosPUsuario(String value) {
        return new JAXBElement<String>(_CustodiaDocumentosPUsuario_QNAME, String.class, CustodiaDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = CustodiaDocumentos.class)
    public JAXBElement<String> createCustodiaDocumentosPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, CustodiaDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = CustodiaDocumentos.class)
    public JAXBElement<String> createCustodiaDocumentosPCliente(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPCliente_QNAME, String.class, CustodiaDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCodigoZona", scope = CustodiaDocumentos.class)
    public JAXBElement<String> createCustodiaDocumentosPCodigoZona(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPCodigoZona_QNAME, String.class, CustodiaDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pAfianzadora", scope = CustodiaDocumentos.class)
    public JAXBElement<String> createCustodiaDocumentosPAfianzadora(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPAfianzadora_QNAME, String.class, CustodiaDocumentos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pTipoIdCliente", scope = ConsultarAprobacion.class)
    public JAXBElement<String> createConsultarAprobacionPTipoIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPTipoIdCliente_QNAME, String.class, ConsultarAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIdCliente", scope = ConsultarAprobacion.class)
    public JAXBElement<String> createConsultarAprobacionPIdCliente(String value) {
        return new JAXBElement<String>(_AprobacionDigitalPIdCliente_QNAME, String.class, ConsultarAprobacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarClienteRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "ConsultarClienteResult", scope = ConsultarClienteResponse.class)
    public JAXBElement<ConsultarClienteRes> createConsultarClienteResponseConsultarClienteResult(ConsultarClienteRes value) {
        return new JAXBElement<ConsultarClienteRes>(_ConsultarClienteResponseConsultarClienteResult_QNAME, ConsultarClienteRes.class, ConsultarClienteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClienteConsultar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = ConsultarCliente.class)
    public JAXBElement<ClienteConsultar> createConsultarClientePCliente(ClienteConsultar value) {
        return new JAXBElement<ClienteConsultar>(_GrabarSolicitudPCliente_QNAME, ClienteConsultar.class, ConsultarCliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPlanPagos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "PlanPagos", scope = SimularPlanPagosRes.class)
    public JAXBElement<ArrayOfPlanPagos> createSimularPlanPagosResPlanPagos(ArrayOfPlanPagos value) {
        return new JAXBElement<ArrayOfPlanPagos>(_PlanPagos_QNAME, ArrayOfPlanPagos.class, SimularPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosCredito", scope = SimularPlanPagosRes.class)
    public JAXBElement<InfoCredito> createSimularPlanPagosResDatosCredito(InfoCredito value) {
        return new JAXBElement<InfoCredito>(_SimularPlanPagosResDatosCredito_QNAME, InfoCredito.class, SimularPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = SimularPlanPagosRes.class)
    public JAXBElement<RespuestaMetodo> createSimularPlanPagosResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, SimularPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Token", scope = TokenRes.class)
    public JAXBElement<String> createTokenResToken(String value) {
        return new JAXBElement<String>(_AutenticacionToken_QNAME, String.class, TokenRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = TokenRes.class)
    public JAXBElement<RespuestaMetodo> createTokenResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, TokenRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pNumeroAprobacion", scope = SimularPlanPagos.class)
    public JAXBElement<String> createSimularPlanPagosPNumeroAprobacion(String value) {
        return new JAXBElement<String>(_DesbloquearAprobacionPNumeroAprobacion_QNAME, String.class, SimularPlanPagos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pCliente", scope = SimularPlanPagos.class)
    public JAXBElement<String> createSimularPlanPagosPCliente(String value) {
        return new JAXBElement<String>(_GrabarSolicitudPCliente_QNAME, String.class, SimularPlanPagos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "pIngreso", scope = SimularPlanPagos.class)
    public JAXBElement<Autenticacion> createSimularPlanPagosPIngreso(Autenticacion value) {
        return new JAXBElement<Autenticacion>(_CrearTarjetaEcommercePIngreso_QNAME, Autenticacion.class, SimularPlanPagos.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = DesbloquearDocumentoDigitalRes.class)
    public JAXBElement<RespuestaMetodo> createDesbloquearDocumentoDigitalResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, DesbloquearDocumentoDigitalRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimularCuotaRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "SimularCuotaResult", scope = SimularCuotaResponse.class)
    public JAXBElement<SimularCuotaRes> createSimularCuotaResponseSimularCuotaResult(SimularCuotaRes value) {
        return new JAXBElement<SimularCuotaRes>(_SimularCuotaResponseSimularCuotaResult_QNAME, SimularCuotaRes.class, SimularCuotaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DesbloquearAprobacionRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DesbloquearAprobacionResult", scope = DesbloquearAprobacionResponse.class)
    public JAXBElement<DesbloquearAprobacionRes> createDesbloquearAprobacionResponseDesbloquearAprobacionResult(DesbloquearAprobacionRes value) {
        return new JAXBElement<DesbloquearAprobacionRes>(_DesbloquearAprobacionResponseDesbloquearAprobacionResult_QNAME, DesbloquearAprobacionRes.class, DesbloquearAprobacionResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPlanPagos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "PlanPagos", scope = ConsultarPlanPagosRes.class)
    public JAXBElement<ArrayOfPlanPagos> createConsultarPlanPagosResPlanPagos(ArrayOfPlanPagos value) {
        return new JAXBElement<ArrayOfPlanPagos>(_PlanPagos_QNAME, ArrayOfPlanPagos.class, ConsultarPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "DatosCredito", scope = ConsultarPlanPagosRes.class)
    public JAXBElement<InfoCredito> createConsultarPlanPagosResDatosCredito(InfoCredito value) {
        return new JAXBElement<InfoCredito>(_SimularPlanPagosResDatosCredito_QNAME, InfoCredito.class, ConsultarPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = ConsultarPlanPagosRes.class)
    public JAXBElement<RespuestaMetodo> createConsultarPlanPagosResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, ConsultarPlanPagosRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoActualizarRetanqueo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "Retanqueo", scope = RetanqueoActualizarRes.class)
    public JAXBElement<InfoActualizarRetanqueo> createRetanqueoActualizarResRetanqueo(InfoActualizarRetanqueo value) {
        return new JAXBElement<InfoActualizarRetanqueo>(_RetanqueoResRetanqueo_QNAME, InfoActualizarRetanqueo.class, RetanqueoActualizarRes.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaMetodo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.flamingo.com.co", name = "RespuestaMetodo", scope = RetanqueoActualizarRes.class)
    public JAXBElement<RespuestaMetodo> createRetanqueoActualizarResRespuestaMetodo(RespuestaMetodo value) {
        return new JAXBElement<RespuestaMetodo>(_RespuestaMetodo_QNAME, RespuestaMetodo.class, RetanqueoActualizarRes.class, value);
    }

}
