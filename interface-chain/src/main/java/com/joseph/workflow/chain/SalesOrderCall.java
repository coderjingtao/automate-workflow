package com.joseph.workflow.chain;

import com.joseph.workflow.inter.Call;
import com.joseph.workflow.inter.Node;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;

import java.util.List;

/**
 * 连接SalesOrderWorkflow和SalesOrderChain(nodes)的桥梁
 * @author Joseph.Liu
 */
public class SalesOrderCall<T extends Request> implements Call<T, Response> {

    private final T request;
    private final List<Node<T,Response>> nodes;

    public SalesOrderCall(T request, List<Node<T,Response>> nodes){
        this.request = request;
        this.nodes = nodes;
    }

    @Override
    public T request() {
        return this.request;
    }

    @Override
    public Response execute() {
        //从第0个节点开始执行责任链
        SalesOrderChain<T> chain = new SalesOrderChain<>(0, request, nodes);
        return chain.next(request);
    }
}
