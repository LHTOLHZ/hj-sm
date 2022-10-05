package com.haojue.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 作品评论
 */
@Data
public class OpusCommentEntity {

    private Long id;

    /**
     * 作品编号
     */
    private String opusCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String userEmail;


    /**
     * 评论时间
     */
    private Date createDate;


    private String ip;

    /**
     * 0：不显示 1：显示
     */
    private Integer view;




}
