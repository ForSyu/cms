package com.syu.apps.cms.service;

import java.util.List;

import com.syu.apps.cms.bean.Test;

public interface ITestService {
    List<Test> findAll();

    void saveOrUpdate(Test test);
}
