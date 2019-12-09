package com.zrz.crm.web.controller;

import com.zrz.crm.service.NoticeService;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.web.config.session.SessionUtil;
import com.zrz.crm.web.dto.NoticeDetailDto;
import com.zrz.crm.web.dto.NoticeDto;
import com.zrz.crm.web.param.NoticeParam;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Administrator
 * @desc 公告
 * @date 2019/9/27
 */
@RestController
@RequestMapping(value = "notice", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "公告", tags = {"公告"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @Resource
    private HttpServletRequest request;

    @ApiOperation(value = "获取公告列表", notes = "获取公告列表")
    @GetMapping(value = "/list")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "2729eb76-6c2a-4745-9360-bb256a78a9cd", dataType = "string", required = true, paramType = "query")})
    public List<NoticeDto> getNoticeList() {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        return noticeService.getNoticeList(user.getUnitId());
    }

    @ApiOperation(value = "保存公告", notes = "保存公告")
    @PostMapping("/save")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "2729eb76-6c2a-4745-9360-bb256a78a9cd", dataType = "string", required = true, paramType = "query")})
    public void saveNotice(@ApiParam(value = "公告参数", required = true) NoticeParam noticeParam) {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        noticeService.saveNotice(user, noticeParam);
    }

    @GetMapping("/detail")
    @ApiOperation(value = "获取公告详情", notes = "获取公告详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "2729eb76-6c2a-4745-9360-bb256a78a9cd", dataType = "string", required = true, paramType = "query")})
    public NoticeDetailDto getNoticeById(@ApiParam(value = "公告id", defaultValue = "1", required = true) @RequestParam("id") Integer id) {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        return noticeService.getNoticeById(id);
    }
}
