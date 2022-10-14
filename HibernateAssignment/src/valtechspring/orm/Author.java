package valtechspring.orm;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Author {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private int phone;
	
	
	
	@OneToOne(targetEntity=Address1.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,    mappedBy="author")
	private Address1 address1;
	
	@ManyToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="author")
	private Set<Book> books;
	
	
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(String name, int phone) {
		super();
		this.id = id;
		this.name = name;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	

}
