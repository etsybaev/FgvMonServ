package com.fgvmonserv.dao;

import com.fgvmonserv.model.User;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public User getUserByContactPhoneNumber(String phoneNumber);//contact phone number is used as main identifier(loginName) in Spring Security
    public List<User> listUsers();
}
