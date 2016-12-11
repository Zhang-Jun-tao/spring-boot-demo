package com.yx.statistics.api;

import com.yx.statistics.Util.CommonUtil;
import com.yx.statistics.Util.DateUtil;
import com.yx.statistics.common.Page;
import com.yx.statistics.service.IShopStatusStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZHANG on 2016/12/9.
 */
@SuppressWarnings("all")
@RestController
public class StatisticsController {

    @Autowired
    private IShopStatusStatisticsService shopStatusStatisticsService;

    @GetMapping(value = "/shop_status_list")
    public Map<String,Object> ShopActionStatusList(
            @RequestParam(value = "current_page",required = false)String current_page,
            @RequestParam(value = "page_size",required = false)String page_size,
            @RequestParam(value = "start_time",required = false)String start_time,
            @RequestParam(value = "end_time",required = false)String end_time)throws  Exception{
        Map<String,Object> result=new HashMap<String,Object>();
        if(CommonUtil.isEmpty(start_time) || CommonUtil.isEmpty(end_time))
            throw new IllegalArgumentException(" start_time or end_time is empty");
        if (!CommonUtil.isNum(current_page) || !CommonUtil.isNum(page_size))
            throw new IllegalArgumentException(" page info is illegal");
        if (!CommonUtil.isEmpty(start_time) && !CommonUtil.isEmpty(end_time) )
            if (!CommonUtil.isYMDHMS(end_time) || !CommonUtil.isYMDHMS(end_time))
                throw new IllegalArgumentException(" page info is illegal");
        Page page=new Page(Integer.parseInt(current_page),Integer.parseInt(page_size),null,null);
        Map<Long, Object> data= shopStatusStatisticsService.getShopStatusStatisticsList(DateUtil.yMdHmsToDate(start_time),DateUtil.yMdHmsToDate(end_time),page);
        if(data==null)
            result.put("has_data",0);
        else {
            result.put("data",data.values());
            result.put("has_data",1);
        }
        result.put("result",200);
        result.put("msg","ok");
        return result;
    }



    @GetMapping(value = "/shop_status_cnt")
    public Map<String,Object> ShopActionStatusList(
            @RequestParam(value = "start_time",required = false)String start_time,
            @RequestParam(value = "end_time",required = false)String end_time)throws  Exception{
        Map<String,Object> result=new HashMap<String,Object>();
        if(CommonUtil.isEmpty(start_time) ? !CommonUtil.isEmpty(end_time):CommonUtil.isEmpty(end_time))
            throw new IllegalArgumentException(" params is illegal");
        if (!CommonUtil.isEmpty(start_time) && !CommonUtil.isEmpty(end_time) )
            if (!CommonUtil.isYMDHMS(end_time) || !CommonUtil.isYMDHMS(end_time))
                throw new IllegalArgumentException(" page info is illegal");
        Map<String,Integer> data= shopStatusStatisticsService.getShopStatusStatisticsHead(DateUtil.yMdHmsToDate(start_time),DateUtil.yMdHmsToDate(end_time));
        result.put("data",data.values());
        result.put("result",200);
        result.put("msg","ok");
        return result;
    }



}
