package com.joseph.workflow.node;


import com.joseph.workflow.annotations.SalesOrderNode;
import com.joseph.workflow.inter.Chain;
import com.joseph.workflow.inter.Node;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joseph.Liu
 */
@Slf4j
@SalesOrderNode(NODE_ID = com.joseph.newnetsuite.constant.WorkFlowNodes.SalesOrderNodes.ADD_INVOICE)
public class SalesOrderInvoiceNode<T extends Request> implements Node<T, Response> {
    @Override
    public Response process(Chain<T, Response> chain) {
        //处理本节点的任务
        log.info("==================执行Sales Order Invoice Node开始=========");
        T request = chain.request();
        request.setStatus("SO_INVOICE");
        System.out.println(request.getStatus());
        log.info("==================执行Sales Order Invoice Node结束=========");

        //进入下一个责任链的节点
        return chain.next(request);
    }
}
