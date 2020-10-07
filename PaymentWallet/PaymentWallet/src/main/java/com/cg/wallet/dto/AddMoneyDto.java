package com.cg.wallet.dto;

public class AddMoneyDto {
	
	
	private String  phoneNo;
	private double amount;
	@Override
	public String toString() {
		return "AddMoneyDto [phoneNo=" + phoneNo + ", amount=" + amount + "]";
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPhoneNo() {
		
		return phoneNo;
	}
	
}
