package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class LibrarianTestGetById { 
	public static void main(String[] args) {
		LibrarianService librarianService =new LibrarianService();
		librarianService.getLibrarianDetailsById(1);
	}


}
