package com.fgvmonserv.service;

import com.fgvmonserv.dao.BaseTableDao;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */


@Service
public class BaseTableServiceImpl implements BaseTableService {

    BaseTableDao baseTableDao;

    public BaseTableServiceImpl setBaseTableDao(BaseTableDao baseTableDao) {
        this.baseTableDao = baseTableDao;
        return this;
    }


    @Override
    @Transactional
    public BaseTable addBaseTableRecord(BaseTable baseTable) {
        return this.baseTableDao.addBaseTableRecord(baseTable);
    }

    @Override
    @Transactional
    public List<BaseTable> addBaseTableRecord(List<BaseTable> baseTableList) {
        return this.baseTableDao.addBaseTableRecord(baseTableList);
    }


    @Override
    @Transactional
    public void updateBaseTableRecord(BaseTable baseTablesList) {
        this.baseTableDao.updateBaseTableRecord(baseTablesList);
    }

    @Override
    @Transactional
    public BaseTable getRecordById(int id) {
        return this.baseTableDao.getRecordById(id);
    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsList() {
        return this.baseTableDao.getAllRecordsList();
    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsList(String searchForText) {
        return this.baseTableDao.getAllRecordsList(searchForText);
    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter) {
        return this.baseTableDao.getAllRecordsList(baseTableDateFilter);
    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsListByReminderDate(LocalDate reminderDate, boolean isReminderEnabled, int managerId) {
        return this.baseTableDao.getAllRecordsListByReminderDate(reminderDate,isReminderEnabled, managerId);
    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsListWithMissedReminders(LocalDate reminderDate, boolean isReminderEnabled) {
        return this.baseTableDao.getAllRecordsListWithMissedReminders(reminderDate, isReminderEnabled);
    }

    @Override
    @Transactional
    public List<String> getAllBanksList() {
        return this.baseTableDao.getAllBanksList();
    }

    @Override
    @Transactional
    public void removeBaseTableRecord(int id) {
        this.baseTableDao.removeBaseTableRecord(id);
    }
}
