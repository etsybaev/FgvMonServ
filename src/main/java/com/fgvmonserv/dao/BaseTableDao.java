package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
public interface BaseTableDao {

    public void addBaseTableRecord();
    public List<BaseTable> getAllRecordsList();


}
