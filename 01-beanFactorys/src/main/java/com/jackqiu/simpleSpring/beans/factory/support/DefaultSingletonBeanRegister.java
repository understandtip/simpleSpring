package com.jackqiu.simpleSpring.beans.factory.support;

import com.jackqiu.simpleSpring.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现了SingletonBeanRegister接口的getSingleton方法，扩展了addSingleton方法
 * @author jackqiu
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object beanObject) {
        singletonObjects.put(beanName, beanObject);
    }
}
