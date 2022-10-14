package valtechspring.client;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import valtechspring.orm.Address1;
import valtechspring.orm.Article;
import valtechspring.orm.Author;
import valtechspring.orm.Blog;
import valtechspring.orm.Book;
import valtechspring.orm.HandBook;
import valtechspring.orm.Publisher;


public class HibernateBook {

	public static void main(String[] args) {
		//SessionFactory sf= new Configuration()
		SessionFactory sf = new AnnotationConfiguration()
				.configure()
				.addAnnotatedClass(Address1.class)
				.addAnnotatedClass(Article.class)
				.addAnnotatedClass(Author.class)
				.addAnnotatedClass(Blog.class)
				.addAnnotatedClass(Book.class)
				.addAnnotatedClass(HandBook.class)
				.addAnnotatedClass(Publisher.class).buildSessionFactory();
				
		
		Session ses =sf.openSession();
		Transaction tx= ses.beginTransaction();
		
		
		
Publisher p=new Publisher("Mangalore","Pqr",78905643);
	ses.save(p);
	
Publisher p1=new Publisher("Hubli","Xyz",90245367);
    ses.save(p1);
    
Publisher p2=new Publisher("Mysore","Sss",980765489);
    ses.save(p2);
    
    Book b=new Book("Fear Not:Be Strong", new Date(91,8,25));
	ses.save(b);
	
	Book b1=new Book("The Mind and Its Control", new Date(92,8,24));
	ses.save(b1);
	
	Book b3=new Book("The Very Hungry Caterpillar", new Date(94,7,28));
	ses.save(b3);
	
	Blog bl=new Blog("www.blog",5);
	ses.save(bl);
	    
 

////		

	//	Book b=new Book("The Alchemist", new Date(90,10,25));
		//ses.save(b);
		
		
//		 Address1 ad=new Address1("3rd","Bengaluru","Karnataka",560003);
//         ses.save(ad);
//         
//         Author a=new Author("Abc",881245667);
//         ses.save(a);
		
         Article al=new Article("www.google");
         ses.save(al);
		
		
		tx.commit();
		ses.close();
		sf.close();

	}

}
