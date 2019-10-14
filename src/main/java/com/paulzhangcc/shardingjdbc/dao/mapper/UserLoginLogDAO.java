package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.UserLoginLog;
import com.paulzhangcc.shardingjdbc.dao.DO.UserLoginLogExample;
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
public interface UserLoginLogDAO {
    long countByExample(UserLoginLogExample example);

    int deleteByExample(UserLoginLogExample example);

    @Delete({
        "delete from t_user_login_log",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_user_login_log (id, user_id, ",
        "create_time)",
        "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    List<UserLoginLog> selectByExampleWithRowbounds(UserLoginLogExample example, RowBounds rowBounds);

    List<UserLoginLog> selectByExample(UserLoginLogExample example);

    @Select({
        "select",
        "id, user_id, create_time",
        "from t_user_login_log",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.UserLoginLogDAO.BaseResultMap")
    UserLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    int updateByExample(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    int updateByPrimaryKeySelective(UserLoginLog record);

    @Update({
        "update t_user_login_log",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserLoginLog record);
}