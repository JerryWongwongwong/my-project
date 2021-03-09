package com.jerry.myproject.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author Jerry
 * @Description 布隆过滤器
 * @createTime 2021年03月01日 16:45:00
 */

public class BloomFilterDemo {

    public static void main(String[] args) {
        int total = 1000000; // 总数量

//        在 BloomFilter 内部，误判率 fpp 的默认值是 0.03
//        BloomFilter<CharSequence> bf =
//                BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);

        //提高匹配精度
        BloomFilter<CharSequence> bf = BloomFilter.create(
                Funnels.stringFunnel(Charsets.UTF_8), total, 0.0002);



        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);
    }







}
