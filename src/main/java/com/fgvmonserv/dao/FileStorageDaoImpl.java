package com.fgvmonserv.dao;

import com.fgvmonserv.model.FileStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;



/**
 * Created by ievgeniit on 22.06.17.
 */

@Repository
public class FileStorageDaoImpl implements FileStorageDao {

    private SessionFactory sessionFactory;
    private final Logger LOGGER = LogManager.getLogger(this);

    public FileStorageDaoImpl setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        return this;
    }


    @Override
    public FileStorage getFileStorageByUserId(int userId) {
        LOGGER.debug("Getting file storage with id=" + userId);
        Session session = sessionFactory.getCurrentSession();
        FileStorage fileStorage = (FileStorage) session.createQuery("from FileStorage where userId =:userId")
                .setParameter("userId", userId)
                .uniqueResult();
        return fileStorage;
    }


    @Override
    public void saveFileInStorage(int userId, byte[] file) {
        LOGGER.debug("Saving file to storage for user with id=" + userId);
        Session session = sessionFactory.getCurrentSession();
        FileStorage fileStorage = getFileStorageByUserId(userId);

        //If record exist for user - then will update it, otherwise will create new record
        if (fileStorage == null){
            session.persist(new FileStorage(userId, file));
        }else {
            session.update(fileStorage.setFile(file));
        }
    }
}
