package com.fgvmonserv.service;

import com.fgvmonserv.dao.StatusOfDealDao;
import com.fgvmonserv.model.StatusOfDeal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ievgeniit on 13.06.17.
 */

@Service
public class StatusOfDealServiceImpl implements StatusOfDealService {

    private StatusOfDealDao statusOfDealDao;

    public StatusOfDealServiceImpl setStatusOfDealDao(StatusOfDealDao statusOfDealDao) {
        this.statusOfDealDao = statusOfDealDao;
        return this;
    }

    @Override
    @Transactional
    public String getStatusById(int id) {
        return this.statusOfDealDao.getStatusById(id);
    }

    @Override
    @Transactional
    public List<StatusOfDeal> getAllStatusList() {
        return this.statusOfDealDao.getAllStatusList();
    }
}
