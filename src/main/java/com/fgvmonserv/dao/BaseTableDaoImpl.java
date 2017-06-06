package com.fgvmonserv.dao;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import com.fgvmonserv.model.userauth.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public void updateBaseTableRecord(BaseTable baseTable) {
        System.out.println("Updating BaseTable record " + baseTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(baseTable);
        System.out.println("Record has been updated");
    }

    @Override
    public BaseTable getRecordById(int id) {
        System.out.println("Getting BaseTable record with id = " + id);
        BaseTable baseTable = this.sessionFactory.getCurrentSession().load(BaseTable.class, id);
        System.out.println("Got record " + baseTable);
        return baseTable;
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

    @Override
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter) {
        System.out.println("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();

        Query query = null;
        if (baseTableDateFilter.getBaseTableNamesEnum() == BaseTableNamesEnum.NEW_AUCTION_DATE){
            query = session.createQuery("from BaseTable where newAuctionDate >=:auctionDateStartFromFilter");
            query.setParameter("auctionDateStartFromFilter", baseTableDateFilter.getStartDate());
        }else if (baseTableDateFilter.getBaseTableNamesEnum() == BaseTableNamesEnum.AUCTION_DATE){
            query = session.createQuery("from BaseTable where auctionDate >=:auctionDateStartFromFilter");
            query.setParameter("auctionDateStartFromFilter", baseTableDateFilter.getStartDate());
        } else {
            System.out.println("ERROR! Wrong enum provided! Returning all values without filtering");
            query = session.createQuery("from BaseTable");
        }
        List<BaseTable> list = query.list();

        for(BaseTable baseTable : list){
            System.out.println("Got user " + baseTable);
        }
        return list;
    }

    @Override
    public void removeBaseTableRecord(int id) {
        System.out.println("Removing BaseTable record with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        BaseTable baseTable = session.load(BaseTable.class, id);
        if(baseTable != null){
            session.delete(baseTable);
            System.out.println("Record has been removed");
        }else {
            System.out.println("WARNING! Record has not been found in DB!");
        }
    }
}
