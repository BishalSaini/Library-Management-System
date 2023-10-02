package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Book;
import com.jsp.dto.Librarian;
import com.jsp.dto.Student;

public class BookDaao { 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To save Details
		public Book saveBook(Book book) {
			entityTransaction.begin(); 
            entityManager.persist(book);
			entityTransaction.commit();
			
			return book;
		} 
		
		//To Delete The Details
		public Book removeBook(int id) {
			Book book= entityManager.find(Book.class, id);
			
			if(book!= null) {
				entityTransaction.begin();
				entityManager.remove(book);
				entityTransaction.commit();
			}
			else {
				System.out.println("Not deleted");
			}
			return book;
		}  
		
		//To Update The Details
		public Book updateBookById(int id,String book_name,String author_name) {   
			Book book = entityManager.find(Book.class, id); 
			book.setBook_name(book_name); 
			book.setAuthor_name(author_name); 
	
				entityTransaction.begin();
				entityManager.merge(book);
				entityTransaction.commit();
			return book;
		}
		
		//To View The Specific Detail
		public Book getBookById(int id) {
			Book book = entityManager.find(Book.class, id);						
			return book;
		}
		
		//To View The All Detail 
		public List<Book> getAllBooks() {
			String sql = "SELECT b FROM Book b"	;
			Query query = entityManager.createQuery(sql);		
			List<Book> books = query.getResultList();
			
			return books;		
			
		}
		
		
		public Librarian addBook(Librarian librarian) {
			entityTransaction.begin(); 
            entityManager.persist(librarian);
			entityTransaction.commit();
			
			return librarian;
		}  
		
		public Book issue(Book book) {
			entityTransaction.begin();
			entityManager.merge(book);
			entityTransaction.commit();
			return book;

		} 
		
		public boolean returnBook(Book book) {
			entityTransaction.begin();
			entityManager.merge(book);
			entityTransaction.commit();
			return true;
		} 
		
		public boolean requestBook(Book book) {  
			entityTransaction.begin();
			entityManager.merge(book);
			entityTransaction.commit();
			return true;
			
		}
		
		}  







