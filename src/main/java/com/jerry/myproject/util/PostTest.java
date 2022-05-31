package com.jerry.myproject.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jerry.myproject.dto.CreateOutboundDTO;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

public class PostTest {


    public static void testPost() throws IOException {

        String appKey = "980788680488648704";
        String secret = "1aad0e36058b48c5a8725458ccf5ca42";

        String reqParam = "{\"businessType\":201,\"orderSourcePlatformCode\":\"5\",\"customerRelatedNo\":\"ch-lws-183561827\",\"platformSellerId\":\"907\",\"deliveryWarehouseCode\":\"USCA1001\",\"express\":{\"recipientCountryName\":\"US\",\"recipientProvinceName\":\"PA\",\"recipientCityName\":\"FORTY FORT\",\"recipientAddressList\":[\"99 FORT STR\"],\"recipientName\":\"MICHAEL SR BARTON\",\"recipientPostcode\":\"18704\",\"recipientBranchPostcode\":\"2304\",\"deliveryList\":[{\"dispatchServiceName\":10}]},\"goodsList\":[{\"sku\":\"HB-AAAA-2\",\"totalQuantity\":1}],\"customerInfo\":{\"customerKey\":\"885a7428d5262ac73ff7b2f53ee4a730\"}}";
        CreateOutboundDTO createOutboundDTO = JSON.parseObject(reqParam, CreateOutboundDTO.class);
        Map<String, String> paramsMap = JSON.parseObject(JSON.toJSONString(createOutboundDTO), new TypeReference<Map<String, String>>() {
        });

        String data = JSON.toJSONString(paramsMap);
        data = URLEncoder.encode(data, "utf-8");

        // 系统参数
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "zouwu.oms.order.createOutbound");
        param.put("version", "1.0");
        param.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        param.put("data", data);
        param.put("app_key", appKey);

        String sign = buildSign(param, secret);
        param.put("sign", sign);

        System.out.println("=====请求数据=====");
        String postJson = JSON.toJSONString(param);
        System.out.println(postJson);

    }

    /**
     * 构建签名
     *
     * @param paramsMap 参数
     * @param secret    密钥
     * @return
     * @throws IOException
     */
    public static String buildSign(Map<String, ?> paramsMap, String secret) throws IOException {
        Set<String> keySet = paramsMap.keySet();
        List<String> paramNames = new ArrayList<String>(keySet);

        Collections.sort(paramNames);

        StringBuilder paramNameValue = new StringBuilder();

        for (String paramName : paramNames) {
            paramNameValue.append(paramName).append(paramsMap.get(paramName));
        }

        String source = secret + paramNameValue.toString() + secret;

        System.out.println("MD5前");
        System.out.println(source);
        return md5(source);
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