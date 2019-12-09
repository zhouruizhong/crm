package com.zrz.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrz.crm.mapper.*;
import com.zrz.crm.service.bo.OrgBo;
import com.zrz.crm.service.bo.UserBo;
import com.zrz.crm.web.dto.OrgDto;
import com.zrz.crm.web.vo.OrgVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zrz
 * @desc 单位
 * @date 2019/10/8
 */
@Service
public class OrgService {

    @Resource
    private OrgMapper orgMapper;

    /**
     * 查询维修单位列表
     *
     * @param page    页码
     * @param size    每页显示
     * @param user    当前登录用户信息
     * @param orgName 单位名称
     * @return PageInfo<OrgDto>
     */
    public PageInfo<OrgDto> orgListByPage(Integer page, Integer size, UserBo user, String orgName) {
        List<OrgDto> orgDtoList = new ArrayList<>(10);
        PageHelper.startPage(page, size);

        List<OrgBo> orgBoList = getSubOrgBoList(user.getUnitId(), orgName);
        OrgDto orgDto;
        for (OrgBo orgBo : orgBoList) {
            orgDto = new OrgDto();
            orgDto.setOrgId(orgBo.getId());
            orgDto.setOrgName(orgBo.getOrgName());
            System.out.println("单位id" + orgBo.getId());

            // 管理处所有下级单位ID
            List<Integer> orgIdList = getOrgIdList(orgBo.getId(), null);
            orgIdList.add(0);

        }
        return new PageInfo<>(orgDtoList);
    }


    /**
     * 查询下属单位
     *
     * @param parentOrgId 上级单位ID
     * @param orgName     单位名称
     * @return List<OrgBo>
     */
    public List<OrgBo> getOrgBoList(Integer parentOrgId, String orgName) {
        List<OrgBo> orgBos = new ArrayList<>(10);
        List<OrgBo> orgBoList = orgMapper.getOrgBoList(parentOrgId, orgName);
        if (null != orgBoList && orgBoList.size() > 0) {
            orgBos.addAll(orgBoList);
            for (OrgBo orgBo : orgBoList) {
                // 管理处
                orgBoList = orgMapper.getOrgBoList(orgBo.getId(), orgName);
                if (orgBoList.size() > 0) {
                    orgBos.addAll(orgBoList);
                    for (OrgBo orgBo1 : orgBoList) {
                        // 管理局
                        orgBoList = orgMapper.getOrgBoList(orgBo1.getId(), orgName);
                        if (orgBoList.size() > 0) {
                            orgBos.addAll(orgBoList);
                            for (OrgBo orgBo2 : orgBoList) {
                                // 维修公司
                                orgBoList = orgMapper.getOrgBoList(orgBo2.getId(), orgName);
                                if (orgBoList.size() > 0) {
                                    orgBos.addAll(orgBoList);
                                }
                            }
                        }
                    }
                }
            }
        }
        return orgBos;
    }

    /**
     * 查询下属单位
     *
     * @param parentOrgId 上级单位ID
     * @param orgName     单位名称
     * @return List<OrgBo>
     */
    public List<Integer> getOrgIdList(Integer parentOrgId, String orgName) {
        List<Integer> orgIdBos = new ArrayList<>(10);
        List<OrgBo> orgBoList = orgMapper.getOrgBoList(parentOrgId, orgName);
        if (null != orgBoList && orgBoList.size() > 0) {
            orgIdBos.addAll(transList(orgBoList));
            for (OrgBo orgBo : orgBoList) {
                // 管理处
                orgBoList = orgMapper.getOrgBoList(orgBo.getId(), orgName);
                if (orgBoList.size() > 0) {
                    orgIdBos.addAll(transList(orgBoList));
                    for (OrgBo orgBo1 : orgBoList) {
                        // 管理局
                        orgBoList = orgMapper.getOrgBoList(orgBo1.getId(), orgName);
                        if (orgBoList.size() > 0) {
                            orgIdBos.addAll(transList(orgBoList));
                            for (OrgBo orgBo2 : orgBoList) {
                                // 维修公司
                                orgBoList = orgMapper.getOrgBoList(orgBo2.getId(), orgName);
                                if (orgBoList.size() > 0) {
                                    orgIdBos.addAll(transList(orgBoList));
                                }
                            }
                        }
                    }
                }
            }
        }
        return orgIdBos;
    }

    /**
     * 查询下属单位
     *
     * @param parentOrgId 上级单位ID
     * @return List<OrgBo>
     */
    public List<Integer> getOrgIdList(Integer parentOrgId) {
        return getOrgIdList(parentOrgId, "");
    }

    public static List<Integer> transList(List<OrgBo> orgBoList) {
        List<Integer> integerList = new ArrayList<>(10);
        for (OrgBo orgBo : orgBoList) {
            integerList.add(orgBo.getId());
        }
        return integerList;
    }

    /**
     * 查询干线公司下属单位
     *
     * @param parentOrgId 上级单位ID
     * @return List<OrgBo>
     */
    public List<OrgBo> getOrgBoList(Integer parentOrgId) {
        return getOrgBoList(parentOrgId, null);
    }

    /**
     * 查询干线公司下属单位
     *
     * @param parentOrgId 上级单位ID
     * @return List<OrgBo>
     */
    public List<OrgBo> getSubOrgBoList(Integer parentOrgId) {
        return orgMapper.getOrgBoList(parentOrgId, null);
    }

    /**
     * 查询干线公司下属单位
     *
     * @param parentOrgId 上级单位ID
     * @param orgName     单位名称
     * @return List<OrgBo>
     */
    public List<OrgBo> getSubOrgBoList(Integer parentOrgId, String orgName) {
        return orgMapper.getOrgBoList(parentOrgId, orgName);
    }

    public PageInfo<OrgBo> reportOrgList(Integer page, Integer size, UserBo user) {

        // TODO 报送单位查询

        return new PageInfo<>();
    }

    /**
     * 查询施工单位
     *
     * @param user 用户
     * @return PageInfo<OrgDto>
     */
    public List<OrgVo> queryOrgList(UserBo user) {
        // 施工单位
        return orgMapper.getOrgVoList(user.getUnitId());
    }
}
