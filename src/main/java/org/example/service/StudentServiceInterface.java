package org.example.service;

import org.example.bean.Book;
import org.example.bean.Student;

import java.util.List;

public interface StudentServiceInterface {

    public List<Book> issuedBooks(String studentId);

    public Student viewDetails(String studentId);

    public List<Student> viewALLStudentDetails();
}
