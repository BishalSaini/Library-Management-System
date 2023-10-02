package com.jsp.controller;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

public class StudentTestSave {
	public static void main(String[] args) { 
		StudentService studentService = new StudentService();
		Student student = new Student();

		student.setSname("Vishu");
		student.setEmail("vishu25@mail.com"); 
		student.setPhone_no(123456789);

		studentService.saveStudentDetails(student);
	} 
}
