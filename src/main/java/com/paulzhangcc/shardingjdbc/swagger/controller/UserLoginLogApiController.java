package com.paulzhangcc.shardingjdbc.swagger.controller;

import com.paulzhangcc.shardingjdbc.model.Result;
import com.paulzhangcc.shardingjdbc.model.ResultUtil;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * the userLoginLog API
 */

@RestController
public class UserLoginLogApiController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserLoginLogApiController.class);
    @Autowired
    private UserLoginLogApiBiz delegate;

    /**
     * 用户登录日志表添加
     */


    @RequestMapping(value = "/userLoginLog/add", method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody UserLoginLogVO userLoginLogVO) {
        return new ResultUtil<Boolean>().setData(delegate.add(userLoginLogVO));
    }

    /**
     * 用户登录日志表删除
     */


    @RequestMapping(value = "/userLoginLog/delete/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> deleteById(@PathVariable("id") String id) {
        return new ResultUtil<Boolean>().setData(delegate.deleteById(id));
    }

    /**
     * 批量删除
     */


    @RequestMapping(value = "/userLoginLog/deleteByIds", consumes = {"multipart/form-data"}, method = RequestMethod.POST)
    public Result<Boolean> deleteByIds(@RequestParam(value = "ids", required = true) String ids) {
        return new ResultUtil<Boolean>().setData(delegate.deleteByIds(ids));
    }

    /**
     * 用户登录日志表get
     */


    @RequestMapping(value = "/userLoginLog/get/{id}", method = RequestMethod.GET)
    public Result<UserLoginLogVO> get(@PathVariable("id") String id) {
        return new ResultUtil<UserLoginLogVO>().setData(delegate.get(id));
    }

    /**
     * 获取全部UserLoginLog数据
     */


    @RequestMapping(value = "/userLoginLog/list", method = RequestMethod.POST)
    public Result<UserLoginLogPage> list(@RequestBody UserLoginLogSearchVO userLoginLogSearchVO) {
        return new ResultUtil<UserLoginLogPage>().setData(delegate.list(userLoginLogSearchVO));
    }

    /**
     * 更新
     */


    @RequestMapping(value = "/userLoginLog/edit", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody UserLoginLogVO userLoginLogVO) {
        return new ResultUtil<Boolean>().setData(delegate.update(userLoginLogVO));
    }
}






