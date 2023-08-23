package com.jackqiu.simpleSpring.factory.support;

import com.jackqiu.simpleSpring.BeansException;
import com.jackqiu.simpleSpring.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 真正用来创建Bean对象的Bean工厂对象
 * @author jackqiu
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if(beanDefinition == null){
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }

        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
