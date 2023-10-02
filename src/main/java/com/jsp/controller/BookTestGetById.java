package com.jsp.controller;

import com.jsp.service.BookService;

public class BookTestGetById { 
	public static void main(String[] args) {
		BookService bookService=new BookService(); 
		bookService.getBookById(1);
	}

}
