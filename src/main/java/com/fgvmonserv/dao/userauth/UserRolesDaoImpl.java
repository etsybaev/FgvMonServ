package com.fgvmonserv.dao.userauth;

import com.fgvmonserv.UserRolesEnum;
import com.fgvmonserv.model.userauth.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */

@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    SessionFactory sessionFactory;
    private final Logger LOGGER = LogManager.getLogger(this);
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int getUserRolesId(UserRolesEnum userRolesEnum) {
        Session session = this.sessionFactory.getCurrentSession();
        String hql = "from UserRoles where role = :role";
        Query query = session.createQuery(hql);
        Query userId = query.setParameter("role", userRolesEnum.getRole());
        List<UserRoles> list = userId.list();

        if(list != null && !list.isEmpty()){
            return list.get(0).getId();
        }else {
            LOGGER.debug("Can't find id for access point " + userRolesEnum.getRole());
            return -1;
        }

    }

    @Override
    public List<UserRoles> getAllUserRoles() {
        LOGGER.debug("Getting UserRolesList");
        Session session = this.sessionFactory.getCurrentSession();
        List<UserRoles> UserRolesList = session.createQuery("from UserRoles ").list();

        for(UserRoles accessPoint : UserRolesList){
            LOGGER.debug("Got accessPoint " + accessPoint);
        }
        return UserRolesList;
    }
}
