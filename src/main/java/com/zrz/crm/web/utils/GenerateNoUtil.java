package com.zrz.crm.web.utils;

import com.zrz.crm.enums.NumberTypeEnum;
import com.zrz.crm.utils.DateUtils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zrz
 * @desc 单号生成器
 * @date 2019/10/8
 */
public class GenerateNoUtil {

    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 生成故障单号
     * @return String
     */
    public static String generate(String generateType){
        String generate = "";
        try {
            lock.lock();
            // 故障单号
            if (NumberTypeEnum.REPORT_VALUE.endsWith(generateType)) {
                String prefix = com.zrz.crm.utils.DateUtils.getTimeString(com.zrz.crm.utils.DateUtils.DATE_YYYYMMDD.substring(1,7), new Date());
                String suffix = (new Random().nextInt(10000)+1000)+"";
                generate = prefix + suffix;
            }

            // 工单号
            if (NumberTypeEnum.AUDIT_VALUE.endsWith(generateType)) {
                String prefix = com.zrz.crm.utils.DateUtils.getTimeString(com.zrz.crm.utils.DateUtils.DATE_YYYYMMDD.substring(1,7), new Date());
                String suffix = (new Random().nextInt(1000)+100)+"";
                generate = prefix + suffix;
            }

            // 反馈工单号
            if (NumberTypeEnum.FEEDBACK_VALUE.endsWith(generateType)) {
                String prefix = com.zrz.crm.utils.DateUtils.getTimeString(com.zrz.crm.utils.DateUtils.DATE_YYYYMMDD.substring(2,7), new Date());
                String suffix = (new Random().nextInt(100)+10)+"";
                generate = prefix + suffix;
            }

            // 维修计划
            if (NumberTypeEnum.MAINTAIN_VALUE.endsWith(generateType)) {
                String prefix = com.zrz.crm.utils.DateUtils.getTimeString(DateUtils.DATE_YYYYMMDD.substring(1,7), new Date());
                String suffix = (new Random().nextInt(100)+10)+"";
                generate = prefix + suffix;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return generate;
    }
}
