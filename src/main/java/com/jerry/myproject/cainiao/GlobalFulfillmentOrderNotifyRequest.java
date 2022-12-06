package com.jerry.myproject.cainiao;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/10/18 10:17
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class GlobalFulfillmentOrderNotifyRequest implements Serializable {

    private String planOrderCode;
    private String focOrderCode;
    private String bizOrderCode;
    private String outOrderCode;
    private Long merchantId;
    private String channelCode;
    private String bizSource;
    private String bizType;
    private String businessUnitId;
    private List<Party> contactList;
    private Trade trade;
    private Transport transport;
    private Cargo cargo;
    private IntlShipmentService intlShipmentService;
    private FirstLineInClearanceService firstLineInClearanceService;
    private FirstLineOutClearanceService firstLineOutClearanceService;
    private SecondLineInService secondLineInService;
    private SecondLineOutService secondLineOutService;
    private LocalTransportService localTransportService;
    private WarehouseTransferService warehouseTransferService;
    private WarehouseOutboundService warehouseOutboundService;
    private WarehouseInboundService warehouseInboundService;
    private WarehouseCrossDockService warehouseCrossDockService;
    private InsuranceService insuranceService;
    private ClientInfo clientInfo;
}
