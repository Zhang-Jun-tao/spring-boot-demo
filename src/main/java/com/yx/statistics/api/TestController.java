package com.yx.statistics.api;

import com.yx.statistics.model.TestPOJO;
import com.yx.statistics.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhang on 2016/12/8.
 */
@RestController
@RequestMapping("/")
@SuppressWarnings("all")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping(value = "list")
    public List<TestPOJO> test(@RequestParam(value = "age",required = true)Integer age){
        Assert.notNull(age,"age is empty");
        return testService.get(age);
    }


    @PostMapping //@GetMapping
    public List<TestPOJO> index(@RequestParam(value = "age",required = true)Integer age){
        Assert.notNull(age,"age is empty");
        return testService.get(age);
    }

}
