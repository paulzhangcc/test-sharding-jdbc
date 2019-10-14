package com.paulzhangcc.shardingjdbc.swagger.controller;

import com.paulzhangcc.shardingjdbc.swagger.model.UserPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserVO;

/**
 *  the user API
 */
public interface UserApiBiz {
    /**
     *  用户表添加
     */
    Boolean add(UserVO userVO);
    /**
     *  用户表删除
     */
    Boolean deleteById(String id);
    /**
     *  批量删除
     */
    Boolean deleteByIds(String ids);
    /**
     *  用户表get
     */
    UserVO get(String id);
    /**
     *  获取全部User数据
     */
    UserPage list(UserSearchVO userSearchVO);
    /**
     *  更新
     */
    Boolean update(UserVO userVO);
}
