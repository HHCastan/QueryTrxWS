package com.fla.devoluciones.model;

public class Cliente {
	private String PAN;
	private String optionalTicketMessage;
	private String firstName;
	private String lastName;
	private String sex;

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pan) {
		PAN = pan;
	}

	public String getOptionalTicketMessage() {
		return optionalTicketMessage;
	}

	public void setOptionalTicketMessage(String optionalTicketMessage) {
		this.optionalTicketMessage = optionalTicketMessage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
