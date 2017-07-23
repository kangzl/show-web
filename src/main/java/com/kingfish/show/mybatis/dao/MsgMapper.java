package com.kingfish.show.mybatis.dao;

import com.kingfish.show.mybatis.model.Msg;
import com.kingfish.show.mybatis.model.MsgExample;
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

public interface MsgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @SelectProvider(type=MsgSqlProvider.class, method="countByExample")
    long countByExample(MsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @DeleteProvider(type=MsgSqlProvider.class, method="deleteByExample")
    int deleteByExample(MsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @Delete({
        "delete from msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @Insert({
        "insert into msg (gmt_create, gmt_modify, ",
        "show_id, from_user_id, ",
        "to_user_id, content, ",
        "parent_msg_id, agree_num, ",
        "ip)",
        "values (#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{showId,jdbcType=BIGINT}, #{fromUserId,jdbcType=BIGINT}, ",
        "#{toUserId,jdbcType=BIGINT}, #{content,jdbcType=VARCHAR}, ",
        "#{parentMsgId,jdbcType=BIGINT}, #{agreeNum,jdbcType=INTEGER}, ",
        "#{ip,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @InsertProvider(type=MsgSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @SelectProvider(type=MsgSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="show_id", property="showId", jdbcType=JdbcType.BIGINT),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_msg_id", property="parentMsgId", jdbcType=JdbcType.BIGINT),
        @Result(column="agree_num", property="agreeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    List<Msg> selectByExample(MsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, gmt_create, gmt_modify, show_id, from_user_id, to_user_id, content, parent_msg_id, ",
        "agree_num, ip",
        "from msg",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="show_id", property="showId", jdbcType=JdbcType.BIGINT),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="to_user_id", property="toUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_msg_id", property="parentMsgId", jdbcType=JdbcType.BIGINT),
        @Result(column="agree_num", property="agreeNum", jdbcType=JdbcType.INTEGER),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR)
    })
    Msg selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MsgSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MsgSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Msg record, @Param("example") MsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @UpdateProvider(type=MsgSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Msg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table msg
     *
     * @mbg.generated
     */
    @Update({
        "update msg",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "show_id = #{showId,jdbcType=BIGINT},",
          "from_user_id = #{fromUserId,jdbcType=BIGINT},",
          "to_user_id = #{toUserId,jdbcType=BIGINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "parent_msg_id = #{parentMsgId,jdbcType=BIGINT},",
          "agree_num = #{agreeNum,jdbcType=INTEGER},",
          "ip = #{ip,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Msg record);
}