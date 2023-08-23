package com.jackqiu.simpleSpring.factory.support;

import com.jackqiu.simpleSpring.factory.config.BeanDefinition;

/**
 * @author jackqiu
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
