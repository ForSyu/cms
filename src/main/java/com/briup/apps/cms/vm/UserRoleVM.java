package com.briup.apps.cms.vm;

import java.util.List;

public class UserRoleVM {
    private Integer id;
    private List<Integer> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
