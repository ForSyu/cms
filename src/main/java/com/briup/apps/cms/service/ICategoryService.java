package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category) throws CustomerException;
    
    void deleteById(int category_id);
    
    void batchDelete(int[] ids) throws CustomerException;
    
    Category findById(int category_id);
    
    List<Category> findByLimit(int page,int size);
}
