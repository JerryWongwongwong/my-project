package com.jerry.myproject.util;

import cn.hutool.core.bean.BeanUtil;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

/**
 * CopyRight : 杭州大掌柜物流科技有限公司
 * Project :  zouwu-oms-order
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2021-10-27 11:01
 *
 * @author : Jerry
 * @version : 0.1.0
 * @since : 0.1.0
 */
public class test {


    public static void test1(Object obj){
        // 获取对象所有字段
        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(obj.getClass());
        // 循环字段进行trim后赋值
        Arrays.stream(propertyDescriptors);
    }

}
