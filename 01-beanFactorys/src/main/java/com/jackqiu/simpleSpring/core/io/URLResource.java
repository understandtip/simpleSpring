package com.jackqiu.simpleSpring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author jackqiu
 */
public class URLResource implements Resource {
    public final URL url;

    public URLResource(URL url) {
        Assert.notNull(url, "url must not be null");
        this.url = url;
    }


    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        ;
        try {
            return urlConnection.getInputStream();
        } catch (IOException e) {
            if (urlConnection instanceof HttpURLConnection) {
               ((HttpURLConnection) urlConnection).disconnect();
            }
            throw e;
        }

    }
}
