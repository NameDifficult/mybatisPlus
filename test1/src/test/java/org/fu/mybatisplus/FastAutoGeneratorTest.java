package org.fu.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus?serverTimezone=Asia/Shanghai&useSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("atguigu") // 设置作者
                                    //.enableSwagger() // 开启 swagger 模式
                                    .fileOverride() // 覆盖已生成文件
                                    .outputDir("D://mybatisPlus1"); // 指定输出目录
                        })
                        .packageConfig(builder -> {
                            builder.parent("com.atguigu") // 设置父包名
                                    .moduleName("mybatisPlus") // 设置父包模块名
                                    // 设置mapperXml生成路径
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://mybatisPlus1"));
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("t_user") // 设置需要生成的表名
                                    .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker 引擎模板，默认的是Velocity引擎模板
                        .execute();
    }

}
