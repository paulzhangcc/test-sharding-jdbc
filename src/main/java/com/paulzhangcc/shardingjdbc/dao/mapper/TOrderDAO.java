package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.TOrder;
import com.paulzhangcc.shardingjdbc.dao.DO.TOrderExample;
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
public interface TOrderDAO {
    long countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    @Delete({
        "delete from t_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String orderId);

    @Insert({
        "insert into t_order (order_id, user_id, ",
        "content, create_time)",
        "values (#{orderId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExampleWithRowbounds(TOrderExample example, RowBounds rowBounds);

    List<TOrder> selectByExample(TOrderExample example);

    @Select({
        "select",
        "order_id, user_id, content, create_time",
        "from t_order",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.TOrderDAO.BaseResultMap")
    TOrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    @Update({
        "update t_order",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TOrder record);
}