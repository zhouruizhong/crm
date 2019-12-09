package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "operation_name")
    private String operationName;

    @Column(name = "operation_code")
    private String operationCode;

    private String ljurlqz;

    @Column(name = "parent_id")
    private Integer parentId;

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
     * @return operation_name
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * @param operationName
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * @return operation_code
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * @param operationCode
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    /**
     * @return ljurlqz
     */
    public String getLjurlqz() {
        return ljurlqz;
    }

    /**
     * @param ljurlqz
     */
    public void setLjurlqz(String ljurlqz) {
        this.ljurlqz = ljurlqz;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
