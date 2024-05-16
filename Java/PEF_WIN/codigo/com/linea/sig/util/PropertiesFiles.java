package com.linea.sig.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import org.apache.log4j.Logger;

public class PropertiesFiles
{

  private static Logger log = Logger.getLogger(PropertiesFiles.class);
  public PropertiesFiles()
  {
    bufferedReader = null;
    fileReader = null;
    file = null;
  }

  public PropertiesFiles(File file)
  {
    bufferedReader = null;
    fileReader = null;
    this.file = null;
    this.file = file;
  }

  public String getKeyFile(String key, String modulo) throws Exception
  {
    if(log.isInfoEnabled())
      log.info("[PropertiesFile]Se Procede a abrir el archivo" + file.getAbsolutePath());
//    Log.logDebug("[PropertiesFile]Se Procede a abrir el archivo" + file.getAbsolutePath());
    fileReader = new FileReader(file);
    bufferedReader = new BufferedReader(fileReader);
    if(log.isDebugEnabled())
      log.debug("[PropertiesFile]Archivo abierto para lectura" + file.getAbsolutePath());
//    Log.logDebug("[PropertiesFile]Archivo abierto para lectura" + file.getAbsolutePath());
    String line = "";
    String valueReturn = "";
    String value = "";
    String keyline = "";
    int numkey = 0;
    boolean sw = false;
    while ((line = bufferedReader.readLine()) != null)
    {
      if (line.equalsIgnoreCase(modulo))
        sw = true;
      if (sw && !line.equals(""))
      {
        numkey = line.indexOf('=');
        if (numkey > 0)
        {
          keyline = line.substring(0, numkey).trim();
          if (keyline.equalsIgnoreCase(key))
          {
            value = line.substring(numkey + 1, line.length()).trim();
            sw = false;
            return value;
          }
        }
      }
    }
    return value;
  }

  public void close() throws Exception
  {
    if(log.isInfoEnabled())
      log.info("[PropertiesFile]Cerrando el archivo" + file.getAbsolutePath());
//    Log.logDebug("[PropertiesFile]Cerrando el archivo" + file.getAbsolutePath());
    if (fileReader != null)
      fileReader.close();
    if (bufferedReader != null)
      bufferedReader.close();
  }

  public static void main(String arg[])
  {
    try
    {
      PropertiesFiles file = new PropertiesFiles(new File("C:/respaldo/UFPAR001"));
      System.out.println(file.getKeyFile("Initial_url", "[VENTA_CRUZADA]"));
      Vector vec = Tokens.createTokens(file.getKeyFile("Initial_url", "[VENTA_CRUZADA]"), ",", false);
      System.out.println(vec.get(1));
      file.close();
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e.toString());
    }
  }

  private BufferedReader bufferedReader;

  private FileReader fileReader;

  private File file;
}