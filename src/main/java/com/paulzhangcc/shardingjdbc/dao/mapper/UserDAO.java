package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.User;
import com.paulzhangcc.shardingjdbc.dao.DO.UserExample;
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
public interface UserDAO {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_user (id, mobile, ",
        "username, create_time)",
        "values (#{id,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, mobile, username, create_time",
        "from t_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.UserDAO.BaseResultMap")
    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update t_user",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}