package com.jerry.myproject.server.impl;

import com.jerry.myproject.server.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jerry
 * @date 30/03/2020 00:12
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer countUser() {
        return 1;
    }


    @Async
    public void longtime() {
        System.out.println("我在执行一项耗时任务");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成");

    }


    public int[] twoSum(int[] nums, int target) {

//        int nums[] = {2, 7, 11, 15};
//        int target = 9;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if ((i != j) && (a + num == target)) {
                    System.out.println("i=" + i);
                    System.out.println("j=" + j);
                    int res[] = {i, j};
                    return res;
                }
            }
        }
        int c[] = {};
        return c;
    }


    public List addTwoNumbers(List l1, List l2) {

        String a = "";

        for (Object l : l1) {
            a+=l;
        }

        String  b ="";

        for (Object l : l2) {
            b+=l;
        }

        Integer integer = Integer.valueOf(a);
        Integer integer1 = Integer.valueOf(b);


        Integer i = integer + integer1;

        String s = i.toString();
        int length = s.length();

        char[] chars = s.toCharArray();

        String[] ad = {};
        for (char aChar : chars) {

        }


        return null;
    }
}
