package com.haojue.common.entity;

import lombok.Data;

/**
 * 订单
 */
@Data
public class OrderEntity extends BaseEntity {

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 用户账号
     */
    private String mobile;

    /**
     * 订单金额
     */
    private String amount;

    /**
     * 支付方式 0：支付宝
     */
    private Integer paymentMethod;

    /**
     * 订单来源
     */
    private String source;

    /**
     * 0：待付款  3：支付完成  5：平台确认订单  8:订单完成
     */
    private  Integer state;


}
