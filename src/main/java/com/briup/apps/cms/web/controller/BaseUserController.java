package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserRoleVM;

import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {
    @Autowired
    private IUserService baseUserService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<User> list = baseUserService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询所有",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> list = baseUserService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(User baseUser){
        baseUserService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(Integer id){
        baseUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        System.out.println(userRoleVM);
        baseUserService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }


}
