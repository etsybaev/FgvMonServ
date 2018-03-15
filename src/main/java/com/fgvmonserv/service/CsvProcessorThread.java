package com.fgvmonserv.service;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableHistory;
import com.fgvmonserv.model.userauth.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class CsvProcessorThread implements Callable<String> {
    private User currentSessionsUser;
    private List<BaseTable> shortBaseTableInfoFromCsvFile;
    private BaseTableService baseTableService;
    private BaseTableHistoryService baseTableHistoryService;


    public CsvProcessorThread(User currentSessionsUser, List<BaseTable> shortBaseTableInfoFromCsvFile,
                              BaseTableService baseTableService, BaseTableHistoryService baseTableHistoryService) {
        this.currentSessionsUser = currentSessionsUser;
        this.shortBaseTableInfoFromCsvFile = shortBaseTableInfoFromCsvFile;
        this.baseTableService = baseTableService;
        this.baseTableHistoryService = baseTableHistoryService;
    }

    @Override
    public String call() throws Exception {
        try{
            List<BaseTable> baseTablesAddedRecordsWithIds = baseTableService.addBaseTableRecord(shortBaseTableInfoFromCsvFile);
            //Now need to add these updated records to DB
            List<BaseTableHistory> baseTableHistoryList = new ArrayList<>();
            baseTablesAddedRecordsWithIds.forEach(baseTable -> {
                BaseTableHistory baseTableHistory = new BaseTableHistory(baseTable);
                baseTableHistory.setManagerUpdatedBy(currentSessionsUser);
                baseTableHistoryList.add(baseTableHistory);
            });
            //final list contains added records in fact but with assigned ids
            List<BaseTableHistory> baseTableHistoryRecordsWihIds = baseTableHistoryService.addBaseTableHistoryRecord(baseTableHistoryList);

            if(baseTablesAddedRecordsWithIds.size() != baseTableHistoryRecordsWihIds.size()){
                return "Error occurred while importing. " + baseTablesAddedRecordsWithIds.size() +
                        " records have been added to BaseTable table, but " + baseTableHistoryRecordsWihIds.size() +
                        " records have been added to BaseTableHistory table";
            }

            return baseTableHistoryRecordsWihIds.size() + " records have been added to database";
        }catch (Exception e){
            return "Error occurred while importing CVS, details: \n" + e.getMessage();
        }
    }
}
