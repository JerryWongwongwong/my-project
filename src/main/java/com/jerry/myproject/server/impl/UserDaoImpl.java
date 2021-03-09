package com.jerry.myproject.server.impl;

import com.jerry.myproject.server.IUserDao;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月04日 16:03:00
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public void save() {
        System.out.println("user dao impl 's save!");
    }
}
