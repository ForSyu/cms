package com.syu.apps.cms.service.impl;

import org.springframework.stereotype.Service;

import com.syu.apps.cms.bean.Test;
import com.syu.apps.cms.bean.TestExample;
import com.syu.apps.cms.dao.TestMapper;
import com.syu.apps.cms.service.ITestService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        TestExample example = new TestExample();
        return testMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Test test) {
        if(test.getId()!=null){
            testMapper.updateByPrimaryKey(test);
        } else {
            testMapper.insert(test);
        }
    }
}
