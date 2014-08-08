package com.jonda.erp.exception;

/**
 * 服务异常，用于事物回滚
 *
 * Created by rejoady on 2014/7/19.
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }
}
