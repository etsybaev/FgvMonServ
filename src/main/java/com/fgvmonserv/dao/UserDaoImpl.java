package com.fgvmonserv.dao;

import com.fgvmonserv.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */


@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        System.out.println("Adding user " + user);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        System.out.println("User " + user + " has been added");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("Updating user " + user);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        System.out.println("User " + user + " has been updated");
    }

    @Override
    public void removeUser(int id) {
        System.out.println("Removing user with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if(user != null){
            session.delete(user);
        }
        System.out.println("User has been removed");
    }

    @Override
    public User getUserById(int id) {
        System.out.println("Getting user with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        System.out.println("Got user " + user);
        return user;
    }

    public User getUserByContactPhoneNumber(String phoneNumber){
        System.out.println("Getting user by PhoneNumber " + phoneNumber);
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from User where contactPhoneNumber = :phoneNumber";
        User user = (User) session.createQuery(hql)
                                  .setParameter("phoneNumber", phoneNumber)
                                  .uniqueResult();
        System.out.println("Got user " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        System.out.println("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();

        for(User user : list){
            System.out.println("Got user " + user);
        }
        return list;
    }
}
