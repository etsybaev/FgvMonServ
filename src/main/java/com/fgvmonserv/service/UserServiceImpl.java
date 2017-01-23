package com.fgvmonserv.service;

import com.fgvmonserv.dao.UserDao;
import com.fgvmonserv.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }


    //contact phone number is used as main identifier(loginName) in Spring Security
    @Override
    @Transactional
    public User getUserByContactPhoneNumber(String phoneNumber){
        return this.userDao.getUserByContactPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
