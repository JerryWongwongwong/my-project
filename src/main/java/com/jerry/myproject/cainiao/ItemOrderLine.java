package com.jerry.myproject.cainiao;

import lombok.Data;

import java.util.Date;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 10:19
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class ItemOrderLine {

    private Long outLineId;
    private String itemId;
    private String outItemId;
    private String itemCode;
    private String barcode;
    private String inventoryType;
    private String desc;
    private String originHscode;
    private String destinationHscode;
    private Integer packageQty;
    private String packageUom;
    private Integer unitQty;
    private Double totalVolume;
    private String originCountry;
    private Double totalGrossWeight;
    private Double totalNetWeight;
    private Date expireDate;
    private String shelfLife;
    private String currency;
    private Double totalPrice;
    private Double price;
    private String tallyType;
}
