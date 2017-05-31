package com.fgvmonserv.service;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.dao.BaseTableDao;
import com.fgvmonserv.model.BaseTable;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ievgeniit on 29.05.17.
 */


@Service
public class BaseTableServiceImpl implements BaseTableService {

    public BaseTableServiceImpl setBaseTableDao(BaseTableDao baseTableDao) {
        this.baseTableDao = baseTableDao;
        return this;
    }

    BaseTableDao baseTableDao;


    @Override
    @Transactional
    public void addBaseTableRecord(BaseTable baseTable) {
        this.baseTableDao.addBaseTableRecord(baseTable);

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
    public List<BaseTable> getShortBaseTableInfoFromCsvFile(CommonsMultipartFile file) {
        List<BaseTable> resultList = new ArrayList<>();
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //http://opencsv.sourceforge.net/
            CSVReader reader = new CSVReader(new InputStreamReader(new ByteArrayInputStream(bytes)), ';');
            List<String[]> csvLines = reader.readAll();
            //As the first line of CSV document is column titles - need to start from second line, i.e. not from 0, but from 1
            for(int i = 1; i < csvLines.size(); i++){
                String[] csvLine = csvLines.get(i);
                BaseTable shortBaseTableFromCsvLine = BaseTable.getShortBaseTableFromCsvLine(csvLine);
                resultList.add(shortBaseTableFromCsvLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    @Transactional
    public void removeBaseTableRecord(int id) {
        this.baseTableDao.removeBaseTableRecord(id);
    }

    @Override
    public List<String[]> getPreparedListOfStringArrayToWriteToCsvFile(List<BaseTable> allRecordsList) {
        List<String[]> listOfStringArrayToWriteToCsvFile = new ArrayList<>();
        //Adding columns header names
        listOfStringArrayToWriteToCsvFile.add(getColumnNamesThatWillBeShownInexportedCsvFile());
        //Now need to prepare and add values
        allRecordsList.forEach(baseTable -> {
            listOfStringArrayToWriteToCsvFile.add(baseTable.getValuesAsStringArray());
        });

        return listOfStringArrayToWriteToCsvFile;
    }

    private String[] getColumnNamesThatWillBeShownInexportedCsvFile(){
        Field[] declaredFields = BaseTable.class.getDeclaredFields();
        String[] declaredFieldsAsString =  new String[declaredFields.length];
        //Get all declared variables in BaseTable class and find appropriate values in Enum.
        for(int i = 0; i < declaredFields.length; i++){
            declaredFieldsAsString[i] = BaseTableNamesEnum.getViewNameFromDbName(declaredFields[i].getName());
        }
        return declaredFieldsAsString;
    }
}
