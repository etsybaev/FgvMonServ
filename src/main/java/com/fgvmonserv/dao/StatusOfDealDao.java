package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfDeal;

import java.util.List;

/**
 * Created by ievgeniit on 13.06.17.
 */
public interface StatusOfDealDao {

    public void addStatusOfDeal(StatusOfDeal statusOfDeal);
    public void updateStatusOfDeal(StatusOfDeal statusOfDeal);
    public void deleteStatusOfDeal(int id);
    public StatusOfDeal getStatusById(int id);
    public List<StatusOfDeal> getAllStatusList();
}
