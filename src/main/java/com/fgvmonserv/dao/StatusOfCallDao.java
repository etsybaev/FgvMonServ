package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfCall;

import java.util.List;

/**
 * Created by ievgeniit on 15.06.17.
 */
public interface StatusOfCallDao {

    public StatusOfCall getCallStatusById(int id);
    public List<StatusOfCall> getAllStatusesList();
}
