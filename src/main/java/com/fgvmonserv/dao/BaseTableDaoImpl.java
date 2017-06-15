package com.fgvmonserv.dao;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
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

        List<BaseTable> list = getQueryForFetchAllRecordsAccordingToFilter(baseTableDateFilter, session).list();

        for(BaseTable baseTable : list){
            System.out.println("Got user " + baseTable);
        }
        return list;
    }

    //TODO to investigate options and rewrite!!!!!!!!!!!!!!!!!!!!!!!!
    private Query getQueryForFetchAllRecordsAccordingToFilter(BaseTableDateFilter baseTableDateFilter, Session session){
        StringBuffer sb = new StringBuffer();

        sb.append("from BaseTable where " + baseTableDateFilter.getBaseTableNamesEnum().getDbName() +
                baseTableDateFilter.getSearchByRangeTypeEnum().getSqlSymbol() + ":auctionDateStartFromFilter ");


        if(baseTableDateFilter.getManager() != null && baseTableDateFilter.getManager().getId() != null ){
            sb.append(" and " + BaseTableNamesEnum.MANAGER.getDbName() + "=:manager ");
        }
        if(baseTableDateFilter.getStatusOfDeal() != null && baseTableDateFilter.getStatusOfDeal().getId() != null ){
            sb.append(" and " + BaseTableNamesEnum.STATUS_OF_DEAL.getDbName() + "=:statusOfDeal ");
        }
        if(baseTableDateFilter.getIsUnderControl() != null){
            sb.append(" and " + BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName() + "=:isUnderControl ");
        }

        Query query = session.createQuery(sb.toString());
        query.setParameter("auctionDateStartFromFilter", baseTableDateFilter.getStartDate());

        if(baseTableDateFilter.getManager() != null && baseTableDateFilter.getManager().getId() != null ){
            query.setParameter("manager", baseTableDateFilter.getManager());
        }
        if(baseTableDateFilter.getStatusOfDeal() != null && baseTableDateFilter.getStatusOfDeal().getId() != null){
            query.setParameter("statusOfDeal", baseTableDateFilter.getStatusOfDeal());
        }
        if(baseTableDateFilter.getIsUnderControl() != null){
            query.setParameter("isUnderControl", baseTableDateFilter.getIsUnderControl());
        }
        return query;
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
