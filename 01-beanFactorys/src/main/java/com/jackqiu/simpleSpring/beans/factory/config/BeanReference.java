package com.jackqiu.simpleSpring.beans.factory.config;

/**
 * Bean的引用类型，用于存放Bean类型的引用对象
 * @author jackqiu
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
