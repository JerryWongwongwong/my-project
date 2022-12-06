package com.jerry.myproject.server.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * erp返回对象
 * @author xiaofeng
 * @create 2022-03-10 14:52
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErpOrderDataDTO {

  // 其他电商平台
  public final static String OTHER = "99";

  private String referenceNo;

  private String 	addTime;

  private String 	serviceProviderCode;

  private String 	orderStatus;

  private String 	orderPaydate;

  // 仓库名
  private String 	warehouseName;

  private String 	serviceProviderName;

  private String 	platform;

  private String 	currency_code;

  private String 	warehouseCode;

  private String 	sellerId;

  // 地址信息
  private ReceiptAddressDTO receiptAddress;

  private String 	ebay_total;


  //订单code
  private String orderCode;


  private String smCode;

  private String channelName;

  private ReceiptAddressDTO 	billingAddress;

  // 产品信息
  private List<ProductDTO> productList;

  private String channelCode;



}
