package com.jerry.myproject.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 出库商品参数
 * JDK version : JDK1.8
 * Create Date : 2021-11-12 19:13
 *
 * @author : Galvin
 * @version : 0.2.0
 * @since : 0.2.0
 */
@Data
public class OutboundGoodsDTO implements Serializable {

    private static final long serialVersionUID = 2630202289405527066L;

    /**
     * SKU
     */
    private String sku;

    /**
     * 总件数
     */
    private Integer totalQuantity;

}
