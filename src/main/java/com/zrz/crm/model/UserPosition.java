package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "user_position")
public class UserPosition {
    /**
     * 记录id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 职位id
     */
    @Column(name = "position_id")
    private Integer positionId;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取职位id
     *
     * @return position_id - 职位id
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 设置职位id
     *
     * @param positionId 职位id
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
