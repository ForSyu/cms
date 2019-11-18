package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {
    List<Article> findAll();
    
    List<ArticleExtend> casecadefindAll();

    void saveOrUpdate(Article article) throws CustomerException ;

	ArticleExtend findById(long id);
	
	void deleteById(int id) throws CustomerException ;
	
	List<ArticleExtend> findByLimit(int page,int size);
}
