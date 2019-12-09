package com.zrz.crm.web.controller;

import com.zrz.crm.service.AttrService;
import com.zrz.crm.web.dto.ValueNameDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zrz
 */

@RestController
@RequestMapping(value = "attr", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "属性值", tags = {"属性值"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AttrController {

    @Resource
    private AttrService attrService;

    @ApiOperation(value = "查询属性", notes = "查询属性 attrType device-维护设备 major-专业 maintain-维护内容 ")
    @GetMapping("/find")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "2f6a882905d9e2f723122318c5c74e0b", dataType = "string", required = true, paramType = "query")})
    public List<ValueNameDto> getAttrValue(@RequestParam("attrType") String attrType){
        return attrService.getAttrValue(attrType);
    }
}
