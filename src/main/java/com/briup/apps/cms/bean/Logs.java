package com.briup.apps.cms.bean;

import java.util.Date;

public class Logs {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_logs.id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_logs.content
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_logs.action_time
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    private Date actionTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_logs.user_id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_logs.id
     *
     * @return the value of cms_logs.id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_logs.id
     *
     * @param id the value for cms_logs.id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_logs.content
     *
     * @return the value of cms_logs.content
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_logs.content
     *
     * @param content the value for cms_logs.content
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_logs.action_time
     *
     * @return the value of cms_logs.action_time
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public Date getActionTime() {
        return actionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_logs.action_time
     *
     * @param actionTime the value for cms_logs.action_time
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_logs.user_id
     *
     * @return the value of cms_logs.user_id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_logs.user_id
     *
     * @param userId the value for cms_logs.user_id
     *
     * @mbg.generated Mon Nov 18 10:05:29 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}