package com.jackqiu.simpleSpring.beans.factory.support;

import com.jackqiu.simpleSpring.beans.BeansException;
import com.jackqiu.simpleSpring.core.io.Resource;
import com.jackqiu.simpleSpring.core.io.ResourceLoader;

/**
 * @author jackqiu
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
