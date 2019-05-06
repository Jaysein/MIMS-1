package com.json;

import com.json.cloud.Client;
import com.json.cloud.ClientAdapter;
import com.json.cloud.ClientCallbackAdapter;
import com.json.util.PropertyUtil;
import com.json.util.SpringContextUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class UsrCloudApplication implements ServletContextListener {
    private Client client;
    private Thread thread;
    private String username;
    private String password;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {    	
    	username = PropertyUtil.getProperty("usrcloud.username");
    	password = PropertyUtil.getProperty("usrcloud.password");
    	client = new Client(username, password);
    	thread = new Thread(client);
    	thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	System.out.println("½áÊø");
    }
}
