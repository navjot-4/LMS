package org.example.dao;

import org.example.bean.Book;
import org.example.bean.Issue;
import org.example.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface LibrarianDaoInterface {

    public void addBook(Book book) throws SQLException;
    public void removeBook(String bookId) throws SQLException;
    public void returnBook(int issueId) throws SQLException;
    public void issueBook(String bookId , String librarianId ,String studentId) throws SQLException;
    public List<Book> fetchAllBooks() throws SQLException;
    public List<Issue> fetchAllIssueLogs() throws SQLException;
    public List<Issue> fetchAllIssuedBooks() throws SQLException;
    public void addStudent(Student student) throws SQLException;
}
