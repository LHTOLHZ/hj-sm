package com.haojue.biz.mapper;

import com.haojue.biz.domain.OpusCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpusCommentMapper {

    List<OpusCommentVO> getPageList(@Param("opusComment") OpusCommentVO opusComment, @Param("createBy") String createBy);
    int updateViewState(@Param("id") Long id,@Param("view") Integer view);
    int deleteById(@Param("id") Long id);
    List<OpusCommentVO> getCommentDetailPage(@Param("opusId") Long  opusId);
}
