package org.example.service;


import org.example.bean.*;
import org.example.dao.AdminDao;
import org.example.dao.AdminDaoInterface;

import java.sql.SQLException;
import java.util.List;

public class AdminService implements AdminServiceInterface {
    private  final AdminDaoInterface dbService = new AdminDao();

    @Override
    public  boolean addLibrarian(User user, Librarian librarian) {
        try {
            dbService.addLibrarian(user, librarian);
            return true;
        }catch(SQLException sqe) {
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
    public  List<Librarian> viewLibrarians() {

        try {
            return dbService.viewLibrarians();
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
    public  boolean deleteLibrarian(String librarianId) {

        try {
            dbService.deleteLibrarian(librarianId);
            return true;
        }catch(SQLException sqe) {
            System.out.println("Error Code = " + sqe.getErrorCode());
            System.out.println("SQL state = " + sqe.getSQLState());
            System.out.println("Message = " + sqe.getMessage());
            return false;
        }
    }
}
