package com.haojue.biz.mapper;

import java.util.List;
import com.haojue.biz.domain.Opus;
import com.haojue.common.entity.OpusMaterialEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 作品Mapper接口
 *
 * @author jay
 * @date 2022-09-27
 */
public interface OpusMapper
{
    /**
     * 查询作品
     *
     * @param id 作品主键
     * @return 作品
     */
    Opus selectOpusById(Long id);

    /**
     * 查询作品列表
     *
     * @param opus 作品
     * @return 作品集合
     */
    List<Opus> selectOpusList(Opus opus);

    /**
     * 新增作品
     *
     * @param opus 作品
     * @return 结果
     */
    int insertOpus(Opus opus);

    /**
     * 修改作品
     *
     * @param opus 作品
     * @return 结果
     */
    int updateOpus(Opus opus);

    /**
     * 删除作品
     *
     * @param id 作品主键
     * @return 结果
     */
    int deleteOpusById(Long id);

    /**
     * 批量删除作品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOpusByIds(Long[] ids);

    int passExamine(@Param("id") Long id);

    /**
     * 删除作品素材
     * @param opusCode
     */
    void deleteOpusMaterial(@Param("opusCode") String opusCode);

    /**
     * 添加作品素材
     * @param opusMaterialEntity
     */
    void saveOpusMaterial(@Param("opusMaterialEntity") OpusMaterialEntity opusMaterialEntity);

    /*void changeSelectedStatus(@Param("id") Long id,@Param("selected") Integer selected);*/
}
