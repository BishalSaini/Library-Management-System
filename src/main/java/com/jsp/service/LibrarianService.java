package com.jsp.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.dao.BookDaao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Admin;
import com.jsp.dto.Book;
import com.jsp.dto.Librarian;
import com.jsp.dto.Student;
 
	public class LibrarianService {
	    LibrarianDao librarianDao = new LibrarianDao();
	    BookDaao bookDao = new BookDaao();
	    Librarian librarian = new Librarian();
	    StudentDao studentDao = new StudentDao();

	    public Librarian saveLibrarianDetails(Librarian librarian) {
	        librarian.setStatus("unauthorized");
	        Librarian savedLibrarian = librarianDao.saveLibrarianDetails(librarian);
	        if (savedLibrarian != null) {
	            System.out.println("Librarian details have been saved");
	        } else {
	            System.out.println("Failed to save librarian details");
	        }
	        return savedLibrarian;
	    }

	    public Librarian deleteLibrarianDetailsById(int id) {
	        Librarian deletedLibrarian = librarianDao.deleteLibrarinDetailsById(id);
	        if (deletedLibrarian != null) {
	            System.out.println("Librarian has been deleted");
	        } else {
	            System.out.println("Failed to delete");
	        }
	        return deletedLibrarian;
	    }

	    public Librarian updateLibrarianById(int id, String name, String email) {
	        Librarian updatedLibrarian = librarianDao.updateLibrarianDetailsById(id, name, email);
	        if (updatedLibrarian != null) {
	            System.out.println("Librarian details have been updated");
	        } else {
	            System.out.println("Failed to update details");
	        }
	        return updatedLibrarian;
	    }

	    public Librarian getLibrarianDetailsById(int id) {
	        Librarian librarian = librarianDao.getLibrarianDetailsById(id);
	        if (librarian != null) {
	        	System.out.println("ID: " + librarian.getId());
	            System.out.println("Name: " + librarian.getName());
	            System.out.println("Email: " + librarian.getEmail());
	        } else {
	            System.out.println("Librarian not found");
	        }
	        return librarian;
	    }

	    public List<Librarian> getAllLibrarianDetails() {
	        List<Librarian> librarianList = librarianDao.getAllLibrarianDetails();
	        if (!librarianList.isEmpty()) {
	            System.out.println("All librarian details:");
	            for (Librarian l : librarianList) {
	                System.out.println("================");
	                System.out.println("ID: " + l.getId());
	                System.out.println("Name: " + l.getName());
	                System.out.println("Email: " + l.getEmail());
	                System.out.println("Status: " + l.getStatus());
	                System.out.println("================");
	            }
	        } else {
	            System.out.println("No librarian details found");
	        }
	        return librarianList;
	    }

	    public Book saveBook(Book book, int libid) {
	        Librarian librarian = librarianDao.getLibrarianDetailsById(libid);
	        if (librarian != null && librarian.getId() == libid && librarian.getStatus().equalsIgnoreCase("authorized")) {
	            Book savedBook = bookDao.saveBook(book);
	            if (savedBook != null) {
	                System.out.println("Book has been saved");
	            } else {
	                System.out.println("Failed to save the book");
	            }
	            return savedBook;
	        } else {
	            System.out.println("Librarian is not authorized or not found");
	            return book;
	        }
	    }

	    // librarian remove book
		public Boolean removeBookById(int bookid) {
			BookDaao bookDao = new BookDaao();
			bookDao.removeBook(bookid);
			return true;
		}

	    public Book issueBookById(int bookid, int libid, int studid) {
	        Book book = bookDao.getBookById(bookid);
	        Student student = studentDao.getStudentDetailsById(studid);
	        Librarian librarian = librarianDao.getLibrarianDetailsById(libid);

	        if (librarian != null && book != null && student != null) {
	            if (book.getStatus().equals("Issued")) {
	                System.out.println("The book is already issued");
	            } else {
	                book.setStatus("Issued");
	                book.setStudent(student);
	                book.setLocalDate(LocalDate.now());
	                book.setLibrarian(librarian);

	                System.out.println("Book issued successfully!");
	                bookDao.issue(book);
	            }
	        } else {
	            System.out.println("Book not issued.");
	        }
	        return book;
	    }
}

 