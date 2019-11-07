package com.paulzhangcc.shardingjdbc.dao.mapper;

import com.paulzhangcc.shardingjdbc.dao.DO.TConfig;
import com.paulzhangcc.shardingjdbc.dao.DO.TConfigExample;
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
public interface TConfigDAO {
    long countByExample(TConfigExample example);

    int deleteByExample(TConfigExample example);

    @Delete({
        "delete from t_config",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_config (id, `key`, ",
        "`value`, create_time)",
        "values (#{id,jdbcType=VARCHAR}, #{key,jdbcType=VARCHAR}, ",
        "#{value,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TConfig record);

    int insertSelective(TConfig record);

    List<TConfig> selectByExampleWithRowbounds(TConfigExample example, RowBounds rowBounds);

    List<TConfig> selectByExample(TConfigExample example);

    @Select({
        "select",
        "id, `key`, `value`, create_time",
        "from t_config",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("com.paulzhangcc.shardingjdbc.dao.mapper.TConfigDAO.BaseResultMap")
    TConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TConfig record, @Param("example") TConfigExample example);

    int updateByExample(@Param("record") TConfig record, @Param("example") TConfigExample example);

    int updateByPrimaryKeySelective(TConfig record);

    @Update({
        "update t_config",
        "set `key` = #{key,jdbcType=VARCHAR},",
          "`value` = #{value,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TConfig record);
}