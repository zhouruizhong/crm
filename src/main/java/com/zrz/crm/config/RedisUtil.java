package com.zrz.crm.config;

import com.google.common.collect.Lists;
import com.zrz.crm.utils.JsonUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * REDIS工具
 *
 * @author qcdl
 * @date 2019/6/7
 */
@Component
public class RedisUtil {

    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void save(@Nonnull String key, @Nonnull String objKey, Object data) {
        stringRedisTemplate.opsForHash().put(key, objKey, JsonUtil.getInstance().toJsonString(data));

    }

    public Long increment(@Nonnull String key, @Nonnull String objKey, int num) {
        return stringRedisTemplate.opsForHash().increment(key, objKey, num);
    }


    public void clear(@Nonnull String key, @Nonnull String objKey) {
        if (hasKey(key, objKey)) {
            stringRedisTemplate.opsForHash().delete(key, objKey);
        }
    }

    public void clearBatch(@Nonnull String key, @Nonnull Object[] objKey) {
        stringRedisTemplate.opsForHash().delete(key, objKey);
    }

    public boolean hasKey(@Nonnull String key, @Nonnull String objKey) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(objKey)) {
            Boolean hasKey = stringRedisTemplate.hasKey(key);
            if (hasKey != null) {
                return hasKey && stringRedisTemplate.opsForHash().hasKey(key, objKey);
            }
        }
        return false;
    }

    public boolean hasCacheKey(@Nonnull String key) {
        if (StringUtils.isNotBlank(key)) {
            Boolean hasKey = stringRedisTemplate.hasKey(key);
            if (hasKey != null) {
                return hasKey;
            }
        }
        return false;
    }

    public String get(@Nonnull String key, @Nonnull String objKey) {
        if (hasKey(key, objKey)) {
            return (String) stringRedisTemplate.opsForHash().get(key, objKey);
        }
        return null;
    }

    public String getRandomValue(@Nonnull String key) {
        List<Object> objects = stringRedisTemplate.opsForHash().values(key);
        Collections.shuffle(objects);

        return (String) objects.get(0);
    }

    public void saveList(@Nonnull String key, @Nonnull Collection<String> data) {
        stringRedisTemplate.opsForList().rightPushAll(key, data);
    }

    public String lPop(@Nonnull String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    public void rPush(@Nonnull String key, @Nonnull String data) {
        stringRedisTemplate.opsForList().rightPush(key, data);
    }

    public int size(@Nonnull String key) {
        Long size = stringRedisTemplate.opsForList().size(key);
        if (size != null) {
            return size.intValue();
        }
        return 0;
    }

    public boolean clearKey(@Nonnull String key) {
        Boolean hasDelete = stringRedisTemplate.delete(key);
        return Boolean.TRUE.equals(hasDelete);
    }

    public boolean hasKey(@Nonnull String key) {
        Boolean hasKey = stringRedisTemplate.hasKey(key);
        return Boolean.TRUE.equals(hasKey);
    }

    public void setsSave(@Nonnull String key, String... values) {
        stringRedisTemplate.opsForSet().add(key, values);
    }

    public int setsSize(@Nonnull String key) {
        Long size = stringRedisTemplate.opsForSet().size(key);
        if (size != null) {
            return size.intValue();
        }
        return 0;
    }

    public void setsClear(@Nonnull String key, Object[] values) {
        stringRedisTemplate.opsForSet().remove(key, values);
    }

    public List<String> setsAll(@Nonnull String key) {
        List<String> memberList = Lists.newArrayList();
        Set<String> members = stringRedisTemplate.opsForSet().members(key);
        if (!CollectionUtils.isEmpty(members)) {
            memberList.addAll(members);
        }
        return memberList;
    }

    public String setsRandomMember(@Nonnull String key) {
        return stringRedisTemplate.opsForSet().randomMember(key);
    }

    public List<String> setsRandomMembers(@Nonnull String key, int count) {
        return stringRedisTemplate.opsForSet().randomMembers(key, count);
    }

    public String setsPop(@Nonnull String key) {
        return stringRedisTemplate.opsForSet().pop(key);
    }

    public void expire(@Nonnull String key, long time) {
        stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    public void valueSaveEx(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public boolean valueHasKey(String key) {
        if (StringUtils.isNotBlank(key)) {
            Boolean hasKey = stringRedisTemplate.hasKey(key);
            return hasKey != null && hasKey;
        }
        return false;
    }

    public boolean valueCheck(String key, String value) {
        String cacheValue = stringRedisTemplate.opsForValue().get(key);
        boolean equalsFlag = Objects.equals(cacheValue, value);
        if (equalsFlag) {
            stringRedisTemplate.delete(key);
        }
        return equalsFlag;
    }

    public List<String> hScan(@Nonnull String key, @Nonnull String match, Integer count) {
        List<String> value = Lists.newArrayList();
        if (hasCacheKey(key)) {
            ScanOptions.ScanOptionsBuilder scanOptionsBuilder = ScanOptions.scanOptions().match(match);
            if (count != null) {
                scanOptionsBuilder.count(new Long(count));
            }
            stringRedisTemplate.opsForHash().scan(key, scanOptionsBuilder.build()).forEachRemaining(obj -> {
                value.add((String) obj.getValue());
            });
        }
        return value;
    }


}
