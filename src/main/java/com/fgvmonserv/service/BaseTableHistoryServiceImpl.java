package com.fgvmonserv.service;


import com.fgvmonserv.dao.BaseTableHistoryDao;
import com.fgvmonserv.model.BaseTableHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseTableHistoryServiceImpl implements BaseTableHistoryService {

    BaseTableHistoryDao baseTableHistoryDao;

    public BaseTableHistoryServiceImpl setBaseTableHistoryDao(BaseTableHistoryDao baseTableHistoryDao) {
        this.baseTableHistoryDao = baseTableHistoryDao;
        return this;
    }


    @Override
    @Transactional
    public void addBaseTableHistoryRecord(BaseTableHistory baseTableHistory) {
        this.baseTableHistoryDao.addBaseTableRecord(baseTableHistory);
    }

    @Override
    @Transactional
    public void addBaseTableHistoryRecord(List<BaseTableHistory> baseTableHistoryList) {
        this.baseTableHistoryDao.addBaseTableHistoryRecord(baseTableHistoryList);
    }

    @Override
    @Transactional
    public List<BaseTableHistory> getBaseTableHistoryListByBaseTableId(int baseTableRecordId) {
        return this.baseTableHistoryDao.getBaseTableHistoryListByBaseTableId(baseTableRecordId);
    }

    @Override
    @Transactional
    public void deleteAllHistoryRecordsForBaseTableId(int baseTableIdCleanHistoryFor) {
        this.baseTableHistoryDao.deleteAllHistoryRecordsForBaseTableId(baseTableIdCleanHistoryFor);
    }
}
