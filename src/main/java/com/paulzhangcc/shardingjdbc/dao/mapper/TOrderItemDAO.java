package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.TOrderItem;
import com.paulzhangcc.shardingjdbc.dao.DO.TOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TOrderItemDAO {
    long countByExample(TOrderItemExample example);

    int deleteByExample(TOrderItemExample example);

    @Delete({
        "delete from t_order_item",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into t_order_item (order_id, user_id, ",
        "`desc`, create_time)",
        "values (#{orderId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{desc,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    List<TOrderItem> selectByExampleWithRowbounds(TOrderItemExample example, RowBounds rowBounds);

    List<TOrderItem> selectByExample(TOrderItemExample example);

    @Select({
        "select",
        "order_id, user_id, `desc`, create_time",
        "from t_order_item",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.TOrderItemDAO.BaseResultMap")
    TOrderItem selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByExample(@Param("record") TOrderItem record, @Param("example") TOrderItemExample example);

    int updateByPrimaryKeySelective(TOrderItem record);

    @Update({
        "update t_order_item",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TOrderItem record);
}