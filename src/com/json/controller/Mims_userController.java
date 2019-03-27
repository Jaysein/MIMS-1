package com.json.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.json.model.PageInfo;
import com.json.service.Mims_userService;

@Controller
public class Mims_userController {
	@Resource
	private Mims_userService mims_userServiceImpl;
	
	@RequestMapping("/userManage")
	public ModelAndView userManage(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("user");
		String user_name = request.getParameter("user_name");
		String pageSize = request.getParameter("pageSize");
		String pageNumber = request.getParameter("pageNumber");
		
		PageInfo pageInfo = mims_userServiceImpl.showPage(user_name, pageSize, pageNumber);
		
		request.setAttribute("pageinfo", pageInfo);
		System.out.println(pageInfo);
		return modelAndView;
	}
	
}
