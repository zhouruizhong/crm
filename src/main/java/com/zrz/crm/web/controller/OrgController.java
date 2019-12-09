package com.zrz.crm.web.controller;

import com.github.pagehelper.PageInfo;
import com.zrz.crm.service.OrgService;
import com.zrz.crm.service.bo.OrgBo;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.web.config.session.SessionUtil;
import com.zrz.crm.web.dto.OrgDto;
import com.zrz.crm.web.vo.OrgVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zrz
 * @desc 维修单位
 * @date 2019/10/8
 */

@RestController
@RequestMapping("/org")
@Api(value = "单位", tags = {"单位"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OrgController {

    @Resource
    private OrgService orgService;

    @Resource
    private HttpServletRequest request;

    @ApiOperation(value = "维修单位列表", notes = "获取维修单位列表")
    @GetMapping("/list")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "8b52065a-7f54-4125-a466-a18f8146c8ef", dataType = "string", required = true, paramType = "query")})
    public PageInfo<OrgDto> orgListByPage(@ApiParam(value = "页码", defaultValue = "1", required = true) @RequestParam(value = "page", defaultValue = "1") Integer page,
                                          @ApiParam(value = "每页数量", defaultValue = "10", required = true) @RequestParam(value = "size", defaultValue = "10") Integer size,
                                          @ApiParam(value = "单位名称", defaultValue = "") @RequestParam(value = "orgName", defaultValue = "") String orgName) {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        return orgService.orgListByPage(page, size, user, orgName);
    }

    @ApiOperation(value = "施工单位列表", notes = "获取施工单位列表-管理处审核")
    @GetMapping("/query")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "8b52065a-7f54-4125-a466-a18f8146c8ef", dataType = "string", required = true, paramType = "query")})
    public List<OrgVo> queryOrgList() {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        return orgService.queryOrgList(user);
    }

    @ApiOperation(value = "报送单位列表", notes = "获取报送单位列表", hidden = true)
    @GetMapping("/reportOrgList")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "8b52065a-7f54-4125-a466-a18f8146c8ef", dataType = "string", required = true, paramType = "query")})
    public PageInfo<OrgBo> orgList(@ApiParam(value = "页码", defaultValue = "1", required = true) @RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @ApiParam(value = "每页数量", defaultValue = "10", required = true) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        return orgService.reportOrgList(page, size, user);
    }

}
