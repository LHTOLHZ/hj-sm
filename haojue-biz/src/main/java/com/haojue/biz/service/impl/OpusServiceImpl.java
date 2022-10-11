package com.haojue.biz.service.impl;

import com.haojue.biz.mapper.OpusMaterialMapper;
import com.haojue.common.entity.OpusMaterialEntity;
import com.haojue.common.utils.StringUtils;
import com.haojue.common.utils.uuid.Seq;

import java.util.*;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haojue.biz.mapper.OpusMapper;
import com.haojue.biz.domain.Opus;
import com.haojue.biz.service.IOpusService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作品Service业务层处理
 *
 * @author jay
 * @date 2022-09-27
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OpusServiceImpl implements IOpusService {
    private final OpusMapper opusMapper;

    private final OpusMaterialMapper opusMaterialMapper;

    /**
     * 查询作品
     *
     * @param id 作品主键
     * @return 作品
     */
    @Override
    public Opus selectOpusById(Long id) {
        Opus opus = opusMapper.selectOpusById(id);
        List<OpusMaterialEntity> list = opusMaterialMapper.getOpusCode(opus.getCode());
        opus.setDepositImg(getMaterial(list, 0, opus));
        opus.setDepositVideo(getMaterial(list, 1, opus));
        return opus;
    }

    private String getMaterial(List<OpusMaterialEntity> list, Integer type, Opus opus) {
        StringBuffer urlBuffer = new StringBuffer();
        List<String> strs = new ArrayList<>();
        if (list != null && list.size() > 0) {
            int index = 0;
            for (OpusMaterialEntity opusMaterialEntity : list) {
                if (type == opusMaterialEntity.getType()) {
                    String url = opusMaterialEntity.getUrl();
                    if (StringUtils.isNotBlank(url)) {
                        strs.add(url);
                        if (StringUtils.isNotBlank(urlBuffer.toString())) {
                            urlBuffer.append(",");
                        }
                        urlBuffer.append(url);
                    }
                }
                index = index + 1;
            }
        }


        if (strs.size() > 0) {
            if (type == 0) {
                opus.setDepositImgs(strs.toArray(new String[strs.size()]));
            } else {
                opus.setDepositVideos(strs.toArray(new String[strs.size()]));
            }
        }

        return urlBuffer.toString();
    }


    /**
     * 查询作品列表
     *
     * @param opus 作品
     * @return 作品
     */
    @Override
    public List<Opus> selectOpusList(Opus opus) {
        return opusMapper.selectOpusList(opus);
    }

    /**
     * 新增作品
     *
     * @param opus 作品
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertOpus(Opus opus) {
        opus.setCode(Seq.getId());
        this.setOpusMaterial(opus);
        return opusMapper.insertOpus(opus);
    }

    /**
     * 修改作品
     *
     * @param opus 作品
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateOpus(Opus opus) {
        opusMaterialMapper.deleteOpusMaterial(opus.getCode());
        this.setOpusMaterial(opus);
        return opusMapper.updateOpus(opus);
    }

    private void setOpusMaterial(Opus opus) {
        String opusCode = opus.getCode();
        String imgs = opus.getDepositImg();
        String videos = opus.getDepositVideo();
        String[] imagess = this.split(imgs, ",");
        List<OpusMaterialEntity> opusMaterialEntities = new ArrayList<>();
        if (imagess != null && imagess.length > 0) {
            for (int index = 0; index < imagess.length; index++) {
                String imgUrl = imagess[index];
                if (index == 0) {
                    //默认取图片的第一张为封面图
                    opus.setCover(imgUrl);
                }
                OpusMaterialEntity opusMaterialEntity = new OpusMaterialEntity();
                opusMaterialEntity.setOpusCode(opusCode);
                opusMaterialEntity.setType(0);
                opusMaterialEntity.setUrl(imgUrl);
                opusMaterialEntities.add(opusMaterialEntity);
            }
        }
        String[] videoss = this.split(videos, ",");
        if (videoss != null && videoss.length > 0) {
            List<String> videoList = Arrays.asList(videoss);
            Set<String> set = videoList.stream().collect(Collectors.toSet());
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String videoUrl = it.next();
                OpusMaterialEntity opusMaterialEntity = new OpusMaterialEntity();
                opusMaterialEntity.setOpusCode(opusCode);
                opusMaterialEntity.setType(1);
                opusMaterialEntity.setUrl(videoUrl);
                opusMaterialEntities.add(opusMaterialEntity);
            }
        }
        if (opusMaterialEntities != null && opusMaterialEntities.size() > 0) {
            for (OpusMaterialEntity opusMaterialEntity : opusMaterialEntities) {
                opusMaterialMapper.saveOpusMaterial(opusMaterialEntity);
            }
        }
    }


    private String[] split(String val, String split) {
        if (StringUtils.isNoneBlank(val)) {
            return val.split(split);//Arrays.asList();
        }
        return null;
    }


    /**
     * 批量删除作品
     *
     * @param ids 需要删除的作品主键
     * @return 结果
     */
    @Override
    public int deleteOpusByIds(Long[] ids) {
        return opusMapper.deleteOpusByIds(ids);
    }

    /**
     * 删除作品信息
     *
     * @param id 作品主键
     * @return 结果
     */
    @Override
    public int deleteOpusById(Long id) {
        return opusMapper.deleteOpusById(id);
    }

    /**
     * 修改 精选 非精选
     *
     * @return
     */
    @Override
    public int changeSelectedStatus(Opus opus) {
        return opusMapper.updateOpus(opus);
    }

    @Override
    public int changeSuperiorStatus(Opus opus) {
        return opusMapper.updateOpus(opus);
    }

    @Override
    public int passExamine(Long id) {
        return opusMapper.passExamine(id);
    }
}
