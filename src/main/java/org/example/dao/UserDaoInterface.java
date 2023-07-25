package org.example.dao;

import java.sql.SQLException;

public interface UserDaoInterface {
    public boolean authenticateUser(String userName, String password) throws SQLException;
}
