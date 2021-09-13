package com.jerry.myproject.controller.thread;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.jerry.myproject.dto.Student;
import com.jerry.myproject.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jerry
 * @date 30/03/2020 00:15
 * @desc
 */
@RestController
@RequestMapping("api/user")
public class UserController {


//    @Autowired
//    private UserService userService;


    /**
     * 统计用户数量 测试多实现
     *
     * @return
     */
    @RequestMapping("/countUser")
    public Integer countUser() {

//        Integer num = userService.countUser();
//        System.out.println(num);
//        return num;
        return null;
    }




}
