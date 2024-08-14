package com.joseph.workflow;

import com.joseph.workflow.chain.HandlerChainManager;
import com.joseph.workflow.constant.WorkflowType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Joseph.Liu
 */
@SpringBootTest
public class SalesOrderWorkflowTest {

    @Autowired
    private HandlerChainManager handlerChainManager;

    @Test
    public void testSalesOrderWorkflow(){
        String result = handlerChainManager.executeHandlers(WorkflowType.SalesOrder, "fake request");
        System.out.println("result = " + result);
    }
}
