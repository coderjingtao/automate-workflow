package com.joseph.workflow.chain;


import com.joseph.workflow.inter.Chain;
import com.joseph.workflow.inter.Node;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Joseph.Liu
 */
@Slf4j
public class SalesOrderChain<T extends Request> implements Chain<T, Response> {

    private final Integer idx;
    private final T request;
    private final List<Node<T,Response>> nodes;

    public SalesOrderChain(Integer idx, T request, List<Node<T,Response>> nodes){
        this.idx = idx;
        this.request = request;
        this.nodes = nodes;
    }

    @Override
    public T request() {
        return this.request;
    }

    @Override
    public Response next(T request) {
        if(idx < 0 || idx >= nodes.size()){
            return Response.builder()
                    .code(404)
                    .status("FAILED")
                    .msg("CANNOT find node")
                    .success(false)
                    .build();
        }
        Node<T, Response> node = this.nodes.get(idx);
        log.info("当前节点：{}", node.getClass().getSimpleName());
        //下一个
        SalesOrderChain<T> nextChain = new SalesOrderChain<>(this.idx + 1, request, this.nodes);
        return node.process(nextChain);
    }
}
