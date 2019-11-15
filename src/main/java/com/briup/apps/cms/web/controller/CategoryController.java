package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;

@Api("栏目相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
	 @Autowired
	 private ICategoryService categoryService;
	
	@GetMapping("findAll")
	public Message findAll(){	
		List<Category> list =  categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@PostMapping(value = "saveOrUpdate")
	public Message saveOrUpdate(Category category) {
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	}
	
	@GetMapping(value = "deleteById")
	public Message deleteById(int id) {
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功！");
	}

	@PostMapping(value = "batchDelete")
	public Message batchDelete(@RequestBody int[] ids) {
		categoryService.batchDelete(ids);
		return MessageUtil.success("删除成功！");
	}
	
	@PostMapping(value = "findById")
	public Message findById(int category_id) {
		Category category = categoryService.findById(category_id);
		return MessageUtil.success(category);
	}
}