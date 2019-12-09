package com.zrz.crm.push;

/**
 * 描述信息
 *
 * @author zrz
 * @date 2019/1/18
 */
public interface PushService {

  /**
   * push msg
   */
  String pushMsg(String receiver, String msg);

}
