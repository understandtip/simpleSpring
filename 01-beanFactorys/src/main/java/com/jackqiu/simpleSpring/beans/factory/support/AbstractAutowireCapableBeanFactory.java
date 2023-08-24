package com.jackqiu.simpleSpring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.jackqiu.simpleSpring.beans.BeansException;
import com.jackqiu.simpleSpring.beans.PropertyValue;
import com.jackqiu.simpleSpring.beans.PropertyValues;
import com.jackqiu.simpleSpring.beans.factory.config.BeanDefinition;
import com.jackqiu.simpleSpring.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 实现了createBean创建Bean对象的逻辑
 *
 * @author jackqiu
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CGlibInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            //需要进行属性填充
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Failed to create an instance of the bean", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                Object value = propertyValue.getValue();
                String name = propertyValue.getName();
                if(value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e) {
            throw new BeansException("setting propertyValue of bean failed: " + beanName);
        }

    }

    protected Object createBeanInstance(String name, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(name, beanDefinition, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
