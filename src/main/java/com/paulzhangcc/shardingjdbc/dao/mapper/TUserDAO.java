package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.TUser;
import com.paulzhangcc.shardingjdbc.dao.DO.TUserExample;
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
public interface TUserDAO {
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_user (id, mobile, ",
        "create_time)",
        "values (#{id,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExampleWithRowbounds(TUserExample example, RowBounds rowBounds);

    List<TUser> selectByExample(TUserExample example);

    @Select({
        "select",
        "id, mobile, create_time",
        "from t_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.TUserDAO.BaseResultMap")
    TUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    @Update({
        "update t_user",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TUser record);
}