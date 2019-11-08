package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.TUserLoginLog;
import com.paulzhangcc.shardingjdbc.dao.DO.TUserLoginLogExample;
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
public interface TUserLoginLogDAO {
    long countByExample(TUserLoginLogExample example);

    int deleteByExample(TUserLoginLogExample example);

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
    int insert(TUserLoginLog record);

    int insertSelective(TUserLoginLog record);

    List<TUserLoginLog> selectByExampleWithRowbounds(TUserLoginLogExample example, RowBounds rowBounds);

    List<TUserLoginLog> selectByExample(TUserLoginLogExample example);

    @Select({
        "select",
        "id, user_id, create_time",
        "from t_user_login_log",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.TUserLoginLogDAO.BaseResultMap")
    TUserLoginLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUserLoginLog record, @Param("example") TUserLoginLogExample example);

    int updateByExample(@Param("record") TUserLoginLog record, @Param("example") TUserLoginLogExample example);

    int updateByPrimaryKeySelective(TUserLoginLog record);

    @Update({
        "update t_user_login_log",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TUserLoginLog record);
}