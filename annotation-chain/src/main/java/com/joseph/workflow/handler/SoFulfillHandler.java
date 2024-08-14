package com.joseph.workflow.handler;

import com.joseph.workflow.annotations.WorkNode;
import com.joseph.workflow.constant.WorkflowType;
import com.joseph.workflow.inter.IHandler;

/**
 * @author Joseph.Liu
 */
@WorkNode(type = WorkflowType.SalesOrder, order = 2)
public class SoFulfillHandler implements IHandler<String,String> {
    @Override
    public String handle(String s) {
        System.out.println("Add Fulfillment");
        return "success";
    }
}
