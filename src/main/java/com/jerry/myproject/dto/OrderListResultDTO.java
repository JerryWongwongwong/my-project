package com.jerry.myproject.dto;

import lombok.Data;

import java.util.List;

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
public class OrderListResultDTO {


    private List<OrderListDataDTO> data;

    private Integer page;

    private Integer itemsPerPage;

    private Integer totalCount;


}
