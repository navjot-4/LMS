package org.example.service;

import java.sql.SQLException;
import java.util.List;
import org.example.bean.*;
import org.example.dao.Librariandao;
import org.example.dao.StudentDao;

public class StudentService {
    private final StudentDao dbService = new StudentDao();
    public List<Book> issuedBooks(String studentId) {
        try{
        return  dbService.fetchIssuedBooks( studentId);
        } catch (SQLException sqe) {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return null;
        }catch (Exception exp){
            System.out.println(exp);
            return null;
        }

    }
    public Student viewDetails(String studentId) {
        try {
            return dbService.fetchStudentDetails(studentId);
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return null;
        }catch (Exception exp){
            System.out.println(exp);
            return null;
        }
    }
    public List<Student> viewALLStudentDetails()  {
        try{
        return dbService.fetchALLStudentDetails();}catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return null;
        }catch (Exception exp){
            System.out.println(exp);
            return null;
        }

    }



}
