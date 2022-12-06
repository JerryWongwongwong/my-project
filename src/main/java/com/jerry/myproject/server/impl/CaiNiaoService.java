package com.jerry.myproject.server.impl;

import com.jerry.myproject.cainiao.GlobalFulfillmentOrderNotifyRequest;
import com.jerry.myproject.cainiao.Party;
import org.springframework.stereotype.Service;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 11:29
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */

@Service
public class CaiNiaoService {

    public void test(){
        GlobalFulfillmentOrderNotifyRequest request = new GlobalFulfillmentOrderNotifyRequest();
        // 出库
//        request.setOutOrderCode();
//        // 货主id
//        request.setMerchantId();
//        // 业务来源
//        request.setBizSource();
//
//        request.setBizType();

        Party party = new Party();
        //
        party.setPartyType("");
        party.setCompanyName("");
        //
        party.setContactName("");
        //
        party.setPhoneArea("");
        //
        party.setPhone("");
        //
        party.setEmail("");
        //
        party.setCountryCode("");
        //
        party.setCountry("");
        party.setState("");
        party.setCity("");
        party.setDistrict("");
        party.setAddress("");
        party.setZipcode("");
        party.setFax("");






    }

}
