package com.jackqiu.simpleSpring.core.io;

import cn.hutool.core.lang.Assert;
import com.jackqiu.simpleSpring.beans.BeansException;
import com.jackqiu.simpleSpring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jackqiu
 */
public class ClassPathResource implements Resource{
    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"path must not be null");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if(resourceAsStream == null){
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }
}
