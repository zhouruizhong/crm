package com.zrz.crm.web.controller;

import com.zrz.crm.service.UserService;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.web.config.session.SessionConstant;
import com.zrz.crm.web.config.session.SessionUtil;
import com.zrz.crm.web.dto.UserDto;
import com.zrz.crm.web.param.LoginParam;
import com.zrz.crm.web.param.UserParam;
import com.zrz.crm.web.param.UserResetParam;
import com.zrz.crm.web.param.UserUpdateParam;
import com.zrz.crm.web.utils.CookieUtil;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zrz
 * @desc 用户
 * @date 2019/9/28
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户", tags = {"用户"}, protocols = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Resource
    private HttpServletResponse response;

    @Resource
    private HttpServletRequest request;

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/save")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "5c33a84f-8be8-4516-b6c5-2bf0698e2a2c", dataType = "string", required = true, paramType = "query")})
    public void save(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) UserParam userParam){
        UserDto user = SessionUtil.getUser(request, UserDto.class);
        userService.save(user, userParam);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping(value = "/login")
    public UserDto login(@ApiParam(value = "用户登录参数", required = true) @RequestBody LoginParam loginParam) {
        UserDto user = userService.login(loginParam);
        CookieUtil.addCookie(response, SessionConstant.OAUTH_KEY, user.getToken(), -1);
        return user;
    }

    @ApiOperation(value = "用户重置密码", notes = "用户重置密码")
    @PostMapping(value = "/reset")
    public void resetPassword(@ApiParam(value = "用户重置密码参数", required = true) @RequestBody UserResetParam resetParam) {
        userService.resetPassword(resetParam.getPhone(), resetParam.getCode(), resetParam.getPassword());
        CookieUtil.removeCookie(response, SessionConstant.OAUTH_KEY);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PostMapping("/update")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "a432c37cdffcb2506f4caa1daf02c06a", dataType = "string", required = true, paramType = "query")})
    public void update(@ApiParam(value = "更新用户信息参数", required = true) @RequestBody UserUpdateParam userParam) {
        UserBo user = SessionUtil.getUser(request, UserBo.class);
        userService.update(userParam, user.getId());
    }

    @ApiOperation(value = "用户登出", notes = "用户登出")
    @PostMapping("/logout")
    @ApiImplicitParams({@ApiImplicitParam(name = "ACCESS_TOKEN", value = "接口调用凭证", defaultValue = "2f6a882905d9e2f723122318c5c74e0b", dataType = "string", required = true, paramType = "query")})
    public void logout() {
        String token = SessionUtil.getToken(request);
        if (StringUtils.isNotBlank(token)) {
            SessionUtil.delete(request);
            CookieUtil.removeCookie(response, SessionConstant.OAUTH_KEY);
        }
    }

}
