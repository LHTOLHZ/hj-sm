package com.haojue.biz.service.impl;

import com.haojue.biz.domain.OpusComment;
import com.haojue.biz.domain.OpusCommentVO;
import com.haojue.biz.mapper.OpusCommentMapper;
import com.haojue.biz.service.OpusCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OpusCommentServiceImpl  implements OpusCommentService {

    private final OpusCommentMapper opusCommentMapper;

    @Override
    public List<OpusCommentVO> getPageList(OpusCommentVO opusComment, String createBy) {
        return opusCommentMapper.getPageList(opusComment,createBy);
    }

    @Override
    public int updateViewState(String commentCode, Integer view) {
        return opusCommentMapper.updateViewState(commentCode,view);
    }

    @Override
    public int deleteById(Long id) {
        return opusCommentMapper.deleteById(id);
    }

    @Override
    public int deleteByCommentCOde(String commentCode) {
        return opusCommentMapper.deleteByCommentCode(commentCode);
    }

    @Override
    public List<OpusCommentVO> getCommentDetailPage(Long  opusId) {
        return opusCommentMapper.getCommentDetailPage(opusId);
    }

    @Override
    public OpusCommentVO commentInfo(Long id) {
        return opusCommentMapper.commentInfo(id);
    }

    @Override
    public int save(OpusComment opusComment) {
        return opusCommentMapper.save(opusComment);
    }
}
