package org.example.service;

import org.example.bean.User;

public interface UserServiceInterface {
    public boolean authenticateUser(User userData);
    public boolean logout(User userData);

}
