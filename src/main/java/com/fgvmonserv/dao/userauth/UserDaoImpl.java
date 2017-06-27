package com.fgvmonserv.dao.userauth;

import com.fgvmonserv.model.userauth.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */


@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private final Logger LOGGER = LogManager.getLogger(this);
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        LOGGER.debug("Adding user " + user);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        LOGGER.debug("User " + user + " has been added");
    }

    @Override
    public void updateUser(User user) {
        LOGGER.debug("Updating user " + user);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        LOGGER.debug("User " + user + " has been updated");
    }

    @Override
    public void removeUser(int id) {
        LOGGER.debug("Removing user with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if(user != null){
            session.delete(user);
        }
        LOGGER.debug("User has been removed");
    }

    @Override
    public User getUserById(int id) {
        LOGGER.debug("Getting user with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        LOGGER.debug("Got user " + user);
        return user;
    }

    public User getUserByContactPhoneNumber(String phoneNumber){
        LOGGER.debug("Getting user by PhoneNumber " + phoneNumber);
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from User where contactPhoneNumber = :phoneNumber";
        User user = (User) session.createQuery(hql)
                                  .setParameter("phoneNumber", phoneNumber)
                                  .uniqueResult();
        LOGGER.debug("Got user " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        LOGGER.debug("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User").list();

        for(User user : list){
            LOGGER.debug("Got user " + user);
        }
        return list;
    }
}
