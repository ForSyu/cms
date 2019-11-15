package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.customerException;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category) throws customerException;
    
    void deleteById(int category_id);
    
    void batchDelete(int[] ids) throws customerException;
    
    Category findById(int category_id);
}
