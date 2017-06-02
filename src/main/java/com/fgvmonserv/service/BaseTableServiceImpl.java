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
    @Transactional
    public void removeBaseTableRecord(int id) {
        this.baseTableDao.removeBaseTableRecord(id);
    }
}
