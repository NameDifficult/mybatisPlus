package org.fu.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fu.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    @Select("select id,name,age,email from user where id = #{id}")
    Map<String,Object> selectMapById(Long id);


    /**
     * 通过年龄查询用户信息并分页
     * @param page
     * @param age
     * @return
     */
    @Select("select id,name,age,email from t_user where age > #{age}")
    Page<User> selectPageVo(@Param("page")Page<User> page,@Param("age")Integer age);
}
