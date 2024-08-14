package com.joseph.workflow.inter;

/**
 * @author Joseph.Liu
 */
public interface Workflow<T,R> {

    /**
     * 工作流的开始方法
     * @param request 请求参数
     * @return 处理结果
     */
    R start(T request);
}
