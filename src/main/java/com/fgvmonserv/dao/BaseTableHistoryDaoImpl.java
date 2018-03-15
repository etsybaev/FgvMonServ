package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTableHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BaseTableHistoryDaoImpl implements BaseTableHistoryDao {

    private SessionFactory sessionFactory;
    private final Logger LOGGER = LogManager.getLogger(this);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addBaseTableRecord(BaseTableHistory baseTableHistory) {
        LOGGER.debug("Adding BaseTableHistory record " + baseTableHistory);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(baseTableHistory);
        LOGGER.debug("Record has been added");
    }

    @Override
    public List<BaseTableHistory> addBaseTableHistoryRecord(List<BaseTableHistory> baseTableHistoryList) {
        LOGGER.debug("Adding BaseTable History records list " + baseTableHistoryList);
        Session session = this.sessionFactory.getCurrentSession();
//        Transaction tx = session.getTransaction();
        baseTableHistoryList.forEach(baseTable -> session.save(baseTable));

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
        return baseTableHistoryList; // after adding records to db we get the same list but with added id's
    }


    @Override
    public List<BaseTableHistory> getBaseTableHistoryListByBaseTableId(int baseTableRecordId) {
        LOGGER.debug("Getting BaseTableHistory list BaseTable's id " + baseTableRecordId);
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from BaseTableHistory where baseTableRecordId = :baseTableRecordId";
        return  (List<BaseTableHistory>) session.createQuery(hql)
                .setParameter("baseTableRecordId", baseTableRecordId)
                .list();
    }

    @Override
    public void deleteAllHistoryRecordsForBaseTableId(int baseTableIdCleanHistoryFor) {
        LOGGER.debug("Going to remove all BaseTable's History for BaseTable's id " + baseTableIdCleanHistoryFor);
        Session session = this.sessionFactory.getCurrentSession();
        getBaseTableHistoryListByBaseTableId(baseTableIdCleanHistoryFor).forEach(session::delete);
    }
}
