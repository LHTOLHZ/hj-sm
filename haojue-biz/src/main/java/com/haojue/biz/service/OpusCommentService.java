package com.haojue.biz.service;

import com.haojue.biz.domain.OpusCommentVO;

import java.util.List;

public interface OpusCommentService {

    List<OpusCommentVO> getPageList(OpusCommentVO opusComment, String createBy);

    int updateViewState(Long id,Integer view);

    int deleteById(Long id);

    List<OpusCommentVO> getCommentDetailPage(Long  opusId);

}
