package com.lineai.posappframework.PEF.userdefined.WS_FALSolutions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;

import com.fal.ws.impl.BasketRequest;
import com.fal.ws.impl.Coupon;
import com.fal.ws.impl.Coupons;
import com.fal.ws.impl.CustomerDetails;
import com.fal.ws.impl.GiftRewards;
import com.fal.ws.impl.LineItem;
import com.fal.ws.impl.LineItems;
import com.fal.ws.impl.PaymentMethod;
import com.fal.ws.impl.PaymentMethods;
import com.fal.ws.impl.Reward;
import com.fal.ws.impl.Rewards;
import com.fal.ws.impl.RewardsField;
import com.fal.ws.impl.RewardsResponse;
import com.fal.ws.impl.Ticket;
import com.fal.ws.impl.TransactionLimitation;
import com.fal.ws.impl.TransactionLimitations;
import com.fal.ws.impl.TrxError;
import com.fal.ws.impl.VoidedRewards;
import com.fal.ws.impl.VoucherDto;
import com.fal.ws.impl.VouchersDto;
import com.linea.TimeOut.Control_TimeOut;
import com.linea.posappEnginePromotions.Voucher.TipoVoucher;
import com.linea.posappEnginePromotions.Voucher.Voucher;
import com.linea.posappEnginePromotions.Voucher.VoucherFormatter;
import com.linea.posappEnginePromotions.contenedores.ContenedorConexion;
import com.linea.posappEnginePromotions.messages.MessageWorker;
import com.linea.posappEnginePromotions.messages.RewardMessageWorker;
import com.linea.posappEnginePromotions.messages.TransactionMessageWorker;
import com.linea.sig.util.UtilidadesDescuentos;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.InfoReward;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.Instancia;
import com.lineai.posappframework.util.userdefined.WS_FALSolutions.RefundManagement;

/**
 * Clase encargada de determinar el proceso, y a su vez tratar los datos acorde
 * a ello (que tipo de consulta debe realizarse, y cómo deben manejarse los
 * datos en las mismas)
 * 
 * @author ferru
 * 
 */
public class ProcessRequest
{
  private static Logger log = Logger.getLogger(ProcessRequest.class);
  private static Logger errorLog = Logger.getLogger("error." + ProcessRequest.class.getName());
  private static final int MAX_STRING_LENGTH = 3950;

  private static final String CLASSNAME = "[ProcessReques] - ";
  
  private static long rewardID[];

  public static final String DECIMALES = "100";
  /**
   * Constante creada para evitar problema con el procesamiento de BigDecimal,
   * ya que estos objetos son al igual que los String muy problemáticos de estar
   * construyendo una y otra vez, he creado una constante
   */
  public static BigDecimal centCorrec = new BigDecimal(DECIMALES);
  private MessageWorker message;
  private String con;
  private int ipAd = 0;
  private static int cursor = 0;
  private int timeOut = 0;
  private int countIncidencias = 0;
  // Para comunicar el CurrencyCode entre consulta de cliente y fin de
  // transaccion
  private static String currency;
  // # de ip's adicionales a la primary y a la secondary
  private int max = 0;
  static private ArrayList tiposCupones;
  // Reward de indice 0
  private long totalIndice0 = 0;
  // OJO solo supermaxi
  // static private WeirdDiscountManager wdm;
  // static private GeneradorMensajesPorArticulos messageBuilder;
  // END SOLO SUPERMAXI
  private static String transaccionAnterior = "";
  private static String transaccionActual = "";
  // Para almacenar la respuesta de cliente, ya estoy harto de variables
  // estáticas
  
  private static String rspCliente = "";
  // Valida si en el momento dado, se va a traer el valor anterior, o
  // simplemente se indica error
  private boolean consultarAnterior = false;

  /**
   * edgar.cuesta
   * 
   * constructor creado con el único fin de poder determinar si se trabaja desde
   * terminal standalone o si se trabaja desde terminar controladora
   */
  public ProcessRequest()
  {
    try
    {
      reiniciarConexion();
      con = getConexion();
      if (log.isInfoEnabled())
        log.info(CLASSNAME + "Conexión inicial: " + con);
      // Log.logInfo(CLASSNAME + "Conexión inicial: " + con);
      timeOut = Integer.parseInt(Core.extraerPropiedad("1", ContenedorConexion.RETRASO));

      // Log.logInfo(CLASSNAME + "Retraso " + timeOut);
      max = Integer.parseInt(Core.extraerPropiedad("1", ContenedorConexion.MAX_IP_ADICIONALES));
      // Log.logInfo(CLASSNAME +
      // "Maximo número de conexiones fuera de las 2 basicas: " + max);
      Boolean rewardMessage = Boolean.valueOf(Core.extraerPropiedad("1", ContenedorConexion.REWARD_MESSAGES));
      // Log.logInfo("De tipo RewardMessage? " + rewardMessage);
      if (log.isInfoEnabled())
      {
        log.info(
          CLASSNAME + "Retraso " + timeOut + "\n" + CLASSNAME + "Maximo número de conexiones fuera de las 2 basicas: "
            + max + "\n" + CLASSNAME + "De tipo RewardMessage? " + rewardMessage);
      }
      // Por defecto extrae los valores por Reward, aunque no se si el null
      // genere un nullPointer...tengo que manejarlo desde el contenedor
      if (rewardMessage == null || rewardMessage.booleanValue())
      {
        this.message = new RewardMessageWorker();
      }
      else
      {
        this.message = new TransactionMessageWorker();
      }
    }
    catch (Throwable t)
    {
      errorLog.error("Error: " + t.getClass().getName() + ":" + t.getMessage(), t);
    }
  }

  /**
   * 
   * @param data
   *          -> Array de String donde vienen los mensajes necesarios para la
   *          peticion SOAP
   * @return la respuesta del mensaje de peticion, interfaz entre el Core y los
   *         metodos de solicitud individuales
   * @autor sebastian castaneda
   */
  public String getResponse(String[] data)
  {
    /*
     * sebastian.castaneda (no se cuando) Con este valor inicial, se garantiza
     * que si surge algun problema a la hora de tratar la conexión, y no se
     * puede dar una respuesta satisfactoria, BASIC recibirá un error que no
     * sabemos de que tipo
     */
    String msgResponse = "Error";
    /*
     * sebastian.castaneda Se imprime en el log, los datos que llegan en data
     * con motivos de seguimiento del c�digo (para mantenimiento y correcci�n de
     * errores
     */
    for (int i = 0; i < data.length; i++)
    {
      if (log.isDebugEnabled())
        log.debug(CLASSNAME + "Data[" + i + "]=[" + data[i] + "]");
      // Log.logDebug(CLASSNAME + "Data[" + i + "]=[" + data[i] + "]");
    }
    try
    {
      /*
       * sebastian.castanedaSe comprueba que la trama poseea al menos un campo,
       * mejor dicho, que no este vacía caso contrario se indica en la trama
       * respuesta que los parámetros indicados no se hanrecibido
       */
      if (data.length >= 1)
      {
        String operation = data[0];
        // SE QUITA LA POSICION 0 DEL VECTOR (OPERACION)
        String d[] = new String[data.length - 1];
        /*
         * sebastian.castaneda Para verficiar que se está  modificando
         * adecuadamente el array con los datos al eliminar el primer campo
         */
        for (int i = 0; i < data.length - 1; i++)
        {
          d[i] = data[i + 1];
          if (log.isDebugEnabled())
            log.debug(CLASSNAME + "d[" + i + "]=[" + d[i] + "]");
          // Log.logDebug(CLASSNAME + "d[" + i + "]=[" + d[i] + "]");
        }
        data = d;
        /*
         * sebastian.castaneda con operacion, determinamos el tipo de operación
         * a realizar 0=optener item 1=optener cliente 2=optener medio de pago
         * 3=fin de transaccion edgar.cuesta 2012/09/18 10=prueba temporal 4 =
         * Devoluciones, 5 =
         */
        int callFunction = new Integer(operation).intValue();
        switch (callFunction)
        {
          case 0:
            try
            {
              if (log.isDebugEnabled())
                log.debug(CLASSNAME + " Opcion 0: Consultar todo");
              // Log.logDebug(CLASSNAME + " Opcion 0: Consultar todo");
              msgResponse = getItem(data);
            }
            catch (Exception e)
            {
              errorLog.error("Exception en consulta 0: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception consulta item: " + e.getClass().getName() + ":" + e.getLocalizedMessage();
            }
            catch (Throwable t)
            {
              errorLog.error("Throwable en consulta 0: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consulta item: " + t.getClass().getName() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
            }
            break;
          case 1:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + " Opcion 1: Consultar Cliente");
              // Log.logDebug(CLASSNAME + " Opcion 1: Consultar Cliente");
              msgResponse = getClient(data);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 1 : " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception consulta cliente: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
              // System.out.println(e.getMessage());
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 1 : " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consutla cliente: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
              // System.out.println(t.getMessage());
            }
            break;
          case 2:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + " Opcion 2: Consulta medios de pago");
              // Log.logDebug(CLASSNAME + " Opcion 2: Consulta medios de pago");
              msgResponse = getPayment(data);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 2: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception consulta medio de pago: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 2: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consulta medio de pago: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
            }
            break;

          case 3:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Opcion 3: fin de transaccion");
              // Log.logDebug(CLASSNAME + " Opcion 3: fin transaccion");
              msgResponse = endOfTransaction(data);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 3: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception al finalizar transaccion: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 3: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Thorwable final de transaccion: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
            }
            break;
          case 4:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Opcion 4: devolucion");
              // Log.logInfo(CLASSNAME + " Opcion 4: devolucion");
              msgResponse = queryRefund(data);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 4: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception en devolucion: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 4: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Thorwable devolucion: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
            }
            break;
          case 5:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Opcion 5: Mostrar descuentos");
              // Log.logInfo(CLASSNAME + " Opcion 5: Muestra Descuentos");
              msgResponse = getWeirdDiscount();
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 5: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception consulta cliente: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
              // System.out.println(e.getMessage());
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 5: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consutla cliente: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
              // System.out.println(t.getMessage());
            }
            break;
          case 6:
            try
            {
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Opcion 6: Cambio descuento");
              // Log.logInfo(CLASSNAME + " Opcion 6: Cambio Descuento");
              msgResponse = setWeirdDiscount(data);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 6: " + e.getClass().getName() + ":" + e.getMessage(), e);
              msgResponse = "300|Exception consulta cliente: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
              // System.out.println(e.getMessage());
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 6: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consutla cliente: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
              // System.out.println(t.getMessage());
            }
            break;
          case 7:
            // OJO solo supermaxi
            // String responseM = messageBuilder.generarMensajes();
            // if (responseM == null || responseM.length() == 0)
            // {
            // END SOLO SUPERMAXI
            // Se deja una respuesta, se quita lo demás, por una cosa que no se
            // usa aca
            msgResponse = "999";
            //OJO solo supermaxi
            // }
            // else
            // {
            // msgResponse = "999|" + responseM;
            // }
            //END SOLO SUPERMAXI
            break;
          case 8:
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Llamando retefuente v1.1...");
            // Log.logDebug("llamando retefuente v1.1 ...");
            UtilidadesDescuentos.inicializar();
            String acumulados = "";
            acumulados += UtilidadesDescuentos.acumuladoItem0() + "|" + UtilidadesDescuentos.consolidadoAticulos();
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "respueta retefuente: " + acumulados);
            // Log.logDebug("respueta retefuente: " + acumulados);
            msgResponse = "999|" + acumulados;
            break;
          case 9:
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Se procede a cargar propiedades");
            // Log.logInfo("Se procede a cargar propiedades");
            Core.cargarPropiedades();
            reiniciarConexion();
            con = getConexion();
            msgResponse = "999|Propiedades cargadas exitosamente";
            break;
          case 10:
            if (log.isInfoEnabled())
              log.info(
                CLASSNAME + "Opcion 10: yo que se..., La respuesta al universo, al mundo y a todo cuanto existe es 42");
            // Log.logInfo(CLASSNAME
            // +
            // "Opcion 10: yo que se..., La respuesta al universo, al mundo y a
            // todo cuanto existe es 42");
            Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            String dayS = "" + day;
            dayS = padear(dayS, "0", 2, "l");
            int month = cldr.get(Calendar.MONTH) + 1;
            String monthS = "" + month;
            monthS = padear(monthS, "0", 2, "l");
            int year = cldr.get(Calendar.YEAR);
            String yearS = "" + year;
            yearS = padear(yearS, "0", 4, "l");
            int hour = cldr.get(Calendar.HOUR_OF_DAY);
            String hourS = "" + hour;
            hourS = padear(hourS, "0", 2, "l");
            int minute = cldr.get(Calendar.MINUTE);
            String minuteS = "" + minute;
            minuteS = padear(minuteS, "0", 2, "l");
            int second = cldr.get(Calendar.SECOND);
            String secondS = "" + second;
            secondS = padear(secondS, "0", 2, "l");
            int milisecond = cldr.get(Calendar.MILLISECOND);
            String milisecondS = "" + milisecond;
            milisecondS = padear(milisecondS, "0", 3, "l");
            msgResponse = yearS + ":" + monthS + ":" + dayS + ":" + hourS + ":" + minuteS + ":" + secondS + ":"
              + milisecondS;
            break;
          // Para que se sientan bien con lo de la información de cliente
          case 11:
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Opcion 11: Se solicita información de cliente");
            // Log.logInfo(CLASSNAME +
            // "Opcion 11: Se solicita información de cliente");
            if (rspCliente != null && !rspCliente.equals(""))
              msgResponse = rspCliente;
            else
              msgResponse = "300|" + "No se ha realizado ninguna consulta al WS";
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Respuesta al consultar el cliente: " + msgResponse);
            // Log.logInfo(CLASSNAME + "Respuesta al consultar el cliente: " +
            // msgResponse);
            break;
          case 12:
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Procede a extraerse la información de la trama anterior");
            // Log.logInfo(CLASSNAME +
            // "Procede a extraerse la información de la trama anterior");
            try
            {
              RewardsResponse r = Instancia.getPenUltimaRespuestaLoyalty();
              msgResponse = getEOT(r);
              int existeCupon = 0;
              if (r.getCoupons() != null && r.getCoupons().getCoupon() != null && r.getCoupons().getCoupon().length > 0)
              {
                existeCupon = 1;
              }
              int totalDescuento = r.getRewardsGranted().getTotalDiscountAmount();
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Valor descuento total reportado por Loyalty " + totalDescuento);
              // Log.logInfo(CLASSNAME +
              // "Valor descuento total reportado por Loyalty " +
              // totalDescuento);
              if (!Core.tieneDecimales())
              {
                BigDecimal correct = new BigDecimal("" + totalDescuento);
                correct = correct.divide(centCorrec, 0, BigDecimal.ROUND_HALF_UP);
                totalDescuento = correct.intValue();
                if (log.isDebugEnabled())
                  log.debug(CLASSNAME + "Valor luego de corregir " + totalDescuento);
                // Log.logDebug(CLASSNAME + "Valor luego de corregir " +
                // totalDescuento);
              }
              msgResponse = msgResponse + "|" + existeCupon + "|" + totalDescuento + "|";
              if (msgResponse.length() > MAX_STRING_LENGTH)
              {
                if (log.isInfoEnabled())
                  log.info(CLASSNAME + "Resultado a Partir:  " + msgResponse);
                // Log.logInfo(CLASSNAME + "Resultado a Partir: " +
                // msgResponse);
                int result = breakString(msgResponse);
                msgResponse = "227|" + result + "|" + existeCupon + "|" + totalDescuento + "|";
                ;
              }
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "RTA: " + msgResponse);
              // Log.logInfo(CLASSNAME + "RTA: " + msgResponse);
            }
            catch (Exception e)
            {
              errorLog.error(CLASSNAME + "Exception 12: " + e.getClass().getName() + ":" + e.getMessage(), e);

              msgResponse = "300|Exception consulta cliente: " + e.getClass() + ":" + e.getLocalizedMessage();
              // e.printStackTrace();
              // System.out.println(e.getMessage());
            }
            catch (Throwable t)
            {
              errorLog.error(CLASSNAME + "Throwable 12: " + t.getClass().getName() + ":" + t.getMessage(), t);
              msgResponse = "300|Throwable consutla cliente: " + t.getClass() + ":" + t.getLocalizedMessage();
              // t.printStackTrace();
              // System.out.println(t.getMessage());
            }
            break;
          default:
            msgResponse = "300|Operacion no valida";
            break;
        }
      }
      else
      {
        msgResponse = "300|Faltan parametros";

      }
    }
    catch (Exception e)
    {
      // System.out.println("Error: " + e.getMessage());
      errorLog.error(CLASSNAME + "Exception getResponse: " + e.getClass().getName() + ":" + e.getMessage(), e);
      msgResponse = "300|Exception: " + e.getClass() + ":" + e.getLocalizedMessage();
      // e.printStackTrace();
    }
    return msgResponse;
  }

  /**
   * 
   * @param msg
   *          -> Mensaje con los datos para la petici�n SOAP
   * @return El String de respuesta de la petici�n de cliente, de la forma
   *         |nombre|apellido|sexo|titulo|actualizacion
   * @throws RemoteException
   *           TODO
   * @throws ServiceException
   *           TODO
   * @autor sebastian castaneda
   */
  public String getClient(String msg[]) throws RemoteException, ServiceException
  {
    currency = "";
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Iniciando Consulta de cliente");
    // Log.logInfo(CLASSNAME + "Iniciando Consulta de cliente");
    // OJO supermaxi only
    // wdm = new WeirdDiscountManager();
    //END SOLO SUPERMAXI
    consultarAnterior = false;
    Instancia.setUltimaRespuesta(null);

    String response = "";

    Reward reward[] = null;

    /*
     * sebastian.castaneda Se comprueba que la trama posea todo los camos
     * requeridos, en este caso que tenga al menos 8 posiciones
     */
    if (msg.length >= 8)
    {
      // Version 7 de loyalty
      Instancia.b = new BasketRequest();
      Instancia.b.setCashierID(msg[0]);
      currency = msg[1];
      if (log.isInfoEnabled())
        log.debug(CLASSNAME + "Currency code almacenado " + currency);
      // Log.logInfo(CLASSNAME + "Currency code almacenado " + currency);
      Instancia.b.setCurrencyCode(msg[1]);
      Instancia.b.setFunctionID("0302");
      Instancia.b.setPAN(msg[2]);
      Instancia.b.setPersist(false);
      Instancia.b.setProcessingCode("900000");
      Instancia.b.setSiteCode(padear(msg[3], "0", 5, "l"));
      Instancia.b.setTerminalID(msg[4]);
      Instancia.b.setTransactionDate(msg[5]);
      Instancia.b.setTransactionNumber(msg[6]);

      // return "999|Edgar,Cuesta,M,Sr,Nunca";

      transaccionActual = msg[6];
      if (transaccionAnterior.equals(""))
        transaccionAnterior = msg[6];

      Instancia.b.setTransactionTime(msg[7]);
      Instancia.b.setGiftRewards(new GiftRewards());
      Instancia.b.setPaymentMethods(new PaymentMethods());
      Instancia.b.setTicket(new Ticket());
      Instancia.b.setVoidedRewards(new VoidedRewards());
      try
      {
        /*
         * edgar.cuesta Algunos rewardResponse de cliente estaban llegando
         * nulos, se añade el tratamiento de nulos, antes de extraer los
         * detalles del cliente
         */
        RewardsResponse rewardRequest = callWS(false);
        if (rewardRequest != null)
        {
          rspCliente = procesamientoClientes(rewardRequest);
          if (rewardRequest.getTrxErrors() != null)
          {

            return "301|" + rewardRequest.getResponseCode() + ", Revise Voucher";
          }
        }
        return rspCliente;

      }
      catch (Exception e)
      {
        errorLog.error(CLASSNAME + " Exception: " + e.getClass().getName() + e.getMessage(), e);
        return response = "300| " + e.getClass().getName() + e.getMessage();
      }
    }
    else
    {
      errorLog.error(CLASSNAME + "No hay suficientes parametros para obtener el Cliente");
      // Log.logError("No hay suficientes parametros para obtener el Cliente");
      // System.out.println("No hay suficientes parametros para obtener el
      // Cliente");
      response = "300|Error: No hay suficientes parametros para obtener el cliente";
    }
    UtilidadesDescuentos.setReward(reward);
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Recibiendo respuesta del cliente esperado, con los sgtes datos: " + response);
    // Log.logInfo("Recibiendo respuesta del cliente esperado, con los sgtes
    // datos: "
    // + response);
    return response;
  }

  /**
   * 
   * @param tram
   *          trama de solicitud de operación*
   * @return trama respuesta de item, de la forma: |Math.round(totalamount)|Math
   *         .round(totaldiscount)|TicketMessage|CashierMessage
   *         |CustomerMessage|grantedcoupons|
   *         points2coupons|pointbalance|pointsearned|previouslyiussedcoup;
   * @throws RemoteException
   *           TODO
   * @throws ServiceException
   *           TODO
   * @author sebastian castaneda
   */
  public String getItem(String[] tram) throws RemoteException, ServiceException
  {
    // return "999|10000,0,0,0,0,0|10%Descuento,10%Descuento,10%Descuento";
    if (log.isDebugEnabled())
      log.info(CLASSNAME + " iniciando getItem... ");
    // Log.logInfo(CLASSNAME + " iniciando getItem... ");
    // se reinician los totales de los descuentos especiales
    // OJO solo supermaxi
    // if (wdm != null)
    // wdm.limpiarTotalesDescuentosEspeciales();
    // else
    // wdm = new WeirdDiscountManager();
    // messageBuilder = new GeneradorMensajesPorArticulos();
    //END SOLO SUPERMAXI
    consultarAnterior = false;
    // System.out.println(CLASSNAME + " iniciando getItem... ");
    String response = "";
    double totaldiscount = 0.0;
    double totalamount = 0;
    /*
     * sebastian.castaneda Se comprueba que al menos exista un item a consultar
     */
    if (tram.length >= 1)
    {
      Ticket ticket = new Ticket();
      ticket.setTicketDate(tram[0]);
      // OJO SuperMaxi y Flamingo -1, Almatex..todo el array, para la línea de abajo
      double price[] = new double[tram.length - 1];
      /*
       * edgar.cuesta 20/11/2012 Se añade la condición, para poder admitir las
       * consultas con items=0, con esto se procesa la trama de items, solo si
       * es mayor a cero, en caso contrario, se envía un ticket vacío
       */
      if (tram.length > 1)
      {
        /*
         * 12-08-2013 edgar.cuesta Se añade procesamiento en base a listas para
         * ahorrarme un ciclo y alguna comprobación de más, hacer pruebas
         * pertinentes respecto de tiempos de respuesta para ver si hay mejora
         * significativa
         */
        ArrayList lineItems = new ArrayList();
        ArrayList vdtosL = new ArrayList();
        int indexArticulos = 1;
        /*
         * sebastian.castaneda Se recorre la trama de consulta, para ubicar los
         * items en el array correspondiente El tamaña -1 para Flamingo y SM
         */
        // OJO SuperMaxi y Flamingo -1, Almatex..todo el array para la linea de abajo
        for (int i = 1; i < tram.length - 1; i++)
        {
          String product[] = tram[i].split(",");

          /*
           * sebastian.castaneda Verificando que corresponda con una trama de
           * consulta de item valida
           */
          if (product.length >= 4)
          {

            /*
             * edgar.cuesta Se separa la seleccion de vouchers redimidos vs la
             * seleccion de items almacenandolos en arrays diferentes
             */
            if (product[4].equalsIgnoreCase("v"))
            {
              VoucherDto vdtoAux = new VoucherDto();
              vdtoAux.setVoucherCode(product[2]);
              // countVoucher++;
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "HAY VOUCHER con codigo " + product[2]);
              // Log.logDebug(CLASSNAME + "HAY VOUCHER con codigo " +
              // product[2]);
              vdtosL.add(vdtoAux);
            }
            /*
             * edgar.cuesta Comprobación de bonos electronicos, y descuentos de
             * bonos especiales El procesamiento en java es similar
             */
            else if (product[4].equalsIgnoreCase("s") || product[4].equalsIgnoreCase("e"))
            {
              LineItem l_itemsAux = new LineItem();
              l_itemsAux.setQuantity(Integer.parseInt(product[0]));
              l_itemsAux.setProductCode(product[2]);
              if (log.isInfoEnabled())
                log.info(CLASSNAME + "Descuento \"Especial\" o Electronico");
              // Log.logInfo(CLASSNAME +
              // "Descuento \"Especial\" o Electronico");
              // System.out.println(CLASSNAME +
              // "Descuento \"Especial\" o Electronico");
              l_itemsAux.setIndex(indexArticulos++);
              lineItems.add(l_itemsAux);
            }
            else
            {
              LineItem l_itemsAux = new LineItem();
              /*
               * edgar.cuesta Con esta condición, podemos trabajar con monedas
               * que admiten centavos restándole trabajo a BASIC
               */
              if (Core.tieneDecimales())
              {
                BigDecimal auxMejora = new BigDecimal(product[3]).divide(ProcessRequest.centCorrec, 2,
                  BigDecimal.ROUND_HALF_UP);
                price[i - 1] = auxMejora.doubleValue();
              }
              else
              {
                price[i - 1] = Double.parseDouble(product[3]);
              }
              l_itemsAux.setProductPrice(price[i - 1]);
              totalamount = totalamount
                + (price[i - 1]) * Double.parseDouble(product[0]) * Double.parseDouble(DECIMALES);
              l_itemsAux.setQuantity(Integer.parseInt(product[0]));
              l_itemsAux.setFamilyCode(product[1]);
              l_itemsAux.setProductCode(product[2]);
              if (product[4].trim().equals("1"))
                l_itemsAux.setNonDiscountable(true);
              else
                l_itemsAux.setNonDiscountable(false);
              if (Integer.parseInt(product[0]) < 0)
              {
                l_itemsAux.setProductType(2);
              }
              else
              {
                l_itemsAux.setProductType(0);
              }
              l_itemsAux.setIndex(indexArticulos++);
              lineItems.add(l_itemsAux);
            }
          }
        }
        // OJO
//         Para Flamingo y SM, no para almatex/crystal
        TransactionLimitation[] trxLimit = new TransactionLimitation[1];
        trxLimit[0] = new TransactionLimitation();
        if (Core.tieneDecimales())
        {
          trxLimit[0].setLimit(
            new BigDecimal(tram[tram.length - 1]).divide(centCorrec, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        else
        {
          trxLimit[0].setLimit(Double.parseDouble(tram[tram.length - 1]));
        }
        if (log.isInfoEnabled())
          log.debug(CLASSNAME + "Maximo descuento otorgable " + tram[tram.length - 1]);
        trxLimit[0].setCategory(2);
        TransactionLimitations trxLimits = new TransactionLimitations();
        trxLimits.setTransactionLimitation(trxLimit);
        Instancia.b.setTransactionLimitations(trxLimits);
        //END Flamingo y Supermaxi, no Almatex/Crystal
        /*
         * edgar.cuesta Se comprueba que exista al menos un producto a
         * consultar, Nota: Verificar si por regla del negocio es posible tener
         * una trama solo con vouchers redimidos, mientras se deja esta fraccion
         * de codigo aca
         */
        if (lineItems.size() > 0)
        {
          LineItem[] l_items = new LineItem[lineItems.size()];
          lineItems.toArray(l_items);
          LineItems lineitems = new LineItems();
          lineitems.setLineItem(l_items);
          ticket.setLineItems(lineitems);
        }
        /*
         * edgar.cuesta Si hay al menos un voucher redimido, para a�adir al
         * ticket
         */
        if (vdtosL.size() > 0)
        {
          VoucherDto[] vdtos = new VoucherDto[vdtosL.size()];
          vdtosL.toArray(vdtos);
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "metiendo vouchers para redimir " + vdtosL.size());
          // Log.logInfo(CLASSNAME + "metiendo vouchers para redimir " +
          // vdtosL.size());
          VouchersDto vdto = new VouchersDto();
          vdto.setVoucher(vdtos);
          ticket.setVouchers(vdto);
        }
      }
      Instancia.b.setFunctionID("9000");
      Instancia.b.setGiftRewards(new GiftRewards());
      Instancia.b.setPaymentMethods(new PaymentMethods());
      Instancia.b.setTicket(ticket);
      Instancia.b.setVoidedRewards(new VoidedRewards());
      try
      {
        RewardsResponse requestRewards = callWS(false);
        response = extraerRespuestaItem(requestRewards, totalamount);
        /*
        *
        */

      }
      catch (Exception e)
      {
        // e.printStackTrace();
        errorLog.error(CLASSNAME + " Exception: " + e.getCause() + ":" + e.getMessage(), e);
        // Log.logError(CLASSNAME + " Exception: " + e.getMessage());
        return response = "300| " + e.getCause() + ":" + e.getMessage();

      }
    }
    else
    {
      Instancia.b.setTicket(new Ticket());
      Instancia.reStartVectorItem();
      Instancia.reStartVectorItem0();
      Instancia.reStartCuponItem();
      response = "300|Trama de consulta de Item vacia";
      log.warn(CLASSNAME + "Respuesta: " + response);
      // Log.logWarning(CLASSNAME + "Respuesta: " + response);
    }

    // Log.logInfo(CLASSNAME + "Respuesta de item :" + response);
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Respuesta de item :" + response);
    return response;
  }

  /**
   * 
   * @param reward
   *          las Rewards a sumar
   * @return suma de rewards de categor�a 2, el cual es el acumulado de los
   *         rewards
   */
  private double addRewards(Reward[] reward)
  {
    if (reward == null || reward.length == 0)
    {
      return 0;
    }
    else
    {
      double totalDiscount = 0;
      for (int i = 0; i < reward.length; i++)
      {
        if (reward[i].getCategory() == 2)
        {
          // Log.logDebug(CLASSNAME + "Valor de descuento de reward " + i + "="
          // + reward[i].getRewardAmount());
          if (log.isDebugEnabled())
            log.debug(CLASSNAME + "Valor de descuento de reward " + i + "=" + reward[i].getRewardAmount());
          totalDiscount += reward[i].getRewardAmount();
        }
      }
      return totalDiscount;
    }
  }

  /**
   * @param tram
   *          Trama de consulta de medios de pago. De la forma
   *          2|InfoMedioPago1|...|InfoMedioPagon donde cada medio de pago es un
   *          par separado por coma de codigo medio pago y valor ( cod,value)
   * @return Un String con toda la informacion de descuentos totales Mismo
   *         formato que la consulta de item, como sigue:
   *         |Math.round(totalamount)|Math
   *         .round(totaldiscount)|TicketMessage|CashierMessage
   *         |CustomerMessage|grantedcoupons|
   *         points2coupons|pointbalance|pointsearned|previouslyiussedcoup;
   * @throws RemoteException
   *           TODO
   * @throws ServiceException
   *           TODO
   * @author sebastian.castaneda
   */
  public String getPayment(String[] tram) throws RemoteException, ServiceException
  {

    // return "999|10000,0,0,0,0,0|10%Descuento,10%Descuento,10%Descuento";
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + " iniciando getPayment... ");
    // Log.logInfo(CLASSNAME + " iniciando getPayment... ");
    consultarAnterior = false;
    String response = "";
    double totaldiscount = 0.0;
    double totalamount = 0;
    double descuentoProdXPago = 0;

    Reward reward[] = null;

    if (tram.length >= 1)
    {
      PaymentMethods paymentm = new PaymentMethods();
      // OJO SuperMaxi y Flamingo -1, Almatex..todo el array, las dos línea de abajo
      PaymentMethod p[] = new PaymentMethod[tram.length - 1];
      for (int i = 0; i < tram.length - 1; i++)
      {
        String product[] = tram[i].split(",");
        if (product.length >= 2)
        {
          totalamount = totalamount + (new Double(product[1]).doubleValue());
          PaymentMethod pay = new PaymentMethod();
          /*
           * edgar.cuesta Con esta condición, podemos trabajar con monedas que
           * admiten centavos restándole trabajo a BASIC
           */
          BigInteger priceAux;
          if (Core.tieneDecimales())
          {
            priceAux = new BigInteger(product[1]);
            pay.setAmount(priceAux.longValue());
          }
          else
          {
            /*
             * edgar.cuesta Al parecer loyalty espera en el monto del medio de
             * pago un valor decimal con las ultimas dos cifras representando
             * los decimales, si la terminal no trabaja con decimales, entonces
             * multiplicamos el valor por 100, para obtener las ultimas dos
             * cifras con 0's
             */
            priceAux = new BigInteger(product[1]).multiply(new BigInteger(DECIMALES));
            pay.setAmount(priceAux.longValue());
          }
          if (log.isDebugEnabled())
            log.debug(CLASSNAME + "Cantidad en medio de pago: " + priceAux.longValue());
          // Log.logDebug(CLASSNAME + "Cantidad en medio de pago: " +
          // priceAux.longValue());
          pay.setPaymentMode(product[0]);
          p[i] = pay;
        }
      }
      // OJO Supermaxi y Flamingo, no para Almatex/Crystal
      TransactionLimitation[] trxLimit = new TransactionLimitation[1];
      trxLimit[0] = new TransactionLimitation();
      if (Core.tieneDecimales())
      {
        trxLimit[0].setLimit(
          new BigDecimal(tram[tram.length - 1]).divide(centCorrec, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
      }
      else
      {
        trxLimit[0].setLimit(Double.parseDouble(tram[tram.length - 1]));
      }
      trxLimit[0].setCategory(2);
      TransactionLimitations trxLimits = new TransactionLimitations();
      trxLimits.setTransactionLimitation(trxLimit);
      Instancia.b.setTransactionLimitations(trxLimits);
      if (log.isDebugEnabled())
        log.debug(CLASSNAME + "Maximo descuento otorgable " + tram[tram.length - 1]);
      //END Supermaxi y Flamingo, no para Almatex/Crystal
      paymentm.setPaymentMethod(p);
      Instancia.b.setFunctionID("9000");
      Instancia.b.setGiftRewards(new GiftRewards());
      Instancia.b.setPaymentMethods(paymentm);
      Instancia.b.setVoidedRewards(new VoidedRewards());
      try
      {
        RewardsResponse requestRewards = callWS(false);
        String ticketMessage = "", CashierMessage = "", CustomerMessage = "";
        Instancia.reStartVectorPay();
        if (requestRewards != null)
        {
          Instancia.setUltimaRespuesta(requestRewards);
          message.setRwr(requestRewards);
          if (requestRewards.getTrxErrors() != null)
          {
            TrxError[] trxErrors = requestRewards.getTrxErrors().getTransactionError();
            if (trxErrors.length > 0)
            {
              for (int i = 0; i < trxErrors.length; i++)
              {
                errorLog.error(CLASSNAME + "Error en loyalty: " + trxErrors[i].getErrorCode() + "-"
                  + trxErrors[i].getErrorDescription());
                // Log.logError(CLASSNAME + "Error en loyalty: " +
                // trxErrors[i].getErrorCode() + "-"
                // + trxErrors[i].getErrorDescription());
              }
              return "301|" + requestRewards.getResponseCode() + ", Revise Voucher";
            }
          }
          rspCliente = procesamientoClientes(requestRewards);
          int grantedcoupons = requestRewards.getRewardsGranted().getNumberGrantedCoupons();
          int points2coupons = requestRewards.getRewardsGranted().getNumberPointsConvertedIntoCoupons();
          int pointbalance = requestRewards.getRewardsGranted().getPointsBalance();
          int pointsearned = new Double(Math.round(requestRewards.getRewardsGranted().getPointsEarned())).intValue();
          int previouslyiussedcoup = requestRewards.getRewardsGranted().getPreviouslyIssuedCoupons();
          int temppointbalance = requestRewards.getRewardsGranted().getTempPointsBalance();
          totaldiscount = requestRewards.getRewardsGranted().getTotalDiscountAmount();
          CashierMessage = requestRewards.getCashierMessage();
          CustomerMessage = requestRewards.getCustomerMessage();
          if (ticketMessage == null)
            ticketMessage = " ";
          if (CashierMessage == null)
            CashierMessage = " ";
          if (CustomerMessage == null)
            CustomerMessage = " ";
          reward = requestRewards.getRewardsGranted().getRewards().getReward();
          ticketMessage = message.getMessages();
          if (reward == null || reward.length == 0)
          {
            ticketMessage = " ";
            CashierMessage = " ";
            CustomerMessage = " ";
          }
          // ticketMessage = requestRewards.getTicketMessage();
          if (Core.tieneDecimales())
          {
            totaldiscount = new BigDecimal(totaldiscount).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
            descuentoProdXPago = new BigDecimal(descuentoProdXPago)
              .divide(new BigDecimal(DECIMALES), 0, BigDecimal.ROUND_HALF_UP).intValue();
          }
          else
          {
            totaldiscount = new BigDecimal(totaldiscount).divide(new BigDecimal(DECIMALES), 0, BigDecimal.ROUND_HALF_UP)
              .longValue();
          }
          response = "999|" + new Double(totalamount).longValue() + "|"
            + new Double(Math.round(totaldiscount)).longValue() + "|" + ticketMessage + "|" + CashierMessage + "|"
            + CustomerMessage + "|" + grantedcoupons + "|" + points2coupons + "|" + pointbalance + "|" + pointsearned
            + "|" + previouslyiussedcoup + "|" + new Double(descuentoProdXPago).longValue();
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "Respuesta medio de pago " + response);
          // Log.logInfo(CLASSNAME + "Respuesta medio de pago " + response);
        }
        else
        {
          response = "999| | | | | | | | | | |";
          log.warn(CLASSNAME + "No hubo descuentos de parte de Loyalty");
          // Log.logWarning(CLASSNAME +
          // "No hubo descuentos de parte de Loyalty");
        }
      }
      catch (Exception e)
      {
        // e.printStackTrace();
        errorLog.error(CLASSNAME + "Exception: " + e.getClass() + ":" + e.getMessage(), e);
        return response = "300| " + e.getClass() + ":" + e.getMessage();
      }
    }
    else
    {
      return "300|No hay parametros de consulta";
    }
    Instancia.reStartVectorPay();
    Instancia.reStartCuponPay();
    UtilidadesDescuentos.setReward(reward);
    return response;
  }

  /**
   * Metodo encargado de realizar como tal la transaccion sobre loyalty y
   * tambien de cerrarla. A su vez debe procesar los vouchers, y modificar los
   * valores de medio de pago netos. (lo que al final paga el cliente)
   * 
   * @param tram
   *          Trama consulta de fin de transaccion de la forma
   *          3|InfoMedioPago1|...|InfoMedioPagoN donde cada InfoMedioPago,
   *          corresponde con un par codigo de medio pago valor (separados por
   *          coma), que sua el EOT para sobreescribir los valores que al final
   *          quedaran en Loyalty para medios de pago
   * @return trama de respuesta con el siguiente formato:
   *         COD|ResumenRewardItem|ResumenRewardItem0
   *         |ResumRewardPM|ResumenCampañas|coupons|existeCoupon Donde cada
   *         campo corresponde a: -COD: Idem a consulta de producto
   *         -ResumenRewardItem: Cadena de la forma:
   *         RewardIem1~RewardItem2~...~RewardItemn, donde: -RewardItemi
   *         (i=1,2,...,n): es una cadena de la forma:
   *         ProductCode,RewardAmont,Despription. Donde -ProductCode: Código del
   *         producto, sobre el que se hará el resumen de descuentos
   *         -RewardAmount: Descuentos acumulados, asociados y/o asignados al
   *         producto -Description: Despripción del primer descuento asociado al
   *         producto (sólo el primero) -ResumenRewardItem0: Equivalente al
   *         ResumenRewardIten, sólo que aplicado a los reward con indice 0.
   *         (Actualmente, no se utiliza) -ResumenRewardPM: Resumen de
   *         Descuentos para medios de pago. Luego de una gran modificación
   *         realizada al PEF, no existen descuentos asociados a medios de pago,
   *         no se utiliza -ResumenCampañas: Cadena de la forma
   *         InfoCampaña1~InfoCampaña2~...~InfoCampañan donde -InfoCampañai
   *         (i=1,2,...,n):RewardId,RewardAmount,Despription -RewardId: Lo
   *         identificación del descuento. -RewardAmount: Ídem de
   *         ResumenRewardItem. -Description: Ídem de ResumenRewardItem.
   *         -coupons: String, que posee toda la información de cupones/vouchers
   *         (como se llamen) concatenada fechaInico+fechaFin+Mensaje+id, puede
   *         haber varios, separados por '~'
   * @throws RemoteException
   *           TODO
   * @throws ServiceException
   *           TODO
   * @author sebastian.castaneda
   */
  public String endOfTransaction(String[] tram) throws RemoteException, ServiceException
  {
    if (log.isDebugEnabled())
    {
      log.debug(CLASSNAME + "Iniciando EOT");
      log.debug(CLASSNAME + "Se debe extraer: " + tram[tram.length - 1].trim().equals("0"));
    }
    // Log.logInfo(CLASSNAME + "Iniciando EOT");
    /*
     * edgar.cuesta Por el momento sólo para supermaxi, para soportar tramas
     * largas, estás se almacenan en un array en Instancia (¡puaj!) se almacena
     * así mismo un cursor, y por este lado, se verifica en el último campo de
     * la trama, si se busca de ese Array o si se va a consultar a Loyalty
     */
    // Log.logDebug(CLASSNAME + "Se debe extraer: " + tram[tram.length -
    // 1].trim().equals("0"));
    if ((tram[tram.length - 1].trim().equals("1")))
    {
      String response = Instancia.getRta();
      // Log.logDebug(CLASSNAME + "Se devuelve: " + response);
      if (log.isDebugEnabled())
        log.debug(CLASSNAME + "Se devuelve: " + response);
      return response;
    }
    consultarAnterior = true;
    // Preprocesamiento, a los nuevos valores de medios de pago
    PaymentMethods paymentm = new PaymentMethods();
    if (tram.length >= 1)
    {
      // PaymentMethods paymentm = new PaymentMethods();
      PaymentMethod p[] = new PaymentMethod[tram.length];
      for (int i = 0; i < tram.length; i++)
      {
        String product[] = tram[i].split(",");
        if (product.length >= 2)
        {
          PaymentMethod pay = new PaymentMethod();
          /*
           * edgar.cuesta Con esta condición, podemos trabajar con monedas que
           * admiten centavos restándole trabajo a BASIC
           */
          BigInteger priceAux;
          if (Core.tieneDecimales())
          {
            priceAux = new BigInteger(product[1]);// .divide(new
            // BigDecimal(DECIMALES),2,BigDecimal.ROUND_HALF_UP);
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Cantidad en medio de pago: " + priceAux.longValue());
            // Log.logDebug(CLASSNAME + "Cantidad en medio de pago: " +
            // priceAux.longValue());
            pay.setAmount(priceAux.longValue());
          }
          else
          {
            /*
             * edgar.cuesta Al parecer loyalty espera en el monto del medio de
             * pago un valor decimal con las ultimas dos cifras representando
             * los decimales, si la terminal no trabaja con decimales, entonces
             * multiplicamos el valor por 100, para obtener las ultimas dos
             * cifras con 0's, no descomentar, siguintes dos líneas hasta
             * aclarar bien que impacto puede tener esto
             */
            priceAux = new BigInteger(product[1]).multiply(new BigInteger(DECIMALES));
            // pay.setAmount(priceAux.longValue());
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Cantidad en medio de pago: " + priceAux.longValue());
            // Log.logDebug(CLASSNAME + "Cantidad en medio de pago: " +
            // priceAux.longValue());
            pay.setAmount(priceAux.longValue());
          }
          pay.setPaymentMode(product[0]);
          p[i] = pay;
        }
      }
      paymentm.setPaymentMethod(p);
    }

    // Elimina el archivo de cupones anterior
    tiposCupones = new ArrayList();

    // Voucher.delete();
    String response = "";
    try
    {
      Instancia.b.setFunctionID("9100");
      RewardsResponse r = callWS(false);
      rspCliente = procesamientoClientes(r);
      // si la respuesta es nula, se trabaja con la ultima respuesta
      if (r == null)
      {
        log.warn(CLASSNAME
          + "Respuesta Mala del web service(probable error de conexion)...se procede a capturar la consulta anterior");
        // Log.logWarning(CLASSNAME
        // +
        // "Respuesta Mala del web service(probable error de conexion)...se
        // procede a capturar la consulta anterior");
        r = Instancia.getUltimaRespuesta();
        if (r == null)
        {
          return "999|||||0|0|0|";
          // TODO Crystal
          // return "999|||||0|";
        }
      }
      else
      {
        Instancia.setUltimaRespuesta(r);
        String an = r.getRewardsGranted().getAuditNumber();
        response = getEOT(r);
        // response = "";
        int existeCupon = this.escribirVoucher(r);
        long totalDescuento = r.getRewardsGranted().getTotalDiscountAmount();
        if (log.isInfoEnabled())
          log.info(CLASSNAME + "Valor descuento total reportado por Loyalty " + totalDescuento);
        // Log.logInfo(CLASSNAME +
        // "Valor descuento total reportado por Loyalty " + totalDescuento);
        if (!Core.tieneDecimales())
        {
          BigDecimal correctTotal = new BigDecimal("" + totalDescuento);
          correctTotal = correctTotal.divide(centCorrec, 0, BigDecimal.ROUND_HALF_UP);
          totalDescuento = correctTotal.longValue();
          if (log.isDebugEnabled())
            log.debug(CLASSNAME + "Valor luego de corregir " + totalDescuento);
          // Log.logDebug(CLASSNAME + "Valor luego de corregir " +
          // totalDescuento);
        }
        if (log.isDebugEnabled())
        {
          log.debug(CLASSNAME + "Valor total de descuentos con indice 0 " + totalIndice0);
        }
        // TODO Crystal no debe tenerlo
        response = response + "|" + totalIndice0 + "|" + existeCupon + "|" + totalDescuento + "|";
        if (an != null)
        {
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "Se procede a efectuar el cierre en Loyalty");
          // Log.logInfo(CLASSNAME +
          // "Se procede a efectuar el cierre en Loyalty");
          paymentm.setAuditNumber(an);
          Instancia.b.setFunctionID("9220");
          Instancia.b.setPaymentMethods(paymentm);
          RewardsResponse rr = callWS(true);
        }
        if (response.length() > MAX_STRING_LENGTH)
        {
          // Log.logInfo(CLASSNAME + "Resultado a Partir: " + response);
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "Resultado a Partir:  " + response);
          int result = breakString(response);
          response = "227|" + result + "|" + existeCupon + "|" + totalDescuento + "|" + totalIndice0 + "|";

        }
      }
    }
    catch (Throwable e)
    {
      errorLog.error("Exception: " + e.getClass() + ":" + e.getMessage(), e);
      cierreVoucher();
      response = "300| " + e.getMessage();
    }
    // Log.logInfo(CLASSNAME + "Resultados obtenidos: " + response);
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Resultados obtenidos: " + response);
    // response = "300|null" ;
    return response;

  }

  private int writeString(String response)
  {
    File file = new File("R::C:/larga.txt");
    try
    {
      FileWriter writer = new FileWriter(file);
      writer.write(response);
      writer.flush();
      writer.close();
      return 1;
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      errorLog.error(CLASSNAME + "Fallo al escribir trama larga: " + e.getClass() + ":" + e.getMessage());
      // Log.logError(CLASSNAME + "Fallo al escribir trama larga: " +
      // e.getClass() + ":" + e.getMessage());
      return 0;
    }
  }

  private int breakString(String toBreak)
  {
    Instancia.restartRta();
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + "Tamaño String a partir: " + toBreak.length());
    // Log.logDebug(CLASSNAME + "Tamaño String a partir: " + toBreak.length());
    int curs = 0;
    int rta = 0;
    while (curs < toBreak.length())
    {
      int max = 0;
      if ((curs + MAX_STRING_LENGTH) >= toBreak.length())
      {
        max = toBreak.length();
      }
      else
      {
        max = MAX_STRING_LENGTH + curs;
      }
      String partx = toBreak.substring(curs, max);
      curs = max;
      if (log.isInfoEnabled())
        log.info(CLASSNAME + "Parte # " + rta + " ,max: " + curs);
      // Log.logInfo(CLASSNAME + "Parte # " + rta + " ,max: " + curs);
      Instancia.addRta(partx);
      rta++;
    }
    return rta;
  }

  /**
   * @param tram
   *          Trama de tipo devoluciones: TO|DatosDevolucion
   * @return Descuento negativo asociado a esa transacción para devolver al
   *         usuario. De la forma:
   * 
   */
  public String queryRefund(String[] tram)
  {
    String response = "999";
    if (tram == null || tram.length == 0)
    {
      return "300|No hay datos para consultar Devoluciones";
    }
    else if (tram.length < 6)
    {
      return "300|No hay datos suficientes para consultar devoluciones";
    }
    else
    {
      RefundManagement rfMng = new RefundManagement();
      if (log.isInfoEnabled())
        log.info(CLASSNAME + "Currency code almacenado " + currency);
      // Log.logInfo(CLASSNAME + "Currency code almacenado " + currency);
      Instancia.b = new BasketRequest();
      if (currency != null)
        Instancia.b.setCurrencyCode(currency);
      Instancia.b.setFunctionID("9101");
      String pAN = tram[0];
      String trxNumber = tram[1];
      String trxDate = tram[2];
      String trxTime = tram[3];
      String site = tram[4];
      while (site.length() < 5)
      {
        site = "0" + site;
      }
      String terminal = tram[5];
      Instancia.b.setPAN(pAN);
      if (log.isDebugEnabled())
      {
        log.debug("PAN a buscar: " + pAN);
        log.debug("Numero de transaccion a buscar: " + trxNumber);
        log.debug("Fecha de transaccion a buscar: " + trxDate);
        log.debug("Hora de transaccion a buscar: " + trxTime);
      }
      // Log.logDebug("PAN a buscar: " + pAN);
      // Log.logDebug("Numero de transaccion a buscar: " + trxNumber);
      // Log.logDebug("Fecha de transaccion a buscar: " + trxDate);
      // Log.logDebug("Hora de transaccion a buscar: " + trxTime);
      Instancia.b.setProcessingCode("900000");
      Instancia.b.setTransactionNumber(trxNumber);
      Instancia.b.setTransactionDate(trxDate);
      if (trxTime.length() < 6)
        trxTime = trxTime + "00";
      Instancia.b.setTransactionTime(trxTime);
      Instancia.b.setSiteCode(site);
      Instancia.b.setTerminalID(terminal);
      LineItem lineItems[] = new LineItem[tram.length - 4];
      for (int i = 6; i < tram.length; i++)
      {
        StringTokenizer separarConsulta = new StringTokenizer(tram[i], ",");

        // Bandera para determinar paridad e imparidad
        int j = 0;
        LineItem lineItemAux = new LineItem();
        lineItemAux.setProductType(2);
        String prodCode = separarConsulta.nextToken();
        while (prodCode.length() < 12)
        {
          prodCode = "0" + prodCode;
        }
        if (log.isDebugEnabled())
          log.debug(CLASSNAME + "Product code # " + j + " " + prodCode);
        // Log.logDebug(CLASSNAME + "Product code # " + j + " " + prodCode);
        lineItemAux.setProductCode(prodCode);
        lineItemAux.setNonDiscountable(false);
        double quantity = 0;
        String cantidad = separarConsulta.nextToken();
        if (log.isDebugEnabled())
          log.debug(CLASSNAME + "cantidad producto # " + j + " " + cantidad);
        // Log.logDebug(CLASSNAME + "cantidad producto # " + j + " " +
        // cantidad);
        quantity = Double.parseDouble(cantidad);
        lineItemAux.setQuantity(quantity);
        lineItems[j] = lineItemAux;
        lineItemAux = new LineItem();
        j++;
      }
      LineItems items = new LineItems();
      items.setLineItem(lineItems);
      Ticket ticket = new Ticket();
      ticket.setLineItems(items);
      Instancia.b.setTicket(ticket);
      try
      {
        RewardsResponse rw = callWS(false);
        if (rw == null)
        {
          response = "300|No hubo respuesta de parte de Loyalty";
        }
        if (rw.getTrxErrors() != null)
        {
          TrxError trxError = rw.getTrxErrors().getTransactionError(0);
          response = "301|" + trxError.getErrorCode() + "," + trxError.getItemCode() + ","
            + trxError.getErrorDescription();
        }
        if (!(rw.getResponseCode().equals("0") || rw.getResponseCode().equals("8")))
        {
          response = "301|Codigo respuesta: " + rw.getResponseCode();
        }
        else
        {
          Rewards rewards = rw.getRewardsGranted().getRewards();
          if (rewards != null)
          {
            log.info("[ProcessRequest]Hubo Respuesta del ws");
            // Log.logInfo("[ProcessRequest]Hubo Respuesta del ws");
            Reward[] rews = rewards.getReward();
            rfMng.extractRefunds(rews);
            // Para cerrar la transacción que se genera
            Instancia.b.setFunctionID("9220");
            String auditNumber = rw.getRewardsGranted().getAuditNumber();
            PaymentMethods paym = new PaymentMethods();
            paym.setAuditNumber(auditNumber);
            Instancia.b.setPaymentMethods(paym);
            // Se extrae la fecha para que quede de manera correcta en Loyalty
            Calendar cal = Calendar.getInstance();
            String year = "" + cal.get(Calendar.YEAR);
            int mont = cal.get(Calendar.MONTH);
            mont++;
            String month = "" + mont;
            while (month.length() < 2)
            {
              month = "0" + month;
            }
            String day = "" + cal.get(Calendar.DAY_OF_MONTH);
            while (day.length() < 2)
            {
              day = "0" + day;
            }
            String hour = "" + cal.get(Calendar.HOUR_OF_DAY);
            while (hour.length() < 2)
            {
              hour = "0" + hour;
            }
            String minute = "" + cal.get(Calendar.MINUTE);
            while (minute.length() < 2)
            {
              minute = "0" + minute;
            }
            String second = "" + cal.get(Calendar.SECOND);
            while (second.length() < 2)
            {
              second = "0" + second;
            }
            String date = year + month + day;
            String time = hour + minute + second;
            if (log.isDebugEnabled())
              log.debug("[ProccessRequest]Fecha y hora " + date + ":" + time);
            // Log.logDebug("[ProccessRequest]Fecha y hora " + date + ":" +
            // time);
            Instancia.b.setTransactionDate(date);
            Instancia.b.setTransactionTime(time);
            callWS(false);
            response = rfMng.trama();
          }
        }
      }
      catch (AxisFault e)
      {
        errorLog.error(CLASSNAME + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage() + "-"
          + e.getFaultActor() + " " + e.getFaultReason(), e);
        // Log.logError(CLASSNAME + "Exception " + e.getClass().getName() + ":"
        // + e.getLocalizedMessage() + "-"
        // + e.getFaultActor() + " " + e.getFaultReason());
        response = "300|" + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage();
        // e.printStackTrace();
      }
      catch (Exception e)
      {
        errorLog.error(CLASSNAME + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage(), e);
        // Log.logError(CLASSNAME + "Exception " + e.getClass().getName() + ":"
        // + e.getLocalizedMessage());
        response = "300|" + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage();
        // e.printStackTrace();
      }
      catch (Throwable e)
      {
        errorLog.error(CLASSNAME + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage(), e);
        // Log.logError(CLASSNAME + "Exception " + e.getClass().getName() + ":"
        // + e.getLocalizedMessage());
        response = "300|" + "Exception " + e.getClass().getName() + ":" + e.getLocalizedMessage();
        // e.printStackTrace();
      }
    }
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + "Respuesta " + response);
    // Log.logDebug(CLASSNAME + "Respuesta " + response);
    return response;
  }

  /**
   * Metodo util para añadir el caracter deseado a la izquierda o a la derecha
   * para obtener una longitud deseada
   * 
   * @param APadear
   *          String a modificar (sobre el que se va a operar)
   * @param Con
   *          String que se empleará para completar la longitud (TODO ¿No
   *          debería ser un char?)
   * @param Cuanto
   *          Cantidad de veces que debe escribirse Con
   * @param lado
   *          'l' para izquierda, 'r' para derecha
   * @return String modificado
   */
  public String padear(String APadear, String Con, int Cuanto, String lado) // lado
  {
    String padeado = APadear;
    for (int i = APadear.length(); i < Cuanto; i++)
    {
      if (lado.endsWith("l"))
        padeado = Con + padeado;
      else if (lado.endsWith("r"))
        padeado = padeado + Con;
      else
        padeado = APadear;
    }
    return padeado;
  }

  /*
   * Metodo que manipula la conexion al servicio web
   */
  private RewardsResponse callWS(boolean justOneTry) throws Exception
  {
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Iniciando llamado a WS...");
    // Log.logInfo(CLASSNAME + "Iniciando llamado a WS...");
    RewardsResponse requestRewards = null;
    /*
     * se valida que con tenga un valor valido. No sea ni nulo, ni el String
     * vacío
     */
    if (con != null && !con.equals("") && !con.trim().equalsIgnoreCase("null"))
    {
      if (log.isInfoEnabled())
      {
        log.info(CLASSNAME + "Direccion: " + con);
        log.info(CLASSNAME + "tiempo de espera: " + timeOut);
      }
      // Log.logInfo(CLASSNAME + "Direccion: " + con);
      // Log.logDebug(CLASSNAME + "tiempo de espera: " + timeOut);
      try
      {
        Class[] clases = { String.class };
        String[] obj = { con };
        Control_TimeOut cto = new Control_TimeOut(timeOut,
          "com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.CallFALWS", "conectWS", null, null, clases, obj);
        Object obj1 = cto.execute_object();
        if (log.isInfoEnabled())
        {
          log.info(CLASSNAME + "Terminando Peticion llamado a WS...");
          log.info(CLASSNAME + "Objeto de respuesta es " + obj1);
        }
        // Log.logInfo(CLASSNAME + "Terminando Peticion llamado a WS...");
        // Log.logInfo(CLASSNAME + "Objeto de respuesta es " + obj1);
        if (obj1 instanceof Exception)
        {
          errorLog.error("Error a la hora de hacer el llamado" + ((Exception) obj1).getClass() + ":"
            + ((Exception) obj1).getMessage(), ((Exception) obj1));
          // Log.logError("Error a la hora de hacer el llamado" + ((Exception)
          // obj1).getMessage());
          if (justOneTry)
          {
            if (log.isDebugEnabled())
              log.debug(CLASSNAME + "Ha fallado el intento de consulta, y solo se admitia 1");
            // Log.logDebug(CLASSNAME +
            // "Ha fallado el intento de consulta, y solo se admitia 1");
            if (consultarAnterior)
            {
              return null;
            }
            else
              throw (Exception) obj1;
          }
          else
          {
            /*
             * se solicita nueva conexion (de respaldo) para volver a intentar
             */
            // cursor++;
            requestRewards = nuevoIntentoConexion();
            // Si fallan todos los intentos
            if (requestRewards == null)
            {
              if (consultarAnterior)
              {
                return null;
              }
              else
                throw (Exception) obj1;
            }
          }
        }
        else if (obj1 == null)
        {
          log.warn(CLASSNAME + "La consulta no ha traido respuesta");
          // Log.logWarning(CLASSNAME + "La consulta no ha traido respuesta");
          if (justOneTry)
          {
            log.warn(CLASSNAME + "Ha fallado el intento de consulta, y solo se admitia 1");
            // Log.logWarning(CLASSNAME +
            // "Ha fallado el intento de consulta, y solo se admitia 1");
            return null;
          }
          else
          {
            /*
             * se solicita nueva conexion (de respaldo) para volver a intentar
             */
            // cursor++;
            requestRewards = nuevoIntentoConexion();
          }
        }
        else
        {
          requestRewards = (RewardsResponse) obj1;
        }
        // requestRewards=FalWSL.getFALWebServicesImplPort().requestRewards(Instancia.b);
      }
      catch (NullPointerException e)
      {
        // Log.logError(CLASSNAME +
        // "NullPointerException tratando de consultar al ws");
        errorLog.error(CLASSNAME + "NullPointerException tratando de consultar al ws", e);
        if (justOneTry)
        {
          log.warn(CLASSNAME + "Ha fallado el intento de consulta, y solo se admitia 1");
          // Log.logWarning(CLASSNAME +
          // "Ha fallado el intento de consulta, y solo se admitia 1");
          if (consultarAnterior)
          {
            return null;
          }
          else
            throw e;
        }
        else
        {
          /*
           * se solicita nueva conexion (de respaldo) para volver a intentar
           */
          requestRewards = nuevoIntentoConexion();
          if (requestRewards == null)
          {
            if (consultarAnterior)
            {
              return null;
            }
            else
              throw e;
          }
        }
      }
      catch (InvocationTargetException e)
      {
        errorLog.error(CLASSNAME + "Exception: " + e.getCause().getClass() + ":" + e.getMessage(), e);
        if (justOneTry)
        {
          log.warn(CLASSNAME + "Ha fallado el intento de consulta, y solo se admitia 1 intento");
          // Log.logWarning(CLASSNAME +
          // "Ha fallado el intento de consulta, y solo se admitia 1 intento");
          if (consultarAnterior)
          {
            return null;
          }
          else
            throw e;
        }
        else
        {
          /*
           * se solicita nueva conexion (de respaldo) para volver a intentar
           */
          // cursor++;
          requestRewards = nuevoIntentoConexion();
          if (requestRewards == null)
          {
            if (consultarAnterior)
            {
              return null;
            }
            else
              throw e;
          }
        }

      }
      catch (Exception e)
      {
        errorLog.error(CLASSNAME + "Error consultando al ws " + e.getClass() + ":" + e.getMessage(), e);
        // Log.logError(CLASSNAME + "Error consultando al ws " + e.getClass() +
        // ":" + e.getMessage());
        if (justOneTry)
        {
          log.warn(CLASSNAME + "Ha fallado el intento de consulta, y solo se admitia 1");
          // Log.logWarning(CLASSNAME +
          // "Ha fallado el intento de consulta, y solo se admitia 1");
          return null;
        }
        else
        {
          /*
           * se solicita nueva conexion (de respaldo) para volver a intentar
           */
          requestRewards = nuevoIntentoConexion();
          if (requestRewards == null)
          {
            return null;
          }
        }
      }
    }
    else
    {
      errorLog.error(CLASSNAME + "Fallaron todos los intentos de conexion");
      // Log.logError(CLASSNAME + "Fallaron todos los intentos de conexion");
      reiniciarConexion();
    }
    return requestRewards;
  }

  /*
   * Metodo que extrae los parametros de conexion del contenedor
   */
  private String getConexion()
  {
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + "Cusor igual a " + cursor);
    // Log.logDebug(CLASSNAME + "Cusor igual a " + cursor);
    String ipAct = "";
    String portAct = "";
    String pathAct = "";
    if (cursor == 0)
    {
      String ipSame = Core.getHost();
      String ipCentral = Core.getTomcatServer();
      /*
       * edgar.cuesta 16-08-2013 Si se trabaja desde terminal controladora, y
       * dicha terminal controladora es el que posee Loyalty, empleamos la
       * dirección de loopback (PE_PRIMARY en el archivo de hosts)
       */
      if (!(Core.isTerminal()) && (ipSame.equalsIgnoreCase(ipCentral)))
      {
        ipAct = Core.extraerPropiedad("1", ContenedorConexion.PE_PRIMARY);
      }
      else
      {
        ipAct = Core.getTomcatServer();
      }
      portAct = Core.extraerPropiedad("1", ContenedorConexion.PRIMARY_PORT);
      pathAct = Core.extraerPropiedad("1", ContenedorConexion.PRIMARY_PATH);
    }
    /*
     * El cursor me permite moverme entre los distintos servidores para que una
     * misma transaccion no deba intentiar mas de una vez si falla en la primera
     * el primer intento NOTA: Al parecer esto logica no ha podido funcionarme
     * todavia
     */
    else if (cursor == 1)
    {
      ipAct = Core.extraerPropiedad("1", ContenedorConexion.PE_SECONDARY);
      portAct = Core.extraerPropiedad("1", ContenedorConexion.SECONDARY_PORT);
      pathAct = Core.extraerPropiedad("1", ContenedorConexion.SECONDARY_PATH);
      ipAd++;
    }
    else
    {
      if (max > 0)
      {
        ipAct = Core.extraerPropiedad("1", "IP" + ipAd);
        portAct = Core.extraerPropiedad("1", "PORT" + ipAd);
        pathAct = Core.extraerPropiedad("1", "PATH" + ipAd);
        ipAd++;
      }
      else
      {
        return null;
      }
    }
    con = "http://" + ipAct + ":" + portAct + pathAct;
    return con;
  }

  private String getCentralCon()
  {
    String con = "";
    String ipCen = Core.extraerPropiedad("1", ContenedorConexion.IP_CENTRAL);
    String portCen = Core.extraerPropiedad("1", ContenedorConexion.CENTRAL_PORT);
    String pathCen = Core.extraerPropiedad("1", ContenedorConexion.CENTRAL_PATH);
    con = "http://" + ipCen + ":" + portCen + pathCen;
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Conexion central devuelta: " + con);
    // Log.logDebug(CLASSNAME + "Conexion central devuelta: " + con);
    return con;
  }

  /**
   * Para almacenar los descuentos posibles de bonos especiales OJO Solo
   * Supermaxi
   * 
   * @return Una trama de la forma TODO
   */
  public String getWeirdDiscount()
  {
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Consultando descuentos raros");
    //Se deja la respuesta,
    String response = "999|";
    //OJO Solo Supermaxi
    // Iterator rewards = wdm.getRewardsId();
    // while (rewards.hasNext())
    // {
    // String rewardId = (String) rewards.next();
    // if (log != null && log.isInfoEnabled())
    // log.info(CLASSNAME + "Sacando RewardID " + rewardId);
    // // Log.logInfo(CLASSNAME + "Sacando RewardID " + rewardId);
    // BigDecimal partialValue = wdm.getValue(rewardId);
    // if (log != null && log.isInfoEnabled())
    // log.info(CLASSNAME + "Extraido walor del map = " + partialValue);
    // // Log.logInfo(CLASSNAME + "Extraido walor del map = " + partialValue);
    // if (partialValue != null)
    // {
    // if (Core.tieneDecimales())
    // {
    // partialValue = partialValue.multiply(centCorrec);
    // partialValue = partialValue.setScale(2, BigDecimal.ROUND_HALF_UP);
    // if (log != null && log.isDebugEnabled())
    // log.debug(CLASSNAME + "Valor BigDecimal, luego de cambiar escala " +
    // partialValue);
    // // Log.logDebug(CLASSNAME +
    // // "Valor BigDecimal, luego de cambiar escala " +
    // // partialValue);
    // }
    // BigInteger aux = partialValue.toBigInteger();
    // if (log != null && log.isDebugEnabled())
    // log.debug(CLASSNAME + "Valor parcial " + aux);
    // // Log.logDebug(CLASSNAME + "Valor parcial " + aux);
    // String partialResponse = rewardId + "," + aux + ",";
    // response = response.concat(partialResponse);
    // }
    // }
    // response = response.substring(0, response.length() - 1);
    // if (log != null && log.isInfoEnabled())
    // log.info(CLASSNAME + "Respuesta: " + response);
    // // Log.logInfo(CLASSNAME + "Respuesta: " + response);
    //END Solo Supermaxi
    return response;
  }

  /**
   * Metodo encargado únicamente de modificar el basket para que la siguiente
   * consulta independiente de cual sea, tenga en cuenta los limitantes de los
   * descuentos que me atreví a llamar raros OJO solo para supermaxi
   * 
   * @param data
   *          Array que contiene en cada ubicación el par RewardID, valor1,
   *          valor2
   * @return Un 999 si la ejecución ha finalizado correctamente un 300|msg,
   *         donde el msg es un mensaje del tipo de error ocurrido en la
   *         ejecución, en caso de falla
   */
  public String setWeirdDiscount(String[] data)
  {
    if (log.isInfoEnabled())
      log.info(CLASSNAME + "Modificando los descuentos raros");
    //SOLO SUpermaxi
    // se reinician los descuentos especiales
    // wdm.limpiarDescuentosEspecialesUsados();
    //
    // if (data.length != 0)
    // {
    // for (int i = 0; i < data.length; i++)
    // {
    // StringTokenizer sepThatModify = new StringTokenizer(data[i], ",");
    // RewardLimitation[] rwlmt = new
    // RewardLimitation[sepThatModify.countTokens() / 2];
    // if (sepThatModify.countTokens() != 0)
    // {
    // int j = 0;
    // String id = "";
    // double value = 0;
    // while (sepThatModify.hasMoreElements())
    // {
    // if (j % 2 == 0)
    // {
    // id = sepThatModify.nextToken();
    // if (log != null && log.isInfoEnabled())
    // log.info(CLASSNAME + "Id descuento # " + j / 2 + " : " + id);
    // // Log.logInfo(CLASSNAME + "Id descuento # " + j / 2 + " : " +
    // // id);
    // }
    // else
    // {
    // RewardLimitation rwlmtAux = new RewardLimitation();
    // BigDecimal valor = new BigDecimal(sepThatModify.nextToken());
    // if (Core.tieneDecimales())
    // {
    // valor = valor.divide(ProcessRequest.centCorrec, 2,
    // BigDecimal.ROUND_HALF_UP);
    // value = valor.doubleValue();
    // }
    // if (log != null && log.isInfoEnabled())
    // log.info("[WDM]Id value # " + j / 2 + " : " + value);
    // // Log.logInfo("[WDM]Id value # " + j / 2 + " : " + value);
    // if (value == 0)
    // {
    // wdm.deleteFromUsed(id);
    // }
    // else
    // {
    // rwlmtAux.setLimit(value);
    // rwlmtAux.setRewardID(id);
    // rwlmt[j / 2] = rwlmtAux;
    // wdm.usedWeirdDiscount(id);
    // }
    // }
    // j++;
    // }
    // }
    // RewardLimitations rwlmts = new RewardLimitations();
    // rwlmts.setRewardLimitation(rwlmt);
    // Instancia.b.setRewardLimitations(rwlmts);
    // }
    // if (log != null && log.isInfoEnabled())
    // log.info(CLASSNAME + "El Administrador de BS " + wdm);
    // Log.logInfo(CLASSNAME + "El Administrador de BS " + wdm);
    //END SOLO Supermaxi, se deja la respuesta exitosa
    return "999";
    //OJO Solo SUPERMAXI
    // }
    // else
    // return "300|No llegaron datos a actualizar";
    //END SOLO SUPERMAXI
  }

  /**
   * Clase util que ha surgido de la paranoia de Sebastian sobre el mal
   * funcionamiento de split en la JVM desarrollada por ibm
   * 
   * @param msg
   *          mensaje a separar
   * @param separador
   *          String en base al cual separaremos msg
   * @return Array de strings, no se incluye el separador en ninguno de ellos
   */
  public static String[] sSplit(String msg, String separador)
  {
    char cmsg[] = msg.toCharArray();
    int cont = 0;
    for (int i = 0; i < cmsg.length; i++)
      if (separador.equals(cmsg[i] + ""))
        cont++;
    String split[] = new String[cont + 1];
    for (int i = 0; i < cont + 1; i++)
      split[i] = "";

    cont = 0;
    for (int i = 0; i < cmsg.length; i++)
      if (!separador.equals(cmsg[i] + ""))
        split[cont] += cmsg[i];
      else
        cont++;
    return split;
  }

  /**
   * Elimina un strig de otro
   * 
   * @param msg
   *          String sobre el que se va a procesar
   * @param quitar
   *          String que deseo eliminar de msg
   * @return String equivalente a eliminar todo quitar que se halle en msg
   * @author sebastian.castaneda
   */
  public static String sSTrim(String msg, String quitar)
  {
    char cmsg[] = msg.toCharArray();
    String trim = "";
    for (int i = 0; i < cmsg.length; i++)
      if (!quitar.equals(cmsg[i] + ""))
        trim += cmsg[i];
    return trim;
  }

  /**
   * Metodo util por si hay fallos en el procesamiento del EOT, cerrar el
   * archivo de voucher. Solo sirve para cerrar el archivo
   */
  public void cierreVoucher()
  {
    try
    {
      Voucher.closeFile();
    }
    catch (IOException e1)
    {
      errorLog.error(
        CLASSNAME + "Error Cerrando o Escribiendo el Voucher" + e1.getClass().getName() + ":" + e1.getMessage(), e1);

      // Log.logError(CLASSNAME + "Error Cerrando o Escribiendo el Voucher");
      // Log.logError(CLASSNAME + e1.getClass().getName() + ":" +
      // e1.getMessage());

    }
  }

  /*
   * Para ahorrar lineas de codigo, se llama cada que falla un intento de
   * conexion Al fallar todos, se devuelve un null, se escribe en log, y se
   * reinician las variables para cuando vuelva a ser llamado
   */
  private RewardsResponse nuevoIntentoConexion() throws Exception
  {
    String conOpt = Core.extraerPropiedad("1", ContenedorConexion.RETRASO_OPT);
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + "Retraso Adicional en hashMap ");
    // Log.logDebug(CLASSNAME + "Retraso Adicional en hashMap ");
    // Sólo se modifica si existe el timeOut Auxiliar
    if (conOpt != null && !conOpt.trim().equals(""))
    {
      timeOut = Integer.parseInt(conOpt);
    }
    if (log.isDebugEnabled())
      log.debug(CLASSNAME + "Nuevo Retraso" + timeOut);
    // Log.logDebug(CLASSNAME + "Nuevo Retraso" + timeOut);
    if (countIncidencias < max + 2)
    {
      if (log.isDebugEnabled())
      {
        log.debug(
          CLASSNAME + "Valor del cursor antes " + cursor + "\nIntentos de conexion realizados " + countIncidencias);
      }
      // Log.logDebug(CLASSNAME + "Valor del cursor antes " + cursor);
      // Log.logDebug(CLASSNAME + "Intentos de conexion realizados " +
      // countIncidencias);
      errorLog.error("no se ha podido establecer conexion con: " + con);

      // Log.logError("no se ha podido establecer conexion con: " + con);
      countIncidencias++;
      cursor++;
      con = getConexion();
      return callWS(false);
    }
    else
    {
      reiniciarConexion();
      return null;
    }

  }

  private void reiniciarConexion()
  {
    cursor = 0;
    ipAd = 0;
    countIncidencias = 0;
    if (!transaccionAnterior.equals(transaccionActual))
    {
      transaccionAnterior = transaccionActual;
    }
  }

  // Para probar
  public void setCon(String con)
  {
    this.con = con;
  }

  // solo para probar
  public void setTimeout(int tim)
  {
    this.timeOut = tim;
  }

  /*
   * Como va a ser llamado por varios métodos, esta información ha de separase
   * en un método aparte Además se crean unas variables de clase para almacenar
   * la respuesta de cliente
   */
  private String procesamientoClientes(RewardsResponse rewardRequest)
  {
    String response = "";
    CustomerDetails customerdetails = null;
    if (rewardRequest != null)
    {
      customerdetails = rewardRequest.getCustomerDetails();
      String nombre = "";
      String apellido = "";
      if (rewardRequest.getTrxErrors() != null)
      {
        log.warn(CLASSNAME + "Parece que hay errores");
        // Log.logWarning(CLASSNAME + "Parece que hay errores");
        TrxError[] trxErrors = rewardRequest.getTrxErrors().getTransactionError();
        if (trxErrors != null && trxErrors.length > 0)
        {
          for (int i = 0; i < trxErrors.length; i++)
          {
            errorLog.error(CLASSNAME + "Error en loyalty: " + trxErrors[i].getErrorCode() + "-"
              + trxErrors[i].getErrorDescription());
            // Log.logError(CLASSNAME + "Error en loyalty: " +
            // trxErrors[i].getErrorCode() + "-"
            // + trxErrors[i].getErrorDescription());
          }
        }
      }
      /*
       * edgar.cuesta A�adido para saltar un nullpointer exception, y en caso de
       * que no llegue en la petici�n un customerName, simplemente env�a a basic
       * una trama vac�a 04/09/2012
       */
      if (customerdetails != null)
      {
        if (customerdetails.getCustomerName() != null)
        {
          nombre = customerdetails.getCustomerName().getFirstName();
          apellido = customerdetails.getCustomerName().getLastName();
          if (nombre == null || nombre.equals(""))
          {
            nombre = " ";
          }
          if (apellido == null || apellido.equals(""))
          {
            apellido = " ";
          }
          String sexo = customerdetails.getCustomerName().getSex();
          if (sexo == null || sexo.equals(""))
          {
            sexo = " ";
          }
          String titulo = customerdetails.getCustomerName().getTitle();
          if (titulo == null || titulo.equals(""))
          {
            titulo = " ";
          }
          Calendar act = customerdetails.getCustomerName().getLastUpdated();
          String actualizacion = "Nunca";
          if (act != null)
          {
            actualizacion = "" + act;
          }
          response = "999|" + nombre + "|" + apellido + "|" + sexo + "|" + titulo + "|" + actualizacion;
          if (log.isInfoEnabled())
            log.info("Recibiendo respuesta del cliente esperado, con los sgtes datos: " + response);
          // Log.logInfo("Recibiendo respuesta del cliente esperado, con los
          // sgtes datos: "
          // + response);
        }
        else
        {
          log.warn(CLASSNAME + "Cliente no encontrado");
          // Log.logWarning(CLASSNAME + "Cliente no encontrado");
          // System.out.println(CLASSNAME + "Cliente no encontrado");
          response = "999| | | | |";
        }
      }
      else
      {
        log.warn(CLASSNAME + "Faltan los detalles del cliente");
        // Log.logWarning(CLASSNAME + "Faltan los detalles del cliente");
        // System.out.println(CLASSNAME + "Faltan los detalles del cliente");
        response = "999| | | | |";
      }
    }
    else
    {
      log.warn(CLASSNAME + "No hubo respuesta");
      // Log.logWarning(CLASSNAME + "No hubo respuesta");
      // System.out.println(CLASSNAME + "No hubo respuesta");
      response = "300|no hubo respuesta del ws";
    }
    return response;
  }

  private String extraerRespuestaItem(RewardsResponse response, double totalAmount)
  {
    String result = "";
    String ticketMessage = "";
    if (response != null)
    {
      Instancia.setUltimaRespuesta(response);
      message.setRwr(response);
      ticketMessage = message.getMessages();
      // ticketMessage = requestRewards.getTicketMessage();
      if (response.getTrxErrors() != null)
      {
        TrxError[] trxErrors = response.getTrxErrors().getTransactionError();
        if (trxErrors.length > 0)
        {
          for (int i = 0; i < trxErrors.length; i++)
          {
            errorLog.error(CLASSNAME + "Error en loyalty: " + trxErrors[i].getErrorCode() + "-"
              + trxErrors[i].getErrorDescription());
            // Log.logError(CLASSNAME + "Error en loyalty: " +
            // trxErrors[i].getErrorCode() + "-"
            // + trxErrors[i].getErrorDescription());
          }
          return "301|Codigo respuesta" + response.getResponseCode() + ", Revise Voucher";
        }
      }
      rspCliente = procesamientoClientes(response);
      int grantedcoupons = response.getRewardsGranted().getNumberGrantedCoupons();
      int points2coupons = response.getRewardsGranted().getNumberPointsConvertedIntoCoupons();
      int pointbalance = response.getRewardsGranted().getPointsBalance();
      int pointsearned = new Double(Math.round(response.getRewardsGranted().getPointsEarned())).intValue();
      int previouslyiussedcoup = response.getRewardsGranted().getPreviouslyIssuedCoupons();
      long totaldis = response.getRewardsGranted().getTotalDiscountAmount();
      if (log.isInfoEnabled())
        log.info(CLASSNAME + "Total descuento " + totaldis);
      // Log.logInfo(CLASSNAME + "Total descuento " + totaldis);
      String cashierMessage = response.getCashierMessage();
      String customerMessage = response.getCustomerMessage();
      if (response.getTrxErrors() != null)
      {
        TrxError trxErrs[] = response.getTrxErrors().getTransactionError();
        if (trxErrs.length > 0)
        {
          for (int countErr = 0; countErr < trxErrs.length; countErr++)
          {
            errorLog.error(CLASSNAME + "Error, con codigo: " + trxErrs[countErr].getErrorCode()
              + trxErrs[countErr].getErrorDescription() + " Asociado al producto: " + trxErrs[countErr].getItemCode());
            // Log.logWarning(CLASSNAME + "Error, con codigo: " +
            // trxErrs[countErr].getErrorCode()
            // + trxErrs[countErr].getErrorDescription() +
            // " Asociado al producto: " + trxErrs[countErr].getItemCode());
          }
        }
      }
      double totaldiscount = 0;
      RewardsField rw = response.getRewardsGranted();
      if (rw.getRewards() != null)
      {
        // OJO, solo supermaxi
        // messageBuilder.agregarDescuento(rw);
        //END SOLO SUPERMAXI
        Reward[] reward = rw.getRewards().getReward();
        UtilidadesDescuentos.setReward(reward);
        if (reward != null)
        {
          for (int i = 0; i < reward.length; i++)
          {
            /*
             * edgar.cuesta - 09-12-2013 Para que dejen de molestar por lo de
             * los logs, se crean logs en nivel info únicamente para producción
             */
            if (log.isInfoEnabled())
              log.info(CLASSNAME + "Descuento: " + reward[i].getRewardID() + "," + reward[i].getProductCode() + ","
                + reward[i].getRewardAmount() + "," + reward[i].getIndex());
            // OJO, sólo para supermaxi
            // if (wdm.isAWeirdDiscount(reward[i].getRewardID()))
            // {
            // if (log != null && log.isInfoEnabled())
            // log.info(CLASSNAME + "Reward de tipo de bono especial " +
            // reward[i].getRewardID());
            // // Log.logInfo(CLASSNAME + "Reward de tipo de bono especial " +
            // // reward[i].getRewardID());
            //
            // BigDecimal auxDec;
            // auxDec = new BigDecimal(reward[i].getRewardAmount());
            // wdm.modifyReward(reward[i].getRewardID(), auxDec);
            // if (wdm.isUsedWeirdDiscount(reward[i].getRewardID()))
            // {
            // totaldiscount += reward[i].getRewardAmount();
            // }
            // }
            // else
            // {
            // END COMENTARIOS SUPERMAXI
            if (reward[i].getCategory() == 2)
              totaldiscount += reward[i].getRewardAmount();
            if (log != null && log.isDebugEnabled())
              log.debug(CLASSNAME + "Descuento parcial " + totaldiscount);
            // OJO SUPERMAXI
            // Log.logDebug(CLASSNAME + "Descuento parcial " + totaldiscount);
            // }
            // END SUPERMAXI
          }
          Instancia.reStartVectorItem();
          Instancia.reStartVectorItem0();
          Instancia.reStartCuponItem();
          if (ticketMessage == null)
            ticketMessage = " ";
          if (cashierMessage == null)
            cashierMessage = " ";
          if (customerMessage == null)
            customerMessage = " ";
          if (Core.tieneDecimales())
            totaldis = new BigDecimal(totaldiscount).multiply(new BigDecimal(DECIMALES))
              .setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
          else
          {
            totaldis = new BigDecimal(totaldiscount).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
          }
          result = "999|" + new Double(totalAmount).longValue() + "|" + new Double(Math.round(totaldis)).longValue()
            + "|" + ticketMessage + "|" + cashierMessage + "|" + customerMessage + "|" + grantedcoupons + "|"
            + points2coupons + "|" + pointbalance + "|" + pointsearned + "|" + previouslyiussedcoup;
          // System.out.println(CLASSNAME + "Respuesta de item :" + response);
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "Respuesta de item :" + response);
          // Log.logInfo(CLASSNAME + "Respuesta de item :" + response);
        }
        else
        {
          log.warn(CLASSNAME + "No han llegado descuentos de parte de Loyalty");
          // Log.logWarning(CLASSNAME +
          // "No han llegado descuentos de parte de Loyalty");
          result = "999| | | | | | | | | | |";
        }
      }
      else
      {
        log.warn(CLASSNAME + "No han llegado descuentos de parte de Loyalty");
        // Log.logWarning(CLASSNAME +
        // "No han llegado descuentos de parte de Loyalty");
        result = "999| | | | | | | | | | |";
      }
    }
    else
    {
      log.warn(CLASSNAME + "No han llegado descuentos de parte de Loyalty");
      // Log.logWarning(CLASSNAME +
      // "No han llegado descuentos de parte de Loyalty");
      result = "999| | | | | | | | | | |";
    }
    return result;
  }

  private String getEOT(RewardsResponse r)
  {
    String response;
    if (r.getTrxErrors() != null)
    {
      if (r.getTrxErrors().getTransactionError().length > 0)
      {
        for (int k = 0; k < r.getTrxErrors().getTransactionError().length; k++)
        {
          TrxError err = r.getTrxErrors().getTransactionError(k);
          log.warn(
            CLASSNAME + "Error de Transaccion en Loyalty: " + err.getErrorCode() + ", " + err.getErrorDescription());
          // Log.logWarning(CLASSNAME + "Error de Transaccion en Loyalty: " +
          // err.getErrorCode() + ", "
          // + err.getErrorDescription());
        }
      }
    }
    Reward reward[] = r.getRewardsGranted().getRewards().getReward();
    Instancia.reStartVectorItem();
    Instancia.reStartVectorItem0();
    if (reward != null)
    {

      if (reward.length == 0)
      {

        log.warn(ProcessRequest.CLASSNAME + " No se han entregado descuentos por parte del WS, favor revisar...");

        // Log.logWarning(ProcessRequest.CLASSNAME +
        // " No se han entregado descuentos por parte del WS, favor
        // revisar...");
        if (Instancia.getUltimaRespuesta().getRewardsGranted().getTotalDiscountAmount() > 0)
        {
          errorLog.error(ProcessRequest.CLASSNAME + "Antes había un descuento de "
            + Instancia.getUltimaRespuesta().getRewardsGranted().getTotalDiscountAmount());
          // Log.logError(ProcessRequest.CLASSNAME +
          // "Antes había un descuento de "
          // +
          // Instancia.getUltimaRespuesta().getRewardsGranted().getTotalDiscountAmount());
        }
      }
      // Para asegurarme que esté vacío antes de procesar
      totalIndice0 = 0;
      for (int i = 0; i < reward.length; i++)
      {
        if (log.isInfoEnabled())
          log.info(CLASSNAME + "Descuento: " + reward[i].getRewardID() + "," + reward[i].getProductCode() + ","
            + reward[i].getRewardAmount() + "," + reward[i].getIndex());
        // Log.logInfo(CLASSNAME + "Descuento: " + reward[i].getRewardID() + ","
        // + reward[i].getProductCode() + ","
        // + reward[i].getRewardAmount() + "," + reward[i].getIndex());
        String mensage = reward[i].getRewardDescription().replace(',', '.');
        String rewardId = reward[i].getRewardID();
        double descontable;
        // Me verifica que el indice sea uno o mas
        // Con el fin de identificar un tipo de descuento
        // distintos para los
        // items con indice cero
        if (reward[i].getIndex() > 0)
        {
          int pCode = -1;
          for (int j = 0; j < Instancia.b.getTicket().getLineItems().getLineItem().length; j++)
          {
            if (Instancia.b.getTicket().getLineItems().getLineItem()[j].getProductCode()
              .equals(reward[i].getProductCode()))
            {
              pCode = j;
              break;
            }
            if (Instancia.b.getTicket().getVouchers() != null)
            {
              for (int k = 0; k < Instancia.b.getTicket().getVouchers().getVoucher().length; k++)
              {
                if (Instancia.b.getTicket().getVouchers().getVoucher()[k].getVoucherCode()
                  .equals(reward[i].getProductCode()))
                {
                  pCode = k;
                }
              }
            }
          }
          if (pCode == -1)
            descontable = 0;
          else
            descontable = Instancia.b.getTicket().getLineItems().getLineItem()[pCode].getProductPrice();
          double descuento = reward[i].getRewardAmount();
          String productcode = reward[i].getProductCode();
          String financinfRef = reward[i].getFinancingRef();
          InfoReward info = new InfoReward(mensage, rewardId, descontable, descuento, productcode,
            reward[i].getCategory());
          info.setFinancingRef(financinfRef);
          if (log.isDebugEnabled())
            log.debug(
              CLASSNAME + "InfoReward agregado a Item: " + info.getMensaje() + " con rewardID: " + info.getRewardId());
          // Log.logDebug(CLASSNAME + "InfoReward agregado a Item: " +
          // info.getMensaje() + " con rewardID: "
          // + info.getRewardId());
          Instancia.setElementOfVectorItem(info);
        }
        else
        {
          descontable = 0;// price[reward[i].getIndex()-1];
          double descuento = reward[i].getRewardAmount();
          if (reward[i].getCategory() == 2)
            totalIndice0 += descuento;
          String productcode = reward[i].getProductCode();
          InfoReward info = new InfoReward(mensage, rewardId, descontable, descuento, productcode,
            reward[i].getCategory());
          if (log.isDebugEnabled())
            log.debug(
              CLASSNAME + "InfoReward agregado a Item0: " + info.getMensaje() + " con rewardID: " + info.getRewardId());
          // Log.logDebug(CLASSNAME + "InfoReward agregado a Item0: " +
          // info.getMensaje() + " con rewardID: "
          // + info.getRewardId());
          Instancia.setElementOfVectorItem0(info);
        }
      }
    }
    else
    {
      log.warn(ProcessRequest.CLASSNAME + " No se han entregado rewards de parte del WS, favor revisar...");
      // Log.logWarning(ProcessRequest.CLASSNAME +
      // " No se han entregado rewards de parte del WS, favor revisar...");
    }
    int existeCupon = 0;
    // Instancia.reStartCuponPay();

    /*
     * 10-04-2013 edgar.cuesta Se añade para extraer la información de vouchers
     * sin serializar Que deben venir en el mensaje obcional al ticket
     */
    String msgTicket2 = r.getOptionalTicketMessage();
    if (msgTicket2 != null && msgTicket2.indexOf("<VouInf>") != -1)
    {
      if (log.isDebugEnabled())
        log.debug(CLASSNAME + "Encontrado tag de apertura para vouchers ns");
      // Log.logDebug(CLASSNAME +
      // "Encontrado tag de apertura para vouchers ns");
      if (msgTicket2.indexOf("</VouInf>") != -1)
      {
        if (log.isDebugEnabled())
          log.debug(CLASSNAME + "Encontrado tag de cierre para vouchers ns");
        // Log.logDebug(CLASSNAME +
        // "Encontrado tag de cierre para vouchers ns");
        String couponNS = msgTicket2.substring(msgTicket2.indexOf("<VouInf>") + 8, msgTicket2.indexOf("</VouInf>"));
        if (log.isDebugEnabled())
          log.debug(CLASSNAME + "Mensaje al log" + couponNS);
        // Log.logDebug(CLASSNAME + "Mensaje al log" + couponNS);
        TipoVoucher tip = new TipoVoucher();
        tip.setMsgCoupon("couponNS");
        tiposCupones.add(tip);
        if (existeCupon == 0)
        {
          existeCupon = 1;
        }
      }
    }
    String resultado = Instancia.consolidado();
    response = "999|" + resultado;
    // int couldWrite = writeString(response);
    // if (couldWrite != 0)
    // Log.logWarning(CLASSNAME + "No escribio trama larga a archivo");

    return response;

  }

  private int escribirVoucher(RewardsResponse r)
  {
    int existeCupon = 0;
    Coupons coups = r.getCoupons();
    if (coups != null)
    {
      if (log.isInfoEnabled())
        log.info(CLASSNAME + "Inicia procesamiento de Vouchers");
      // Log.logInfo(CLASSNAME + "Inicia procesamiento de Vouchers");
      existeCupon = 1;
      Coupon cupon[] = coups.getCoupon();
      tiposCupones = new ArrayList();
      String mensage[];
      if (cupon != null)
      {
        if (log.isDebugEnabled())
          log.debug("Tamanno cupones " + cupon.length);
        // Log.logDebug("Tamanno cupones " + cupon.length);
        for (int i = 0; i < cupon.length; i++)
        {
          /*
           * edgar.cuesta 20/12/2012 Se permiten vouchers sin mensajes *
           */
          TipoVoucher typV = new TipoVoucher();
          String idCupon = cupon[i].getId();
          if (log.isInfoEnabled())
            log.info(CLASSNAME + "ID Voucher" + idCupon);
          // Log.logInfo(CLASSNAME + "ID Voucher" + idCupon);
          typV.setIdcoupon(idCupon);
          java.util.Date startDate = cupon[i].getStartDate().getTime();
          typV.setStartDate(startDate.toString());
          java.util.Date endDate = cupon[i].getEndDate().getTime();
          typV.setEndDate(endDate.toString());
          String mens_cupon = "";
          /*
           * edgar.cuesta 11/12/2012 Probando una mejora del voucher, eliminado
           * la separación de campos del lado de la clase voucher
           */
          if (cupon[i].getMessages() != null)
          {

            mensage = cupon[i].getMessages().getMessage();
            for (int j = 0; j < mensage.length; j++)
            {
              if (j == 0)
                mens_cupon = mens_cupon + mensage[j];
              else
                mens_cupon = mens_cupon + "|" + mensage[j];
            }
          }
          typV.setMsgCoupon(mens_cupon);
          if (i == cupon.length - 1)
            Instancia.setCuponPayFin(startDate.toString() + endDate.toString() + mens_cupon + idCupon);
          else
            Instancia.setCuponPay(startDate.toString() + endDate.toString() + mens_cupon + idCupon);
          tiposCupones.add(typV);
          if (log.isDebugEnabled())
            log.debug(CLASSNAME + "Voucher Ingresado " + i);
          // Log.logDebug(CLASSNAME + "Voucher Ingresado " + i);
        }
      }
    }
    else
      existeCupon = 0;
    if (existeCupon == 1)
    {
      VoucherFormatter vftt = new VoucherFormatter(tiposCupones);
      vftt.run();
      /*
       * edgar.cuesta Por si algun día revive el procesamiento de vouchers en un
       * hilo aparte
       */
      // Thread escribeVoucher = new Thread(vftt);
      // escribeVoucher.start();
    }
    return existeCupon;
  }
}