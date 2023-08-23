package com.jackqiu.simpleSpring;

/**
 * 通用的Bean的异常类
 * @author jackqiu
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
