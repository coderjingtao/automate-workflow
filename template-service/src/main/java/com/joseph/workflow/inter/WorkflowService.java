package com.joseph.workflow.inter;

import com.joseph.workflow.pojo.WorkflowDto;
import com.joseph.workflow.pojo.WorkflowRequest;
import com.joseph.workflow.pojo.WorkflowResponse;

/**
 *  public logic for the implementation of WorkflowService
 *  T is the WorkflowRequest class or its subclass, it is sent by client
 *  V is the WorkflowDto class or its subclass, T will be transferred to V, which is for persistence in DB
 *  R is the WorkflowResponse class or its subclass, which is the result of current sub service for next service
 * @author Joseph.Liu
 */
public interface WorkflowService<T extends WorkflowRequest, V extends WorkflowDto, R extends WorkflowResponse> {

    R process(T request, R response);
}
