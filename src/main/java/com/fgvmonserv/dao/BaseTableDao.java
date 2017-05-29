package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
public interface BaseTableDao {

    public void addBaseTableRecord(BaseTable baseTable);
    public void addBaseTableRecordsList(List<BaseTable> baseTablesList);
    public List<BaseTable> getAllRecordsList();


}
