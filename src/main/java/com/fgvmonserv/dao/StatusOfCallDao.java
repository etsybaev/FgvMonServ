package com.fgvmonserv.dao;

import com.fgvmonserv.model.StatusOfCall;

import java.util.List;

/**
 * Created by ievgeniit on 15.06.17.
 */
public interface StatusOfCallDao {

    public void addStatusOfCall(StatusOfCall statusOfCall);
    public void updateStatusOfCall(StatusOfCall statusOfCall);
    public void deleteStatusOfCall(int id);
    public StatusOfCall getCallStatusById(int id);
    public List<StatusOfCall> getAllStatusesList();
}
