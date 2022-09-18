package org.fu.mybatisplus;

import org.fu.mybatisplus.pojo.User;
import org.fu.mybatisplus.service.api.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestService {

    @Autowired
    private UserService userService;


    /**
     * 统计表中数据的数量
     *  ==>  Preparing: SELECT COUNT( * ) FROM user
     */
    @Test
    public void test(){
        long count = userService.count();
        System.out.println(count);
    }




    @Test
    public void testInsertMore(){
        List<User> list = new ArrayList<>();
        for (int i = 9 ; i < 15 ; i++){
            User user = new User();
            user.setName("name_"+i);
            user.setAge(i);
            user.setEmail("email_"+i);
            user.setId((long)i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
