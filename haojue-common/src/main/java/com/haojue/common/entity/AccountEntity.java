package com.haojue.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * 会员
 */
@Data
public class AccountEntity{

    private Long id;

    /**
     * 用户账号
     */
    private String mobile;

    /**
     * 性别 0：保密 1：男  2：女
     */
    private Integer gender;


    /**
     * 昵称
     */
    private String nickName;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 签名
     */
    private String autograph;


    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 来源
     */
    private String source;

    /**
     * 富力币
     */
    private Integer flCurrency;

    /**
     * 成长值
     */
    private Integer growthValue;


    /**
     * 创建时间
     */
    private Date createDate = new Date();

    /**
     * 修改时间
     */
    private Date updateDate = new Date();


}
