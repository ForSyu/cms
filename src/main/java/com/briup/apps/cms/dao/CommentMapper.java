package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    long countByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int deleteByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int insertSelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_comment
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    int updateByPrimaryKey(Comment record);
}