package com.json.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.json.model.Mims_admin;
import com.json.service.Mims_adminService;

@Controller
public class Mims_adminController {
	@Resource
	private Mims_adminService mims_adminServiceImpl;
	
	@RequestMapping("/log")
	public void log(String admin_name, String password, HttpServletResponse response, HttpSession session) {
		Mims_admin mims_admin = new Mims_admin();
		mims_admin.setAdmin_name(admin_name);
		mims_admin.setPassword(password);
		
		Mims_admin admin = mims_adminServiceImpl.selByMims_admin(mims_admin);
		response.setContentType("application/json; charset=utf-8");
		try {
			if (admin == null) {
				response.getWriter().print("{\"msg\":\"0\"}");
			} else {
				session.setAttribute("real_name", admin.getReal_name());
				response.getWriter().print("{\"msg\":\"1\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(admin);		
	}
	
	@RequestMapping("/user")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping("/cancel")
	public String cancel(HttpSession session) {
		session.removeAttribute("real_name");
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
}
