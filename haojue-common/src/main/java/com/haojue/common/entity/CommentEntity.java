package com.haojue.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 评论
 */
@Data
public class CommentEntity{



    private Long id;

    /**
     * 内容
     */
    private String content;


    /**
     * 用户名
     */
    private String nickName;

    /**|
     * 作品名称
     */
    private String opusName;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 0：不显示  1：显示
     */
    private Integer display;


    /**
     * 创建时间
     */
    private Date createDate = new Date();


}
