package com.haojue.biz.mapper;

import com.haojue.common.entity.OpusMaterialEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpusMaterialMapper {
    int deleteOpusMaterial(@Param("opusCode") String opusCode);

    int saveOpusMaterial(OpusMaterialEntity opusMaterialEntity);

    List<OpusMaterialEntity> getOpusCode(@Param("opusCode") String opusCode);

}
