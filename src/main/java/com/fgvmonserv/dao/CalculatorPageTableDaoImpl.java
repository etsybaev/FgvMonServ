package com.fgvmonserv.dao;

import com.fgvmonserv.model.CalculatorPageTable;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by ievgeniit on 26.06.17.
 */

@Repository
public class CalculatorPageTableDaoImpl implements CalculatorPageTableDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public CalculatorPageTable getCalculatorPageTableById(int id) {
        Session session = sessionFactory.getCurrentSession();
        CalculatorPageTable calculatorPageTable;
        try{
            calculatorPageTable = session.load(CalculatorPageTable.class, id);
            System.out.println("Found CalculatorPageTable record with id=" + id + " is:" + calculatorPageTable);
        } catch (ObjectNotFoundException e){
            System.out.println("Calculator record doesn't exist. Will create new one for id=" + id);
            calculatorPageTable = new CalculatorPageTable(id);
            createRecord(calculatorPageTable);
        }
        return calculatorPageTable;
    }


    @Override
    public void createRecord(CalculatorPageTable calculatorPageTable) {
        System.out.println("Adding record " + calculatorPageTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(calculatorPageTable);
        System.out.println("Record " + calculatorPageTable + " has been added");
    }

    @Override
    public void updateRecord(CalculatorPageTable calculatorPageTable) {
        System.out.println("Updating record " + calculatorPageTable);
        Session session = this.sessionFactory.getCurrentSession();
        session.update(calculatorPageTable);
        System.out.println("Record " + calculatorPageTable + " has been updated");
    }
}
