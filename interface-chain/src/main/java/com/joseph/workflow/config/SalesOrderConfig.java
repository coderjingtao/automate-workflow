package com.joseph.workflow.config;

import com.joseph.workflow.annotations.SalesOrderNode;
import com.joseph.workflow.inter.Node;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Joseph.Liu
 */
public class SalesOrderConfig {

    @Resource
    protected List<Node> nodes;

    protected static final Map<Integer, Node> SALES_ORDER_NODE_MAP = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        nodes.forEach(node -> {
            //查找接口Node实现类上有没有SalesOrderNode注解
            SalesOrderNode anno = AnnotationUtils.findAnnotation(node.getClass(), SalesOrderNode.class);
            if(Objects.nonNull(anno)){
                SALES_ORDER_NODE_MAP.put(anno.NODE_ID().getNodeNo(),node);
            }
        });
    }
}
