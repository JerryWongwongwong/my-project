package com.jerry.myproject.controller;

import com.jerry.myproject.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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




    public static void main(String[] args){

        System.out.println("a");
//        String a = "2020-09-10 08:01:11";

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date date = simpleDateFormat.parse(a);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }


}
