package com.jerry.myproject.cainiao;

import lombok.Data;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 11:15
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class InsuranceService {


    private String serviceId;
    private Party insuredParty;
    private Double insuranceValue;
    private String insuranceCurrency;
    private Double cargoValue;
    private String cargoCurrency;
    private Double cargoValueCNY;
    private Double exchangeRate;
    private String cargoCategory;
    private String invoiceNo;

}
