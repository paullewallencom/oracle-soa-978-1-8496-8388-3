package com.rubiconred.ckbk.creditcardsvc.pojo;

public class DebitCreditCard {

	private Double trnAmount;
	private String trnDesc;
	private CreditCard creditCard;
	
	public Double getTrnAmount() {
		return trnAmount;
	}
	public void setTrnAmount(Double trnAmount) {
		this.trnAmount = trnAmount;
	}
	public String getTrnDesc() {
		return trnDesc;
	}
	public void setTrnDesc(String trnDesc) {
		this.trnDesc = trnDesc;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
