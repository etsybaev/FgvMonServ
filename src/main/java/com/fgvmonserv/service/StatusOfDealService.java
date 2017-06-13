package com.fgvmonserv.service;

import com.fgvmonserv.model.StatusOfDeal;

import java.util.List;

/**
 * Created by ievgeniit on 13.06.17.
 */
public interface StatusOfDealService {

    public String getStatusById(int id);
    public List<StatusOfDeal> getAllStatusList();


}
