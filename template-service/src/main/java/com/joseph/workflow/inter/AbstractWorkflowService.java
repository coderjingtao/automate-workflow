package com.joseph.workflow.inter;

import com.joseph.workflow.pojo.WorkflowDto;
import com.joseph.workflow.pojo.WorkflowRequest;
import com.joseph.workflow.pojo.WorkflowResponse;

/**
 * Template Method:
 *
 * All methods input and output parameters are generic types.
 * This ensures that when subclasses extend, they can use custom implementations
 * @author Joseph.Liu
 */
public abstract class AbstractWorkflowService<T extends WorkflowRequest, V extends WorkflowDto, R extends WorkflowResponse>
        implements WorkflowService<T,V,R>{

    @Override
    public R process(T request, R response) {
        //1. validator
        validate(request, response);
        //2. pre-process
        V dto = preprocess(request, response);
        //3. persistence
        persistence(request, dto, response);
        //4. post event
        postHandler(request, dto, response);
        return response;
    }

    /**
     * step 1 : validator
     */
    protected void validate(T req, R resp){
        // 1.1 public validator
        if(req.getStatus() == null){
            throw new IllegalArgumentException("Status is null");
        }
        // 1.2 custom validator
        customValidate(req,resp);
    }
    protected void customValidate(T req, R resp){}

    /**
     * step 2 : pre-process
     */
    protected V preprocess(T req, R resp){
        //2.1 convert T to V, e.g. retrieve id from db
        V dto = convert(req, resp);
        //2.2 set public attributes to DTO
        dto.setOrderId(req.getOrderId());
        dto.setShopName("AMZN");
        //2.3 set custom preprocess logic
        customPreprocess(req, dto, resp);
        System.out.println(dto);
        return dto;
    }

    /**
     * the logic to convert to DTO for subclasses implementation
     * @param req request
     * @param resp response
     * @return dto
     */
    protected abstract V convert(T req, R resp);

    protected void customPreprocess(T req, V dto, R resp){}

    /**
     * step 3 : persistence
     */
    protected void persistence(T req, V dto, R resp){
        //public persistence

        //custom persistence
        customPersistence(req, dto, resp);
    }
    protected void customPersistence(T req, V dto, R resp){

    }

    /**
     * step 4 : post Event Message, e.g. notifications, process Response
     */
    protected void postHandler(T req, V dto, R resp){
        System.out.println("Post Event: "+ req.getOrderId());
        resp.setCode(200);
        resp.setMessage("success : "+ req.getOrderId());
    }
}
