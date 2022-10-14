package valtechspring.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
     
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	  private int id;
	  private String name;
	  private String address;
	  private int phone;
	  
	  @OneToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="publisher")
		private Set<Book> Book;
	  
	  
	  public void setBook(Set<Book> book) {
		Book = book;
	}
	  
	  public Set<Book> getBook() {
		return Book;
	}
	public Publisher() {
		super();
		
	}
	public Publisher( String name, String address, int phone) {
		super();
		
		this.name = name;
		this.address = address;
		this.phone = phone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	  
	  
}
