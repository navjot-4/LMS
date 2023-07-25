package org.example.service;

import org.example.bean.Book;
import org.example.bean.Issue;
import org.example.bean.Student;

import java.util.List;

public interface LibrarianServiceInterface {

    public boolean addBook(Book book);
    public boolean removeBook(String bookId);
    public boolean issueBook(String bookId , String librarianId ,String studentId);

    public boolean returnBook(int issueId);
    public List<Book> viewBooks();
    public List<Issue> viewIssuedBooks();

    public List<Issue> viewAllIssueLogs();
    public boolean addStudent( Student student);
}
