package com.jackqiu.simpleSpring.beans.factory.support;

import com.jackqiu.simpleSpring.beans.BeansException;
import com.jackqiu.simpleSpring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 基于Java反射实现的实例化对象策略
 * @author jackqiu
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(String name, BeanDefinition beanDefinition, Constructor constructor, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if(null != constructor) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
