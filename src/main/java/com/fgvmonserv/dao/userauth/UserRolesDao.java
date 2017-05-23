package com.fgvmonserv.dao.userauth;

import com.fgvmonserv.UserRolesEnum;
import com.fgvmonserv.model.userauth.UserRoles;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */
public interface UserRolesDao {
    public int getUserRolesId(UserRolesEnum userRolesEnum);
    public List<UserRoles> getAllUserRoles();
}
