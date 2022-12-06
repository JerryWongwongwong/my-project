package com.jerry.myproject.server.impl;

import lombok.Data;

/**
 * @author xiaofeng
 * @create 2022-03-14 19:09
 */
@Data
public class PaginationDTO {

  private Integer pageSize;

  private Integer page;
}
