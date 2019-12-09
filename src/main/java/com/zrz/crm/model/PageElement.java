package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "page_element")
public class PageElement {
    /**
     * 页面
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 元素名称
     */
    @Column(name = "element_name")
    private String elementName;

    /**
     * 获取页面
     *
     * @return id - 页面
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置页面
     *
     * @param id 页面
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取元素名称
     *
     * @return element_name - 元素名称
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * 设置元素名称
     *
     * @param elementName 元素名称
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
}
