package com.zrz.crm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "banner_name")
    private String bannerName;

    /**
     * 封面图
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * BANNER位置(首页、商品分类、大屏)
     */
    @Column(name = "sort_type")
    private Integer sortType;

    /**
     * 数据类型(0:商品 1:商户 2:外链)
     */
    @Column(name = "data_type")
    private Integer dataType;

    /**
     * 数据值
     */
    @Column(name = "data_value")
    private String dataValue;

    /**
     * 排列顺序
     */
    @Column(name = "plain_seq")
    private Integer plainSeq;

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
     * 获取名称
     *
     * @return banner_name - 名称
     */
    public String getBannerName() {
        return bannerName;
    }

    /**
     * 设置名称
     *
     * @param bannerName 名称
     */
    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    /**
     * 获取封面图
     *
     * @return img_url - 封面图
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置封面图
     *
     * @param imgUrl 封面图
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取BANNER位置(首页、商品分类、大屏)
     *
     * @return sort_type - BANNER位置(首页、商品分类、大屏)
     */
    public Integer getSortType() {
        return sortType;
    }

    /**
     * 设置BANNER位置(首页、商品分类、大屏)
     *
     * @param sortType BANNER位置(首页、商品分类、大屏)
     */
    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    /**
     * 获取数据类型(0:商品 1:商户 2:外链)
     *
     * @return data_type - 数据类型(0:商品 1:商户 2:外链)
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 设置数据类型(0:商品 1:商户 2:外链)
     *
     * @param dataType 数据类型(0:商品 1:商户 2:外链)
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取数据值
     *
     * @return data_value - 数据值
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * 设置数据值
     *
     * @param dataValue 数据值
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    /**
     * 获取排列顺序
     *
     * @return plain_seq - 排列顺序
     */
    public Integer getPlainSeq() {
        return plainSeq;
    }

    /**
     * 设置排列顺序
     *
     * @param plainSeq 排列顺序
     */
    public void setPlainSeq(Integer plainSeq) {
        this.plainSeq = plainSeq;
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
}
