package com.jackqiu.simpleSpring.core.io;

/**
 * @author jackqiu
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
