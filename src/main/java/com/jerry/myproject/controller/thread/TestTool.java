package com.jerry.myproject.controller.thread;

import com.jerry.myproject.annotation.JianCha;

import java.lang.reflect.Method;

/**
 * @author Jerry
 * @date 16/09/2020 14:19
 * @desc
 */
public class TestTool {

    public static void main(String[] args) {

        NoBug testObj = new NoBug();
        Class clazz = testObj.getClass();
        Method[] method = clazz.getDeclaredMethods();
        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errorNum = 0;
        for (Method m : method) {
            // 只有被 @Jiecha 标注过的方法才进行测试
            if (m.isAnnotationPresent(JianCha.class)) {
                try {
                    m.setAccessible(true);
                    m.invoke(testObj, null);
                } catch (Exception e) {

                    errorNum++;
                    log.append(m.getName());
                    log.append("存在错误:");
                    log.append("\n\r  原因");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append("有");
        log.append(errorNum);
        log.append("个错误。");
        // 生成测试报告
        System.out.println(log.toString());
    }

}
