import com.joseph.workflow.pojo.WorkflowRequest;
import com.joseph.workflow.pojo.WorkflowResponse;
import com.joseph.workflow.service.SalesOrderService;

/**
 * @author Joseph.Liu
 */
public class TemplateServiceTest {

    public static void main(String[] args) {
        SalesOrderService salesOrderService = new SalesOrderService();

        WorkflowRequest request = new WorkflowRequest();
        request.setStatus("INIT");
        request.setOrderId(12345L);
        WorkflowResponse response = new WorkflowResponse();
        salesOrderService.process(request,response);
    }
}
