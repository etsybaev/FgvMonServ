package com.fgvmonserv.dao;

import com.fgvmonserv.model.FileStorage;



/**
 * Created by ievgeniit on 22.06.17.
 */
public interface FileStorageDao {

    public FileStorage getFileStorageByUserId(int userId);
    public void saveFileInStorage(int userId, byte[] file);
}
