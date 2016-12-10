package com.yx.statistics.dao;

import com.yx.statistics.common.Mapper;
import com.yx.statistics.model.ConstantDictionary;
import com.yx.statistics.common.Page;
import com.yx.statistics.model.ShopActionStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2016/12/9.
 */
@SuppressWarnings("all")
@Mapper
public interface ShopActionStatusDao {

    List<ShopActionStatus> getShopActionsStatusByShopIds(List<Long> shopIds);


    List<Long> getShopIds(@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("page") Page page);



    List<ConstantDictionary> getConstantDictionarys();

    Integer getAllShopCnt(@Param("startTime") String startTime, @Param("endTime") String endTime);

    Integer getGiveMoneyShopCnt(@Param("startTime") String startTime, @Param("endTime") String endTime);

    Integer getStatusCompleteCnt(@Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Map<String, Object>> getPreShopActionsStatusByShopIds(List<Long> shopIds);

}
