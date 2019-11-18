package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "id",value = "编号",paramType = "form"),
    		@ApiImplicitParam(name = "title",value = "标题" ,required = true,paramType = "form"),
    		@ApiImplicitParam(name = "content",value = "正文" ,required = true,paramType = "form"),
    		@ApiImplicitParam(name = "source",value = "原内容" ,required = true,paramType = "form"),
    		@ApiImplicitParam(name = "categoryId",value = "栏目编号" ,required = true,paramType = "form"),
    		@ApiImplicitParam(name = "authorId",value = "作者编号" ,required = true,paramType = "form")
    })
    public Message saveOrUpdate(
    		Integer id,
    		String title,
    		String content,
    		String source,
    		Integer categoryId,
    		Integer authorId) {
    	
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
    
    @ApiOperation("通过id删除")
    @GetMapping("deleteById")
    @ApiImplicitParams(
    		@ApiImplicitParam(name = "id",value = "编号",required = true,paramType = "query")
    )
    public Message deleteById(Integer id) {
    	articleService.deleteById(id);
    	return MessageUtil.success("删除成功！");
    }
    
	@PostMapping(value = "findByLimit")
	public Message findByLimit(@RequestBody int[] limits) {
		List<ArticleExtend> article = articleService.findByLimit(limits[0], limits[1]);
		return MessageUtil.success(article);
	}
}