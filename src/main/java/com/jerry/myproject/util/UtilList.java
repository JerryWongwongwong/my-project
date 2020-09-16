package com.jerry.myproject.util;

/**
 * @author Jerry
 * @date 02/09/2020 09:53
 * @desc
 */
public class UtilList {


    public static void main(String[] args) {

        reverseInputString("wangyajun");

        removeCharFromString("wangyajun", 'w');
    }


    /**
     * 反转字符串
     * 使用StringBuilder或者StringBuffer的reverse()方法
     */
    private static void reverseInputString(String input) {

        StringBuilder sb = new StringBuilder(input);
        String result = sb.reverse().toString();
        System.out.println(result);
    }


    /**
     * 删除指定的字符
     *
     * @param input
     * @param c
     */
    private static void removeCharFromString(String input, char c) {
        String result = input.replaceAll(String.valueOf(c), "");
        System.out.println(result);
    }

    /**
     * 不使用第三个参数交换两个对象
     *
     * @param s1
     * @param s2
     */
    private static void swapTwoStrings(String s1, String s2) {
        s1 = s1.concat(s2);
        s2 = s1.substring(0, s1.length() - s2.length());
        s1 = s1.substring(s2.length());

        System.out.println(s1);
        System.out.println(s2);
    }


}
