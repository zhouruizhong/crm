package com.zrz.crm.utils;

import com.google.common.collect.Maps;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.util.Map;

/**
 * 七牛云存储工具
 *
 * @author qcdl
 * @date 2019/6/6
 */
public final class QiniuUtil {
  private static final PropertiesUtil QINIU_PRO = new PropertiesUtil("/configs/qiniu.properties");
  private static final Integer EXPIRES;
  private static final String BUCKET;
  private static final String URL;
  private static final Auth AUTH;

  static {
    EXPIRES = Integer.parseInt(QINIU_PRO.getProperty("expires"));
    BUCKET = QINIU_PRO.getProperty("bucket");
    URL = QINIU_PRO.getProperty("url");
    AUTH = Auth.create(QINIU_PRO.getProperty("AK"), QINIU_PRO.getProperty("SK"));
  }

  /**
   * 生成七牛云文件上传token
   *
   * @param body 上传策略要素
   * @return token
   */
  private static String generateToken(Map<String, String> body) {
    StringMap policy = new StringMap();
    policy.put("returnBody", JsonUtil.getInstance().toJsonString(body));
    return AUTH.uploadToken(BUCKET, null, (long) EXPIRES, policy);
  }

  /**
   * 生成七牛云图片上传token
   *
   * @return token
   */
  public static String generatePicToken() {
    Map<String, String> strategy = Maps.newHashMap();
    strategy.put("key", "$(key)");
    strategy.put("hash", "$(etag)");
    strategy.put("w", "$(imageInfo.width)");
    strategy.put("h", "$(imageInfo.height)");

    return generateToken(strategy);
  }

  /**
   * 获取七牛云存储访问域名
   *
   * @return 域名地址
   */
  public static String getUrl() {
    return URL;
  }

}
