package com.json.cloud;


import cn.usr.UsrCloudMqttClientAdapter;
import org.eclipse.paho.client.mqttv3.MqttException;

public class ClientAdapter extends UsrCloudMqttClientAdapter {
    /**
     * 连接登录
     * @param userName 用户名
     * @param passWord 密码
     * @throws MqttException
     */
    @Override
    public void Connect(String userName, String passWord) throws MqttException {
        super.Connect(userName, passWord);
    }

    /**
     * 断开连接，取消登录
     * @return
     * @throws MqttException
     */
    @Override
    public boolean DisConnectUnCheck() throws MqttException {
        return super.DisConnectUnCheck();
    }

    /**
     * 订阅消息（单个设备）
     * @param devId
     * @throws MqttException
     */
    @Override
    public void SubscribeForDevId(String devId) throws MqttException {
        super.SubscribeForDevId(devId);
    }

    /**
     * 订阅消息（账户下的所有设备）
     * @throws MqttException
     */
    @Override
    public void SubscribeForUsername() throws MqttException {
        super.SubscribeForUsername();
    }

    /**
     * 订阅消息（账户下的所有设备）
     * @param userName 用户名
     * @throws MqttException
     */
    @Override
    public void SubscribeForUsername(String userName) throws MqttException {
        super.SubscribeForUsername(userName);
    }

    /**
     * 取消订阅（单个设备）
     * @param devId
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforDevId(String devId) throws MqttException {
        super.DisSubscribeforDevId(devId);
    }

    /**
     * 取消订阅（账户下的所有设备）
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforuName() throws MqttException {
        super.DisSubscribeforuName();
    }

    /**
     * 取消订阅（账号下的所有设备）
     * @param userName 用户名
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforuName(String userName) throws MqttException {
        super.DisSubscribeforuName(userName);
    }
}