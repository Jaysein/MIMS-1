package com.json.util;

import java.io.*;
import java.util.Properties;

public class PropertyUtil {
    private static Properties props;
    static {
        loadProps();
    }

    synchronized static private void loadProps(){
        System.out.println("��ʼ����properties�ļ�����.......");
        props = new Properties();
        InputStream in = null;
        InputStreamReader ir = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream("/usrcloud.properties");
            ir = new InputStreamReader(in,"utf-8");
            props.load(ir);
        } catch (FileNotFoundException e) {
            System.out.println("usrcloud.properties�ļ�δ�ҵ�");
        } catch (IOException e) {
            System.out.println("����IOException");
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("usrcloud.properties�ļ����رճ����쳣");
            }
        }
        System.out.println("����properties�ļ��������...........");
        System.out.println("properties�ļ����ݣ�" + props);
    }

    /**
     * ����key��ȡ�����ļ��е�����
     */
    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    /**
     * ����key��ȡ�����ļ��е����ԣ���Ϊnullʱ����ָ����Ĭ��ֵ
     */
    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}