package com.jerry.myproject.dto;


import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 创建出库申请单
 * JDK version : JDK1.8
 * Create Date : 2021-12-08 14:33
 *
 * @author : zyg
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class CreateOutboundDTO implements Serializable {

    private static final long serialVersionUID = 5298556609636311336L;

    /**
     * 业务类型（201-标准出库）
     */

    private Integer businessType;

    /**
     * 订单来源平台code（1-Amazon，2-Ebay，99-其它电商平台）
     */
    private String orderSourcePlatformCode;

    /**
     * 客户销售单号
     */
    private String customerSalesNo;

    /**
     * 客户关联单号
     */
    private String customerRelatedNo;

    /**
     * 平台卖家id
     */
    private String platformSellerId;

    /**
     * 平台店铺id
     */
    private String platformStoreId;

    /**
     * 订单销售金额(USD)
     */
    private BigDecimal salesAmount;

    /**
     * Ebay交易ID号
     */
    private String ebaySalesId;

    /**
     * Ebay平台交易单号
     */
    private String ebayPlatformSalesNo;

    /**
     * 订单备注（仅仓库人员可见）
     */
    private String warehouseRemark;

    /**
     * 订单人姓名
     */
    private String orderOwnerName;

    /**
     * 订单人证件类型（1-身份证，2-护照，99-其他）
     */
    private Integer orderOwnerIdType;

    /**
     * 订单人证件号码
     */
    private String orderOwnerIdNo;

    /**
     * 发货仓库编码
     */
    private String deliveryWarehouseCode;

    /**
     * 物流快递信息
     */
    @Valid
    private OutboundLogisticsDTO express;

    /**
     * 商品清单
     */
    private List<OutboundGoodsDTO> goodsList;

    /**
     * 客商信息
     */
    private CustomerInfoDTO customerInfo;
}
