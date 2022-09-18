package org.fu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
//@TableName("t_user")
public class User {

    /**
     *  设置这个字段为数据库主键对应的字段
     *  value: 数据库主键名称
     *  type:  主键类型。 默认使用的是雪花算法随机生成的。
     *          如果要主键自动递增，则 1.数据库要设计主键自动递增  2. 然后type类型设置为IdType.AUTO
     *                            也可以在yml文件中配置 id-type: auto
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

//    @TableField("user_name")  //指定属性所对应的字段名
    private String name;

    private Integer age;

    private String email;


    /**
     *  需要@TableLogic注解
     *  逻辑删除，可以添加一个字段作为标记，数据库也要有对应的字段。当这个字段为
     *  0：表示未删除。
     *  1：已删除
     *  删除操作也会自动改为修改操作
     */
//    @TableLogic
//    private String isDelete;
}
