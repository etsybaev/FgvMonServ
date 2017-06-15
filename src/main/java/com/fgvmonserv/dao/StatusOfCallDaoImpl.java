package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfCall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgeniit on 15.06.17.
 */


@Repository
public class StatusOfCallDaoImpl implements StatusOfCallDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public StatusOfCall getCallStatusById(int id) {
        System.out.println("Getting call status with id=" + id);
        Session session = sessionFactory.getCurrentSession();
        StatusOfCall statusOfCall = session.load(StatusOfCall.class, id);
        System.out.println("Found StatusOfCall record is: " + statusOfCall);
        return statusOfCall;
    }

    @Override
    public List<StatusOfCall> getAllStatusesList() {
        System.out.println("Getting all CallStatuses list");
        Session session = sessionFactory.getCurrentSession();
        List<StatusOfCall> list = session.createQuery("from StatusOfCall ").list();
        System.out.println("Got statuses: " + list);
        return list;
    }
}
