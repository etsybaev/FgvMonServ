package com.fgvmonserv.service;

import com.fgvmonserv.dao.BaseTableDao;
import com.fgvmonserv.model.BaseTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void addBaseTableRecord() {

    }

    @Override
    @Transactional
    public List<BaseTable> getAllRecordsList() {
        return this.baseTableDao.getAllRecordsList();
    }
}
