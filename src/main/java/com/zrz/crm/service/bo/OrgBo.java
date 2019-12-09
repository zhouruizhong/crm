package com.zrz.crm.service.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zrz
 * @desc 单位信息
 * @date 2019/10/14
 */
@Data
public class OrgBo implements Serializable {
    /**
     * 编号 主键
     */
    private Integer id;

    /**
     * 单位名称
     */
    private String orgName;

    /**
     * 显示顺序
     */
    private Integer priority;

    /**
     * 父编号
     */
    private Integer parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 是否可用 1 是 0否
     */
    private Boolean available;
}
