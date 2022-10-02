package com.haojue.common.entity;

import lombok.Data;

/**
 * 订单详情
 */
@Data
public class OrderDetailEntity extends BaseEntity {

    /**
     * 订单编号
     */
    private String orderId;


    /**
     * 作品编号
     */
    private String opusCode;

    /**
     * 作品名称
     */
    private String opusName;

    /**
     * 作品关键字
     */
    private String keyword;


    /**
     * 价格
     */
    private String price;


    /**
     * 数量
     */
    private Integer num;


}
