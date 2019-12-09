package com.zrz.crm.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "attr_value")
public class AttrValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attr_type_id")
    private Integer attrTypeId;

    private String code;

    private String name;

    private String status;

    @Column(name = "sort_id")
    private Integer sortId;

    private String parent;

    private String remark;

    @Column(name = "delete_flag")
    private String deleteFlag;

    @Column(name = "update_id")
    private Integer updateId;

    @Column(name = "update_name")
    private String updateName;

    @Column(name = "update_time")
    private Date updateTime;

}
