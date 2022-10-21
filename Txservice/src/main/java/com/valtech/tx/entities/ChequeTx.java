package com.valtech.tx.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class ChequeTx extends Tx {
	 private int chequeNo;
	 private boolean outstaion;
	 private float collectionCharges;
	 
	 
	public ChequeTx() {
		super();
	
	}
	
	public ChequeTx(float amount, boolean debit, LocalDateTime txTime, long accountId) {
		super(amount, debit, txTime, accountId);
		
	}



	public ChequeTx(int chequeNo, boolean outstaion, float collectionCharges) {
		super();
		this.chequeNo = chequeNo;
		this.outstaion = outstaion;
		this.collectionCharges = collectionCharges;
	}


	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public boolean isOutstaion() {
		return outstaion;
	}
	public void setOutstaion(boolean outstaion) {
		this.outstaion = outstaion;
	}
	public float getCollectionCharges() {
		return collectionCharges;
	}
	public void setCollectionCharges(float collectionCharges) {
		this.collectionCharges = collectionCharges;
	}
	@Override
	public String toString() {
		return "ChequeTx [chequeNo=" + chequeNo + ", outstaion=" + outstaion + ", collectionCharges="
				+ collectionCharges + "]";
	}
	 
	 

}
