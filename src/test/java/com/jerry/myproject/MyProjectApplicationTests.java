package com.jerry.myproject;


import com.jerry.myproject.entity.Order;
import com.jerry.myproject.server.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * springboot单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MyProjectApplicationTests {


    @Autowired
    private UserServiceImpl userService;

    @Test
    public void test() {
        int a[] = {2, 7, 11, 15};
        int b = 9;
        int[] ints = userService.twoSum(a, b);
        System.out.println(ints);
    }


    @Test
    void contextLoads() throws IOException, ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("===task start===");
                Thread.sleep(5000);
                System.out.println("===task finish===");
                return 3;
            }
        });

        Integer result = future.get();
        System.out.println("result:" + result);
        System.out.println("main函数执行结束");

        System.in.read();


    }


    @Test
    void testAsync() throws InterruptedException {
        System.out.println("begin");
        try {
            getAa();
            System.out.println("aaa");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("end");
        }


    }

    private void getAa() {
        try {
            int i = 1 / 0;
        } catch (Throwable e) {

            throw e;
        }
    }

    @Async
    public String asyncMethod() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("----");
        return "CBD";
    }


    @Test
    public void test3() throws Exception {
        System.out.println("main函数开始执行");
        userService.longtime();
        System.out.println("main函数执行结束");
    }


    private static String AWS_ACCESS_KEY_ID = "XXXX";//替换成自己的
    private static String AWS_SECRET_ACCESS_KEY = "XXX";//替换成自己的


    @Test
    public void testAWS() {

    }


    //    public AWSCognitoIdentityProvider getAmazonCognitoIdentityClient() {
//        ClasspathPropertiesFileCredentialsProvider propertiesFileCredentialsProvider =
//                new ClasspathPropertiesFileCredentialsProvider();
//
//        return AWSCognitoIdentityProviderClientBuilder.standard()
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIARY66HDFOQ6UEXTMN", "L1Mb11q9Nri3UnITrCi512ebXwXcUy6cY5FiUIb0")))
//                .withRegion("us-east-2")
//                .build();
//
//    }
//
//    @Test
//    public void testAwsCreateUser() {
//
//        AWSCognitoIdentityProvider cognitoClient = getAmazonCognitoIdentityClient();
//
//        AdminCreateUserRequest cognitoRequest = new AdminCreateUserRequest()
//                .withUserPoolId("us-east-2_XEW6z7jV5")
//                .withUsername("AWS-User")
//                .withUserAttributes(
//
//                        new AttributeType()
//                                .withName("email")
//                                .withValue("jerrywongwongwong@gmail.com"),
//                        new AttributeType()
//                                .withName("name")
//                                .withValue("jerry"),
//                        new AttributeType()
//                                .withName("family_name")
//                                .withValue("wong"),
////                        new AttributeType()
////                                .withName("phone_number")
////                                .withValue("+86-17621732503"),
////                        new AttributeType()
////                                .withName("custom:companyName")
////                                .withValue("shenzhen"),
////                        new AttributeType()
////                                .withName("custom:companyPosition")
////                                .withValue("boss"),
//                        new AttributeType()
//                                .withName("email_verified")
//                                .withValue("true"))
//                .withTemporaryPassword("Qwer1234")
//                .withMessageAction("SUPPRESS")
//                .withDesiredDeliveryMediums(DeliveryMediumType.EMAIL)
//                .withForceAliasCreation(Boolean.FALSE);
//
//        AdminCreateUserResult createUserResult = cognitoClient.adminCreateUser(cognitoRequest);
//        UserType cognitoUser = createUserResult.getUser();
//        System.out.println(cognitoClient);
//    }
//
//
//    @Test
//    public void testAwsUpdateUserPwd() {
//
//        AWSCognitoIdentityProvider cognitoClient = getAmazonCognitoIdentityClient();
//
//
//        AdminSetUserPasswordRequest request = new AdminSetUserPasswordRequest()
//                .withPassword("Yajun123")
//                .withPermanent(true)
//                .withUsername("AWS-User")
//                .withUserPoolId("us-east-2_XEW6z7jV5");
//
//        AdminSetUserPasswordResult adminSetUserPasswordResult = cognitoClient.adminSetUserPassword(request);
//        System.out.println(adminSetUserPasswordResult.getSdkResponseMetadata());
//    }




    @Test
    public void testDrools() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        //会话对象，用于和规则引擎交互
        KieSession kieSession = kieClasspathContainer.newKieSession();

        //构造订单对象，设置原始价格，由规则引擎根据优惠规则计算优惠后的价格
        Order order = new Order();
        order.setOriginalPrice(210D);

        //将数据提供给规则引擎，规则引擎会根据提供的数据进行规则匹配
        kieSession.insert(order);

        //激活规则引擎，如果规则匹配成功则执行规则
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();

        System.out.println("优惠前原始价格：" + order.getOriginalPrice() +
                "，优惠后价格：" + order.getRealPrice());
    }


}
