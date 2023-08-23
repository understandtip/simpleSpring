package com.jackqiu.simpleSpring.factory.support;

import com.jackqiu.simpleSpring.BeanFactory;
import com.jackqiu.simpleSpring.BeansException;
import com.jackqiu.simpleSpring.factory.config.BeanDefinition;

/**
 * 实现了getBean方法的逻辑
 * @author jackqiu
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory{

    @Override
    public Object getBean(String name) {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    protected <T> T doGetBean(final String name,final Object[] args){
        Object object = getSingleton(name);
        if(object != null){//单例池中有对应的实例对象，则从单例池中取出实例对象
            return (T) object;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);//获取Bean相关信息
        return (T) createBean(name, beanDefinition, args);//创建Bean
    }

    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition ,Object[] args);
}
