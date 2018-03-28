package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
public interface BaseTableDao {

    public BaseTable addBaseTableRecord(BaseTable baseTable);
    public List<BaseTable> addBaseTableRecord(List<BaseTable> baseTableList);
    public void updateBaseTableRecord(BaseTable baseTable);
    public BaseTable getRecordById(int id);
    public void removeBaseTableRecord(int id);
    public List<BaseTable> getAllRecordsList();
    public List<BaseTable> getAllRecordsList(String searchForText);
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter);
    public List<BaseTable> getAllRecordsListByReminderDate(LocalDate reminderDate, boolean isReminderEnabled, int managerId);
    public List<BaseTable> getAllRecordsListWithMissedReminders(LocalDate reminderDate, boolean isReminderEnabled);
    public List<String> getAllBanksList();

}
