package com.zrz.crm.web.controller;

import com.zrz.crm.push.PushUtils;
import com.zrz.crm.service.NoticeService;
import com.zrz.crm.utils.JsonUtil;
import com.zrz.crm.web.dto.NoticeDto;
import com.zrz.crm.web.dto.PushConfigDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author qcdl
 * @date 2019/8/9
 */
@RestController
@RequestMapping(value = "/push")
@Api(value = "推送通知相关接口", tags = {"推送通知相关接口"}, protocols = MediaType.APPLICATION_JSON_VALUE)
public class PushController {

    @Resource
    private NoticeService noticeService;

    @ApiOperation(value = "推送订阅", notes = "推送订阅", hidden = true)
    @GetMapping("/subscribe")
    public PushConfigDto subscribe() {
        Map<String, Object> result = PushUtils.getInstance().generateSubscribeInfo();
        return JsonUtil.getInstance().toJsonObj(result, PushConfigDto.class);
    }

    @ApiOperation(value = "获取通知列表", notes = "获取通知列表", hidden = true)
    @GetMapping("/")
    public List<NoticeDto> getNoticeInfoList() {
        return null;
    }

    @ApiOperation(value = "设置全部通知为已读状态", notes = "设置全部通知为已读状态", hidden = true)
    @PutMapping("/")
    public void readAllNotice() {
        noticeService.readAllNotice();
    }

    @ApiOperation(value = "设置单个通知为已读状态", notes = "设置单个通知为已读状态", hidden = true)
    @PutMapping("/{noticeId}")
    public void readNotice(@ApiParam("通知ID") @PathVariable(value = "noticeId") Integer noticeId) {
        noticeService.readNotice(noticeId);
    }

}
