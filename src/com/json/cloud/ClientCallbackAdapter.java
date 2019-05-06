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
     * ������Ӧ�ص�����
     * @param returnCode ������
     * @param description ���������ĺ���
     */
    @Override
    public void onConnectAck(int returnCode, String description) {
        super.onConnectAck(returnCode, description);
        System.out.println("���ӻص�����");
        System.out.println(returnCode);
        switch (returnCode) {
            case 0:
                System.out.println("���ӳɹ�");
                break;

            case 1:
                System.out.println("���ӶϿ�");
                break;

            case 2:
                System.out.println("��������������");
                break;

            case 3:
                System.out.println("����������ӶϿ�");
                break;

            default:
                break;
        }
        connectFlag = returnCode;
    }

    /**
     * ������Ӧ�ص�����
     * @param messageId ��ϢID
     * @param clientId �ͻ���ID
     * @param topics ��������
     * @param returnCode ������
     */
    @Override
    public void onSubscribeAck(int messageId, String clientId, String topics, int returnCode) {
        super.onSubscribeAck(messageId, clientId, topics, returnCode);
        System.out.println("/********************************/");
        System.out.println("������Ӧ�ص�������");
        System.out.println("��ϢID��"+messageId);
        System.out.println("�ͻ���ID��"+clientId);
        System.out.println("�������⣺"+topics);
        System.out.println("�����룺"+returnCode);
        if (returnCode == 0) {
            System.out.println("���ĳɹ�");
        } else if (returnCode == 1) {
            System.out.println("����ʧ��");
        }
        subscribeFalg = returnCode;
    }

    /**
     * ȡ��������Ӧ�ص�����
     * @param messageId ��ϢID
     * @param clientId �ͻ���ID
     * @param topics ��������
     * @param returnCode ������
     */
    @Override
    public void onDisSubscribeAck(int messageId, String clientId, String topics, int returnCode) {
        super.onDisSubscribeAck(messageId, clientId, topics, returnCode);
        if (returnCode == 0) {
            System.out.println("ȡ�����ĳɹ�");
        } else if (returnCode == 1) {
            System.out.println("ȡ������ʧ��");
        }
    }

    /**
     * �������ݻص�����
     * @param messageId ��ϢID
     * @param topic ������Ϣ��Դ
     * @param data ���յ�����
     */
    @Override
    public void onReceiveEvent(int messageId, String topic, byte[] data) {
        super.onReceiveEvent(messageId, topic, data);

        tmp = TranscodeUtil.byte2DecStr(data);
        System.out.printf("���յ����ݣ�"+tmp);
        
        deviceCode = tmp.substring(3, 5);
        temp = Double.parseDouble(tmp.substring(8, 12));
        heart = Integer.parseInt(tmp.substring(5, 8));
        System.out.println("�豸�ţ�"+deviceCode);
        System.out.println("���£�"+temp); 
        System.out.println("����"+heart);
        
        sql = new SQLHelp();
        int temp_flag = sql.insTempData(deviceCode, temp);
        if (temp_flag > 0) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
        
        int heart_flag = sql.insHeartData(deviceCode, heart);
        if (heart_flag > 0) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
    }

    public int connectFlag(){
        return connectFlag;
    }

    public int subscribeFlag(){
        return subscribeFalg;
    }
    
    
}
