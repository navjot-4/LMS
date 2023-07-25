package org.example.dao;

import org.example.bean.Book;
import org.example.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDaoInterface {
    public List<Book> fetchIssuedBooks(String studentId) throws SQLException;
    public Student fetchStudentDetails(String studentId) throws SQLException;

    public List<Student> fetchALLStudentDetails() throws SQLException;
}
