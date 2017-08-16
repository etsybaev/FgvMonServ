package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfDeal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgeniit on 13.06.17.
 */

@Repository
public class StatusOfDealDaoImp implements StatusOfDealDao {

    private SessionFactory sessionFactory;
    private final Logger LOGGER = LogManager.getLogger(this);
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStatusOfDeal(StatusOfDeal statusOfDeal) {
        LOGGER.debug("Adding status of deal: " + statusOfDeal);
        Session session = sessionFactory.getCurrentSession();
        session.persist(statusOfDeal);
        LOGGER.debug("Status Of deal " + statusOfDeal + " has been added");
    }

    @Override
    public void updateStatusOfDeal(StatusOfDeal statusOfDeal) {
        LOGGER.debug("Updating status of deal " + statusOfDeal);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(statusOfDeal);
        LOGGER.debug("Status of deal " + statusOfDeal + " has been updated");
    }

    @Override
    public void deleteStatusOfDeal(int id) {
        LOGGER.debug("Removing Status Of deal with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        StatusOfDeal statusOfDeal = (StatusOfDeal) session.load(StatusOfDeal.class, new Integer(id));
        if(statusOfDeal != null){
            session.delete(statusOfDeal);
        }
        LOGGER.debug("Status of call has been removed");
    }

    @Override
    public StatusOfDeal getStatusById(int id) {
        LOGGER.debug("Getting statusOfDeal with id=" + id);
        Session session = sessionFactory.getCurrentSession();
        StatusOfDeal statusOfDeal = session.load(StatusOfDeal.class, id);
        LOGGER.debug("Found status of Deal is:" + statusOfDeal);
        return statusOfDeal;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StatusOfDeal> getAllStatusList() {
        LOGGER.debug("Getting all Statuses of Deal");
        Session session = this.sessionFactory.getCurrentSession();
        List<StatusOfDeal> list = session.createQuery("from StatusOfDeal").list();
        LOGGER.debug("Found statuses list is: " + list);
        return list;
    }
}
