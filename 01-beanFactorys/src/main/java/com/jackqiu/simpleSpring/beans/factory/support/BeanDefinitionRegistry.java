package com.jackqiu.simpleSpring.beans.factory.support;

import com.jackqiu.simpleSpring.beans.factory.config.BeanDefinition;

/**
 * @author jackqiu
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);
}
