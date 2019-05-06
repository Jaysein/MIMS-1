package com.json.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.json.model.Mims_user;
import com.json.model.PageInfo;
import com.json.service.Mims_userService;

import net.sf.json.JSONObject;

@Controller
public class Mims_userController {
	@Resource
	private Mims_userService mims_userServiceImpl;
	
	@RequestMapping("/selectUser")
	@ResponseBody
	public PageInfo selectUser(HttpServletRequest request, HttpServletResponse response) {
		String user_name = request.getParameter("username");
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		
		System.out.println("前台发过来的用户名："+user_name);
		
		PageInfo pageInfo = mims_userServiceImpl.showPage(user_name, pageSize, pageNumber);
		//request.setAttribute("pageinfo", pageInfo);
		System.out.println(pageInfo);
		return pageInfo;
	}
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String user_name = request.getParameter("user_name");
		String e_mail = request.getParameter("e_mail");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		Mims_user user = new Mims_user();
		user.setUser_name(user_name);
		user.setPassword("000000");
		user.setE_mail(e_mail);
		user.setPhone(phone);
		if ("男".equals(sex)) {
			user.setSex(0);
		} else if ("女".equals(sex)) {
			user.setSex(1);
		}
		user.setAge(age);
		user.setHeight(height);
		user.setWeight(weight);
		
		JSONObject json = new JSONObject();
		Mims_user resultUser = mims_userServiceImpl.selByName(user_name);
		if (resultUser != null) {
			json.put("ins_flag", "user_exist");
		} else {
			int result = mims_userServiceImpl.insUser(user);
			System.out.println("新增结果："+result);
			if (result > 0) {
				json.put("ins_flag", "ins_success");
			} else {
				json.put("ins_flag", "ins_fails");
			}
		}
			
        try {
        	response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/cancelUser", method=RequestMethod.POST)
	public void cancelUser(HttpServletRequest request, HttpServletResponse response) {
		String user_name = request.getParameter("user_name");
		System.out.println(user_name);
		
		JSONObject json = new JSONObject();
		Mims_user resultUser = mims_userServiceImpl.selByName(user_name);
		if (resultUser != null) {
			Map<String, Object> cancelMap = new HashMap<>();
			cancelMap.put("user_status", 1);
			cancelMap.put("user_name", user_name);
			int result = mims_userServiceImpl.updUserStateByName(cancelMap);
			if (result > 0) {
				json.put("cancel_flag", "cancel_success");
			} else {
				json.put("cancel_flag", "cancel_fails");
			}
		} else {
			json.put("cancel_flag", "cancel_no_exist");
		}
		
		 try {
	        	response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public void updateUser(HttpServletRequest request, HttpServletResponse response) {
		String user_name = request.getParameter("user_name");
		String e_mail = request.getParameter("e_mail");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		double height = Double.parseDouble(request.getParameter("height"));
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		Mims_user user = new Mims_user();
		user.setUser_name(user_name);
		user.setPassword("000000");
		user.setE_mail(e_mail);
		user.setPhone(phone);
		if ("男".equals(sex)) {
			user.setSex(0);
		} else if ("女".equals(sex)) {
			user.setSex(1);
		}
		user.setAge(age);
		user.setHeight(height);
		user.setWeight(weight);
		
		JSONObject json = new JSONObject();
		Mims_user resultUser = mims_userServiceImpl.selByName(user_name);
		if (resultUser != null) {
			int result = mims_userServiceImpl.updUserByName(user);
			System.out.println("新增结果："+result);
			if (result > 0) {
				json.put("upd_flag", "upd_success");
			} else {
				json.put("upd_flag", "upd_fails");
			}
		} else {
			json.put("upd_flag", "user_no_exist");
		}
			
        try {
        	response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/main")
	public ModelAndView mains() {
		ModelAndView modelAndView = new ModelAndView("main");
		
		return modelAndView;
	}
	
	@RequestMapping("/seluser")
	public ModelAndView selUser() {
		ModelAndView modelAndView = new ModelAndView("user");
		return modelAndView;
	}
	
	@RequestMapping("/insuser")
	public ModelAndView insUser() {
		ModelAndView modelAndView = new ModelAndView("insUser");
		return modelAndView;
	}
	
	@RequestMapping("/upduser")
	public ModelAndView updUser() {
		ModelAndView modelAndView = new ModelAndView("updUser");
		return modelAndView;
	}
	
	@RequestMapping("/canceluser")
	public ModelAndView canUser() {
		ModelAndView modelAndView = new ModelAndView("cancelUser");
		return modelAndView;
	}
	
	@RequestMapping(value="/homeManage", method=RequestMethod.GET)
	public void homeManage(HttpServletResponse response) {
		int total_number = mims_userServiceImpl.selCountByTotalUser();
		int normal_number = mims_userServiceImpl.selCountByNormalUser();
		int cancel_number = mims_userServiceImpl.selCountByCancelUser();
		
		System.out.println("total_number"+total_number);
		System.out.println("normal_number"+normal_number);
		System.out.println("cancel_number"+cancel_number);
		JSONObject json = new JSONObject();
		if (total_number >= 0) {
			json.put("total_number", total_number);
		} else if (normal_number >= 0) {
			json.put("normal_number", normal_number);
		} else if (cancel_number >= 0) {
			json.put("cancel_number", cancel_number);
		}
		
		try {
        	response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/homes")
	public ModelAndView homes() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	} 
}
