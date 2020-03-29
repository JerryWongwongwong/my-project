package com.jerry.myproject.controller;

import com.jerry.myproject.server.impl.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @date 30/03/2020 00:15
 * @desc
 */
@RestController
@RequestMapping("api/user")
public class UserController {


    @Autowired
    private UserService1 userService;


    @RequestMapping("/countUser")
    public Integer countUser() {

        Integer num = userService.countUser();
        System.out.println(num);
        return num;
    }


}
