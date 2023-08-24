package com.jackqiu.simpleSpring;

import cn.hutool.core.io.IoUtil;
import com.jackqiu.simpleSpring.bean.UserDao;
import com.jackqiu.simpleSpring.bean.UserService;
import com.jackqiu.simpleSpring.beans.PropertyValue;
import com.jackqiu.simpleSpring.beans.PropertyValues;
import com.jackqiu.simpleSpring.beans.factory.config.BeanDefinition;
import com.jackqiu.simpleSpring.beans.factory.config.BeanReference;
import com.jackqiu.simpleSpring.beans.factory.support.DefaultListableBeanFactory;
import com.jackqiu.simpleSpring.beans.factory.xml.XmlBeanDefinitionReader;
import com.jackqiu.simpleSpring.core.io.DefaultResourceLoader;
import com.jackqiu.simpleSpring.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Test
    public void test_BeanFactory() {
        //定义bean对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        //创建Bean工厂，注册Bean对象
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        //第一次获取对象
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService", "jackQiu");
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

    @Test
    public void test_BeanFactoryOptimizing() {
        //定义Bean工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //注册UserDao
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        //定义Bean
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        //注册Bean
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取Bean
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("D:/BaiduNetdiskDownload/workSpace/simpleSpring/01-beanFactorys/src/test/resource/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
                InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
