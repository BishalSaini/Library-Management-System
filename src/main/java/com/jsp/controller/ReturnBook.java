package com.jsp.controller;

import com.jsp.service.StudentService;

public class ReturnBook {   
	public static void main(String[] args) {
		StudentService studentService=new StudentService(); 
		studentService.returnBookById(4);
	}
}