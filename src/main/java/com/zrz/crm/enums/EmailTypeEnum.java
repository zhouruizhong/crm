package com.zrz.crm.enums;

import lombok.Getter;

/**
 * @author zrz
 * @desc 邮件类型
 * @date 2019/10/8
 */
@Getter
public enum EmailTypeEnum {

    /**
     * 文本邮件
     */
    EMAIL_TEXT_KEY("email_text_key", "文本邮件"),
    EMAIL_IMAGE_KEY("email_image_key", "图片邮件"),
    EMAIL_FILE_KEY("email_file_key", "文件邮件");

    private String code;
    private String value;

    EmailTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getByCode(String code) {
        EmailTypeEnum[] values = EmailTypeEnum.values();
        for (EmailTypeEnum emailType: values) {
            if (emailType.code.equalsIgnoreCase(code)) {
                return emailType.value;
            }
        }
        return null;
    }

}
