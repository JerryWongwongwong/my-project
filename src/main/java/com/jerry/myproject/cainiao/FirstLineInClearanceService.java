package com.jerry.myproject.cainiao;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 11:21
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class FirstLineInClearanceService {


    private String serviceId;
    private Date expectCompleteTime;
    private String expectCompleteTimezone;
    private String payType;
    private String carrierCode;
    private String vessel;
    private String voyage;
    private Date etd;
    private String etdTimezone;
    private Date eta;
    private String etaTimezone;
    private String transportMode;
    private String masterWayBill;
    private String houseWayBill;
    private List<ServiceProvider> serviceProviderList;
    private List<Document> documentList;
    private List<Party> partyList;


}
