package com.haojue.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 作品收藏
 */
@Data
public class OpusCollectionEntity {

    private Long id;

    /**
     * 作品编号
     */
    private String opusCode;

    /**
     * 用户账号
     */
    private String mobile;

    /**
     * 收藏时间
     */
    private Date createDate = new Date();

}
