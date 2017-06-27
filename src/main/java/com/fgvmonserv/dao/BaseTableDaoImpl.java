package com.fgvmonserv.dao;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final Logger LOGGER = LogManager.getLogger(this);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBaseTableRecord(BaseTable baseTable) {
        LOGGER.debug("Adding BaseTable record " + baseTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(baseTable);
        LOGGER.debug("Record has been added");
    }

    @Override
    public void updateBaseTableRecord(BaseTable baseTable) {
        LOGGER.debug("Updating BaseTable record " + baseTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(baseTable);
        LOGGER.debug("Record has been updated");
    }

    @Override
    public BaseTable getRecordById(int id) {
        LOGGER.debug("Getting BaseTable record with id = " + id);
        BaseTable baseTable = this.sessionFactory.getCurrentSession().load(BaseTable.class, id);
        LOGGER.debug("Got record " + baseTable);
        return baseTable;
    }

    @Override
    public List<BaseTable> getAllRecordsList() {
        LOGGER.debug("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();
        List<BaseTable> list = session.createQuery("from BaseTable").list();
        for(BaseTable baseTable : list){
            LOGGER.debug("Got user " + baseTable);
        }
        return list;
    }

    @Override
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter) {
        LOGGER.debug("Getting all user list according to filter:" + baseTableDateFilter);
        Session session = this.sessionFactory.getCurrentSession();

        List<BaseTable> list = getQueryForFetchAllRecordsAccordingToFilter(baseTableDateFilter, session).list();

        for(BaseTable baseTable : list){
            LOGGER.debug("Got user " + baseTable);
        }
        return list;
    }

    @Override
    public List<String> getAllBanksList() {
        LOGGER.debug("Getting all Banks list");
        Session session = sessionFactory.getCurrentSession();
        List<String> bankList = session.createQuery("select distinct bank FROM BaseTable order by bank").list();
        LOGGER.debug("Got bank list: " + bankList);
        return bankList;
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
        if(baseTableDateFilter.getBank() != null && !baseTableDateFilter.getBank().isEmpty()){
            sb.append(" and " + BaseTableNamesEnum.BANK.getDbName() + "=:bank ");
        }
        if(baseTableDateFilter.getStatusOfCall() != null && baseTableDateFilter.getStatusOfCall().getId() != null ){
            sb.append(" and " + BaseTableNamesEnum.STATUS_OF_CALL.getDbName() + "=:statusOfCall ");
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
        if(baseTableDateFilter.getBank() != null && !baseTableDateFilter.getBank().isEmpty()){
            query.setParameter("bank", baseTableDateFilter.getBank());
        }
        if(baseTableDateFilter.getStatusOfCall() != null && baseTableDateFilter.getStatusOfCall().getId() != null){
            query.setParameter("statusOfCall", baseTableDateFilter.getStatusOfCall());
        }
        return query;
    }

    @Override
    public void removeBaseTableRecord(int id) {
        LOGGER.debug("Removing BaseTable record with id = " + id);
        Session session = this.sessionFactory.getCurrentSession();
        BaseTable baseTable = session.load(BaseTable.class, id);
        if(baseTable != null){
            session.delete(baseTable);
            LOGGER.debug("Record has been removed");
        }else {
            LOGGER.debug("WARNING! Record has not been found in DB!");
        }
    }
}
