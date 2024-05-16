package com.flamingo.test;

import com.flamingo.util.ManejoXML;

public class Prueba
{
  public static void main(String[] args)
  {
    ManejoXML manager = new ManejoXML(Prueba.class.getResourceAsStream("/xml/confMensajes.xml"));
    System.out.println(manager.validateMessage("451307"));
    /*
     * 360324 Diners
     * 451308 Visa Bancolombia
     * 543421 Mastercard Citi
     * 400558 Pruebas Electron
     * 498858 Visa Citi
     * 498860 Visa Debit Citi
     * 498862 Visa Debit Citi
     * 530691 Mastercard Debito Bancolombia
     * 601660 Maestro Debito Bancolombia
     * 590701 Debito confiar Maestro
     * 528209 CRM Falabella Mastercard
     * 377816 Amex Bancolombia
     * 541203 Credenvisa
     * 870055 tarjeta bono codensa
     * 590712 tarjeta chip codensa
     * 529448 tarjeta franquiciada mastercard Codensa
     * 881006 trajeta somos
     * 527474 542060 543280 636853 899800 899801 Banco SerFinanza
     */
  }
}