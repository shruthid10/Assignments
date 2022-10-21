package com.valtech.account.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
  
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String mobile;
	private LocalDate birthDate;
	private String address;
	private String customerType;
	private String pincode;
	
	@ManyToMany(targetEntity = Account.class,cascade={CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="customers")
	private Set<Account> accounts;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int id, String name, String email, String mobile, LocalDate birthDate, String address,
			String customerType, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}
	
	
	
	public Customer(String name, String email, String mobile, LocalDate birthDate, String address, String customerType,
			String pincode) {
		
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
