package com.jackqiu.simpleSpring;

import com.jackqiu.simpleSpring.bean.UserService;
import com.jackqiu.simpleSpring.factory.config.BeanDefinition;
import com.jackqiu.simpleSpring.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //定义bean对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        //创建Bean工厂，注册Bean对象
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        //第一次获取对象
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService","jackQiu");
        userService.queryUserInfo();
        System.out.println(userService);
    }

    @Test
    public void test_BeanFactoryOptimize() {
        //定义bean对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        //创建Bean工厂，注册Bean对象
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        //第一次获取对象
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();
        System.out.println(userService);

        //第二次获取对象
        UserService userService1 = (UserService) defaultListableBeanFactory.getBean("userService");
        userService1.queryUserInfo();
        System.out.println(userService1);
    }
}
