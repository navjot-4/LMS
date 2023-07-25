package org.example.service;

import java.sql.SQLException;
import java.util.List;
import org.example.bean.*;
import org.example.dao.StudentDao;
import org.example.dao.StudentDaoInterface;

public class StudentService implements StudentServiceInterface {
    private final StudentDaoInterface dbService = new StudentDao();

    @Override
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

    @Override
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

    @Override
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
