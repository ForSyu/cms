package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.service.ITestService;

@RestController
@RequestMapping("/test")
public class TestController {
	 @Autowired
	 private ITestService testService;
	
	@RequestMapping(value = "findAll",method = {RequestMethod.GET})
	public List<Test> findAll(){	
		return testService.findAll();
	}
	
	@RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
	public String saveOrUpdate(Test test) {
		testService.saveOrUpdate(test);
		return "更新成功";
	}
}