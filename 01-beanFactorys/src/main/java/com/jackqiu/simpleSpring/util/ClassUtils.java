package com.jackqiu.simpleSpring.util;

import java.io.InputStream;

/**
 * @author jackqiu
 */
public class ClassUtils {
    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        if(classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
