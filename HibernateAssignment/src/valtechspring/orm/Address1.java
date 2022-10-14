package valtechspring.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Address1 {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	 private String street;
	 private String city;
	 private String state;
	 private int zipCode;
	 
	 
	 @OneToOne(targetEntity=Author.class)
	 @JoinColumn(name="id",referencedColumnName="id") // name -fk of child and ref - pk of master
	 private Author author;
	 
	 public void setAuthor(Author author) {
		this.author = author;
	}
	 public Author getAuthor() {
		return author;
	}
	 
	public Address1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address1(String street, String city, String state, int zipCode) {
		super();
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	 
	 
}
