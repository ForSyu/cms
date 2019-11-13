package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.customerException;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource 
    private ArticleExtendMapper articleExtendMapper;
    
    @Override
    public List<Article> findAll() {
    	ArticleExample example = new ArticleExample();
        return articleMapper.selectByExample(example);
    } 
	@Override
	public List<ArticleExtend> casecadefindAll() {
		return articleExtendMapper.selectAll();
	}
	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id);
	}


	@Override
	public void saveOrUpdate(Article article) throws customerException {
		if(article.getId()!=null) {
			articleMapper.updateByPrimaryKey(article);
		}else {
			ArticleExample 	example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new customerException("文章标题不能重复！");
			}
			
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			article.setPublishTime(System.currentTimeMillis());
			article.setThumbDown(0);
			article.setThumbUp(0);
			article.setReadTimes(0l);
			articleMapper.insert(article);
		}
	}
}
