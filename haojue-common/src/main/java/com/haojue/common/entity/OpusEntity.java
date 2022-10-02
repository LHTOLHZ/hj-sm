package com.haojue.common.entity;

import lombok.Data;

/**
 * 作品
 */
@Data
public class OpusEntity extends BaseEntity{

    /**
     * 作品编号
     */
    private String code;

    /**
     * 作品名称
     */
    private String name;


    /**
     * 价格
     */
    private String price;



    /**
     * 作者
     */
    private String author;


    /**
     * qq
     */
    private String qq;

    /**
     * 微信
     */
    private String wechat;


    /**
     * 手机号
     */
    private String mobile;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 介绍
     */
    private String remark;

    /**
     * 网盘地址
     */
    private String networkUrl;

    /**
     * 网盘编码
     */
    private String networkCode;

    /**
     * 解压码
     */
    private String zipCode;

    /**
     * 审核状态 0：未审核 1：审核
     */
    private Integer state;

    /**
     * 0：下架  1：上架
     */
    private Integer superior;

    /**
     * 0：非精选 1:精选
     */
    private Integer selected;

    /**
     * 浏览数
     */
    private Integer browseNum;



}
