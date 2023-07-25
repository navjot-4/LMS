package org.example.dao;

import org.example.bean.Book;
import org.example.bean.Issue;
import org.example.bean.Student;
import org.example.constants.SQLConstants;
import org.example.service.LibrarianServiceInterface;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao implements LibrarianDaoInterface {
   @Override
    public void addBook(Book book) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        conn = DBUtils.getConnection();

        stmt = conn.prepareStatement(SQLConstants.SQL_ADD_BOOK_QUERY);
        stmt.setString(1,book.getBookId());
        stmt.setString(2,book.getName());
        stmt.setString(3,book.getAuthor());
        stmt.executeUpdate();
    }

    @Override
    public void removeBook(String bookId) throws SQLException {
        Connection conn =null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();

        stmt = conn.prepareStatement(SQLConstants.SQL_REMOVE_BOOK_QUERY);
        stmt.setString(1,bookId);
        stmt.executeUpdate();
    }

   @Override
    public void returnBook(int issueId) throws SQLException {
        Connection conn =null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_RETURN_BOOK_QUERY);
        stmt.setInt(1,issueId);
        stmt.executeUpdate();
    }

    @Override
    public void issueBook(String bookId , String librarianId ,String studentId) throws SQLException {
        Connection conn =null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();

        stmt = conn.prepareStatement(SQLConstants.SQL_CHECK_BOOK_ISSUED_QUERY);
        stmt.setString(1,bookId);
        ResultSet output = stmt.executeQuery();
        output.next();
        if(output.getInt(1)>0) throw new SQLException();

        stmt = conn.prepareStatement(SQLConstants.SQL_ISSUE_BOOK_QUERY);
        stmt.setString(1,bookId);
        stmt.setString(2,librarianId);
        stmt.setString(3,studentId);
        stmt.executeUpdate();
    }

   @Override
    public List<Book> fetchAllBooks() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn =DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_BOOKS_QUERY);
        ResultSet output = stmt.executeQuery();
        List<Book> books = new ArrayList<Book>();
        while(output.next()){
            Book book = new Book();
            book.setBookId(output.getString(1));
            book.setName(output.getString(2));
            book.setAuthor(output.getString(3));
            books.add(book);
        }
        return books;
    }

    @Override
    public List<Issue> fetchAllIssueLogs() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn =DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_ISSUE_LOGS_QUERY);
        ResultSet output = stmt.executeQuery();
        List<Issue> logs = new ArrayList<Issue>();
        while(output.next()){
            Issue log = new Issue();
            log.setBookId(output.getString(3));
            log.setIssueId(output.getInt(1));
            log.setLibrarianId(output.getString(2));
            log.setIssueDate(output.getTimestamp(5).toLocalDateTime());
            log.setReturned(output.getBoolean(6));
            log.setStudentId(output.getString(4));
            logs.add(log);
        }
        return logs;
    }

    @Override
    public List<Issue> fetchAllIssuedBooks() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn =DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_ISSUE_BOOKS_QUERY);

        ResultSet output = stmt.executeQuery();
        List<Issue> issues = new ArrayList<Issue>();
        while(output.next()){
            Issue issue = new Issue();
            issue.setBookId(output.getString(3));
            issue.setIssueId(output.getInt(1));
            issue.setLibrarianId(output.getString(2));
            issue.setIssueDate(output.getTimestamp(5).toLocalDateTime());
            issue.setReturned(output.getBoolean(6));
            issue.setStudentId(output.getString(4));
            issues.add(issue);
        }
        return issues;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt =null;
        conn = DBUtils.getConnection();

        stmt = conn.prepareStatement(SQLConstants.SQL_ADD_STUDENT_QUERY);
        stmt.setString(1,student.getStudentId());
        stmt.setString(2,student.getName());
        stmt.setString(3,student.getEmail());
        stmt.setString(4,student.getAddress());
        stmt.setString(5,student.getMobile());
        stmt.executeUpdate();
    }
}
