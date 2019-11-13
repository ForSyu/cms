package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestController
@RequestMapping("/category")
public class CategoryController {
	 @Autowired
	 private ICategoryService categoryService;
	
	@RequestMapping(value = "findAll",method = {RequestMethod.GET})
	public Message findAll(){	
		List<Category> list =  categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@RequestMapping(value = "saveOrUpdate",method = RequestMethod.POST)
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功", null);
	}
	
	@RequestMapping(value = "delete",method =RequestMethod.POST )
	public Message deleteById(int category_id) {
		categoryService.deleteById(category_id);
		return MessageUtil.success("删除成功！", null);
	}
	
	@RequestMapping(value = "findById",method = RequestMethod.POST)
	public Message findById(int category_id) {
		Category category = categoryService.findById(category_id);
		return MessageUtil.success(category);
	}
}