package com.jerry.myproject.server.impl;

import com.jerry.myproject.server.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Jerry
 * @date 30/03/2020 00:12
 * @desc
 */
@Service
public class UserService2 implements UserService {

    @Override
    public Integer countUser() {
        return 2;
    }
}
