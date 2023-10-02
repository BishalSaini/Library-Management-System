package com.jsp.controller;

import com.jsp.service.BookService;

public class BookTestGetAll { 
	public static void main(String[] args) {
		BookService bookService=new BookService();  
		bookService.getAllBooks();
	}
}
