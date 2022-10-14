package valtechspring.orm;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity

@DiscriminatorValue("hdb")
public class HandBook extends Book {
	
	private String isbn;
	private float price;
	private int editioning;
	private Date published_year;
	public HandBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HandBook(String isbn, float price, int editioning, Date published_year) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.editioning = editioning;
		this.published_year = published_year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getEditioning() {
		return editioning;
	}
	public void setEditioning(int editioning) {
		this.editioning = editioning;
	}
	public Date getPublished_year() {
		return published_year;
	}
	public void setPublished_year(Date published_year) {
		this.published_year = published_year;
	}
	

}
