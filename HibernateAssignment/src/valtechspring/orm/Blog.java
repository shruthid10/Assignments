package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

@DiscriminatorValue("Blg")
public class Blog extends Book {
	
	private String url;
	private int visited_number;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(String url, int visited_number) {
		super();
		this.url = url;
		this.visited_number = visited_number;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getVisited_number() {
		return visited_number;
	}
	public void setVisited_number(int visited_number) {
		this.visited_number = visited_number;
	}
	
	

}
