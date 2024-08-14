package com.joseph.workflow.inter;

import com.joseph.workflow.pojo.BaseDto;
import com.joseph.workflow.pojo.Request;
import com.joseph.workflow.pojo.Response;

/**
 * 抽象父类,抽取公共逻辑
 * @author Joseph.Liu
 */
public abstract class WorkNode<T extends Request, V extends BaseDto, R extends Response> implements INode<T,V,R>{


    @Override
    public final R process(Chain<T, R> chain) {
        //1.数据过滤器 / 数据校验器
        validator(chain);
        //2.数据预处理器（数据转换）

        //3.API执行器

        //4.数据持久化器

        //5.后置处理器（发送消息或通知）
        return null;
    }

    protected void validator(Chain<T, R> chain){
        //公共校验
        T request = chain.request();
        if(request.getStatus() == null){
            throw new IllegalArgumentException("status must be not null");
        }
        //子类的个性化校验
        customValidator(chain);
    }

    /**
     * 子类的个性化校验
     * @param chain 责任链
     */
    protected abstract void customValidator(Chain<T, R> chain);




}
