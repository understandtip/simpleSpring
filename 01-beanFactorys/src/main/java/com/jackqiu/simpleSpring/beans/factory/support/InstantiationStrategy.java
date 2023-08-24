package com.jackqiu.simpleSpring.beans.factory.support;

import com.jackqiu.simpleSpring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 创建Bean的策略接口
 * @author jackqiu
 */
public interface InstantiationStrategy {
    Object instantiate(String name, BeanDefinition beanDefinition, Constructor constructor, Object[] args);
}
