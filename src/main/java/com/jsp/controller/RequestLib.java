package com.jsp.controller;

import com.jsp.service.BookService;
import com.jsp.service.StudentService;


public class RequestLib { 
		public static void main(String[] args) { 
			StudentService studentService=new StudentService(); 
			studentService.requestBook(4, 1, 2);
		}
}