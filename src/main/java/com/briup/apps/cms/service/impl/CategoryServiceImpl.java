package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.dao.extend.CategoryExtendMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;

	@Override
	public void saveOrUpdate(Category category) throws CustomerException{
		if(category.getId()!=null){
			categoryMapper.updateByPrimaryKey(category);
		} else {
			CategoryExample example = new CategoryExample();
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("文章标题不能重复！");
			}
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
		}else {
			throw new CustomerException("栏目不存在！");
		}
	}

	@Override
	public Category findById(int category_id) {
		Category category = categoryMapper.selectByPrimaryKey(category_id);
		return category;
	}

	@Override
	public void batchDelete(int[] ids) {
		for(int id:ids) {
			this.deleteById(id);
		}
	}

	@Override
	public List<Category> findByLimit(int page, int size) {
		List<Category> byLimit = categoryExtendMapper.selectByLimit((page-1)*size, size);
		return byLimit;
	}
}
