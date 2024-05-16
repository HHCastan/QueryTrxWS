package com.linea.posappEnginePromotions.Voucher;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class VoucherFormatter //implements Runnable
{
    public final static String CLASSNAME = "[VoucherWriter]";
    private static Logger log = Logger.getLogger(VoucherFormatter.class);
    private static Logger errorLog = Logger.getLogger("error." + VoucherFormatter.class.getName());
    private int indVoucher = 0;
    private String toWrite = "";
    private ArrayList tiposCupones;
    private final static String LINE_FEED = "\r\n";

    public VoucherFormatter(ArrayList tiposCupones)
    {
      this.tiposCupones = tiposCupones;
    }
  public void run()
  {
    try
    {
      Voucher.openFile();
      if(log.isDebugEnabled())
        log.debug(CLASSNAME + "Tamanno Cupones " + tiposCupones.size());
//      Log.logDebug(CLASSNAME + "Tamanno Cupones " + tiposCupones.size());
      for (int i = 0; i < tiposCupones.size(); i++)
      {
        TipoVoucher vouc = (TipoVoucher) tiposCupones.get(i);
        String idCoup = vouc.getIdcoupon();
        String endDate = vouc.getEndDate();
        String startDate = vouc.getStartDate();
        String msg = vouc.getMsgCoupon();
        if(log.isDebugEnabled())
          log.debug(CLASSNAME + "VoucherID: " + idCoup);
//        Log.logDebug(CLASSNAME + "VoucherID: " + idCoup);
        setVoucher(startDate.trim());
        setVoucher(endDate.trim());
        setVoucher(msg.trim());
        setVoucher(Voucher.getBarCode() + idCoup);
        if (!(i == tiposCupones.size() - 1))
        {
          setVoucher(Voucher.getCutPaper());
          setVoucher(LINE_FEED);
        }
      }
      setVoucher(LINE_FEED);
      Voucher.flush(toWrite);
      cierreVoucher();
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
      cierreVoucher();
    }
  }
    
  public void cierreVoucher()
  {
    try
    {
      Voucher.closeFile();
    }
    catch (IOException e1)
    {
      errorLog.error(CLASSNAME + "Error Cerrando o Escribiendo el Voucher: " + e1.getClass().getName() + ":" + e1.getMessage() , e1);
//      Log.logError(CLASSNAME + "Error Cerrando o Escribiendo el Voucher");
//      Log.logError(CLASSNAME + e1.getClass().getName() + ":" + e1.getMessage());
      
    }
  }
  public void setVoucher(String voucher)
  {
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "Se va a añadir " + voucher);
//    Log.logDebug(CLASSNAME + "Se va a añadir " + voucher);
    if (voucher.toLowerCase().equals("null"))
    {
      voucher = "";
    }
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "Se adiciona " + voucher);
//    Log.logDebug(CLASSNAME + "Se adiciona " + voucher);
    toWrite = toWrite.concat( "|" + voucher);
    if(log.isDebugEnabled())
      log.debug(CLASSNAME + "Resultado parcial " + toWrite);
//    Log.logDebug(CLASSNAME + "Resultado parcial " + toWrite);
  }
}
