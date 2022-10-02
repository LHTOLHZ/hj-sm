package com.haojue.web.controller.biz;

import com.haojue.biz.domain.Opus;
import com.haojue.biz.service.IOpusService;
import com.haojue.common.annotation.Log;
import com.haojue.common.core.controller.BaseController;
import com.haojue.common.core.domain.AjaxResult;
import com.haojue.common.core.page.TableDataInfo;
import com.haojue.common.enums.BusinessType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询作品列表
     */
    @PreAuthorize("@ss.hasPermi('biz:opus:list')")
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
    @PreAuthorize("@ss.hasPermi('biz:opus:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(opusService.selectOpusById(id));
    }

    /**
     * 新增作品
     */
    @PreAuthorize("@ss.hasPermi('biz:opus:add')")
    @Log(title = "作品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Opus opus) {

        return toAjax(opusService.insertOpus(opus));
    }

    /**
     * 修改作品
     */
    @PreAuthorize("@ss.hasPermi('biz:opus:edit')")
    @Log(title = "作品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Opus opus) {
        return toAjax(opusService.updateOpus(opus));
    }

    /**
     * 设置精选
     *
     * @param opus
     * @return
     */
    @PreAuthorize("@ss.hasPermi('biz:opus:edit')")
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
    @PreAuthorize("@ss.hasPermi('biz:opus:edit')")
    @Log(title = "作品", businessType = BusinessType.UPDATE)
    @PutMapping("/changeSuperiorStatus")
    public AjaxResult changeSuperiorStatus(@RequestBody Opus opus) {
        return toAjax(opusService.changeSuperiorStatus(opus));
    }

    @PreAuthorize("@ss.hasPermi('biz:opus:edit')")
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

}
