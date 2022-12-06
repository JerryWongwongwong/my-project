package com.jerry.myproject.server.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * @author xiaofeng
 * @create 2022-03-14 19:05
 */
@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErpResultDTO {

  private Integer code = 0;

  private PaginationDTO pagination;

  private List<ErpOrderDataDTO> data;

  private Boolean nextPage;

  private String service;

  private String responseTime;

  private String ask;

  private Integer count;

  private String message;
}
