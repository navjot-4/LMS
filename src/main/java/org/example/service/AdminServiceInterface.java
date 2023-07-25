package org.example.service;

import org.example.bean.Librarian;
import org.example.bean.User;

import java.util.List;

public interface AdminServiceInterface {
    public  boolean addLibrarian(User user, Librarian librarian);

    public  List<Librarian> viewLibrarians();
    public  boolean deleteLibrarian(String librarianId);

}
