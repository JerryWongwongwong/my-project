package com.jerry.myproject.entity;

import lombok.Data;

/**
 * CopyRight : <company domain>
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2021-10-18 14:05
 *
 * @author : Jerry
 * @version : 0.2.0
 * @since : 0.2.0
 */
@Data
public class Order {

    private Double originalPrice;//订单原始价格，即优惠前价格
    private Double realPrice;//订单真实价格，即优惠后价格

    public String toString() {
        return "Order{" +
                "originalPrice=" + originalPrice +
                ", realPrice=" + realPrice +
                '}';
    }
}
