package org.fu.mybatisplus;

import org.fu.mybatisplus.enums.SexEnum;
import org.fu.mybatisplus.mapper.UserMapper;
import org.fu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEnums {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setName("小小");
        user.setEmail("234@qq.com");
        user.setAge(44);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
