package com.jsp.controller;

import com.jsp.service.LibrarianService;

public class Issue_Book { 
		public static void main(String[] args) {
			LibrarianService librarianService = new LibrarianService();
			librarianService.issueBookById(4, 1, 2);
		
		} 
}
