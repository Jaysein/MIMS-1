package com.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataController {
	
	@RequestMapping("/dataManage")
	public ModelAndView show() {
		ModelAndView model = new ModelAndView("data");
		return model;
	}

}
