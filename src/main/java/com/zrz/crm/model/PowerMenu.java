package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "power_menu")
public class PowerMenu {
    /**
     * 主键
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
     * 菜单id
     */
    @Column(name = "menu_id")
    private Integer menuId;

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
     * 获取菜单id
     *
     * @return menu_id - 菜单id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
