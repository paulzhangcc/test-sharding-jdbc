package com.paulzhangcc.shardingjdbc.swagger.controller;

import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogVO;

/**
 *  the userLoginLog API
 */
public interface UserLoginLogApiBiz {
    /**
     *  用户登录日志表添加
     */
    Boolean add(UserLoginLogVO userLoginLogVO);
    /**
     *  用户登录日志表删除
     */
    Boolean deleteById(String id);
    /**
     *  批量删除
     */
    Boolean deleteByIds(String ids);
    /**
     *  用户登录日志表get
     */
    UserLoginLogVO get(String id);
    /**
     *  获取全部UserLoginLog数据
     */
    UserLoginLogPage list(UserLoginLogSearchVO userLoginLogSearchVO);
    /**
     *  更新
     */
    Boolean update(UserLoginLogVO userLoginLogVO);
}
