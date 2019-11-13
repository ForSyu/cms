package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category);
    
    void deleteById(int category_id);
    
    Category findById(int category_id);
}
