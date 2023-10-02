package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;
import com.jsp.dto.Librarian;

public class AdminDao { 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To save Details
		public Admin saveAdminDetails(Admin admin) {
			entityTransaction.begin(); 
                entityManager.persist(admin);
			entityTransaction.commit();
			
			return admin;
		} 
		
		//To Delete The Details
		public Admin deleteAdminById(int id) {

			Admin admin = entityManager.find(Admin.class, id);

			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			
			return admin;

		}

		public Admin updateAdminEmailById(int id, String username,String password) {

			Admin admin = entityManager.find(Admin.class, id);

			admin.setUsername(username); 
			admin.setPassword(password);

			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();
			
			return admin;

		}		
		//To View The Specific Detail
		public Admin getAdminDetailsById(int id) {
			Admin admin = entityManager.find(Admin.class, id);
			
			System.out.println(admin.getId());
			System.out.println(admin.getUsername()); 
			System.out.println(admin.getPassword());
						
			return admin;
		}
		
		//To View The All Detail 
		public List<Admin> getAllAdminDetails() {
			String sql = "SELECT a FROM Admin a";
			Query query = entityManager.createQuery(sql);
			List<Admin> admins = query.getResultList();
			return admins;
		}		 
		} 



		
			
			

