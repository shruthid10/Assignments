package com.valtech.tx.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class TransferTx extends Tx {
	private long id;
	private String teller;
	private String branch;
	public TransferTx() {
		super();
		
	}
	
	
	public TransferTx(float amount, boolean debit, LocalDateTime txTime, long accountId) {
		super(amount, debit, txTime, accountId);
		// TODO Auto-generated constructor stub
	}

	public TransferTx(String teller, String branch) {
		super();
		this.teller = teller;
		this.branch = branch;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTeller() {
		return teller;
	}


	public void setTeller(String teller) {
		this.teller = teller;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	

}
