package org.example.service;


import org.example.bean.*;

import org.example.dao.LibrarianDao;
import org.example.dao.LibrarianDaoInterface;

import java.sql.SQLException;
import java.util.List;


public class LibrarianService implements LibrarianServiceInterface {
    private final LibrarianDaoInterface dbService = new LibrarianDao();
    @Override
    public boolean addBook(Book book)  {
        try{
        dbService.addBook(book);
        return true;
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }catch (Exception exp){
            System.out.println(exp);
            return false;
        }
    }
    @Override
    public boolean removeBook(String bookId) {
        try{
            dbService.removeBook(bookId);
            return true;
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }catch (Exception exp){
            System.out.println(exp);
            return false;
        }
    }


    @Override
    public boolean issueBook(String bookId , String librarianId ,String studentId) {
        try{
            //if()
            dbService.issueBook(bookId, librarianId, studentId);
            return true;
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }catch (Exception exp){
            System.out.println(exp);
            return false;
        }
    }
    @Override
    public boolean returnBook(int issueId)   {
        try{
            dbService.returnBook(issueId);
            return true;
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }catch (Exception exp){
            System.out.println(exp);
            return false;
        }
    }
    @Override
    public List<Book> viewBooks()  {
        try{
            return dbService.fetchAllBooks();
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
    public List<Issue> viewIssuedBooks()  {
        try{
            return dbService.fetchAllIssuedBooks();
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
    public List<Issue> viewAllIssueLogs()  {
        try{
            return dbService.fetchAllIssueLogs();
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
    public boolean addStudent( Student student)  {
        try{
            dbService.addStudent(student);
            return true;
        }catch(SQLException sqe)
        {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }catch (Exception exp){
            System.out.println(exp);
            return false;
        }
    }

}
