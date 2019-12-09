package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "sys_region")
public class SysRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 区域类型(0:省 1:市 2:区)
     */
    private Integer type;

    /**
     * 父级编码
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取区域编码
     *
     * @return code - 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置区域编码
     *
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取区域名称
     *
     * @return name - 区域名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置区域名称
     *
     * @param name 区域名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取区域类型(0:省 1:市 2:区)
     *
     * @return type - 区域类型(0:省 1:市 2:区)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置区域类型(0:省 1:市 2:区)
     *
     * @param type 区域类型(0:省 1:市 2:区)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取父级编码
     *
     * @return parent_code - 父级编码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置父级编码
     *
     * @param parentCode 父级编码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
