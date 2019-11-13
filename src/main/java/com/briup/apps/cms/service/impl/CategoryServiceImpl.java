package com.briup.apps.cms.service.impl;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.service.ITestService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

	@Override
	public void saveOrUpdate(Category category) {
		if(category.getId()!=null){
			categoryMapper.updateByPrimaryKey(category);
		} else {
			categoryMapper.insert(category);
		}
	}

	@Override
	public List<Category> findAll() {
		CategoryExample example = new CategoryExample();
		return categoryMapper.selectByExample(example);
	}

	@Override
	public void deleteById(int category_id) {
		Category category = categoryMapper.selectByPrimaryKey(category_id);
		if(category!=null) {
			categoryMapper.deleteByPrimaryKey(category_id);
		}
	}

	@Override
	public Category findById(int category_id) {
		Category category = categoryMapper.selectByPrimaryKey(category_id);
		return category;
	}
}
