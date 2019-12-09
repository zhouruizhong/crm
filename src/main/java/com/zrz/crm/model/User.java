package com.zrz.crm.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码颜值
     */
    private String salt;

    /**
     * 账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)
     */
    private Integer type;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别 0:未知  1:男  2:女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 单位ID
     */
    @Column(name = "unit_id")
    private Integer unitId;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 职位ID
     */
    @Column(name = "position_id")
    private Integer positionId;

    /**
     * 是否管理员
     */
    @Column(name = "is_admin")
    private Integer isAdmin;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 删除标识(0: 已删除/禁用 1:正常)
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码颜值
     *
     * @return salt - 密码颜值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码颜值
     *
     * @param salt 密码颜值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)
     *
     * @return type - 账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)
     *
     * @param type 账号类型(0:干线公司 1:管理局 2:管理处 3:维修公司 4:维修人员)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取性别 0:未知  1:男  2:女
     *
     * @return sex - 性别 0:未知  1:男  2:女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0:未知  1:男  2:女
     *
     * @param sex 性别 0:未知  1:男  2:女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取头像
     *
     * @return portrait - 头像
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 设置头像
     *
     * @param portrait 头像
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * 获取单位ID
     *
     * @return unit_id - 单位ID
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 设置单位ID
     *
     * @param unitId 单位ID
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取部门ID
     *
     * @return department_id - 部门ID
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门ID
     *
     * @param departmentId 部门ID
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取职位ID
     *
     * @return position_id - 职位ID
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 设置职位ID
     *
     * @param positionId 职位ID
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取是否管理员
     *
     * @return is_admin - 是否管理员
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置是否管理员
     *
     * @param isAdmin 是否管理员
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取最后更新时间
     *
     * @return update_time - 最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * 获取最后登录时间
     *
     * @return login_time - 最后登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param loginTime 最后登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取删除标识(0: 已删除/禁用 1:正常)
     *
     * @return delete_flag - 删除标识(0: 已删除/禁用 1:正常)
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标识(0: 已删除/禁用 1:正常)
     *
     * @param deleteFlag 删除标识(0: 已删除/禁用 1:正常)
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
