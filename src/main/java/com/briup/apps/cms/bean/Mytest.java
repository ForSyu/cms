package com.briup.apps.cms.bean;

public class Mytest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_mytest.id
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_mytest.text
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    private byte[] text;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_mytest.id
     *
     * @return the value of cms_mytest.id
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_mytest.id
     *
     * @param id the value for cms_mytest.id
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_mytest.text
     *
     * @return the value of cms_mytest.text
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    public byte[] getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_mytest.text
     *
     * @param text the value for cms_mytest.text
     *
     * @mbg.generated Tue Nov 12 10:57:48 CST 2019
     */
    public void setText(byte[] text) {
        this.text = text;
    }
}