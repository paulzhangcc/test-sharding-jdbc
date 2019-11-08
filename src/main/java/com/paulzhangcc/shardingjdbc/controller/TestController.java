package com.paulzhangcc.shardingjdbc.controller;

import com.alibaba.fastjson.JSON;
import com.paulzhangcc.shardingjdbc.dao.DO.TOrder;
import com.paulzhangcc.shardingjdbc.dao.DO.TOrderItem;
import com.paulzhangcc.shardingjdbc.dao.DO.TUserLoginLog;
import com.paulzhangcc.shardingjdbc.dao.mapper.TOrderDAO;
import com.paulzhangcc.shardingjdbc.dao.mapper.TOrderItemDAO;
import com.paulzhangcc.shardingjdbc.dao.mapper.TUserLoginLogDAO;
import com.paulzhangcc.shardingjdbc.dao.mapper.SelectDAO;
import com.paulzhangcc.shardingjdbc.model.Result;
import com.paulzhangcc.shardingjdbc.model.ResultUtil;
import com.paulzhangcc.shardingjdbc.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * the user API
 */

@RestController
public class TestController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TOrderDAO tOrderDAO;
    @Autowired
    private TOrderItemDAO tOrderItemDAO;


    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public Result<Boolean> orderAdd(@RequestParam String userId, @RequestParam(required = false) String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            orderId = SnowFlakeUtil.getFlowIdInstance().nextStringId();
        }
        Map<String, String> data = new HashMap<>();
        data.put("userId", userId);
        data.put("orderId", orderId);
        String dataStr = JSON.toJSONString(data);
        TOrder tOrder = TOrder.builder().orderId(orderId).userId(userId).createTime(new Date()).content(dataStr).build();
        TOrderItem tOrderItem = TOrderItem.builder().orderId(orderId).userId(userId).createTime(new Date()).title(dataStr).build();
        tOrderDAO.insertSelective(tOrder);
        tOrderItemDAO.insertSelective(tOrderItem);
        return new ResultUtil<Boolean>().setData(Boolean.TRUE);
    }

    @Autowired
    TUserLoginLogDAO tUserLoginLogDAO;

    @RequestMapping(value = "/userLoginLog/add", method = RequestMethod.GET)
    public Result<Boolean> userLoginLogAdd(@RequestParam String userId) {

        TUserLoginLog userLoginLog = TUserLoginLog.builder().id(SnowFlakeUtil.getFlowIdInstance().nextStringId()).userId(userId).createTime(new Date()).build();
        tUserLoginLogDAO.insertSelective(userLoginLog);
        return new ResultUtil<Boolean>().setData(Boolean.TRUE);
    }

    @Autowired
    SelectDAO selectDAO;

    @RequestMapping(value = "/userLoginLog/list", method = RequestMethod.GET)
    public Result<Object> userLoginLogList() {
        return new ResultUtil<Object>().setData(selectDAO.selectUserAndUserLoginlogAll());
    }

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public Result<Object> orderList() {
        return new ResultUtil<Object>().setData(selectDAO.selectOrderAll());
    }


}






