package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "user_org")
public class UserOrg {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 机构id
     */
    @Column(name = "org_id")
    private Integer orgId;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取机构id
     *
     * @return org_id - 机构id
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 设置机构id
     *
     * @param orgId 机构id
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
