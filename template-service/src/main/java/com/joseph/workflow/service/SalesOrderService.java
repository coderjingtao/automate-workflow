package com.joseph.workflow.service;

import com.joseph.workflow.inter.AbstractWorkflowService;
import com.joseph.workflow.pojo.WorkflowDto;
import com.joseph.workflow.pojo.WorkflowRequest;
import com.joseph.workflow.pojo.WorkflowResponse;

/**
 * @author Joseph.Liu
 */
public class SalesOrderService extends AbstractWorkflowService<WorkflowRequest, WorkflowDto, WorkflowResponse> {

    @Override
    protected WorkflowDto convert(WorkflowRequest req, WorkflowResponse resp) {
        WorkflowDto workflowDto = new WorkflowDto();
        workflowDto.setNode("SalesOrderService");
        return workflowDto;
    }

    @Override
    protected void customValidate(WorkflowRequest req, WorkflowResponse resp) {
        if(req.getOrderId() == null){
            throw new IllegalArgumentException("order id is null");
        }
    }
}
