package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Category;

public interface CategoryExtendMapper {
	List<Category> selectByLimit(int page,int size);
}
