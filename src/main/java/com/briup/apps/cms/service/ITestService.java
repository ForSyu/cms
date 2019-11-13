package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Test;

public interface ITestService {
    List<Test> findAll();

    void saveOrUpdate(Test test);
}
