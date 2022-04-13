package com.jerry.myproject.dto;

import lombok.Data;

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
@Data
public class OrderListDataDTO {

    private String id;

    private String name;

    private String orderStatus;

    private String carrier;

    private String createdDate;

    private String trackingNumber;

    private String userEmail;

    private String orderType;

    private String sourceDocument;

    private String scheduledDate;
    private String sourceLocation;
    private String destinationLocation;
    private String remark;
    private String transferDate;
    private String isFBA;
    private String ownShippingLabel;
    private String shippingLabelURL;
    private String shippingLabelUploaded;
    private String shippingCost;
    private String shippingWeight;
    private String backOrders;
    private String backOrderOf;
    private String refundStatus;
    private String refundNote;

}
