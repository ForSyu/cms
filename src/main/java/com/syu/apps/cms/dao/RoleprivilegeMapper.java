package com.syu.apps.cms.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.syu.apps.cms.bean.Roleprivilege;
import com.syu.apps.cms.bean.RoleprivilegeExample;

public interface RoleprivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    long countByExample(RoleprivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int deleteByExample(RoleprivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int insert(Roleprivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int insertSelective(Roleprivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    List<Roleprivilege> selectByExample(RoleprivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    Roleprivilege selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int updateByExampleSelective(@Param("record") Roleprivilege record, @Param("example") RoleprivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int updateByExample(@Param("record") Roleprivilege record, @Param("example") RoleprivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int updateByPrimaryKeySelective(Roleprivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_role_privilege
     *
     * @mbg.generated Wed Nov 13 09:29:28 CST 2019
     */
    int updateByPrimaryKey(Roleprivilege record);
}