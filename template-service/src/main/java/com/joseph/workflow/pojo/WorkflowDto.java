package com.joseph.workflow.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Joseph.Liu
 */
@Getter
@Setter
@ToString
public class WorkflowDto {
    private Long orderId;
    private String shopName;

    private String node;
}
