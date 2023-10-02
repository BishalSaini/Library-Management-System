package com.jsp.service;

import java.util.List;

import com.jsp.dao.BookDaao;
import com.jsp.dao.LibrarianDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Book;
import com.jsp.dto.Librarian;
import com.jsp.dto.Student;

public class BookService { 
    BookDaao bookDao = new BookDaao();
    LibrarianDao librarianDao = new LibrarianDao();
    Book book = new Book();
    StudentDao studentDao = new StudentDao();

    public Book saveBook(Book book, int libid) {
        Book savedBook = bookDao.saveBook(book);
        if (savedBook != null) {
            System.out.println("Book has been saved");
        } else {
            System.out.println("Failed to save the book");
        }
        return savedBook;
    }

    public Book removeBook(int id) {
        Book removedBook = bookDao.removeBook(id);
        if (removedBook != null) {
            System.out.println("Book has been removed");
        } else {
            System.out.println("Failed to remove book");
        }
        return removedBook;
    }

    public Book updateBookById(int id, String book_name, String author_name) {
        Book updatedBook = bookDao.updateBookById(id, book_name, author_name);
        if (updatedBook != null) {
            System.out.println("Book details have been updated");
        } else {
            System.out.println("Failed to update details");
        }
        return updatedBook;
    }

    public Book getBookById(int id) {
        Book book = bookDao.getBookById(id);
        if (book != null) {
            System.out.println("Book ID: " + book.getBook_id());
            System.out.println("Book Name: " + book.getBook_name());
            System.out.println("Author Name: " + book.getAuthor_name());
            System.out.println("Status: " + book.getStatus());
        } else {
            System.out.println("Book not found");
        }
        return book;
    }

    public List<Book> getAllBooks() {
        List<Book> book = bookDao.getAllBooks();
        if (!book.isEmpty()) {
            System.out.println("All book details:");
            for (Book b : book) {
                System.out.println("================");
                System.out.println("Book ID: " + b.getBook_id());
                System.out.println("Book Name: " + b.getBook_name());
                System.out.println("Author Name: " + b.getAuthor_name());
                System.out.println("Status: " + b.getStatus());
                System.out.println("================");
            }
        } else {
            System.out.println("No books found");
        }
        return book;
    }
		
} 
