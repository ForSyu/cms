package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;


public interface IArticleService {
    List<Article> findAll();
    
    List<ArticleExtend> casecadefindAll();

    void saveOrUpdate(Article article);

	ArticleExtend findById(long id);
}
