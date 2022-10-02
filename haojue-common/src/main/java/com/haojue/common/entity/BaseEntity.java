package com.haojue.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {


    private Long id;

    /**
     * 创建时间
     */
    private Date createDate = new Date();

    /**
     * 修改时间
     */
    private Date updateDate = new Date();

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String updater;
}
