package com.lxlib.uavplatform.exception;

/**
 * 系统异常
 *
 * @author chengmanyuan
 * @date 2021/09/10
 */
public class SystemException extends RuntimeException {
    public SystemException() {

    }

    public SystemException(String msg) {
        super(msg);
    }
}
