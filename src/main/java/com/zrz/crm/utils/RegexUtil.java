package com.zrz.crm.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 常用正则工具
 *
 * @author qcdl
 * @date 2019/6/6
 */
public final class RegexUtil {

  /**
   * 手机号正则表达式
   */
  private static final String PHONE_REGEX = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";

  /**
   * 身份证号正则表达式
   */
  private static final String ID_CARD_REGEX = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";


  private static final String EMAIL_REGEX = "^\\w+@(\\w+\\.)+\\w+$";

  public static boolean checkEmail(String email) {
    if (StringUtils.isNotBlank(email)) {
      return email.matches(EMAIL_REGEX);
    }
    return false;
  }

  /**
   * 手机号校验
   *
   * @param phone 手机号
   * @return true/false
   */
  public static boolean checkPhone(String phone) {
    if (StringUtils.isNotBlank(phone)) {
      return phone.matches(PHONE_REGEX);
    }
    return false;
  }

  /**
   * 身份证校验
   *
   * @param idCard 身份证号
   * @return true/false
   */
  public static boolean checkIdCard(String idCard) {
    return idCard.matches(ID_CARD_REGEX);
  }
}
