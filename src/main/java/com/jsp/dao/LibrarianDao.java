package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Librarian;

public class LibrarianDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To save Details
		public Librarian saveLibrarianDetails(Librarian librarians) {
			entityTransaction.begin();
				  entityManager.persist(librarians);
			entityTransaction.commit();
			return librarians;
		} 
		
		public Librarian deleteLibrarinDetailsById(int id) {
			Librarian librarian = entityManager.find(Librarian.class, id);

			entityTransaction.begin();
			entityManager.remove(librarian);
			entityTransaction.commit();
			
			return librarian;

		}

		public Librarian updateLibrarianDetailsById(int id,String name, String email) {
			Librarian librarian = entityManager.find(Librarian.class, id);
            librarian.setName(name);
			librarian.setEmail(email);

			entityTransaction.begin();
			entityManager.merge(librarian);
			entityTransaction.commit();

			return librarian;

		}
		
		//To View The Specific Detail
		public Librarian getLibrarianDetailsById(int id) {
			Librarian librarian = entityManager.find(Librarian.class, id);
			return librarian;
		}
		
		//To View The All Detail 
		public List<Librarian> getAllLibrarianDetails() {
			String sql = "SELECT l FROM Librarian l";  		
			Query query = entityManager.createQuery(sql); 		
			List<Librarian> librarian = query.getResultList();
			
			return librarian;
		}   
		
		//To Approve Librarian
		public boolean approveLibrarian(Librarian librarian) {
			entityTransaction.begin();
			entityManager.merge(librarian);
			entityTransaction.commit();
			return true;
		} 
}
