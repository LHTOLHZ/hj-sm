package com.haojue.common.entity;

import lombok.Data;

/**
 * 素材
 */
@Data
public class MaterialEntity{


    private Long id;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 是否是主图 1：是 0：不是
     */
    private Integer main;

    /**
     * 0:图片 1：视频
     */
    private Integer type;

    /**
     * 作品编号
     */
    private  String opusCode;





}
