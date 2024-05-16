package com.linea.posappEnginePromotions.Voucher;

/**
 * Una representación de los Vouchers/Cupones (como se llamen)
 * @author edgar.cuesta
 * @version 1.0.0.0
 */
public class TipoVoucher
{
	private String endDate;
	private String msgCoupon;
	private String startDate;
	private String idcoupon;
	
	/**
	 * @return La fecha final, hasta donde es válido el Voucher
	 */
	public String getEndDate()
	{
		return endDate;
	}
	/**
	 * Se modifica la fecha fin
	 * @param endDate La fecha hasta donde es válido el Voucher
	 */
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	/**
	 * @return El mensaje del Voucher/Cupon, a imprimir 
	 */
	public String getMsgCoupon()
	{
		return msgCoupon;
	}
	/**
	 * Modifica el mensaje a imprimirse del Voucher
	 * @param msgCoupon Mensaje a imprimir del Cupon/Voucher
	 */
	public void setMsgCoupon(String msgCoupon)
	{
		this.msgCoupon = msgCoupon;
	}
	/**
	 * Se extrae la fecha de inicio
	 * @return La fecha, a partir de la cual es válido el Voucher
	 */
	public String getStartDate()
	{
		return startDate;
	}
	/**
	 * Modifica la fecha de inicio
	 * @param startDate Fecha a partir de la cual se puede redimir el Voucher/Coupon
	 */
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	/** 
	 * Se extrae el Identificador
	 * @return Identificador del Cupon/Voucher
	 */
	public String getIdcoupon()
	{
		return idcoupon;
	}
	/**
	 * Se modifica el ID del Cupon/Voucher
	 * @param idcoupon El Id del cupon/voucher
	 */
	public void setIdcoupon(String idcoupon)
	{
		this.idcoupon = idcoupon;
	}

}
