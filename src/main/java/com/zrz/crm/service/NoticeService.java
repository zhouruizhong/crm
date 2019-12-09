package com.zrz.crm.service;

import com.zrz.crm.mapper.NoticeMapper;
import com.zrz.crm.model.Notice;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.utils.AssertUtil;
import com.zrz.crm.web.config.advice.ExceptionEnum;
import com.zrz.crm.web.dto.NoticeDetailDto;
import com.zrz.crm.web.dto.NoticeDto;
import com.zrz.crm.web.param.NoticeParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zrz
 * @desc 公告
 * @date 2019/9/27
 */
@Service
public class NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private OrgService orgService;

    /**
     * 保存公告
     *
     * @param user        当前登录用户信息
     * @param noticeParam 公告信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveNotice(UserBo user, NoticeParam noticeParam) {
        Notice notice = new Notice();
        BeanUtils.copyProperties(noticeParam, notice);
        notice.setCreateTime(new Date());
        notice.setCreatorId(user.getId());
        notice.setCreatorName(user.getName());
        notice.setCreatorOrgId(user.getUnitId());
        notice.setCreatorOrgName(user.getUnitName());
        noticeMapper.insertSelective(notice);
    }

    /**
     * 查询公告
     *
     * @return List<NoticeDto>
     */
    public List<NoticeDto> getNoticeList(Integer orgId) {
        List<Integer> orgIdList = orgService.getOrgIdList(orgId, null);
        orgIdList.add(orgId);
        return noticeMapper.getNoticeList(orgIdList);
    }

    /**
     * 查询公告详情
     *
     * @param id 公告id
     * @return NoticeDetailDto
     */
    public NoticeDetailDto getNoticeById(Integer id) {
        NoticeDetailDto noticeDetail = noticeMapper.getNoticeDetail(id);
        AssertUtil.notNull(noticeDetail, ExceptionEnum.NoticeNoExists);

        return noticeDetail;
    }

    public void readAllNotice() {


    }

    public void readNotice(Integer noticeId) {

    }
}
