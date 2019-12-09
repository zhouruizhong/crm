package com.zrz.crm.push;

import com.caucho.hessian.client.HessianProxyFactory;
import com.google.common.collect.Maps;
import com.zrz.crm.utils.PropertiesUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.config.advice.WebException;

import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.Map;

/**
 * @author qcdl
 */
public class PushUtils {

    private final static PushUtils INSTANCE = new PushUtils();

    public static PushUtils getInstance() {
        return INSTANCE;
    }

    private static final PropertiesUtil PUSH_CFG = new PropertiesUtil("/configs/push.properties");
    private static final String URL;
    private static final String ENDPOINT;
    private static final String SUBSCRIBE_URL;

    static {
        URL = PUSH_CFG.getProperty("url");
        ENDPOINT = PUSH_CFG.getProperty("endpoint");
        SUBSCRIBE_URL = PUSH_CFG.getProperty("subscribe.url");
    }

    private PushService deserializeService() {
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            return (PushService) factory.create(PushService.class, URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new WebException(ExceptionEnum.PushServiceError);
    }

    public void pushMsg(String receiver, String msg) {
        String value = deserializeService().pushMsg(receiver, msg);
    }

    private String subscribeUrl(String token) {
        return MessageFormat.format(SUBSCRIBE_URL, token);
    }

    public Map<String, Object> generateSubscribeInfo() {
        Map<String, Object> value = Maps.newHashMap();
        value.put("endpoint", ENDPOINT);
        value.put("subscribeUrl", subscribeUrl("admin"));

        return value;
    }

    public static void main(String[] args) {
        PushUtils.getInstance().pushMsg("admin", "123222123");
    }

}
