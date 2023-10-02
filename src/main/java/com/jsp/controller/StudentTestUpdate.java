package com.jsp.controller;

import com.jsp.service.StudentService;

public class StudentTestUpdate {  
	public static void main(String[] args) {
	StudentService studentService=new StudentService();  
	studentService.updateStudentDetailsById(1, "vishu", "vishu25@mail.com", 987654321);
	}
}
