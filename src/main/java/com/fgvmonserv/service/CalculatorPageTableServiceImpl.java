package com.fgvmonserv.service;

import com.fgvmonserv.dao.CalculatorPageTableDao;
import com.fgvmonserv.model.CalculatorPageTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ievgeniit on 26.06.17.
 */

@Service
public class CalculatorPageTableServiceImpl implements CalculatorPageTableService {

    CalculatorPageTableDao calculatorPageTableDao;

    public CalculatorPageTableServiceImpl setCalculatorPageTableDao(CalculatorPageTableDao calculatorPageTableDao) {
        this.calculatorPageTableDao = calculatorPageTableDao;
        return this;
    }


    @Override
    @Transactional
    public CalculatorPageTable getCalculatorPageTableById(int id) {
        return calculatorPageTableDao.getCalculatorPageTableById(id);
    }

    @Override
    @Transactional
    public void createRecord(CalculatorPageTable calculatorPageTable) {
        this.calculatorPageTableDao.createRecord(calculatorPageTable);
    }

    @Override
    @Transactional
    public void updateRecord(CalculatorPageTable calculatorPageTable) {
        this.calculatorPageTableDao.updateRecord(calculatorPageTable);
    }

}
