package com.jerry.myproject.test;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年02月26日 15:03:00
 */
public class Test2 {

//    public static void main(String[] args) {
//
//        getCpu();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
//        ExecutorService executorService2 = Executors.newCachedThreadPool();
//
////        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
//
//
//
//        new ThreadPoolExecutor(2,
//                5,
//                2,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//        try {
//            for (int i = 0; i < 100; i++) {
//                executorService2.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + "正在执行");
//                });
//            }
//        } finally {
//            executorService.shutdown();
//            executorService1.shutdown();
//            executorService2.shutdown();
//        }


//    }


    public static void getCpu() {

        //获取cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
    }


}
