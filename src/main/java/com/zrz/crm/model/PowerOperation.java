package com.zrz.crm.model;

import javax.persistence.*;

@Table(name = "power_operation")
public class PowerOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "power_id")
    private Integer powerId;

    @Column(name = "operation_id")
    private Integer operationId;

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
     * @return power_id
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * @param powerId
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    /**
     * @return operation_id
     */
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * @param operationId
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
}
