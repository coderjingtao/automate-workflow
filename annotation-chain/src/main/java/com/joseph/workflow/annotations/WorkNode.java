package com.joseph.workflow.annotations;

import com.joseph.workflow.constant.WorkflowType;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author Joseph.Liu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Service
public @interface WorkNode {
    /**
     * 相同的type类型的bean，会被放到一个责任链集合中
     * @return chain type
     */
    WorkflowType type();

    /**
     * 排序：数值越小，排序越前
     * @return order number
     */
    int order() default 0;
}
