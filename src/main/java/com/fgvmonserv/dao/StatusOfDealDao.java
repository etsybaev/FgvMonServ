package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfDeal;

import java.util.List;

/**
 * Created by ievgeniit on 13.06.17.
 */
public interface StatusOfDealDao {

    public String getStatusById(int id);
    public List<StatusOfDeal> getAllStatusList();
}
