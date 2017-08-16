package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfCall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final Logger LOGGER = LogManager.getLogger(this);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStatusOfCall(StatusOfCall statusOfCall) {
        LOGGER.debug("Adding status of Call: " + statusOfCall);
        Session session = sessionFactory.getCurrentSession();
        session.persist(statusOfCall);
    }

    @Override
    public void updateStatusOfCall(StatusOfCall statusOfCall) {
        LOGGER.debug("Updating status of call " + statusOfCall);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(statusOfCall);
        LOGGER.debug("Status of call " + statusOfCall + " has been updated");
    }

    @Override
    public void deleteStatusOfCall(int id) {
        LOGGER.debug("Removing Status Of Call with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        StatusOfCall statusOfCall = (StatusOfCall) session.load(StatusOfCall.class, new Integer(id));
        if(statusOfCall != null){
            session.delete(statusOfCall);
        }
        LOGGER.debug("Status of call has been removed");
    }

    @Override
    public StatusOfCall getCallStatusById(int id) {
        LOGGER.debug("Getting call status with id=" + id);
        Session session = sessionFactory.getCurrentSession();
        StatusOfCall statusOfCall = session.load(StatusOfCall.class, id);
        LOGGER.debug("Found StatusOfCall record is: " + statusOfCall);
        return statusOfCall;
    }

    @Override
    public List<StatusOfCall> getAllStatusesList() {
        LOGGER.debug("Getting all CallStatuses list");
        Session session = sessionFactory.getCurrentSession();
        List<StatusOfCall> list = session.createQuery("from StatusOfCall ").list();
        LOGGER.debug("Got statuses: " + list);
        return list;
    }
}
