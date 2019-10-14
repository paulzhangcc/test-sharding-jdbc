package com.paulzhangcc.shardingjdbc.biz;

import com.paulzhangcc.shardingjdbc.dao.DO.User;
import com.paulzhangcc.shardingjdbc.dao.mapper.UserDAO;
import com.paulzhangcc.shardingjdbc.swagger.controller.UserApiBiz;
import com.paulzhangcc.shardingjdbc.swagger.model.UserPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserVO;
import com.paulzhangcc.shardingjdbc.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author paul
 * @description
 * @date 2019/10/12
 */
@Component
public class UserApiBizImpl implements UserApiBiz {
    @Autowired
    UserDAO userDAO;
    @Override
    public Boolean add(UserVO userVO) {
        String uuid = SnowFlakeUtil.getFlowIdInstance().nextStringId();
        User insertUser = User.builder().id(uuid).createTime(new Date()).mobile(userVO.getMobile()).username("M" + userVO.getMobile()).build();
        userDAO.insertSelective(insertUser);
        return true;
    }

    @Override
    public Boolean deleteById(String id) {
        return null;
    }

    @Override
    public Boolean deleteByIds(String ids) {
        return null;
    }

    @Override
    public UserVO get(String id) {
        return null;
    }

    @Override
    public UserPage list(UserSearchVO userSearchVO) {
        return null;
    }

    @Override
    public Boolean update(UserVO userVO) {
        return null;
    }
}
