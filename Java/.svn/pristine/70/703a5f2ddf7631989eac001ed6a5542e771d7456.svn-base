package com.lineai.posappframework.util.userdefined.WS_FALSolutions.validator;

import java.util.ArrayList;

/**
 * @author edgar.cuesta
 * Clase que simplemente me representa las variedades de descuentos con tratamientos
 * especiales que requiera el cliente, sólo es una manera de organizar datos
 * y mantener una "atomicidad"
 *
 */
public class WeirdDiscountProyection
{
  private String key;
  private ArrayList values;
  /**
   * Constructor por defecto, crea un array vacío, y como identificador un 
   * String vacío
   */
  public WeirdDiscountProyection()
  {
    setKey("");
    setValues(new ArrayList());
  }
  /**
   * @param key Identificador del descuento de tratamiento especial
   * @param values Valores, puede ser sólo uno o varios
   */
  public WeirdDiscountProyection(String key, ArrayList values)
  {
    this.setKey(key);
    this.setValues(values);
  }
  /**
   * @return El identificador del descuento especial
   */
  public String getKey()
  {
    return key;
  }
  /**
   * @param key Identificador de descuento especial
   */
  public void setKey(String key)
  {
    this.key = key;
  }
  /**
   * @return La lista con los valores a procesar
   */
  public ArrayList getValues()
  {
    return values;
  }
  /**
   * @param values Lista con los valores asociados al descuento especial
   */
  public void setValues(ArrayList values)
  {
    this.values = values;
  }
  

}
