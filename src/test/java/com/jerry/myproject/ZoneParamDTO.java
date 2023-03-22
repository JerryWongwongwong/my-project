package com.jerry.myproject;

import lombok.Data;

/**
 * CopyRight (c)2018-2023 : cargogm.com
 * Project :  zouwu-oms-order
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2023/01/03 17:06
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class ZoneParamDTO {


  /**
   * 仓库code
   */
  private String warehouseCode;

  /**
   * 派送服务code
   */
  private String dispatchServiceCode;

  /**
   * 目的地开始
   */
  private String destinationStart;

  /**
   * 仓库配置信息
   */
  private WmsSystemWarehouseRelaRespDTO wmsSystem;


  public void postcodeParam(String param, Integer length) {

//    if (!param.matches("^[0-9]*$")) {
//      throw new RuntimeException();
//    }

    while (param.length() < 4) {
      param = String.format("%0" + length + "d", Integer.valueOf(param));
//      param = String.format("%04d", Integer.valueOf(param));
    }
    this.destinationStart = param;
  }

  public void countryParam(String param) {

    this.destinationStart = param;
  }


}
