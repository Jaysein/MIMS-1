package com.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.json.cloud.ClientCallbackAdapter;
import com.json.util.SpringContextUtil;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public void test() {
		ClientCallbackAdapter adapter = 
				(ClientCallbackAdapter)SpringContextUtil.getBean("clientCallbackAdapter");
		int result = adapter.connectFlag();
		System.out.println("sda"+result);
	}
}
