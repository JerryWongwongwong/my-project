package com.jerry.myproject.cainiao;

import lombok.Data;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 10:21
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class PackageItem {

    private Long length;
    private Long width;
    private Long height;
    private Integer qty;
    private String uom;
    private String stack;
    private String ippc;
    private String originCountry;
    private String packageMaterial;
}
