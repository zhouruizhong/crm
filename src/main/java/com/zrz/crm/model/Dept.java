package com.zrz.crm.model;

import java.util.Date;
import javax.persistence.*;

public class Dept {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编号
     */
    private String code;

    /**
     * 部门描述
     */
    private String description;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人单位ID
     */
    @Column(name = "create_org_id")
    private Integer createOrgId;

    /**
     * 创建人单位名称
     */
    @Column(name = "create_org_name")
    private String createOrgName;

    /**
     * 是否删除 1是 0否
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取部门编号
     *
     * @return code - 部门编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置部门编号
     *
     * @param code 部门编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取部门描述
     *
     * @return description - 部门描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置部门描述
     *
     * @param description 部门描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人单位ID
     *
     * @return create_org_id - 创建人单位ID
     */
    public Integer getCreateOrgId() {
        return createOrgId;
    }

    /**
     * 设置创建人单位ID
     *
     * @param createOrgId 创建人单位ID
     */
    public void setCreateOrgId(Integer createOrgId) {
        this.createOrgId = createOrgId;
    }

    /**
     * 获取创建人单位名称
     *
     * @return create_org_name - 创建人单位名称
     */
    public String getCreateOrgName() {
        return createOrgName;
    }

    /**
     * 设置创建人单位名称
     *
     * @param createOrgName 创建人单位名称
     */
    public void setCreateOrgName(String createOrgName) {
        this.createOrgName = createOrgName;
    }

    /**
     * 获取是否删除 1是 0否
     *
     * @return delete_flag - 是否删除 1是 0否
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置是否删除 1是 0否
     *
     * @param deleteFlag 是否删除 1是 0否
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
