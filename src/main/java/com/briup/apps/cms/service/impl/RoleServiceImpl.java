package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RoleExample;
import com.briup.apps.cms.bean.Roleprivilege;
import com.briup.apps.cms.bean.RoleprivilegeExample;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.RoleprivilegeMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.CustomerException;

@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper baseRoleMapper;
    @Resource
    private RoleExtendMapper baseRoleExtendMapper;
    @Resource
    private RoleprivilegeMapper roleprivilegeMapper;
    
    @Override
    public List<Role> findAll() {

        return baseRoleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<RoleExtend> cascadePrivilegeFindAll() {
        return baseRoleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(Role baseRole) throws CustomerException {
        if(baseRole.getId()!=null){
            baseRoleMapper.updateByPrimaryKey(baseRole);
        } else {
            baseRoleMapper.insert(baseRole);
        }
    }

    @Override
    public void deleteById(Integer id) throws CustomerException {
        Role role = baseRoleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        baseRoleMapper.deleteByPrimaryKey(id);
    }

	@Override
	public void authorization(Integer roleId, List<Integer> privilegeIds) {
		RoleprivilegeExample example = new RoleprivilegeExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<Roleprivilege> roleprivileges = roleprivilegeMapper.selectByExample(example);
		
		List<Integer> old_privilege = new ArrayList<>();
		for(Roleprivilege rp:roleprivileges) {
			old_privilege.add(rp.getPrivilegeId());
		}
		
		for(Integer privilege:privilegeIds) {
			if(!old_privilege.contains(privilege)) {
				Roleprivilege rp = new Roleprivilege();
				rp.setRoleId(roleId);
				rp.setPrivilegeId(privilege);
				roleprivilegeMapper.insert(rp);
			}
		}
		
		for(Integer privilege:old_privilege) {
			if(!privilegeIds.contains(privilege)) {
				example.clear();
				example.createCriteria().andRoleIdEqualTo(roleId).andPrivilegeIdEqualTo(privilege);
				roleprivilegeMapper.deleteByExample(example);
				
			}
		}
	}
}
