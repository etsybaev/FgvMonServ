package com.fgvmonserv.service;

import com.fgvmonserv.model.FileStorage;


/**
 * Created by ievgeniit on 22.06.17.
 */
public interface FileStorageService {

    public FileStorage getFileStorageByUserId(int userId);
    public void saveFileInStorage(int userId, byte[] file);
}
