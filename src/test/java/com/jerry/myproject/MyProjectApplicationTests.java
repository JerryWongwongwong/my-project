package com.jerry.myproject;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;

import com.amazonaws.services.cognitoidp.model.*;
import com.jerry.myproject.server.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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

        asyncMethod();
        System.out.println("end");
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


    public AWSCognitoIdentityProvider getAmazonCognitoIdentityClient() {
        ClasspathPropertiesFileCredentialsProvider propertiesFileCredentialsProvider =
                new ClasspathPropertiesFileCredentialsProvider();

        return AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIARY66HDFOQ6UEXTMN", "L1Mb11q9Nri3UnITrCi512ebXwXcUy6cY5FiUIb0")))
                .withRegion("us-east-2")
                .build();

    }

    @Test
    public void testAwsCreateUser() {

        AWSCognitoIdentityProvider cognitoClient = getAmazonCognitoIdentityClient();

        AdminCreateUserRequest cognitoRequest = new AdminCreateUserRequest()
                .withUserPoolId("us-east-2_XEW6z7jV5")
                .withUsername("AWS-User")
                .withUserAttributes(

                        new AttributeType()
                                .withName("email")
                                .withValue("jerrywongwongwong@gmail.com"),
                        new AttributeType()
                                .withName("name")
                                .withValue("jerry"),
                        new AttributeType()
                                .withName("family_name")
                                .withValue("wong"),
//                        new AttributeType()
//                                .withName("phone_number")
//                                .withValue("+86-17621732503"),
//                        new AttributeType()
//                                .withName("custom:companyName")
//                                .withValue("shenzhen"),
//                        new AttributeType()
//                                .withName("custom:companyPosition")
//                                .withValue("boss"),
                        new AttributeType()
                                .withName("email_verified")
                                .withValue("true"))
                .withTemporaryPassword("Qwer1234")
                .withMessageAction("SUPPRESS")
                .withDesiredDeliveryMediums(DeliveryMediumType.EMAIL)
                .withForceAliasCreation(Boolean.FALSE);

        AdminCreateUserResult createUserResult = cognitoClient.adminCreateUser(cognitoRequest);
        UserType cognitoUser = createUserResult.getUser();
        System.out.println(cognitoClient);
    }


    @Test
    public void testAwsUpdateUserPwd() {

        AWSCognitoIdentityProvider cognitoClient = getAmazonCognitoIdentityClient();


        AdminSetUserPasswordRequest request = new AdminSetUserPasswordRequest()
                .withPassword("Yajun123")
                .withPermanent(true)
                .withUsername("AWS-User")
                .withUserPoolId("us-east-2_XEW6z7jV5");

        AdminSetUserPasswordResult adminSetUserPasswordResult = cognitoClient.adminSetUserPassword(request);
        System.out.println(adminSetUserPasswordResult.getSdkResponseMetadata());
    }

    //甄士东

    //王亚军



}
