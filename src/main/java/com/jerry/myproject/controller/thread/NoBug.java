package com.jerry.myproject.controller.thread;

import com.jerry.myproject.annotation.JianCha;

/**
 * @author Jerry
 * @date 16/09/2020 14:18
 * @desc
 */
public class NoBug {


    @JianCha
    public void suanShu() {
        System.out.println("1234567890");
    }

    @JianCha
    public void jiafa() {
        System.out.println("1+1=" + 1 + 1);
    }

    @JianCha
    public void jianfa() {
        System.out.println("1-1=" + (1 - 1));
    }

    @JianCha
    public void chengfa() {
        System.out.println("3 x 5=" + 3 * 5);
    }

    @JianCha
    public void chufa() {
        System.out.println("6 / 0=" + 6 / 0);
    }

    public void ziwojieshao() {
        System.out.println("我写的程序没有 bug!");
    }
}
