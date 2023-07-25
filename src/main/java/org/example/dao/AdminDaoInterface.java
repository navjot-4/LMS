package org.example.dao;

import org.example.bean.Librarian;
import org.example.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface AdminDaoInterface {
    public void addLibrarian(User user , Librarian librarian) throws SQLException;
    public void deleteLibrarian(String librarianId)throws SQLException;
    public List<Librarian> viewLibrarians()throws SQLException;
}
