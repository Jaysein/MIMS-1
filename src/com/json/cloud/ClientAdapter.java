package com.json.cloud;


import cn.usr.UsrCloudMqttClientAdapter;
import org.eclipse.paho.client.mqttv3.MqttException;

public class ClientAdapter extends UsrCloudMqttClientAdapter {
    /**
     * ���ӵ�¼
     * @param userName �û���
     * @param passWord ����
     * @throws MqttException
     */
    @Override
    public void Connect(String userName, String passWord) throws MqttException {
        super.Connect(userName, passWord);
    }

    /**
     * �Ͽ����ӣ�ȡ����¼
     * @return
     * @throws MqttException
     */
    @Override
    public boolean DisConnectUnCheck() throws MqttException {
        return super.DisConnectUnCheck();
    }

    /**
     * ������Ϣ�������豸��
     * @param devId
     * @throws MqttException
     */
    @Override
    public void SubscribeForDevId(String devId) throws MqttException {
        super.SubscribeForDevId(devId);
    }

    /**
     * ������Ϣ���˻��µ������豸��
     * @throws MqttException
     */
    @Override
    public void SubscribeForUsername() throws MqttException {
        super.SubscribeForUsername();
    }

    /**
     * ������Ϣ���˻��µ������豸��
     * @param userName �û���
     * @throws MqttException
     */
    @Override
    public void SubscribeForUsername(String userName) throws MqttException {
        super.SubscribeForUsername(userName);
    }

    /**
     * ȡ�����ģ������豸��
     * @param devId
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforDevId(String devId) throws MqttException {
        super.DisSubscribeforDevId(devId);
    }

    /**
     * ȡ�����ģ��˻��µ������豸��
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforuName() throws MqttException {
        super.DisSubscribeforuName();
    }

    /**
     * ȡ�����ģ��˺��µ������豸��
     * @param userName �û���
     * @throws MqttException
     */
    @Override
    public void DisSubscribeforuName(String userName) throws MqttException {
        super.DisSubscribeforuName(userName);
    }
}