package com.fgvmonserv.service;

import com.fgvmonserv.model.BaseTableHistory;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */
public interface BaseTableHistoryService {

    public void addBaseTableHistoryRecord(BaseTableHistory baseTableHistory);
    public List<BaseTableHistory> addBaseTableHistoryRecord(List<BaseTableHistory> baseTableHistoryList);
    public List<BaseTableHistory> getBaseTableHistoryListByBaseTableId(int baseTableRecordId);
    public void deleteAllHistoryRecordsForBaseTableId(int baseTableIdCleanHistoryFor);

}
