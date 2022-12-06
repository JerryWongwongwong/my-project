package com.jerry.myproject.server.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jerry.myproject.dto.OrderListResultDTO;
import com.jerry.myproject.server.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Jerry
 * @date 30/03/2020 00:12
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Integer countUser() {
        return 1;
    }


    @Async
    public void longtime() {
        System.out.println("我在执行一项耗时任务");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成");

    }


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


    public List addTwoNumbers(List l1, List l2) {

        String a = "";

        for (Object l : l1) {
            a += l;
        }

        String b = "";

        for (Object l : l2) {
            b += l;
        }

        Integer integer = Integer.valueOf(a);
        Integer integer1 = Integer.valueOf(b);


        Integer i = integer + integer1;

        String s = i.toString();
        int length = s.length();

        char[] chars = s.toCharArray();

        String[] ad = {};
        for (char aChar : chars) {

        }


        return null;
    }


    public void testHttp() {

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", "test@test.com");
        paramMap.put("password", "Test@123");
        String jsonString = JSONObject.toJSONString(paramMap);

        // 先登录获取到token
        String loginUrl = "http://sat-public-api-64704567.us-east-1.elb.amazonaws.com/api/user/login";
        HttpResponse execute = HttpRequest.post(loginUrl).body(jsonString).execute();
        String body = execute.body();
        System.out.println(JSONObject.toJSONString(body) + "===========");

        String substring = body.substring(1, body.length() - 1);
        // header中带有token信息获取其他接口
        String authorizationValue = "Bearer " + substring;
        String otherUrl = "http://sat-public-api-64704567.us-east-1.elb.amazonaws.com/api/order/list";
        HashMap<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("ordertype", "入库单");
        String params = JSONObject.toJSONString(paramMap1);

        HttpResponse execute1 = HttpRequest.get(otherUrl).body(params).header("Authorization", authorizationValue).execute();
        String body1 = execute1.body();

        System.out.println();
        System.out.println(JSONObject.toJSONString(body1));
        System.out.println();

        OrderListResultDTO orderListDTO = JSONObject.parseObject(body1, OrderListResultDTO.class);
        System.out.println(JSONObject.toJSONString(orderListDTO));


    }

//    public static void main(String[] args) throws JsonProcessingException {
//        String json = "{\"ask\":\"Success\",\"code\":200,\"message\":\"Success\",\"count\":\"1\",\"nextPage\":\"false\",\"pagination\":{\"pageSize\":500,\"page\":1},\"data\":[{\"platform\":\"wayfairnew\",\"orderCode\":\"SO22091640017\",\"referenceNo\":\"wf-CS422256377\",\"sellerId\":\"wqian\",\"smCode\":\"WWL-FEDEX-SELF-EXPRESS-WAYBILL\",\"addTime\":\"2022-09-16 09:15:35\",\"orderPaydate\":\"2022-09-14 02:06:50\",\"orderStatus\":\"4\",\"ebay_total\":\"50.000\",\"currency_code\":\"USD\",\"warehouseCode\":\"USNJ1002\",\"warehouseName\":\"环世美东 USNJ1002 号仓\",\"channelCode\":\"WWL-FEDEX-SELF-EXPRESS-WAYBILL\",\"channelName\":\"环世wayfair发货渠道\",\"serviceProviderCode\":\"WAYFAIR\",\"serviceProviderName\":\"WAYFAIR\",\"receiptAddress\":{\"firstname\":\"Kim Hyatt\",\"lastname\":\"\",\"company\":\"\",\"country\":\"US\",\"postcode\":\"24523\",\"state\":\"VA\",\"city\":\"Bedford\",\"streetAddress1\":\"1290 Screechum Hollow Road\",\"streetAddress2\":\"\",\"doorplate\":\"\",\"phone\":\"3087303008\",\"cellPhone\":\"\",\"email\":\"\"},\"billingAddress\":{\"firstname\":\"Kim Hyatt\",\"lastname\":\"\",\"company\":\"\",\"country\":\"US\",\"postcode\":\"24523\",\"state\":\"VA\",\"city\":\"Bedford\",\"streetAddress1\":\"1290 Screechum Hollow Road\",\"streetAddress2\":\"\",\"doorplate\":\"\",\"phone\":\"3087303008\",\"cellPhone\":\"\",\"email\":\"\"},\"productList\":[{\"sku\":\"KBK-PB08GY-22\",\"platformSalesSku\":\"KBK-PB08GY-22\",\"quantity\":\"1\",\"product_title\":\"吧台茶几\",\"op_sales_price\":\"50.000\",\"declaredValue\":\"62.160\",\"declaredWeight\":\"11.600\",\"recvAccount\":\"\",\"refTnx\":\"\",\"refItemId\":\"KBK-PB08GY-22\",\"product_weight\":\"11.600\",\"warehouseProductBarcode\":\"KBK-PB08GY-22\"}]}],\"service\":\"getPreShippingOrder\",\"responseTime\":\"2022-09-16 09:30:01\"}";
//
//
//        ErpResultDTO erpResultDTO1 = JSON.parseObject(json, ErpResultDTO.class);
//        System.out.println(erpResultDTO1);
//
//        ObjectMapper configure = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        ErpResultDTO erpResultDTO2 = configure.readValue(json, ErpResultDTO.class);
//
//        System.out.println(erpResultDTO2);
//
//        ErpResultDTO erpResultDTO = new ObjectMapper().readValue(json, ErpResultDTO.class);
//        System.out.println(erpResultDTO);
//
//    }

//    public static void main(String[] args) {
//        String phoneNumber = " efa2334rwe  f234232312g sd";
//        Pattern pattern = Pattern.compile("[^0-9]");
//        Matcher matcher = pattern.matcher(phoneNumber);
//        String s = matcher.toString();
//        System.out.println(s);
//        String trim = matcher.replaceAll("").trim();
//        System.out.println(trim);
//    }

    public static void main(String[] args) {
         String countryStr = "US,AU";

        // 只有美国和澳大利亚才做二字码校验
        Arrays.stream(countryStr.split(",")).filter(i -> i.equalsIgnoreCase("AU")).forEach(e -> {
            System.out.println("====");
        });
    }

}
