package com.zrz.crm.mapper;

import com.zrz.crm.config.BaseMapper;
import com.zrz.crm.model.Banner;
import com.zrz.crm.web.dto.BannerDto;
import com.zrz.crm.web.param.BannerParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 增加横幅
     *
     * @param bannerParam
     */
    void addBanner(@Param("bannerParam") BannerParam bannerParam);

    /**
     * 更新横幅表（banner）信息
     *
     * @param bannerId
     * @param bannerParam
     */
    void updateBanner(@Param(value = "bannerId") Integer bannerId, @Param("bannerParam") BannerParam bannerParam);

    /**
     * 获取横幅列表
     *
     * @return
     */
    List<BannerDto> getBannerList();
}
