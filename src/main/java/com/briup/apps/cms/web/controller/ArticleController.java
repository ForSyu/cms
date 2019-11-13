package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiParam;

@RestController
@Validated
@RequestMapping("/article")
public class ArticleController {
	 @Autowired
	 private IArticleService articleService;
	
	@RequestMapping(value = "findAll",method = {RequestMethod.GET})
	public Message findAll(){	
		List<Article> list =  articleService.findAll();
		return MessageUtil.success(list);
	}
	
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
    	List<ArticleExtend> list = articleService.casecadefindAll();
    	return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id){
    	ArticleExtend article = articleService.findById(id);
    	return MessageUtil.success(article);
    }
    
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
    		@ApiParam(value = "编号") @RequestParam(value = "id",required = false) Integer id,
    		@ApiParam(value = "标题" ,required = true) @RequestParam(value = "title") String title,
    		@ApiParam(value = "正文" ,required = true) @RequestParam(value = "content") String content,
    		@ApiParam(value = "原内容" ,required = true) @RequestParam(value = "source") String source,
    		@ApiParam(value = "栏目编号" ,required = true) @RequestParam(value = "categortId") Integer categoryId,
    		@ApiParam(value = "作者编号" ,required = true) @RequestParam(value = "authorId") Integer authorId) {
    	
    	Article article = new Article();
    	article.setId(id);
    	article.setTitle(title);
    	article.setSource(source);
    	article.setContent(content);
    	article.setCategoryId(categoryId);
    	article.setAuthorId(authorId);
    	
    	articleService.saveOrUpdate(article);
    	return MessageUtil.success("更新成功！", null);
    }
}