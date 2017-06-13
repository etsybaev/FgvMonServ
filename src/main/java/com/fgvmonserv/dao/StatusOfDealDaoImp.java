package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfDeal;
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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String getStatusById(int id) {
        Session session = sessionFactory.getCurrentSession();
        StatusOfDeal statusOfDeal = session.load(StatusOfDeal.class, id);
        return statusOfDeal.getStatus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StatusOfDeal> getAllStatusList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<StatusOfDeal> list = session.createQuery("from StatusOfDeal").list();
        return list;
    }
}
