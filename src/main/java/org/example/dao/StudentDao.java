package org.example.dao;

import org.example.bean.Book;
import org.example.bean.Issue;
import org.example.bean.Student;
import org.example.constants.SQLConstants;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class StudentDao implements StudentDaoInterface
{
    @Override
    public List<Book> fetchIssuedBooks(String studentId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ISSUE_BOOKS_QUERY);
        stmt.setString(1,studentId);
        ResultSet output = stmt.executeQuery();
        List<Book> books = new ArrayList<Book>();
        while(output.next()){
            Book book = new Book();
            book.setBookId(output.getString(1));
            book.setAuthor(output.getString(3));
            book.setName(output.getString(2));
            books.add(book);
        }
        return books;
    }


    @Override
    public Student fetchStudentDetails(String studentId) throws SQLException {
            Connection conn =null;
            PreparedStatement stmt = null;
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_Student_QUERY);
            stmt.setString(1,studentId);
            ResultSet output = stmt.executeQuery();
            output.next();
            Student student = new Student();
            student.setStudentId(output.getString(1));
            student.setName(output.getString(2));
            student.setEmail(output.getString(3));
            student.setAddress(output.getString(4));
            student.setMobile(output.getString(5));
            return student;
    }



    @Override
    public List<Student> fetchALLStudentDetails() throws SQLException {
        Connection conn =null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_Student_QUERY);
        ResultSet output = stmt.executeQuery();
        List<Student> students = new ArrayList<Student>();
        while(output.next()) {
            Student student = new Student();
            student.setStudentId(output.getString(1));
            student.setName(output.getString(2));
            student.setEmail(output.getString(3));
            student.setAddress(output.getString(4));
            student.setMobile(output.getString(5));
            students.add(student);
            students.add(student);
        }
        return students;
    }
}