package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */

@Repository
public class BaseTableDaoImpl implements BaseTableDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBaseTableRecord() {
        throw new RuntimeException("Method  implemented");
    }

    @Override
    public List<BaseTable> getAllRecordsList() {
        System.out.println("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();
        List<BaseTable> list = session.createQuery("from BaseTable").list();
        for(BaseTable baseTable : list){
            System.out.println("Got user " + baseTable);
        }
        return list;
    }
}
