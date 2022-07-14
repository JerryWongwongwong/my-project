package com.jerry.myproject.controller.thread;


import org.springframework.web.bind.annotation.PostMapping;
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


    /**
     * 统计用户数量 测试多实现
     *
     * @return
     */
    @PostMapping("/countUser")
    public Integer countUser() {

        return 10000;
    }


}
