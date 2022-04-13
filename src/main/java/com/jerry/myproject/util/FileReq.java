package com.jerry.myproject.util;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-system
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2021-10-28 17:48
 *
 * @author : lucian
 * @version : 0.1.0
 * @since : 0.1.0
 */
@Data
public class FileReq implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 文件字节数组
   */
  @NotNull
  private byte[] fileBytes;

  /**
   * 类目路径
   */
  @NotNull
  private Integer pathType;

  /**
   * 文件名称
   */
  private String fileName;
}
