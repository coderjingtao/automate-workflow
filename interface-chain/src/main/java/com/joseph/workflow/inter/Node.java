package com.joseph.workflow.inter;

/**
 * @author Joseph.Liu
 */
public interface Node <T,R>{
    /**
     * 处理节点
     * @param chain 包含该节点的责任链，方便传递给下一个责任链节点
     * @return 处理结果
     */
    R process(com.joseph.workflow.inter.Chain<T,R> chain);
}
