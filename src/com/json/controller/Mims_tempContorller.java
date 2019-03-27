package com.json.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.sf.json.JSONObject;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.json.model.Mims_heart_rate;
import com.json.model.Mims_temperature;
import com.json.model.Series;
import com.json.service.Mims_temperatureService;
 
 
/**
 * 
 * @author Administrator
 *
 */
@Controller
public class Mims_tempContorller {
	@Resource
	private Mims_temperatureService mims_temperatureServiceImpl;
	
	@RequestMapping("/tempManage")
	public ModelAndView dataManage() {
		ModelAndView model = new ModelAndView("temperature");
		return model;
	}
	
	
	@RequestMapping("/temp")
	public String countInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject json=new JSONObject();
		String start=request.getParameter("startDate");
		String end=request.getParameter("endDate");
		String data_name = request.getParameter("data_name");
				
		Date startDate = null;
		Date endDate = null;
		List<String> category=new ArrayList<String>();
		List<Series> series = new ArrayList<Series>();
		
		SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(start!=null&&!"".equals(start)&&end!=null&&!"".equals(end)){
			startDate = dateFormatIn.parse(start);
			endDate = dateFormatIn.parse(end);
		}
		
		Map<String, Object> timeMap = new HashMap<String, Object>();
		timeMap.put("startDate", startDate);
		timeMap.put("endDate", endDate);
		timeMap.put("user_name", data_name);
		
		
		List<Mims_temperature> serisData1 = mims_temperatureServiceImpl.selByTime(timeMap);
		for(int i=0;i<serisData1.size();i++) {
			category.add(dateFormatOut.format(serisData1.get(i).getTime()));
		}
		
		series.add(new Series("体温", "line", serisData1));
		
		json.put("category", category);
		json.put("series", series);
		
		List<String> legend = Arrays.asList("体温");
		json.put("legend", legend);
		
		String title = "体温统计图";
		json.put("title", title);
        
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json.toString());
		return null;
	}
}








