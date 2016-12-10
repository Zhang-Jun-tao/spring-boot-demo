package com.yx.statistics.service;


import com.yx.statistics.common.Page;

import java.util.Date;
import java.util.Map;

/**
 * Created by zhang on 2016/12/9.
 */
public interface IShopStatusStatisticsService {

    Map<Long, Object> getShopStatusStatisticsList(Date startTime,Date endTime,Page page)throws Exception;


    Map<String,Integer> getShopStatusStatisticsHead(Date startTime, Date endTime);

}
