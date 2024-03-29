package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;

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
	public void saveOrUpdate(Article article) throws CustomerException {
		if(article.getId()!=null) {
			article.setPublishTime(System.currentTimeMillis());
			articleMapper.updateByPrimaryKey(article);
		}else {
			
			ArticleExample 	example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("文章标题不能重复！");
			}
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			article.setPublishTime(System.currentTimeMillis());
			article.setThumbDown(0);
			article.setThumbUp(0);
			article.setReadTimes(0l);
			articleMapper.insert(article);
		}
	}
	@Override
	public void deleteById(int id) throws CustomerException {
		if(this.findById(id)!=null) {
			articleMapper.deleteByPrimaryKey(id);
		}else {
			throw new CustomerException("文章不存在！");
		}
	}
	@Override
	public List<ArticleExtend> findByLimit(int page, int size) {
		List<ArticleExtend> byLimit = articleExtendMapper.selectByLimit((page-1)*size, size);
		return byLimit;
	}
}
