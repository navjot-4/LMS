package org.example.dao;

import org.example.constants.SQLConstants;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean authenticateUser(String userName, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        conn = DBUtils.getConnection();
        stmt = conn.prepareStatement(SQLConstants.SQL_AUTH_QUERY);
        stmt.setString(1, userName);
        ResultSet output = stmt.executeQuery();
        output.next();
        String desirePassword = output.getString(1);
        return (password.equals(desirePassword));
    }
}
