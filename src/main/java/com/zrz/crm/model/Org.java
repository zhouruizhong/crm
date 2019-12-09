package com.zrz.crm.model;

import javax.persistence.*;

public class Org {
    /**
     * 编号 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 显示顺序
     */
    private Integer priority;

    /**
     * 父编号
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 父编号列表
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 是否可用 1 是 0否
     */
    private Boolean available;

    /**
     * 获取编号 主键
     *
     * @return id - 编号 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号 主键
     *
     * @param id 编号 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取单位名称
     *
     * @return org_name - 单位名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置单位名称
     *
     * @param orgName 单位名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取显示顺序
     *
     * @return priority - 显示顺序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置显示顺序
     *
     * @param priority 显示顺序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取父编号
     *
     * @return parent_id - 父编号
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父编号列表
     *
     * @return parent_ids - 父编号列表
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置父编号列表
     *
     * @param parentIds 父编号列表
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取是否可用 1 是 0否
     *
     * @return available - 是否可用 1 是 0否
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * 设置是否可用 1 是 0否
     *
     * @param available 是否可用 1 是 0否
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
