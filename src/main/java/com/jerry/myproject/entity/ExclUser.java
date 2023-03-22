package com.jerry.myproject.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/11/15 22:01
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class ExclUser {

//    public static void main(String[] args) {
//        String CANCEL_INBOUND = "/api-json/CancelASN.aspx?CustomerID=%s&Key=%s";
//        String cancelUrl = String.format(CANCEL_INBOUND, "1212","3434");
//        System.out.println(cancelUrl);
//    }


    public static void main(String[] args) {
//
        String otherCode = "";
        String s = StringUtils.isEmpty(otherCode) ? "goods.getSku()" : otherCode;
        System.out.println("====" + s);

//        String str = "love234csdn3423java";
//        String str = "ET+724825#1700000+%";
//        String regEx = "[^0-9]";
//        Matcher m = Pattern.compile(regEx).matcher(str);
//        String result = m.replaceAll("").trim();
//        result = result.substring(0, 11);
//
//        System.out.println(result);
//
//        String a = "A";
//        if (!Objects.equals("F", a) && !Objects.equals("E", a)) {
//            System.out.println("===");
//        }
//
//        System.out.println("123");

    }


    public void addStock() {

        /**
         *  查询sku信息
         *  查询仓库信息
         *
         *
         *  加锁（batchNo）
         *
         *
         *  插入处理库存详情  Map<goods,List<库存详情（包含新增的数量）>>
         *      for（）{
         *          Sum(新增数量)
         *      }
         *
         *  本批次sku需要新增的数据
         *  插入/更新库存信息（+=新增总量）by goodsId
         *  插入流水
         *
         *
         */


    }


}
