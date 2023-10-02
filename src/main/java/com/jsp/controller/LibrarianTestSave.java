package com.jsp.controller;


import com.jsp.dto.Librarian;
import com.jsp.service.LibrarianService;


public class LibrarianTestSave { 
	public static void main(String[] args) { 
		Librarian librarian=new Librarian(); 
		librarian.setName("sabaat"); 
		librarian.setEmail("sabaat25@mail.com"); 
		librarian.setStatus("authorised"); 
		
		LibrarianService librarianService=new LibrarianService(); 
		librarianService.saveLibrarianDetails(librarian);
	}
}
