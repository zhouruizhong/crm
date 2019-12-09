package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "power_page")
public class PowerPage {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限id
     */
    @Column(name = "power_id")
    private Integer powerId;

    /**
     * 页面id
     */
    @Column(name = "page_id")
    private Integer pageId;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限id
     *
     * @return power_id - 权限id
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * 设置权限id
     *
     * @param powerId 权限id
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    /**
     * 获取页面id
     *
     * @return page_id - 页面id
     */
    public Integer getPageId() {
        return pageId;
    }

    /**
     * 设置页面id
     *
     * @param pageId 页面id
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }
}
