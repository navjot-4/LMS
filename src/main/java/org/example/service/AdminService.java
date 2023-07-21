package org.example.service;


import org.example.bean.*;
import org.example.dao.AdminDao;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private static final AdminDao dbService = new AdminDao();
    public static boolean addLibrarian(User user, Librarian librarian) {
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
    public static List<Librarian> viewLibrarians() {

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

    public static boolean deleteLibrarian(String librarianId) {

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
