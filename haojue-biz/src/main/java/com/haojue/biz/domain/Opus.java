package com.haojue.biz.domain;

import com.haojue.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 作品对象 hj_opus
 *
 * @author jay
 * @date 2022-09-27
 */
@Data
public class Opus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 作品编号 20220901121212 +纳秒 */
    private String code;

    /** 作品名称 */
    private String name;

    /** 价格 */
    private String price;

    /** 作者 */
    private String author;

    /** $column.columnComment */
    private String qq;

    /** 微信 */
    private String wechat;

    /** 手机号 */
    private String mobile;

    /** 关键字 */
    private String keyword;

    /** 网盘地址 */
    private String networkUrl;

    /** 网盘编码 */
    private String networkCode;

    /** 解压码 */
    private String zipCode;

    /** 审核状态 1：待审核 ；2：审核中；3-审核未通过；4-审核已通过 */
    private Integer state;

    /** 0：下架  1：上架 */
    private Integer superior;

    /** 0：非精选 1:精选 */
    private Integer selected;

    /**
     * 封面
     */
    private String cover;


    /** 浏览数 */
    private Integer browseNum;

    private String  depositImg;

    private String  depositVideo;

    private String [] depositImgs;

    private String [] depositVideos;

    private transient String trString;

    private transient String nameKeyword;






}
