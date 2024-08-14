package com.joseph.workflow.chain;

import com.joseph.workflow.annotations.WorkNode;
import com.joseph.workflow.constant.WorkflowType;
import com.joseph.workflow.inter.IHandler;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Joseph.Liu
 */
public class HandlerChainManager {

    private Map<WorkflowType, List<IHandler>> handlerMap;

    public void assembleHandlers(List<IHandler> handlers){
        handlerMap = handlers
                .stream()
                .sorted(Comparator.comparingInt(handler -> Objects.requireNonNull(AnnotationUtils.findAnnotation(handler.getClass(), WorkNode.class)).order()))
                .collect(Collectors.groupingBy(handler -> Objects.requireNonNull(AnnotationUtils.findAnnotation(handler.getClass(), WorkNode.class)).type()));
    }

    public <T,R> R executeHandlers(WorkflowType type, T request){
        List<IHandler> handlers = handlerMap.get(type);
        R response = null;
        if(!CollectionUtils.isEmpty(handlers)){
            for (IHandler<T,R> handler : handlers) {
                response = handler.handle(request);
            }
        }
        return response;
    }
}
