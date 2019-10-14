package com.paulzhangcc.shardingjdbc.swagger.controller;

import com.paulzhangcc.shardingjdbc.model.Result;
import com.paulzhangcc.shardingjdbc.model.ResultUtil;
import com.paulzhangcc.shardingjdbc.swagger.model.UserPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * the user API
 */

@RestController
public class UserApiController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserApiController.class);
    @Autowired
    private UserApiBiz delegate;

    /**
     * 用户表添加
     */


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Result<Boolean> add(@RequestBody UserVO userVO) {
        return new ResultUtil<Boolean>().setData(delegate.add(userVO));
    }

    /**
     * 用户表删除
     */


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> deleteById(@PathVariable("id") String id) {
        return new ResultUtil<Boolean>().setData(delegate.deleteById(id));
    }

    /**
     * 批量删除
     */


    @RequestMapping(value = "/user/deleteByIds", consumes = {"multipart/form-data"}, method = RequestMethod.POST)
    public Result<Boolean> deleteByIds(@RequestParam(value = "ids", required = true) String ids) {
        return new ResultUtil<Boolean>().setData(delegate.deleteByIds(ids));
    }

    /**
     * 用户表get
     */


    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public Result<UserVO> get(@PathVariable("id") String id) {
        return new ResultUtil<UserVO>().setData(delegate.get(id));
    }

    /**
     * 获取全部User数据
     */


    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    public Result<UserPage> list(@RequestBody UserSearchVO userSearchVO) {
        return new ResultUtil<UserPage>().setData(delegate.list(userSearchVO));
    }

    /**
     * 更新
     */


    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody UserVO userVO) {
        return new ResultUtil<Boolean>().setData(delegate.update(userVO));
    }
}






