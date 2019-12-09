package com.zrz.crm.mapper;

import com.zrz.crm.config.BaseMapper;
import com.zrz.crm.model.Org;
import com.zrz.crm.service.bo.OrgBo;
import com.zrz.crm.web.vo.OrgVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgMapper extends BaseMapper<Org> {

    /**
     * 查询单位下子单位
     * @param orgId 单位id
     * @return List<OrgBo>
     */
    List<OrgBo> getOrgBoList(@Param("orgId") Integer orgId, @Param("orgName") String orgName);

    /**
     * 查询下级单位
     * @param orgId 单位id
     * @return List<OrgBo>
     */
    List<OrgVo> getOrgVoList(@Param("orgId") Integer orgId);
}
