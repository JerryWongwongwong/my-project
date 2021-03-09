package com.jerry.myproject;

import com.jerry.myproject.util.MD5Util;
import com.jerry.myproject.util.RestfulHttpClient;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry
 * @Description
 * @createTime 2021年03月03日 15:09:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestTest {


    @Test
    public void httpRequestTest() {

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/xml");

        //32位
//        String secret = "3d6277254ed8278e7a7f299d4b58626e";
        String secret = "ec8ba61d894268b0d8ca2ca532ef44d8";

        String substring1 = secret.substring(0, 16);
        String substring2 = secret.substring(16, 32);
        String xmlInfo = getXmlInfo();
//        String xmlInfo = "<Test>123abc 测试</Test>";
        String beforeSign = substring1 + xmlInfo + substring2;

        String afterSign = MD5Util.getMD5Str(beforeSign);


        String urlParam = "http://test.edaeu.com/Api/GetStockInList/DataDigest/" + afterSign;

        final RestfulHttpClient.HttpResponse request;
        try {
            request = RestfulHttpClient
                    .getClient(urlParam)
                    .post()
                    .headers(headers)
                    .request();
        } catch (IOException e) {
            e.printStackTrace();
        }

//http://test.edaeu.com/Api/GetStockInList/DataDigest/976e93dcd53f0e2900a433449f6103ea


    }


    private static String getXmlInfo() {

        String email = "346337292@QQ.COM";
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);

//        DateTime dateTime = new DateTime(currentTimeMillis);
//        Timestamp timestamp = new Timestamp(date.getTime());
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateStr = simpleDateFormat.format(date);
        String dateStr = "2021-03-08 14:30:00";



        StringBuilder sb = new StringBuilder();
//        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<GetStockInList>");
        sb.append("<User>" + email + "</User>");
        sb.append("<RequestTime>" + dateStr + "</RequestTime>");
//        sb.append("<PageNumber>" + 1 + "</PageNumber>");
//        sb.append("<ItemsPerPage>" + 10 + "</ItemsPerPage>");
        sb.append("</GetStockInList>");


        return sb.toString();
    }


    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        String dateStr2 = sdf2.format(date);
        System.out.println(dateStr2);

        System.out.println(date.toString());
    }


}
