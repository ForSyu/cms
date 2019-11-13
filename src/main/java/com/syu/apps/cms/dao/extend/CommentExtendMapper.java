package com.syu.apps.cms.dao.extend;

import java.util.List;

import com.syu.apps.cms.bean.Comment;

public interface CommentExtendMapper {
	
	List<Comment> selectByArticleId(long id);
	
}
