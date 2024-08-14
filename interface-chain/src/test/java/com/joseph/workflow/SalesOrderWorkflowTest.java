package com.joseph.workflow;

import com.joseph.workflow.inter.Workflow;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Joseph.Liu
 */
@SpringBootTest
public class SalesOrderWorkflowTest {

    @Autowired
    private Workflow<Request, Response> saleOrderWorkflow;

    @Test
    public void testSalesOrderWorkflow(){
        Request request = Request.builder()
                .name("joseph")
                .status("imported")
                .build();

        Response finalResponse = saleOrderWorkflow.start(request);
        System.out.println("finalResponse = " + finalResponse);
    }
}
