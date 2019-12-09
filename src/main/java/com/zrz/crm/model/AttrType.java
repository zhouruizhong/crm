package com.zrz.crm.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "attr_type")
public class AttrType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    private String status;

    @Column(name = "update_id")
    private Integer updateId;

    @Column(name = "update_name")
    private String updateName;

    @Column(name = "update_time")
    private Date updateTime;

}
