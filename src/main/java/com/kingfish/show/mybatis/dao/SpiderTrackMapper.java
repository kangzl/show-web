package com.kingfish.show.mybatis.dao;

import com.kingfish.show.mybatis.model.SpiderTrack;
import com.kingfish.show.mybatis.model.SpiderTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpiderTrackMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @SelectProvider(type=SpiderTrackSqlProvider.class, method="countByExample")
    long countByExample(SpiderTrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @DeleteProvider(type=SpiderTrackSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpiderTrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @Delete({
        "delete from spider_track",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @Insert({
        "insert into spider_track (gmt_create, gmt_modify, ",
        "category_id, keyword, ",
        "last_time, num)",
        "values (#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{categoryId,jdbcType=BIGINT}, #{keyword,jdbcType=VARCHAR}, ",
        "#{lastTime,jdbcType=TIMESTAMP}, #{num,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SpiderTrack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @InsertProvider(type=SpiderTrackSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SpiderTrack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @SelectProvider(type=SpiderTrackSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="num", property="num", jdbcType=JdbcType.BIGINT)
    })
    List<SpiderTrack> selectByExample(SpiderTrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, gmt_create, gmt_modify, category_id, keyword, last_time, num",
        "from spider_track",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="keyword", property="keyword", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="num", property="num", jdbcType=JdbcType.BIGINT)
    })
    SpiderTrack selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SpiderTrackSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SpiderTrack record, @Param("example") SpiderTrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SpiderTrackSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SpiderTrack record, @Param("example") SpiderTrackExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @UpdateProvider(type=SpiderTrackSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpiderTrack record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table spider_track
     *
     * @mbg.generated
     */
    @Update({
        "update spider_track",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "category_id = #{categoryId,jdbcType=BIGINT},",
          "keyword = #{keyword,jdbcType=VARCHAR},",
          "last_time = #{lastTime,jdbcType=TIMESTAMP},",
          "num = #{num,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SpiderTrack record);
}