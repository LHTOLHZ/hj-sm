package com.haojue.common.entity;

import lombok.Data;

@Data
public class OpusMaterialEntity {
    private Long id;
    private String  opusCode;
    private String url;
    /**
     * 0；图片 1：视频
     */
    private Integer type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpusCode() {
        return opusCode;
    }

    public void setOpusCode(String opusCode) {
        this.opusCode = opusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
