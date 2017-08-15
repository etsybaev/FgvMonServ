package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;

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
//    public List<BaseTable> getAllRecordsList(String searchForText);
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter);
    public List<String> getAllBanksList();

}
