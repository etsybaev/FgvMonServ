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
    public void addBaseTableRecord(BaseTable baseTable) {
        System.out.println("Adding BaseTable record " + baseTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(baseTable);
        System.out.println("Record has been added");
    }


    @Override
    public void addBaseTableRecordsList(List<BaseTable> baseTablesList) {
        System.out.println("Adding BaseTable record " + baseTablesList);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(baseTablesList);
        System.out.println("Record has been added");
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
