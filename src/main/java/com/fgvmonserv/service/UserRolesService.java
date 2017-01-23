package com.fgvmonserv.service;

import com.fgvmonserv.UserRolesEnum;
import com.fgvmonserv.model.UserRoles;

import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 10.01.2017.
 */
public interface UserRolesService {
    public int getUserRolesId(UserRolesEnum userRolesEnum);
    public List<UserRoles> getAllUserRoles();
}
