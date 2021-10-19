package com.jerry.myproject.controller.thread;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    static Integer initNum = 100;

//    public static void main(String[] args) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse("2019-09-09 12:00:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        long time1 = date.getTime();
//        System.out.println(time1);
//
//        System.out.println(time1);
//
//    }


    /**
     * demo
     *
     * @return
     */
    @RequestMapping("sayHello")
    public String sayHello() {

        return "hello!";
    }


    /**
     * demo
     *
     * @return
     */
    @RequestMapping("getNum")
    public Integer getNum() {

        return initNum;
    }


//
//    @RequestMapping("cacheDemo")
//    public String cacheDemo() {
//
//        loadingCache.get();\
//    }


//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6,5, TimeUnit.SECONDS, );


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

}
