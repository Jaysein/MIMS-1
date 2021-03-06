package com.json.util;

import java.io.*;
import java.util.Properties;

public class PropertyUtil {
    private static Properties props;
    static {
        loadProps();
    }

    synchronized static private void loadProps(){
        System.out.println("开始加载properties文件内容.......");
        props = new Properties();
        InputStream in = null;
        InputStreamReader ir = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream("/usrcloud.properties");
            ir = new InputStreamReader(in,"utf-8");
            props.load(ir);
        } catch (FileNotFoundException e) {
            System.out.println("usrcloud.properties文件未找到");
        } catch (IOException e) {
            System.out.println("出现IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("usrcloud.properties文件流关闭出现异常");
            }
        }
        System.out.println("加载properties文件内容完成...........");
        System.out.println("properties文件内容：" + props);
    }

    /**
     * 根据key获取配置文件中的属性
     */
    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    /**
     * 根据key获取配置文件中的属性，当为null时返回指定的默认值
     */
    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}