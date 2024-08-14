package com.joseph.workflow.inter;

/**
 * @author Joseph.Liu
 */
public interface IHandler<T,R> {

    R handle(T t);
}
