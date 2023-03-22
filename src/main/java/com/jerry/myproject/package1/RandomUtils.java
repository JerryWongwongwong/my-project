//package com.jerry.myproject.package1;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * CopyRight (c)2018-2023 : cargogm.com
// * Project :  my-project
// * Comments : <对此类的描述，可以引用系统设计中的描述>
// * JDK version : JDK1.8
// * Create Date : 2023/03/06 21:13
// *
// * @author : Jerry
// * @version : 1.0
// * @since : 1.0
// */
//public class RandomUtils {
//
//
//    public static void main(String[] args) {
//        productRandom(10, 20);
//    }
//
//    public static void productRandom(int size, int boxcount) {
//
//        // 初始化一个index数组
//        int[] index = new int[size];
//
//        // 往index里面加入0-x 的数字
//        for (int i = 0; i < size; i++) index[i] = i;
//
//        Random r = new Random();
//        // 用来保存随机生成的不重复的10个数
//        int[] result = new int[boxcount];
//
//        //设置上限
//        int site = boxcount;
//
//        int id = 0;
//        for (int j = 0; j < site; j++) {
//            id = r.nextInt(size - 1);
////            System.out.println("+++++" + id);
//            System.out.println("===" + index[id]);
////            Console.WriteLine();
//            //在随机位置取出一个数，保存到结果数组
//            result[j] = index[id];
//
//            //最后一个数复制到当前位置
//            index[id] = index[size - 1];
//            //位置的上限减少一
//            //site--;
//        }
//    }
//
////    public static void main(String[] args) {
////        Random r = new Random();
////        for (int i =0; i < 10 ;i ++)
////        System.out.println("===" + r.nextInt(10));
////    }
//    public static List<Integer> Generate2(int size, int count) {
//        List<Integer> all = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        Random random = new Random();
//        if (count < size) {
//            for (int i = 0; i < size; i++) {
//                all.add(i);
//            }
//
//            for (int j = 0; j < count; j++) {
//                int index = random.nextInt( all.size() - 1);
//                result.add(all[index]);
//                all.removeAll(index);
//            }
//        } else {
//            for (int t = 0; t <= (count / size) + 1; t++) {
//                for (int i = 0; i < size; i++) {
//                    all.add(i);
//                }
//            }
//            for (int j = 0; j < count; j++) {
//                int index = random.nextInt(all.size() - 1);
//                result.add(all[index]);
//                all.removeAll(index);
//            }
//        }
//
//        return result;
//    }
//
////    public static int test(int size) {
////        int result = 0;
////        Random r = new Random();
////        result = r.Next(0, size - 1);
////
////        System.out.println(size + ":===>" + result);
//////        Console.WriteLine(size+":===>"+result);
////        return result;
////    }
//
//
//}
