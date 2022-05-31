package com.jerry.myproject;


import com.alibaba.fastjson.JSON;
import com.jerry.myproject.entity.Order;
import com.jerry.myproject.server.DingService;
import com.jerry.myproject.server.impl.UserServiceImpl;
import com.jerry.myproject.util.PostTest;
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
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * springboot单元测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MyProjectApplicationTests {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private DingService dingService;

    @Test
    public void testDing() throws IOException {

        PostTest.testPost();
//        dingService.testDing();
    }


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


    @Test
    public void testHttp() {
        userService.testHttp();
    }


    @Test
    public void testPost() throws IOException {
        String appKey = "922609183583371264";
        String secret = "6d5929c4d6354237a98c3a66a6f160e7";
        // 业务参数, 要用LinkedHashMap
//        Map<String, String> jsonMap = new LinkedHashMap<String, String>();
//        jsonMap.put("warehouseCode", "iphoneX");
//        jsonMap.put("sku", "test");
//        jsonMap.put("limit", "0");
//        jsonMap.put("customerInfo", "{\"customerKey\":\"\"}");

        String a = "{\"warehouseCode\":\"\",\"sku\":\"\",\"limit\":0,\"customerInfo\":{\"customerKey\":\"\"}}";
//        String json = JSON.toJSONString(a);
        String json = URLEncoder.encode(a, "utf-8");
        System.out.println("======请求参数jsonStr======" + json);
        // 系统参数
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "zouwu.oms.stock.queryInventoryDetail");
        param.put("app_key", appKey);
        param.put("data", json);
        param.put("format", "json");
//        param.put("timestamp", getTime());
        param.put("timestamp", "1646289707358");
        param.put("version", "1.0");

        String sign = buildSign(param, secret);
        System.out.println("=======签名======" + sign);
        param.put("sign", sign);

        System.out.println("=====请求数据=====");
        String postJson = JSON.toJSONString(param);
        System.out.println(postJson);

    }


    public static String buildSign(Map<String, ?> paramsMap, String secret) throws IOException {
        Set<String> keySet = paramsMap.keySet();
        List<String> paramNames = new ArrayList<String>(keySet);

        Collections.sort(paramNames);

        StringBuilder paramNameValue = new StringBuilder();

        for (String paramName : paramNames) {
            paramNameValue.append(paramName).append(paramsMap.get(paramName));
        }

        String source = secret + paramNameValue.toString() + secret;
        System.out.println("======加密字符串======"+ source);

        return md5(source);
    }

    @Test
    public void testSign() {
        String a = "6d5929c4d6354237a98c3a66a6f160e7<app_key><922609183583371264><data><%7B%22warehouseCode%22%3A%22%22%2C%22sku%22%3A%22%22%2C%22limit%22%3A0%2C%22customerInfo%22%3A%7B%22customerKey%22%3A%22%22%7D%7D><format><json><timestamp><1646286776609><name><zouwu.oms.stock.queryInventoryDetail><version><1.0>6d5929c4d6354237a98c3a66a6f160e7";

        System.out.println(md5(a));
    }

    /**
     * 生成md5,全部大写
     *
     * @param message
     * @return
     */
    public static String md5(String message) {
        try {
            // 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 2 将消息变成byte数组
            byte[] input = message.getBytes();

            // 3 计算后获得字节数组,这就是那128位了
            byte[] buff = md.digest(input);

            // 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
            return byte2hex(buff);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
