package com.joseph.workflow.inter;

/**
 * @author Joseph.Liu
 */
public interface Call <T,R>{
    /**
     * 获取请求
     * @return request
     */
    T request();

    /**
     * 执行请求
     * @return response
     */
    R execute();
}
