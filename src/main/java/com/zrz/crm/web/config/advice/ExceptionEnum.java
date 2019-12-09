package com.zrz.crm.web.config.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 常用异常信息
 *
 * @author qcdl
 * @date 2019/6/5
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    /**
     * 操作成功
     */
    Success(200, "操作成功"),
    Exception(500, "系统异常"),

    /**
     * 1000
     */
    InValidToken(1000, "登录状态失效"),
    InValidUser(1001, "用户不存在或已被禁用"),
    ExistsUser(1002, "用户已存在"),
    DisableUser(1003, "用户被禁用"),
    IncorrectPhone(1004, "手机号格式错误"),
    IncorrectCodeType(1005, "验证码类型错误"),
    IncorrectNameOrPassword(1006, "用户名或密码错误"),
    IncorrectCode(1007, "验证码错误"),
    NotNullPhone(1043, "手机号不能为空"),
    NotNullPassword(1008, "密码不能为空"),
    NotNullCode(1009, "验证码不能为空"),
    ChangeBindSamePhone(1010, "手机号不能重复绑定"),
    IncorrectType(1011, "类型信息错误"),
    InValidUserType(1012, "用户类型无效"),
    IncorrectClientType(1013, "请使用正确客户端登录"),
    InValidUserCertType(1014, "用户认证类型无效"),

    AlreadyBindPhone(1024, "用户已绑定手机号"),

    NotExistsPhone(1025, "手机号不存在"),

    IncorrectEmail(1026, "邮箱格式错误"),

    PhoneAlreadyRegister(1027, "手机号已被注册"),

    AlreadyRegisterMerchant(1028, "你已注册为商户,请不要重复注册"),

    NeedRegisterMerchant(1029, "你还未注册成为商户,请先注册"),

    NeedCheckMerchant(1029, "商户等待审核或已审核成功"),

    GoodNumLimit(1030, "受不了了,商品不能再少了"),

    GoodNumZero(1031, "商品数量不能为零"),

    GoodStockLack(1032, "商品库存不足"),

    NotBindPhone(1033, "用户未绑定手机"),

    NotChangePhone(1034, "更换手机号请先验证旧手机号"),

    NotExistPhone(1035, "手机号未绑定用户"),

    PhoneNotRegister(1036, "手机号未注册商户"),

    ChangePhoneNeedNew(1037, "请使用新手机号进行绑定"),

    AlreadyRegisterMerchantUser(1038, "你已注册为商户账号,请不要重复注册"),

    NotCheckMerchant(1039, "商户尚未审核通过"),

    waitRefund(1040, "商户已申请退押金或系统审核中"),

    MerchantBindPhone(1041, "商户已绑定手机号"),

    waitDepositRefund(1042, "商户暂未申请退款或已经退款"),
    NotExistRecord(1044, "记录不存在"),
    NotNullMobile(1045, "手机号码不能为空"),
    /**
     * 2000
     */
    InValidCouponStatus(2001, "优惠券状态无效"),
    CouponNoExists(2002, "优惠券不存在"),
    MerchantNoExists(2003, "商户不存在或已被禁用"),
    GoodsNoExists(2004, "商品不存在或者已下架"),
    GoodsCatalogNoExists(2005, "商品分类信息不存在"),
    GoodsOrderInValid(2006, "订单信息无效,请稍后重试!"),

    GoodsOrderCancel(2007, "订单已取消或已被删除!"),

    GoodsOrderDelete(2008, "当前状态下的订单不允许被删除"),

    GoodsOrderReceipt(2009, "当前状态下的订单不允许确认收货"),

    GoodsCatalogNotConfig(2010, "未配置商品分类信息"),

    SortTypeNotExist(2011, "分类信息不存在"),

    BannerNoExists(2101, "BANNER信息不存在"),
    InValidBannerType(2102, "BANNER类型无效"),
    InValidTemplate(2103, "模板信息无效"),
    InValidModule(2104, "模块信息无效"),


    NewsNoExists(2100, "资讯信息不存在"),
    NoticeNoExists(2105, "公告信息不存在或已被删除"),
    ReportNoExists(2106, "您的报修信息不存在"),


    OrderConsigneeInValid(3001, "订单收货信息无效"),
    OrderGoodsInValid(3002, "订单商品信息无效"),
    OrderGoodsFail(3003, "订单生成失败,请稍后重试!"),

    OrderGoodsDelivery(3004, "请选择订单配送方式!"),

    InvalidOrderGoodsDelivery(3004, "订单配送方式无效,请重新选择"),

    NotConfigMerchantDeposit(3005, "系统未配置商户入驻押金"),

    NotConfigMerchantUrl(3006, "系统未配置商户平台地址"),

    waitDeliveryJustRefund(3007, "待收货状态下售后只支持退款"),

    invalidRefundOrder(3008, "退货单信息无效"),

    refundOrderExpressRepeat(3009, "请不要重复填写发货信息"),

    bankcardSame(3010, "银行卡不能相同，请绑定新的银行卡"),

    remindLimit(3011, "今日提醒已达上限"),

    mchPhoneError(3012, "请使用注册商户时填写的手机号"),

    NotPermission(111, "您没有权限访问！"),
    /**
     * 5000
     */
    ServiceError(5500, "系统服务异常"),

    ServiceErrorSms(5501, "短信服务异常"),

    /**
     * 50000
     */
    PushServiceError(50001, "推送服务异常");

    private Integer code;

    private String msg;

}
