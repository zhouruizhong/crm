package com.zrz.crm.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.common.collect.Maps;
import com.zrz.crm.enums.CodeTypeEnum;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Objects;

/**
 * 阿里云短信
 *
 * @author qcdl
 * @date 2019/6/6
 */
public final class SmsUtil {

    private static final PropertiesUtil SMS_PRO = new PropertiesUtil("/configs/sms.properties");
    private static final String ACCESS_KEY_ID;
    private static final String ACCESS_KEY_SECRET;
    private static final String PRODUCT;
    private static final String DOMAIN;
    private static final String SIGN_NAME;
    private static final String COMMON_SIGN_NAME;
    private static final String REGION_ID;
    private static final String TEMPLATE_CHANGE_PASSWORD;
    private static final boolean PROD_MODE;

    static {
        ACCESS_KEY_ID = SMS_PRO.getProperty("sms.accessKeyId");
        ACCESS_KEY_SECRET = SMS_PRO.getProperty("sms.accessKeySecret");
        PRODUCT = SMS_PRO.getProperty("sms.default.product");
        DOMAIN = SMS_PRO.getProperty("sms.default.domain");
        SIGN_NAME = SMS_PRO.getProperty("sms.sign");
        COMMON_SIGN_NAME = SMS_PRO.getProperty("sms.common.sign");
        REGION_ID = SMS_PRO.getProperty("sms.default.region");

        TEMPLATE_CHANGE_PASSWORD = SMS_PRO.getProperty("sms.template.changePassword");

        PROD_MODE = Boolean.parseBoolean(SMS_PRO.getProperty("prod.mode"));
    }

    public static void sendSms(String phone, String code, String templateCode) {
        try {
            IClientProfile profile = DefaultProfile.getProfile(REGION_ID, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            DefaultProfile.addEndpoint(REGION_ID, PRODUCT, DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setPhoneNumbers(phone);
            request.setTemplateCode(templateCode);
            request.setSignName(COMMON_SIGN_NAME);

            HashMap<String, String> params = Maps.newHashMap();
            if (StringUtils.isNotBlank(code)) {
                params.put("code", code);
                request.setTemplateParam(JsonUtil.getInstance().toJsonString(params));
                request.setSignName(SIGN_NAME);
            }
            SendSmsResponse smsResponse = acsClient.getAcsResponse(request);
            if (smsResponse == null || !Objects.equals(smsResponse.getCode(), "OK")) {
                if (smsResponse != null) {
                    System.out.println(JsonUtil.getInstance().toJsonString(smsResponse));
                }
                throw new WebException(ExceptionEnum.ServiceErrorSms);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebException(ExceptionEnum.ServiceErrorSms);
        }
    }

    public static void sendSms(String phone, String code, CodeTypeEnum codeTypeEnum) {
        switch (codeTypeEnum) {
            case ChangePassword:
                sendSms(phone, code, TEMPLATE_CHANGE_PASSWORD);
                break;
            default:
                break;
        }
    }

    public static String generateSmsKey(String codeTypeValue, String phone) {
        return "SMS_" + codeTypeValue + "_" + phone;
    }

    public static boolean isProdMode() {
        return PROD_MODE;
    }


}
