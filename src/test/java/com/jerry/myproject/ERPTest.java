package com.jerry.myproject;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/09/21 16:46
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ERPTest {


    @Test
    public void testPost() throws IOException {
        String appKey = "1019268392156135424";
        String secret = "ac63bee283d847c1a226ab727186ce47";

        String a = "{\"businessType\":null,\"warehouseCode\":\"USCA1002\"}";
//        String json = JSON.toJSONString(a);
        String json = URLEncoder.encode(a, "utf-8");
        System.out.println("======请求参数jsonStr======" + json);
        // 系统参数
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", "zouwu.oms.system.queryDcChannel");
        param.put("app_key", appKey);
        param.put("data", json);
        param.put("format", "json");
        param.put("timestamp", getTime());
//        param.put("timestamp", "2022-09-20 17:59:18");
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
