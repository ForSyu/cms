package com.syu.apps.cms.dao.extend;

import java.util.List;

import com.syu.apps.cms.bean.extend.ArticleExtend;

public interface ArticleExtendMapper {
	
	List<ArticleExtend> selectAll();

	ArticleExtend selectById(long id);
	
	List<ArticleExtend> selectAllWithBLOBs();
	
}
