package org.fu.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fu.mybatisplus.mapper.UserMapper;
import org.fu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class TestPage {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testPage(){
        //current：页码     size：每页大小
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        System.out.println(page.getPages());
    }



    @Test
    public void testPage2(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPageVo(page, 20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());

    }




}
