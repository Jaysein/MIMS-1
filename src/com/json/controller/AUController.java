package com.json.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.json.model.Mims_device;
import com.json.model.Mims_user;
import com.json.service.AUService;

@Controller
public class AUController {
	@Resource
	private AUService auService;
	
	private String flag;
	
	@RequestMapping(value="/auRegister", method=RequestMethod.POST)
	public void auRegister(HttpServletRequest request, HttpServletResponse response) {
		BufferedReader bufferedReader = null;
		PrintWriter out = null;
		
		try {
			bufferedReader = request.getReader();
			String json = bufferedReader.readLine();
			Gson gson = new Gson();
			Mims_user user = gson.fromJson(json, Mims_user.class);
			System.out.println("接收到的用户：\n"+user);
			
			Mims_user mUser = auService.selUserByName(user.getUser_name());
			if (mUser == null) {
				int result = auService.insUser(user);
				
				System.out.println("插入数据的结果："+result);
				
				if (result > 0) {
					flag = "REGISTER_SUCCESS";
				} else {
					flag = "REGISTER_FAIL";
				}
			} else {
				flag = "USER_EXIST";
			}
			
			System.out.println("标识位："+flag);
			out = response.getWriter();
			out.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value="/auLogin", method=RequestMethod.POST)
	public void auLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		Mims_user user = auService.selUserByNameAndPwd(username, password);
		
		System.out.println("查询到的用户：\n"+user);
		
		if (user != null) {
			flag = "LOGIN_OK";
		} else {
			flag = "LOGIN_NO";
		}
		
		try {
			System.out.println("标识位："+flag);
			PrintWriter out = response.getWriter();
			out.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/auInformation", method=RequestMethod.GET)
	@ResponseBody
	public Mims_user auInformation(HttpServletRequest request) {
		String username = request.getParameter("username");
		
		System.out.println("username = "+username);
		
		Mims_user user = auService.selUserByName(username);
		System.out.println("查询到的用户：\n"+user);
		
		return user;
	}
	
	@RequestMapping(value="/auUpdInformation", method=RequestMethod.POST)
	public void auUpdInformation(HttpServletRequest request, HttpServletResponse response) {
		BufferedReader bufferedReader = null;
		PrintWriter out = null;
		try {
			bufferedReader = request.getReader();
			String json = bufferedReader.readLine();
			
			Gson gson = new Gson();
			Mims_user user = gson.fromJson(json, Mims_user.class);
			System.out.println("接收到的用户：\n"+user);
			
			int result = auService.updUserByName(user);
			
			if (result > 0) {
				flag = "UPDATE_OK";
			} else {
				flag = "UPDATE_FAIL";
			}
			
			out = response.getWriter();
			out.print(flag);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping(value="/auDevInformation", method=RequestMethod.GET)
	@ResponseBody
	public Mims_device auDevInformation(HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println("username = "+username);
		
		Mims_device device = auService.selDevByName(username);
		return device;
	}
	
	@RequestMapping(value="/auDevUpdInformation", method=RequestMethod.POST)
	public void auDevUpdInformation(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		Map<String, Object> map = null;
		String username = request.getParameter("username");
		String deviceCode = request.getParameter("deviceCode");
		
		System.out.println("username:"+username);
		System.out.println("deviceCode"+deviceCode);
		
		Mims_user user = auService.selUserByName(username);
		System.out.println("查询到的用户信息："+user);
		if (user == null) {
			flag = "SEACHER_NO_USER";
			try {
				out = response.getWriter();
				out.print(flag);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		} else {
			map = new HashMap<String, Object>();
			map.put("username", username);
			map.put("deviceCode", deviceCode);
			map.put("user_id", user.getId());
		}	
	
		Mims_device device = auService.selDevByName(username);
		int result = 0;
		if (device != null) {
			result = auService.updDevCodeByName(map);
			System.out.println("结果："+result);
			
			if (result > 0) {
				flag = "UPDATE_OK";
			} else {
				flag = "UPDATE_FAIL";
			}
		} else {
			result = auService.insDevCodeByName(map);
			if (result > 0) {
				flag = "INSERT_OK";
			} else {
				flag = "INSERT_FAIL";
			}
		}	
		
		System.out.println("标志位："+flag);
		
		try {
			out = response.getWriter();
			out.print(flag);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}		
	}
	
	@RequestMapping(value="/auPassword", method=RequestMethod.POST)
	public void auPassword(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String originalPwd = request.getParameter("originalPwd");
		String newPwd = request.getParameter("newPwd");
		
		System.out.println("username:"+username);
		System.out.println("originalPwd:"+originalPwd);
		System.out.println("newPwd:"+newPwd);
		
		Mims_user user = auService.selUserByName(username);
		System.out.println("查询到的用户：\n"+user);
		if (user != null) {
			System.out.println(user.getPassword());
			if (!originalPwd.equals(user.getPassword())) {
				flag = "PASSWORD_ERROR";
			} else {
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", username);
				map.put("newPwd", newPwd);
				
				int result = auService.updPwdByName(map);
				if (result > 0) {
					flag = "PASSWORD_UPDATE_OK";
				} else {
					flag = "PASSWORD_UPDATE_FAIL";
				}
			}
		}	
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(flag);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		
	}

}
