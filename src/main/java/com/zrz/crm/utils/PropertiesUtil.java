package com.zrz.crm.utils;


import com.google.common.collect.Maps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * properties文件读写工具
 *
 * @author qcdl
 * @since 2019/6/5
 */
public class PropertiesUtil {
    private Properties props;
    private URI uri;

    public PropertiesUtil(String fileName) {
        this.readProperties(fileName);
    }

    private void readProperties(String fileName) {
        try {
            this.props = new Properties();
            InputStream fis = this.getClass().getResourceAsStream(fileName);
            this.props.load(fis);
            this.uri = this.getClass().getResource(fileName).toURI();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    public String getProperty(String key) {
        return this.props.getProperty(key);
    }

    public Map<String, String> getAllProperty() {
        Map<String, String> map = Maps.newHashMap();
        Enumeration enu = this.props.propertyNames();

        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = this.props.getProperty(key);
            map.put(key, value);
        }

        return map;
    }

    public void printProperties() {
        this.props.list(System.out);
    }

    public void writeProperties(String key, String value) {
        try {
            OutputStream fos = new FileOutputStream(new File(this.uri));
            this.props.setProperty(key, value);
            this.props.store(fos, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
