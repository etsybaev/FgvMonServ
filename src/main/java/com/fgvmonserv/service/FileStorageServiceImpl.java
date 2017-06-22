package com.fgvmonserv.service;

import com.fgvmonserv.dao.FileStorageDao;
import com.fgvmonserv.model.FileStorage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ievgeniit on 22.06.17.
 */

@Service
public class FileStorageServiceImpl implements FileStorageService {


    FileStorageDao fileStorageDao;

    public FileStorageServiceImpl setFileStorageDao(FileStorageDao fileStorageDao) {
        this.fileStorageDao = fileStorageDao;
        return this;
    }

    @Override
    @Transactional
    public FileStorage getFileStorageByUserId(int userId) {
        return fileStorageDao.getFileStorageByUserId(userId);
    }

    @Override
    @Transactional
    public void saveFileInStorage(int userId, byte[] file) {
        fileStorageDao.saveFileInStorage(userId, file);
    }
}
