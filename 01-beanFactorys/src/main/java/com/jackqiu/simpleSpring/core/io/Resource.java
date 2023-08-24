package com.jackqiu.simpleSpring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载的接口类（主要用于处理资源加载流）
 * @author jackqiu
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
