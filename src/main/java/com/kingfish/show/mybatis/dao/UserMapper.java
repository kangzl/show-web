package com.kingfish.show.mybatis.dao;

import com.kingfish.show.mybatis.model.User;
import com.kingfish.show.mybatis.model.UserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user (gmt_create, gmt_modify, ",
        "username, password, ",
        "nick_name, sex, header_pic_url, ",
        "signature, mobile_phone_number, ",
        "email, hide_nick_name)",
        "values (#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nickName,jdbcType=VARCHAR}, #{sex,jdbcType=TINYINT}, #{headerPicUrl,jdbcType=VARCHAR}, ",
        "#{signature,jdbcType=VARCHAR}, #{mobilePhoneNumber,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{hideNickName,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="header_pic_url", property="headerPicUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_phone_number", property="mobilePhoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="hide_nick_name", property="hideNickName", jdbcType=JdbcType.BIT)
    })
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, gmt_create, gmt_modify, username, password, nick_name, sex, header_pic_url, ",
        "signature, mobile_phone_number, email, hide_nick_name",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="header_pic_url", property="headerPicUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_phone_number", property="mobilePhoneNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="hide_nick_name", property="hideNickName", jdbcType=JdbcType.BIT)
    })

    @Cacheable
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    @Update({
        "update user",
        "set gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "header_pic_url = #{headerPicUrl,jdbcType=VARCHAR},",
          "signature = #{signature,jdbcType=VARCHAR},",
          "mobile_phone_number = #{mobilePhoneNumber,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "hide_nick_name = #{hideNickName,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}