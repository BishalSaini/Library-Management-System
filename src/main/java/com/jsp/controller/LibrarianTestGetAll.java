package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class LibrarianTestGetAll { 
	public static void main(String[] args) {
		LibrarianService librarianService=new LibrarianService(); 
		librarianService.getAllLibrarianDetails();
	}
}
