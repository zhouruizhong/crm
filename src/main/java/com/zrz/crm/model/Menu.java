package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "menu")
public class Menu {
    /**
     * 记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单路径
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 父菜单id
     */
    @Column(name = "parent_id")
    private Integer parentId;

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
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单路径
     *
     * @return menu_url - 菜单路径
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单路径
     *
     * @param menuUrl 菜单路径
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取父菜单id
     *
     * @return parent_id - 父菜单id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单id
     *
     * @param parentId 父菜单id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
