package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.customerException;

public interface IArticleService {
    List<Article> findAll();
    
    List<ArticleExtend> casecadefindAll();

    void saveOrUpdate(Article article) throws customerException ;

	ArticleExtend findById(long id);
	
	void deleteById(int id) throws customerException ;
}
