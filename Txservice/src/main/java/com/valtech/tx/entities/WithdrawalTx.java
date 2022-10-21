package com.valtech.tx.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class WithdrawalTx extends Tx {
	private int atmNo;
	private String loaction;
	public WithdrawalTx() {
		super();
		
	}
	
	public WithdrawalTx(float amount, boolean debit, LocalDateTime txTime, long accountId) {
		super(amount, debit, txTime, accountId);
		// TODO Auto-generated constructor stub
	}

	public WithdrawalTx(int atmNo, String loaction) {
		super();
		this.atmNo = atmNo;
		this.loaction = loaction;
	}
	public int getAtmNo() {
		return atmNo;
	}
	public void setAtmNo(int atmNo) {
		this.atmNo = atmNo;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	@Override
	public String toString() {
		return "WithdrawalTx [atmNo=" + atmNo + ", loaction=" + loaction + "]";
	}
	
}
