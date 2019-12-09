package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "power_file")
public class PowerFile {
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
     * 文件id
     */
    @Column(name = "file_id")
    private Integer fileId;

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
     * 获取文件id
     *
     * @return file_id - 文件id
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置文件id
     *
     * @param fileId 文件id
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}
