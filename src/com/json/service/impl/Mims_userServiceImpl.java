package com.json.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.json.dao.Mims_userDao;
import com.json.model.Mims_user;
import com.json.model.PageInfo;
import com.json.service.Mims_userService;

@Service
public class Mims_userServiceImpl implements Mims_userService {
	@Resource
	private Mims_userDao mims_userDao;

	@Override
	public PageInfo showPage(String user_name, String pageSizeStr, String pageNumberStr) {
		int pageSize = 20;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart(pageSize*(pageNumber-1));
		pageInfo.setUser_name(user_name);
		
		List<Mims_user> list = mims_userDao.selByPage(pageInfo);
		pageInfo.setList(list);
		
		long count = mims_userDao.selCountByPage(pageInfo);
		System.out.println(count);
		pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		return pageInfo;
	}

}
