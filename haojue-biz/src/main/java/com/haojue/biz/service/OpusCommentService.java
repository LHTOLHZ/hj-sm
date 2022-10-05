package com.haojue.biz.service;

import com.haojue.biz.domain.OpusComment;
import com.haojue.biz.domain.OpusCommentVO;

import java.util.List;

public interface OpusCommentService {

    List<OpusCommentVO> getPageList(OpusCommentVO opusComment, String createBy);

    int updateViewState(String commentCode ,Integer view);

    int deleteById(Long id);

    int deleteByCommentCOde(String commentCode);

    List<OpusCommentVO> getCommentDetailPage(Long  opusId);

    OpusCommentVO commentInfo(Long id);

    int save(OpusComment opusComment);

}
