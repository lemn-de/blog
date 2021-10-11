package com.lemndo.blog.admin.base;



import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.SQLException;
import java.util.Collections;

/**
 * MybatisPlus代码生成器
 */
public class CodeGenerator {
    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
//        before();
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog", "root", "1832580")
                .globalConfig(builder -> {
                    builder.author("lemndo") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\My_Java\\blog\\blog-admin\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lemndo.blog.admin") // 设置父包名
//                            .moduleName("blog-admin")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\My_Java\\blog\\blog-admin\\src\\main\\resources\\com\\lemndo\\blog\\admin\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("ms_sys_user") // 设置需要生成的表名
                            .addTablePrefix("ms_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}

