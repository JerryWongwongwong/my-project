package com.jerry.myproject;

import lombok.Data;

import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 仓库系统关联对象
 * JDK version : JDK1.8
 * Create Date : 2022-03-18 16:08
 *
 * @author : zhongyunchang
 * @version : 0.2.3
 * @since : 0.2.3
 */
@Data
public class WmsSystemWarehouseRelaRespDTO implements Serializable {
  private static final long serialVersionUID = 5942455173388460174L;

  /**
   * 运营主体id
   */
  private String companyId;

  /**
   * 仓库code
   */
  private String warehouseCode;

  /**
   * 仓库系统code
   */
  private String wmsSystemCode;

  /**
   * 是否回调
   */
  private Boolean callback;

  /**
   * 第三方仓库code
   */
  private String otherWarehouseCode;
}
