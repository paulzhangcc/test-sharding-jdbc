package com.paulzhangcc.shardingjdbc.biz;

import com.paulzhangcc.shardingjdbc.dao.DO.UserLoginLog;
import com.paulzhangcc.shardingjdbc.dao.mapper.UserLoginLogDAO;
import com.paulzhangcc.shardingjdbc.swagger.controller.UserLoginLogApiBiz;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogPage;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogSearchVO;
import com.paulzhangcc.shardingjdbc.swagger.model.UserLoginLogVO;
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
public class UserLoginLogApiBizImpl implements UserLoginLogApiBiz {

    @Autowired
    UserLoginLogDAO userLoginLogDAO;
    @Override
    public Boolean add(UserLoginLogVO userLoginLogVO) {
        String uuid = SnowFlakeUtil.getFlowIdInstance().nextStringId();
        UserLoginLog insertUserLoginLog = UserLoginLog.builder().id(uuid).createTime(new Date()).userId(userLoginLogVO.getUserId()).build();
        userLoginLogDAO.insertSelective(insertUserLoginLog);
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
    public UserLoginLogVO get(String id) {
        return null;
    }

    @Override
    public UserLoginLogPage list(UserLoginLogSearchVO userLoginLogSearchVO) {
        return null;
    }

    @Override
    public Boolean update(UserLoginLogVO userLoginLogVO) {
        return null;
    }
}
