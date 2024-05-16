package com.linea.test;


import com.lineai.posappframework.PEF.userdefined.WS_FALSolutions.ProcessRequest;

public class TestLoyalty
{
  public static void main(String args[])
  {

    ProcessRequest pr =  new ProcessRequest();
    pr.setCon("http://192.168.147.139:9090/falws/falws");
    pr.setTimeout(5);
    String consulta = "4|9999999999999999999|1025|20131219|102500|00201|1|333333333333,1|";
    String [] cons = consulta.split("\\|");
    System.out.println("Inicia consulta");
    for(int j = 0; j < cons.length; j++)
    {
      System.out.println(cons[j]);
    }
    String rta = pr.getResponse(cons);
    System.out.println(rta);
//    consulta = "0|0000000123|1,409,770285910300,76900,0|2147483647";
//    cons = consulta.split("\\|");
//    System.out.println("Inicia consulta");
//    for(int j = 0; j < cons.length; j++)
//    {
//      System.out.println(cons[j]);
//    }
//    rta = pr.getResponse(cons);
//    System.out.println(rta);
//    consulta = "2|61,50000|2147483647";
//    cons = consulta.split("\\|");
//    System.out.println("Inicia consulta");
//    for(int j = 0; j < cons.length; j++)
//    {
//      System.out.println(cons[j]);
//    }
//    rta = pr.getResponse(cons);
//    System.out.println(rta);
//    consulta = "3|61,50000|2147483647";
//    cons = consulta.split("\\|");
//    System.out.println("Inicia consulta");
//    for(int j = 0; j < cons.length; j++)
//    {
//      System.out.println(cons[j]);
//    }
//    rta = pr.getResponse(cons);
//    System.out.println(rta);
  }
}
