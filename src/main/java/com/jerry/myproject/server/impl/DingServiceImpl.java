package com.jerry.myproject.server.impl;

import com.dzg.doraemon.ding.GroupRobotSender;
import com.dzg.doraemon.ding.request.GroupRobotTextRequest;
import com.dzg.doraemon.enums.SecurityType;
import com.dzg.doraemon.utils.HttpClientResult;
import com.jerry.myproject.server.DingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * CopyRight : 杭州大掌柜物流科技有限公司
 * Project :  zouwu-oms-order
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2021-10-27 11:01
 *
 * @author : Jerry
 * @version : 0.1.0
 * @since : 0.1.0
 */
@Service
@Slf4j
public class DingServiceImpl implements DingService {

    String content = "@UserID's test_msg";
    String url = "https://oapi.dingtalk.com/robot/send?access_token=29bf2889315bfe4233005c894764da3b833cb3903bfb27425965fc80df8ff984";
    String secret = "SEC177e6e52e743381941b53827ba5459b0e50422e0e29ad8167dee6cfee6682a20";

    @Override
    public void testDing() {

//        HttpClientResult result = GroupRobotSender.sendGroupTextMsg(content, url, secret);

        GroupRobotTextRequest request = GroupRobotTextRequest.Builder.create()
                .content(content)
                .url(url)
                .secret(secret)
//                .userIds(Collections.singletonList("1az_84hqtmpa9a"))
//                .mobiles(Collections.singletonList("17621732503"))
                .allowAtAll(true)
//                .exceptionHandler(e -> log.error())
                .build();

        HttpClientResult result = GroupRobotSender.sendGroupTextMsg(request, SecurityType.COUNTERSIGN);
        System.out.println(result);

    }
}
