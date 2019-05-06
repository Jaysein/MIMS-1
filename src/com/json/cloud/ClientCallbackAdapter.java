package com.json.cloud;


import cn.usr.UsrCloudMqttCallbackAdapter;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.json.util.SQLHelp;
import com.json.util.TranscodeUtil;

public class ClientCallbackAdapter extends UsrCloudMqttCallbackAdapter {
	
    private int connectFlag;
    private int subscribeFalg;
    private String tmp = "";
    private double temp = 0;
    private int heart = 0;
    private String deviceCode = "";
    private SQLHelp sql = null;
    /**
     * 连接响应回调函数
     * @param returnCode 返回码
     * @param description 返回码代表的含义
     */
    @Override
    public void onConnectAck(int returnCode, String description) {
        super.onConnectAck(returnCode, description);
        System.out.println("连接回调函数");
        System.out.println(returnCode);
        switch (returnCode) {
            case 0:
                System.out.println("连接成功");
                break;

            case 1:
                System.out.println("连接断开");
                break;

            case 2:
                System.out.println("与服务器完成连接");
                break;

            case 3:
                System.out.println("与服务器连接断开");
                break;

            default:
                break;
        }
        connectFlag = returnCode;
    }

    /**
     * 订阅响应回调函数
     * @param messageId 消息ID
     * @param clientId 客户端ID
     * @param topics 订阅主题
     * @param returnCode 返回码
     */
    @Override
    public void onSubscribeAck(int messageId, String clientId, String topics, int returnCode) {
        super.onSubscribeAck(messageId, clientId, topics, returnCode);
        System.out.println("/********************************/");
        System.out.println("订阅响应回调函数：");
        System.out.println("消息ID："+messageId);
        System.out.println("客户端ID："+clientId);
        System.out.println("订阅主题："+topics);
        System.out.println("返回码："+returnCode);
        if (returnCode == 0) {
            System.out.println("订阅成功");
        } else if (returnCode == 1) {
            System.out.println("订阅失败");
        }
        subscribeFalg = returnCode;
    }

    /**
     * 取消订阅响应回调函数
     * @param messageId 消息ID
     * @param clientId 客户端ID
     * @param topics 订阅主题
     * @param returnCode 返回码
     */
    @Override
    public void onDisSubscribeAck(int messageId, String clientId, String topics, int returnCode) {
        super.onDisSubscribeAck(messageId, clientId, topics, returnCode);
        if (returnCode == 0) {
            System.out.println("取消订阅成功");
        } else if (returnCode == 1) {
            System.out.println("取消订阅失败");
        }
    }

    /**
     * 接收数据回调函数
     * @param messageId 消息ID
     * @param topic 主题消息来源
     * @param data 接收的数据
     */
    @Override
    public void onReceiveEvent(int messageId, String topic, byte[] data) {
        super.onReceiveEvent(messageId, topic, data);

        tmp = TranscodeUtil.byte2DecStr(data);
        System.out.printf("接收的数据："+tmp);
        
        deviceCode = tmp.substring(3, 5);
        temp = Double.parseDouble(tmp.substring(8, 12));
        heart = Integer.parseInt(tmp.substring(5, 8));
        System.out.println("设备号："+deviceCode);
        System.out.println("体温："+temp); 
        System.out.println("心率"+heart);
        
        sql = new SQLHelp();
        int temp_flag = sql.insTempData(deviceCode, temp);
        if (temp_flag > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
        
        int heart_flag = sql.insHeartData(deviceCode, heart);
        if (heart_flag > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
    }

    public int connectFlag(){
        return connectFlag;
    }

    public int subscribeFlag(){
        return subscribeFalg;
    }
    
    
}
