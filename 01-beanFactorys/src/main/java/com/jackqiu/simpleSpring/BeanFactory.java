package com.jackqiu.simpleSpring;

/**
 * Bean工厂对象，用于Bean对象的注册与获取
 * 目前还是接口类，需要在实现类中实现具体的逻辑
 * @author jackqiu
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    /**
     * 可以支持带有参构造器的Bean的实例化
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;
}
