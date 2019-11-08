package com.paulzhangcc.shardingjdbc.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author paul
 * @description
 * @date 2019/11/8
 */
@Mapper
public interface SelectDAO {

    @Select({
            "select t_user.*,t_user_login_log.* from t_user ,t_user_login_log where  t_user.id = t_user_login_log.user_id"
    })
    List<Map<String, Object>> selectUserAndUserLoginlogAll();

    @Select({
            "select t_order.*,t_order_item.* from t_order,t_order_item where t_order.order_id = t_order_item.order_id"
    })
    List<Map<String, Object>> selectOrderAll();
}
