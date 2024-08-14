package com.joseph.workflow.chain;

import com.joseph.workflow.config.SalesOrderConfig;
import com.joseph.workflow.inter.Node;
import com.joseph.workflow.inter.Workflow;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joseph.Liu
 */
@Component
@Slf4j
public class SalesOrderWorkflow<T extends Request> extends SalesOrderConfig implements Workflow<T, Response> {

    @Override
    public Response start(T request) {
        List<Node<T,Response>> salesOrderNodes = new ArrayList<>();
        //获取排序后的结果，保证责任链的顺序（hashmap中如果key是数字，通过hashcode编码后是有序的）
        for(Integer nodeNum : SALES_ORDER_NODE_MAP.keySet()){
            salesOrderNodes.add(SALES_ORDER_NODE_MAP.get(nodeNum));
        }

        log.info("[Sales Order Workflow] start...");
        System.out.println();
        return new SalesOrderCall<>(request,salesOrderNodes).execute();
    }
}
