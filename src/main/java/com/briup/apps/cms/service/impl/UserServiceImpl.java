package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.bean.Userrole;
import com.briup.apps.cms.bean.UserroleExample;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.dao.UserMapper;
import com.briup.apps.cms.dao.UserroleMapper;
import com.briup.apps.cms.dao.extend.UserExtendMapper;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserExtendMapper UserExtendMapper;
    @Resource
    private UserMapper UserMapper;
    @Resource
    private UserroleMapper UserRoleMapper;

    @Override
    public UserExtend findById(Integer id) {
        return UserExtendMapper.selectById(id);
    }

    @Override
    public List<User> findAll() {
        return UserMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> cascadeRoleFindAll() {
        return UserExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(User User) throws CustomerException {
        if(User.getId()!=null){
            UserMapper.updateByPrimaryKey(User);
        } else {
            // 判断用户名是否被占用
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(User.getUsername());
            List<User> list = UserMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化
            User.setRegisterTime(new Date().getTime());
            User.setStatus(UserExtend.STATUS_NORMAL);
            UserMapper.insert(User);
        }
    }

    @Override
    public void changeStatus(Integer id,String status) throws CustomerException {
        User user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        UserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteById(Integer id) throws CustomerException {
        User user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        UserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setRoles(Integer id, List<Integer> roles) {
        // 根据userid查询自己的角色
        UserroleExample example = new UserroleExample();
        example.createCriteria().andUserIdEqualTo(id);
        // 用户角色关系,获取所有老的角色
        List<Userrole> list = UserRoleMapper.selectByExample(example);
        List<Integer> oldRoles = new ArrayList<>();
        Iterator<Userrole> iterator = list.iterator();
        while(iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        for(Integer roleId : roles){
            if(!oldRoles.contains(roleId)){
                Userrole userRole = new Userrole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                UserRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 一次判断老的角色是否存在于roles中，如果不存在则删除
        for(Userrole userRole : list){
            if(!roles.contains(userRole.getRoleId())){
                UserRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }


    }

	@Override
	public User login(UserVM userVM) throws CustomerException {
		UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<User> list = UserMapper.selectByExample(example);
        if(list.size()<=0){
            throw new CustomerException("该用户不存在");
        }
        User user = list.get(0);
        if(!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;
	}
}
