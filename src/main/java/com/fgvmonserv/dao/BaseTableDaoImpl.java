package com.fgvmonserv.dao;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.enums.SearchByRangeTypeEnum;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    public BaseTable addBaseTableRecord(BaseTable baseTable) {
        LOGGER.debug("Adding BaseTable record " + baseTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(baseTable);
        LOGGER.debug("Record has been added");
        return baseTable;
    }

    @Override
    public List<BaseTable> addBaseTableRecord(List<BaseTable> baseTableList) {
        LOGGER.debug("Adding BaseTable records list " + baseTableList);
        Session session = this.sessionFactory.getCurrentSession();
//        Transaction tx = session.getTransaction();
        baseTableList.forEach(baseTable -> session.save(baseTable));

//        for ( int i=0; i<baseTableList.size(); i++ ) {
//
//            session.save(baseTableList.get(i));
//            if ( i % 20 == 0 ) { //20, same as the JDBC batch size
//                //flush a batch of inserts and release memory:
//                session.flush();
//                session.clear();
//            }
//        }

//        tx.commit();
//        session.close();
        LOGGER.debug("Records have been added");
        return baseTableList;
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
//        for(BaseTable baseTable : list){
//            LOGGER.debug("Got user " + baseTable);
//        }
        return list;
    }

    @Override
    public List<BaseTable> getAllRecordsList(String searchForText) {
        LOGGER.debug("Getting all user list");
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from BaseTable where concat(\n" +
                "COALESCE(id,''),\n" +
                "COALESCE(bank,''),\n" +
                "COALESCE(auctionDate,''),\n" +
                "COALESCE(lotNumber,''),\n" +
                "COALESCE(kdNumber,''),\n" +
                "COALESCE(aboutAuction,''),\n" +
                "COALESCE(startPrice,''),\n" +
                "COALESCE(auctionStep,''),\n" +
                "COALESCE(stockExchangeCommission,''),\n" +
                "COALESCE(notaryCommission,''),\n" +
                "COALESCE(ourCommission,''),\n" +
                "COALESCE(finalPrice,''),\n" +
                "COALESCE(url,''),\n" +
                "COALESCE(propertyDetails,''),\n" +
                "COALESCE(loanDebtorFullName,''),\n" +
                "COALESCE(loanDebtorPhoneNumber,''),\n" +
                "COALESCE(loanDebtorIdentCode,''),\n" +
                "COALESCE(details,''),\n" +
                "COALESCE(dateOfCall,''),\n" +
                "COALESCE(newAuctionDate,''),\n" +
                "COALESCE(managersComment,''),\n" +
                "COALESCE(symptom,'')) like :searchForText";

        return  (List<BaseTable>) session.createQuery(hql)
                .setParameter("searchForText", "%" + searchForText + "%")
                .list();
    }


    @Override
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter) {
        LOGGER.debug("Getting all baseTable records list according to filter:" + baseTableDateFilter);
        Session session = this.sessionFactory.getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BaseTable> criteria = builder.createQuery(BaseTable.class);
        Root<BaseTable> root = criteria.from(BaseTable.class);

        List<Predicate> predicateList = new ArrayList<>();

        if(baseTableDateFilter.getSearchByRangeTypeEnum().equals(SearchByRangeTypeEnum.EQUALS_TO)){
            predicateList.add(builder.equal(root.get(baseTableDateFilter.getBaseTableNamesEnum().getDbName()),
                    baseTableDateFilter.getStartDate()));
        }else if(baseTableDateFilter.getSearchByRangeTypeEnum().equals(SearchByRangeTypeEnum.START_FROM)){
            predicateList.add(builder.greaterThanOrEqualTo(root.get(baseTableDateFilter.getBaseTableNamesEnum().getDbName()),
                    baseTableDateFilter.getStartDate()));
        }

        if(baseTableDateFilter.getEndDate() != null){
            predicateList.add(builder.lessThanOrEqualTo(root.get(baseTableDateFilter.getBaseTableNamesEnum().getDbName()),
                    baseTableDateFilter.getEndDate()));
        }

        if(baseTableDateFilter.getManager() != null){
            if(baseTableDateFilter.getManager().getId() == null){
                predicateList.add(builder.isNull(root.get(BaseTableNamesEnum.MANAGER.getDbName())));
            }else if(baseTableDateFilter.getManager().getId() != 0) {
                predicateList.add(builder.equal(root.get(BaseTableNamesEnum.MANAGER.getDbName()),
                        baseTableDateFilter.getManager()));
            }
        }
        if(baseTableDateFilter.getStatusOfDeal() != null){
            if(baseTableDateFilter.getStatusOfDeal().getId() == null ){
                predicateList.add(builder.isNull(root.get(BaseTableNamesEnum.STATUS_OF_DEAL.getDbName())));
            } else if (baseTableDateFilter.getStatusOfDeal().getId() != 0 ){
                predicateList.add(builder.equal(root.get(BaseTableNamesEnum.STATUS_OF_DEAL.getDbName()),
                        baseTableDateFilter.getStatusOfDeal()));
            }
        }
        if(baseTableDateFilter.getIsUnderControl() != null){
            predicateList.add(builder.equal(root.get(BaseTableNamesEnum.IS_UNDER_CONTROL.getDbName()),
                    baseTableDateFilter.getIsUnderControl()));
        }
        if(baseTableDateFilter.getBank() != null && !baseTableDateFilter.getBank().isEmpty()){
            predicateList.add(builder.equal(root.get(BaseTableNamesEnum.BANK.getDbName()), baseTableDateFilter.getBank()));
        }
        if(baseTableDateFilter.getStatusOfCall() != null){
            if(baseTableDateFilter.getStatusOfCall().getId() == null){
                predicateList.add(builder.isNull(root.get(BaseTableNamesEnum.STATUS_OF_CALL.getDbName())));
            } else if(baseTableDateFilter.getStatusOfCall().getId() != 0 ){
                predicateList.add(builder.equal(root.get(BaseTableNamesEnum.STATUS_OF_CALL.getDbName()),
                        baseTableDateFilter.getStatusOfCall()));
            }
        }

        criteria.select(root).where(predicateList.toArray(new Predicate[]{}));
        List<BaseTable> baseTableList = session.createQuery( criteria ).getResultList();
        return baseTableList;
    }

    @Override
    public List<String> getAllBanksList() {
        LOGGER.debug("Getting all Banks list");
        Session session = sessionFactory.getCurrentSession();
        List<String> bankList = session.createQuery("select distinct bank FROM BaseTable order by bank").list();
        LOGGER.debug("Got bank list: " + bankList);
        return bankList;
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
