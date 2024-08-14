package com.joseph.workflow.config;

import com.joseph.workflow.chain.HandlerChainManager;
import com.joseph.workflow.inter.IHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Joseph.Liu
 */
@Configuration
public class WorkflowConfig {

    @Bean
    public HandlerChainManager handlerChainManager(List<IHandler> handlers){
        HandlerChainManager handlerChainManager = new HandlerChainManager();
        handlerChainManager.assembleHandlers(handlers);
        return handlerChainManager;
    }
}
