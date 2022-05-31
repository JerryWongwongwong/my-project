package com.jerry.myproject.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 派送单参数
 * JDK version : JDK1.8
 * Create Date : 2021-11-12 21:31
 *
 * @author : Galvin
 * @version : 0.2.0
 * @since : 0.2.0
 */
@Data
public class OutboundDeliveryDTO implements Serializable {

  private static final long serialVersionUID = -489461908354250202L;

  /**
   * id
   */
  private Long id;

  /**
   * 派送服务类型
   */
  private Integer dispatchServiceType;

  /**
   * 派送服务名称
   */
  private Integer dispatchServiceName;

  /**
   * 派送服务类型翻译
   */
  private String dispatchServiceTypeStr;

  /**
   * 派送服务名称翻译
   */
  private String dispatchServiceNameStr;

  /**
   * 追踪单号
   */
  private String trackingNo;

  /**
   * 删除标志
   */
  private Boolean deleted;

  /**
   * 附件列表
   */
  private List<OutboundOrderFileDTO> fileList;
}
