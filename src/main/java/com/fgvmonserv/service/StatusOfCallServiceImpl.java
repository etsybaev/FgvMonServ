package com.fgvmonserv.service;

import com.fgvmonserv.dao.StatusOfCallDao;
import com.fgvmonserv.model.StatusOfCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgeniit on 15.06.17.
 */

@Service
public class StatusOfCallServiceImpl implements StatusOfCallService {

    StatusOfCallDao statusOfCallDao;


    public StatusOfCallServiceImpl setStatusOfCallDao(StatusOfCallDao statusOfCallDao) {
        this.statusOfCallDao = statusOfCallDao;
        return this;
    }

    @Override
    @Transactional
    public void addStatusOfCall(StatusOfCall statusOfCall) {
        statusOfCallDao.addStatusOfCall(statusOfCall);
    }

    @Override
    @Transactional
    public void updateStatusOfCall(StatusOfCall statusOfCall) {
        statusOfCallDao.updateStatusOfCall(statusOfCall);
    }

    @Override
    @Transactional
    public void deleteStatusOfCall(int id) {
        statusOfCallDao.deleteStatusOfCall(id);
    }

    @Override
    @Transactional
    public StatusOfCall getCallStatusById(int id) {
        return this.statusOfCallDao.getCallStatusById(id);
    }

    @Override
    @Transactional
    public List<StatusOfCall> getAllStatusesList() {
        return this.statusOfCallDao.getAllStatusesList();
    }
}
