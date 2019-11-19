package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IRoleService {

    List<Role> findAll();
    
    List<RoleExtend> cascadePrivilegeFindAll();

    void saveOrUpdate(Role baseRole) throws CustomerException;
    
    void deleteById(Integer id) throws CustomerException;
    
    void authorization(Integer roleId,List<Integer> privilegeIds);
}
