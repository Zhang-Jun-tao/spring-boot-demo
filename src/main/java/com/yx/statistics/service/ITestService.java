package com.yx.statistics.service;
import com.yx.statistics.model.TestPOJO;
import java.util.List;

/**
 * Created by ZHANG on 2016/12/8.
 */
public interface ITestService {

    //根据age查找info
    List<TestPOJO> get(int age);
}
