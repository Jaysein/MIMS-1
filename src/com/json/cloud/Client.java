package com.json.cloud;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.TimerTask;

@RestController
public class Client implements Runnable {
    private ClientAdapter clientAdapter = null;
    private ClientCallbackAdapter callbackAdapter = null;
    private Timer timer = null;
    private String username;
    private String password;

    public Client(String username, String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public void run() {
    	clientAdapter = new ClientAdapter();
        callbackAdapter = new ClientCallbackAdapter();
        clientAdapter.setUsrCloudMqttCallback(callbackAdapter);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    clientAdapter.Connect("joker666", "2468joker");
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            try {
                                clientAdapter.SubscribeForUsername("joker666");
                            } catch (MqttException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 2000);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

}
