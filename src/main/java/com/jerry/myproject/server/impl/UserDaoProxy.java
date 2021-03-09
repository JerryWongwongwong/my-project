package com.jerry.myproject.server.impl;

import com.jerry.myproject.server.IUserDao;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月04日 16:05:00
 */
@Service
public class UserDaoProxy implements IUserDao {

//    private IUserDao userDao;
//
//    public UserDaoProxy(IUserDao iUserDao) {
//        this.userDao = iUserDao;
//    }

    @Override
    public void save() {

//        userDao.save();
        System.out.println("UserDaoProxy's save!");
    }
}
