package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;
import com.jsp.dto.Student;

public class StudentDao { 
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vishu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To save Details
		public Student saveStudentDetails(Student student) {
			entityTransaction.begin(); 
            entityManager.persist(student);
			entityTransaction.commit();
			
			return student;
		} 
		
		//To Delete The Details
		public Student deleteStudentById(int id) {
			
			Student student = entityManager.find(Student.class, id);
			
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			
			return student;		
			
		}
		
		//To Update The Details
		public Student updateStudentDetailsById(int id,String sname,String email, long ph_no) {   
			Student student = entityManager.find(Student.class, id);
			student.setSname(sname);
			student.setEmail(email); 
			student.setPhone_no(ph_no);
					
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
					
			return student;		
		}
		
		//To View The Specific Detail
		public Student getStudentDetailsById(int id) {
			Student student = entityManager.find(Student.class, id);
			return student;
		}
		
		//To View The All Detail 
		public List<Student> getAllStudentDetails() {
			String sql = "SELECT s FROM Student s";
			Query query = entityManager.createQuery(sql);
			List<Student> student = query.getResultList();
			return student;
		}		 
		}
