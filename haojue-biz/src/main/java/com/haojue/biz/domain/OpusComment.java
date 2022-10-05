package com.haojue.biz.domain;

import lombok.Data;

@Data
public class OpusComment {

    private Long id;

    private String opusCode;

    private String userName;

    private String userEmail;

    private String ip;

    private Integer view;

    private String remark;

    private String commentCode;

    private Long userId;
}
