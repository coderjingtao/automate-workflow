package com.joseph.workflow.annotations;

import com.joseph.newnetsuite.constant.WorkFlowNodes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Joseph.Liu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RefundNode {
    WorkFlowNodes.RefundNodes NODE_ID();
}
