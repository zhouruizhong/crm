package com.zrz.crm.service.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qcdl
 */
@Data
public class UserBo implements Serializable {
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private Integer type;
    private String name;
    private Integer sex;
    private String email;
    private Integer unitId;
    private String unitName;
    private Integer departmentId;
    private String departmentName;
    private Integer positionId;
    private String positionName;
    private String portrait;
}
