package com.jerry.myproject.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 附件参数
 * JDK version : JDK1.8
 * Create Date : 2021-11-13 15:37
 *
 * @author : Galvin
 * @version : 0.2.0
 * @since : 0.2.0
 */
@Data
public class OutboundOrderFileDTO implements Serializable {

  private static final long serialVersionUID = -686088717227209433L;

  /**
   * id
   */
  private Long id;

  /**
   * 附件类型
   */
  private Integer fileType;

  /**
   * 附件名称
   */
  private String fileName;

  /**
   * 附件路径
   */
  private String filePath;

  /**
   * 删除标志
   */
  private Boolean deleted;
}
