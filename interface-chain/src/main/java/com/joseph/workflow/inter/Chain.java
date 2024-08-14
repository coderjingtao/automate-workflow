package com.joseph.workflow.inter;

/**
 * @author Joseph.Liu
 */
public interface Chain <T,R>{
    /**
     * 获取请求
     * @return request
     */
    T request();

    /**
     * 处理下一个流程节点
     * @param request 数据请求
     * @return 处理结果
     */
    R next(T request);
}
