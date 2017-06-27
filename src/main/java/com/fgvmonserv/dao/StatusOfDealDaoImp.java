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
    public String getStatusById(int id) {
        LOGGER.debug("Getting statusOfDeal with id=" + id);
        Session session = sessionFactory.getCurrentSession();
        StatusOfDeal statusOfDeal = session.load(StatusOfDeal.class, id);
        LOGGER.debug("Found status of Deal is:" + statusOfDeal);
        return statusOfDeal.getStatus();
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
