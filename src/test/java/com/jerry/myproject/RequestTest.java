package com.jerry.myproject;

import com.jerry.myproject.util.MD5Util;
import com.jerry.myproject.util.RestfulHttpClient;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
        String secret = "3d6277254ed8278e7a7f299d4b58626e";

        String substring1 = secret.substring(0, 16);
        String substring2 = secret.substring(16, 32);
        String xmlInfo = getXmlInfo();
//        String xmlInfo = "<Test>123abc 测试</Test>";
        String beforeSign = substring1 + xmlInfo + substring2;

        String afterSign = MD5Util.getMD5Str(beforeSign);


        String urlParam = "http://test.edaeu.com/Api/GetStorageList/DataDigest/" + afterSign;


        String s = testPost(urlParam, xmlInfo);

        System.out.println(s);

//
//        final RestfulHttpClient.HttpResponse request;
//        try {
//            request = RestfulHttpClient
//                    .getClient(urlParam)
//                    .post()
////                    .pathParams()
//                    .headers(headers)
//                    .request();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
        sb.append("<GetStorageList>");
        sb.append("<User>" + email + "</User>");
        sb.append("<RequestTime>" + dateStr + "</RequestTime>");
//        sb.append("<PageNumber>" + 1 + "</PageNumber>");
//        sb.append("<ItemsPerPage>" + 10 + "</ItemsPerPage>");
        sb.append("</GetStorageList>");


        return sb.toString();
    }

//
//    public static void main(String[] args) {
//        long currentTimeMillis = System.currentTimeMillis();
//        Date date = new Date(currentTimeMillis);
//        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//
//        String dateStr2 = sdf2.format(date);
//        System.out.println(dateStr2);
//
//        System.out.println(date.toString());
//    }


    public static String testPost(String urlStr, String xmlInfo) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
//            con.setRequestProperty("Pragma:", "no-cache");
//            con.setRequestProperty("Cache-Control", "no-cache");
            // 一定要设置报文格式，否则发送失败
            con.setRequestProperty("Content-Type", "text/xml");

            OutputStreamWriter out = null;
            try {
                out = new OutputStreamWriter(con.getOutputStream());
            } catch (ConnectException e) {
//                e.printStackTrace();
                return "Connection refused";
            }
//            System.out.println("urlStr=" + urlStr);
//            System.out.println("xmlInfo=" + xmlInfo);
            out.write(new String(xmlInfo.getBytes("ISO-8859-1")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            for (line = br.readLine(); line != null; line = br.readLine()) {
//                System.out.println(line);
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
