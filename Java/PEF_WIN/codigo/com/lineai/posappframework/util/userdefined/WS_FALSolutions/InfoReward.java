package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

public class InfoReward {

	private String mensaje;
	private String rewardId;
	private double descontable;
	private double descuento;
	private String productcode;
	private int category;
	private String financingRef;

	public InfoReward(String mensaje, String rewardId, double descontable, double descuento, String productcode) {
		this.mensaje = mensaje;
		this.rewardId = rewardId;
		this.descontable = descontable;
		this.descuento = descuento;
		this.productcode = productcode;
		this.setCategory(2);
		setFinancingRef("0");

	}
	public InfoReward(String mensaje, String rewardId, double descontable, double descuento, String productcode, int category) {
		this.mensaje = mensaje;
		this.rewardId = rewardId;
		this.descontable = descontable;
		this.descuento = descuento;
		this.productcode = productcode;
		this.setCategory(category);
		setFinancingRef("0");
	}
	public String getInfo() {
		return mensaje + "," + rewardId + "," + productcode + "," + descontable + "," + descuento;
	}

	public String getRewardId() {
		return rewardId;
	}

	public double getDescuento() {
		return this.descuento;
	}
	
	public void setDescuento(double descuento)
	{
	  this.descuento = descuento;
	}

	public String getMensaje() {
		return this.mensaje;
	}
	public void setMensaje(String msg) {
      this.mensaje = msg;
  }

	public String getProductCode() {
		return this.productcode;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
  public String getFinancingRef()
  {
    return financingRef;
  }
  public void setFinancingRef(String financingRef)
  {
    this.financingRef = financingRef;
  }
}
