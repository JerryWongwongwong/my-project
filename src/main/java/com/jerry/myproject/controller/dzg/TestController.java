package com.jerry.myproject.controller.dzg;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class TestController {



    /**
     * demo
     * https://sandboxapi.satsupplychain.com
     *
     * @return
     */
    @PostMapping("/api/order")
    public String outBound() {

        return "{\"transferOrderId\": 123}";
    }
}
