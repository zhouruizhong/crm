package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "power")
public class Power {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限类型
     */
    @Column(name = "power_type")
    private String powerType;

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
     * 获取权限类型
     *
     * @return power_type - 权限类型
     */
    public String getPowerType() {
        return powerType;
    }

    /**
     * 设置权限类型
     *
     * @param powerType 权限类型
     */
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }
}
