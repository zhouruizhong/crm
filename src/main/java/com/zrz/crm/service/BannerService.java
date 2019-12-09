package com.zrz.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrz.crm.enums.DeleteFlagEnum;
import com.zrz.crm.mapper.BannerMapper;
import com.zrz.crm.model.Banner;
import com.zrz.crm.web.dto.BannerDto;
import com.zrz.crm.web.param.BannerParam;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author zrz
 */
@Service
public class BannerService {

    @Resource
    private BannerMapper bannerMapper;

    public void addBanner(BannerParam bannerParam) {
        bannerMapper.addBanner(bannerParam);
    }

    public void deleteBanner(Integer bannerId) {
        Banner banner = new Banner();
        banner.setId(bannerId);
        banner.setDeleteFlag(DeleteFlagEnum.DELETED.getCode().byteValue());
        Example example = new Example(Banner.class);
        example.createCriteria().andEqualTo("id", bannerId).andEqualTo("deleteFlag", DeleteFlagEnum.NOT_DELETED.getCode());

        bannerMapper.updateByExampleSelective(banner, example);
    }

    public void updateBanner(Integer bannerId, BannerParam bannerParam) {
        bannerMapper.updateBanner(bannerId, bannerParam);
    }

    public PageInfo<BannerDto> getBannerList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo<>(bannerMapper.getBannerList());
    }

}
