package com.zrz.crm.model;

import java.util.Date;
import javax.persistence.*;

public class Position {
    /**
     * 记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 职位
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 描述
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
     * 创建人单温名称
     */
    @Column(name = "create_org_name")
    private String createOrgName;

    /**
     * 删除标志 1是 0否
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 获取记录id
     *
     * @return id - 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置记录id
     *
     * @param id 记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取职位
     *
     * @return name - 职位
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职位
     *
     * @param name 职位
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取编号
     *
     * @return code - 编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编号
     *
     * @param code 编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
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
     * 获取创建人单温名称
     *
     * @return create_org_name - 创建人单温名称
     */
    public String getCreateOrgName() {
        return createOrgName;
    }

    /**
     * 设置创建人单温名称
     *
     * @param createOrgName 创建人单温名称
     */
    public void setCreateOrgName(String createOrgName) {
        this.createOrgName = createOrgName;
    }

    /**
     * 获取删除标志 1是 0否
     *
     * @return delete_flag - 删除标志 1是 0否
     */
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标志 1是 0否
     *
     * @param deleteFlag 删除标志 1是 0否
     */
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
