package org.fu.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.fu.mybatisplus.mapper.UserMapper;
import org.fu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMain {
    @Autowired
    private UserMapper userMapper;


    /**
     * 添加数据
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("2212245373@qq.com");
        user.setId(1L);
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }


    /**
     * 根据实体ID删除数据
     */
    @Test
    public void testDeleteById(){
        int delete = userMapper.deleteById(1571394007449862145L);
        System.out.println(delete);
    }


    /**
     * 根据map删除数据
     * map里的为要删除的条件
     * 如：name=张三
     *    age = 23
     */
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        userMapper.deleteByMap(map);
    }


    /**
     * 根据ID批量删除
     *      DELETE FROM user WHERE id IN ( ? , ? , ? )
     */
    @Test
    public void testDeleteBatchIds(){
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println(i);
    }


    /**
     *  根据ID修改数据
     *  ==>  Preparing: UPDATE user SET name=?, age=? WHERE id=?
     */
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1L);
        user.setAge(22);
        user.setName("李四");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }




    /**
     * 查询所有数据
     */
    @Test
    public void selectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    /**
     * 根据ID查询数据
     * ==>  Preparing: SELECT id,name,age,email FROM user WHERE id=?
     */
    @Test
    public void selectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }


    /**
     * 根据ID集合批量查询
     * ==>  Preparing: SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
     */
    @Test
    public void selectByBatchIds(){
        List<Long> longs = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(longs);
        users.forEach(user -> System.out.println(user));
    }


    /**
     * 根据map中的条件查询
     * ==>  Preparing: SELECT id,name,age,email FROM user WHERE name = ? AND id = ?
     */
    @Test
    public void selectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1L);
        map.put("name","李四");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(user -> System.out.println(user));
    }


    /**
     * 根据ID查询
     * 返回值类型为map集合
     */
    @Test
    public void selectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
        System.out.println(map.get("age"));
    }


    /**
     *  使用wrapper进行复杂查询
     *  例：查询用户名包含a，年龄在20到30之间，邮箱信息不为null的用户信息
     *  ==>  Preparing: SELECT id,name,age,email FROM t_user
     *                  WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
     */
    @Test
    public void selectUserByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(user -> System.out.println(user));
    }




    /**
     *  复杂查询
     */
    @Test
    public void selectUserByWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //查询name中不包含a的
        //queryWrapper.notLike("name","a");


        //查询name中以a结尾的
        //queryWrapper.likeLeft("name","a");


        //查询name中以S开头的
        //queryWrapper.likeRight("name","S");


        //查询用户信息按照年龄降序排序，若年龄相同，则按照id升序排序
//        queryWrapper.orderByDesc("age")
//                .orderByAsc("id");

//        List<User> list = userMapper.selectList(queryWrapper);
//        list.forEach(user -> System.out.println(user));



        //删除邮箱地址为空的字段
        //queryWrapper.isNull("email");
        //int delete = userMapper.delete(queryWrapper);
        //System.out.println(delete);


        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        //条件间默认是and
/*        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User updateUser = new User();
        updateUser.setEmail("23232@qq.com");
        updateUser.setName("李明");
        int update = userMapper.update(updateUser, queryWrapper);*/



        //将用户名中包含有a并且（年龄大于20或者邮箱为null）的用户信息修改
        /*queryWrapper.like("name","a")
                .and(update -> update.gt("age",20)
                    .or()
                    .isNull("email"));*/


        //只查询想要的字段
        queryWrapper.select("name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(stringObjectMap -> System.out.println(stringObjectMap));

    }




















}
