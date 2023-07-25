package org.example.dao;

import org.example.bean.Librarian;
import org.example.bean.User;
import org.example.constants.SQLConstants;
import org.example.service.AdminServiceInterface;
import org.example.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements AdminDaoInterface {

    @Override
    public void addLibrarian(User user , Librarian librarian) throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;

            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement(SQLConstants.SQL_ADD_LIBRARIAN_USER_QUERY);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, 2);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(SQLConstants.SQL_ADD_LIBRARIAN_QUERY);
            stmt.setString(1, librarian.getLibrarianId());
            stmt.setString(2, librarian.getName());
            stmt.setString(3, librarian.getAddress());
            stmt.setString(4, librarian.getMobile());
            stmt.setString(5, librarian.getEmail());
            System.out.println("dkmjgore");
            stmt.executeUpdate();


    }
   @Override
    public void deleteLibrarian(String librarianId) throws SQLException {

           Connection conn = null;
           PreparedStatement stmt = null;

           conn = DBUtils.getConnection();

           stmt = conn.prepareStatement(SQLConstants.SQL_DELETE_LIBRARIAN_QUERY);
           stmt.setString(1, librarianId);
           stmt.executeUpdate();

           stmt = conn.prepareStatement(SQLConstants.SQL_DELETE_LIBRARIAN_USER_QUERY);
           stmt.setString(1, librarianId);
           stmt.executeUpdate();


    }

    @Override
    public List<Librarian> viewLibrarians() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        conn = DBUtils.getConnection();

        stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_ALL_LIBRARIAN_QUERY);

        ResultSet output =  stmt.executeQuery();
        List<Librarian> librarians = new ArrayList<Librarian>();
        while(output.next()) {
            Librarian librarian = new Librarian();
            librarian.setLibrarianId(output.getString(1));
            librarian.setName(output.getString(2));
            librarian.setAddress(output.getString(3));
            librarian.setMobile(output.getString(4));
            librarian.setEmail(output.getString(5));
            librarians.add(librarian);
        }
            return librarians;

    }

}
