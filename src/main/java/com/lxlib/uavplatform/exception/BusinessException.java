package com.lxlib.uavplatform.exception;

/**
 * 业务异常
 *
 * @author chengmanyuan
 * @date 2021/09/10
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {

    }

    public BusinessException(String msg) {
        super(msg);
    }
}
