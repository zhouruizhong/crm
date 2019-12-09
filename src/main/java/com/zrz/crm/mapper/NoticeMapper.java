package com.zrz.crm.mapper;

import com.zrz.crm.config.BaseMapper;
import com.zrz.crm.model.Notice;
import com.zrz.crm.web.dto.NoticeDetailDto;
import com.zrz.crm.web.dto.NoticeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zrz
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取公告列表
     * @param orgIdList 单位ID
     * @return List<NoticeDto>
     */
    List<NoticeDto> getNoticeList(@Param("orgIdList") List<Integer> orgIdList);

    /**
     * 查询公告详情
     * @param id 公告id
     * @return NoticeDetailDto
     */
    NoticeDetailDto getNoticeDetail(@Param("id") Integer id);
}
