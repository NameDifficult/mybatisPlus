package org.fu.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
