package com.haojue.web.controller.biz;

import com.haojue.biz.domain.InfoSubmitVO;
import com.haojue.biz.domain.Opus;
import com.haojue.biz.domain.OpusComment;
import com.haojue.biz.domain.OpusCommentVO;
import com.haojue.biz.service.IOpusService;
import com.haojue.biz.service.OpusCommentService;
import com.haojue.common.annotation.Log;
import com.haojue.common.core.controller.BaseController;
import com.haojue.common.core.domain.AjaxResult;
import com.haojue.common.core.domain.model.LoginUser;
import com.haojue.common.core.page.TableDataInfo;
import com.haojue.common.enums.BusinessType;
import com.haojue.common.utils.DateUtils;
import com.haojue.common.utils.StringUtils;
import com.haojue.common.utils.http.HttpIPUtil;
import com.haojue.web.core.config.SwaggerConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作品Controller
 *
 * @author jay
 * @date 2022-09-27
 */
@RestController
@RequestMapping("/biz/opus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OpusController extends BaseController {

    private final IOpusService opusService;

    private final OpusCommentService opusCommentServiceImpl;



    private final SwaggerConfig swaggerConfig;


    /**
     * 查询作品列表
     */
    /*@PreAuthorize("@ss.hasPermi('biz:opus:list')")*/
    @GetMapping("/list")
    public TableDataInfo list(Opus opus) {
        startPage();
        List<Opus> list = opusService.selectOpusList(opus);
        if (list != null && list.size() > 0) {
            for (Opus opus1 : list) {
                opus1.setTrString("12/79/10");
            }
        }
        return getDataTable(list);
    }

    @GetMapping("/examine/page")
    public TableDataInfo examinePage(Opus opus) {
        startPage();
        opus.setState(4);
        List<Opus> list = opusService.selectOpusList(opus);
        return getDataTable(list);
    }


    /**
     * 获取作品详细信息
     */
    /*@PreAuthorize("@ss.hasPermi('biz:opus:query')")*/
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(opusService.selectOpusById(id));
    }

    /**
     * 新增作品
     */
   /* @PreAuthorize("@ss.hasPermi('biz:opus:add')")*/
    @Log(title = "作品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Opus opus, HttpServletRequest request) {
        String ip = HttpIPUtil.getIpAddress(request);
        opus.setIp(ip);
        opus.setCreateBy(getUsername());
        return toAjax(opusService.insertOpus(opus));
    }

    /**
     * 修改作品
     */
    /*@PreAuthorize("@ss.hasPermi('biz:opus:edit')")*/
    @Log(title = "作品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Opus opus, HttpServletRequest request) {
        String ip = HttpIPUtil.getIpAddress(request);
        opus.setIp(ip);
        opus.setUpdateBy(getUsername());
        return toAjax(opusService.updateOpus(opus));
    }

    /**
     * 设置精选
     *
     * @param opus
     * @return
     */
   /* @PreAuthorize("@ss.hasPermi('biz:opus:edit')")*/
    @Log(title = "作品", businessType = BusinessType.UPDATE)
    @PutMapping("/changeSelectedStatus")
    public AjaxResult changeSelectedStatus(@RequestBody Opus opus) {
        return toAjax(opusService.changeSelectedStatus(opus));
    }


    /**
     * 设置上架
     *
     * @param opus
     * @return
     */
   /* @PreAuthorize("@ss.hasPermi('biz:opus:edit')")*/
    @Log(title = "作品", businessType = BusinessType.UPDATE)
    @PutMapping("/changeSuperiorStatus")
    public AjaxResult changeSuperiorStatus(@RequestBody Opus opus) {
        return toAjax(opusService.changeSuperiorStatus(opus));
    }

    /*@PreAuthorize("@ss.hasPermi('biz:opus:edit')")*/
    @GetMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        return AjaxResult.success(opusService.deleteOpusById(id));
    }

    /**
     * 审核通过
     *
     * @param id
     * @return
     */
    @GetMapping("/examine/data/{id}")
    public AjaxResult examineState(@PathVariable("id") Long id) {
        return AjaxResult.success(opusService.passExamine(id));
    }

    /**
     * 评论列表
     *
     * @return
     */
    @GetMapping("/comment/pageList")
    public TableDataInfo commentPageList(OpusCommentVO opusComment) {
        startPage();
        List<OpusCommentVO> list = opusCommentServiceImpl.getPageList(opusComment, super.getLoginUserName());
        return getDataTable(list);
    }

    /**
     * 修改是否展示
     *
     * @param opusComment
     * @return
     */
    @PostMapping("/comment/changeViewStatus")
    public AjaxResult changeViewStatus(@RequestBody OpusCommentVO opusComment) {
        return AjaxResult.success(opusCommentServiceImpl.updateViewState(opusComment.getCommentCode(), opusComment.getView()));
    }

    /**
     * 删除评论
     *
     * @param commentCode
     * @return
     */
    @GetMapping("/comment/delete/{commentCode}")
    public AjaxResult commentDelete(@PathVariable("commentCode") String commentCode) {
        return AjaxResult.success(opusCommentServiceImpl.deleteByCommentCOde(commentCode));
    }

    /**
     * 通过作品Id获取当前作品的评论信息 列表
     *
     * @param opusCommentVO
     * @return
     */
    @GetMapping("/comment/getDetailPage")
    public TableDataInfo getDetailPage(OpusCommentVO opusCommentVO) {
        startPage();
        List<OpusCommentVO> list =
                opusCommentServiceImpl.getCommentDetailPage(opusCommentVO.getOpusId());
        if (list != null && list.size() > 0) {
            for (OpusCommentVO opusComment : list) {
                if (StringUtils.isNotBlank(opusComment.getUserUrl())) {
                    opusComment.setUserUrl(swaggerConfig.getPathMapping() + "/" + opusComment.getUserUrl());
                }
            }
        }
        return getDataTable(list);
    }

    /**
     * 获取查看评论详情信息单个主体
     *
     * @param id
     * @return
     */
    @GetMapping("/comment/getInfo/{id}")
    public AjaxResult commnetInfo(@PathVariable("id") Long id) {
        OpusCommentVO vo = opusCommentServiceImpl.commentInfo(id);
        if (vo != null && StringUtils.isNotBlank(vo.getUserUrl())) {
            vo.setUserUrl("/dev-api/" + vo.getUserUrl());
        }
        return AjaxResult.success(vo);
    }

    /**
     * 获取当前登陆人
     *
     * @return
     */
    @GetMapping("/comment/getLoginUserInfo")
    public AjaxResult getLoginUserInfo() {
        LoginUser loginUser = super.getLoginUser();
        return AjaxResult.success(loginUser.getUser());
    }


    /**
     * 填写评论
     */
    @PostMapping("/comment/infoSubmit")
    public AjaxResult infoSubmit(@RequestBody InfoSubmitVO submitVO, HttpServletRequest request) {
        Long opusId = submitVO.getId();
        Opus opus = opusService.selectOpusById(opusId);
        OpusComment opusComment = new OpusComment();
        opusComment.setOpusCode(opus.getCode());
        LoginUser loginUser = super.getLoginUser();
        String nickName = loginUser.getUser().getNickName();
        String userName = (StringUtils.isNotBlank(nickName))?nickName:loginUser.getUser().getUserName();
        opusComment.setUserName(userName);
        opusComment.setUserEmail(loginUser.getUser().getEmail());
        opusComment.setIp(HttpIPUtil.getIpAddress(request));
        opusComment.setRemark(submitVO.getRemark());
        opusComment.setUserId(loginUser.getUser().getUserId());
        opusComment.setCommentCode(DateUtils.dateTimeNow() + "_" + loginUser.getUser().getUserId());
        return AjaxResult.success(opusCommentServiceImpl.save(opusComment));
    }


}
