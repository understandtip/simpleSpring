package com.jackqiu.simpleSpring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jackqiu
 */
public class FileSystemResource implements Resource {

    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        Assert.notNull(file, "file must not be null");
        this.path = file.getPath();
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(path);
    }

    public String getPath() {
        return path;
    }
}
