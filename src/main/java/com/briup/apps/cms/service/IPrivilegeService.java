package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

public interface IPrivilegeService {
    
    List<Privilege> findAll();
    
    List<Privilege> findByParentId(Integer parentId);

    void saveOrUpdate(Privilege privilege) throws CustomerException;

    List<PrivilegeTree> findPrivilegeTree();

    List<Privilege> findByUserId(Integer id);
    
    void deleteById(Integer id);
}
