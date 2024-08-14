package com.joseph.workflow.annotations;

import com.joseph.newnetsuite.constant.WorkFlowNodes;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Joseph.Liu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface SalesOrderNode {
    WorkFlowNodes.SalesOrderNodes NODE_ID();
}
