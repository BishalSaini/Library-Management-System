package com.jsp.controller;

import com.jsp.service.StudentService;

public class StudentTestGetAll { 
	public static void main(String[] args) {
		StudentService studentService=new StudentService(); 
		studentService.getAllStudentDetails();
	}

}
