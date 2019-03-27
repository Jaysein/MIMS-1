package com.json.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.json.model.Mims_user;
import com.json.service.AndroidUserService;


@Controller
public class AndroidUserController {
	
	@Resource
	private AndroidUserService androidUserServiceImpl;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	@ResponseBody
	public Mims_user show(HttpServletRequest request) throws IOException {
		String user_name = request.getParameter("name");	
		
		Mims_user user = new Mims_user();
		user = androidUserServiceImpl.selByName(user_name);
		
		return user;
	}

}
