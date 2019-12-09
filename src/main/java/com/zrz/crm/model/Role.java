package com.zrz.crm.model;

import javax.persistence.*;

public class Role {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 编号
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 授权的资源
     */
    @Column(name = "resource_ids")
    private String resourceIds;

    /**
     * 是否可用 1是 0否
     */
    private Boolean available;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色描述
     *
     * @return description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取授权的资源
     *
     * @return resource_ids - 授权的资源
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * 设置授权的资源
     *
     * @param resourceIds 授权的资源
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * 获取是否可用 1是 0否
     *
     * @return available - 是否可用 1是 0否
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * 设置是否可用 1是 0否
     *
     * @param available 是否可用 1是 0否
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
