package com.haojue.biz.service;

import java.util.List;
import com.haojue.biz.domain.Opus;

/**
 * 作品Service接口
 *
 * @author jay
 * @date 2022-09-27
 */
public interface IOpusService
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
     * 批量删除作品
     *
     * @param ids 需要删除的作品主键集合
     * @return 结果
     */
    int deleteOpusByIds(Long[] ids);

    /**
     * 删除作品信息
     *
     * @param id 作品主键
     * @return 结果
     */
    int deleteOpusById(Long id);

    /**
     * 修改
     * @return
     */
    int changeSelectedStatus(Opus opus);


    /**
     * 设置商品上架
     * @param opus
     * @return
     */
    int changeSuperiorStatus(Opus opus);


    /**
     * 审核通过
     * @param id
     * @return
     */
    int passExamine(Long id);
}
