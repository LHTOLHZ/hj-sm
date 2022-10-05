package com.haojue.biz.mapper;

import com.haojue.biz.domain.OpusComment;
import com.haojue.biz.domain.OpusCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpusCommentMapper {

    List<OpusCommentVO> getPageList(@Param("opusComment") OpusCommentVO opusComment, @Param("createBy") String createBy);

    int updateViewState(@Param("commentCode") String commentCode, @Param("view") Integer view);

    int deleteById(@Param("id") Long id);

    int deleteByCommentCode(@Param("commentCode") String commentCode);

    List<OpusCommentVO> getCommentDetailPage(@Param("opusId") Long opusId);

    OpusCommentVO commentInfo(@Param("id") Long id);

    int save(@Param("opusComment") OpusComment opusComment);


}
