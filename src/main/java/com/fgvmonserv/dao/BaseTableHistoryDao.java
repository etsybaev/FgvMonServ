package com.fgvmonserv.dao;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import com.fgvmonserv.model.BaseTableHistory;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
public interface BaseTableHistoryDao {

    public void addBaseTableRecord(BaseTableHistory baseTableHistory);
    public void addBaseTableHistoryRecord(List<BaseTableHistory> baseTableHistoryList);
    public List<BaseTableHistory> getBaseTableHistoryListByBaseTableId(int baseTableRecordId);
    public void deleteAllHistoryRecordsForBaseTableId(int baseTableIdCleanHistoryFor);

}
