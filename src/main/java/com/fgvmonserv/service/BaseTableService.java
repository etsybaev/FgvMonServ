package com.fgvmonserv.service;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableDateFilter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */

public interface BaseTableService {

    public void addBaseTableRecord(BaseTable baseTable);
    public void updateBaseTableRecord(BaseTable baseTablesList);
    public BaseTable getRecordById(int id);
    public void removeBaseTableRecord(int id);
    public List<BaseTable> getAllRecordsList();
    public List<BaseTable> getAllRecordsList(BaseTableDateFilter baseTableDateFilter);
    public List<String> getAllBanksList();

}
