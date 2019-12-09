package com.zrz.crm.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "operation_log")
public class OperationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "operation_type_id")
    private Integer operationTypeId;

    @Column(name = "operation_content")
    private String operationContent;

    @Column(name = "operation_user_id")
    private Integer operationUserId;

    @Column(name = "operation_time")
    private Date operationTime;

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
     * @return operation_type_id
     */
    public Integer getOperationTypeId() {
        return operationTypeId;
    }

    /**
     * @param operationTypeId
     */
    public void setOperationTypeId(Integer operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    /**
     * @return operation_content
     */
    public String getOperationContent() {
        return operationContent;
    }

    /**
     * @param operationContent
     */
    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    /**
     * @return operation_user_id
     */
    public Integer getOperationUserId() {
        return operationUserId;
    }

    /**
     * @param operationUserId
     */
    public void setOperationUserId(Integer operationUserId) {
        this.operationUserId = operationUserId;
    }

    /**
     * @return operation_time
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * @param operationTime
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}
