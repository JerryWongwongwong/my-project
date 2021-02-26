package com.jerry.myproject.controller.singleton;

/**
 * @author jerry
 */
public class Holder {

    private Holder(){}

    public static Holder getInstance(){
        return Innerclass.holder;
    }
    /**
     * 在一个类里面在创建一个静态类
     */
    public static class Innerclass{

        private static Holder holder = new Holder();
    }



}
