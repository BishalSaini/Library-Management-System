package com.jsp.controller;

import com.jsp.service.BookService;

public class BookTestDelete { 
	public static void main(String[] args) {
		
	
	BookService bookService=new BookService(); 
	bookService.removeBook(3);

}
}