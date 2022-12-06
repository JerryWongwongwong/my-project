package com.jerry.myproject.server.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author xiaofeng
 * @create 2022-03-10 15:01
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiptAddressDTO {

  private String country;

  private String firstname;

  private String 	city;

  private String 	postcode;

  private String 	streetAddress1;

  private String 	streetAddress2;

  private String 	lastname;

  private String 	phone;

  private String 	company;

  private String 	state;

  private String 	doorplate;

  private String 	cellPhone;

  private String 	email;


}
