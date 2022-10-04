package com.haojue.biz.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OpusCommentVO {
    /**
     * 关键字
     */
    private String keyword;

    /**
     * 作品名称
     */
    private String name;

    /**
     * opusId
     */
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;


    private String ip;

    /**
     * 0：不显示 1：显示
     */
    private Integer view;

    private String remark;

    private String commentCode;

    private Long opusId;

    /**
     * 用户头像
     */
    private String userUrl;
    /**
     * 用户昵称
     */
    private String nickName;


}
