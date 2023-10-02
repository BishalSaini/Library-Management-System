package com.jsp.controller;

import com.jsp.service.StudentService;

public class StudentTestGetById { 
	public static void main(String[] args) {
		StudentService studentService=new StudentService(); 
		studentService.getStudentDetailsById(1);
	}

}
