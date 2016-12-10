package com.yx.statistics.service.imp;

import com.yx.statistics.Util.CommonUtil;
import com.yx.statistics.Util.DateUtil;
import com.yx.statistics.dao.ShopActionStatusDao;
import com.yx.statistics.model.ConstantDictionary;
import com.yx.statistics.common.Page;
import com.yx.statistics.model.ShopActionStatus;
import com.yx.statistics.service.IShopStatusStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈泽鹏 on 2016/12/9.
 */
@SuppressWarnings("all")
@Service
public class ShopStatusStatisticsServiceImp implements IShopStatusStatisticsService {

    @Autowired
    private ShopActionStatusDao shopActionStatusDao;

    public Map<Long, Object> getShopStatusStatisticsList(Date startTime, Date endTime,Page page) throws Exception{
        List<ConstantDictionary> constantDictionarys=shopActionStatusDao.getConstantDictionarys();
        Assert.notEmpty(constantDictionarys,"constantDictionarys is null");
        Map<String, String> filedMap=new HashMap<String, String>();
        for (ConstantDictionary constantDictionary:constantDictionarys)
            filedMap.put(constantDictionary.getCode(),constantDictionary.getRelation_field_name());
        List<Long> shopIds= shopActionStatusDao.getShopIds(DateUtil.dateToyMdHms(startTime),DateUtil.dateToyMdHms(endTime),page);
        if (shopIds == null || shopIds.isEmpty() ) return null;
        List<ShopActionStatus> shopActionStatuss=shopActionStatusDao.getShopActionsStatusByShopIds(shopIds);
        if(shopActionStatuss ==null || shopActionStatuss.isEmpty()) return null;
        Map<Long, Object> data= new HashMap<Long, Object>();
        for (Long shopId:shopIds)
            data.put(shopId,new HashMap<String, Object>());
        for (ShopActionStatus statu :shopActionStatuss){
            Map<String, Object> statuMap=(Map<String, Object>)data.get(statu.getMerchant_id());
            statuMap.put(filedMap.get(statu.getAction_code()),statu.getStatus());
        }
        List<Map<String, Object>> list=shopActionStatusDao.getPreShopActionsStatusByShopIds(shopIds);
        for (Map<String, Object> map :list){
            String id=String.valueOf(map.get("id"));
            if(!CommonUtil.isNum(id))
                continue;
            Map<String, Object> statuMap=(Map<String, Object>)data.get(Long.parseLong(id));
            for (Map.Entry<String, Object> entry: map.entrySet())
                statuMap.put(entry.getKey(),entry.getValue());
        }
        return data;
    }


    public Map<String,Integer> getShopStatusStatisticsHead(Date startTime, Date endTime){
        Map<String,Integer> data=new HashMap<>();
        String startTimeStr=DateUtil.dateToyMdHms(startTime);
        String endTimeStr=DateUtil.dateToyMdHms(endTime);
        data.put("registration_cnt",shopActionStatusDao.getAllShopCnt(startTimeStr,endTimeStr));
        data.put("give_money_cnt",shopActionStatusDao.getGiveMoneyShopCnt(startTimeStr,endTimeStr));
        data.put("complete_cnt",shopActionStatusDao.getStatusCompleteCnt(startTimeStr,endTimeStr));
        return data;
    }

}
