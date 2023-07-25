package org.example.service;
import org.example.bean.*;
import org.example.dao.UserDao;
import org.example.dao.UserDaoInterface;

import java.sql.SQLException;

public class UserService  implements  UserServiceInterface{
    private static UserDaoInterface dbService = new UserDao();

    @Override
    public boolean authenticateUser(User userData){
        String userName = userData.getUserName();
        String password = userData.getPassword();
        try {
            return dbService.authenticateUser(userName,password);
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
    public boolean logout(User userData) {
        return true;
    }

}
