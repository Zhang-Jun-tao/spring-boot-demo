package com.yx.statistics.dao;

import com.yx.statistics.common.Mapper;
import com.yx.statistics.model.TestPOJO;

import java.util.List;
@Mapper
public interface TestDao {

    //根据age查找info
    List<TestPOJO> get(int age);

}
