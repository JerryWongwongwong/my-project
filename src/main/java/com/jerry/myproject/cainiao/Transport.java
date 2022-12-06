package com.jerry.myproject.cainiao;

import lombok.Data;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 10:20
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class Transport {

    private String depWarehouse;
    private String dstWarehouse;
    private String depCustomsArea;
    private String dstCustomsArea;
    private String pol;
    private String pod;
    private String exportCountry;
    private String importCountry;
    private String transportMode;
    private String deliveryMethod;

}
