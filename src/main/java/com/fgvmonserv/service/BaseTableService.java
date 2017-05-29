package com.fgvmonserv.service;

import com.fgvmonserv.model.BaseTable;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */

public interface BaseTableService {

    public void addBaseTableRecord(BaseTable baseTable);
    public void addBaseTableRecordsList(List<BaseTable> baseTablesList);
    public List<BaseTable> getAllRecordsList();
    public List<BaseTable> getShortBaseTableInfoFromCsvFile(CommonsMultipartFile file);
    public List<String[]> getPreparedListOfStringArrayToWriteToCsvFile(List<BaseTable> allRecordsList);


}
