package com.fgvmonserv.service;

import com.fgvmonserv.model.CalculatorPageTable;

/**
 * Created by ievgeniit on 26.06.17.
 */
public interface CalculatorPageTableService {

    public CalculatorPageTable getCalculatorPageTableById(int id);
    public void createRecord (CalculatorPageTable calculatorPageTable);
    public void updateRecord (CalculatorPageTable calculatorPageTable);
}
