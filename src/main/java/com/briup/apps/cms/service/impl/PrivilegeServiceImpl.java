package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.PrivilegeExample;
import com.briup.apps.cms.dao.PrivilegeMapper;
import com.briup.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
    @Resource
    private PrivilegeMapper PrivilegeMapper;
    @Resource
    private PrivilegeExtendMapper PrivilegeExtendMapper;

    @Override
    public List<Privilege> findAll() {
        return PrivilegeMapper.selectByExample(new PrivilegeExample());
    }

    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {
        if(privilege.getId()!=null){
            PrivilegeMapper.updateByPrimaryKey(privilege);
        } else {
            PrivilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<Privilege> findByParentId(Integer parentId) {
        PrivilegeExample example = new PrivilegeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return PrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return PrivilegeExtendMapper.selectAll();
    }
}
