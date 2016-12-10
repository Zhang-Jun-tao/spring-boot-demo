package com.yx.statistics.service.imp;

import com.yx.statistics.dao.TestDao;
import com.yx.statistics.model.TestPOJO;
import com.yx.statistics.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2016/12/8.
 */
@Service
public class TestServiceImp implements ITestService{

    @Autowired
    private TestDao testDao;

    @Override
    public List<TestPOJO> get(int age) {
        return testDao.get(age);
    }
}
