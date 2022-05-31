package com.jerry.myproject.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 客商信息
 * JDK version : JDK1.8
 * Create Date : 2021-12-09 14:08
 *
 * @author : zyg
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class CustomerInfoDTO implements Serializable {

  private static final long serialVersionUID = 7817473890892896843L;

  /**
   * 客商标识
   */
  @NotBlank
  private String customerKey;

}
