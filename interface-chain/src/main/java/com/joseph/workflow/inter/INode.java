package com.joseph.workflow.inter;


import com.joseph.workflow.pojo.BaseDto;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;

/**
 * @author Joseph.Liu
 */
public interface INode<T extends Request, V extends BaseDto, R extends Response> {

    R process(Chain<T,R> chain);
}
