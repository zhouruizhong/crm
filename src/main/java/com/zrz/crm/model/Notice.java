package com.zrz.crm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "notice")
public class Notice {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 创建人
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 创建人单位id
     */
    @Column(name = "creator_org_id")
    private Integer creatorOrgId;

    /**
     * 创建人单位名称
     */
    @Column(name = "creator_org_name")
    private String creatorOrgName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 删除标识(0: 已删除 1:正常)
     */
    @Column(name = "delete_flag")
    private Byte deleteFlag;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 内容
     */
    private String content;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return creator_name - 创建人
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置创建人
     *
     * @param creatorName 创建人
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     * 获取创建人单位id
     *
     * @return creator_org_id - 创建人单位id
     */
    public Integer getCreatorOrgId() {
        return creatorId;
    }

    /**
     * 设置创建人单位id
     *
     * @param creatorOrgId 创建人单位id
     */
    public void setCreatorOrgId(Integer creatorOrgId) {
        this.creatorOrgId = creatorOrgId;
    }

    /**
     * 获取创建人单位
     *
     * @return creator_name - 创建人单位
     */
    public String getCreatorOrgName() {
        return creatorOrgName;
    }

    /**
     * 设置创建人单位
     *
     * @param creatorOrgName 创建人单位
     */
    public void setCreatorOrgName(String creatorOrgName) {
        this.creatorOrgName = creatorOrgName;
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
     * 获取删除标识(0: 已删除 1:正常)
     *
     * @return delete_flag - 删除标识(0: 已删除 1:正常)
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标识(0: 已删除 1:正常)
     *
     * @param deleteFlag 删除标识(0: 已删除 1:正常)
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
