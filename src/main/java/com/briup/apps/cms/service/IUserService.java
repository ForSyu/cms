package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IUserService {

    UserExtend findById(Integer id);

    List<User> findAll();
    
    List<UserExtend> cascadeRoleFindAll();

    void saveOrUpdate(User User) throws CustomerException;

    void changeStatus(Integer id,String status) throws CustomerException;
 
    void deleteById(Integer id) throws CustomerException;

    void setRoles(Integer id, List<Integer> roles);
}
