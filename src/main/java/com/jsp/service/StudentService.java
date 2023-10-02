package com.jsp.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.dao.BookDaao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Book;
import com.jsp.dto.Librarian;
import com.jsp.dto.Student;



public class StudentService {
    Book book = new Book();
    StudentDao studentDao = new StudentDao();
    BookService bookService = new BookService();
    BookDaao bookDao = new BookDaao();
    LibrarianDao librarianDao = new LibrarianDao();
    Student student = new Student();

    public Student saveStudentDetails(Student student) {
        Student savedStudent = studentDao.saveStudentDetails(student);
        if (savedStudent != null) {
            System.out.println("Student details have been saved");
        } else {
            System.out.println("Failed to save student details");
        }
        return savedStudent;
    }

    public Student deleteStudentById(int id) {
        Student deletedStudent = studentDao.deleteStudentById(id);
        if (deletedStudent != null) {
            System.out.println("Student with ID has been deleted");
        } else {
            System.out.println("Failed to delete student with ID ");
        }
        return deletedStudent;
    }

    public Student updateStudentDetailsById(int id, String name, String email, long ph_no) {
        Student updatedStudent = studentDao.updateStudentDetailsById(id, name, email, ph_no);
        if (updatedStudent != null) {
            System.out.println("Student details have been updated");
        } else {
            System.out.println("Failed to update details");
        }
        return updatedStudent;
    }

    public Student getStudentDetailsById(int id) {
        Student student = studentDao.getStudentDetailsById(id);
        if (student != null) {
            System.out.println("ID: " + student.getSid());
            System.out.println("Name: " + student.getSname());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Phone Number: " + student.getPhone_no());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
        return student;
    }

    public List<Student> getAllStudentDetails() {
        List<Student> studentList = studentDao.getAllStudentDetails();
        if (!studentList.isEmpty()) {
            System.out.println("All student details:");
            for (Student s : studentList) {
                System.out.println("================");
                System.out.println("ID: " + s.getSid());
                System.out.println("Name: " + s.getSname());
                System.out.println("Email: " + s.getEmail());
                System.out.println("Phone Number: " + s.getPhone_no());
                System.out.println("================");
            }
        } else {
            System.out.println("No students found");
        }
        return studentList;
    }
	
    public boolean returnBookById(int bookid) {
        Book book = bookDao.getBookById(bookid);
        if (book != null && book.getStatus().equals("Issued")) {
            Student student = book.getStudent();
            Librarian librarian = book.getLibrarian();

            if (student != null && librarian != null) {
                book.setStatus("Available");
                book.setStudent(null);
                book.setLibrarian(null);
                boolean returned = bookDao.returnBook(book);
                if (returned) {
                    System.out.println("Book with ID has been returned");
                } else {
                    System.out.println("Failed to return book");
                }
                return returned;
            }
        }
        System.out.println("Book cannot be returned");
        return false;
    }
	
	 public boolean requestBook(int bookid, int libid, int studid) {
			Book book = bookDao.getBookById(bookid);
			Student student = studentDao.getStudentDetailsById(studid);
			Librarian librarian = librarianDao.getLibrarianDetailsById(libid);
			if (librarian != null && book != null && student != null) {
				if(!book.getStatus().equals("Available")) 
					System.out.println("The book is already in request"); 
				else {
				book.setStatus("In Request");
				book.setStudent(student);
				book.setLibrarian(librarian);  
				
				System.out.println("Request Sent SuccessFully!");

				return bookDao.requestBook(book);
			} 
			}
			return false;
		}  
} 
        
