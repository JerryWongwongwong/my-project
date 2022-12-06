package com.jerry.myproject.cainiao;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
public class Cargo {

    private Date cargoReadyDate;
    private String cargoReadyTimezone;
    private String cargoType;
    private String containerLoad;
    private String temperature;
    private String temperatureUom;
    private List<Container> containerList;
    private List<PackageItem> packageList;
}
