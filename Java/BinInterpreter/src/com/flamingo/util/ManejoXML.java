package com.flamingo.util;


import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ManejoXML
{
  Document doc = null;
  
  public ManejoXML(String xmlPath)
  {
    SAXBuilder builder = new SAXBuilder();
    try
    {
      this.doc = builder.build(new File(xmlPath));
    }
    catch (JDOMException e)
    {
      e.printStackTrace();
    }
  }
  
  public ManejoXML(InputStream xmlSource)
  {
    SAXBuilder builder = new SAXBuilder();
    try
    {
      this.doc = builder.build(xmlSource);
    }
    catch (JDOMException e)
    {
      System.out.println("Error en building" );
//      e.printStackTrace();
    }
  }
  
  public String validateMessage(String message)
  {
    if (this.doc == null) {
      iniciarDoc();
    }
    String response = "";
    response = comprobarPatrones(message);
    if (response.equals(""))
    {
      response = comprobarValores(message);
      if (response.equals("")) {
        response = returnDefault();
      }
    }
    return response;
  }
  
  private void iniciarDoc()
  {
    SAXBuilder builder = new SAXBuilder();
    try
    {
      this.doc = builder.build(getClass().getResourceAsStream("/xmlInterpreter/confMensajes.xml"));
    }
    catch (JDOMException e)
    {
      e.printStackTrace();
    }
  }
  
  private String comprobarValores(String message)
  {
    Element root = this.doc.getRootElement();
    List elementos = root.getChildren("mensaje");
    if ((elementos == null) || (elementos.isEmpty())) {
      return "";
    }
    Iterator it = elementos.iterator();
    while (it.hasNext())
    {
      Element mensaje = (Element)it.next();
      Element valores = mensaje.getChild("valores");
      if (valores != null)
      {
        List values = valores.getChildren();
        if ((values != null) && (!values.isEmpty()))
        {
          Iterator itValores = values.iterator();
          while (itValores.hasNext())
          {
            String toCompare = ((Element)itValores.next()).getText();
            if (toCompare.equalsIgnoreCase(message)) {
              return mensaje.getAttributeValue("value");
            }
          }
        }
      }
    }
    return "";
  }
  
  private String returnDefault()
  {
    Element root = this.doc.getRootElement();
    Element porDefecto = root.getChild("defecto");
    return porDefecto.getAttributeValue("value");
  }
  
  private String comprobarPatrones(String message)
  {
    Element root = this.doc.getRootElement();
    List elementos = root.getChildren("mensaje");
    if ((elementos == null) || (elementos.isEmpty())) {
      return "";
    }
    Iterator it = elementos.iterator();
    while (it.hasNext())
    {
      Element mensaje = (Element)it.next();
      Element patrones = mensaje.getChild("patrones");
      if (patrones != null)
      {
        List patterns = patrones.getChildren();
        if ((patterns != null) && (!patterns.isEmpty()))
        {
          Iterator itPatrones = patterns.iterator();
          while (itPatrones.hasNext())
          {
            Element patron = (Element)itPatrones.next();
            Pattern pattern = Pattern.compile(patron.getText());
            Matcher m = pattern.matcher(message);
            if (m.matches()) {
              return mensaje.getAttributeValue("value");
            }
          }
        }
      }
    }
    return "";
  }
}
