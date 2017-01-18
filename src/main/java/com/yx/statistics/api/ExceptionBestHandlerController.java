package com.yx.statistics.api;

import com.yx.statistics.Util.CommonUtil;
import com.yx.statistics.common.ErrorMsg;
import com.yx.statistics.common.ResultMsg;
import com.yx.statistics.common.SuccessMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/18.
 */

@SuppressWarnings("all")
@RestController("/exception")
public class ExceptionBestHandlerController {



    @GetMapping
    public ResultMsg test(@RequestParam(value = "age",required = false)String age)throws Exception{
        if (CommonUtil.isEmpty(age))
            return new ErrorMsg(200,500,"age is empty");
        else
            return new SuccessMsg(200,200,"ok",1,"zhangsan");
    }


    @GetMapping(value = "/serializable")
    public Serializable testSerializable(@RequestParam(value = "age",required = false)String age)throws Exception{
        if (CommonUtil.isEmpty(age))
            return new ErrorMsg(200,500,"age is empty");
        else
            return new SuccessMsg(200,200,"ok",1,"zhangsan");
    }
}
