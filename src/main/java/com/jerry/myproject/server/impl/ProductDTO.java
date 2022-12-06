package com.jerry.myproject.server.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author xiaofeng
 * @create 2022-03-10 15:04
 */
@Data
public class ProductDTO {

  private String op_sales_price;

  private String quantity;

  private String platformSalesSku;

  private String product_weight;

  private String recvAccount;

  private String sku;

  private String refTnx;

  private String product_title;

  private String declaredValue;

  private String declaredWeight;

  private String refItemId;

}
