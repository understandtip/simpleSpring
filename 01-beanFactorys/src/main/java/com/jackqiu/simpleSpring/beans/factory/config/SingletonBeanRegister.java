package com.jackqiu.simpleSpring.beans.factory.config;

/**
 * 定义注册单例bean的实例
 * @author jackqiu
 */
public interface SingletonBeanRegister {
    Object getSingleton(String beanName);
}
