package com.jerry.myproject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  zouwu-oms-order
 * Comments : 出库物流信息参数
 * JDK version : JDK1.8
 * Create Date : 2021-11-12 20:54
 *
 * @author : Galvin
 * @version : 0.2.0
 * @since : 0.2.0
 */
@Data
public class OutboundLogisticsDTO implements Serializable {

  private static final long serialVersionUID = 3925717166992196851L;

  /**
   * 收件人国家
   */
  @NotNull
  private String recipientCountryName;

  /**
   * 收件人省/州
   */
  private String recipientProvinceName;

  /**
   * 收件人城市
   */
  private String recipientCityName;

  /**
   * 收件人详细地址列表(最多三条)
   */
  private List<String> recipientAddressList;

  /**
   * 收件人姓名
   */
  private String recipientName;

  /**
   * 收件人证件类型（1-身份证，2-护照，99-其他）
   */
  private Integer recipientIdType;

  /**
   * 收件人证件号码
   */
  private String recipientIdNo;

  /**
   * 收件人联系电话列表(最多两条)
   */
  private List<String> recipientPhoneNumberList;

  /**
   * 收件人邮箱
   */
  private String recipientEmail;

  /**
   * 收件人邮编
   */
  private String recipientPostcode;

  /**
   * 收件人分邮编
   */
  private String recipientBranchPostcode;

  /**
   * 收件人EORI号
   */
  private String recipientEoriNo;

  /**
   * 收件人公司
   */
  private String recipientCompanyName;

  /**
   * 收件人是否FBA
   */
  private Boolean recipientIsFba;

  /**
   * 签名服务
   */
  private Boolean signature;

  /**
   * 是否带电
   */
  private Boolean electric;

  /**
   * 保险服务
   */
  private Boolean insured;

  /**
   * 投保金额(USD)
   */
  private BigDecimal insuredAmount;

  /**
   * 派送单列表
   */
  @Valid
  @Size(max = 1)
  private List<OutboundDeliveryDTO> deliveryList;
}
