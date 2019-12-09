package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "group")
public class Group {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组名
     */
    @Column(name = "group_name")
    private String groupName;

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
     * 获取组名
     *
     * @return group_name - 组名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置组名
     *
     * @param groupName 组名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
