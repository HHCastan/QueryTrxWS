package com.fla.consultaSaldos.modelo;

public class Saldo
{
  private String ndoc;
  private String fechael;
  private String fechare;
  private String valordoc;
  private String docid;
  private String nombre;
  private String apellido;
  private String tipo;
  private String almcob;
  private String docorigen;
  private String almorigen;
  private String aux;
  private String tienda;
  
  public String getTienda()
  {
    return this.tienda;
  }
  
  public void setTienda(String tienda)
  {
    this.tienda = tienda;
  }
  
  public String getNdoc()
  {
    return this.ndoc;
  }
  
  public void setNdoc(String ndoc)
  {
    this.ndoc = ndoc;
  }
  
  public String getFechael()
  {
    return this.fechael;
  }
  
  public void setFechael(String fechael)
  {
    this.fechael = fechael;
  }
  
  public String getFechare()
  {
    return this.fechare;
  }
  
  public void setFechare(String fechare)
  {
    this.fechare = fechare;
  }
  
  public String getValordoc()
  {
    return this.valordoc;
  }
  
  public void setValordoc(String valordoc)
  {
    this.valordoc = valordoc;
  }
  
  public String getDocid()
  {
    return this.docid;
  }
  
  public void setDocid(String docid)
  {
    this.docid = docid;
  }
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public String getApellido()
  {
    return this.apellido;
  }
  
  public void setApellido(String apellido)
  {
    this.apellido = apellido;
  }
  
  public String getTipo()
  {
    return this.tipo;
  }
  
  public String getTipoDescription()
  {
    if (this.tipo.startsWith("4")) {
      return "Devolución";
    }
    if (this.tipo.startsWith("1")) {
      return "OR. Cta. Cte.";
    }
    if (this.tipo.startsWith("2")) {
      return "OR. Club";
    }
    return this.tipo;
  }
  
  public String getEstadoDescription()
  {
    if (this.tipo.endsWith("1")) {
      return "Abierto";
    }
    if (this.tipo.endsWith("2")) {
      return "Anulado el negocio";
    }
    if (this.tipo.endsWith("3")) {
      return "Cobrado en otro almacén";
    }
    if (this.tipo.endsWith("4")) {
      return "Anulado por pérdida";
    }
    if (this.tipo.endsWith("0")) {
      return "Cobrado";
    }
    return this.tipo;
  }
  
  public void setTipo(String tipo)
  {
    this.tipo = tipo;
  }
  
  public String getAlmcob()
  {
    return this.almcob;
  }
  
  public void setAlmcob(String almcob)
  {
    this.almcob = almcob;
  }
  
  public String getDocorigen()
  {
    return this.docorigen;
  }
  
  public void setDocorigen(String docorigen)
  {
    this.docorigen = docorigen;
  }
  
  public String getAux()
  {
    return this.aux;
  }
  
  public void setAux(String aux)
  {
    this.aux = aux;
  }
  
  public String getAlmorigen()
  {
    return this.almorigen;
  }
  
  public void setAlmorigen(String almorigen)
  {
    this.almorigen = almorigen;
  }
  
  public String toString()
  {
    String respuesta = "";
    respuesta = respuesta + "ndoc: " + this.ndoc + "; ";
    respuesta = respuesta + "fechael: " + this.fechael + "; ";
    respuesta = respuesta + "fechare: " + this.fechare + "; ";
    respuesta = respuesta + "valordoc: " + this.valordoc + "; ";
    respuesta = respuesta + "docid: " + this.docid + "; ";
    respuesta = respuesta + "nombre: " + this.nombre + "; ";
    respuesta = respuesta + "apellido: " + this.apellido + "; ";
    respuesta = respuesta + "tipo: " + this.tipo + "; ";
    respuesta = respuesta + "almcob: " + this.almcob + "; ";
    respuesta = respuesta + "docorigen: " + this.docorigen + "; ";
    respuesta = respuesta + "almorigen: " + this.almorigen + "; ";
    respuesta = respuesta + "aux: " + this.aux + "; ";
    
    return respuesta;
  }
}